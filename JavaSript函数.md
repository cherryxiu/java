## JavaScript的函数
#### 1.1定义函数
```
function 函数名（形式参数1，形式参数2，...形式参数n){
}
```
#### 1.2调用函数
```JavaScript
<script type="text/javascript">
//定义函数
	function getArea(width,height) {
		var result=width*height;
		document.write("面积是：" +result);
	}
</script>
<body>
<h2>
//调用函数
	宽度是3，高度是4<script type="text/javascript">
		getArea(3,4);
	</script>
  ```
  #### 1.3函数的参数
    参数的特殊性都依赖于JavaScript对函数的实现。在函数调用时，一个arguments对象就会被创建，它只能使用在函数体内，并用来
    管理函数的实际参数。
  > 1.函数声明了参数，调用时也可以不传递参数，这是在c#中会出现编译错误的。<br/>
  > 2.不管函数声明时有多少个参数，调用函数时也可传递若干个参数值给函数，并且实际传递的参数值还可以在函数内使用。
  ```JavaScript
  <script type="text/javascript">
	function getTotal() {
		var count;//人数
		var sum = 0;//总工资
		//每调用一次函数，自动创建arguments对象
		count=arguments.length;//数组，length属性；string，length方法
		for (var i = 0;i<count;i++) {
			sum += arguments[i];
		}
		document.writeln("总人数是：" +count+ "总工资是：" +sum);
	}
</script>
<body>
<!-- 调用函数 -->
<h2>
	A公司：
	<script type="text/javascript">
		getTotal(2000,3000,4000);
	</script>
</h2>
<h2>
	B公司：
	<script type="text/javascript">
		getTotal(1000,1000,1000);
	</script>
</h2>
</body>
```
  #### 1.4函数的返回值
  `return 返回值`在函数体内需要返回值时使用，执行到return这条语句后，函数就停止执行。在调用函数时，可以把返回值赋值给变量
  ```JavaScript
  <script type="text/javascript">
	//创建有返回值的函数
	function getArea(width,height) {
		if(width<=0 || height<=0){
				return;//中断循环的作用
		}else{
		var result=width*height;
		return result;
		}
	}
</script>
<body>
<h2>
	宽度是3，高度是4，面积是
<script type="text/javascript">
	//调用有返回值的函数
	var area=getArea(3,4);
	document.write(area);
</script>
</h2>

</body>
```

#### 1.5匿名函数
```javascript
<script type="text/javascript">
	//匿名函数
	function (width,height){
		document.write("面积是：" + width*height);
	} 
</script>
<body>
<!-- <script type="text/javascript">
	//方法一：匿名函数的调用
	(function   (width,height){
		document.write("面积是：" + width*height);
	} )(3,4);
</script> -->
<script type="text/javascript">
//方法二：函数是一种数据类型，称为function类型,可以赋值给变量
	var area=function (width,height){
		document.write("面积是：" + width*height);
	}
	area(3,4);
</script>
</body>
```
#### 1.6变量的作用域
全局变量：在外部声明的，可以在任何地方包含函数的内部使用。<br/>
局部变量：在函数体内声明的，只能在函数体内使用。<br/>
如果全局变量和局部变量出现重名的情况，局部变量优先，即无论局部变量的值怎么改变，全局变量的值都不会改变。

#### 1.7系统函数
`parseInt()函数`将字符串转换为整数。它从字符串开头开始解析，在第一个非整数位置停止解析并返回前面读到的所有整数。如果字符串不是以
整数开头，将返回NaN(Not a Number：非数字值)<br/>
"150cats"-150;   "cats"-NaN;   "6"-6;    "-6"-6;   "6.6"-6<br/>
`parseFloat()函数`与parseInt函数类似，返回一个浮点数<br/>
`isNaN()函数`用于判断参数是否是NaN（不是数字）
```javascript
<script type="text/javascript">
	function calc() {
		// 根据id属性获取文本框后，使用value属性进一步得到内容
		var m1=document.getElementById("n1").value;
		var m2=document.getElementById("n2").value;
		if(m1.trim(n1) != "" && m2.trim(n2) != ""){//trim()修建两边空格，判断是否已经输入内容
			if(!isNaN(m1) && !isNaN(m2)){//判断是否为数值
				document.getElementById("result").value=parseFloat(m1) + parseFloat(m2);//求和
			}else{
				document.write("请输入数值类型");
			}
		}else{
			document.write("请输入两个操作数");
		}
	}
</script>
<body>
<input type="text" id="n1" />+
<input type="text" id="n2" />=
<input type="text" id="result" /><br/>
<input type="button" value="计算" onclick="calc()"/>
</body>
```
`eval()函数`运行以字符串形式表示的JavaScript代码，并返回执行代码串后的结果。(evaluate)
```javascript
<script type="text/javascript">
	function calc(){
		var express=document.getElementById("info").value;
		var result=eval(express);//运行以字符串形式表达的js代码串，并返回执行代码串后的结果
		alert("输入结果是：" +result);
	}
</script>
<body>
<input type="text" id="info"/><br/>
<input type="button" value="计算" id="btn" onclick="calc()" />
</body>
```
