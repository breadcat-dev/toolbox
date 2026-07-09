plugins {
    id("java")
    id("maven-publish")
}

group = "cat.breadcat"
version = "2.2.1"

repositories {
    mavenCentral()
    mavenLocal()
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])

            artifactId = rootProject.name;
        }
    }
}