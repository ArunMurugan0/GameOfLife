data class GridState(val liveCells: Set<Cell>) {
    fun isCellAlive(cell: Cell)
        = liveCells.firstOrNull { it ==  cell} != null

    fun getAliveNeighbourCountOf(cell: Cell): Int {
        return cell.getAllNeighbourCells().count { isCellAlive(it) }
    }
}