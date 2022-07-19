import json
import matplotlib.pyplot as plt

f = open('result.json')
data = json.load(f)
xaxis = [1,2,3,4,5]
for key, val in data.items():
    # print(val)
    plt.scatter(xaxis,val,)

plt.ylabel('some numbers')
plt.show()



f.close()