# Lecture IV
## 1.Object oriented programming
- 面向对象编程（Object-Oriented Programming, OOP）和面向过程编程（Procedural Programming, PP）是两种不同的编程思想。
---
### 面向对象编程
###### 🌟 特点
- 封装（Encapsulation）
- 继承（Inheritance）
- 多态（Polymorphism）
- 抽象（Abstraction）

##### ✅ 示例语言：
- Java、C++、Python（支持OOP）

###### 🧠 举例
```java
class Dog {
    String name;

    void bark() {
        System.out.println(name + " is barking");
    }
}
```
---
### 面向过程编程

##### 🌟 特点
- 代码按流程执行
- 数据和操作是分离的
- 注重逻辑步骤

##### ✅ 示例语言：
- C、Pascal、Fortran

##### 🧠 举例
```c
void bark(char* name) {
    printf("%s is barking\n", name);
}
```
---
##### 🔍 对比表

| 特点         | 面向对象编程 (OOP)       | 面向过程编程 (PP)       |
|--------------|---------------------------|--------------------------|
| 核心         | 对象、类                  | 函数、流程               |
| 数据与操作   | 封装在对象内部            | 分离的，全局传递         |
| 可重用性     | 高（继承与多态）          | 较低                     |
| 可扩展性     | 强                        | 弱                       |
| 适合场景     | 大型系统、复杂逻辑        | 简单程序、嵌入式开发等   |

## 2.Java classes
### 基本要求
- 类声明需要写明类名和修饰符，public意味着这个类可以被其他类访问
- 属性（成员变量）:field,可以根据其访问控制级别使用不同的访问修饰符（public、private、protected 或默认访问修饰符），这决定了其他类对这些变量的访问权限。
- Java 中常用的访问修饰符有以下几种： 
- - public：公共访问权限，表示该变量可以被任何其他类访问。
- - private：私有访问权限，表示该变量只能在当前类内部访问，外部类无法直接访问。
- - protected：受保护访问权限，表示该变量可以在当前类、子类（包括不同包中的子类）以及同一个包中的类中访问。
- - 默认（包级访问权限）：如果没有显式地指定访问修饰符（即不写任何修饰符），则该变量只能在当前包内访问。
- 类的首字母必须大写
- 一个源文件（.java 文件）可以有多个类，但其中只能有一个公共类 (public class)，且该公共类的名称必须与文件名相同。其他类可以是非公共类，它们可以存在于同一个文件中。
- 具有main方法的类意味着可以执行。
- main方法不一定只能出现在公共类(public class)中，但通常我们会将它放在公共类中，特别是当你希望运行的类被命名为 public class 且该类与文件名匹配时。
### 构造函数
- 默认情况下仅仅进行构造
- 可以重载
```java
public class Baby{
    int age;
    String name;
    
    Baby(){
        
    }//default constructor
    Baby(int Age,String name){
        this.age = Age;
        this.name = name;
    }
}
```
### 方法
一个方法通常由以下几个部分组成：
- 访问修饰符（public, private, protected 等）
- 返回类型（void, int, String 等）
- 方法名称（自定义名称）
- 参数列表（括号中的参数，如果没有参数为空）
- 方法体（包含实际功能的代码块）

##### 方法的类型
- 实例方法：属于对象实例的方法，访问类的实例变量和其他实例方法。 **调用方式：通过类的对象来调用。**
- 静态方法：属于类的方法，不依赖于对象实例，直接通过类名调用。 **调用方式：通过类名来调用，无需创建对象。**

##### 方法的访问修饰符
- public：方法可以被任何其他类访问。
- private：方法只能在定义它的类内部访问。
- protected：方法可以在同一个包内或子类中访问。
- 默认（包级访问权限）：方法只能在同一个包内访问。

##### 方法重载（Overloading）
Java 允许一个类中定义多个同名方法，但这些方法必须有不同的参数列表（即参数的数量、类型或顺序不同），这叫做方法重载。
```java
public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }

    // 重载方法：参数不同
    public double add(double a, double b) {
        return a + b;
    }

    // 另一种重载方法：参数数量不同
    public int add(int a, int b, int c) {
        return a + b + c;
    }
}
```

##### 方法的可变参数
方法可以使用可变参数（varargs）来接收任意数量的参数。可变参数在方法声明时使用 ... 来表示。
```java
public class Printer {
    public void printMessages(String... messages) {
        for (String message : messages) {
            System.out.println(message);
        }
    }
    public static void main(String[] arguments){
        Printer printer = new Printer();
        printer.printMessages("Hello", "World", "Java");  // 传递多个参数
    }
}
```
- 可变参数实际上会在方法内部作为一个数组来处理。例如：
```java
public void printMessages(String... messages) {
    for (String message : messages) {
        System.out.println(message);
    }
}
```
- 只能在方法参数列表的最后 使用可变参数。如果方法中同时有常规参数和可变参数，那么可变参数必须放在参数列表的最后。
- 不能同时使用多个可变参数。你不能在同一个方法中声明多个可变参数。
- 传递 0 个参数：即使没有传递任何参数给可变参数，它也会被处理为一个空数组。
- 如果你需要接受不同类型的参数，可以使用对象数组或父类数组。比如，你可以使用 Object... 来接受任何类型的参数。
```java
public class MultiTypePrinter {
    public void print(Object... items) {
        for (Object item : items) {
            System.out.println(item);
        }
    }
    public static void main(String[] args) {
        MultiTypePrinter printer = new MultiTypePrinter();
        // 打印不同类型的对象
        printer.print("Hello", 42, 3.14, true);  // 接受字符串、整数、浮点数和布尔值
    }
}
```
- 可变参数提供了一个简化重载的机制。在许多情况下，你不需要为不同数量的参数编写多个方法，只需使用一个方法并传递一个可变参数。
```java
public class Calculator {
    public int sum(int... numbers) {
        int total = 0;
        for (int num : numbers) {
            total += num;
        }
        return total;
    }
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        System.out.println(calc.sum(1, 2, 3));        // 输出：6
        System.out.println(calc.sum(4, 5, 6, 7));     // 输出：22
        System.out.println(calc.sum());               // 输出：0
    }
}
```
- 如果你已经有一个数组，并且想把数组传递给使用可变参数的方法，可以直接通过`...`语法传递该数组。
```java
public class ArrayPrinter {
    public void printArray(String... strings) {
        for (String str : strings) {
            System.out.println(str);
        }
    }

    public static void main(String[] args) {
        ArrayPrinter printer = new ArrayPrinter();
        String[] arr = {"Java", "Python", "C++"};
        
        // 传递数组给可变参数方法
        printer.printArray(arr);
    }
}
```