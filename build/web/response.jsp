<!DOCTYPE html>
<html lang="pt-br">
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<jsp:include page="WEB-INF/head.jsp"></jsp:include>
<body>
    <div class="container">
        <a href="/Projeto_CalculaOnda" class="mb-3 btn btn-dark">
            Voltar para a tela Inicial
        </a>
        
        <section class="result-section">
            <div class="result-box">
                <h1>Resultado</h1>
                <div class="result-values">
                    <p>Frequência Fundamental <span>${frequenciaFundamental} Hz</span></p>
                
                    <c:choose>
                        <c:when test="${tipoCanal == 'bx'}">
                            <p>Frequência Corte: <span>${frequenciaInicial} Hz</span></p>
                        </c:when>
                        <c:otherwise>
                            <p>Frequência Inicial <span>${frequenciaInicial} Hz</span></p>
                            <p>Frequência Final: <span>${frequenciaFinal} Hz</span></p>
                        </c:otherwise>
                    </c:choose>
                    
                </div>
            </div>
        </section>
        <section class="chart-section">
            <div class="highlighted-chart">
                <h2>Sinal de Entrada</h2>
                <canvas id="graf_emitido" width="600" height="400"></canvas>
            </div>
            <div class="highlighted-chart">
                <h2>Sinal de Saída</h2>
                <canvas id="graf_saida" width="600" height="400"></canvas>
            </div>
            <div class="side-by-side-charts">
                <div>
                    <h2>Espectro da Amplitude de Entrada</h2>
                    <canvas id="graf_ampli_entrada" width="300" height="200"></canvas>
                </div>
                <div>
                    <h2>Espectro da Fase de Entrada</h2>
                    <canvas id="graf_fase_entrada" width="300" height="200"></canvas>
                </div>
            </div>
            <div class="side-by-side-charts">
                <div>
                    <h2>Módulo do Canal</h2>
                    <canvas id="graf_mod_canal" width="300" height="200"></canvas>
                </div>
                <div>
                    <h2>Fase do Canal</h2>
                    <canvas id="graf_fase_canal" width="300" height="200"></canvas>
                </div>
            </div>
            <div class="side-by-side-charts">
                <div>
                    <h2>Espectro da Amplitude de Saída</h2>
                    <canvas id="graf_ampli_saida" width="300" height="200"></canvas>
                </div>
                <div>
                    <h2>Espectro da Fase de Saída</h2>
                    <canvas id="graf_fase_saida" width="300" height="200"></canvas>
                </div>
            </div>
        </section>
        
    </div>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js" integrity="sha512-v2CJ7UaYy4JwqLDIrZUI/4hqeoQieOmAZNXBeQyjo21dadnwR+8ZaIJVT8EE2iyI61OV8e6M8PP2/4hpQINQ/g==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>

    <script>
        var jsonEmitido = <%= request.getAttribute("emitido") %>
        var jsonFaseEntrada = <%= request.getAttribute("jsonFaseEntrada") %>
        var tipoOnda = '<%= request.getAttribute("tipoOnda") %>'
        var espectroAmplitudeEntrada = <%= request.getAttribute("espectroAmplitudeEntrada") %>
        var moduloCanal = <%= request.getAttribute("moduloCanal") %>
        var faseCanal = <%= request.getAttribute("faseCanal") %>
        var amplitudeSaida = <%= request.getAttribute("amplitudeSaida") %>
        var faseSaida = <%= request.getAttribute("faseSaida") %>
    </script>
    <script src="js/index.js" charset="UTF-8"></script>
    <script src="js/graph.js" charset="UTF-8"></script>
</body>
</html>