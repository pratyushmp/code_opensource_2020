##
## Decryption
##


def choosedecryptionkey(decryptionkey, encryptionkey, n):   # Choosing key to decrypt message
    for i in range(1, n):
        if (i * encryptionkey) % n == 1:
            decryptionkey = i
            break
    return decryptionkey


def decryptmessage(encryptedmessage, decryptionkey, n):     # Decrypt the message that you got from encrypting.
    en = encryptedmessage ** decryptionkey % n
    return en
