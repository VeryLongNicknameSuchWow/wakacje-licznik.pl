import kotlin.math.floor

object Conjugator {
    fun conjugate(word: Word, value: Double, mainCounter: Boolean): String {
        val rounded = floor(value).toInt()
        val lastDigit = rounded % 10
        val lastTwoDigits = rounded % 100

        if (rounded == 0 && mainCounter) {
            return when (word) {
                Word.SEKUNDA -> " sekund "
                Word.MINUTA -> " minut "
                Word.GODZINA -> " godzin "
                Word.DZIEN -> " dni "
                Word.TYDZIEN -> "tygodni "
            }
        } else if (rounded == 0 && !mainCounter) {
            return when (word) {
                Word.SEKUNDA -> " sekundy "
                Word.MINUTA -> " minuty "
                Word.GODZINA -> " godziny "
                Word.DZIEN -> " dnia "
                Word.TYDZIEN -> " tygodnia "
            }
        } else if (rounded == 1) {
            return when (word) {
                Word.SEKUNDA -> " sekundę "
                Word.MINUTA -> " minutę "
                Word.GODZINA -> " godzinę "
                Word.DZIEN -> " dzień "
                Word.TYDZIEN -> " tydzień "
            }
        } else if ((lastDigit in 2..4) && (lastTwoDigits > 20 || lastTwoDigits < 10)) {
            return when (word) {
                Word.SEKUNDA -> " sekundy "
                Word.MINUTA -> " minuty "
                Word.GODZINA -> " godziny "
                Word.DZIEN -> " dni "
                Word.TYDZIEN -> " tygodnie "
            }
        } else {
            return when (word) {
                Word.SEKUNDA -> " sekund "
                Word.MINUTA -> " minut "
                Word.GODZINA -> " godzin "
                Word.DZIEN -> " dni "
                Word.TYDZIEN -> " tygodni "
            }
        }
    }

    enum class Word {
        SEKUNDA,
        MINUTA,
        GODZINA,
        DZIEN,
        TYDZIEN
    }
}