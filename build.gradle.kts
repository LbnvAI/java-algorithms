plugins {
    id("java")
    id("io.freefair.lombok") version "8.4"
    application
}

application {
    mainClass = "org.anton.Main"
    tasks.withType<Jar> {
        manifest {
            attributes["Main-Class"] = mainClass
        }
    }
}

group = "org.anton"
version = "1"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    // Apache:common-lang3
    implementation("org.apache.commons:commons-lang3:3.14.0")
    // Apache:common-collections4
    implementation("org.apache.commons:commons-collections4:4.5.0-M2")
}

tasks.test {
    useJUnitPlatform()
}