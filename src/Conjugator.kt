import kotlin.math.floor

object Conjugator {
    fun conjugate(word: Word, value: Double, mainCounter: Boolean): String {
        val rounded = floor(value).toInt()
        val lastDigit = rounded % 10
        val lastTwoDigits = rounded % 100

        if (rounded == 0 && mainCounter) {
            return when (word) {
                Conjugator.Word.SEKUNDA -> " sekund "
                Conjugator.Word.MINUTA -> " minut "
                Conjugator.Word.GODZINA -> " godzin "
                Conjugator.Word.DZIEN -> " dni "
                Conjugator.Word.TYDZIEN -> "tygodni "
            }
        } else if (rounded == 0 && !mainCounter) {
            return when (word) {
                Conjugator.Word.SEKUNDA -> " sekundy "
                Conjugator.Word.MINUTA -> " minuty "
                Conjugator.Word.GODZINA -> " godziny "
                Conjugator.Word.DZIEN -> " dnia "
                Conjugator.Word.TYDZIEN -> " tygodnia "
            }
        } else if (rounded == 1) {
            return when (word) {
                Conjugator.Word.SEKUNDA -> " sekundę "
                Conjugator.Word.MINUTA -> " minutę "
                Conjugator.Word.GODZINA -> " godzinę "
                Conjugator.Word.DZIEN -> " dzień "
                Conjugator.Word.TYDZIEN -> " tydzień "
            }
        } else if ((lastDigit in 2..4) && (lastTwoDigits > 20 || lastTwoDigits < 10)) {
            return when (word) {
                Conjugator.Word.SEKUNDA -> " sekundy "
                Conjugator.Word.MINUTA -> " minuty "
                Conjugator.Word.GODZINA -> " godziny "
                Conjugator.Word.DZIEN -> " dni "
                Conjugator.Word.TYDZIEN -> " tygodnie "
            }
        } else {
            return when (word) {
                Conjugator.Word.SEKUNDA -> " sekund "
                Conjugator.Word.MINUTA -> " minut "
                Conjugator.Word.GODZINA -> " godzin "
                Conjugator.Word.DZIEN -> " dni "
                Conjugator.Word.TYDZIEN -> " tygodni "
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