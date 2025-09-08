#This program will convert a given temperature to another scale given the numeric value, original scale, and scale to be converted to
def convert_temperature(orig_scale,conv_scale,deg):
    f_to_c = lambda x: (x-32)*5/9
    c_to_f = lambda x: (x*9/5)+32
    c_to_k = lambda x: x+273.15
    k_to_c = lambda x: x-273.15
    if orig_scale.lower() == 'c':
        if conv_scale.lower() == 'f':
            return c_to_f(deg)
        if conv_scale.lower() == 'k':
            return c_to_k(deg)
    elif orig_scale.lower() == 'f':
        if conv_scale.lower() == 'c':
            return f_to_c(deg)
        if conv_scale.lower() == 'k':
            return c_to_k(f_to_c(deg))
    elif orig_scale.lower() == 'k':
        if conv_scale.lower() == 'c':
            return k_to_c(deg)
        if conv_scale.lower() == 'f':
            return c_to_f(k_to_c(deg))

def convert_temperature_inputs():
    print("This program will convert temperatures for you. Please use 'C' for Celcius, 'F' for Fahrenheit, and 'K' for 'Kelvin")
    orig_scale = input('Please enter the scale your are converting from: ').upper()
    conv_scale = input('Please enter the scale your are converting to: ').upper()
    deg = float(input("Please enter the degree number that you are converting: "))
    return f'{deg} {orig_scale} is equal to {round(convert_temperature(orig_scale,conv_scale,deg),2)} {conv_scale}'

print(convert_temperature_inputs())