import json
import matplotlib.pyplot as plt

f = open('result.json')
data = json.load(f)
xaxis = [1,2,3,4,5]

fig, ax = plt.subplots()


agent1 = list(map(lambda e: sum(e["0"][0:2]), data))
agent2 = list(map(lambda e: sum(e["1"][0:2]), data))


# print(agent1)

ax.plot(list(agent1), label='agent 1')
ax.plot(list(agent2), label='agent 2')

ax.legend()

# for run in data:
#     for key, val in run.items():
#         if key == '0':
#             plt.scatter(xaxis,val,c='r')
#         else:
#             plt.scatter(xaxis,val,c='g')
        
plt.show()

f.close()