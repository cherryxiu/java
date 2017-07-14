#### JavaScript的原理
    JavaSript是嵌入到HTML语言中，直接通过浏览器就得以运行，通常情况下，把JavaScript称为Web脚本语言。JavaSript是一种轻型的，解
释性的脚本语言，是一种由浏览器解释执行的程序语言。
#### JavaSript的作用
    JavaSript脚本是从服务器端下载到客户端，然后在客户端执行的，既不占用服务器的CPU等资源，因此，通过客户端脚本，分担了服务器的任
    务，从而间接地提升了Web服务器的性能。
#### 脚本代码的位置
1.放在<script></script>标签对之间<br/>
2.将JavaScript代码放置在同一个单独的文件里<br/>
```
<script type="text/javasrcipt" src="demo1.js"></script>
```
3.将脚本程序代码作为属性值
```
<a href="javasrcipt:document.write('欢迎来到JS世界');">hello world</a>
```
 ## JavaScript核心语法
 ### 1.变量
 1.1先声明变量再赋值
 ```
 var message;
 message="hi";
 ```
 1.2.同时声明变量和赋值<br/>
 1.3.不声明变量，直接赋值
 #### 2.数据类型
 基本数据类型:undefined,null,boolean,number,string<br/>
 复杂数据类型：object对象类型
 ###### typeof操作符( typeof操作符返回值)
 > 1.undefined：对未初始化的变量及未声明的变量。<br/>
 > 2.string:用单引号或双引号来声明的字符串。<br/>
 > 3.boolean:true或false。<br/>
 > 4.number:整数或浮点数。<br/>
 > 5.object:javascript中的对象、数组和null。
 ```
 <script type="text/javascript">
  var name;
  document.write(typeof(name));//string,因为name是关键字
  var obj=new Date();
  document.write(typeof(obj));//object
  var obj=null;
  document.write(typeof(obj));//object
  var flag=1<2
  document.write(typeof(flag));//boolean
</script>
 ```
  #### 3.运算符
  算术运算符：+ - * / % ++ --<br/>
  赋值运算符：=<br/>
  比较运算符：> < >= <= == !=<br/>
  逻辑运算符：&&  ||  ！
  
   #### 4.注释
   （1）单行注释`//`
   （2）多行注释`/*.....*/`
   
    #### 5.流程控制语句
    5.1顺序结构
    5.2选择结构
    ```
  <script type="text/javascript">
	var na;
	if (!na){//判断变量的值是否为undefined或null，可以简写成if(变量)，原本是if(typeof na=="undefined")
		na="liu";
	}
	document.write("名称是" + na);

</script>
```
    ```
    <script type="text/javascript">
	var time=new Date();//创建Date对象
	var hour=time.getHours();//当前小时
	if(hour<=11){
		document.write("good morning");
	}else if(hour<=18){
		document.write("good afternoon");
	}else{
		document.write("good night");
	}
</script>
```
5.3循环结构
```
<script type="text/javascript">
	var f;//华氏
	var c=0;//摄氏
	var count=1;//条目
	while(count<=10 && c<250){
		f = c*9/5.0 + 32;  //转换
		document.write("<tr><td>"+c+"</td><td>"+f+"</td></tr>");
		c=c+20;
		count++;

	}
</script>
```
```
<script type="text/javascript">
	//求1~20之间的偶数之和
	var i=1;
	var sum=20;
	while(i<=20){
		if(i%2!=0){
			i++;
			continue;//是奇数就结束本次循环，开始下一次循环
		}
		sum = sum + i;
		if(sum>30){
			document.write("当加到：" +i+ "时，累加之和达到30");
			break;//累加和超过30时，跳出循环

		}
		i++;//为偶数时计算后也要自增一下
	}
</script>
 ```
 
 
 
 
 
 
 
 
 
 
