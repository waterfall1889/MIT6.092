# Lecture III
## 1. Coding styles
- 变量名有意义
- 注意缩进使用
- 增加运算符之间的空格
- 不要重复编写测试用例来验证相同的逻辑或行为
## 2，Loops
- 循环提高代码效率
- while循环，类似于C++
- for循环，类似于C++
- break/continue控制循环的运行
```java
public class main{
    public static void main(String[] args) {
        System.out.printf("Hello and welcome!");
        for (int i = 1; i <= 5; i++) {
            System.out.println("i = " + i);
        }
        int s = 0;
        while(s < 30){
            if(s%2 == 0){
                System.out.println(s);
                s+=3;
                continue;
            }
            s++;
        }
    }
} 
```
## 3. Array
- The index starts at zero and ends at length-1.索引从0开始
- 数组中数据类型相同
- 定义：
```java
int[] values1;
int[] values2 = new int[5];
int[][] values3;
int size = 12;
int[] values = new int[size];
int[] values = {1, 2.5, 3, 3.5, 4};//错误，double类型不能用于初始化int数组
double[] s = {1.1, 4, 2.2, 5};//正确，会发生自动类型转化
```
- 数组长度：
```java
int[] values = new int[12];
int size = values.length; // 12
int[] values2 = {1,2,3,4,5};
int size2 = values2.length; // 5
```
- 遍历数组：
```java
int[] values = new int[5]; 
for (int i=0; i<values.length; i++) { 
    values[i] = i; 
    int y = values[i] * values[i]; 
    System.out.println(y); 
}
```

