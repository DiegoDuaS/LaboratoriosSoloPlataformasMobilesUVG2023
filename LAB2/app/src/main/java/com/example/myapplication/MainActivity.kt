//*********************
//
// Universidad del Valle de Guatemala
// Diego Duarte 22075
// 26/07/23
//
//*********************

//Clase Data con parametros para persona
data class Person(val name: String, val age: Int, val gender: String)

//Clase Data con parametros para estudiante
data class Student(val name: String, val age: Int, val gender: String, val
studentId: String)

//Clase MainActivty con funciones
class MainActivity {
        //Funcion Promedio con Parametros (Lista<Int>) y regresa un valor double
        fun Promedio(lista: List<Int>): Double{
            val suma = lista.reduce { acumulado, elemento -> acumulado + elemento }
            val promedio = suma.toDouble() / lista.size
            return promedio
        }
        //Funcion Pares con Parametros (Lista<Int>) y regresa un valor Lista<Int>
        fun pares(lista: List<Int>): List<Int>{
            val pares = lista.filter { it % 2 == 0 }
            return pares
        }
        //Funcion Palindrome con Parametros (String) y regresa un valor booleano
        fun Palindrome(input: String): Boolean {
            var pal = false
            if(input == input.reversed()){
                pal = true
            }
            return pal
        }
        //Funcion Operacion con Parametros (Int, Int, String) y regresa un valor Int
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
        //Funcion PersonaAEstudiante con Parametros (Person) y regresa un valor Student
        fun PersonaAEstduiante(person: Person): Student {
            return Student(person.name, person.age, person.gender, "ID-${person.name.hashCode()}")
        }
}

// Funcion Main para correr el código
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

    println("\nEJERCICIO 5\n ")
    val personas = listOf( Person("Esteban", 20, "Hombre"), Person("Checha", 19, "Hombre"), Person("Sofía", 19, "Mujer"))
    val estudaiantes = personas.map { mainActivity.PersonaAEstduiante(it) }

    for (estudiante in estudaiantes) {
        println("El Estudiante ${estudiante.name} tiene ${estudiante.age} años")
    }


}