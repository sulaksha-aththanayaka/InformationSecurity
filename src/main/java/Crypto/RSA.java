package Crypto;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

public class RSA {
    public static void main(String[] args) throws InvalidKeyException, InvalidKeySpecException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException, UnsupportedEncodingException {
        KeyPairGenerator key_gen = KeyPairGenerator.getInstance("RSA");
        key_gen.initialize(2048);
        KeyPair key_pair = key_gen.generateKeyPair();

        PrivateKey pvt_key = key_pair.getPrivate();
        PublicKey pub_key = key_pair.getPublic();

        PrivateKey alice_pvt_key        System.out.println("Private Key: " + new String(pvt_key.getEncoded()));
        System.out.println("Public Key: " + new String(pub_key.getEncoded()));

        Cipher rsa;
        rsa = Cipher.getInstance("RSA");

        rsa.init(Cipher.ENCRYPT_MODE, pub_key);

        String msg = "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx";
        byte[] text = msg.getBytes("UTF-8");

        System.out.println("Plain Text: " + msg);

        byte[] encrypted_text = rsa.doFinal(text);

        System.out.println("Cipher Text: " + new String(encrypted_text));

        String encoded_enc_text = Base64.getEncoder().encodeToString(encrypted_text);

        System.out.println("Cipher Text  (Encoded): " + encoded_enc_text);

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
