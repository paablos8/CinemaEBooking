package com.example.Database;

/*
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.security.*;
*/

import java.io.UnsupportedEncodingException;


/**
 * This is for encrypting the user's password and card number.
 * It is not using state-of-the-art encryption, but it's better
 * than nothing.
 */

/**
 * It might only be good for comedic purposes. I apologise,
 * I have no experience in cryptography.
 */
class Encryptor
{
    // This method is irrelevant as long as we aren't using javax.crypto
    /*
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

        key = new SecretKeySpec(decodedKey, 0, decodedKey.length, "DES");


        String enc = encrypt("Toby");
        System.out.println("\n"+enc);
        System.out.println(decrypt(enc));
        

        SecretKey key = generateKey();
        byte[] keyBytes = key.getEncoded();

        for(int i = 0; i < keyBytes.length; i++)
        {
            System.out.println(keyBytes[i]);
        }

    }
    */
/*
    /**
     * THIS METHOD DOES NOT WORK. I DON'T KNOW WHY.
     * I THINK IT'S ALL THAT STANDS BETWEEN US AND
     * HAVING VALID ENCRYPTION.
     *
     * This encodes a string input properly for encryption.
     * @param input the string to input
     * @return the properly padded byte array

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

        for(int i = 0; i < temp.length; i ++)
        {
            System.out.print(temp[i]);
        }

        byte [] paddedInput;

        if(temp.length %8 == 0)
        {
            return temp;
        }
        else
        {
            paddedInput = new byte[(8-(temp.length %8)) + temp.length];
            System.out.println(paddedInput.length);
            for(int i = 0; i < temp.length; i ++)
            {
                paddedInput[i] = temp[i];
            }
        }

        for(int i = 0; i < paddedInput.length; i ++)
        {
            System.out.print(paddedInput[i]);
        }

        return paddedInput;
    }

    /**
     * This undoes the padding
     * @param paddedInput
     * @return

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

    */

    String encrypt(String input)
    {
        /*
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
        */
        byte [] temp;
        try {
            temp = input.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }

        for(int i = 0; i < temp.length; i++)
        {
            if(temp[i] > 252)
            {
                temp[i] = (byte)(temp[i] - 255 + 3);
            }
            else
            {
                temp[i] = (byte)(temp[i] + 3);
            }

        }
        try {
            return new String (temp,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    String decrypt(String cipherText)
    {
        /*
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
         */

        byte [] temp;
        try {
            temp = cipherText.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }

        for(int i = 0; i < temp.length; i++)
        {
            if(temp[i] < 2)
            {
                temp[i] = (byte)(temp[i] + 255 -3);
            }
            else
            {
                temp[i] = (byte)(temp[i] - 3);
            }

        }
        try {
            return new String (temp,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    long decryptLong(String cipherText)
    {
        String decryptStr = decrypt(cipherText);
        long ret = 0L;
        for(int i = 15; i >= 0; i--)
        {
            ret *= 10;
            ret += letterToNum(decryptStr.charAt(i));
        }
        return ret;
    }

    String encryptLong (long num)
    {
        String ret = "";
        for(int i = 0; i < 16; i++)
        {
            long temp = num %10;
            int numLastDigit = (int) temp;

            ret = ret + numToLetter(numLastDigit);
            num /= 10;
        }
        return encrypt(ret);
    }

    private char numToLetter (int num)
    {
        switch(num)
        {
            case(0): return 'a';
            case(1): return 'b';
            case(2): return 'c';
            case(3): return 'd';
            case(4): return 'e';
            case(5): return 'f';
            case(6): return 'g';
            case(7): return 'h';
            case(8): return 'i';
            default: return 'j';
        }
    }

    private int letterToNum (char letter)
    {
        switch(letter)
        {
            case('a'):return 0;
            case('b'):return 1;
            case('c'):return 2;
            case('d'):return 3;
            case('e'):return 4;
            case('f'):return 5;
            case('g'):return 6;
            case('h'):return 7;
            case('i'):return 8;
            default: return 9;
        }
    }
/*
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
 */
}
