load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_library")
load("@rules_java//java:defs.bzl", "java_binary")

# defining the kotlin project as a lib
kt_jvm_library(
    name = "myapp_lib",

    # source files that will be compiled on this lib
    srcs = [
        "AppMain.kt",
        "OtherClasses.kt",
    ],

    # dependencies for this lib
    deps = [
        "//:math_helper",
        "//:serialization",  # this adds both dependencies for serialization and the compiler plugin
        "//:string_helper",
    ],
)

# configuration for deployment, enables the creation of a fat-jar by adding _deploy.jar in the end of the build command
# like this: bazel build //src/main/kotlin/com/example:myapp_deploy.jar
java_binary(
    name = "myapp",
    main_class = "com.example.AppMainKt",
    visibility = ["//visibility:public"],
    runtime_deps = [":myapp_lib"],
)
