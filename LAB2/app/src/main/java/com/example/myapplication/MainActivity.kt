class MainActivity {
        fun Promedio(lista: List<Int>): Double{
            val suma = lista.reduce { acumulado, elemento -> acumulado + elemento }
            val promedio = suma.toDouble() / lista.size
            return promedio
        }
    }

fun main(){
    val Listaa: List<Int> = listOf(2,5,7,10,12,4,1)
    val mainActivity = MainActivity()
    val promedio: Double = mainActivity.Promedio(Listaa)
    println("$promedio")
}