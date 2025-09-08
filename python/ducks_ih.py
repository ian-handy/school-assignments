#This program deals with ducks

duck_hell = []

ducks = ["Jack", "Kack", "Lack", "Mack", "Nack", "Oack", "Pack", "Qack"]
print(ducks)

ducks.sort()
print(ducks)

ducks.append("Uack")
print(ducks)

duck_hell.append(ducks.pop(5))
#Wack him
print(ducks)

ducks.insert(2, "Vack")
print(ducks)

ducks.sort(reverse=True)
print(ducks)

ducks.insert(2, duck_hell.pop(0))
print(ducks)

ducks.append("Xack")
print(ducks)

ducks = [duck for duck in ducks if duck !="Uack"]
#Send him to oblivion
print(ducks)

duck_hell.append(ducks.pop(-1))
print(ducks)

ducks = [duck for duck in ducks if duck !="Vack"]
#No more headaches
print(ducks)

ducks.append(duck_hell.pop(0))
print(ducks)

ducks = [duck for duck in ducks if duck !="Xack"]
#Peking Duck
print(ducks)

print(len(ducks))

ducks.sort()
print(ducks)