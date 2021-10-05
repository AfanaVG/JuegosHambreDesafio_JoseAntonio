import Items.Arma
import Items.Item
import Items.Medicina
import Items.Trampa

class Mapa(var capitolio: Capitolio, var distritos: ArrayList<Distrito>) {

    var sectores = Array(5){Array<Any?>(5){null} }


    fun rellenarMapa(){

        var colFil = arrayListOf(0,0)
        var colocado = false
        var n =0

        mezclar(colFil)
        for (i in this.distritos.indices){
            for (j in this.distritos[i].tributos.indices){

                while (!colocado){


                    if (this.sectores[colFil[0]][colFil[1]] == null){
                        this.sectores[colFil[0]][colFil[1]] = this.distritos[i].tributos[j]
                        colocado = true
                        mezclar(colFil)
                    }else{
                        colocado = false
                        mezclar(colFil)
                    }
                }
                colocado = false
            }
        }


        while (n != 10){
            while (!colocado){
                if (this.sectores[colFil[0]][colFil[1]] == null){
                    this.sectores[colFil[0]][colFil[1]] = this.capitolio.almacenItem[0]
                    this.capitolio.almacenItem.removeAt(0)
                    n++
                    colocado = true
                    mezclar(colFil)
                }else{
                    colocado = false
                    mezclar(colFil)
                }
            }
            colocado = false
        }



    }

    private fun mezclar(colFil:ArrayList<Int>):ArrayList<Int>{

        colFil[0] = this.sectores.indices.random()
        colFil[1] = this.sectores.indices.random()

        return  colFil
    }


    fun mostarMapa(){
        println("")
        println("*******************")
        for (i in sectores.indices){
            print("|  ")
            for (j in sectores[i].indices){

                when(sectores[i][j]){

                    is Tributo -> print("${(sectores[i][j] as Tributo).distrito}  |  ")
                    is Item ->
                        when(sectores[i][j]){
                            is Trampa -> print("${(sectores[i][j] as Item).descripcion}  |  ")
                            is Arma -> print("${(sectores[i][j] as Item).descripcion}  |  ")
                            is Medicina -> print("${(sectores[i][j] as Item).descripcion}  |  ")
                        }

                    else-> print("--  |  ")
                }


            }
            println()
        }
    }

    fun moverTributo() {


        for (i in this.sectores.indices) {
            for (j in this.sectores[i].indices){


                if (this.sectores[i][j] is Tributo && capitolio.morgue.size!=9) {
                    println(capitolio.morgue.size)
                    println("")
                    var dir = (1..8).random()

                        when (dir) {
                            1 ->
                                if (j - 1 >= 0 && i - 1 >= 0 ) {
                                    println("El tributo "+(this.sectores[i][j] as Tributo).distrito+" se mueve en direccion izquierda/arriba")
                                    situaciones(i,j,i-1,j-1)
                                }
                            2 ->
                                if (j + 1 < this.sectores.size && i + 1 < this.sectores.size ) {
                                    println("El tributo "+(this.sectores[i][j] as Tributo).distrito+" se mueve en direccion derecha/abajo")
                                    situaciones(i,j,i+1,j+1)
                                }
                            3->
                                if (j + 1 < this.sectores.size && i - 1 >= 0 ) {
                                    println("El tributo "+(this.sectores[i][j] as Tributo).distrito+" se mueve en direccion derecha/arriba")
                                    situaciones(i,j,i-1,j+1)
                                }
                            4->
                                if (j - 1 >= 0 && i + 1 < this.sectores.size ) {
                                    println("El tributo "+(this.sectores[i][j] as Tributo).distrito+" se mueve en direccion izquierda/abajo")
                                    situaciones(i,j,i+1,j-1)
                                }
                            5->
                                if ( i + 1 < this.sectores.size ) {
                                    println("El tributo "+(this.sectores[i][j] as Tributo).distrito+" se mueve en direccion abajo")
                                    situaciones(i,j,i+1,j)
                                }
                            6->
                                if ( i - 1 >= 0  ) {
                                    println("El tributo "+(this.sectores[i][j] as Tributo).distrito+" se mueve en direccion arriba")
                                    situaciones(i,j,i-1,j)
                                }
                            7->
                                if ( j + 1 < this.sectores.size ) {
                                    println("El tributo "+(this.sectores[i][j] as Tributo).distrito+" se mueve en direccion derecha")
                                    situaciones(i,j,i,j+1)
                                }
                            8->
                                if ( j - 1 >= 0 ) {
                                    println("El tributo "+(this.sectores[i][j] as Tributo).distrito+" se mueve en direccion izquierda")
                                    situaciones(i,j,i,j-1)
                                }
                        }

                }

            }

        }
    }

    fun situaciones(filaA:Int,columnaA:Int,filaS:Int,columnaS:Int){
        when(this.sectores[filaS][columnaS]){
            is Arma-> (this.sectores[filaS][columnaS] as Arma).fuerzaArma?.let {
                (this.sectores[filaA][columnaA] as Tributo).sumarFuerza(
                    it
                )
                this.sectores[filaS][columnaS] = this.sectores[filaA][columnaA]
                this.sectores[filaA][columnaA] = null
            }
            is Medicina-> (this.sectores[filaS][columnaS] as Medicina).vida?.let {
                (this.sectores[filaA][columnaA] as Tributo).sumarVida(
                    it
                )
                this.sectores[filaS][columnaS] = this.sectores[filaA][columnaA]
                this.sectores[filaA][columnaA] = null
            }
            is Trampa->{
                println("El tributo "+(this.sectores[filaA][columnaA] as Tributo).distrito+" pisa una trampa y muere")

                this.capitolio.morgue.add(this.sectores[filaA][columnaA] as Tributo)
                this.sectores[filaS][columnaS] = null
                this.sectores[filaA][columnaA] = null
                }

            is Tributo->{
                if ((this.sectores[filaA][columnaA] as Tributo).pelear(this.sectores[filaS][columnaS] as Tributo)){
                    this.capitolio.morgue.add(this.sectores[filaA][columnaA] as Tributo)
                    this.sectores[filaS][columnaS] = this.sectores[filaA][columnaA]
                    this.sectores[filaA][columnaA] = null
                }else{
                    this.capitolio.morgue.add(this.sectores[filaA][columnaA] as Tributo)
                    this.sectores[filaA][columnaA] = null
                }

            }

            else ->{
                this.sectores[filaS][columnaS] = this.sectores[filaA][columnaA]
                this.sectores[filaA][columnaA] = null
            }

        }
        mostarMapa()

       // Thread.sleep(1000)
    }

    fun ganador(){

        for (i in this.sectores.indices) {
            for (j in this.sectores[i].indices){
                if (this.sectores[i][j] is Tributo && this.sectores[i][j] != null){
                    println("****************         *****************")
                    println("")
                    println("El ganador es el tributo del distrito "+(this.sectores[i][j] as Tributo).distrito)
                    println("")
                    println("****************         *****************")
                }
            }
        }
    }

    fun recargarItems(){

        var n = 0
        var colocado = false
        var colFil = arrayListOf(0,0)

        while (n != 4){
            while (!colocado){
                if (this.sectores[colFil[0]][colFil[1]] == null){
                    this.sectores[colFil[0]][colFil[1]] = this.capitolio.almacenItem[0]
                    this.capitolio.almacenItem.removeAt(0)
                    n++
                    colocado = true
                    mezclar(colFil)
                }else{
                    colocado = false
                    mezclar(colFil)
                }
            }
            colocado = false
        }

        println("El capitolio recarga items")

    }

}


