package board

enum class Mark {
    X,
    O,
    BLANK;

    fun opponent(): Mark {
        return if (this == X) O
        else X
    }
}