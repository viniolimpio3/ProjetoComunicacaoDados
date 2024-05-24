//google.charts.load('current', {packages: ['corechart', 'line']});;;;;
//google.charts.setOnLoadCallback(drawChart);
//
//function drawChart() {
//    let array = [['Tempo', 'Onda Emitida']]
//    
//    lastState = 0;
//    for (let i=0; i < jsonEmitido.length; i++){
//        let value = jsonEmitido[i]
//        array.push([(value !== lastState) ? i - 1 : i, value])
//        lastState = value;
//    }
//
//    var data = google.visualization.arrayToDataTable(array);
//
//    var options = {
//        title: '',
//        curveType: 'function',
//        legend: {position: 'bottom'}
//    };
//    
//    var options = {
//        chart: {
//          title: 'Gráfico emitido'
//        },
//        width: 900,
//        height: 500
//      };
//
//
//    var chart = new google.charts.Line(document.getElementById('graf_emitido'));
//
//    chart.draw(data, google.charts.Line.convertOptions(options));
//}

lastState = 0
let array = []
for (let i = 0; i < jsonEmitido.length; i++) {
    let value = jsonEmitido[i]
    array.push([(value !== lastState) ? i - 1 : i, value])
    lastState = value
}

const ctx = document.getElementById('graf_emitido').getContext('2d');
const chart = new Chart(ctx, {
    type: 'line',
    data: {
        datasets: [{
                label: 'Onda Emitida',
                data: array,
                borderColor: 'rgba(75, 192, 192, 1)',
                borderWidth: 1,
                pointRadius: 0, // Remove os pontos dos dados
                fill: false,
                stepped: false // Adiciona passos para uma onda quadrada
            }]
    },
    options: {
        responsive: true,
        scales: {
            x: {
                type: 'linear',
                position: 'bottom',
                title: {
                    display: true,
                    text: 'Tempo'
                }
            },
            y: {
                title: {
                    display: true,
                    text: 'Amplitude'
                },
                suggestedMin: 0,
                suggestedMax: 1.5
            }
        }
    }})
