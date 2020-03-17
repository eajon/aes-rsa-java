package cn.csfz.config;

import cn.csfz.Main;
import cn.csfz.model.Receipt;
import cn.csfz.util.*;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
import okhttp3.Headers;

import java.util.HashMap;
import java.util.Map;

import static cn.csfz.config.ZfConfig.SERVER_PUBLIC_KEY;

public class ZfApi {

    private ZfApi() {
        throw new AssertionError();
    }

    public static Result addUnConfirmNotice(Receipt receipt, String baseUrl, String privateKey, String publicKey) throws Exception {
        receipt.setIsConfirm(0);
        SimplePropertyPreFilter filter = new SimplePropertyPreFilter(Receipt.class);
        filter.getExcludes().add("confirmDate");
        filter.getExcludes().add("foreignIncomeNumber");
        Map<String, String> params = JSONObject.parseObject(JSON.toJSONString(receipt, filter), new TypeReference<Map<String, String>>() {
        });
        String sign = EncryUtil.handleRSA(params, privateKey);
        params.put("sign", sign);
        String info = JSON.toJSONString(params);
        //随机生成AES密钥
        String aesKey = SecureRandomUtil.getRandom(16);
        //AES加密数据
        String data = AES.encryptToBase64(ConvertUtils.stringToHexString(info), aesKey);
        Map<String, String> map = new HashMap<String, String>();
        map.put("data", data);
        String key = RSA.encrypt(aesKey, SERVER_PUBLIC_KEY);
        Headers.Builder builder = new Headers.Builder();
        builder.set("encryptKey", key);
        builder.set("publicKey", publicKey);

        String response = OkHttpUtils.post(baseUrl + "/exchange/receipt/add", map, builder.build());
        return JSON.parseObject(response, Result.class);
    }

    public static Result addConfirmNotice(Receipt receipt, String baseUrl, String privateKey, String publicKey) throws Exception {
        receipt.setIsConfirm(1);
        SimplePropertyPreFilter filter = new SimplePropertyPreFilter(Receipt.class, "bankBusinessId", "bankCode", "confirmDate", "foreignIncomeNumber", "isConfirm");
        Map<String, String> params = JSONObject.parseObject(JSON.toJSONString(receipt, filter), new TypeReference<Map<String, String>>() {
        });
        String sign = EncryUtil.handleRSA(params, privateKey);
        params.put("sign", sign);
        String info = JSON.toJSONString(params);
        //随机生成AES密钥
        String aesKey = SecureRandomUtil.getRandom(16);
        //AES加密数据
        String data = AES.encryptToBase64(ConvertUtils.stringToHexString(info), aesKey);
        Map<String, String> map = new HashMap<String, String>();
        map.put("data", data);
        String key = RSA.encrypt(aesKey, SERVER_PUBLIC_KEY);
        Headers.Builder builder = new Headers.Builder();
        builder.set("encryptKey", key);
        builder.set("publicKey", publicKey);

        String response = OkHttpUtils.post(baseUrl + "/exchange/receipt/add", map, builder.build());
        return JSON.parseObject(response, Result.class);
    }

    public static Result queryById(Receipt receipt, String baseUrl, String privateKey, String publicKey) throws Exception {
        Map<String, String> params = JSONObject.parseObject(JSON.toJSONString(receipt), new TypeReference<Map<String, String>>() {
        });
        String sign = EncryUtil.handleRSA(params, privateKey);
        params.put("sign", sign);
        String info = JSON.toJSONString(params);
        //随机生成AES密钥
        String aesKey = SecureRandomUtil.getRandom(16);
        //AES加密数据
        String data = AES.encryptToBase64(ConvertUtils.stringToHexString(info), aesKey);
        Map<String, String> map = new HashMap<String, String>();
        map.put("data", data);
        String key = RSA.encrypt(aesKey, SERVER_PUBLIC_KEY);
        Headers.Builder builder = new Headers.Builder();
        builder.set("encryptKey", key);
        builder.set("publicKey", publicKey);

        String response = OkHttpUtils.post(baseUrl + "/exchange/receipt/queryById", map, builder.build());
        return JSON.parseObject(response, Result.class);
    }

}
