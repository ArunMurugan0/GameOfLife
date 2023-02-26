import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class GameOfLifeSimulatorTest {

    @Test
    fun `alive cell should die if it has less than 2 alive neighbours`(){
        val initialGridState = GridState(
            liveCells = listOf(
                Cell(1, 1),
                Cell(0, 2),
                Cell(2, 2)
            )
        )

        val actualGridState = NonConcurrentGameOfLifeSimulator().getNextState(initialGridState)

        val expectedGridState = GridState(
            liveCells = listOf(Cell(1, 1), Cell(1, 2))
        )
        assertEquals(expectedGridState, actualGridState)
    }

    @Test
    fun `alive cell should die if it has more than 3 neighbours`(){
        val initialGridState = GridState(
            liveCells = listOf(
                Cell(1, 1),
                Cell(1, 2),
                Cell(0, 2),
                Cell(2, 2),
                Cell(1, 0)
            )
        )

        val actualGridState = NonConcurrentGameOfLifeSimulator().getNextState(initialGridState)

        val expectedGridState = GridState(
            liveCells = listOf(Cell(2, 2), Cell(1, 2), Cell(0, 2), Cell(1, 3))
        )
        assertEquals(expectedGridState, actualGridState)
    }

    @Test
    fun `dead cell should become alive if has 3 alive neighbours`() {
        val gridState = GridState(liveCells = listOf(
            Cell(0, 2),
            Cell(2, 2),
            Cell(1, 0)
        )
        )

        val actualGridState = NonConcurrentGameOfLifeSimulator().getNextState(gridState)

        val expectedGridState = GridState(
            liveCells = listOf(
                Cell(1, 1)
            )
        )
        assertEquals(expectedGridState, actualGridState)
    }

}