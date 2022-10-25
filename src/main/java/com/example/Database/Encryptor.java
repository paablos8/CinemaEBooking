package com.example.Database;

import javax.crypto.*;
import java.security.*;

public class Encryptor
{
    public static void main (String [] args)
    {
        try
        {
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            byte[] keyBytes = {0,0,0,1,1,0,1,0};
            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            keyGen.init(256); // for example
            SecretKey secretKey = keyGen.generateKey();
        }
        catch (NoSuchAlgorithmException e)
        {
            throw new RuntimeException(e);
        }
        catch (NoSuchPaddingException e)
        {
            throw new RuntimeException(e);
        }
    }
}
