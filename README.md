# ToStringVerifier: Useless library to verify toString method

[![Build Status](https://travis-ci.org/WojciechZankowski/ToStringVerifier.svg?branch=master)](https://travis-ci.org/WojciechZankowski/ToStringVerifier)
[![codecov](https://codecov.io/gh/WojciechZankowski/ToStringVerifier/branch/master/graph/badge.svg)](https://codecov.io/gh/WojciechZankowski/ToStringVerifier)
[![Quality Gate](https://sonarcloud.io/api/project_badges/measure?project=pl.zankowski%3Atostringverifier&metric=alert_status)](https://sonarcloud.io/dashboard/index/pl.zankowski:tostringverifier)
[![Maven Central](https://img.shields.io/maven-central/v/pl.zankowski/tostringverifier.svg?label=Maven%20Central)](https://search.maven.org/search?q=g:%22pl.zankowski%22%20AND%20a:%22tostringverifier%22)

## Table of Contents

* [Quick Start](#quick-start)
* [Description](#description)
* [How to](#how-to)
* [License](#license)

## Quick Start

Maven:

```
<dependency>
	<groupId>pl.zankowski</groupId>
	<artifactId>tostringverifier</artifactId>
	<version>0.9.1</version>
</dependency>
```

Gradle:

```
dependencies {
	compile 'pl.zankowski:tostringverifier:0.9.1'
}
```

## Description

This is simple library to test if your generated toString method is correctly built. It means it contains all fields in the class and has the right formatting according to the selected generation type. Currently supported generation methods:

* Guava
* String Joiner
* String Concat
* String Builder
* String Buffer
* Apache Lang3

Generally this library is useless.

## How to

Strict verification - verifies if whole string, so it also takes order of fields into the consideration

```
ToStringVerifier.forClass(YourObject.class)
        .withGeneratorType(GeneratorType.GUAVA_18_PLUS)
        .withStrictVerification()
        .verify();
```

Not strict verification - just checks if all fields are in the toString output and it prefix and suffix of the string is correct.

```
ToStringVerifier.forClass(YourObject.class)
        .withGeneratorType(GeneratorType.GUAVA_18_PLUS)
        .verify();
```

## License

Code and documentation released under the Apache License, Version 2.0