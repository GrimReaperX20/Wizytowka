package pl.merito.nikodemscibiorski.Student

import kotlin.collections.iterator

class Student(string: String, i: Int, string2: String, string3: String) {
    val punkty: Any
        get() {
            TODO()
        }
    val grupa: Any
        get() {
            TODO()
        }

    // Definicja klasy danych rozbudowana o pole grupa.
    data class Student(val imie: String, val punkty: Int, val email: String? = null, val grupa: String)

    // Dodanie funkcji rozszerzającej czyZaliczyl()[cite: 5].
    fun Student.czyZaliczyl() = punkty >= 50

    fun ocena(punkty: Int): String = when {
        punkty >= 90 -> "5,0"
        punkty >= 75 -> "4,0"
        punkty >= 50 -> "3,0"
        else -> "2,0"
    }

    fun main() {
        val studenci = listOf(
            Student("Ala", 92, "ala@student.pl", "Grupa 1"),
            Student("Bartek", 71, null, "Grupa 1"),
            Student("Celina", 48, "celina@student.pl", "Grupa 2"),
            Student("Dawid", 80, "dawid@student.pl", "Grupa 2")
        )

        // Pogrupowanie studentów funkcją groupBy względem grupy[cite: 5].
        val studenciWGrupiach = studenci.groupBy { it.grupa }

        // Wypisanie średniej w każdej grupie[cite: 5].
        for ((grupa, listaStudentow) in studenciWGrupiach) {
            val srednia = listaStudentow.map { it.punkty }.average()
            println("Średnia dla grupy $grupa wynosi: ${"%.1f".format(srednia)} pkt")
        }

        // Użycie funkcji rozszerzającej w filter w celu znalezienia osób, które zaliczyły[cite: 5].
        val zaliczeni = studenci.filter { it.czyZaliczyl() }.map { it.imie }
        println("\nStudenci, którzy zaliczyli: $zaliczeni")
    }
}