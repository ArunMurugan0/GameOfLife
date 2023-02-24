import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CellTest {

    @Test
    fun `it should return all it's neighbour cells`() {
        val cell = Cell(1, 2)

        val actualNeighbourCells  = cell.getAllNeighbourCells()

        val expectedNeighbourCells = listOf(
            Cell(2,  2),
            Cell(1, 3),
            Cell(2, 3),
            Cell(0, 2),
            Cell(1, 1),
            Cell(0, 1),
            Cell(2, 1),
            Cell(0, 3)
        )


        assertEquals(expectedNeighbourCells.size, actualNeighbourCells.size)
        assertTrue(expectedNeighbourCells.containsAll(actualNeighbourCells))
    }
}