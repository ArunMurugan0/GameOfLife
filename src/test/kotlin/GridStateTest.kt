import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class GridStateTest {

    @Test
    fun `it should return true if the cell is alive`() {
        val gridState = GridState(liveCells = listOf(
            Cell(1, 1),
            Cell(1, 2),
            Cell(2, 3)
        ))

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
        ))

        val actualResult = gridState.isCellAlive(Cell(-1, 2))

        val expectedResult = false
        assertEquals(expectedResult, actualResult)
    }
}