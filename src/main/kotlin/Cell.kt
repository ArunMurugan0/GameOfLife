import java.math.BigInteger
import java.math.BigInteger.ONE

data class Cell(val x: BigInteger, val y: BigInteger) {
    constructor(x: Long, y: Long): this(BigInteger.valueOf(x), BigInteger.valueOf(y))

    fun getAllNeighbourCells(): List<Cell> {
        return listOf(
            Cell(x - ONE, y),
            Cell(x, y - ONE),
            Cell(x + ONE, y),
            Cell(x, y + ONE),
            Cell(x + ONE, y + ONE),
            Cell(x - ONE, y - ONE),
            Cell(x + ONE, y - ONE),
            Cell(x - ONE, y + ONE),
        )
    }
}