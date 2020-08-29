import kotlin.js.Date
import kotlin.math.floor


object Counter {
    private fun dif() = CounterDate.closestFutureDate().date.getTime() - Date.now()

    fun s(parsed: Boolean = false): Double = if (parsed) floor(s() % 60) else dif() / 1000

    fun m(parsed: Boolean = false): Double = if (parsed) floor(m() % 60) else s() / 60

    fun h(parsed: Boolean = false): Double = if (parsed) floor(h() % 24) else m() / 60

    fun d(parsed: Boolean = false): Double = if (parsed) floor(d()) else h() / 24

    fun w(): Double = d() / 7

    fun percentage(): Double {
        val pastToFuture = CounterDate.closestFutureDate().date.getTime() - CounterDate.closestPastDate().date.getTime()
        val pastToNow = Date.now() - CounterDate.closestPastDate().date.getTime()

        return pastToNow / pastToFuture * 100
    }

    class CounterDate(val date: Date, val type: Type) : Comparable<CounterDate> {
        override fun compareTo(other: CounterDate): Int = this.date.getTime().compareTo(other.date.getTime())

        init {
            dates += this
            dates.sort()
        }

        enum class Type {
            HOLIDAYS,
            SCHOOL,
            CORONAVIRUS
        }

        companion object {
            private val dates = ArrayList<CounterDate>()

            fun closestFutureDate(): CounterDate {
                for (date in dates) if (date.date.getTime() - Date.now() > 0) return date

                return dates.last()
            }

            fun closestPastDate(): CounterDate {
                val sorted = dates.sortedDescending()

                for (date in sorted) if (Date.now() - date.date.getTime() > 0) return date

                return sorted.last()
            }
        }
    }
}
