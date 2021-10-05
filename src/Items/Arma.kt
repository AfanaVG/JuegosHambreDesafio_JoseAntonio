package Items

class Arma(var des:String?,var fuerzaArma:Int?):Item(des) {


    class Builder(var des:String?=null,var fuerzaArma:Int?=null){
        fun des(des: String):Builder{
            this.des=des
            return this
        }
        fun fuerzaArma(fuerzaArma: Int):Builder{
            this.fuerzaArma=fuerzaArma
            return this
        }

        fun build():Arma{
            return Arma(this.des,this.fuerzaArma)
        }
    }

    override fun toString(): String {
        return this.des+" Fuerza : "+this.fuerzaArma
    }

}