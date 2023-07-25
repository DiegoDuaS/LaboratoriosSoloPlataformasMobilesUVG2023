data class Person(val name: String, val age: Int, val gender: String)
data class Student(val name: String, val age: Int, val gender: String, val
studentId: String)
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
        fun Operacion(numA: Int, numB: Int, lambda: String): Int{
            var resultado = 0
            if(lambda == "+"){
                resultado = numA + numB
            }
            else if(lambda == "-"){
                resultado = numA - numB
            }
            return resultado
        }

}

fun main(){

    val mainActivity = MainActivity()
    val Listaa: List<Int> = listOf(2,5,7,10,12,4,1)
    val promedio: Double = mainActivity.Promedio(Listaa)
    println("\nEJERCICIO 1\n Lista: $Listaa \n Promedio: $promedio")

    val pares: List<Int> = mainActivity.pares(Listaa)
    println("\nEJERCICIO 2\n Lista: $Listaa \n Pares: $pares")


    val palabra = "araña"
    val palabra2 = "radar"
    val pali1: Boolean = mainActivity.Palindrome(palabra)
    val pali2: Boolean = mainActivity.Palindrome(palabra2)
    println("\nEJERCICIO 3\n Palabra: $palabra \n Palindrome: $pali1 \n Palabra: $palabra2 \n Palindrome: $pali2")


    println("\nEJERCICIO 4\n ")
    val nombres = listOf("Marce", "Jeffrey", "Isa", "Julio")
    val saludos = nombres.map { "¡Hola, $it!" }
    saludos.forEach { println(it) }

    println("\nEJERCICIO 4\n ")
    val num1 = 20
    val num2 = 5
    val resultado: Int = mainActivity.Operacion(num1,num2,"+")
    println("El resultado de la operacion es: $resultado")


}