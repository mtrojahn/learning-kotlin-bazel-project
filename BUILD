package(default_visibility = ["//visibility:public"])

load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "define_kt_toolchain", "kt_compiler_plugin", "kt_jvm_library")

define_kt_toolchain(
    name = "kotlin_toolchain",
    api_version = "1.4",
    jvm_target = "11",
    language_version = "1.4",
)

# adding the serialization plugin as a compiler plugin
kt_compiler_plugin(
    name = "serialization_plugin",
    id = "org.jetbrains.kotlin.serialization",
    deps = [
        "@com_github_jetbrains_kotlin//:kotlinx-serialization-compiler-plugin",
    ],
)

# this is a lib we will have to import on every other lib that will use kotlinx serialization
kt_jvm_library(
    name = "kotlinx_serialization",
    srcs = [],
    exported_compiler_plugins = [":serialization_plugin"],
    exports = [
        "@maven//:org_jetbrains_kotlinx_kotlinx_serialization_json",
        "@maven//:org_jetbrains_kotlinx_kotlinx_serialization_runtime",
    ],
)

# aliases on the project's root dir can be a nice way to create a collection of libs that devs can use and don't need
# to know the whole implementation or package dependencies. with aliases we can even abstract compiler plugins and
# reflection
alias(
    # allows me to run "bazel run //:app" instead of "bazel run //src/main/kotlin/com/example:myapp"
    name = "app",
    actual = "//src/main/kotlin/com/example:myapp",
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
