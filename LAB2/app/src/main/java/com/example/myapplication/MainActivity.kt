class MainActivity {
        fun Promedio(lista: List<Int>): Double{
            val suma = lista.reduce { acumulado, elemento -> acumulado + elemento }
            val promedio = suma.toDouble() / lista.size
            return promedio
        }
        fun pares(lista: List<Int>): List<Int>{
            val pares = lista.filter { it % 2 == 0 }
            return pares
        }
        fun Palindrome(input: String): Boolean {
            var pal = false
            if(input == input.reversed()){
                pal = true
            }
            return pal
        }

}

fun main(){

    val mainActivity = MainActivity()
    val Listaa: List<Int> = listOf(2,5,7,10,12,4,1)
    val promedio: Double = mainActivity.Promedio(Listaa)
    val pares: List<Int> = mainActivity.pares(Listaa)
    val palabra = "araña"
    val palabra2 = "rad"
    val pali1: Boolean = mainActivity.Palindrome(palabra)
    val pali2: Boolean = mainActivity.Palindrome(palabra2)

}