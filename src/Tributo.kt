import Items.Medicina

class Tributo(var distrito:String?, var vida:Int?, var fuerza:Int?) {


    override fun toString(): String {
        return "El tributo del distrito "+this.distrito+" tiene Fuerza : "+this.fuerza+" Vida : "+this.vida
    }

    fun sumarVida(medicamento: Int){
        println("El tributo "+this.distrito+" suma "+medicamento+" puntos de vida")
        this.vida = this.vida?.plus(medicamento)
    }

    fun sumarFuerza(forza:Int){
        println("El tributo "+this.distrito+" suma "+fuerza+" puntos de fuerza")
        this.fuerza = this.fuerza?.plus(forza)
    }

    fun pelear(enemigo:Tributo):Boolean{

        if (this.fuerza!! > enemigo.fuerza!!){
            println("Pelea vencida por el tributo "+this.distrito)
            return  true
        }else if(this.fuerza!! < enemigo.fuerza!!){
            println("Pelea vencida por el tributo "+enemigo.distrito)
            return false
        }else if(this.fuerza!! == enemigo.fuerza!!){
            if (this.vida!! > enemigo.vida!!){
                println("Pelea vencida por el tributo "+this.distrito)
                return  true
            }else if(this.vida!! < enemigo.vida!!){
                println("Pelea vencida por el tributo "+enemigo.distrito)
                return false
            }else if(this.vida!! == enemigo.vida!!){

                if ((0..1).random() == 0){
                    println("Pelea vencida por el tributo "+this.distrito)
                    return  true
                }
                }else{
                println("Pelea vencida por el tributo "+enemigo.distrito)
                return false
            }
        }else{
        return false
        }

        return false
    }

        /**
        if (this.fuerza!! > enemigo.fuerza!!){
            println("Pelea vencida por el tributo "+this.distrito)
            return  true
        }else if(this.fuerza!! < enemigo.fuerza!!){
            println("Pelea vencida por el tributo "+enemigo.distrito)
            return false
        }else if(this.fuerza!! == enemigo.fuerza!!){
            if (this.vida!! > enemigo.vida!!){
                println("Pelea vencida por el tributo "+this.distrito)
                return  true
            }else if(this.vida!! < enemigo.vida!!){
                println("Pelea vencida por el tributo "+enemigo.distrito)
                return false
            }else if(this.vida!! == enemigo.vida!!){

                if ((0..1).random() == 0){
                    println("Pelea vencida por el tributo "+this.distrito)
                    return  true

                }else{
                    println("Pelea vencida por el tributo "+enemigo.distrito)
                    return false
                }

            }

            }else{
                return false
            }**/



    class Builder(var distrito:String? = null, var vida:Int? = null, var fuerza:Int? = null){
        fun distrito(distrito: String?):Builder{
            this.distrito=distrito
            return this
        }
        fun vida(vida: Int?):Builder{
            this.vida=vida
            return this
        }

        fun fuerza(fuerza: Int?):Builder{
            this.fuerza=fuerza
            return this
        }

        fun build(): Tributo {
            return Tributo(this.distrito,this.vida,this.fuerza)
        }
    }

}

