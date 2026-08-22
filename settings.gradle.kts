pluginManagement {

    // don't uncomment the statements below and especially - the line 'mavenCentral' due to https://github.com/renovatebot/renovate/discussions/43146#discussioncomment-16917760
    // repositories {
    //     gradlePluginPortal()
    //     mavenCentral()  <<<<<<<<<<<< strictly don't include this
    // }
    resolutionStrategy.eachPlugin {
        if (requested.id.namespace == "org.jetbrains.kotlin" ||
                requested.id.namespace.orEmpty().startsWith("org.jetbrains.kotlin.")) {
            useVersion(embeddedKotlinVersion)
        }
    }
}

@Suppress("UnstableApiUsage")
dependencyResolutionManagement {
    repositories {
        mavenCentral()
    }
}

rootProject.name = "gradle-plugin-utils-parent"

include(
    "bom",
    "gradle-plugin-integration-test-utils",
    "gradle-plugin-test-utils",
    "gradle-plugin-utils"
)
