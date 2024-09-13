package Crypto;

import javax.crypto.*;
import javax.crypto.spec.DESKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

public class TripleDES {
    public static void main(String[] args) throws InvalidKeyException, InvalidKeySpecException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {

        String custom_key = "123456781234567812345678";
        DESKeySpec key_spec = new DESKeySpec(custom_key.getBytes());
        SecretKey des_key = SecretKeyFactory.getInstance("DESede").generateSecret(key_spec);

        byte[] key_byte = des_key.getEncoded();
        String key_str = new String(key_byte);

        System.out.println("Triple DES Key: " + key_str);
        System.out.println("Triple DES Key Size: " + key_str.length());

        Cipher des;
//        des = Cipher.getInstance("DES/ECB/PKCS5Padding");

        // Gives an error because it needs 64 bit input (8bytes block)
        des = Cipher.getInstance("DESede/ECB/NoPadding");

        des.init(Cipher.ENCRYPT_MODE, des_key);

        String msg = "xxxxxxxxxxxxxxxx";
        byte[] text = msg.getBytes();

        System.out.println("Plain Text: " + msg);

        byte[] encrypted_text = des.doFinal(text);

        System.out.println("Cipher Text: " + new String(encrypted_text));

        String encoded_enc_text = Base64.getEncoder().encodeToString(encrypted_text);

        System.out.println("Cipher Text  (Encoded): " + encoded_enc_text);

        // Transmit encoded_enc_text
//        byte[] decoded_enc_text = Base64.getDecoder().decode(encoded_enc_text);

        // Decrypt

        byte[] decoded_enc_text = Base64.getDecoder().decode(encoded_enc_text);
        des.init(Cipher.DECRYPT_MODE, des_key);

        byte[] decrypted_text = des.doFinal(encrypted_text);
        System.out.println("Decrypted text: " + new String(decrypted_text));
    }

}
