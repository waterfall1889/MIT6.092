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

## 3.primitive and reference
- primitive types are basic java types.
- reference types are arrays and objects
- 引用类型存储的是对象的内存地址，而不是对象的内容。
- 栈内存存储的是变量本身（即引用），而堆内存存储的是实际的对象数据。对象在堆内存中创建，而栈内存中存储的是引用（内存地址）。
- 赋值操作会传递引用（对象的内存地址），而不是对象本身。
- == compares the references, 而不是对象的数值。
```java
Baby shiloh1 = new Baby('shiloh'); 
Baby shiloh2 = new Baby('shiloh');
// shiloh1 == shiloh2 is false.这是由于二者的内存位置不同造成的。引用类型比较的是内存位置
```

## 4.static types and methods
- 在 Java 中，static 关键字用于定义静态变量和静态方法，它们与类本身而非类的实例（对象）相关联。也就是说，静态变量和方法属于类级别，而不是对象级别。

###  静态变量（Static Variable）
静态变量是属于类的，而不是类的实例。所有类的实例共享同一个静态变量。静态变量被存储在 类的共享内存区，因此，修改某个对象的静态变量，其他对象也能看到这个修改。
```java
public class Counter {
    // 静态变量
    static int count = 0;

    public Counter() {
        count++;  // 每次创建新对象，count 自增
    }

    public static void main(String[] args) {
        System.out.println("Initial count: " + count);  // 输出 0

        // 创建对象，count 会增加
        Counter c1 = new Counter();
        Counter c2 = new Counter();
        
        System.out.println("Count after creating 2 objects: " + count);  // 输出 2
    }
}
```

### 静态方法（Static Method）
- 静态方法是属于类的，而不是实例。静态方法可以通过类名直接调用，而不需要创建类的实例。
- 静态方法不能访问非静态（实例）变量或实例方法。它们只能访问静态成员。
- 不能在静态方法中直接使用 this 关键字（因为 this 是指向实例的）。
- 实例方法（非静态方法）是能够访问静态变量和静态方法的。
```java
public class Baby { 
    static void cry(Baby thebaby) { 
        System.out.println(thebaby.name + "cries"); 
    } 
    //虽然 cry 是静态的，但它并不依赖于实例本身，而是依赖于你传递给它的 Baby 对象。
    //静态方法是属于类的，而非对象的，所以它不能直接访问类的实例成员（如 name）。
    //但通过传入一个 Baby 对象（即 thebaby），静态方法能够操作这个对象的实例成员
}
//等价于
public class Baby {
    void cry() {
        System.out.println(name + "cries");
    }
}
```
### main 函数
- main 方法被设计成静态的（static），是因为 Java 程序的执行入口需要能够在不依赖于类的实例的情况下直接调用。
- Java 程序的执行是从 main 方法开始的。无论程序多么复杂，Java 虚拟机（JVM）总是通过调用 main 方法来启动应用程序。
- JVM 在启动时并不创建该类的实例，而是直接调用 main 方法。这个方法必须是 static，以便 JVM 在加载类时能够直接调用它，而无需实例化该类。
- static 修饰符表示该方法属于类本身，而不是某个实例。当程序启动时，JVM 会加载并运行指定的类，但不会创建类的实例。main 方法是类的一个静态方法，所以它可以在没有类实例的情况下直接被调用。
- 如果 main 不是静态的，JVM 就无法直接调用它，因为没有对象来调用该方法。
- 如果 main 方法是实例方法（非静态），你就需要先创建该类的一个实例，然后通过该实例调用 main 方法，这样会引入不必要的复杂性。