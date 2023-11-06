# 🏗️ Base project for PaperMC plugin
This project is configured for use with Java and Kotlin. The code is written in a way that allows it to be built with
Gradle.

## Configuration ⚙️
All build scripts use Kotlin scripts (.kts) to simplify the writing of more complex build scenarios in a familiar style.
To declare project dependencies, the
[Gradle buildSrc feature](https://docs.gradle.org/current/userguide/organizing_gradle_projects.html#sec:build_sources)
is utilized. This feature enables the declaration of constants and the writing of some logic using Kotlin code in
separate files.
It is particularly useful for multi-module projects where build logic needs to be shared.

### Build project 🛠️
To build the plugin, execute the following command in the terminal from the project's root directory
```
./gradlew build
```
After a successful build, two files will be created in the [`build/libs`](build/libs) directory:
* `papermc-plguin-template-1.0.0.jar`: A jar file without external dependencies.
* `papermc-plguin-template-1.0.0-all.jar`: A jar file containing all project dependencies.

Running the `papermc-plguin-template-1.0.0.jar` with plain Kotlin (without external dependencies)
may lead to exceptions like `ClassNotFoundException` after running the server, and the plugin may not start. 
This is because Kotlin:
1. Has its own [standard library](https://kotlinlang.org/api/latest/jvm/stdlib/)
2. Translates certain language expressions (like [safe calls](https://kotlinlang.org/docs/null-safety.html#safe-calls))
   into code that uses internal Kotlin APIs

Unfortunately, PaperMC only uses Java code and is not aware of Kotlin. To avoid the described problems, 
you should use the `papermc-plguin-template-1.0.0-all.jar`,
which includes all the necessary code for running Kotlin code.

### Declaring dependencies 📜
In the [`buildSrc`](buildSrc) directory, various objects are declared to manage project dependencies and configurations:
* [`Dependencies`](buildSrc/src/main/kotlin/Dependencies.kt): This file contains dependencies and their respective
  versions used in different modules of the project
* [`Plugins`](buildSrc/src/main/kotlin/Plugins.kt): Here, you can find a list of plugins used across various modules
* [`Project`](buildSrc/src/main/kotlin/Project.kt): This file encompasses project-level configuration settings such as
  the Java version, Kotlin version, and more
* [`Repositories`](buildSrc/src/main/kotlin/Repositories.kt): This file provides essential information for declaring
  repositories used to download project dependencies.

These declared objects are essential components that can be easily modified or extended to accommodate new dependencies
or configurations. Furthermore, you have the flexibility to extract and organize build logic in separate files within
the buildSrc directory, allowing you to customize and manage the build process as needed.

### Including dependencies 📦
To include project dependencies in the final output file, we utilize the
[Gradle Shadow Plugin](https://imperceptiblethoughts.com/shadow/), which can be configured using the
[`shadowJar`](https://imperceptiblethoughts.com/shadow/configuration/#configuring-shadow) closure in your
[`build.gradle.kts`](build.gradle.kts) file. This plugin is helpful for creating a single, self-contained jar file with
all the necessary dependencies.

You can configure the `shadowJar` task like this:
```
tasks {
    ...
    shadowJar {
        archiveBaseName.set("my_plugin")
        archiveClassifier.set("shadow")
        archiveVersion.set(Project.VERSION)
    }
    ...
}
```
For more detailed information about configuring the shadow jar, you can refer to its official documentation.
