import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.runBlocking

class ConcurrentGameOfLifeSimulator : GameOfLifeSimulator() {
    override fun getNextState(previousGridState: GridState): GridState {
        return GridState(
            liveCells = runBlocking { runTask(previousGridState, previousGridState.liveCells).toList() }
        )
    }

    private suspend fun runTask(state: GridState, list: List<Cell>): Set<Cell> = coroutineScope {
        if (list.size < 100) {
            return@coroutineScope getAllCandidateForNextGenAliveCells(prevGenLiveCells = list)
                .filter { isCellAliveInNextGen(state, it) }
                .toSet()
        }

        val m = list.size / 2

        val leftList = list.subList(0, m + 1)
        val coroutineOne = async(Dispatchers.Default) { runTask(state, leftList) }
        coroutineOne.start()

        val rightList = list.subList(m + 1, list.size)
        val coroutineTwo = async(Dispatchers.Default) { runTask(state, rightList) }
        coroutineTwo.start()

        return@coroutineScope merge(coroutineOne.await(), coroutineTwo.await())
    }

    private fun merge(a: Set<Cell>, b: Set<Cell>) = a.plus(b)
}