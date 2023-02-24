data class GridState(val liveCells: Set<Cell>) {
    fun isCellAlive(cell: Cell)
        = liveCells.contains(cell)

    fun getAliveNeighbourCountOf(cell: Cell): Int {
        return cell.getAllNeighbourCells().count { isCellAlive(it) }
    }
}