class GameOfLifeSimulator {
    fun getNextState(previousGridState: GridState): GridState {
        return GridState(
            liveCells =
            getAllCandidateForNextGenAliveCells(previousGridState.liveCells)
                .filter { isCellAliveInNextGen(previousGridState, it) }
                .toSet()
        )
    }

    private fun getAllCandidateForNextGenAliveCells(prevGenLiveCells: Set<Cell>): Set<Cell> {
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

    private fun isCellAliveInNextGen(previousGridState: GridState, cell: Cell) =
        previousGridState.getAliveNeighbourCountOf(cell).let {
            when (previousGridState.isCellAlive(cell)) {
                true -> isAliveCellAliveInNextGen(aliveNeighbourCount = it)
                false -> isDeadCellAliveInNextGen(aliveNeighbourCount = it)
            }
        }
}