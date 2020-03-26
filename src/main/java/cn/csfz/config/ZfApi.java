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

    //预入账
    public static String preConfirmNotice(Receipt receipt) {
        if (!ZfConfig.checkInit()) {
            throw new IllegalStateException("初始化参数错误!");
        }
        receipt.setIsConfirm(0);
        receipt.setBankCode(BANK_CODE);
        SimplePropertyPreFilter filter = new SimplePropertyPreFilter(Receipt.class);
        filter.getExcludes().add("confirmDate");
        filter.getExcludes().add("confirmRemark");
        filter.getExcludes().add("foreignIncomeNumber");
        filter.getExcludes().add("rejectDate");
        filter.getExcludes().add("rejectRemark");
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

    //实入账
    public static String confirmNotice(Receipt receipt) {
        if (!ZfConfig.checkInit()) {
            throw new IllegalStateException("初始化参数错误!");
        }
        receipt.setIsConfirm(1);
        receipt.setBankCode(BANK_CODE);
        SimplePropertyPreFilter filter = new SimplePropertyPreFilter(Receipt.class, "bankBusinessId", "bankCode", "confirmDate", "foreignIncomeNumber", "isConfirm", "confirmRemark");
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

    //拒绝入账
    public static String rejectConfirmNotice(Receipt receipt) {
        if (!ZfConfig.checkInit()) {
            throw new IllegalStateException("初始化参数错误!");
        }
        receipt.setIsConfirm(2);
        receipt.setBankCode(BANK_CODE);
        SimplePropertyPreFilter filter = new SimplePropertyPreFilter(Receipt.class, "bankBusinessId", "bankCode", "rejectDate", "isConfirm", "rejectRemark");
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

    public static String queryById(String id) {
        if (!ZfConfig.checkInit()) {
            throw new IllegalStateException("初始化参数错误!");
        }
        Receipt receipt = new Receipt();
        receipt.setBankBusinessId(id);
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
        return OkHttpUtils.post(host + "receipt/queryById", map, builder.build());
    }

}
