package top.xiao.utils.common.utils;

import org.apache.log4j.Logger;
import org.apache.shiro.crypto.hash.SimpleHash;

/**
 * @author 肖
 * @version 1.0
 * @Package top.xiao.utils.common.utils
 * @data 2020/2/22 14:42
 */


public class MD5Util {

    static Logger logger = Logger.getLogger(MD5Util.class);

    /**
     * @param manner    加密方式
     * @param password  真实密码
     * @param salt      加盐
     * @param frequency 次数
     * @return 返回MD5加密后的值
     */
    public static String[] getMD5(String manner, String password, int frequency) {
        //生成随机盐
        String randomSalt = getRandomSalt();
        SimpleHash md5 = new SimpleHash(manner, password, randomSalt, frequency);
        logger.info("本次加密  --->  " + md5.toString());
        String[] strs = new String[2];
        strs[0] = md5.toString();
        strs[1] = randomSalt;
        return strs;
    }

    public static String getMD5(String manner, String password, String salt) {
        //生成随机盐
        String randomSalt = getRandomSalt();
        SimpleHash md5 = new SimpleHash(manner, password, salt, 12);
        logger.info("本次加密  --->  " + md5.toString());
        return md5.toString();
    }

    /**
     * 生成随机盐
     *
     * @return 返回盐
     */

    public static String getRandomSalt() {
        String model = "abcdefghijklmnopqrstuvwxyz1234567890";
        StringBuffer salt = new StringBuffer();
        char[] m = model.toCharArray();
        for (int i = 0; i < 6; i++) {
            char c = m[(int) (Math.random() * 36)];
            salt = salt.append(c);
        }
        return salt.toString();
    }

    public static void main(String[] args) {
        String[] admins = getMD5(Const.MD5_UTIL, "admin", 12);
        System.out.println(admins[0]);
        String admin = getMD5(Const.MD5_UTIL, "admin", admins[1]);
        System.out.println(admin);
    }


}



