## JDBC概述
#### JDBC简介
1.DBC API<br>提供了Java应用程序与各种不同数据库交互的标准接口，包括Connection,Statement,PrepareStatement,Result。
2.JDBC Driver Manager<br>管理各种不同的JDBC驱动
3.JDBC 驱动<br>由不同的数据库厂商提供，用于连接不同的数据库。
> JDBC的核心是提供Java API类库，帮助用户建立与数据库的连接，执行sql语句，检索结果集等。

#### 使用JDBC操作数据库
###### 1.JDBC操作数据库步骤
1.加载并注册驱动程序（使用Class.forName()方法将指定的驱动加载到Java虚拟机，若不指定则产生异常）
```
Class.forName(JDBC驱动类的名称);
```
2.与数据库建立连接
```
Connection con=DriverManager.getConnection(数据连接字符串,用户名,密码);
```
3.创建操作对象，发送sql语句
```
Statement sta=con.createStatement();
ResultSet rst=sta.executeQuery("select * from Student");
```
4.处理结果
```
while(rst.next()){
	int id=rst.getInt("id");
    String name=rst.getString("stuName");
}
```
###### 2.JDBC连接数据库
1.配置数据库驱动程序
2.加载驱动程序`Class.forName(driver)`
3.连接及关闭数据库
jdbc:sqlserver://IP地址：端口号;DataBaseName=数据库名称
```java
import java.sql.*;
public class DBManager {
	private static final String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String url="jdbc:sqlserver://localhost:1433;DataBaseName=mstanford";
	private static final String user="sa";
	private static final String pwd="123456";
	private static Connection con=null;	
	//与数据库建立连接
	public static Connection getCon(){
		try {
			Class.forName(driver);//加载驱动
			con=DriverManager.getConnection(url,user,pwd);//连接数据库
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}		
		return con;
	}		
}
```
######  3.Statement接口
数据库连接后可以使用Statement接口进行具体操作，该接口引用指向的对象使用Connection
接口提供createStatement()方法获得。

|返回类型|方法名称|描述|
|:-----:|:--------:|:-----:|
|int|executeUpdate(String sql)|执行数据库更新sql语句，insert，update，delete,并返回更新的记录数|
|ResultSet|executeQuery(String sql)|执行数据库查询操作，返回结果集对象|
|boolean|execute(String sql)|执行sql语句，返回false表示执行失败|
|void|close()|关闭Statement操作|

```java
package OOP6;

import java.sql.*;



public class StatementDemo {
	private static Connection con=null;
	private static Statement sta=null;
	public static void main(String[] args) {
		try {
			con=DBManager.getCon();
			//向数据表中添加数据
				//创建Statemnet对象
			sta=con.createStatement();
				//执行数据库sql语句
			sta.executeUpdate("insert into student values(4,'xi',18)");
			sta.close();
			//修改student表中的数据
			String name="ji";
			String sql="update student set name='"+name+"'where age=18";
			sta.executeUpdate(sql);
			/*//为什么这种写法无效？？？因为sql语句没有打引号呀
			 sta=con.createStatement();
			sta.executeUpdate(update student set age=18);
			*/
			//删除student表中的age为18的记录
			//每执行一条sql语句，都要写一条sta=con.createStatement();
			sta=con.createStatement();
			sta.executeUpdate("delete from student where age=18");
			sta.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
```
利用返回值是int的特性，判断是否执行成功
```
	sta=con.createStatement();
    int a=sta.executeUpdate("delete from student where age=18");
    if(a>0){
    	System.out.println("执行成功");
    }else{
    	System.out.println("执行成功");
    }	
```
###### 4.ResultSet接口

|返回类型|方法名称|描述|
|:-----:|:--------:|:-----:|
|boolean|next()|将指针指向下一行|
|int|getInt(int columnName)|以整数形式按列的序号取得指定内容|
|int|getInt(String columnName)|以整数形式取得指定列的内容|

```java
package OOP6;

import java.sql.*;

public class ResultSetDemo {
	private static Connection con=null;
	private static Statement sta=null;
	private static ResultSet rst=null;
	public static void main(String[] args) {
		try {
			con=DBManager.getCon();
			sta=con.createStatement();
			//接口Statement的executeQuery(sql)方法返回类型为ResultSet
			rst=sta.executeQuery("select * from student");
			//next()将指针移到下一行
			while(rst.next()){
				int id=rst.getInt(1);
				String name=rst.getString(2);
				int age=rst.getInt(3);
				System.out.println("id是：" +id+ "");
				System.out.println("名字是：" +name+ "");
				System.out.println("年龄是：" +age+ "");
			}
			rst.close();
			sta.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{		
		}
	}
}
```
###### 5.PreparedStatement接口
```java
package OOP6;

import java.sql.*;

public class PraparedStatementDemo {
	public static Connection con=null;
	public static PreparedStatement pst=null;
	public static ResultSet rst=null;
	public static void main(String[] args) {
		try {
			con=DBManager.getCon();
			//向表中加入数据
			pst=con.prepareStatement("insert into student values(?,?,?)");
			pst.setInt(1, 6);
			pst.setString(2, "xiaosi");
			pst.setInt(3, 12);
			pst.execute();
			pst.close();
			//删除student表中name="xiu"的数据
			pst=con.prepareStatement("delete from student where name=?");
			pst.setString(1, "xiu");
			pst.execute();
			pst.close();
			//修改student表中name="lx"的age修改为22
			pst=con.prepareStatement("update student set age=? where name=?");
			pst.setInt(1, 22);
			pst.setString(2,"lx");
			pst.execute();
			pst.close();
			//查询student表中年龄为12的记录
			pst=con.prepareStatement("select * from student where age=?" );
			pst.setInt(1, 12);
			   //使用结果集
			 rst=pst.executeQuery();
			while(rst.next()){
				System.out.println("id是：" +rst.getInt(1));
				System.out.println("名字是：" +rst.getString("name"));
				System.out.println("年龄是：" +rst.getInt("age"));
				
			}
			pst.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
```











