#This program will test if a given integer is prime or not
def is_prime(num):
    if num<=3:
        return True
    for i in range(int((num/2)+1))[2:]:
        if num%i==0:
            return False
    return True

primes_under_100 = [x for x in range(101)[2:-1] if is_prime(x)]
print(f'Primes under 100: \n{primes_under_100}')