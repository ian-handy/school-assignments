#This program will pull a column of data from an excel file and calculate the mean, median, mode, and midrange of the data set

import pandas as pd
import matplotlib.pyplot as plt
import numpy as np

plt.close('all')

header_present = int(input("Header present? 1. Yes 0. No: "))

data = ''

if header_present == 1:
    data = pd.read_excel('/Users/ianhandy/Downloads/data.xlsx',sheet_name=0)
else:
    data = pd.read_excel('/Users/ianhandy/Downloads/data.xlsx',sheet_name=0,header=None)




def get_mean(data_set):
    return data_set.mean()
def get_median(data_set):
    return data_set.median()
def get_mode(data_set):
    return data_set.mode()

def print_results():
    print(f'Mean: {get_mean(data)}\nMedian: {get_median(data)}\nMode: {get_mode(data)}')

print_results()
    