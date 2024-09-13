package Crypto;

import javax.crypto.*;
import javax.crypto.spec.DESKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class DES {
    public static void main(String[] args) throws InvalidKeyException, InvalidKeySpecException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {

        String custom_key = "12345678";
        DESKeySpec key_spec = new DESKeySpec(custom_key.getBytes());
        SecretKey des_key = SecretKeyFactory.getInstance("DES").generateSecret(key_spec);

        byte[] key_byte = des_key.getEncoded();
        String key_str = new String(key_byte);

        System.out.println("DES Key: " + key_str);
        System.out.println("DES Key Size: " + key_str.length());

        Cipher des;
        des = Cipher.getInstance("DES/ECB/PKCS5Padding");

        des.init(Cipher.ENCRYPT_MODE, des_key);

        String msg = "xxxxxxxxxxxxxx";
        byte[] text = msg.getBytes();

        System.out.println("Plain Text: " + msg);

        byte[] encrypted_text = des.doFinal(text);

        System.out.println("Cipher Text: " + new String(encrypted_text));

        // Decrypt
        des.init(Cipher.DECRYPT_MODE, des_key);

        byte[] decrypted_text = des.doFinal(encrypted_text);
        System.out.println("Decrypted text: " + new String(decrypted_text));
    }
}
