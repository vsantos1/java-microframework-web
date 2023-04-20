<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <Link rel="stylesheet" href="static/css/styles.css">
    <link rel="stylesheet" href="static/css/bootstrap.min.css">
    <link rel="icon" href="static/assets/icone.ico">
    <title>JSP - Pizzaria</title>
</head>
<body>

<nav class="navbar navbar-light bg-light px-3">
    <a class="navbar-brand" href="/">
        Pizzaria JSP
    </a>

    <li class="nav-item dropdown hover-shadow-soft rounded-pill">
        <a
                class="nav-link"
                id="navbarDropdown"
                role="button"
                data-mdb-toggle="dropdown"
                aria-expanded="false"
        >
            <img src="static/assets/icon-menu.svg" width="32" alt="Menu">
        </a>
        <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
            <li>
                <a class="dropdown-item" target="_blank" href="https://wa.link/ygo5fc">Pedir pelo whatsapp</a>
            </li>
            <li>
                <a class="dropdown-item" href="/">Lorem</a>
            </li>
            <li>
                <a class="dropdown-item" href="/">Ipsum</a>
            </li>
            <li>
                <a class="dropdown-item" href="/termos">Termos de uso</a>
            </li>
            <li>
                <hr class="dropdown-divider"/>
            </li>
            <li>
                <a class="dropdown-item" href="/login">Entrar</a>
            </li>
            <li>
                <a class="dropdown-item" href="/cadastro">Cadastro</a>
            </li>
        </ul>
    </li>

</nav>


<ul id="list" class="card">
</ul>

<footer class="text-center text-start bg-light border-top w-100 position-fixed bottom-0 ">
    <div class="justify-content-center gap-5 bg-light shadow-3 p-4 ">
        <a href="/produtos" class="btn btn-light  rounded-circle" data-mdb-toggle="tooltip" data-mdb-placement="bottom"
           title="Produtos">
            <img src="static/assets/icon-food.svg" alt="Icone comida" width="32">
        </a>
        <a href="/avisos" class="btn btn-light rounded-circle" data-mdb-toggle="tooltip" data-mdb-placement="bottom"
           title="Avisos">
            <img src="static/assets/icon-notify.svg" alt="Icone notificacoes" width="32">
        </a>
        <a href="/pedido" class="btn btn-light rounded-circle" data-mdb-toggle="tooltip" data-mdb-placement="bottom"
           title="Detalhes do pedido">
            <img src="static/assets/icon-list.svg" alt="Icone pedidos" width="32">
        </a>
        <a href="/carrinho" class="btn btn-light rounded-circle" data-mdb-toggle="tooltip" data-mdb-placement="bottom"
           title="Carrinho">
            <img src="static/assets/icon-buy-cart.svg" alt="Icone carrinho" width="32">
        </a>

    </div>

    <div class="text-center text-white p-3 bg-primary">
        &copy; 2023 Copyright, criado por
        <a class="text-white link-opacity-50-hover" href="https://github.com/vsantos1">@vsantos1</a>,
        entre em contato via email<a class="text-white text-decoration-none" href="mailto:vsantos1.dev@gmail.com"> saiba
        mais</a>.
    </div>

</footer>

</body>


<script src="static/js/jquery.js"></script>

<script src="static/js/mdb.min.js"></script>

<script src="static/js/main.js"></script>

</html>