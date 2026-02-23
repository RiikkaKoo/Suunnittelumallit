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

    public static SecretKey generateKey() throws NoSuchAlgorithmException {
        KeyGenerator keygenerator = KeyGenerator.getInstance("AES");
        keygenerator.init(128);
        return keygenerator.generateKey();
    }

    public static GCMParameterSpec generateIv() {
        byte[] iv = new byte[12];
        new SecureRandom().nextBytes(iv);
        return new GCMParameterSpec(128, iv);
    }

    public static String encrypt(String input, SecretKey key, GCMParameterSpec iv)
            throws Exception {
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        cipher.init(Cipher.ENCRYPT_MODE, key, iv);
        byte[] cipherText = cipher.doFinal(input.getBytes());
        return Base64.getEncoder()
                .encodeToString(cipherText);
    }

    public static String decrypt(String cipherText, SecretKey key, GCMParameterSpec iv) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        cipher.init(Cipher.DECRYPT_MODE, key, iv);
        byte[] plainText = cipher.doFinal(Base64.getDecoder()
                .decode(cipherText));
        return new String(plainText);
    }
}
