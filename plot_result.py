import json
import matplotlib.pyplot as plt

f = open('result.json')
data = json.load(f)
xaxis = [1,2,3,4,5]

for run in data:
    for key, val in run.items():
        if key == '0':
            plt.scatter(xaxis,val,c='r')
        else:
            plt.scatter(xaxis,val,c='g')
        
plt.show()

f.close()