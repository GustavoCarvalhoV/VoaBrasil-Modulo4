<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>ListaPassagem</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <link rel="stylesheet" href="./css/estilo.css">
    </head>
    
    <body>
        <header>
            <!--Inicio do Menu-->           
            <nav class="navbar navbar-expand-lg navbar-light bg-success">
                <a class="navbar-brand" href="#">VoaBrasil</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
                aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
                </button>
                    <div class="collapse navbar-collapse" id="navbarNav">
                        <ul class="navbar-nav ml-auto">
                            <li class="nav-item active">
                                <a class="nav-link" href="index.html">Home<span class="sr-only">(current)</span></a>
                            </li>
                            <li class="nav-item active">
                                <a class="nav-link" href="destino.html">Destino</a>
                            </li>
                            <li class="nav-item active">
                                <a class="nav-link" href="contato.html">Contato</a>
                            </li>
                            <li class="nav-item active">
                                <a class="nav-link" href="promocoes.html">Promoções</a>
                            </li>
                            <li class="nav-item active">
                                <a class="nav-link" href="cadastro.html">Cadastro</a>
                            </li>
                            <li class="nav-item active">
                                <a class="nav-link" href="usuario">Usuarios</a>
                            </li>
                            <li class="nav-item active">
                                <a class="nav-link" href="destino">Destinos</a>
                            </li>
                            <li class="nav-item active">
                                <a class="nav-link" href="passagem">Passagens</a>
                            </li>
                        </ul>
                    </div>
            </nav>
            <!--Fim do Menu--> 
        </header>
        
        <main>
            <div class="container mt-5">
                <h1 class="mb-4">Lista de Passagens</h1>
                
				<table class="table">
				  <thead>
				    <tr>
				      <th scope="col">Passagem</th>
				      <th scope="col">Data Ida</th>
				      <th scope="col">Data Volta</th>
				      <th scope="col">Horario</th>				     
				      <th scope="col">Preço</th>				     
				      <th scope="col">Ações</th>
				    </tr>
				  </thead>
				  <tbody>
				    <jstl:forEach items="${passagens}" var="p">
                    <tr>
                    	<td>${p.id}</td>
                        <td>${p.dataIda}</td>
                        <td>${p.dataVolta}</td>
                        <td>${p.horario}</td>
                        <td>${p.preco}</td>                 
                        <td>
                            <a href="passagem-edit?id=${p.id}" class="btn btn-primary mb-1" >Editar</a>

                            <a href="passagem-delete?id=${p.id}" onclick="return confirm('Deseja excluir ${p.id}?')" class="btn btn-danger mb-1">Excluir</a>
                        </td>

                    </tr>
                </jstl:forEach>          
				  </tbody>
				</table>     
            </div>

        </main>

        <br>

        <footer class="bg-dark text-white py-4">
            <div class="container">
                <div class="row">
                    <div class="col-lg-4 col-md-6 mb-4 mb-lg-0">
                        <h5>Contato</h5>
                        <p>Email: contato@voabrasil.com</p>
                        <p>Telefone: (XX) XXXX-XXXX</p>
                        <p>Site desenvolvido por Gustavo Carvalho</p>
                    </div>
                    <div class="col-lg-4 col-md-6 mb-4 mb-lg-0">
                        <h5>Redes Sociais</h5>
                        <ul class="list-unstyled">
                            <li><a href="https://www.facebook.com/">Facebook</a></li>
                            <li><a href="https://www.instagram.com/">Instagram</a></li>
                            <li><a href="https://twitter.com/">Twitter</a></li>
                        </ul>
                    </div>
                    <div class="col-lg-4 col-md-12">
                        <h5>Endereço</h5>
                        <p>Rua VoaBrasil, 100</p>
                        <p>Natal - RN</p>
                    </div>
                </div>
            </div>
        </footer>

        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.1/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </body>
</html>