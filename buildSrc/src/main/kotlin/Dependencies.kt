object Dependencies {
    const val PAPER_MC = "io.papermc.paper:paper-api:1.20.2-R0.1-SNAPSHOT"
    const val SHADOW_JAR = "${ShadowJar.ARTIFACT}:${ShadowJar.VERSION}"

    object ShadowJar {
        const val VERSION = "8.1.1"
        const val ARTIFACT = "com.github.johnrengelman:shadow"
    }
}