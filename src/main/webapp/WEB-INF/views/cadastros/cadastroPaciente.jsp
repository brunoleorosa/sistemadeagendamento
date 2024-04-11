<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro Pet</title>

<spring:url value="/cadastros/cadastroPet" var="cadastroPet"></spring:url>

<link href="/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
	<jsp:include page="../comum/Navbar.jsp"></jsp:include>
	<div class="container">
		<h2 align="center">Cadastrar Pet</h2>
		<form:form modelAttribute="cadastros" action="${cadastroPet}">
			<h4>Pet</h4>
			<hr>
			<div class="form-row">
				<input type="hidden" name="id" id="id" value="${petDto.id}">
				<div class="form-group col-md-6">
					<label for="nome">Nome</label>
					<input type="text" class="form-control" name="nome" id="nome" value="${petDto.nome}">
				</div>
				<div class="form-group col-md-6">
					<label for="especie">Espécie</label>
					<input type="text" class="form-control" name="especie" id="especie" value="${petDto.sobrenome}">
				</div>
			</div>
			<div class="form-row">
				<div class="form-group col-md-6">
					<label for="raca">Raça</label>
					<input type="text" class="form-control" name="raca" id="raca" value="${petDto.raca}">
				</div>
				<div class="form-group col-md-6">
					<label for="idade">Idade</label>
					<input type="text" class="form-control" name="idade" id="idade" value="${petDto.idade}">
				</div>
			</div>
			
			<br><h4>Tutor</h4>
			<hr>
			<div class="form-row">
				<input type="hidden" name="tutorId" id="tutorId" value="${petDto.tutorId}">
				<div class="form-group col-md-6">
					<label for="tutorNome">Nome</label>
					<input type="text" class="form-control" name="tutorNome" id="tutorNome" value="${petDto.tutorNome}">
				</div>
				<div class="form-group col-md-6">
					<label for="tutorSobrenome">Sobrenome</label>
					<input type="text" class="form-control" name="tutorSobrenome" id="tutorSobrenome" value="${petDto.tutorSobrenome}">
				</div>
			</div>
			<div class="form-row">
				<div class="form-group col-md-6">
					<label for="tutorCPF">CPF</label>
					<input type="text" class="form-control" name="tutorCPF" id="tutorCPF" value="${petDto.tutorCPF}">
				</div>
				<div class="form-group col-md-6">
					<label for="tutorEmail">Email</label>
					<input type="text" class="form-control" name="tutorEmail" id="tutorEmail" value="${petDto.tutorEmail}">
				</div>
			</div>
			<div class="form-row">
				<div class="form-group col-md-6">
					<label for="tutorTelefone">Telefone</label>
					<input type="text" class="form-control" name="tutorTelefone" id="tutorTelefone" value="${petDto.tutorTelefone}">
				</div>
			</div>
			
			<br><h4>Endereço</h4>
			<hr>
			<div class="form-row">
				<div class="form-group col-md-9">
					<label for="logradouro">Endereço</label>
					<input type="text" class="form-control" name="logradouro" id="logradouro" value="${petDto.logradouro}">
				</div>
				<div class="form-group col-md-3">
					<label for="cep">CEP</label>
					<input type="text" class="form-control" name="cep" id="cep" value="${petDto.cep}">
				</div>
			</div>
			<div class="form-row">
				<div class="form-group col-md-4">
					<label for="estados">Estado</label>
					<input type="hidden" name="estado" id="estado" value="${petDto.estadoId}"> 
					<select	class="form-control" name = "estado" id="estado">
						<option selected>Escolha o estado</option>
						<c:forEach var="estado" items="${estados}">
							<option value="${petDto.estadoId}">${estado.estado}</option>
						</c:forEach>
					</select>
				</div>
				<div class="form-group col-md-4">
					<label for="cidades">Cidade</label>
					<input type="hidden" name="cidade" id="cidade" value="${petDto.cidadeId}">
					<select	class="form-control" name="cidade" id="cidade">
						<option selected>Escolha a cidade</option>
						<c:forEach var="cidade" items="${cidades}">
							<option value="${cidade.id}">${cidade.cidade}</option>
						</c:forEach>
					</select>
				</div>
				<div class="form-group col-md-4">
					<label for="bairro">Bairro</label>
					<input type="text" class="form-control" name="bairro" id="bairro" value="${petDto.bairro}">
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