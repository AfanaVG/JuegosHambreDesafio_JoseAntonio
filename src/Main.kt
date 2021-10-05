import Items.Item

fun main(){

    var capitolio = Inicializador.iniciarCapitolio()
    var distrito1 = Inicializador.iniciarDistrito()
    var distrito2 = Inicializador.iniciarDistrito()
    var distrito3 = Inicializador.iniciarDistrito()
    var distrito4 = Inicializador.iniciarDistrito()
    var distrito5 = Inicializador.iniciarDistrito()
    var distritos = arrayListOf(distrito1,distrito2,distrito3,distrito4,distrito5)
    var  mapa = Mapa(capitolio,distritos)
    var n = 0
/*
    println(distrito1.toString())
    println(distrito2.toString())
    println(distrito3.toString())
    println(distrito4.toString())
    println(distrito5.toString())*/

    mapa.rellenarMapa()
    //mapa.mostarMapa()



    while (n <= 216.000 && capitolio.morgue.size!=9) {

        if (n % 2 == 0){
            while (capitolio.morgue.size!=9){
                mapa.moverTributo()
            }
        }

        if (n % 5 == 0){
            mapa.recargarItems()
        }

        //Thread.sleep(1000)
        n++

    }


    mapa.ganador()






}
