keyboard = " `1234567890-=  QWERTYUIOP[]\\  ASDFGHJKL;'  ZXCVBNM,./ "
try:
    while 1:
        print("".join(keyboard[keyboard.find(c) - 1] for c in input()))
except EOFError:
    pass
