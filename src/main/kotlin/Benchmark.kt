import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.io.File
import kotlin.system.measureTimeMillis


val tripleGliderGunPattern = listOf(
    Cell(2, 5),
    Cell(3, 5),
    Cell(2, 6),
    Cell(3, 6),

    Cell(12, 4),
    Cell(12, 5),
    Cell(12, 6),
    Cell(13, 3),
    Cell(13, 7),
    Cell(14, 8),
    Cell(15, 8),

    Cell(14, 2),
    Cell(15, 2),

    Cell(16, 5),

    Cell(17, 3),
    Cell(18, 4),
    Cell(18, 5),
    Cell(18, 6),
    Cell(17, 7),

    Cell(19, 5),

    Cell(22, 6),
    Cell(22, 7),
    Cell(22, 8),

    Cell(23, 6),
    Cell(23, 7),
    Cell(23, 8),

    Cell(24, 5),
    Cell(24, 9),

    Cell(26, 4),
    Cell(26, 5),

    Cell(26, 9),
    Cell(26, 10),


    Cell(36, 7),
    Cell(36, 8),

    Cell(37, 7),
    Cell(37, 8),

    Cell(2 + 1000, 5 + 1000),
    Cell(3 + 1000, 5 + 1000),
    Cell(2 + 1000, 6 + 1000),
    Cell(3 + 1000, 6 + 1000),

    Cell(12 + 1000, 4 + 1000),
    Cell(12 + 1000, 5 + 1000),
    Cell(12 + 1000, 6 + 1000),
    Cell(13 + 1000, 3 + 1000),
    Cell(13 + 1000, 7 + 1000),
    Cell(14 + 1000, 8 + 1000),
    Cell(15 + 1000, 8 + 1000),

    Cell(14 + 1000, 2 + 1000),
    Cell(15 + 1000, 2 + 1000),

    Cell(16 + 1000, 5 + 1000),

    Cell(17 + 1000, 3 + 1000),
    Cell(18 + 1000, 4 + 1000),
    Cell(18 + 1000, 5 + 1000),
    Cell(18 + 1000, 6 + 1000),
    Cell(17 + 1000, 7 + 1000),

    Cell(19 + 1000, 5 + 1000),

    Cell(22 + 1000, 6 + 1000),
    Cell(22 + 1000, 7 + 1000),
    Cell(22 + 1000, 8 + 1000),

    Cell(23 + 1000, 6 + 1000),
    Cell(23 + 1000, 7 + 1000),
    Cell(23 + 1000, 8 + 1000),

    Cell(24 + 1000, 5 + 1000),
    Cell(24 + 1000, 9 + 1000),

    Cell(26 + 1000, 4 + 1000),
    Cell(26 + 1000, 5 + 1000),

    Cell(26 + 1000, 9 + 1000),
    Cell(26 + 1000, 10 + 1000),


    Cell(36 + 1000, 7 + 1000),
    Cell(36 + 1000, 8 + 1000),

    Cell(37 + 1000, 7 + 1000),
    Cell(37 + 1000, 8 + 1000),

    Cell(2 + 5000, 5 + 5000),
    Cell(3 + 5000, 5 + 5000),
    Cell(2 + 5000, 6 + 5000),
    Cell(3 + 5000, 6 + 5000),

    Cell(12 + 5000, 4 + 5000),
    Cell(12 + 5000, 5 + 5000),
    Cell(12 + 5000, 6 + 5000),
    Cell(13 + 5000, 3 + 5000),
    Cell(13 + 5000, 7 + 5000),
    Cell(14 + 5000, 8 + 5000),
    Cell(15 + 5000, 8 + 5000),

    Cell(14 + 5000, 2 + 5000),
    Cell(15 + 5000, 2 + 5000),

    Cell(16 + 5000, 5 + 5000),

    Cell(17 + 5000, 3 + 5000),
    Cell(18 + 5000, 4 + 5000),
    Cell(18 + 5000, 5 + 5000),
    Cell(18 + 5000, 6 + 5000),
    Cell(17 + 5000, 7 + 5000),

    Cell(19 + 5000, 5 + 5000),

    Cell(22 + 5000, 6 + 5000),
    Cell(22 + 5000, 7 + 5000),
    Cell(22 + 5000, 8 + 5000),

    Cell(23 + 5000, 6 + 5000),
    Cell(23 + 5000, 7 + 5000),
    Cell(23 + 5000, 8 + 5000),

    Cell(24 + 5000, 5 + 5000),
    Cell(24 + 5000, 9 + 5000),

    Cell(26 + 5000, 4 + 5000),
    Cell(26 + 5000, 5 + 5000),

    Cell(26 + 5000, 9 + 5000),
    Cell(26 + 5000, 10 + 5000),


    Cell(36 + 5000, 7 + 5000),
    Cell(36 + 5000, 8 + 5000),

    Cell(37 + 5000, 7 + 5000),
    Cell(37 + 5000, 8 + 5000),

    Cell(2 + 2000, 5 + 2000),
    Cell(3 + 2000, 5 + 2000),
    Cell(2 + 2000, 6 + 2000),
    Cell(3 + 2000, 6 + 2000),

    Cell(12 + 2000, 4 + 2000),
    Cell(12 + 2000, 5 + 2000),
    Cell(12 + 2000, 6 + 2000),
    Cell(13 + 2000, 3 + 2000),
    Cell(13 + 2000, 7 + 2000),
    Cell(14 + 2000, 8 + 2000),
    Cell(15 + 2000, 8 + 2000),

    Cell(14 + 2000, 2 + 2000),
    Cell(15 + 2000, 2 + 2000),

    Cell(16 + 2000, 5 + 2000),

    Cell(17 + 2000, 3 + 2000),
    Cell(18 + 2000, 4 + 2000),
    Cell(18 + 2000, 5 + 2000),
    Cell(18 + 2000, 6 + 2000),
    Cell(17 + 2000, 7 + 2000),

    Cell(19 + 2000, 5 + 2000),

    Cell(22 + 2000, 6 + 2000),
    Cell(22 + 2000, 7 + 2000),
    Cell(22 + 2000, 8 + 2000),

    Cell(23 + 2000, 6 + 2000),
    Cell(23 + 2000, 7 + 2000),
    Cell(23 + 2000, 8 + 2000),

    Cell(24 + 2000, 5 + 2000),
    Cell(24 + 2000, 9 + 2000),

    Cell(26 + 2000, 4 + 2000),
    Cell(26 + 2000, 5 + 2000),

    Cell(26 + 2000, 9 + 2000),
    Cell(26 + 2000, 10 + 2000),


    Cell(36 + 2000, 7 + 2000),
    Cell(36 + 2000, 8 + 2000),

    Cell(37 + 2000, 7 + 2000),
    Cell(37 + 2000, 8 + 2000),
)

fun runBenchmark(simulator: GameOfLifeSimulator, outputFilePath: String) {
    var gridState = GridState(liveCells = tripleGliderGunPattern)
    val generations = 5000
    val results = mutableListOf<BenchmarkResult>()

    for (i in 1..generations) {
        val time = measureTimeMillis {
            gridState = simulator.getNextState(gridState)
        }

        results.add(BenchmarkResult(time, i, gridState.liveCells.size))

        if (i % 5 == 0) {
            writeRes(outputFilePath, results)
        }

        println("gen($i); time taken: ${time}ms; alive cells = ${gridState.liveCells.size}")
    }
}

fun main() {
    runBenchmark(NonConcurrentGameOfLifeSimulator(), "benchmark/non_concurrent_simulator_benchmark.json")
    runBenchmark(ConcurrentGameOfLifeSimulator(), "benchmark/concurrent_simulator_benchmark.json")
}

@Serializable
data class BenchmarkResult(val timeTaken: Long, val generation: Int, val liveCellsCount: Int)

fun writeRes(outputFilePath: String, res: List<BenchmarkResult>) {
    File(outputFilePath).bufferedWriter().use { out ->
        out.write(Json.encodeToString(res))
    }
}