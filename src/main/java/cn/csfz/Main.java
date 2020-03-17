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
    public static final String clientPrivateKey = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAKbNojYr8KlqKD/y" +
            "COd7QXu3e4TsrHd4sz3XgDYWEZZgYqIjVDcpcnlztwomgjMj9xSxdpyCc85GOGa0" +
            "lva1fNZpG6KXYS1xuFa9G7FRbaACoCL31TRv8t4TNkfQhQ7e2S7ZktqyUePWYLlz" +
            "u8hx5jXdriErRIx1jWK1q1NeEd3NAgMBAAECgYAws7Ob+4JeBLfRy9pbs/ovpCf1" +
            "bKEClQRIlyZBJHpoHKZPzt7k6D4bRfT4irvTMLoQmawXEGO9o3UOT8YQLHdRLitW" +
            "1CYKLy8k8ycyNpB/1L2vP+kHDzmM6Pr0IvkFgnbIFQmXeS5NBV+xOdlAYzuPFkCy" +
            "fUSOKdmt3F/Pbf9EhQJBANrF5Uaxmk7qGXfRV7tCT+f27eAWtYi2h/gJenLrmtke" +
            "Hg7SkgDiYHErJDns85va4cnhaAzAI1eSIHVaXh3JGXcCQQDDL9ns78LNDr/QuHN9" +
            "pmeDdlQfikeDKzW8dMcUIqGVX4WQJMptviZuf3cMvgm9+hDTVLvSePdTlA9YSCF4" +
            "VNPbAkEAvbe54XlpCKBIX7iiLRkPdGiV1qu614j7FqUZlAkvKrPMeywuQygNXHZ+" +
            "HuGWTIUfItQfSFdjDrEBBuPMFGZtdwJAV5N3xyyIjfMJM4AfKYhpN333HrOvhHX1" +
            "xVnsHOew8lGKnvMy9Gx11+xPISN/QYMa24dQQo5OAm0TOXwbsF73MwJAHzqaKZPs" +
            "EN08JunWDOKs3ZS+92maJIm1YGdYf5ipB8/Bm3wElnJsCiAeRqYKmPpAMlCZ5x+Z" +
            "AsuC1sjcp2r7xw==";

    public static final String clientPublicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCmzaI2K/Cpaig/8gjne0F7t3uE" +
            "7Kx3eLM914A2FhGWYGKiI1Q3KXJ5c7cKJoIzI/cUsXacgnPORjhmtJb2tXzWaRui" +
            "l2EtcbhWvRuxUW2gAqAi99U0b/LeEzZH0IUO3tku2ZLaslHj1mC5c7vIceY13a4h" +
            "K0SMdY1itatTXhHdzQIDAQAB";

    public static final String serverPublicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAhNQ7RJubPZXqnOyShniA7f2r4IRJFYV1MErWKdhQcnTUznETW90iSpf+gpNQR75TrYq9wZlDgagB2Xk31x8FOLhefYkVz4oN5+EHQ0mdq6J4yHxOLwBPEXuIuxuZaJAUrroeeZ7U1SPEqKnuNloaIWCbQTzg0jjohAwyhXX/IF2sQZBvzHl1owc+jT8ectL7LH1WTA0JHMTym73f6478IxYeeh7gKFIvzPyvnwOs/nU8eb9OX36r+82NG0eIwVXqqe+ebeerf4qU/hxw/7PXB21HyyaixQh5E+fYB/3s5mNVnZYVn6Ccsef1367P8Hul7PvRPCKOKqBNtuz2iyyeBQIDAQAB";

    public static void main(String[] args) throws Exception {
        RSA.generateKeyPair();
    }
}
