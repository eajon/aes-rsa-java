package cn.csfz.config;
import cn.csfz.util.*;
import com.alibaba.fastjson.JSON;
import okhttp3.Headers;

import java.util.HashMap;
import java.util.Map;

public class ZfApi {

    private ZfApi() {
        throw new AssertionError();
    }

    public static Result sendReceiptNotice(Map<String, String> params, String baseUrl, String privateKey, String publicKey, String serverPublicKey) throws Exception {
        String sign = EncryUtil.handleRSA(params, privateKey);
        params.put("sign",sign);
        String info = JSON.toJSONString(params);
        //随机生成AES密钥
        String aesKey = SecureRandomUtil.getRandom(16);
        //AES加密数据
        String data = AES.encryptToBase64(ConvertUtils.stringToHexString(info), aesKey);
        Map<String,String> map = new HashMap<String, String>();
        map.put("data", data);
        String key = RSA.encrypt(aesKey,serverPublicKey);
        Headers.Builder builder = new Headers.Builder();
        builder.set("encryptKey", key);
        builder.set("publicKey",publicKey);

        String response = OkHttpUtils.post(baseUrl+"/exchange/receipt/add", map, builder.build());
        return JSON.parseObject(response, Result.class);
    }

}
