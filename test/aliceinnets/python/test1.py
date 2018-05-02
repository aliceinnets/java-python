import numpy as np
import matplotlib.pyplot as plt

x = np.linspace(0, 10, 100)
y = np.sin(x)
x[1] = None
x[2] = np.inf
x[3] = -np.inf
x[4] = np.nan
print(x)
plt.plot(x, y, label=None)
plt.savefig(r'C:\Users\sehk\PythonScript\/test.pdf')
plt.show()
