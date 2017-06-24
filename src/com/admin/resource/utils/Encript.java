package com.admin.resource.utils;
import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;

public class Encript {
    public static String MD5 = "MD5";
    
    public static String toHexadecimal(byte[] digest) {
        String hash = "";
        for (byte aux : digest) {
            int b = aux & 0xff;
            if (Integer.toHexString(b).length() == 1) hash += "0"; 
            hash += Integer.toHexString(b);            
        }
        return hash;
    }

    public static String getStringMessageDigest(String message, String algorithm) {
        byte[] digest = null;
        byte[] buffer = message.getBytes();
        
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
            messageDigest.reset();
            messageDigest.update(buffer);
            digest = messageDigest.digest();
        } catch(Exception ex) {}
        
        return toHexadecimal(digest);
    }
    
    public static String Encriptar(String texto) { 
        String secretKey = "qualityinfosolutions"; //llave para encriptar datos
        String base64EncryptedString = null; 

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digestOfPassword = md.digest(secretKey.getBytes("utf-8"));
            byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);

            SecretKey key = new SecretKeySpec(keyBytes, "DESede");
            Cipher cipher = Cipher.getInstance("DESede");
            cipher.init(Cipher.ENCRYPT_MODE, key);

            byte[] plainTextBytes = texto.getBytes("utf-8");
            byte[] buf = cipher.doFinal(plainTextBytes);
            byte[] base64Bytes = Base64.encodeBase64(buf);
            base64EncryptedString = new String(base64Bytes); 
        } catch (Exception ex) {}
        
        return base64EncryptedString;
    }
 
    public static String Desencriptar(String textoEncriptado) { 
        String secretKey = "qualityinfosolutions"; //llave para encriptar datos
        String base64EncryptedString = null; 

        try {
            byte[] message = Base64.decodeBase64(textoEncriptado.getBytes("utf-8"));
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digestOfPassword = md.digest(secretKey.getBytes("utf-8"));
            byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
            SecretKey key = new SecretKeySpec(keyBytes, "DESede");

            Cipher decipher = Cipher.getInstance("DESede");
            decipher.init(Cipher.DECRYPT_MODE, key);

            byte[] plainText = decipher.doFinal(message); 
            base64EncryptedString = new String(plainText, "UTF-8"); 
        } catch (Exception e) {}

        return base64EncryptedString;
    }    
}
