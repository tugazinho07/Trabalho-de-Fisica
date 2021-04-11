import kotlin.math.PI
import kotlin.math.acos
import kotlin.math.cos
import kotlin.math.sin

fun buildMenu(): String {
    return """
        1-> Start New Program;
        2-> Get Help;
        3-> Exit Program.
        
        
    """.trimIndent()
}

fun main(args: Array<String>) {
    var jogo = 0
    val larguraGrafico = 100
    val alturaGrafico = 50
    val grafico = Chart(larguraGrafico, alturaGrafico)

    while (jogo == 0) {
        print(buildMenu())
        var resposta = readLine()!!.toInt()
        if (resposta == 3) {
            break
        }
        if (resposta == 2) {
            println("A altura nunca deve passar dos 40metros")
            println("A velocidade aconselhada deve ser entre os 50 a 55 metros por segundo")
        } else {
            println("Intruduza o angulo")
            var angulo = readLine()!!.toDouble()

            println("Intruduza a velocidade inicial")
            val velocidadeInicial = readLine()!!.toDouble()

            println("Intruduza a altura")
            val altura = readLine()!!.toDouble()
            var tempo = 0.0
            while (tempo < 2.1) {
                var x = 0 + velocidadeInicial * cos(angulo * PI / 180) * tempo
                var y = altura + (velocidadeInicial * sin(angulo * PI / 180) * tempo) - 10 * (tempo * tempo)
                if (y >= -2.0) {
                    grafico.ponto(x, y)
                }
                tempo += 0.1
            }
            grafico.draw()

            var xHelp = 0 + velocidadeInicial * cos(angulo * PI / 180) * 2
            var yHelp = altura + (velocidadeInicial * sin(angulo * PI / 180) * tempo) - 10 * (tempo * tempo)
            if(xHelp < 80){
                println("O astraunauta aterrou bastante atras dos 100metros")
            }
            if(xHelp > 81 && xHelp <100){
                println("O astraunauta aterrou pertos dos 100metros")
            }
            if(xHelp == 100.0 && yHelp == 0.0){
                println("O astraunauta aterrou com sucesso")
            }
            if(xHelp>100 && xHelp <110){
                println("O astraunauta aterrou pertos dos 100metros")
            }
            if(xHelp >110){
                println("O astraunauta aterrou bastante a frente dos 100metros")
            }
            //velocidade 50 a 54 e alturas abaixo 40
            // angulo 21.8  velocidade  em x53.85 m/s
            // angulo 24.62 velocidade 55m/s e altura -5,826
            // altura inicial 40 e velocidade 50 m/s
            //ficar com o angulo mudar e altura a velocidade Inicial
            // 0 + velocidadeInicial * cos(angulo * PI / 180) * 2.0
            //  var anguloCerto = acos(50 / velocidadeInicial) * 180 / PI
            // println(anguloCerto)

        }
    }
}