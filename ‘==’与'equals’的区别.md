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
       public static void main(String[] args) {
       int n=3;
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

 --------------------------------------------
```java
public class Demo {
	public static void main(String[] args) {
		//“==”对于基本数据类型，判断两个变量的值是否相等。 
		int t1=43;
		int t2=12;
		int t3=55;
		int t4=55;
		Boolean r1=(t1==t2);
		Boolean r2=((t1+t2)==t3);
		Boolean r3=(t3==t4);
		System.out.println("1"+r1+" "+r2+" "+r3);
		//false true true
		//“equal”不能用于基本数据类型。只能用于类变量。对于基本数据类型要用其包装类。 
		Integer i1=new Integer(t1);
		Integer i2=new Integer(t2);
		Integer i3=new Integer(t3);
		Integer i4=new Integer(t4);
		Boolean b1=i1.equals(i2);
		Boolean b2=i3.equals(i1+i2);
		Boolean b3=i3.equals(i4);
		System.out.println("2"+b1+" "+b2+" "+b3);
		//false true true
		//对于对象变量
		String str1="my";
		String str2="name is lx";
		String str3="my name is lx";
		String str4="my name is lx";
		Boolean q1=(str1==str2);
		Boolean q2=((str1+str2)==str3);
		Boolean q3=(str3==str4);
		System.out.println("3"+q1+" "+q2+" "+q3);
		//false false true
		//对象变量equals
		 Boolean l1=str1.equals(str2); 
		 Boolean l2=(str1+str2).equals(str3); 
		 Boolean l3=str3.equals(str4); 
		 System.out.println("4"+l1+" "+l2+" "+l3);
		 //false false true
		
	}
}

```
 
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

```java
package imooc;

public class Lstring {
	public static void main(String[] args) {
		String s1 = "imooc";
		String s2 = "imooc";
        
        //定义字符串s3，保存“I love”和s1拼接后的内容
		 String s3="I love"+s1;
		
        // 比较字符串s1和s2  true
		// imooc为常量字符串，多次出现时会被编译器优化，只创建一个对象
		System.out.println("s1和s2内存地址相同吗？" + (s1 == s2));
        
        //比较字符串s1和s3  false
		System.out.println("s1和s3内存地址相同吗？" +  (s1==s3)               );

		String s4 = "I love " + s1;
         //比较字符串s4和s3  false
		// s1是变量，s4在运行时才知道具体值，所以s3和s4是不同的对象
		System.out.println("s3和s4内存地址相同吗？" + (s4 == s3));
	}
}
```
 
 
