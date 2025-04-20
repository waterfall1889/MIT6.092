# Lecture V
## 1.Access control
- Java 提供了四种访问级别，用于控制类、方法、字段等的访问范围：

| 修饰符        | 同类 | 同包 | 子类（不同包） | 外部类 |
|---------------|------|------|----------------|--------|
| `public`      | ✅    | ✅    | ✅              | ✅      |
| `protected`   | ✅    | ✅    | ✅              | ❌      |
| *默认（包访问）* | ✅    | ✅    | ❌              | ❌      |
| `private`     | ✅    | ❌    | ❌              | ❌      |

---
### public

- 可以在任何地方访问。
- 通常用于类或希望对外公开的方法和字段。

```java
public class Person {
    public String name;

    public void sayHello() {
        System.out.println("Hello");
    }
}
```

### protected
- 可以在同一个包中访问。
- 也可以在不同包的子类中访问。但访问方式必须通过继承而来的引用，不能直接访问其他类的对象。

### private
- 只能在定义它的类内部访问。
- 常用于隐藏类的实现细节。

### 默认（包访问）
- 不写任何修饰符时默认的访问权限。
- 只能在同一个包中访问。

## 2.this的使用
- this 关键字是一个引用变量，它指向当前对象的实例。
- this 用来引用当前对象的成员变量、方法等。例如，在构造方法中，this 可以用来区分实例变量和局部变量。
- this() 用于在一个构造函数中调用同一个类中的另一个构造函数。必须是构造函数中的第一行代码。
```java
class Person {
    String name;
    int age;

    // 第一个构造函数
    public Person(String name) {
        this(name, 0); // 调用第二个构造函数
    }

    // 第二个构造函数
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
```
- 可以将 this 作为参数传递给方法或构造函数，表示当前对象。
```java
class Test {
    void display(Test t) {
        System.out.println("Method called on: " + t);
    }

    void callMethod() {
        this.display(this); // 将当前对象传递给 display 方法
    }
}
```
- this 用来明确指向当前对象的实例变量。
- this 可以用于返回当前对象的引用，常用于方法链式调用。
```java
class Person {
    String name;

    public Person setName(String name) {
        this.name = name;
        return this; // 返回当前对象的引用
    }
}

public class Main {
    public static void main(String[] args) {
        Person p = new Person();
        p.setName("Alice").setName("Bob"); // 链式调用
    }
}
```
## 3.package
- package（包）是一个组织类和接口的机制，用于将相关的类和接口归类在一起，以便于管理和使用。
- 通过 package，可以避免类名冲突，并且让代码更加有条理和模块化。
- 在 Java 中，每个类文件可以通过 package 语句声明它属于哪个包。package 语句必须是文件的第一行，且通常遵循包名的层级结构。
- 包的命名通常与项目的目录结构相对应。
```java
// 文件: src/com/example/MyClass.java
package com.example;  // 声明该类属于 com.example 包

public class MyClass {
    // 类的实现
}
```
- 包可以有层级，使用.来表示层级。例如，com.example.utils 就表示 com 包中的 example 包下的 utils 包。
- 不同的包可以包含同名的类而不会发生冲突。
- 包的使用与 Java 的访问控制（即访问修饰符）密切相关。Java 提供了四种访问级别：
- - public：可以被任何类访问。
- - protected：可以被同一个包中的类，或子类访问。
- - 默认访问（包级访问权限）：如果没有显式使用访问修饰符，类或成员变量默认只能在同一个包内访问。
- - private：只能在本类中访问。
```java
import com.example.utils.MyUtility;  // 导入 com.example.utils 包中的 MyUtility 类
import com.example.utils.*;  // 导入 com.example.utils 包中的所有类
```
- Java 标准库提供了许多常用的包。例如：
- - java.lang：包含 Java 的核心类，如 String、Math、Object 等。
- - java.util：提供常用的集合类，如 ArrayList、HashMap 等。
- - java.io：用于文件和数据流的处理。
- - java.net：用于网络编程。
- - 这些包中的类可以直接导入和使用

## 4.Java API
- Java API（Java Application Programming Interface）是 Java 编程语言中的一组预定义的类、接口、库和方法，用于帮助开发者构建和开发 Java 程序。它是 Java 开发的基础，包含了大量的标准类库，供开发者直接使用，从而避免了重复造轮子。API 为 Java 提供了丰富的功能和工具，使得开发过程更加高效和简便。
### Java API分类
#### 类库（Library）
组织成多个包（package），如 java.lang、java.util、java.io、java.net 等，提供了许多常见的功能和工具。
#### 接口（Interface）
定义了类应该具备的行为（方法签名）。这些接口不提供方法的实现，而是由具体的类去实现。例如：
- java.util.List：一个表示列表的接口，ArrayList 和 LinkedList 等类实现了这个接口。
- java.util.Map：表示映射关系的接口，HashMap 和 TreeMap 等实现了这个接口。
#### 异常（Exception）
用于处理程序中的各种错误情况。例如：
- java.lang.Exception：所有异常类的根类。
- java.io.IOException：用于表示输入输出操作中的异常。
- java.sql.SQLException：用于表示数据库操作中的异常。
#### 工具类
用于简化常见操作。例如：
- java.util.Collections：提供集合类的各种操作（排序、查找等）。
- java.util.Arrays：提供数组操作的方法（排序、查找等）。
- java.math.BigDecimal：用于高精度计算。
### 使用API的优势
- 标准化
- 功能强大、使用灵活
- 跨平台性好