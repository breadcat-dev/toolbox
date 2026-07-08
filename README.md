# Toolbox

[![License: MIT](https://img.shields.io/badge/License-MIT-green.svg)](https://opensource.org/licenses/MIT)
![Java](https://img.shields.io/badge/Java-21-blue)
![Status](https://img.shields.io/badge/status-stable-brightgreen)
![Release](https://img.shields.io/github/v/release/breadcat-dev/toolbox)

> Lightweight utility library for Java projects

Part of the TANK Series.

---

## Features

- File utilities (copy, move, traversal, path helpers) 
- Binary utilities (bit manipulation)
- String utilities
- ANSI color constants
- Data and time unit constants
- Lightweight with no external dependencies

## Design Goals

- Clean API
- Minimal
- Lightweight

---

## Installation

Currently, Toolbox is not on Maven Central.
To use it, clone the repository and publish it to your local Maven Repository.


```sh
git clone https://github.com/breadcat-dev/toolbox.git
cd toolbox
```

### Linux / MacOS
```sh
./gradlew publishToMavenLocal
```
### Windows
```sh
./gradlew.bat publishToMavenLocal
```

Once installed, add the dependency:

### Groovy
```gradle
implementation "cat.breadcat:toolbox:<version>"
```

### Kotlin DSL
```gradle
implementation("cat.breadcat:toolbox:<version>")
```

---

## Examples

### AnsiUtil
```java
System.out.println(AnsiUtil.RED + "This text is red." + AnsiUtil.RESET);
```

### BinaryUtil
```java
long byteTest = 0; // 00000000 00000000 00000000 00000000
byteTest = BinaryUtil.setBit(byteTest, 2); // 00000000 00000000 00000000 00000100
```

### FileIOUtil
```java
Path useful = Path.of("./input.bin");
Path backupUseful = Path.of("./backup/input.bin");

try
{
    FileIOUtil.copy(useful, backupUseful);
}
catch(IOException e)
{
    throw new RuntimeException(e);    
}
```

### FileQueryUtil
```java
Path chosenDirectory = Path.of("./project");
List<Path> filesInDirectory = new ArrayList<>();
try
{
    filesInDirectory = FileQueryUtil.files(chosenDirectory);
}
catch(IOException e)
{
    throw new RuntimeException(e);    
}
```

( File structure )
```text
project/
├── test.txt
├── main.c
└── assets/
    ├── icon.png
    └── breadcat.png
```

( filesInDirectory )
```text
./project/test.txt
./project/main.c
./project/assets/icon.png
./project/assets/breadcat.png
```

### PathUtil
```java
Path file = Path.of("./Main.java");
String extension = PathUtil.extension(file);
```

( extension )
```java
String extension = "java";
```

### StringUtil
```java
String text = StringUtil.join(", ", "breadcat", 43, true);
System.out.println(text);
```
> breadcat, 43, true

### BinaryDataUnits
```java
System.out.println("There are " + BinaryDataUnits.MiB + " bytes in a MiB.");
```
> There are 1048576 bytes in a MiB.

---

## Dependencies:

This library has no external dependencies.