pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()

    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }

}

rootProject.name = "NoteBookKmm"
include(":androidApp")
include(":shared")