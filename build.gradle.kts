@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.kotlin.jvm)
    `java-gradle-plugin`
    `kotlin-dsl`
    `maven-publish`
    id("com.gradle.plugin-publish") version "1.0.0-rc-1"
//    signing
}

group = "com.lounres.gradle.feature"
version = "1.0.0"

description = "Build tools for kotlin for science projects"

repositories {
    mavenCentral()
    gradlePluginPortal()
    maven("https://repo.kotlin.link")
}

java.targetCompatibility = JavaVersion.VERSION_11

kotlin {
    explicitApiWarning()

    target.compilations.all {
        kotlinOptions {
            jvmTarget = "11"
        }
    }

    sourceSets {
        main {
            dependencies {
            }
        }
        test {
            dependencies {
                implementation(kotlin("test"))
            }
        }
    }
}

tasks.test {
    useJUnitPlatform()
}

gradlePlugin {
    plugins {
        create("feature") {
            id = "com.lounres.gradle.feature"
            displayName = "Feature structuring plugin"
            description = "Settings plugin for flexible multi-module project configuration"
            implementationClass = "com.lounres.gradle.feature.FeatureSettingsPlugin"
        }
    }
}

pluginBundle {
    website = ""
}