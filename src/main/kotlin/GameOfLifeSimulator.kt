abstract class GameOfLifeSimulator {
    protected fun getAllCandidateForNextGenAliveCells(prevGenLiveCells: List<Cell>): Set<Cell> {
        return listOf(
            prevGenLiveCells.toList(),
            prevGenLiveCells.map { it.getAllNeighbourCells() }.flatten()
        ).flatten().toSet()
    }

    private fun isAliveCellAliveInNextGen(aliveNeighbourCount: Int): Boolean {
        return aliveNeighbourCount == 2 || aliveNeighbourCount == 3
    }

    private fun isDeadCellAliveInNextGen(aliveNeighbourCount: Int): Boolean {
        return aliveNeighbourCount == 3
    }

    protected fun isCellAliveInNextGen(previousGridState: GridState, cell: Cell) =
        previousGridState.getAliveNeighbourCountOf(cell).let {
            when (previousGridState.isCellAlive(cell)) {
                true -> isAliveCellAliveInNextGen(aliveNeighbourCount = it)
                false -> isDeadCellAliveInNextGen(aliveNeighbourCount = it)
            }
        }

    abstract fun getNextState(previousGridState: GridState): GridState
}