package cn.csfz.config;

import cn.csfz.model.Receipt;
import cn.csfz.util.*;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
import okhttp3.Headers;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import static cn.csfz.config.ZfConfig.*;

public class ZfApi {

    private ZfApi() {
        throw new AssertionError();
    }

    public static String addUnConfirmNotice(Receipt receipt) {
        if (!ZfConfig.checkInit()) {
            return null;
        }
        receipt.setIsConfirm(0);
        receipt.setBankCode(BANK_CODE);
        SimplePropertyPreFilter filter = new SimplePropertyPreFilter(Receipt.class);
        filter.getExcludes().add("confirmDate");
        filter.getExcludes().add("foreignIncomeNumber");
        TreeMap<String, String> params = JSONObject.parseObject(JSON.toJSONString(receipt, filter), new TypeReference<TreeMap<String, String>>() {
        });
        String sign = EncryUtil.handleRSA(params, CLIENT_PRIVATE_KEY);
        params.put("sign", sign);
        String info = JSON.toJSONString(params);
        //随机生成AES密钥
        String aesKey = SecureRandomUtil.getRandom(16);
        //AES加密数据
        String data = AES.encryptToBase64(ConvertUtils.stringToHexString(info), aesKey);
        Map<String, String> map = new HashMap<String, String>();
        map.put("data", data);
        String key = "";
        try {
            key = RSA.encrypt(aesKey, SERVER_PUBLIC_KEY);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Headers.Builder builder = new Headers.Builder();
        builder.set("encryptKey", key);
        builder.set("publicKey", CLIENT_PUBLIC_KEY);
        String host = SERVER_HOST;
        if (!SERVER_HOST.endsWith("/")) {
            host = SERVER_HOST + "/";
        }
        return  OkHttpUtils.post(host + "receipt/add", map, builder.build());
    }

    public static String addConfirmNotice(Receipt receipt) {
        if (!ZfConfig.checkInit()) {
            return null;
        }
        receipt.setIsConfirm(1);
        receipt.setBankCode(BANK_CODE);
        SimplePropertyPreFilter filter = new SimplePropertyPreFilter(Receipt.class, "bankBusinessId", "bankCode", "confirmDate", "foreignIncomeNumber", "isConfirm");
        TreeMap<String, String> params = JSONObject.parseObject(JSON.toJSONString(receipt, filter), new TypeReference<TreeMap<String, String>>() {
        });
        String sign = EncryUtil.handleRSA(params, CLIENT_PRIVATE_KEY);
        params.put("sign", sign);
        String info = JSON.toJSONString(params);
        //随机生成AES密钥
        String aesKey = SecureRandomUtil.getRandom(16);
        //AES加密数据
        String data = AES.encryptToBase64(ConvertUtils.stringToHexString(info), aesKey);
        Map<String, String> map = new HashMap<String, String>();
        map.put("data", data);
        String key = "";
        try {
            key = RSA.encrypt(aesKey, SERVER_PUBLIC_KEY);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Headers.Builder builder = new Headers.Builder();
        builder.set("encryptKey", key);
        builder.set("publicKey", CLIENT_PUBLIC_KEY);
        String host = SERVER_HOST;
        if (!SERVER_HOST.endsWith("/")) {
            host = SERVER_HOST + "/";
        }
        return OkHttpUtils.post(host + "receipt/add", map, builder.build());
    }

    public static String queryById(Receipt receipt) {
        if (!ZfConfig.checkInit()) {
            return null;
        }
        receipt.setBankCode(BANK_CODE);
        SimplePropertyPreFilter filter = new SimplePropertyPreFilter(Receipt.class, "bankBusinessId", "bankCode");
        TreeMap<String, String> params = JSONObject.parseObject(JSON.toJSONString(receipt, filter), new TypeReference<TreeMap<String, String>>() {
        });
        String sign = EncryUtil.handleRSA(params, CLIENT_PRIVATE_KEY);
        params.put("sign", sign);
        String info = JSON.toJSONString(params);
        //随机生成AES密钥
        String aesKey = SecureRandomUtil.getRandom(16);
        //AES加密数据
        String data = AES.encryptToBase64(ConvertUtils.stringToHexString(info), aesKey);
        Map<String, String> map = new HashMap<String, String>();
        map.put("data", data);
        String key = "";
        try {
            key = RSA.encrypt(aesKey, SERVER_PUBLIC_KEY);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Headers.Builder builder = new Headers.Builder();
        builder.set("encryptKey", key);
        builder.set("publicKey", CLIENT_PUBLIC_KEY);
        String host = SERVER_HOST;
        if (!SERVER_HOST.endsWith("/")) {
            host = SERVER_HOST + "/";
        }
        return  OkHttpUtils.post(host + "receipt/queryById", map, builder.build());
    }

}
