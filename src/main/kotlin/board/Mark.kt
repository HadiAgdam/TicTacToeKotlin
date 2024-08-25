package board

enum class Mark {
    X,
    O,
    BLANK;

    fun opponent(): Mark {
        return if (this == X) O
        else if (this == O) X
        else BLANK
    }
}