import kotlinx.browser.document
import kotlinx.browser.window
import org.w3c.dom.HTMLProgressElement
import kotlin.js.Date

fun start() {
    Counter.CounterDate(Date(2020, 5, 26), Counter.CounterDate.Type.HOLIDAYS)
    Counter.CounterDate(Date(2020, 8, 1), Counter.CounterDate.Type.SCHOOL)
    Counter.CounterDate(Date(2021, 5, 25), Counter.CounterDate.Type.HOLIDAYS)
    Counter.CounterDate(Date(2021, 8, 1), Counter.CounterDate.Type.SCHOOL)
    Counter.CounterDate(Date(2022, 5, 24), Counter.CounterDate.Type.HOLIDAYS)
    Counter.CounterDate(Date(2022, 8, 1), Counter.CounterDate.Type.SCHOOL)
    Counter.CounterDate(Date(2023, 5, 23), Counter.CounterDate.Type.HOLIDAYS)

    window.setInterval("this['wakacje-licznik'].update();", 10)
}

fun update() {
    document.getElementById("header")?.innerHTML = when (Counter.CounterDate.closestFutureDate().type) {
        Counter.CounterDate.Type.HOLIDAYS -> "Wakacje!"
        Counter.CounterDate.Type.SCHOOL -> "Koniec wakacji..."
        Counter.CounterDate.Type.CORONAVIRUS -> "Koniec koronaferii..."
    }

    document.getElementById("mainCounter")?.innerHTML = "Już za... " +
            Counter.d(true) +
            Conjugator.conjugate(Conjugator.Word.DZIEN, Counter.d(true), true) +
            Counter.h(true) +
            Conjugator.conjugate(Conjugator.Word.GODZINA, Counter.h(true), true) +
            Counter.m(true) +
            Conjugator.conjugate(Conjugator.Word.MINUTA, Counter.m(true), true) +
            Counter.s(true) +
            Conjugator.conjugate(Conjugator.Word.SEKUNDA, Counter.s(true), true)

    document.getElementById("weeks")?.innerHTML = Counter.w().format(6) +
            Conjugator.conjugate(Conjugator.Word.TYDZIEN, Counter.w(), false)
    document.getElementById("days")?.innerHTML = Counter.d().format(5) +
            Conjugator.conjugate(Conjugator.Word.DZIEN, Counter.d(), false)
    document.getElementById("hours")?.innerHTML = Counter.h().format(4) +
            Conjugator.conjugate(Conjugator.Word.GODZINA, Counter.h(), false)
    document.getElementById("minutes")?.innerHTML = Counter.m().format(3) +
            Conjugator.conjugate(Conjugator.Word.MINUTA, Counter.m(), false)
    document.getElementById("seconds")?.innerHTML = Counter.s().format(2) +
            Conjugator.conjugate(Conjugator.Word.SEKUNDA, Counter.s(), false)

    document.getElementById("percentage")?.innerHTML = Counter.percentage().format(2) + "%"
    val progress = document.getElementById("progress") as HTMLProgressElement
    progress.value = Counter.percentage()
}

fun Double.format(digits: Int): String = this.asDynamic().toFixed(digits) as String