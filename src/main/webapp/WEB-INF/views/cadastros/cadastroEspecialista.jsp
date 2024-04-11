<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro Tutor</title>

<spring:url value="/cadastros/cadastroVeterinario" var="cadastroVeterinario"></spring:url>

<link href="/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
	<jsp:include page="../comum/Navbar.jsp"></jsp:include>
	<div class="container">
		<h2 align="center">Cadastrar Tutor</h2>
		<form:form modelAtributte="cadastros" action="${cadastroVeterinario}">
			<div class="form-row">
				<input type="hidden" name="id" id="id" value="${VeterinarioDto.id}">
				<div class="form-group col-md-6">
					<label for="nome">Nome</label>
					<input type="text" class="form-control" name="nome" id="nome" value="${VeterinarioDto.nome}">
				</div>
				<div class="form-group col-md-6">
					<label for="sobrenome">Sobrenome</label>
					<input type="text" class="form-control" name="sobrenome" id="sobrenome" value="${VeterinarioDto.sobrenome}">
				</div>
			</div>

			<div class="form-row">
				<div class="form-group col-md-4">
					<label for="cpf">CPF</label>
					<input type="text"	class="form-control" name="cpf" id="cpf" value="${VeterinarioDto.cpf}">
				</div>
				<div class="form-group col-md-4">
					<label for="crmv">CRMV</label>
					<input type="text" class="form-control" name="crmv" id="crmv" value="${VeterinarioDto.crmv}">
				</div>
				<div class="form-group col-md-4">
					<label for="telefone">Telefone</label>
					<input type="tel" class="form-control" name="telefone" id="telefone" value="${VeterinarioDto.telefone}">
				</div>
			</div>
			<div class="form-row">
				<input type="hidden" name="enderecoId" id="enderecoId" value="${VeterinarioDto.enderecoId}">
				<div class="form-group col-md-10">
					<label for="logradouro">Endereço</label>
					<input type="text" class="form-control" name="logradouro" id="logradouro" value="${VeterinarioDto.logradouro}">
				</div>
				<div class="form-group col-md-2">
					<label for="cep">CEP</label>
					<input type="text" class="form-control" name="cep" id="cep" value="${VeterinarioDto.cep}">
				</div>
			</div>

 			<div class="form-row">

				<div class="form-group col-md-4">
					<label for="estados">Estado</label>
					<input type="hidden" name="estado" id="estado" value="${VeterinarioDto.estadoId}"> 
					<select	class="form-control" name = "estado" id="estado">
						<option selected>Escolha o estado</option>
						<c:forEach var="estado" items="${estados}">
							<option value="${estado.id}">${estado.estado}</option>
						</c:forEach>
					</select>
				</div>

				<div class="form-group col-md-4">
					<label for="cidades">Cidade</label> <input type="hidden" name="cidade"
						id="cidade" value="${VeterinarioDto.cidadeId}"> <select
						class="form-control" name="cidade" id="cidade">
						<option selected>Escolha a cidade</option>
						<c:forEach var="cidade" items="${cidades}">
							<option value="${cidade.id}">${cidade.cidade}</option>
						</c:forEach>
					</select>
				</div>
				<div class="form-group col-md-4">
					<label for="bairro">Bairro</label>
					<input type="text" class="form-control" name="bairro" id="bairro" value="${VeterinarioDto.bairro}">
				</div>
			</div>
			<button type="submit" class="btn btn-primary">Cadastrar</button>
			<a href="/" type="submit" class="btn btn-secondary">Voltar</a>
		</form:form>
	</div>

	<script type="text/javascript" src="/js/jquery-3.5.1.min.js"></script>
	<script type="text/javascript" src="/js/bootstrap.min.js"></script>
</body>
</html>