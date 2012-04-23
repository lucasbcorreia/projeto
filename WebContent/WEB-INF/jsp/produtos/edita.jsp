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
<form action="<c:url value="/produtos/${produto.id}"/>" method="POST">
<fieldset>

<legend>Editar Produto</legend>

<label for="nome">Nome:</label>
<input id="nome" type="text" name="produto.nome" value="${produto.nome}"/>

<label for="descricao">Descrição:</label>
<textarea id="descricao" name="produto.descricao">${produto.descricao}</textarea>

<label for="preco">Preço:</label>
<input id="preco" type="text" name="produto.preco" value="${produto.preco}"/>

<button type="submit" name="_method" value="PUT">Enviar</button>

</fieldset>
</form>
<br>
<form action="<c:url value="/produtos"/>" method="GET">
	<button type="submit">Voltar</button>
</form>
</body>
</html>