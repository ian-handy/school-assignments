import csv

with open('datasets/superbowls_to_2024.csv', 'r') as csv_in:
    reader = csv.reader(csv_in)
    
    for row in reader:
        score_dif = abs(int(row[4].split('-')[0]) - int(row[4].split('-')[1]))
        print(f'Year: {row[0]}, Score Difference: {score_dif}')