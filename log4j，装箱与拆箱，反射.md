## log4j
#### log4j介绍
`1.日志信息的优先级`优先级由高至低：error,warn,info,debug<br/>
核心原则：只有大于或者等于该日志级别的日志请求才会被打印出来。<br/>
`2.日志信息输出目的地`<br/>
console(控制台)：ConsoleAppender<br/>
file(文件)：FileAppender<br/>
GUI components(图形组件)<br/>
`3.日志信息输出格式`
PatternLayout(可以灵活地指定布局模式)，HTMLLayout(以HTML表格形式布局)
#### 使用log4j记录日志
```
###将日志信息输出到控制台###
log4j.appender.Console=org.apache.log4j.ConsoleAppender
log4j.appender.Console.layout=org.apache.log4j.PatternLayout
log4j.appender.Console.layout.ConversionPattern=%d{yyyy-MM-dd HH:mm:ss}%m%n %l
###将日志文件输出到文件中###
log4j.appender.file=org.apache.log4j.FileAppender
log4j.appender.file.File=D:/test/test.log    【日志文件的名称，路径】
log4j.appender.file.layout=org.apache.log4j.PatternLayout
log4j.appender.file.layout.ConversionPattern=%d{yyyy-MM-dd HH:mm:ss}%m%n %l
###设置日志的优先级别###
log4j.rootLogger=debug,Console,file
```
```
package OP4;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
public class Demo {
	public static void main(String[] args) {
		//导入的是apache的包
		Logger logger=null;
		try {
      //1..通过PropertyConfigurator.config()方法加载指定位置的配置文件
			    //将log4j配置文件放到src目录下，就可以自动加载配置文件（不能放到包下）
			PropertyConfigurator.configure("e:/log4j.properties");
			//2.获取日志记录器
			logger=Logger.getLogger(Demo.class.getName());
			int result=4/0;
		} catch (Exception e) {
			//3.日志记录器记录日志
			logger.debug(e.getMessage());
		}
		
		
	}
}

```
## 装箱与拆箱
```
package imooc;

public class LInteger {
	    public static void main(String[] args) {
	        // 定义double类型变量
			double a = 91.5; 
	         // 手动装箱
			Double b = new Double(a);       	        
	        // 自动装箱
			Double c =a;
	        System.out.println("装箱后的结果为：" + b + "和" + c);	        
	        // 定义一个Double包装类对象，值为8
			Double d = new Double(87.0);	        
	        // 手动拆箱
			double e =  d.doubleValue()   ;	        
	        // 自动拆箱
			double f =  d              ;	        
	         System.out.println("拆箱后的结果为：" + e + "和" + f);	         
	         //数据类型转换
	     	double m = 78.5;
			//将基本类型转换为字符串
			String str1 =  Double.toString(m);	        
			System.out.println("m 转换为String型后与整数20的求和结果为： "+(str1+20));			
			String str = "180.20";
		    // 将字符串转换为基本类型
			Double g =Double.parseDouble(str);
			System.out.println("str 转换为double型后与整数20的求和结果为： "+(g+20));
		}
	
}
```
## 反射
> 反射是指程序在运行时能够获取自身信息的机制。例如一个类在运行时能够获取自身有哪些方法和属性等信息。

#### Class类及其使用
通过Object类的getClass()或Class.forName()方法取得每个类对应的Class对象，然后通过取得的Class对象获取类的基本信息。<br/>
getClass()方法
```
package OP4;
public class ClassDemo {
	public static void main(String[] args) {
		String str="hello";
		//通过Objet类获取类对应的Class对象
		Class stringClass=str.getClass();
		System.out.println("类的名称是+" +stringClass.getName());
		System.out.println("是否为接口："+stringClass.isInterface());
		System.out.println("是否为基本类型:"+stringClass.isPrimitive());
		System.out.println("是否为数组："+stringClass.isArray());
		System.out.println("父类的名称是："+stringClass.getSuperclass().getName());
		/*
		 *  类的名称是+java.lang.String
			是否为接口：false
			是否为基本类型:false
			是否为数组：false
			父类的名称是：java.lang.Object*/
	}
}
```
Class.forName()方法
```
package OP4;
import java.lang.reflect.Method;
public class Demo3 {
		public static void main(String[] args) {
			try {
      //通过Class.forName()方法获取Class对象  动态加载类
				Class stu=Class.forName(args[0]);
				//获取类中的所有方法，  要导包(获取所有方法时，使用Method[]接收)
				Method[] methods=stu.getMethods();
				for(int i=0;i<methods.length;i++){
					System.out.println(methods[i].getName());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
}
```
#### 反射的应用
使用Class的newInstance()方法实例化对象，实例化的对象以Object类型返回
```
Class c=Class.forName(classname);
Object obj=c.newInstance();
```
```
package OP4;
import java.util.List;
public class InvokeMethod {
	public static void main(String[] args) {
		try {
			Class c=Class.forName("java.util.ArrayList");
			List list=(List)c.newInstance();//生成ArrayList实例
			for(int i=0;i<5;i++){
				list.add(i);
			}
			for(int i=0;i<list.size();i++){
				System.out.println(list.get(i));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
```
#### 调用反射中的方法
> 1.通过Class类的getMethod方法取得Method对象，并设置调用方法时需要的参数类型。<br/>
> 2.使用Method对象的invoke方法，并向该方法传递参数，其参数通常为一个类的实例。
```
package OP4;
public class Student {
	public void printInfo(){
		System.out.println("你好，傻瓜");
	}
	public void print(String name){
		System.out.println("名字是"+name);
	}
	
}
```
```
package OP4;
import java.lang.reflect.Method;
public class End {
	public static void main(String[] args) {
		try {
//动态加载类（"OP4.Student"是要获取方法的类名）
 			Class student =Class.forName("OP4.Student");
//获取Student类的printInfo()方法
			Method m1=student.getMethod("printInfo");
//调用printInfo方法,参数为一个类的实例
			m1.invoke(student.newInstance());
//获取print方法；第一个参数：方法名；第二个参数：String.class是方法的参数类型（就是形式参数的类型.class）
			Method m2=student.getMethod("print",String.class);
//调用方法   第一个参数：一个类的实例  第二个参数：实际参数
			m2.invoke(student.newInstance(),"liu");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
```


