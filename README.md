# ParaTask - Java Parallel Task Manager
## About
ParaTask is designed to be used in java game servers such as Minecraft Servers. ParaTask lets you dispatch tasks that
can be considered "safe to run beside each other while main thread is suspended", that normally would not be safe if
the main thread was not suspended.

Examples can be:
  * Serializing all online player data 
  * Serializing current state of world data
  * Triggering write operations that has no chance of interfering with the write operation of another async operation
    * Updating the light data of a chunk
    * Generating content for a chunk
    
ParaTask will also help provide a framework for a server to delay a task until the server tick loop enters the
sleeping phase, letting the work be executed during the servers slack time.

These operations will all occur while the main thread is suspended, so as long as 2 parallel operations
do not impede on each others work, thread safety should be maintained. It is up to the implementor of
ParaTask to ensure that they do not enqueue work that can cross context and step on each other.

## Usage

ParaTask has not been released yet. Early development and usage will be for [PaperMC](https://papergit.emc.gs)
Once the API has been stabilized, it will be ready for public use.

 - REPO: `https://repo.aikar.co/content/groups/aikar/`
 - GROUP: `co.aikar`
 - ARTIFACT: `paratask`
 - VERSION `0.1.0-SNAPSHOT`


## Contributing
See Issues section. 

Join [#aikar on Spigot IRC - irc.spi.gt](https://aikarchat.emc.gs) to discuss. 

Or [Code With Aikar](https://aikardiscord.emc.gs) Discord.

## Other projects by Aikar / Empire Minecraft
 - [ACF](https://acf.emc.gs) - Annotation Command Framework - Extremely Powerful Java Command Dispatch Framework
 - [TaskChain](https://taskchain.emc.gs) - Powerful context control to dispatch tasks Async, then access the result sync for API usage. Concurrency controls too.
 - [IDB](https://idb.emc.gs) - Simple and Intuitive JDBC Wrapper for Java
 - [Minecraft Timings](https://github.com/aikar/minecraft-timings/) - Add Timings to your plugin in a safe way that works on all Bukkit platforms (CraftBukkit - no timings, Spigot - Timings v1, Paper and Paper forks - Timings v2)

## Say Thanks
If this library has helped you, please consider donating as a way of saying thanks

[![PayPal Donate](https://aikar.co/donate.png "Donate with PayPal")](https://paypal.me/empireminecraft)

## License
ParaTask (c) Daniel Ennis (Aikar) 2018.

ParaTask is licensed [MIT](https://tldrlegal.com/license/mit-license). See [LICENSE](LICENSE)


