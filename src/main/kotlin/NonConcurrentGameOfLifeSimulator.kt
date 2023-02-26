class NonConcurrentGameOfLifeSimulator: GameOfLifeSimulator() {
    override fun getNextState(previousGridState: GridState): GridState {
        return GridState(
            liveCells = getAllCandidateForNextGenAliveCells(previousGridState.liveCells)
                .filter { isCellAliveInNextGen(previousGridState, it) }
        )
    }
}