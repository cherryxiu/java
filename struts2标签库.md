#### 导入标签库
```
<%@taglib uri="/struts-tags" prefix="s"%>
```
#### property标签
当value为null时，显示default的值(default可以不写)
```
<s:property value="msg" default="123"/>
```
#### if/elseif/else标签
```
<s:if test='sex=="男"'>男</s:if>
<s:elseif test='sex=="女"'>女</s:elseif>
<s:else>妖精</s:else>
```
#### iterator标签
```
<s:iterator var="singer" value="list" status="no">
<tr>
  <td align="center"><s:property value="#no.count"/></td>
  <td align="center"><s:property value="#singer.name"/></td>
  <td align="center"><s:property value="#singer.sex"/></td>
  <td align="center"><s:property value="#singer.date"/></td>
</tr>
</s:iterator>
```
使用`<s:debug>`标签获取提示信息，若为`Value Stack Contents`不需要使用`#`号，`Stack Contents`需要`#`号
#### 迭代map集合时
```
<s:iterator var="mapvar" value="map">
  <s:iterator var="album" value="#mapvar.key"><!-- 遍历key值 -->
  </s:iterator>
  <s:iterator var="singer" value="#mapvar.value"><!--遍历value值 -->
  </s:iterator>
</s:iterator>
```
