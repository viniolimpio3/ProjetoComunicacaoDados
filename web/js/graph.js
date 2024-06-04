var lastState = 0
let array = []
for (let i = 0; i < jsonEmitido.length; i++) {
    let value = jsonEmitido[i]
    array.push([((value !== lastState) ? i - 1: i) * (tipoOnda === 'senoidal-retificada' ? 1 : .1), value])
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
                    text: 'Tempo (ms)'
                }
            },
            y: {
                title: {
                    display: true,
                    text: 'Amplitude'
                },
                suggestedMin: (tipoOnda === "senoidal-retificada" || tipoOnda === "dente-serra") ? 0 : -1,
                suggestedMax: 1
            }
        }
    }})


array = []
for (let i = 0; i < jsonFaseEntrada.length; i++) {
    array.push(i + 1)
}
const ctxFaseEntrada = document.getElementById('graf_fase_entrada').getContext('2d');
const chartFaseEntrada = new Chart(ctxFaseEntrada, {
    type: 'bar',
    data: {
        labels: array,
        datasets: [{
                label: 'Fase de Entrada',
                data: jsonFaseEntrada,
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
                    text: 'Frequência (kHz)'
                }
            },
            y: {
                title: {
                    display: true,
                    text: 'Fase º'
                },
            }
        }
    }})

lastState = 0
array = []
for (let i = 0; i < espectroAmplitudeEntrada.length; i++) {
    array.push(i + 1)
}
const ctxEspectroAmpEntrada = document.getElementById('graf_ampli_entrada').getContext('2d');
const chartEspectroAmpEntrada = new Chart(ctxEspectroAmpEntrada,{
    type: 'bar',
    data: {
        labels: array,
        datasets: [{
                label: 'Amplitude de Entrada',
                data: espectroAmplitudeEntrada,
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
                    text: 'Frequência (kHz)'
                }
            },
            y: {
                title: {
                    display: true,
                    text: 'Amplitude'
                },
            }
        }
    }})

array = []
for (let i = 0; i < moduloCanal.length; i++) {
    let value = moduloCanal[i]
    array.push([i + 1, value])
}

const ctxModuloCanal = document.getElementById('graf_mod_canal').getContext('2d');
const chartModCanal = new Chart(ctxModuloCanal, {
    type: 'line',
    data: {
        
        datasets: [{
                tension: 0.5,
                label: 'Módulo do canal',
                data: array,
                borderColor: 'rgba(75, 192, 192, 1)',
                borderWidth: 1,
                pointRadius: 0, // Remove os pontos dos dados
                fill: true,
                stepped: false
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
                    text: 'Frequência (kHz)'
                }
            },
            y: {
                title: {
                    display: true,
                    text: 'Módulo'
                }
            }
        }
    }})

array = []
for (let i = 0; i < faseCanal.length; i++) {
    let value = faseCanal[i]
    array.push([i + 1, value])
}


const ctxFaseCanal = document.getElementById('graf_fase_canal').getContext('2d');
const chartFaseCanal = new Chart(ctxFaseCanal, {
    type: 'line',
    data: {
        datasets: [{
                tension: 0.7,
                label: 'Fase do canal',
                data: array,
                borderColor: 'rgba(75, 192, 192, 1)',
                borderWidth: 1,
                pointRadius: 0, // Remove os pontos dos dados
                fill: true,
                stepped: false
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
                    text: 'Frequência (kHz)'
                }
            },
            y: {
                title: {
                    display: true,
                    text: 'Fase º'
                }
            }
        }
    }})

array = []
for (let i = 0; i < amplitudeSaida.length; i++) {
    array.push(i + 1)
}
const ctxAmpSaida = document.getElementById('graf_ampli_saida').getContext('2d');
const chartAmpSaida = new Chart(ctxAmpSaida,{
    type: 'bar',
    data: {
        labels: array,
        datasets: [{
                label: 'Amplitude de Entrada',
                data: amplitudeSaida,
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
                    text: 'Frequência (kHz)'
                }
            },
            y: {
                title: {
                    display: true,
                    text: 'Amplitude'
                },
            }
        }
    }})

array = []
for (let i = 0; i < faseSaida.length; i++) {
    array.push(i + 1)
}
const ctxFaseSaida = document.getElementById('graf_fase_saida').getContext('2d');
const chartFaseSaida = new Chart(ctxFaseSaida, {
    type: 'bar',
    data: {
        labels: array,
        datasets: [{
                label: 'Fase de Entrada',
                data: faseSaida,
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
                    text: 'Frequência (kHz)'
                }
            },
            y: {
                title: {
                    display: true,
                    text: 'Fase º'
                },
            }
        }
    }})


lastState = 0
array = []
for (let i = 0; i < sinalSaida.length; i++) {
    let value = sinalSaida[i]
    array.push([i, value])
    lastState = value
}

const ctxSaida = document.getElementById('graf_saida').getContext('2d');
const chartSaida = new Chart(ctxSaida, {
    type: 'line',
    data: {
        datasets: [{
                label: 'Onda Saída',
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
                    text: 'Tempo (ms)'
                }
            },
            y: {
                title: {
                    display: true,
                    text: 'Amplitude'
                }
            }
        }
    }})
