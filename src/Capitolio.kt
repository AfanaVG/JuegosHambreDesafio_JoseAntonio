import Items.Item

class Capitolio(var almacenItem:ArrayList<Item>,var morgue: ArrayList<Tributo>) {


    class Builder(var almacenItem:ArrayList<Item>,var morgue: ArrayList<Tributo>){


        fun almacenItem(almacenItem:ArrayList<Item>): Builder {
            this.almacenItem=almacenItem
            return this
        }

        fun morgue(morgue:ArrayList<Tributo>): Builder {
            this.morgue=morgue
            return this
        }

        fun build():Capitolio{
            return Capitolio(this.almacenItem,this.morgue)
        }

    }

}