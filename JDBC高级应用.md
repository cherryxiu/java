## 可滚动结果集
|结果集类型（resultType取值）|说明|
|----------|------------|
|FETCH_FORWARD|正向（由始至尾）移动或处理集中的行。允许更新结果集但不能反映到表中；表数据修改后也不能反映到结果集；|
|FETCH_REVERSE|逆向（由尾至始）处理集中的行。不允许更新结果集；表数据修改后也不能反映到结果集；|
|TYPE_FORWARD_ONLY|结果集只能向前移动，不允许对结果集进行更新；表数据修改后可以反映到结果集中；|
|TYPE_SCROLL_INSENSITIVE|结果集可任意滚动，不允许修改结果集；表数据修改后不能反映到结果集中|
|TYPE_SCORLL_SENSITIVE|结果集可任意滚动，允许修改结果集并反映到表中；表数据修改后可以反映到结果集中|

|并发类型（resultSetConCurrency取值）|说明|
|--------|-------------------|
|CONCUR_READ_ONLY|不允许修改结果集|
|COUCUR_UPTATABLE|允许修改结果集|

#### 使用可滚动结果集定位记录
```java
con=DBManager.getCon();
			String sql="select * from student";
			pst=con.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			rst=pst.executeQuery();
			System.out.println("表中第四条数据的学生姓名是");
			rst.absolute(4);//定位到第四条数据
			System.out.println(rst.getString(2));
			
			System.out.println("当前记录的上一条记录的学生姓名是");
			rst.previous();//定位到当前记录的上一条记录
			System.out.println(rst.getString(2));
			
			System.out.println("当前记录的下一条记录的学生姓名是");
			rst.next();//定位到当前数据的下一条记录
			System.out.println(rst.getString(2));
			System.out.println("表中第一条记录是");
			
			rst.first();//定位到第一行
			System.out.println(rst.getString(2));
			System.out.println("表中最后一条记录是");
			
			rst.last();//定位到最后一行
			System.out.println(rst.getString(2));
```
#### 使用可滚动结果集操作数据
```java
con=DBManager.getCon();
			String sql="select * from student";
			pst=con.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			rst=pst.executeQuery();
			
			rst.moveToInsertRow();//移动到待插入的行，插入到最后一行
			rst.updateString("name", "pig");
			rst.insertRow();//将插入行的内容插入到结果集和数据库中
			
			rst.absolute(3);//将结果集指针定位到第三条记录
			rst.updateInt("age",108);
			rst.updateRow();//用结果集的当前行的新内容更新底层数据
			
			rst.absolute(5);
			rst.deleteRow();//从此结果集和底层数据库中删除当前行
```
## CallableStatement
> CallableStatement是Statement的子接口，主要用于调用存储过程，提高操作效率。


```java
package OOP7;
import java.sql.*;
/*存储过程（无输入输出参数的存储过程）
 * use mstanford
if exists(select * from sysobjects)
 drop procedure pro_demo1
 go
 create procedure pro_demo1
 as 
 SELECT * from student
 go*/
 
public class Callable1 {
	private static Connection con=null;
	private static CallableStatement cst=null;
	private static ResultSet rst=null;
	public static void main(String[] args) {
		try {
			con=DBManager.getCon();
			cst=con.prepareCall("{call pro_demo1}");//调用无参存储过程
			cst.execute();
			rst=cst.getResultSet();
            //结果集需要rst.next()才可以getString；
			while(rst.next()){
				System.out.println("名称是：" +rst.getString(2));				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBManager.closeResultSet(rst);
			DBManager.closeStatement(cst);
			DBManager.closeConnection(con);
		}
	}
}
```
```java
package OOP7;

import java.sql.*;
/*存储过程（有输入无输出参数的存储过程）
 * use mstanford
if exists(select * from sysobjects)
drop procedure pro_demo2
go
create procedure pro_demo2
@LName varchar(20)
AS 
select COUNT(*) from student where name=@LName
go*/
public class Callable2 {
	private static Connection con=null;
	private static CallableStatement cst=null;
	private static ResultSet rst=null;
	public static void main(String[] args) {
		try {
			con=DBManager.getCon();
			cst=con.prepareCall("{call pro_demo2(?)}");//调用有参的存储过程
			cst.setString(1, "li");
			cst.execute();
			rst=cst.getResultSet();
			while(rst.next()){
				System.out.println("名字是li的有" +rst.getInt(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBManager.closeResultSet(rst);
			DBManager.closeStatement(cst);
			DBManager.closeConnection(con);
		}
	}
}
```
```java
package OOP7;

import java.sql.*;
/*存储过程（含有输入输出的存储函数）
 * use mstanford
if exists(select * from sysobjects)
drop procedure pro_demo3
go
create procedure pro_demo3
@LName varchar(20),
@Num int output
as
select @Num=COUNT(*) from student where name=@LName
go */
public class Callable3 {
	private static Connection con=null;
	private static CallableStatement cst=null;
	private static ResultSet rst=null;
	public static void main(String[] args) {
		try {
			con=DBManager.getCon();
			cst=con.prepareCall("{call pro_demo3(?,?)}");
			cst.setString(1,"li");
			cst.registerOutParameter(2,java.sql.Types.INTEGER);
			cst.execute();
			System.out.println(cst.getInt(2));//获得输出参数值并输出,第二个问号
			//与Callable2的区别是2是结果之后的遍历，这里仅指第二个占位符的值（输出值）
					} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBManager.closeResultSet(rst);
			DBManager.closeStatement(cst);
			DBManager.closeConnection(con);
		}
	}
}
```
含有return的话，传入参数的位置数字有所改变
```java
package OOP7;

import java.sql.*;
/*含有return的存储过程
 * use mstanford
if exists(select * from sysobjects)
drop procedure pro_demo4
go
create procedure pro_demo4
@LName varchar(20)
as 
if (select COUNT(*) from student where name=@LName)>5
return 0
else
return 1
go*/
public class Lreturn {
	private static Connection con=null;
	private static CallableStatement cst=null;
	private static ResultSet rst=null;
	public static void main(String[] args) {
		try {
			con=DBManager.getCon();
			cst=con.prepareCall("{?=call pro_demo4(?)}");//使用占位符换取返回值
			cst.registerOutParameter(1, java.sql.Types.INTEGER);
			cst.setString(2,"zhangsan");
			cst.execute();
			System.out.println(cst.getInt(1));//获取存储过程的返回值
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBManager.closeResultSet(rst);
			DBManager.closeStatement(cst);
			DBManager.closeConnection(con);
		}
	}
}
```
## JDBC 事务
> 数据库角度上的事务则指一组sql语句，用于全部指令执行成功，当其中某条指令有误时撤销先前执行过的所有指令。

#### 使用JDBC事务步骤
1. 取消Connection对象默认的事务自动提交方式`con.setAutoCommit(false);`
2. 所有sql语句执行成功后提交事务`con.commit();`
3. 若在执行sql语句过程中发生异常，则回滚事务`con.rollback();`

```java
package OOP7;
import java.sql.*;
public class testJDBC {
	private static Connection con=null;
	private static PreparedStatement pst=null;
	private static ResultSet rst=null;
	public static void main(String[] args) {
		try {
			con=DBManager.getCon();
			con.setAutoCommit(false);//取消自动提交方式
			pst=con.prepareStatement("insert into student values('903','English')");
			pst.execute();
			pst=con.prepareStatement("insert into student values('923',Chinese')");
			pst.execute();
			con.commit();//在所有语句都执行成功的情况下提交事务
			
		} catch (Exception e) {
			try {
				con.rollback();//若执行过程中发生异常则回滚事务
			} catch (Exception e2) {
				e.printStackTrace();
			}
			e.printStackTrace();
		}finally{
			DBManager.closeResultSet(rst);
			DBManager.closeStatement(pst);
			DBManager.closeConnection(con);
		}
	}
}
```
若需要异常发生后仅撤销部分操作，则可以通过设置事务的回滚点（Savepoint）（回滚位置）来进行回滚控制
```java
package OOP7;
import java.sql.*;
public class testJDBC {
	private static Connection con=null;
	private static PreparedStatement pst=null;
	private static ResultSet rst=null;
	public static void main(String[] args) {
		Savepoint sp=null;//回滚点类型
		try {
			con=DBManager.getCon();
			con.setAutoCommit(false);//取消自动提交方式
			pst=con.prepareStatement("insert into student values('903','English')");
			pst.execute();
			sp=con.setSavepoint();//创建回滚点对象
			pst=con.prepareStatement("insert into student values('923',Chinese')");
			pst.execute();
			con.commit();//在所有语句都执行成功的情况下提交事务
		} catch (Exception e) {
			try {
				con.rollback(sp);//回滚事务到回滚点
				con.commit();
			} catch (Exception e2) {
				e.printStackTrace();
			}
			e.printStackTrace();
		}finally{
			DBManager.closeResultSet(rst);
			DBManager.closeStatement(pst);
			DBManager.closeConnection(con);
		}
	}
}

```
使用con.rollback(sp)后需要再次提交事务。
