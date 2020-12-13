package cn.csfz.config;

import org.apache.commons.lang.StringUtils;

public class ZfConfig {

    public static String SERVER_PUBLIC_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCFisyJeK9HyhdoJbbg41lTi+64Ud18Q2w71xVU9Jw+oYdhoPnTm2/29E/TtP/K4MAg4y8OZjmgR1taGer9h/xhM7Pc6JsxqD/rP/X9I5xTZBrgdc3DeQqlHRV8O32HNu6F9f0q1oe3vK/StcqL73YtyeugA7s93aHVchfYqlzZgQIDAQAB";
    public static String CLIENT_PRIVATE_KEY = "";
    public static String CLIENT_PUBLIC_KEY = "";
    public static String SERVER_HOST = "";
    public static String BANK_CODE = "";
    public static String TENANT_ID = "";

    public static void init(String serverPublicKey, String clientPrivateKey, String clientPublicKey, String serverHost, String bankCode, String tenantId) {
        SERVER_PUBLIC_KEY = serverPublicKey;
        CLIENT_PRIVATE_KEY = clientPrivateKey;
        CLIENT_PUBLIC_KEY = clientPublicKey;
        SERVER_HOST = serverHost;
        BANK_CODE = bankCode;
        TENANT_ID = StringUtils.isEmpty(tenantId) ? "cs" : tenantId.toLowerCase();
    }

    public static boolean checkInit() {
        if (StringUtils.isEmpty(SERVER_PUBLIC_KEY)) {
            return false;
        }
        if (StringUtils.isEmpty(CLIENT_PRIVATE_KEY)) {
            return false;
        }
        if (StringUtils.isEmpty(CLIENT_PUBLIC_KEY)) {
            return false;
        }
        if (StringUtils.isEmpty(SERVER_HOST)) {
            return false;
        }
        if (StringUtils.isEmpty(BANK_CODE)) {
            return false;
        }
        if (StringUtils.isEmpty(TENANT_ID)) {
            return false;
        }
        return true;
    }
}
