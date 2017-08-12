## BOM（浏览器对象模型）
一个完整的BOM主要包括window，history，location，document等对象，其中window对象是整个BOM的顶层对象。
#### window对象
window对象处于对象模型的第一层，对于每个打开的窗口，系统都会自动将其定义为window对象。<br/>
1.常用的属性<br/>
`document`窗口总当前显示的文档对象<br/>
`history`history对象保存窗口最近加载的url<br/>
`location`当前窗口的url<br/>
`status`状态栏文本<br/>
2.常用的方法<br/>
（1）利用窗口对象的prompt，alert，confirm方法创建对话框<br/>
alert方法是用来向用户弹出一个警告，或提示下一步该怎么操作。
```javascript
<script type="text/javascript">
    var age=23;
    var name="zhang";
	  window.alert("我的名字是" +name+ "年龄是" +age);
</script>
```
prompt方法用于创建提示对话框，用户可以在对话框中输入信息，如密码等。
> 1.点击确定按钮，文本框中的内容将作为函数返回值
> 2.点击取消按钮，将返回null
```jvascript
<script type="text/javascript">
//若有两个参数时，第二参数作为输入框的默认提示
	var name=window.prompt("请输入昵称","Liuxiu");
	if(name!=null){
	window.alert("welcome" +name);
	}else{
	window.alert("你好");
	}
	
</script>
```
confirm方法创建确认对话框，用来确认用户针对某一问题的答案，必须经过用户同意操作才能完成。
> 返回值是boolean值
```javascript
<script type="text/javascript">
	var flag=window.confirm("确定删除吗？");
	if(flag){
		window.alert("执行删除操作");
	}else{
		window.alert("取消删除操作");
	}
</script>
```
（2）利用窗口对象的open，close方法打开，关闭窗口<br/>`window.open[URL],[窗口名称],[参数字符串]`
open方法第一个参数是新窗口的url，第二个参数是给新窗口的命名，第三个参数是设置新窗口的特征，这三个参数都可以省略。
> URL:可选参数，在窗口中要显示网页的网址或路径。如果省略这个参数，或者它的值是空字符串，那么窗口就不显示任何文档。<br/>
> 窗口名称：可选参数，被打开窗口的名称。<br/>
    1.该名称由字母、数字和下划线字符组成。<br/>
    2."_top"、"_blank"、"_self"具有特殊意义的名称。<br/>
       _blank：在新窗口显示目标网页<br/>
       _self：在当前窗口显示目标网页<br/>
       _top：框架网页中在上部窗口中显示目标网页<br/>
    3.相同 name 的窗口只能创建一个，要想创建多个窗口则 name 不能相同。<br/>
   4.name 不能包含有空格。<br/>
> 参数字符串：可选参数，设置窗口参数，各参数用逗号隔开。

![image](/img/1.jpg)
```javascript
<body>
<script type="text/javascript">
	var newWin;
	window.onload=function(){
		newWin=window.open("Lprompt.html","广告");
	}
</script>
<a href="javascript:newWin.close()">关闭广告</a>
</body>
```
(3)window对象有类似闹钟的两个方法：setTimeout方法和setInterval方法。
```javascript
<script type="text/javascript">
    var dh; 
	function start() {
		dh=setInterval("change()",1000);
	}
	var i=1;//保持动画当前播放状态的静态页面索引
	function change(){
		if(i<4){
			i++;
		}else{
			i=1;//播放到最后一页时从头播放
		}
		document.getElementById("pic").src=i+".jpg";

	}
	function stop(){
		clearInterval(dh);//清除反复执行
	}
</script>
<body>
<p>
	<img src="1.jpg" id="pic">
</p>
<p>
	<input type="button" value="开始" onclick="start()">
</p>
<p>
	<input type="button" value="停止" onclick="stop()">
</p>
</body>
```
#### history对象
history对象保存了当前浏览器窗口打开文档的一个历史记录列表。
```javascript
	<br/>
	<a href="javasript:window.history.go(-1)">后退</a>//代替history.back()
	<a href="javasript:window.history.go(1)">前进</a>//代替history.forward()
```
#### location对象
location对象用于管理当前打开窗口的url信息，相当于浏览器的地址栏。<br/>
href属性：获取或设置网页地址<br/>
reload方法：重新加载当前页面，相当于浏览器的刷新按钮。
```javascript
<!-- 这是在当前窗口打开新的url，window.open()是重新打开新窗口
 -->
 <script type="text/javascript">
	function changeURL() {
		//获取选择的列表项的值
		var url=document.getElementById("sel").value
		//设置当前浏览器窗口的地址栏url
		window.location.href=url;
	}
</script>
<body>
<h3>
	友情链接：
	<select id="sel" onchange="changeURL()">
	<option >请选择</option>
		<option value="http:baidu.com">百度</option>
		<option value="http:taobao.com">淘宝</option>
	</select>
</h3>
</body>
```
## DOM(文档对象模型)
#### DOM概述
与BOM关注浏览器的整体不同，DOM(Document Object Model)只关注浏览器载入的文档。DOM把html文档看成元素，属性和文本组成的一颗倒立的树。
#### document对象
1.常用属性<br/>
`bgColor`页面的背景颜色<br/>
`fgColor`文本的前景颜色<br/>
`title`页面标题
```javascript
<body>
ducument对象
<script type="text/javascript">
	//页面标题
	document.title="document属性";
	//页面的背景颜色
	document.bgColor="blue";
	//文本的前景颜色
	document.fgColor="white";
</script>
</body>
```
2.常用方法<br/>
（1）document.getElementById(id)：通过id访问页面元素（返回的是对象，无符合的则为null）
```javascript
<script type="text/javascript">
	function setContent() {
		var obj=document.getElementById("content");
		obj.innerHTML="<h2>动态添加内容</h2>";
	}
</script>
<body>
<div id="content"></div>
<input type="button" value="添加内容" onclick="setContent()"/>
</body>
```
> 几乎所有的元素对象都有innerHTML属性。innerHTML属性是一个字符串，用来设置或获取位于对象起始和结束标签之间的HTML内容。

在此基础之上，增加能够动态添加样式的功能
```javascript
<script type="text/javascript">
	function setContent() {
		var obj=document.getElementById("content");
		obj.innerHTML="<h2>动态添加内容</h2>";
	}
	function setStyle(){
		var obj=document.getElementById("content");
		obj.style.borderColor="red";
		obj.style.borderStyle="solid";
		obj.style.borderWidth="2px";
		obj.style.color="orange";
	}
</script>
<body>
<div id="content"></div>
<input type="button" value="添加内容" onclick="setContent()"/>
<input type="button" value="修改样式" onclick="setStyle()"/>
</body>
```
(2)getElementsByName(name):通过name访问页面元素（返回的是一个数组对象，无符合则返回空数组）
```javascript
<script type="text/javascript">
	function check() {
		var n1=document.getElementById("allCb");
		//getElementsByName返回的是一个数组对象
		var n2=document.getElementsByName("item");
		for(var i=0;i<n2.length;i++){
			n2[i].checked=n1.checked;
		}
	}
</script>
<body>
<input type="checkbox" id="allCb" onclick="check()"/>全选
<input type="checkbox" name="item"/>百度
<input type="checkbox" name="item"/>新浪
<input type="checkbox" name="item"/>淘宝
</body>
```
（3）getElementsByTagName(tagname):通过标签名访问页面元素（返回的是指定标签名的对象的集合，无符合则返回空数组）
#### 节点信息
利用parseNode属性获取父节点，childNodes属性获取所有子节点（nodeType为1时是元素节点，2为属性节点，3是文本节点）
```javascript
<script type="text/javascript">
	function getChildren() {
	var div1=document.getElementById("test");
	var ps=div1.childNodes;
	for(var i=0;i<ps.length;i++){
		if(ps[i].nodeType==1){//如果子节点是元素节点
			ps[i].style.color="blue";
		}
	}
	}
	function getParent() {
		var div1=document.getElementById("test");
		var parent = div1.parentNode;
		parent.style.backgroundColor="pink";
	}
</script>
<body>
<div id="test">
	<p>第一个段落</p>
	<p>第二个段落</p>
</div>
<input type="button" value="子节点" onclick="getChildren()"/>
<input type="button" value="父节点" onclick="getParent()"/>
</body>
```
动态添加和删除节点
```javascript
<script type="text/javascript">
	var newNode=document.createElement("div");
	newNode.className="con";
	newNode.innerHTML="这是一个新的节点";
	function insertNode(){
		//增加body标签的子节点
		document.body.appendChild(newNode);
	}
	function removeCreateNode(){
		//删除bidy标签的子节点
		document.body.removeChild(newNode);
	}
</script>
<body>
<input type="button" value="添加" onclick="insertNode()"/>
<input type="button" value="删除" onclick="removeCreateNode()"/>
</body>
```
