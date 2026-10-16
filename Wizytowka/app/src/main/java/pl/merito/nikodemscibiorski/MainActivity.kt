package pl.merito.nikodemscibiorski

import android.os.Bundle
import android.util.Log // Dodany import dla Log.d
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import pl.merito.nikodemscibiorski.Koszyk.Koszyk
import pl.merito.nikodemscibiorski.Student.Student
import pl.merito.nikodemscibiorski.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // --- AKTYWACJA KODU Z ZADAŃ ---
        testujZadania()
        // ------------------------------

        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Nikodem Ścibiorski",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }

    // Funkcja wywołująca logikę z Twoich klas
    private fun testujZadania() {
        Log.d("WYNIKI_ZADAN", "--- Start Zadania 2 ---")

        // Upewnij się, że klasa Student jest utworzona w osobnym pliku w Twoim pakiecie
        val studenci = listOf(
            Student("Ala", 92, "ala@student.pl", "Grupa 1"),
            Student("Celina", 48, "celina@student.pl", "Grupa 2")
        )
        val studenciWGrupiach = studenci.groupBy { it.grupa }
        for ((grupa, listaStudentow) in studenciWGrupiach) {
            val srednia = listaStudentow.map { it.punkty }.average()
            Log.d("WYNIKI_ZADAN", "Średnia dla grupy $grupa wynosi: $srednia")
        }

        Log.d("WYNIKI_ZADAN", "--- Start Zadania 3 ---")

        // Upewnij się, że klasa Koszyk i Produkt są utworzone
        val koszyk = Koszyk()
        koszyk.dodaj(Koszyk.Produkt("Klawiatura", 120.0, 1))
        koszyk.dodaj(Koszyk.Produkt("Myszka", 90.0, 1))
        Log.d("WYNIKI_ZADAN", "Suma w koszyku: ${koszyk.suma()} zł")
    }
}

private fun List<Any>.average() {

}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        Greeting("Android")
    }
}