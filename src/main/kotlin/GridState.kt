data class GridState(val liveCells: List<Cell>) {
    fun isCellAlive(cell: Cell)
        = liveCells.firstOrNull { it ==  cell} != null
}