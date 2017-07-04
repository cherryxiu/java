JavaScript是基于对象，采用事件驱动的脚本语言。通过鼠标或按键在浏览器窗口或网页元素上的执行的操作，称之为事件。
#### onclick事件
(1)在事件源对象所对应的html标签上增加一个要处理的事件属性，让事件属性值等于事件的函数名或程序代码
```javascript
<p onclick="this.style.fontSize='30px'">事件与程序的绑定</p>
```
或把处理事件的程序代码封装到函数中
```javascript
<script type="text/javascript">
	function changeSize() {
		//不需要加value，不是取值
		var obj=document.getElementById("txt");
		//点击过后字体改变
		obj.style.fontSize="30px";
	}
</script>
<body>
<p id="txt" onclick="changeSize()">hello world</p>
</body>
```
（2）直接在JavaScript代码中设置元素对象的事件属性，让事件属性值等于处理该事件的函数名或程序代码。
```javascript
<script type="text/javascript">
	function changeSize() {
		var obj=document.getElementById("txt");
		obj.style.fontSize="30px";
	}
	document.getElementById("txt").onclick=changeSize;
</script>
<body>
<p id="txt">hello world</p>
</body>
```
或用匿名函数来简化
```javascript
<script type="text/javascript">
	document.getElementById("txt").onclick=function (){
		this.style.fontSize="30px";
	}
</script>
<body>
<p id="txt">hello world</p>
</body>
```

#### onload和onunload事件
onload事件会在页面加载完成后立即发生。
```javascript
//onload事件（只在IE有效）
 <body onload="window.status='欢迎来到淘宝'">
</body> 
//onunload事件
<body onunload="alert('触发了onload事件')">
</body>
```
#### onblur事件
onblur事件是指光标或者焦点离开元素后触发的事件。
```javascript
<script type="text/javascript">
//验证用户输入的密码长度是否在6位以上
	function checkPwd() {
		var pwd=document.getElementById("txtpwd").value;
		if(pwd>=6){
			alert("输入密码正确");
		}else{
			alert("输入密码错误");
		}
	}
</script>
<body>
<p>
	请输入密码<input type="text" id="txtpwd" onblur="checkPwd()">
</p>
</body>
```
#### onchange事件
onchange事件通常指输入框的值发生了变化或者改变下列列表框的选项会触发onchange事件。
```javascript
<script type="text/javascript">
	function changeLink(obj) {
		var site=obj.value;
		if(site!="请选择"){
			window.open(site);
		}
	}
</script>
<body>
友情链接：<select onchange="changeLink(this)">
	<option value="请选择">请选择</option>
	<option value="http://www.taobao.com">淘宝</option>
	<option value="http://www.baidu.com">百度</option>
</select>
</body>
```

#### onmouseover和onmouseout事件
是指鼠标移入，移出页面元素时触发的事件。
```javascript
<marquee direction="right" onmouseover="stop()" onmouseout="start()">
	<img src="1.jpg"/>
</marquee>
```
#### 浏览器默认的事件处理程序
首先为事件处理程序创建函数，然后将这个函数与form标签的onsubmit事件进行绑定。
```
<form action="info.html" onsubmit="return check()"></form>
```





