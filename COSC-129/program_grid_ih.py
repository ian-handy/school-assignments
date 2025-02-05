#This program will create an x by x grid, where x is the number given by the user

def grid():
    grid_size = int(input("Please enter a number for the size of the grid: "))
    result = ''
    for i in range(grid_size**2):
        if (i+1)%grid_size == 0:
            result+=(f'{i+1}\n')
        else:
            result+=(f'{i+1}\t')
    return result
print(grid())