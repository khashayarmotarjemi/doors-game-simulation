import json
import matplotlib.pyplot as plt

f = open('result.json')

data = json.load(f)

fig, ax = plt.subplots()

for agent in data["results"]:
    res = list(map(lambda e: sum(e[0:2]), agent["results"]))
    ax.plot(res, label=agent['agentId'])
   
      
plt.ylim([0,80])

ax.legend()   
plt.show()

f.close()