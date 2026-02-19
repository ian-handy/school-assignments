def is_valid(pwd):
    if len(pwd) >= 8:
        if not pwd.upper() == pwd:
            if not pwd.lower() == pwd:
                digit = False
                symbol = False
                for char in pwd:
                    if char.isnumeric():
                        digit = True
                    if not char.isalnum() or char.isspace():
                        symbol = True
                if digit and symbol:
                    return True
    return False

print(is_valid('P4$$w0rd'))