<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Livros de Java, Android, iPhone, Ruby, PHP e muito mais - Casa do Código</title>
</head>
<body>
	<h1>Lista de produtos</h1>
	<p>${success}</p>
	<table>
		<tr>
			<td>Título</td>
			<td>Descrição</td>
			<td>Paginas</td>
		</tr>
			<c:forEach var="produto" items="${produtos}">
				<tr>
					<td><a href="produtos/detalhe?id=${produto.id}">${produto.titulo}</a></td>
<%-- 					<td><a href="${s:mvcUrl('PC#detalhe').arg(0,produto.id).build() }">${produto.titulo}</a></td> --%>
					<td>${produto.descricao}</td>
					<td>${produto.paginas}</td>
				</tr>
			</c:forEach>
	</table>
</body>
</html>