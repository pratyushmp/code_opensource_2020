##
##  Main
##

import Encrypt
import Decrypt

p = 3  # First random primmer
q = 16843  # Second random primmer

N = p * q  # Product of p and q, modules for encryption and decryption key

encryptKey = 0  # Encryption key
decryption = 0  # Decryption key

pq = (p - 1) * (q - 1)

coprimeNumbersN = list(range(2, N))  # numbers with the chosen N
coPrimeNumbersPQ = list(range(2, pq))  # numbers with the chosen p and q

#   Calculating the coprime numbers relative to the input
coPrimeNumbersN = Encrypt.phi(N, coprimeNumbersN, p, q)
coPrimeNumbersPQ = Encrypt.phi(pq, coPrimeNumbersPQ, p, q)

#   Encryption key and encryptLock generation
encryptKey = Encrypt.chooseencryptionkey(encryptKey, coPrimeNumbersPQ)
encryptLock = [encryptKey, N]

#   Decryption key generation
decryption = Decrypt.choosedecryptionkey(decryption, encryptKey, pq)
decryptionKey = [decryption, N]

print(encryptLock)
print(decryptionKey)
print("***********")

#   Final printing with message to encrypt/decrypt and generating
message = 2
#
cryptedmessage = Encrypt.encryptmessage(message, encryptKey, N)
deciphered = Decrypt.decryptmessage(cryptedmessage, decryption, N)
print("Message: ", message)
print("Ciphered message: ", cryptedmessage)
print("Deciphered message: ", deciphered)
