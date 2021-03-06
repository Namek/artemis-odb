package com.artemis;

import java.util.BitSet;

import com.artemis.utils.Bag;

public final class EntityEditPool {
	
	private final Bag<EntityEdit> pool = new Bag<EntityEdit>();
	private final World world;
	
	private WildBag<EntityEdit> edited;
	private WildBag<EntityEdit> alternateEdited;
	private final BitSet editedIds;
	
	EntityEditPool(World world) {
		this.world = world;
		
		edited = new WildBag<EntityEdit>();
		alternateEdited = new WildBag<EntityEdit>();
		editedIds = new BitSet();
	}
	
	boolean isEdited(Entity e) {
		return editedIds.get(e.getId());
	}
	

	EntityEdit obtainEditor(Entity entity) {
		EntityEdit edit;
		if (editedIds.get(entity.getId())) {
			edit = findEntityEdit(entity);
		} else {
			if (pool.isEmpty()) {
				edit = new EntityEdit(world);
			} else {
				edit = pool.removeLast();
				edit.componentBits.clear();
				edit.scheduledDeletion = false;
			}
			editedIds.set(entity.getId());
			edited.add(edit);
		}
		
		edit.entity = entity;
		edit.hasBeenAddedToWorld = world.getEntityManager().isActive(entity.getId());
		if (edit.hasBeenAddedToWorld) {
			// TODO: ps. test this shit....
			BitSet bits = entity.getComponentBits();
			edit.componentBits.or(bits);
		}
		return edit;
	}
	
	private EntityEdit findEntityEdit(Entity entity) {
		// Since it's quite likely that already edited entities are called
		// repeatedly within the same scope, we start by first checking the last
		// element, before checking the rest.
		int last = edited.size() - 1;
		if (edited.get(last).entity == entity)
			return edited.get(last);
		
		Object[] data = edited.getData();
		for (int i = 0; last > i; i++) {
			EntityEdit edit = (EntityEdit)data[i];
			if (edit.entity == entity)
				return edit;
		}
		
		throw new RuntimeException();
	}

	boolean processEntities() {
		int size = edited.size();
		if (size == 0)
			return false;
		
		Object[] data = edited.getData();
		editedIds.clear();
		edited.setSize(0);
		swapEditBags();
		
		World w = world;
		EntityManager em = w.getEntityManager();
		for (int i = 0; size > i; i++) {
			EntityEdit edit = (EntityEdit)data[i];
			em.updateCompositionIdentity(edit);
			if (edit.scheduledDeletion) {
				w.deleted.add(edit.entity);
			} else if (edit.hasBeenAddedToWorld) {
				w.changed.add(edit.entity);
			} else {
				w.added.add(edit.entity);
			}
			
			pool.add(edit);
		}
		
		return true;
	}

	private void swapEditBags() {
		WildBag<EntityEdit> tmp = edited;
		edited = alternateEdited;
		alternateEdited = tmp;
	}
}
