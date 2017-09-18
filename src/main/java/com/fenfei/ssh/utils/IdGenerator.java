package com.fenfei.ssh.utils;

/**
 * Created by shefenfei on 2017/9/5.
 */
public class IdGenerator {

    /**
     * 流水号（生成规则：取系统配置文件的instance号2位+12位currentTimeMillis/10(10毫秒)+2位流水号）
     * @return
     */
    private static int i = 0;
    private static String instanceId = "00";

    public static String getInstanceId() {
        return instanceId;
    }

    public static void setInstanceId(String instanceId) {
        if (instanceId == null || instanceId.length() != 2) {
            throw new IllegalArgumentException(
                    "Set instanceId error: the length should be 2 '"
                            + (instanceId == null ? "" : instanceId)
                            + "' is not correct.");
        }
        IdGenerator.instanceId = instanceId;
    }

    /**
     * @DESCRIPION :每10毫秒可生成100个序列号；优于每毫秒10个序列号
     * @Create on: 2013-4-16 下午5:27:05
     * @Author : shefenfei
     * @return : String
     */
    public synchronized static String genOptId16() {
        i = i % 100;
        String index = (i < 10) ? ("0" + i) : "" + i;
        String orderNum = instanceId + System.currentTimeMillis() / 10 + index;
        i++;
        return orderNum;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.err.println(genOptId16());
                }
            });
            t.start();
        }
    }

}
