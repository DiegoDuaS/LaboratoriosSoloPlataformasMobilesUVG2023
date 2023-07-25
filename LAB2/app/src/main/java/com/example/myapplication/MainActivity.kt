class MainActivity {
        fun Promedio(lista: List<Int>): Double{
            val suma = lista.reduce { acumulado, elemento -> acumulado + elemento }
            val promedio = suma.toDouble() / lista.size
            return promedio
        }
        fun pares(lista: List<Int>){
            val pares = lista.filter { it % 2 == 0 }
            println(pares)
        }

        fun 
    }

fun main(){
    val Listaa: List<Int> = listOf(2,5,7,10,12,4,1)
    val mainActivity = MainActivity()
    val promedio: Double = mainActivity.Promedio(Listaa)
    println("$promedio")
}