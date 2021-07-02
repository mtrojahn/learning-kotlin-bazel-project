####################################
### KOTLIN RELATED CONFIGURATION ###
####################################

load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")

# using 1.5 rules
rules_kotlin_version = "v1.5.0-alpha-3"

# but not the 1.5 compiler
kotlin_compiler_version = "1.4.32"

http_archive(
    name = "io_bazel_rules_kotlin",
    urls = ["https://github.com/bazelbuild/rules_kotlin/releases/download/%s/rules_kotlin_release.tgz" % rules_kotlin_version],
)

load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kotlin_repositories", "kt_compiler_plugin", "kt_register_toolchains")

KOTLIN_COMPILER_RELEASE = {
    "urls": [
        "https://github.com/JetBrains/kotlin/releases/download/v%s/kotlin-compiler-%s.zip" %
        (kotlin_compiler_version, kotlin_compiler_version),
    ],
    "sha256": "dfef23bb86bd5f36166d4ec1267c8de53b3827c446d54e82322c6b6daad3594c",
}

kotlin_repositories(compiler_release = KOTLIN_COMPILER_RELEASE)

register_toolchains("//:kotlin_toolchain")

###################################
### MAVEN RELATED CONFIGURATION ###
###################################

RULES_JVM_EXTERNAL_TAG = "2.8"

RULES_JVM_EXTERNAL_SHA = "79c9850690d7614ecdb72d68394f994fef7534b292c4867ce5e7dec0aa7bdfad"

http_archive(
    name = "rules_jvm_external",
    sha256 = RULES_JVM_EXTERNAL_SHA,
    strip_prefix = "rules_jvm_external-%s" % RULES_JVM_EXTERNAL_TAG,
    url = "https://github.com/bazelbuild/rules_jvm_external/archive/%s.zip" % RULES_JVM_EXTERNAL_TAG,
)

load("@rules_jvm_external//:defs.bzl", "maven_install")

# dependecies that we will download from the repository
maven_install(
    artifacts = [
        "org.jetbrains.kotlin:kotlin-reflect:1.4.32",
        "org.jetbrains.kotlinx:kotlinx-serialization-json:1.1.0",
        "org.jetbrains.kotlinx:kotlinx-serialization-runtime:1.0-M1-1.4.0-rc",
    ],
    maven_install_json = "//:maven_install.json",
    repositories = [
        "https://repo1.maven.org/maven2",
    ],
)

load("@maven//:defs.bzl", "pinned_maven_install")

pinned_maven_install()
