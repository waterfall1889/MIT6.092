# Java基本介绍

## Java 语言
- Java 是面向对象的语言，在虚拟机(JVM)上运行
- 比python更复杂，但是速度更快
- Java中没有指针，专门建立垃圾回收机制。分为运行环境和JDK环境

## Java的编译
- 基本步骤：source code(.java)->javac->byte code(.class)->JVM解析运行
- ByteCode不是机器码，是JVM解析的中间代码；大部分固定（机器码），少部分和机器有关的部分，
会根据不同的机器解析不同的效果，在不同系统上有不同的JVM，从而提高效率，但是慢于C++
- 对性能要求高的情况下依然使用C++
- bytecode通过对应的JVM实现执行

## Java程序基本结构

```
class CLASSNAME {
    public static void main(String[] arguments) {
        STATEMENTS
    }
}
```

## Java 基本数据类型

Java 提供了 8 种基本数据类型（Primitive Types），用于表示最基本的数据值。

### 类型一览表

| 类型名       | 占用空间 | 默认值     | 取值范围                              | 示例值               |
|--------------|----------|------------|----------------------------------------|----------------------|
| `byte`       | 1 字节    | `0`        | -128 ~ 127                             | `byte b = 100;`      |
| `short`      | 2 字节    | `0`        | -32,768 ~ 32,767                       | `short s = 20000;`   |
| `int`        | 4 字节    | `0`        | -2³¹ ~ 2³¹-1                           | `int i = 123456;`    |
| `long`       | 8 字节    | `0L`       | -2⁶³ ~ 2⁶³-1                           | `long l = 123456L;`  |
| `float`      | 4 字节    | `0.0f`     | ±1.4E-45 ~ ±3.4028235E+38             | `float f = 3.14f;`   |
| `double`     | 8 字节    | `0.0d`     | ±4.9E-324 ~ ±1.7976931348623157E+308  | `double d = 3.14159;`|
| `char`       | 2 字节    | `'\u0000'` | 单个 Unicode 字符（0 ~ 65535）        | `char c = 'A';`      |
| `boolean`    | ~1 字节   | `false`    | `true` 或 `false`                     | `boolean b = true;`  |

### 📌 补充说明

- `char` 是无符号整数，表示一个 Unicode 字符。
- `boolean` 实际存储空间在 JVM 中并不确定，但逻辑值仅有 `true` 和 `false`。
- `int` 是默认整数类型，`double` 是默认浮点类型。
    - `long` 值后缀加 `L`
    - `float` 值后缀加 `f`