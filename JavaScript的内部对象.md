## JavaScript的内部对象
#### Object对象
Object对象提供了一种创建自定义对象的简单方式，不需要程序员再次定义构造函数。
```javascript
<body>
<script type="text/javascript">
	var person=new Object();
	person.name="tony";
	person.age=14;
	function getAttr(attr){
		alert(person[attr]);
	}
	getAttr("name");
	getAttr("age");
</script>
```
### Date对象
通过创建Date对象，可以获取计算机中的时间。
```javascript
<script type="text/javascript">
//利用date制作时钟
	function shoWTime() {
		var today=new Date();
		var year=today.getFullYear();//获取年
		var month=today.getDate();//获取月
		var day=today.getMonth();//获取日
		var hh=today.getHours();//获取小时
		var mm=today.getMinutes();//获取分钟
		var ss=today.getSeconds();//获取秒数
		document.getElementById("myClock").innerHTML=year +"年"+ month +"月"+ day +"日"
    + hh +"时"+ mm +"分"+ ss +"秒";
	}
	window.setInterval("shoWTime(),1000");
	window.onload=shoWTime;
</script>
<body>
<span id="myClock"></span>
</body>
```
Date对象制作倒计时特效
```javascript
<body>
<span id="days">
</span>
<script type="text/javascript">
// HTML 文档是由浏览器从上到下依次载入的，为避免 JavaScript 代码操作 HTML 元素时，HTML 元素还未载入而报错（对象不存在），
//因此需要将这段代码写到 HTML 元素后面
	//利用date制作倒计时
	var now=new Date();//获取当前时间
	var year=now.getFullYear();
	var future=new Date("December 25,"+year);
	var diff=future.getTime()-now.getTime();//计算圣诞节与现在的时间差,毫秒
	var d=parseInt(diff/(1000*60*60*24));//转换为天数，取整
	document.getElementById("days").innerHTML="距离" +year+ "年圣诞节还剩" +d+ "天"; 
</script>
</body>
```
#### image对象
```javascript
<script type="text/javascript">
	var picObj=new Image();
	picObj.src="2.jpg";
	function changePc(){
		//两边都是src
		document.getElementById("pic").src=picObj.src;
	}
</script>
<body>
<img src="1.jpg" id="pic" width="200px" height="200px" />
<input type="button" value="切换" onclick="changePc()"/>
</body>
```
#### Math对象
不需要使用new关键字创建Math对象的实例。
```javascript
<script type="text/javascript">
	var number=Math.floor(1+10*Math.random());//获取1到10之间的整数
	function guess(){
		var num=document.getElementById("d1").value;
		if(num.trim()!="" && !isNaN(num)){//确认时输入正确数值
			var input=Math.floor(num);//向下取整
			//是否等于是“==”不是"="
				if(number==input){
				alert("正确");
				}else if(number>input){
					alert("猜小啦");
				}else{
					alert("猜大啦");
				}
		}else{
			alert("请输入正确格式的数");
		}
		
	}
</script>
<body>
请输入1-10之间的数字：<input type="text" name="text" id="d1"><br/>
<input type="button" value="确定" onclick="guess()"/>
</body>
```
#### 数组
数组就是一个变量来表示一组数据的集合。它用于实现对这组数据的统一管理，数组中的每一个数据也叫数组的一个元素。<br/>
1.数组列表
`var arr=["happy",12,2.3]`
2.Array对象<br/>
第一种：`var arr=new Array()`创建了一个Array对象，数组中初始的元素个数为0，可以使用`arr[0]=1;arr[1]=2.3;`的
方式添加新元素<br/>
第二种：`var arr=new Array(4);arr[4]="hello;`表示创建具有指定大小的Array对象，当用户访问的下标超出指定长度
时，数组将自动扩展。<br/>
第三种：`var arr=new Array(2,2.3,"book");`用指定的元素列表去初始化Array对象，数组的长度是设置的元素的数目。
```javascript
<script type="text/javascript">
	var arr=new Array(2,2.3,"book");
	arr.sort();//排序
	for(var i=0;i<arr.length;i++){
		document.write(i+":"+arr[i]+"<br/>");
	}
</script>
```
#### String对象
属性：length属性常用<br/>
方法：
```
charAt:返回字符串对象中指定索引处的字符，索引从0开始；
indexOf：返回某个字符串在某个字符串中首次出现的位置，不存在则返回-1；
substr：从指定索引位置开始截取指定长度的字符串，`mstanford.substr(2,3)`表示从索引2开始截取长度为3；
substring：返回指定索引范围内的字符串；
toLowerCase：把字符串转换为小写；
toUpperCase：把字符串转换为大写；
split：返回按照指定分割符拆分的若干字符串数组；
```
## 创建对象
定义新的JavaScript类，需要编写一个函数，函数名当做对象的类名称，函数体定义其属性和方法。当使用new关键字调
用该函数时，该函数创建新对象并返回对象的引用。例如，如果调用Book()函数，它将返回新Book对象的引用面积一个Book
类的实例。所以说在JavaScript中创建一个函数的时候，相当于创建了一个类，即JavaScript中的函数也是对象。
```javascript
<script type="text/javascript">
	//创建Book类型
	function Book(name,author,price) {
		this.name=name;
		this.author=author;
		this.price=price;
		this.show=function (){
			alert("书名"+this.name+"作者是"+this.author+"价格是"+this.price);
		}
	}
	var book=new Book("java","ll","21");
	book.show();
</script>
```
## 对象常用语句
#### with语句(简化对象.属性)
```javascript
<body>
<script type="text/javascript">
//利用date制作时钟
	function shoWTime() {
		var today=new Date();
		with(today){
		var year=getFullYear();//获取年
		var month=getDate();//获取月
		var day=getMonth();//获取日
		var hh=getHours();//获取小时
		var mm=getMinutes();//获取分钟
		var ss=getSeconds();//获取秒数
		}
		document.getElementById("myClock").innerHTML=year +"年"+ month +"月"
		+ day +"日"+ hh +"时"+ mm +"分"+ ss +"秒";
	}
	window.setInterval("shoWTime(),1000");
	window.onload=shoWTime;
</script>
<span id="myClock"></span>
</body>
```
#### for...in语法
```javascript
<script type="text/javascript">
	function Person(){
		this.name="liu";
		this.age=22;
		this.gendar="nv";
	}
	var person=new Person();
	var info="",prop;
	/*----------------
  for(prop in person){
		info+=prop+"  ";
	}
	//结果是：name age gendar
  -------------------*/
	for(prop in person){
		info+=person[prop]+"  ";
	}
	//liu 22 nv
	document.write(info);
</script>
```
