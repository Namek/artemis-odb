## Artemis-odb

[Artemis-odb](https://github.com/junkdog/artemis-odb/wiki/About) is a [high performance](https://github.com/junkdog/entity-system-benchmarks) java based [Entity-Component-System](https://github.com/junkdog/artemis-odb/wiki/Introduction-to-Entity-Systems) framework.

It is actively maintained, and a continuation of the popular [Artemis](http://gamadu.com/artemis/).

### Highlights
- Full GWT support.
- High performance, GC-friendly, [less boilerplate](https://github.com/junkdog/artemis-odb/wiki/@Wire)!
- [packed](https://github.com/junkdog/artemis-odb/wiki/Packed-Weaver) and [pooled](https://github.com/junkdog/artemis-odb/wiki/@PooledWeaver) components, [optimized systems](https://github.com/junkdog/artemis-odb/wiki/Optimizing-Entity-Systems), leveraged by [bytecode injection](https://github.com/junkdog/artemis-odb/wiki/Bytecode weaving).
- Convenient [dependency matrices](https://github.com/junkdog/artemis-odb/wiki/Component Dependency Matrix) for your components and systems.

_For more details, see [CHANGELOG.md](https://github.com/junkdog/artemis-odb/blob/master/CHANGELOG.md)_

### Benchmarks
Artemis-ODB is one of the fastest incarnations of Artemis. 

Operations/second. Higher is better.<br/>
Empty bars indicate missing benchmarks (Ashley 1.2.0 insert/remove).
![it16k][it16k] ![ir16k][ir16k]

See [entity-system-benchmarks](https://github.com/junkdog/entity-system-benchmarks) for more benchmarks.
Don't take our word for it, run the benchmarks yourself!

 [it1k]: http://junkdog.github.io/images/ecs-bench/iteration-1024.png
 [it4k]: http://junkdog.github.io/images/ecs-bench/iteration-4096.png
 [it16k]: http://junkdog.github.io/images/ecs-bench/iteration-16384.png
 [it65k]: http://junkdog.github.io/images/ecs-bench/iteration-65536.png
 [ir1k]: http://junkdog.github.io/images/ecs-bench/insert_remove-1024.png
 [ir4k]: http://junkdog.github.io/images/ecs-bench/insert_remove-4096.png
 [ir16k]: http://junkdog.github.io/images/ecs-bench/insert_remove-16384.png
 [ir65k]: http://junkdog.github.io/images/ecs-bench/insert_remove-65536.png 

### Made with artemis-odb

#### Commercial games

- [Dog Sled Saga](http://www.dogsledsaga.com/), upcoming "desktop and mobile racing game with a saga of rank climbing, reputation building, team management, and pet loving".
  - [Polygon piece on Dog Sled Saga](http://www.polygon.com/2013/5/22/4344100/dog-sled-saga).
  
#### Open source games
| game                          | source/binaries                      | [matrix][cdm]     | author                         |
|-------------------------------|--------------------------------------|-------------------|--------------------------------|
| [Arktrail][ark]               | [source][ark-src] [play][ark-play]   | N/A               | [@DaanVanYperen][dvy]          |
| [Sine][sine]                  | [source][sine-src]                   | [cdm][sine-cdm]   | [@timtipgames][sine-auth]      |
| Spaceship Warrior Redux       | [source][sw-src] [play][sw-play]     | [cdm][sw-cdm]     | updated by [@Flet][flet]       |
| [Ned et les Maki][ned]        | [source][ned-src]                    | N/A               | [Geeky Gobling Prod][ned-auth] |
| [Naturally Selected 2D][ns2d] | [source][ns2d-src] [play][ns2d-play] | [cdm][ns2d-cdm]   | [@DaanVanYperen][dvy]          |
| [The Underkeep][tu]           | [source][tu-src] [play][tu-play]     | [cdm][tu-cdm]     | [@DaanVanYperen][dvy]          |

 [ark]: http://www.ludumdare.com/compo/ludum-dare-30/?action=preview&uid=22396
 [ark-src]: https://github.com/DaanVanYperen/arktrail
 [ark-play]: http://www.mostlyoriginal.net/play-arktrail/
 [cdm]: https://github.com/junkdog/artemis-odb/wiki/Component-Dependency-Matrix
 [cli]: https://github.com/junkdog/artemis-odb/wiki/Command-Line-Tool
 [sine]: http://www.ludumdare.com/compo/ludum-dare-27/?action=preview&uid=15341
 [sine-src]: https://dl.dropboxusercontent.com/u/3057562/sine/sine-src.jar
 [sine-cdm]: http://junkdog.github.io/matrix-sine.html
 [sine-auth]: http://twitter.com/timtipgames
 [ned]: http://devnewton.bci.im/en/games/nedetlesmaki
 [ned-src]: https://github.com/devnewton/nedetlesmaki
 [ned-auth]: http://geekygoblin.org/
 [ns2d]: http://www.ludumdare.com/compo/minild-50/?action=preview&uid=22396
 [ns2d-src]: https://github.com/DaanVanYperen/naturally-selected-2d
 [ns2d-play]: http://ludum.mostlyoriginal.net/game/ns2d/
 [ns2d-cdm]: http://junkdog.github.io/matrix-ns2d.html
 [tu]: http://www.ludumdare.com/compo/ludum-dare-29/?action=preview&uid=22396
 [tu-src]: https://github.com/DaanVanYperen/underkeep
 [tu-play]: http://www.mostlyoriginal.net/play-underkeep/
 [tu-cdm]: http://junkdog.github.io/matrix-tu.html
 [dvy]: https://github.com/DaanVanYperen
 [sw-src]: https://github.com/Flet/spasceship-warrior-gradle
 [sw-play]: http://flet.github.io/spaceship-warrior-redux/
 [sw-cdm]: http://junkdog.github.io/matrix-sw.html
 [flet]: https://github.com/Flet/ 

### Dependency Matrix

Generate dependency matrix of your existing systems, managers and components.

[![Shaman's Weirding Game: Component Dependency Matrix](https://raw.githubusercontent.com/wiki/junkdog/artemis-odb/images/cdm.png)](http://junkdog.github.io/matrix.html)

### Getting started

#### Discussion/Forum

There's a google group at https://groups.google.com/forum/#!forum/artemis-odb - in addition to the issues, where hitherto much of the discussion has taken place. The original artemis forum is still around too, though it doesn't see much traffic, nor is it specific to artemis-odb: http://slick.ninjacave.com/forum/viewforum.php?f=28

#### Maven
```xml
<dependency>
	<groupId>net.onedaybeard.artemis</groupId>
	<artifactId>artemis-odb</artifactId>
	<version>0.7.1</version>
</dependency>
```

See [weave automation](https://github.com/junkdog/artemis-odb/wiki/Weave-Automation) and [module overview](https://github.com/junkdog/artemis-odb/wiki/Module-Overview)

#### Gradle
```groovy
  dependencies { compile "net.onedaybeard.artemis:artemis-odb:0.7.1" }
```

#### Manual Download

 - [Main library](http://repo1.maven.org/maven2/net/onedaybeard/artemis/artemis-odb/0.7.0/) 
 - [Command-line tool](http://repo1.maven.org/maven2/net/onedaybeard/artemis/artemis-odb-cli/0.7.0/)

