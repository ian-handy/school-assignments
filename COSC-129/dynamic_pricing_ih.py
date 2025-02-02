# This program will calculate the price based on the type of vehicle and whether you are diving on or off-season.

def dynamic_pricing():
    car = {'on':5,
            'off':3}
    truck = {'on':10,
            'off':7}
    motorcycle = {'on':3,
            'off':2}
    vehicle_type = input("Please choose your vehicle from the following list (Car, Truck, Motorcycle):")
    if vehicle_type.lower() == 'car':
        vehicle_type = car
    elif vehicle_type.lower() == 'truck':
        vehicle_type = truck
    else:
        vehicle_type = motorcycle
    season_type = input("Are we currently in the on or off-season? (on,off):")
    return f'${vehicle_type[season_type]}'
print(dynamic_pricing())