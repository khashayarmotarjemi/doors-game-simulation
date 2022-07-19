import json
import matplotlib.pyplot as plt

f = open('result.json')
data = json.load(f)
xaxis = [1,2,3,4,5]
for row in data:
    plt.scatter(xaxis,row)

plt.ylabel('some numbers')
plt.show()



f.close()