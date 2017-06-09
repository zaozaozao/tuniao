package wantao.wt.myapplication.encryption;

import android.util.Base64;
import android.util.Log;

/**
 * 本工具使用des，aes加密
 * Created by wantao on 2017/5/26.
 */

public class EncrypUtil {

    public static final String AES_KEY="tuniao17tuniao17";//AES 密钥必须是16个字节的
    public static final String DES_KEY="tuniao17";//DES 密钥必须是8个字节的

    public static String encryp(String content)
    {
        //使用des加密
        byte[] contentBytes = content.getBytes();
        byte[] desKey = DES_KEY.getBytes();

        byte[] desBytes = CryptUtil.desEncrypt(contentBytes, desKey);
        String desString = Base64.encodeToString(desBytes, Base64.NO_WRAP);


        byte[] aesKey = AES_KEY.getBytes();
        //aes加密
        byte[] aesBytes = CryptUtil.aesEncrypt(desString.getBytes(), aesKey);

        String result = Base64.encodeToString(aesBytes, Base64.NO_WRAP);
        return result;
    }

    public static String decryp(String content)
    {
        //aes解密
        byte[] aesKey = AES_KEY.getBytes();
        byte[] base64Bytes = Base64.decode(content.getBytes(), Base64.NO_WRAP);
        byte[] aesString = CryptUtil.aesDecrypt(base64Bytes, aesKey);

        //des解密
        byte[] base64Bytes1 = Base64.decode(aesString, Base64.NO_WRAP);
        byte[] desKey = DES_KEY.getBytes();
        byte[] desByte = CryptUtil.desDecrypt(base64Bytes1, desKey);
        String result = new String(desByte);

        return result;
    }


}
