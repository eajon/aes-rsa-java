package cn.csfz;

import java.util.TreeMap;
import java.util.UUID;

import cn.csfz.config.ZfApi;
import cn.csfz.util.*;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * Description: AES+RSA签名，加密 验签，解密
 *
 * @author: wubaoguo
 * @email: wustrive2008@gmail.com
 * @date: 2015/8/13 15:12
 */
public class Main {
    public static final String serverPublicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAhNQ7RJubPZXqnOyShniA7f2r4IRJFYV1MErWKdhQcnTUznETW90iSpf+gpNQR75TrYq9wZlDgagB2Xk31x8FOLhefYkVz4oN5+EHQ0mdq6J4yHxOLwBPEXuIuxuZaJAUrroeeZ7U1SPEqKnuNloaIWCbQTzg0jjohAwyhXX/IF2sQZBvzHl1owc+jT8ectL7LH1WTA0JHMTym73f6478IxYeeh7gKFIvzPyvnwOs/nU8eb9OX36r+82NG0eIwVXqqe+ebeerf4qU/hxw/7PXB21HyyaixQh5E+fYB/3s5mNVnZYVn6Ccsef1367P8Hul7PvRPCKOKqBNtuz2iyyeBQIDAQAB";

    public static void main(String[] args) throws Exception {
        RSA.genKey();
    }
}
