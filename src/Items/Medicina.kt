package Items

public class Medicina(var des:String?,var vida:Int?):Item(des){

    override fun toString(): String {
        return this.des+" Vida : "+this.vida
    }

    class Builder(var des:String?=null,var vida:Int?=null){
        fun des(des: String):Builder{
            this.des=des
            return this
        }
        fun vida(vida: Int):Builder{
            this.vida=vida
            return this
        }

        fun build():Medicina{
            return Medicina(this.des,this.vida)
        }
    }
}