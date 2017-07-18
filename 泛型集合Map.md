Student类
```java
public class Student {
	public String id;
	public String name;
	public int age;
    }
```
泛型集合Map<k,v>,增，删，改，查
```java
package imooc;

import java.util.*;
import java.util.Map.Entry;

public class TestmapKV {
	Map<String,Student> map=new HashMap<String,Student>();
	//测试添加，输入学生id判断是否被占用；未被占用，就添加到map中
	Scanner sc=new Scanner(System.in);
	public void testPut(){
			int i=0;
			while(i<3){
				System.out.println("请输入id");
				String id=sc.next();
				//判断id是否被占用,通过键来取value，看value是否为null
					//这只是用Student接收一下，并不是实例化一个对象
				Student stu=map.get(id);
				if(stu==null){
					Student stu2=new Student();
					System.out.println("请输入姓名");
					String name=sc.next();
					stu2.name=name;
					System.out.println("请输入年龄");
					int age=sc.nextInt();
					stu2.age=age;
					map.put(id, stu2);
					System.out.println("成功添加"+stu2.name);
					i++;
				}else{
					System.out.println("此id已经被占用");
					continue;//利用continue继续循环
				}
				
			}
	}
	//测试Map的keySet方法
	public void testkeySet(){
		//通过keySet方法返回Map中所有键的集合
		Set<String> set=map.keySet();
		//遍历keySet。获得每一个键，再调用get方法取得每个键的value
		for(String stuId:set){
			Student stu=map.get(stuId);
			if(stu!=null){
				System.out.println("学生"+stu.name);
			}
			//System.out.println("名字是"+stu.name+"年龄是"+stu.age);
		}
		
	}
	
	//测试删除待删除的学生
	public void testDelete(){
		//用死循环来保证输入的正确数值
		while(true){
		
		System.out.println("请输入要删除的学生id");
		String id=sc.next();
		//判断该id是否有对应的学生对象
		Student st=map.get(id);
		if(st==null){
			System.out.println("该id不存在");
			continue;//当id不存在时，继续输入，使循环继续下去
		}else{
			//删除学生，只需使用remove(key)就可以
			map.remove(id);
			System.out.println("删除学生"+st.name);
			break;//用break结束此次循环
		}
		}
	}
	//使用entrySet方法遍历Map  返回Map中所有键值对的集合
	public void testentrySet(){
		Set<Entry<String,Student>> entrySet=map.entrySet();
		for(Entry<String,Student> entry:entrySet){
			System.out.println("取得键"+entry.getKey());
			System.out.println("对应的值"+entry.getValue().name);
		}
	}
	//修改学生信息
	public void testModify(){
		while(true){
			System.out.println("请输入要修改的id");
			String id=sc.next();
			Student stu=map.get(id);
			if(stu==null){
				System.out.println("此id不存在");
				continue;
			}else{
				//提示当前对应的学生对象的姓名
				System.out.println("当前该id的学生为"+stu.name);
				//提示输入新的学生姓名，来修改已有的映射
				System.out.println("请输入新的学生姓名");
				String name=sc.next();
				System.out.println("请输入新的学生年龄");
				int age=sc.nextInt();
				Student newstu=new Student();
				newstu.name=name;
				newstu.age=age;
				map.put(id, newstu);//其实就是覆盖之前id的内容，map不允许出现重复值
				System.out.println("修改成功");
				break;//跳出循环
			}					
		}
	}
public static void main(String[] args) {
	TestmapKV m=new TestmapKV();
	m.testPut();
	m.testkeySet();
	m.testDelete();
	m.testentrySet();
}
}
```
