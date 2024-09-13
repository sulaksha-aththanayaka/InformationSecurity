package Crypto;

import javax.crypto.*;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

public class AES {
    public static void main(String[] args) throws InvalidKeyException, InvalidKeySpecException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException, UnsupportedEncodingException {

//        String custom_key = "123456781234567812345678";
//        DESKeySpec key_spec = new DESKeySpec(custom_key.getBytes());

        byte[] key_array = new byte[] {'T', 'h', 'e', 'B', 'e', 's', 't', 'S', 'e', 'c', 'r', 'e', 't', 'K', 'e', 'y'};
        SecretKeySpec key = new SecretKeySpec(key_array, "AES");

//        byte[] key_byte = des_key.getEncoded();
//        String key_str = new String(key_byte);

        System.out.println("AES Key Phrase: " + new String(key.getEncoded()));
//        System.out.println("Triple DES Key Size: " + key_str.length());

        Cipher aes;
        aes = Cipher.getInstance("AES/CBC/PKCS5Padding");

        String iv_str = "AAAAAAAAAAAAAAAA";
        IvParameterSpec iv = new IvParameterSpec(iv_str.getBytes());

        aes.init(Cipher.ENCRYPT_MODE, key, iv);

        String msg = "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx";
        byte[] text = msg.getBytes("UTF-8");



//        byte[] text = iv_str.getBytes();

        System.out.println("Plain Text: " + iv_str);

        byte[] encrypted_text = aes.doFinal(text);

        System.out.println("Cipher Text: " + new String(encrypted_text));
//
//        String encoded_enc_text = Base64.getEncoder().encodeToString(encrypted_text);
//
//        System.out.println("Cipher Text  (Encoded): " + encoded_enc_text);

        // Transmit encoded_enc_text
//        byte[] decoded_enc_text = Base64.getDecoder().decode(encoded_enc_text);

        // Decrypt

//        byte[] decoded_enc_text = Base64.getDecoder().decode(encoded_enc_text);
//        des.init(Cipher.DECRYPT_MODE, des_key);
//
//        byte[] decrypted_text = des.doFinal(encrypted_text);
//        System.out.println("Decrypted text: " + new String(decrypted_text));
    }
}
