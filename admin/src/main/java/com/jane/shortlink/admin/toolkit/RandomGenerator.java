package com.jane.shortlink.admin.toolkit;

import java.security.SecureRandom;

/**
 * _@Description: 分组 ID 随机生成器
 */
public final class RandomGenerator {

    private static final String CHARACTERS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final SecureRandom RANDOM = new SecureRandom();

    /**
     * 生成随机分组 ID
     * @return 分组 ID
     */
    public static String generateRandom() {
        return generateRandom(6);
    }

    /**
     * 生成随机分组 ID
     * @param length 随机生成位数
     * @return 分组 ID
     */
    public static String generateRandom(int length) {
        StringBuffer stringBuffer = new StringBuffer(length);
        for (int i = 0; i < length; i++) {
            int randomIndex = RANDOM.nextInt(CHARACTERS.length());
            stringBuffer.append(CHARACTERS.charAt(randomIndex));
        }
        return stringBuffer.toString();
    }
}
