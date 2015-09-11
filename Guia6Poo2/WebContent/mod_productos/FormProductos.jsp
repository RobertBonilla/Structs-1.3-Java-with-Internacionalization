<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/top-tags.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><bean:message
key="label.productoTitle"/></title>
<script type="text/javascript" language="JavaScript">
function nuevo(){
document.forms[0].method.value ="agregar"
document.forms[0].submit();
}
function update(){
document.forms[0].method.value ="actualizar"
document.forms[0].submit();
}
function remove(){
document.forms[0].method.value ="eliminar"
document.forms[0].submit();
}
function show(){
document.forms[0].method.value ="mostrar"
document.forms[0].submit();
}
</script>
</head>
<body>
<html:form action="/productos" method="get">
<table>
<tr><td><bean:message
key="label.codigo"/></td><td><html:text property="codigo"/></td>
</tr>
<tr><td><bean:message
key="label.producto"/></td><td><html:text property="nombreproducto"/></td>
</tr>
<tr><td><bean:message
key="label.precio"/></td><td><html:text property="precio"/></td>
</tr>
<td><bean:message
key="label.proveedor"/></td>
<td>
<logic:present name="proveedor">
<html:select property="provee" styleClass="textBox">
<html:options collection="proveedor" property="codigo"
labelProperty="nombre" />
</html:select>
</logic:present>
</td>
</tr>
<tr>
<td><bean:message
key="label.categoria"/></td>
<td>
<logic:present name="categoria">
<html:select property="cat" styleClass="textBox">
<html:options collection="categoria" property="codigo"
labelProperty="nombre" />
</html:select>
</logic:present>
</td>
</tr>
<tr><td><bean:message
key="label.existencia"/></td><td><html:text property="existencia"/></td>
</tr>
<tr>
<td colspan="2">
<html:button property="ingresar"
onclick="nuevo()"><bean:message key="label.agregar"/></html:button>
<html:button property="actualizar"
onclick="update()"><bean:message key="label.actualizar"/></html:button>
<html:button property="eliminar"
onclick="remove()"><bean:message key="label.eliminar"/></html:button>
<html:button property="mostrar"
onclick="show()"><bean:message key="label.mostrar"/></html:button>
<html:hidden property="method" value=""/>
</td>
</tr>
</table>
</html:form>
<logic:present name="mensaje">
<logic:equal name="mensaje" value="Exito">
<bean:message key="label.insert"/>
</logic:equal>
<logic:equal name="mensaje" value="Fracaso">
<font color="red">
<bean:message key="error.insert"/>
</font>
</logic:equal>
</logic:present>
<logic:present name="update">
<logic:equal name="update" value="Exito">
<bean:message key="label.update"/>
</logic:equal>
<logic:equal name="update" value="Fracaso">
<font color="red">
<bean:message key="error.update"/>
</font>
</logic:equal>
</logic:present>
<logic:present name="delete">
<logic:equal name="delete" value="Exito">
<bean:message key="label.delete"/>
</logic:equal>
<logic:equal name="delete" value="Fracaso">
<font color="red">
<bean:message key="error.delete"/>
</font>
</logic:equal>
</logic:present>
<center>
<logic:present name="producto">
<display:table name="producto">
<display:column property="idproducto" title="Codigo" />
<display:column property="nombreproducto" title="Nombre"/>
<display:column property="precio" title="Precio"/>
<display:column property="existencias" title="Existencias"/>
<display:column property="idproveedor" title="Proveedor"/>
<display:column property="idcategoria" title="Categoria"/>
</display:table>
</logic:present>
</center>
<center>
<html:link forward="menu1">Regresar al Menu</html:link>
</center>
</body>
</html>