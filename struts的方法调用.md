### Action中指定业务的调用
```
public class UserAction {
	//一定要给private属性创建getter/setter方法
	private String username;
	private String password;
	private String msg;
	//不指定方法名时执行execute()方法
	public String execute(){
		System.out.println("12用户名是"+username);
		System.out.println("12密码是"+password);
		if(username.equals("jack") && password.equals("123")  ){
			msg="登录成功";
			return "success";
		}else{
			msg="登录失败";
			return "error";
		}
		
	}
    
   public String add(){
		System.out.println("添加方法");
	
	}
...
	
	
}

```
##### 1.直接调用方法
```
<struts>
 <package name="default" namespace="/" extends="struts-default">	
	<action name="login" class="com.cn.action.UserAction">
		<result name="success">/login.jsp</result>
		<result name="error">/login.jsp</result>
	</action>
 </package>
</struts>
```
调用
```
	<form action="add.action" method="post">
		username:<input type="text" name="username"/>${msg }<br/>
		password:<input type="text" name="password"/><br/>
		<input type="submit" value="submit"/>
	</form>
```
##### 2.动态方法调用
```
<struts>
<!--  开启动态方法 -->
 <constant name="struts.enable.DynamicMethodInvocation" value="true"/> 
 <package name="default" namespace="/" extends="struts-default">	
	<action name="userManage" class="com.cn.action.UserAction">
		<result name="success">/login.jsp</result>
		<result name="error">/login.jsp</result>
	</action>
 </package>
</struts>
```
调用
```
	<form action="userManage!add.action" method="post">
		username:<input type="text" name="username"/>${msg }<br/>
		password:<input type="text" name="password"/><br/>
		<input type="submit" value="submit"/>
	</form>
```
##### 3.使用通配符
```
<struts>
<!--  开启动态方法 -->
 <constant name="struts.enable.DynamicMethodInvocation" value="true"/> 
 <package name="default" namespace="/" extends="struts-default">	
	<action name="userManage_*" class="com.cn.action.UserAction" method={1}>
		<result name="{1}">/{1}.jsp</result>
	</action>
 </package>
</struts>
```
调用
```
	<form action="userManage_add.action" method="post">
		username:<input type="text" name="username"/>${msg }<br/>
		password:<input type="text" name="password"/><br/>
		<input type="submit" value="submit"/>
	</form>
```
### struts的结果类型
> dispatcher:请求转发至指定的jsp资源
> chain:请求转发至指定的Action资源
> redirect:重定向至指定的jsp资源
> redirectAction:重定向至指定的Action资源
#### 请求转发
```
<result name="success" type="dispatcher">/index.jsp</result>

```
#### 重定向
```
<result name="success" type="redirectAction">
    <param name="actionName">userManage</param>
    <param name="method">add</param>
</result>

```



