
plugins {
    `java-library`
    id("com.github.johnrengelman.shadow") version "5.1.0"
}
repositories {
    mavenLocal()
    maven("https://repo.spongepowered.org/maven")
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshoits")
    maven("https://repo.codemc.org/repository/maven-public")
    maven("https://maven.sk89q.com/repo")
    maven("https://mvnrepository.com/artifact/org.jetbrains/annotations")
}

tasks {
    withType(JavaCompile::class.java) {
        options.encoding = "UTF-8"
    }

    shadowJar {
        dependencies {
            include(dependency("org.spongepowered:configurate-yaml"))
            include(dependency("org.spongepowered:configurate-hocon"))
            include(dependency("org.spongepowered:configurate-core"))
            include(dependency("org.bstats:bstats-bukkit"))
            include(dependency("org.apache.tomcat:tomcat-jdbc"))
            include(dependency("org.apache.tomcat:tomcat-juli"))
            include(dependency("com.typesafe:config"))
            exclude(dependency("org.spigotmc:spigot"))
        }
        relocate("org.apache.commons.logging", "com.gmail.nossr50.commons.logging")
        relocate("org.apache.juli", "com.gmail.nossr50.database.tomcat.juli")
        relocate("org.apache.tomcat", "com.gmail.nossr50.database.tomcat")
        relocate("org.bstats", "com.gmail.nossr50.metrics.bstat")
    }
}

java {
    targetCompatibility = JavaVersion.VERSION_1_8
    sourceCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
    api("org.apache.tomcat:tomcat-jdbc:7.0.52")
    api("com.typesafe:config:1.3.2")
    api("org.spongepowered:configurate-core:3.7-SNAPSHOT")
    api("org.spongepowered:configurate-yaml:3.7-SNAPSHOT")
    api("org.spongepowered:configurate-hocon:3.7-SNAPSHOT")
    implementation("org.jetbrains:annotations:17.0.0")
    implementation("org.apache.maven.scm:maven-scm-provider-gitexe:1.8.1")
    implementation("org.bstats:bstats-bukkit:1.4")
    implementation("org.spigotmc:spigot:1.14.4-R0.1-SNAPSHOT")
    implementation("com.sk89q.worldguard:worldguard-legacy:7.0.0-SNAPSHOT")
    testImplementation("junit:junit:4.10")
}


