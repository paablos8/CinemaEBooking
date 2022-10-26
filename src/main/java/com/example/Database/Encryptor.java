package com.example.Database;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.ByteBuffer;
import java.security.*;
import java.util.Base64;

class Encryptor
{
//    private SecretKey key;
//    private String encodedKey = "RbpDoQygNVytZnWkJuK89aVGYk/Olbq2Pmd/VgngYmo=";

//    public static final int AES_KEY_SIZE = 256;

    /*
        public Encryptor()
    {
        try
        {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        }
        catch (NoSuchAlgorithmException|NoSuchPaddingException e)
        {
            e.printStackTrace();
        }

        /*
        byte[] decodedKey = Base64.getDecoder().decode(encodedKey);
        key = new SecretKeySpec(decodedKey, 0, decodedKey.length, "AES");

    }
    */

    String encrypt(String input)
    {
        /*
        Cipher cipher = null;
        try {
            cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        } catch (NoSuchAlgorithmException|NoSuchPaddingException e)
        {
            throw new RuntimeException(e);
        }
        SecretKeySpec keySpec = new SecretKeySpec(key.getEncoded(), "AES");

        try
        {
            cipher.init(Cipher.ENCRYPT_MODE, keySpec);
        }
        catch (InvalidKeyException e)
        {
            e.printStackTrace();
        }

        // Perform Encryption
        byte[] cipherText = new byte[0];
        try {
            cipherText = cipher.doFinal(input.getBytes());
        }
        catch (IllegalBlockSizeException|BadPaddingException e)
        {
            throw new RuntimeException(e);
        }

        return String.valueOf(cipherText);
        */
        byte[] temp = Base64.getDecoder().decode(input);
        for(int i = 0; i <temp.length; i ++)
        {
            temp[i] += 2;
        }
        return Base64.getEncoder().encodeToString(temp);
    }

    String decrypt(String cipherText)
    {
        /*
        Cipher cipher = null;
        try {
            cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (NoSuchPaddingException e) {
            throw new RuntimeException(e);
        }
        SecretKeySpec keySpec = new SecretKeySpec(key.getEncoded(), "AES");

        try
        {
            cipher.init(Cipher.DECRYPT_MODE, keySpec);
        }
        catch (InvalidKeyException e)
        {
            throw new RuntimeException(e);
        }

        byte[] decryptedText = null;
        // Perform Decryption on encrypted text
        try
        {
            decryptedText = cipher.doFinal(cipherText.getBytes());
        }
        catch (IllegalBlockSizeException e)
        {
            e.printStackTrace();
        }
        catch(BadPaddingException e)
        {
            throw new RuntimeException(e);
        }
        return Base64.getEncoder().encodeToString(decryptedText);
        */
        byte[] temp = Base64.getDecoder().decode(cipherText);
        for(int i = 0; i <temp.length; i ++)
        {
            temp[i] -= 2;
        }
        return Base64.getEncoder().encodeToString(temp);
    }

    SecretKey generateKey()
    {
        SecretKey key = null;
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            //keyGenerator.init(AES_KEY_SIZE);
            key = keyGenerator.generateKey();
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        return key;
    }

}
