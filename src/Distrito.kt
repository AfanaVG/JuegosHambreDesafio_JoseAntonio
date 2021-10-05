import Items.Medicina

class Distrito(var numDistrito:String?,var tributos:Array<Tributo?>) {


    override fun toString(): String {
        return "**************************" +
                "\nDatos del distrito "+numDistrito +
                "\n{"+tributos[0].toString()+"}"+
                "\n{"+tributos[1].toString()+"}" +
                "\n*************************"
    }

    /*class Builder(var numDistrito:Int? = null, var tributo1:Tributo, var tributo2:Tributo){
        fun numDistrito(numDistrito: Int?):Builder{
            this.numDistrito=numDistrito
            return this
        }
        fun tributo1():Builder{
            this.tributo1= Tributo.Builder()
                .distrito(this.numDistrito)
                .vida(10)
                .fuerza(10).build()
            return this
        }
        fun tributo2():Builder{
            this.tributo2= Tributo.Builder()
                .distrito(this.numDistrito)
                .vida(10)
                .fuerza(10).build()
            return this
        }

        fun build(): Distrito {
            return Distrito(this.numDistrito,this.tributo1,this.tributo2)
        }
    }*/
    class Builder(var numDistrito:String? = null){
        fun numDistrito(numDistrito: String?):Builder{
            this.numDistrito=numDistrito
            return this
        }


        fun build(): Distrito {
            return Distrito(this.numDistrito,tributos = construirTributo(),)
        }

        fun construirTributo():Array<Tributo?>{

            var tributos:Array<Tributo?> =Array(2){null}
            for (i in tributos.indices){

                tributos[i] =Tributo.Builder()
                    .distrito(this.numDistrito)
                    .vida((10..70).random())
                    .fuerza((10..70).random()).build()

            }

            return tributos
        }
    }
}