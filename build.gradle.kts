import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    kotlin("jvm") version "1.3.50"
    id("com.github.johnrengelman.shadow") version "5.1.0"
}

group = "org.emgen.crypto.caesar"
version = "1.0.0"


repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
}

val fatJar = tasks.withType<ShadowJar> {
    classifier = "FINAL"
    manifest {
        attributes["Main-Class"] = "org.emgen.crypto.caesar.ApplicationKt"
    }
}

tasks {
    "build" {
        dependsOn(fatJar)
    }
}