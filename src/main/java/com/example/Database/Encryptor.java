package com.example.Database;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.*;

/**
 * This is for encrypting the user's password and card number.
 * It is not using state-of-the-art encryption, but it's better
 * than nothing.
 */
class Encryptor
{
    // I am only using one key. Ideally, there would be many.
    private byte[] decodedKey = {-88,-38,-116,88,-38,32,38,55};
    private SecretKey key;
    private Cipher cipher;

    public Encryptor()
    {
        try
        {
            cipher = Cipher.getInstance("DES/ECB/NoPadding");
        }
        catch (NoSuchAlgorithmException|NoSuchPaddingException e)
        {
            e.printStackTrace();
        }

        //key = new SecretKeySpec(decodedKey, 0, decodedKey.length, "DES");

        /*
        String enc = encrypt("Toby");
        System.out.println(enc);
        System.out.println(decrypt(enc));
        */

        
        /*
        SecretKey key = generateKey();
        byte[] keyBytes = key.getEncoded();

        for(int i = 0; i < keyBytes.length; i++)
        {
            System.out.println(keyBytes[i]);
        }
        */
    }

    /**
     * This encodes a string input properly for encryption.
     * @param input the string to input
     * @return the properly padded byte array
     */
    byte [] pad (String input)
    {
        byte [] temp = null;

        try
        {
            temp = input.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }

        if(temp.length %8 == 0)
        {
            return temp;
        }
        else
        {
            byte [] paddedInput = new byte[(temp.length %8) + temp.length];
            for(int i = 0; i < temp.length; i ++)
            {
                paddedInput[i] = temp[i];
            }
            return paddedInput;
        }
    }

    /**
     * This undoes the padding
     * @param paddedInput
     * @return
     */
    String unpad (byte[] paddedInput)
    {
        int i = 0;
        for (; i < paddedInput.length; i++)
        {
            if (paddedInput[i] == 0)
            {
                break;
            }
        }
        byte[] temp = new byte[i];
        System.arraycopy(paddedInput, 0, temp, 0, i);

        try
        {
            return new String(temp,"UTF-8");
        }
        catch (UnsupportedEncodingException e)
        {
            throw new RuntimeException(e);
        }
    }

    String encrypt(String input)
    {
        Cipher cipher = null;
        try
        {
            cipher = Cipher.getInstance("DES/ECB/NoPadding");
        } catch (NoSuchAlgorithmException|NoSuchPaddingException e)
        {
            e.printStackTrace();
        }

        try
        {
            cipher.init(Cipher.ENCRYPT_MODE, key);
        }
        catch (InvalidKeyException e)
        {
            e.printStackTrace();
        }

        byte [] utf8 = pad(input);
        try {

            byte[] enc = cipher.doFinal(utf8);

            return new String(enc, StandardCharsets.UTF_8);
        }
        catch (IllegalBlockSizeException | BadPaddingException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    String decrypt(String cipherText)
    {
        Cipher cipher = null;
        try
        {
            cipher = Cipher.getInstance("DES/ECB/NoPadding");
        }
        catch (NoSuchAlgorithmException |NoSuchPaddingException e)
        {
            throw new RuntimeException(e);
        }

        try
        {
            cipher.init(Cipher.DECRYPT_MODE, key);
        }
        catch (InvalidKeyException e)
        {
            throw new RuntimeException(e);
        }

        byte[] decryptedText = null;
        try
        {
            byte[] dec = cipherText.getBytes("UTF-8");

            byte[] utf8 = cipher.doFinal(dec);

            return unpad(dec);
        }
        catch (IllegalBlockSizeException |UnsupportedEncodingException |BadPaddingException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    SecretKey generateKey()
    {
        SecretKey key = null;
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
            key = KeyGenerator.getInstance("DES").generateKey();
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        return key;
    }

}
