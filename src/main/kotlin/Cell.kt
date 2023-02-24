data class Cell(val x: Long, val y: Long) {
    fun getAllNeighbourCells(): List<Cell> {
        return listOf(
            Cell(x - 1, y),
            Cell(x, y - 1),
            Cell(x + 1, y),
            Cell(x, y + 1),
            Cell(x + 1, y + 1),
            Cell(x - 1, y - 1),
            Cell(x + 1, y - 1),
            Cell(x - 1, y + 1),
        )
    }
}