plugins {
    id("java")
    id("maven-publish")
}

group = "cat.breadcat"
version = "1.4.0"

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