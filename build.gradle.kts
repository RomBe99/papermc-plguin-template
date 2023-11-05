import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    repositories {
        gradlePluginPortal()
    }

    dependencies {
        classpath(Dependencies.SHADOW_JAR)
    }
}

plugins {
    kotlin(Plugins.KOTLIN_TARGET) version Project.Kotlin.VERSION
    id(Plugins.SHADOW_JAR) version Dependencies.ShadowJar.VERSION
}

group = Project.GROUP
version = Project.VERSION

repositories {
    mavenCentral()

    maven {
        name = Repositories.PaperMcMaven.NAME
        url = uri(path = Repositories.PaperMcMaven.URI_PATH)
    }
}

dependencies {
    implementation(Dependencies.PAPER_MC)
}

java {
    sourceCompatibility = Project.Java.SOURCE_COMPATIBILITY
    targetCompatibility = Project.Java.TARGET_COMPATIBILITY
}

tasks.withType<JavaCompile> {
    options.encoding = Charsets.UTF_8.toString()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = Project.Java.TARGET_COMPATIBILITY.toString()
}

tasks.processResources {
    val props = mapOf("version" to version)

    inputs.properties(props)
    filteringCharset = Charsets.UTF_8.toString()
    filesMatching("plugin.yml") {
        expand(props)
    }
}

tasks {
    build {
        dependsOn(shadowJar)
    }
}
