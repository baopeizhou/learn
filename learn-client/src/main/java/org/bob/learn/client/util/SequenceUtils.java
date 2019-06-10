package org.bob.learn.client.util;

import java.util.UUID;

/**
 * 序列号工具类
 */
public final class SequenceUtils {

    private static UUID uuid = UUID.randomUUID();

    /**
     * 生产8位序列id
     * @return
     */
    public static String seq() {
        return uuid.toString().substring(0, 12);
    }
}
