load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_library")
load("@rules_java//java:defs.bzl", "java_binary")

kt_jvm_library(
    name = "myapp_lib",
    srcs = [
        "AppMain.kt",
        "OtherClasses.kt",
    ],
    deps = ["//src/main/kotlin/com/example/helpers:helpers_lib"],
)

java_binary(
    name = "myapp",
    main_class = "com.example.AppMainKt",
    runtime_deps = [":myapp_lib"],
)
