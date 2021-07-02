package(default_visibility = ["//visibility:public"])

load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "define_kt_toolchain", "kt_compiler_plugin", "kt_jvm_library")

define_kt_toolchain(
    name = "kotlin_toolchain",
    api_version = "1.4",
    jvm_target = "11",
    language_version = "1.4",
)

kt_compiler_plugin(
    name = "serialization_plugin",
    id = "org.jetbrains.kotlin.serialization",
    deps = [
        "@com_github_jetbrains_kotlin//:kotlinx-serialization-compiler-plugin",
    ],
)

kt_jvm_library(
    name = "kotlinx_serialization",
    srcs = [],
    exported_compiler_plugins = [":serialization_plugin"],
    exports = [
        "@maven//:org_jetbrains_kotlinx_kotlinx_serialization_json",
        "@maven//:org_jetbrains_kotlinx_kotlinx_serialization_runtime",
    ],
)

alias(
    name = "math_helper",
    actual = "//src/main/kotlin/com/dummy/libs:math_helper_lib",
)

alias(
    name = "string_helper",
    actual = "//src/main/kotlin/com/dummy/libs:string_helper_lib",
)

alias(
    name = "serialization",
    actual = "//:kotlinx_serialization",
)
