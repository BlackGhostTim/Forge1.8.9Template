plugins {
    java
    id("net.minecraftforge.gradle") version "2.1.2"
}

group = "com.yourname.modid"
version = "1.0"
base.archivesBaseName = "YourModName"

// Настройка совместимости с Java 8 (обязательно для 1.8.9)
java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

minecraft {
    version = "1.8.9-11.15.1.2318-1.8.9"
    mappings = "stable_20"
    runDir = "run"
    
    // Настройка замены токенов в исходниках
    replace("@VERSION@", project.version)
    replace("@MC_VERSION@", "1.8.9")
}

repositories {
    mavenCentral()
}

dependencies {
    // Пример добавления других зависимостей
    // testImplementation("junit:junit:4.13.2")
}

// Настройка процесса сборки
tasks.processResources {
    inputs.property("version", project.version)
    inputs.property("mcversion", "1.8.9")

    filesMatching("mcmod.info") {
        expand(
            "version" to project.version,
            "mcversion" to "1.8.9",
            "modid" to base.archivesBaseName
        )
    }
}

// Настройка JAR-файла
tasks.jar {
    manifest {
        attributes(
            "FMLCorePlugin" to "com.yourname.modid.core.YourCoreModClass",
            "FMLCorePluginContainsFMLMod" to "true",
            "ForceLoadAsMod" to "true"
        )
    }
    
    // Добавление лицензии (опционально)
    from("LICENSE") {
        rename { "${it}_${base.archivesBaseName}" }
    }

    // Указание appendix для имени файла
    archiveAppendix.set("")
}

// Настройка кодировки
tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

// Настройка репозиториев для Forge
repositories {
    maven {
        name = "forge"
        url = uri("https://files.minecraftforge.net/maven")
    }
}
