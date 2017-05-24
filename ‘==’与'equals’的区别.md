### ==比较引用地址，equals比较的是值

```
　1）对于==，如果作用于基本数据类型的变量，则直接比较其存储的 “值”是否相等；
   如果作用于引用类型的变量，则比较的是所指向的对象的地址
　2）对于equals方法，equals是判定值是否相等。注意：equals方法不能作用于基本数据类型的变量.
   如果没有对equals方法进行重写，则比较的是引用类型的变量所指向的对象的地址；
　　诸如String、Date等类对equals方法进行了重写的话，比较的是所指向的对象的内容。
```

--------------

```java
publicclass Main {

    /**
     * @param args
     */publicstaticvoid main(String[] args) {
        // TODO Auto-generated method stubint n=3;
        int m=3;
        
        System.out.println(n==m);
        
        String str = new String("hello");
        String str1 = new String("hello");
        String str2 = new String("hello");
        
        System.out.println(str1==str2);
        
        str1 = str;
        str2 = str;
        System.out.println(str1==str2);
    }

}
```
　n==m结果为true，这个很容易理解，变量n和变量m存储的值都为3，肯定是相等的。而为什么str1和str2两次比较的结果不同？
 要理解这个其实只需要理解基本数据类型变量和非基本数据类型变量的区别。对于这8种基本数据类型的变量，变量直接存储的是“值”，
 因此在用关系操作符==来进行比较时，比较的就是 “值” 本身。而对于非基本数据类型的变量，在一些书籍中称作为 引用类型的变量。
 比如上面的str1就是引用类型的变量，引用类型的变量存储的并不是 “值”本身，而是于其关联的对象在内存中的地址。
 
 -----------------------
 
 ```java
 String source="abc";
String str1 = "abc";
String str2 = new String(source);
String str3 = new String("abc");
String str4 = source;
String str5="ab"+"c";

System.out.println(source == str1);
System.out.println(source == str2);
System.out.println(source == str3);
System.out.println(source == str4);
System.out.println(source == str5);


结果为：true
             false
             false
             true
             true
 
 
 ```
 --------------------------------------------
 
```java
package demo;

public class This {
	public static void main(String[] args){
		Card card = new Card();
		Card newcard = new Card();
		if(card==newcard){
			System.out.println("两个对象是相同的");
		}else{
			System.out.println("两个对象是不相同的");
		}
		
	}

}
结果显示：两个对象是不相同的
```
```java
package demo;

public class This {
	public static void main(String[] args){
		String card = new String();
		String newcard = new String();
		if(card==newcard){
			System.out.println("两个对象是相同的");
		}else{
			System.out.println("两个对象是不相同的");
		}
		
	}

}
结果显示：两个对象是相同的
```
### 结果显示不同的原因是：string类是封装类，equals()方法已经被重写了，比较的是两个的值

 
 
 
