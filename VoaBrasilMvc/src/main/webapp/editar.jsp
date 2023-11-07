<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>EditarUsuario</title>
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
                <h1 class="mb-4">Atualizar Usuário</h1>
                <form action="./usuario-update">
                    <div class="mb-3">                        
                        <input type="hidden" class="form-control" id="id" name="id" value="${usuario.id}">
                    </div>             
                    <div class="mb-3">
                        <label for="nome" class="form-label">Nome:</label>
                        <input type="text" class="form-control" id="nome" placeholder="Digite seu nome" name="nome" value="${usuario.nome}"  required>
                    </div>
                    <div class="mb-3">
                        <label for="sobrenome" class="form-label">Sobrenome:</label>
                        <input type="text" class="form-control" id="sobrenome" placeholder="Digite seu sobrenome" name="sobrenome" value="${usuario.sobrenome}" required>
                    </div>
                    <div class="mb-3">
                        <label for="rg" class="form-label">RG:</label>
                        <input type="text" class="form-control" id="rg" placeholder="Digite seu RG" name="rg" value="${usuario.rg}" required>
                    </div>
                    <div class="mb-3">
                        <label for="cpf" class="form-label">CPF:</label>
                        <input type="text" class="form-control" id="cpf" placeholder="Digite seu CPF" name="cpf" value="${usuario.cpf}" required>
                    </div>
                    <div class="mb-3">
                        <label for="contato" class="form-label">Contato:</label>
                        <input type="text" class="form-control" id="contato" placeholder="Digite seu contato" name="contato" value="${usuario.contato}" required>
                    </div>
                    <div class="mb-3">
                        <label for="email" class="form-label">E-mail:</label>
                        <input type="email" class="form-control" id="email" placeholder="exemplo@email.com" name="email" value="${usuario.email}" required>
                    </div>
                    <div class="mb-3">
                        <label for="senha" class="form-label">Senha:</label>
                        <input type="password" class="form-control" id="senha" placeholder="Digite sua senha" name="senha" value="${usuario.senha}" required>
                    </div>
                                                           
                    <button type="submit" class="btn btn-success">Confirmar</button>
                </form>
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