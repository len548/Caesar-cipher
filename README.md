# Caesar-cipher
<p>Caesar cipher (aka shift cipher) is one of simple encryption techniques where each letter of a given plaintext is replaced by a letter some fixed number of positions down the alphabet. 
  In this project, the Caesar class provides a method to set a key (some fixed number of positions to shift letters in alphabet), encryption and decryption methods.
  For example, if the key is set to 3, encryption method shift 'a' to 'd' and 'c' to 'f'</p>

[More about Caesar cipher](https://en.wikipedia.org/wiki/Caesar_cipher)

# Implemented methods

- `Caesar(int key)`: Instantiate the object of the class and set the key.
- `setKey(int key)`: Set the key.
- `encrypt(String plaintext)`: Each letter of the given plain text will be shifted to the right by the number of the key.
- `decrypt(String ciphertext)`: Each letter of the given cipher text will be shifted to the left by the number of the key.

# Constraints
- The key must be between 1 and 25.
- plaintext to be encrypted must consists of only English alphabet [a-zA-Z]. No digits, special characters or any other is in the text.

# Tests for Caesar class
- correctness of encrypt and decrypt methods
- exception handling
    - the number not between 1 and 25 should not be accepted for the key of caesar cipher.
    - non-English-alphabet characters should not be accepted for any letter in a plaintext to be encrypted or decrypted.