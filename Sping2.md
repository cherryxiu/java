```
Struts做控制层框架，任务处理，任务分发
Mybatis做持久化层框架，操作数据库
Spring用来整合框架，（1）将不同模块分离，解耦（2）资源的统一管理
```
```
OOP面向对象的工程:在java语言里面，通过计算机程序模拟出现实生活中的一些物体。淘宝买手机，但手机不在电脑里，淘宝通过信息描述手机。
AOP面向切面的编程：我的主线不变，在某一个切面或切入点插入新的东西。现实生活中，进入超市买东西，门口的安检是不影响我正常购物的主业务下添加的附加功能。
```

### AOP基本概念和术语
#### AOP概念
AOP(Aspect Oriented Programming)面向切面编程，解决程序的共性问题，通过预编译方式和运动期动态代理的方式，在不修改源代码的情况下，为对象添加新的方法和属性。

#### AOP术语解释
（1）切面(Aspect):是共有功能的实现。如**日志切面，权限切面，事务权限**等。
（2）通知(Advice)：即增强，是切面的具体实现。以目标方法为参考点，根据放置位置不同，分为前置增强，后置增强，异常增强，环绕增强，引介增强
（3）连接点（Jointpoint）
（4）切入点（PointCut）
（4）目标对象（Target）
（4）代理对象（Proxy）
（4）织入（Weaving）

**（1）创建iava工程，添加spring支持**
![Spring框架](img/spring2_1.png)
**（1）选择spring对AOP的支持**
![Spring框架](img/spring2_2.png)

### 静态代理
##### (1)创建接口
```java
package com.cn.daili;
public interface TestInterface {
	public void say();
}
```
##### (2)创建目标对象（继承接口）
```java
package com.cn.daili;
/*
 * 实现接口，目标对象
 * */
public class Test1 implements TestInterface {
	@Override
	public void say() {
		System.out.println("你很美");
	}
}
```
##### (3)创建代理对象（继承接口）
```java
package com.cn.daili;
/*
 * 代理对象
 * */
public class Test2 implements TestInterface {
	 private TestInterface t1;
	 //写带接口参数的构造方法，为代理目标对象做准备(接口为new test1（）)
    public Test2(TestInterface t){
        t1 = t;
    }		
	//重写接口的方法
	public void say() {
		before();
		t1.say();//接口中的方法（调用test1中的say方法）	
	}
	public void before(){
		System.out.println("小时候");
	}
	//省略接口的get/set方法
```
##### (4)实现代理
```java
package com.cn.daili;

public class Test {
	//正常调用test1
	@org.junit.Test
	public void test(){
		Test1 t1 = new Test1();//目标对象
		t1.say();
	}
	//代理test1
    @org.junit.Test
    public void test1(){
        TestInterface t = new Test2(new Test1());
        t.say();
    }
}

```


#### 饿汉式单例模式
```java
package com.cn.danli;
/*
 * 饿汉式单例模式：一开始就创建一个对象
 * */
public class EHan {
	//私有化对象
	private EHan eh = new EHan();
	//私有化构造函数
	private EHan(){
		
	}
	//提供公有的对外方法
	public EHan getEh(){
		return eh;
	}
}
```

### 懒汉式单例模式
可能存在线程安全问题，因为可能第一个没有被创建完，第二个请求又来了，为了避免这种情况，给方法添加`synchronized`同步，一次性只能一个访问
```java
package com.cn.danli;
/*
 * 懒汉式单例模式:先判断是否存在对象，不存在就创建一个
 * */
public class LanHan {
	//1.私有化对象
	private LanHan lh;
	//2.私有化构造函数
	private LanHan(){
		
	}
	//3.提供公有的对外方法
	public synchronized LanHan getLh(){
		if(lh==null){
			lh = new LanHan();
		}
		return lh;
	}
}

```
