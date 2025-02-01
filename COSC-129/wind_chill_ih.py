#Wind Chill Assignment

def wind_chill():
    print("This program will calculate the wind chill for a given temperature (in Fahrenheit between -58 and 41) and a given wind speed.")
    ambient_temp = float(input("Please enter the ambient temperature in degrees fahrenheit between -58 and 41: "))
    wind_speed = float(input("Please enter the windspeed in miles per hour: "))
    print(f'The windchill is: {35.74 + (0.6215 * ambient_temp) - (35.75* wind_speed ** .16) + (0.4275 * ambient_temp * wind_speed **0.16)}')
wind_chill()