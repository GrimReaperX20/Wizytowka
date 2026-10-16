package pl.merito.nikodemscibiorski.Koszyk

class Koszyk {
    // Klasa danych opisująca produkt[cite: 5].
    data class Produkt(val nazwa: String, val cena: Double, val ilosc: Int)

    // Klasa Koszyk z listą produktów[cite: 5].
    class Koszyk {
        private val produkty = mutableListOf<Produkt>()

        // Funkcja dodająca produkt do koszyka[cite: 5].
        fun dodaj(produkt: Produkt) {
            produkty.add(produkt)
            println("Dodano: ${produkt.nazwa}")
        }

        // Funkcja usuwająca produkt po nazwie[cite: 5].
        fun usun(nazwa: String) {
            val usunieto = produkty.removeAll { it.nazwa == nazwa }
            if (usunieto) println("Usunięto produkt o nazwie: $nazwa")
        }

        // Funkcja licząca sumę z 10% rabatem powyżej 200 zł za pomocą when[cite: 5].
        fun suma(): Double {
            val sumaCalkowita = produkty.sumOf { it.cena * it.ilosc }

            return when {
                sumaCalkowita > 200.0 -> sumaCalkowita * 0.9 // Rabat 10%
                else -> sumaCalkowita
            }
        }
    }

    // Przetestowanie w main[cite: 5].
    fun main() {
        val koszyk = Koszyk()

        koszyk.dodaj(Produkt("Klawiatura", 120.0, 1))
        koszyk.dodaj(Produkt("Myszka", 90.0, 1))

        println("Aktualna suma (bez rabatu byłoby 210.0 zł, z rabatem): ${koszyk.suma()} zł")

        koszyk.usun("Myszka")
        println("Suma po usunięciu myszki (poniżej 200 zł, więc bez rabatu): ${koszyk.suma()} zł")
    }

    fun dodaj(produkt: Any) {}
    fun suma(): String {
        return TODO("Provide the return value")
    }
}