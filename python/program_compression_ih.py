def compress_string(str):
    result = ''
    if str:
        str = list(str)
        counter = 1
        for char in range(len(str)):
            if len(result) == 0 or not str[char] == result[-2]:
                index = char + 1
                while str[char] == str[index]:
                    counter +=1
                    index+=1
                    if index == len(str):
                        index = 0
                result+=f'{str[char]}{counter}'
                counter = 1
        return result
    return 'Feed me string!'

print(compress_string('aabbccdddeeeeeeee77'))