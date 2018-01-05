<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Livros de Java, Android, iPhone, Ruby, PHP e muito mais - Casa do Código</title>
</head>
<body>
	<form:form action="${s:mvcUrl('PC#cadastrar').build()}" method="POST" commandName="produto" enctype="multipart/form-data">
	<!-- 1. Se for utilizado o FORM padrão do HTML, é necessário informar a classe/entidade no FORM:ERRORS
		 2. Se utilizado o FORM:FORM e setado o commandName devemos setar apenas o campo da classe/entidade-->
	<%--<form action="${s:mvcUrl('PC#cadastrar').build()}" method="POST"> --%>
		<div>
			<label>Titulo do Livro: </label>
			<form:input path="titulo" />
			<form:errors path="titulo"/>
		</div>
		<div>
			<label>Descrição: </label>
			<form:textarea rows="10" cols="20" path="descricao" />
			<form:errors path="descricao"/>
		</div>
		<div>
			<label>Páginas: </label>
			<form:input path="paginas" />
			<form:errors path="paginas"/>
		</div>
		<div>
			<label>Data de Lançamento</label>
			<form:input path="dataLancamento" />
			<form:errors path="dataLancamento"/>
		</div>
		<div>
			<c:forEach items="${tipos}" var="tipoPreco" varStatus="status">
				<div>
					<label>${tipoPreco}</label>
					<form:input path="precos[${status.index}].preco"/>
					<form:hidden path="precos[${status.index}].tipoPreco" value="${tipoPreco}"/>
				</div>
			</c:forEach>
		</div>
		<div>
		    <label>Sumário</label>
		    <input name="file" type="file" />
		</div>
		<button type="submit">Cadastrar</button>
	<%--</form> --%>
	</form:form>
</body>
</html>