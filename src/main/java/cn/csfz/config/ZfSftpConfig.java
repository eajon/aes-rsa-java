package cn.csfz.config;

import org.apache.commons.lang.StringUtils;

public class ZfSftpConfig {

    public static String USER_NAME = "";
    public static String PASS_WORD = "";

    public static void init(String userName, String password) {
        USER_NAME = userName;
        PASS_WORD = password;
    }
    public static boolean checkInit() {
        if (StringUtils.isEmpty(USER_NAME)) {
            return false;
        }
        if (StringUtils.isEmpty(PASS_WORD)) {
            return false;
        }
        return true;
    }

}
