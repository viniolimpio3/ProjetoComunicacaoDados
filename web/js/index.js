$(document).ready(function () {
    $('#tipoCanal').on('change', function (e) {
        var optionSelected = $("option:selected", this);
        var valueSelected = this.value;
        if(valueSelected === 'bx'){
            $('#divFrequenciaFinal').hide()
            $('#divFrequenciaFinal input').prop('disabled', true)
            $('#divFrequenciaFinal input').removeAttr('required')
            $('#text-freq').text('Frequência de Corte (entre 1kHz e 100kHz)')
        } else {
            $('#divFrequenciaFinal').show()
            $('#divFrequenciaFinal input').prop('disabled', false)
            $('#divFrequenciaFinal input').prop('required', true)
            $('#text-freq').text('Frequência Inicial (entre 1kHz e 100kHz)')
        }
    })
    
    $('.freq').on('input', function(){
        var regex = /^([0-9]|[0-9][0-9]|100)$/;
        if(!regex.test(this.value)){
            this.value = 0
        }
    })
})