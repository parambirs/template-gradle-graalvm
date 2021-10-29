## GraalVM Image Example

A small application that shows how to build a GraalVM native image with code
using SLF4J and LogBack Classic.

The plugin is configured in `build.gradle` as follows:

```
plugins {
    id 'com.palantir.graal' version '0.9.0'
    ...
}

graal {
    javaVersion '11'
    mainClass 'io.github.parambirs.gradle.graal.Main'
    outputName 'hello-graal'
    option '-H:+ReportExceptionStackTraces'
    option '--report-unsupported-elements-at-runtime'
    option '--no-fallback'
    option '-H:EnableURLProtocols=https'
}
```

### Usage
**Running with gradle:**
```
./gradlew run
```

The following text should appear on your screen:
```
11:31:40.974 [main] INFO io.github.parambirs.gradle.graal.Main - Hello, graal VM!
```


**Creating and executing a custom runtime image:**
```
./gradlew nativeImage
./build/graal/hello-graal
```

The following text should appear on your screen:
```
11:31:40.974 [main] INFO io.github.parambirs.gradle.graal.Main - Hello, graal VM!
```