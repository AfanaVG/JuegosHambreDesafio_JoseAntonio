import Items.Arma
import Items.Item
import Items.Medicina
import Items.Trampa

object Inicializador {

        var LISTADISTRITOS = arrayListOf<String>(" 1"," 2"," 3"," 4"," 5"," 6"," 7"," 8"," 9","10","11","12","13")


    fun crearItem():Item{
        var item:Item
        when((0..2).random()){

            0-> item = Arma.Builder()
                .des("AA")
                .fuerzaArma((50..100).random())
                .build()

            1-> item = Medicina.Builder()
                .des("MM")
                .vida((50..100).random())
                .build()

            else-> item = Trampa.Builder()
                .des("TT")
                .build()
        }

        return item

    }

    /*fun iniciarCapitolio():Capitolio{

        var almacen = ArrayList<Item>()
        var morgue = ArrayList<Tributo>()


        for (i in 1..100){
            almacen.add(crearItem())

        }

        return Capitolio.Builder()
            .almacenItem(ArrayList<Item>())
            .morgue(ArrayList<Tributo>())
            .build()

    }*/

    fun iniciarCapitolio():Capitolio{



        var almacen = arrayListOf<Item>()
        var morgue = arrayListOf<Tributo>()


        for (i in 1..100){
            almacen.add(crearItem())

        }

        var capitolio = Capitolio(almacen,morgue)

        return capitolio

    }

    fun iniciarDistrito():Distrito{

        var numDistrito = LISTADISTRITOS.get((0..LISTADISTRITOS.size-1).random())
        LISTADISTRITOS.remove(numDistrito)

        return  Distrito.Builder().numDistrito(numDistrito).build()
    }




}