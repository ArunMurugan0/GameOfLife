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

    private fun isCellAliveInNextGen(previousGridState: GridState, cell: Cell): Boolean {
        val aliveNeighbourCount = previousGridState.getAliveNeighbourCountOf(cell)
        if (previousGridState.isCellAlive(cell)) {
            if (aliveNeighbourCount == 2 || aliveNeighbourCount == 3) {
                return true
            }

            return false
        }

        return aliveNeighbourCount == 3
    }
}