<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Passa Faixa</title>
    <!-- Incluindo Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-image: url('images/onda_home.jpeg');
            background-size: cover;
            text-align: center;
            color: white; /* Alterando a cor do texto para branco */
            padding-top: 50px;
        }
        .container {
            background-color: rgba(0, 0, 0, 0.5); /* Adicionando uma cor de fundo semi-transparente */
            padding: 20px;
            border-radius: 10px;
        }
    </style>
</head>
<body>
    <div class="container">
        <a href="/Projeto_CalculaOnda" class="mb-3">
            <h2>Voltar para a tela Inicial</h2>
        </a>
        <canvas id="graf_emitido" width="400" height="200"></canvas>
        
    </div>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js" integrity="sha512-v2CJ7UaYy4JwqLDIrZUI/4hqeoQieOmAZNXBeQyjo21dadnwR+8ZaIJVT8EE2iyI61OV8e6M8PP2/4hpQINQ/g==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>

    <script>
        var jsonEmitido = <%= request.getAttribute("emitido") %>
    </script>
    <script src="js/index.js" charset="UTF-8"></script>
    <script src="js/graph.js" charset="UTF-8"></script>
</body>
</html>