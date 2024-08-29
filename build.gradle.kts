plugins {
    kotlin("jvm") version "2.0.10"
}

group = "com.github.inventoryjam"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://maven.radsteve.net/public")
}

dependencies {
    implementation("net.radstevee.packed:packed-core:0.5.0")
    implementation("org.apache.commons:commons-lang3:3.0")
    implementation("org.apache.logging.log4j:log4j-api:2.23.1")
    implementation("org.apache.logging.log4j:log4j-core:2.23.1")
    implementation("org.apache.logging.log4j:log4j-slf4j2-impl:2.23.1")
}

kotlin {
    jvmToolchain(21)
}