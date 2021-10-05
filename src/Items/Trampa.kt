package Items

class Trampa(var des:String?):Item(des) {

    override fun toString(): String {
        return ""+this.des
    }

    class Builder(var des:String?=null){
        fun des(des: String):Builder{
            this.des=des
            return this
        }

        fun build():Trampa{
            return Trampa(this.des)
        }
    }


}