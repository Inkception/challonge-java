# challonge-java

### This is a forked version of https://github.com/stefangeyer/challonge-java
[![](https://jitpack.io/v/Inkception/challonge-java.svg)](https://jitpack.io/#Inkception/challonge-java)

This library binds the [CHALLONGE! REST API](http://api.challonge.com/v1) calls for Java and any other JVM language.

Released under the MIT license.

## Gradle
```groovy
repositories {
  maven { url 'https://jitpack.io' }
}

implementation 'com.github.Inkception:challonge-java:core:%VERSION%'
```

## Maven
```xml
<repository>
    <id>jitpack.io</id>
    <url>https://jitpack.io</url>
</repository>

<dependency>
    <groupId>com.github.Inkception.challonge-java</groupId>
    <artifactId>core</artifactId>
    <version>%VERSION%</version>
</dependency>
```

## Examples
Check the [wiki](https://github.com/stefangeyer/challonge-java/wiki) for instructions on how get started.

## Modules
This project is split up in the modules core, rest and serializers. While core contains
the main functionality and interfaces for the rest and serializer package, the latter contains all available 
implementations of their respective interfaces. Rest and serializers contain all implementations of the core module's interfaces `Serializer` 
and `RestClient`. Additional implementations may follow in the future.

### Serializers
Currently, there are the following serializer implementations:
- [Gson](https://github.com/google/gson)

### Rest Clients
Currently, there are the following rest client implementations:
- [Retrofit](https://github.com/square/retrofit)
