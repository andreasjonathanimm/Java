import numpy as np
import math as m
import matplotlib.pyplot as plt

# # image enhancement
# # initial array
# arr = np.array([[80, 80, 100, 100], [70, 80, 90, 100], [85, 85, 95, 90], [100, 110, 100, 95]])
# n = len(arr)
# r = [0, 255]
# print("Initial array: ")
# print(arr)
# print()

# x1 = 85
# x2 = 95
# y1 = 50
# y2 = 200
# print("x1 = ", x1)
# print("x2 = ", x2)
# print("y1 = ", y1)
# print("y2 = ", y2)

# # contrast stretching
# arr2 = arr.copy()
# for i in range(n):
#     for j in range(n):
#         if arr2[i][j] < x1:
#             arr2[i][j] = (arr2[i][j] - r[0]) * ((y1 - r[0]) / (x1 - r[0])) + r[0]
#         elif arr2[i][j] > x2:
#             arr2[i][j] = (arr2[i][j] - r[1]) * ((y2 - r[1]) / (x2 - r[1])) + r[1]
#         else:
#             arr2[i][j] = (arr2[i][j] - x1) * ((y2 - y1) / (x2 - x1)) + y1
# print("Histogram equalization: ")
# print(arr2)
# print()

# # histogram
# hist = np.zeros(256)
# for i in range(n):
#     for j in range(n):
#         hist[arr[i][j]] += 1
# print("Histogram: ")
# # drawing histogram
# plt.bar(range(256), hist)
# plt.show()

arr3 = np.array([[10, 10, 15, 13], [13, 12, 13, 12], [10, 10, 10, 10], [12, 12, 10, 10]])
n = len(arr3)
r = [0, 15]
print("Initial array: ")
print(arr3)
print()

# histogram
hist = np.zeros(16)
for i in range(n):
    for j in range(n):
        hist[arr3[i][j]] += 1
print("Histogram: ")
# drawing histogram
plt.bar(range(16), hist)
plt.show()

# histogram equalization
arr4 = arr3.copy()
for i in range(n):
    for j in range(n):
        arr4[i][j] = (arr4[i][j] - r[0]) * ((r[1] - r[0]) / (n * n - 1)) + r[0]
print("Histogram equalization: ")
print(arr4)
print()
