import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class EncryptedPrinter extends PrinterDecorator {

    public EncryptedPrinter(Printer decorable) {
        super(decorable);
    }

    @Override
    public void print(String text) {
        try {
            SecretKey key = generateKey();
            GCMParameterSpec gcmParameterSpec = generateIv();
            String encryptedText = encrypt(text, key, gcmParameterSpec);
            super.print(encryptedText);
            //System.out.println("Decrypted: " + decrypt(encryptedText, key, gcmParameterSpec));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Advanced Encryption Standard (AES), symmetric-key encryption algorithm using Java Cryptography Architecture (JCA)
    // Based on this tutorial: https://www.baeldung.com/java-aes-encryption-decryption

    // Generate a secret key using the KeyGenerator class:
    public static SecretKey generateKey() throws NoSuchAlgorithmException {
        KeyGenerator keygenerator = KeyGenerator.getInstance("AES");
        keygenerator.init(128);
        return keygenerator.generateKey();
    }

    // Initialization Vector (IV): "a pseudo-random value used to ensure that the same plaintext encrypted with the same key produces different ciphertexts".
    public static GCMParameterSpec generateIv() {
        byte[] iv = new byte[12];
        new SecureRandom().nextBytes(iv);
        return new GCMParameterSpec(128, iv);
    }

    // Method for encrypting a string input. Parameters: input, the secret key and the initialization vector
    public static String encrypt(String input, SecretKey key, GCMParameterSpec iv)
            throws Exception {
        // Create an instance from the Cipher class by using the getInstance() method
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        // Configure a cipher instance using the init() method with a secret key, IV, and ENCRYPTION mode
        cipher.init(Cipher.ENCRYPT_MODE, key, iv);
        // Encrypt the input string by invoking the doFinal() method (gets bytes of input and returns ciphertext in bytes)
        byte[] cipherText = cipher.doFinal(input.getBytes());
        return Base64.getEncoder()
                .encodeToString(cipherText);
    }

    // Method for decrypting a string ciphered text. Parameters: ciphered text, the secret key and the initialization vector
    public static String decrypt(String cipherText, SecretKey key, GCMParameterSpec iv) throws Exception {
        // Create an instance from the Cipher class by using the getInstance() method
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        // Configure a cipher instance using the init() method with a secret key, IV, and DECRYPTION mode
        cipher.init(Cipher.DECRYPT_MODE, key, iv);
        // Decrypt the input string by invoking the doFinal() method (decode ciphertext to bytes, returns plaintext in bytes)
        byte[] plainText = cipher.doFinal(Base64.getDecoder()
                .decode(cipherText));
        return new String(plainText);
    }
}
