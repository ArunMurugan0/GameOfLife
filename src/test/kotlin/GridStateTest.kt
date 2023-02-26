import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class GridStateTest {

    @Test
    fun `it should return true if the cell is alive`() {
        val gridState = GridState(liveCells = listOf(
            Cell(1, 1),
            Cell(1, 2),
            Cell(2, 3)
        )
        )

        val actualResult = gridState.isCellAlive(Cell(1, 2))

        val expectedResult = true
        assertEquals(expectedResult, actualResult)
    }

    @Test
    fun `it should return false if the cell is not alive`() {
        val gridState = GridState(liveCells = listOf(
            Cell(1, 1),
            Cell(1, 2),
            Cell(2, 3)
        )
        )

        val actualResult = gridState.isCellAlive(Cell(-1, 2))

        val expectedResult = false
        assertEquals(expectedResult, actualResult)
    }

    @Test
    fun `it should return the count of alive neighbours`() {
        val gridState = GridState(liveCells = listOf(Cell(1, 1), Cell(2, 2), Cell(0, 2)))

        val actualCount = gridState.getAliveNeighbourCountOf(Cell(2, 2))

        val expectedCount = 1
        assertEquals(expectedCount, actualCount)
    }
}