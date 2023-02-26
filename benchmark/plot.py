import matplotlib.pyplot as plt
import json

result = json.load(open('non_concurrent_simulator_benchmark.json', 'r'))
xAxis = [v["generation"] for v in result]
yAxis = [v["timeTaken"] for v in result]
plt.plot(xAxis,yAxis, color='maroon', label='Single Threaded')

result = json.load(open('concurrent_simulator_benchmark.json', 'r'))
xAxis = [v["generation"] for v in result]
yAxis = [v["timeTaken"] for v in result]
plt.plot(xAxis,yAxis, color='blue', label='Multi threaded (Concurrent)')

plt.xlabel('Generation')
plt.ylabel('Time Taken (ms)')
plt.legend()

plt.show()