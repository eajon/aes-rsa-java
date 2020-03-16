package cn.csfz.config;

import cn.csfz.util.AES;
import cn.csfz.util.ConvertUtils;
import cn.csfz.util.EncryUtil;
import cn.csfz.util.RSA;

public class ZfSecurity {


    public static String decodeBase64(String data, String sign, String privateKey,String serverPublicKey) throws Exception {
        // 验签
        boolean passSign = EncryUtil.checkDecryptAndSign(data, sign, serverPublicKey, privateKey);
        if (passSign) {
            String response = ConvertUtils.hexStringToString(AES.decryptFromBase64(data, RSA.decrypt(sign, privateKey)));
            return response;
        } else {
            throw new Exception("验签失败!");
        }

    }
}
