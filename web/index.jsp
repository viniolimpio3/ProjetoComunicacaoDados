<!DOCTYPE html>
<html lang="pt-br">
    <jsp:include page="WEB-INF/head.jsp"></jsp:include>
    <body>
        <div class="container">
            <h1 class="mb-4">Seja bem-vindo ao PBL!</h1>
            <!-- Adicionando classe container para centralizar o conteúdo -->
            <div class="row justify-content-center">
                <div class="col-md-8 col-sm-12">
                    <form action="ControllerServlet" method="post" class="form-container">
                        <div class="row">
                            <div class="col">
                                <div class="mb-3">
                                    <label class="mr-sm-2" for="tipoCanal">Tipo de onda</label>
                                    <select required class="form-select mr-sm-2" id="tipoOnda" name="tipoOnda">
                                        <option selected value="quadrada">Quadrada</option>
                                        <option value="senoidal-retificada">Senoidal Retificada</option>
                                        <option value="dente-serra">Dente de Serra</option>
                                        <option value="triangular">Triangular</option>
                                    </select>
                                </div>
                            </div>
                            <div class="col">
                                <div class="mb-3">
                                    <label class="mr-sm-2" for="tipoCanal">Tipo de canal:</label>
                                    <select required class="form-select mr-sm-2" id="tipoCanal" name="tipoCanal">
                                        <option value="fx">Passa Faixas</option>
                                        <option value="bx">Passa Baixas</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col">
                                <div class="mb-3">
                                    <label for="frequenciaFundamental" class="form-label">Frequência Fundamental (entre 1kHz e 100kHz):</label>
                                    <input required type="number" min="1" max="100" id="frequenciaFundamental" name="frequenciaFundamental" class="form-control freq">
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-6">
                                <div class="mb-3">
                                    <label for="frequenciaInicial" class="form-label" id="text-freq">Frequência Inicial (entre 1kHz e 100kHz):</label>
                                    <input type="number" min="1" max="100" id="frequenciaInicial" name="frequenciaInicial" class="form-control freq">
                                </div>
                            </div>
                            <div class="col-6">
                                <div class="mb-3" id="divFrequenciaFinal">
                                    <label for="frequenciaFinal" class="form-label">Frequência Final (entre 1kHz e 100kHz):</label>
                                    <input type="number" min="1" max="100" id="frequenciaFinal" name="frequenciaFinal" class="form-control freq">
                                </div>
                            </div>
                        </div>
                        <button type="submit" class="btn btn-primary">Enviar</button>
                    </form>
                </div>
            </div>
        </div>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js" integrity="sha512-v2CJ7UaYy4JwqLDIrZUI/4hqeoQieOmAZNXBeQyjo21dadnwR+8ZaIJVT8EE2iyI61OV8e6M8PP2/4hpQINQ/g==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
        <script src="js/index.js"></script>
    </body>
</html>