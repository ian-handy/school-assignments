def get_message():
    return input("Please enter your message:")

# def clean_message(msg):
#     clean_msg = ''
#     for char in msg:
#         if char.islower() or char.isupper():
#             clean_msg+=char
#     return clean_msg.upper()

def clean_message(msg):
    clean_msg = ''
    msg = msg.upper()
    for char in msg:
        if ord(char) >= 65 and ord(char) <= 90:
            clean_msg+= char
    return clean_msg

def encrypt_message(msg):
    encrypt_msg = ''
    for char in msg:
        enc = ord(char) + 3
        if enc >90:
            enc -= 26
        encrypt_msg+= chr(enc)
    return encrypt_msg
            


print(encrypt_message(clean_message(get_message())))