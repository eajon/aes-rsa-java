package cn.csfz.config;

import org.apache.commons.lang.StringUtils;

public class ZfConfig {

    public static final String serverPublicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCyGffCqoC1vCDLeBvjfuHdw4jo" +
            "hGvubOpQjEhhPzW1PbLSRKsNBLgj+eDGOiZE9BwmEwqy16sMOq0kMlhewTQlRrLJ" +
            "Nlw3L0iogs9WTIGm3el1SuZLyMnMksnV0NCsuq538cPMNppZRwARb7NXmpmh0KM7" +
            "9fJ/1xqnpo1tgRcv4wIDAQAB";

    private static String CLIENT_PUBLIC_KEY = "";

    private static String CLIENT_PRIVATE_KEY = "";

    private static String SERVER_URL = "http://127.0.0.1:8888";

    private ZfConfig() {
        throw new AssertionError();
    }


    public static void init(String clientPublicKey, String serverUrl) {
        CLIENT_PUBLIC_KEY = clientPublicKey;
        SERVER_URL = serverUrl;
    }


    public static String getClientPublicKey() {
        if (StringUtils.isEmpty(CLIENT_PUBLIC_KEY)) {
            throw new NullPointerException("please use  init method first !");
        }
        return CLIENT_PUBLIC_KEY;
    }

    public static String getServerUrl() {
        if (StringUtils.isEmpty(SERVER_URL)) {
            throw new NullPointerException("please use  init method  first !");
        }
        return SERVER_URL;
    }


    public static String getClientPrivateKey() {
        if (StringUtils.isEmpty(CLIENT_PRIVATE_KEY)) {
            throw new NullPointerException("please use  init method  first !");
        }
        return CLIENT_PRIVATE_KEY;
    }
}
