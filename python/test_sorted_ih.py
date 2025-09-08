#This program will tell you if a randomly generated list is sorted or not

import random

unsorted_list = [random.randrange(1, 51) for i in range(20)]
sorted_list = sorted(unsorted_list)

def check_if_sorted(test_list):
    if test_list == sorted(test_list):
        return True
    else:
        return False

print(check_if_sorted(unsorted_list))
print(check_if_sorted(sorted_list))