<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Produtos</h3>
<table>
	<thead>
		<tr>
			<th>Id</th>
			<th>Nome</th>
			<th>Descrição</th>
			<th>Preço</th>
		</tr>
	</thead>
<tbody>
<c:forEach items="${produtoList}" var="produto">
	<tr>
		<td>${produto.id }</td>
		<td>${produto.nome }</td>
		<td>${produto.descricao }</td>
		<td>${produto.preco }</td>
		<td>
			<form action="<c:url value="/produtos/${produto.id}"/>" method="GET">
				<button>Editar</button>
			</form>
		</td>
		<td>
			<form action="<c:url value="/produtos/${produto.id}"/>" method="POST">
				<button name="_method" value="DELETE">Remover</button>
			</form>
		</td>
	</tr>
</c:forEach>
</tbody>
</table>
<br>
<form action="<c:url value="/produtos/novo"/>" method="GET">
	<button type="submit">Novo Produto</button>
</form>
<form action="<c:url value="/produtos/busca"/>">
	<input id="busca" name="nome"/>
	<button type="submit">busca</button>
</form>
</body>
</html>