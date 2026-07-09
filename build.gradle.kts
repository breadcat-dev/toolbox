plugins {
    id("java")
    id("maven-publish")
}

group = "cat.breadcat"
version = "2.2.0"

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