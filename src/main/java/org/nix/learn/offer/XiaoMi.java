package org.nix.learn.offer;

/**
 * 背景：
 * 在客户端-服务端模型中，服务端通常需要根据客户端的版本名，提供不同的服务。
 * <p>
 * 前置条件：
 * 版本名用字符串表示，格式如”3.1”。从左向右，第1位表示stable版本号，第2位表示beta版本号。
 * <p>
 * 需求：
 * 提供版本管理工具类，提供如下方法：
 * 1 输入两个版本名，判断版本大小：stable版本号不同，stable版本号大者为大版本；stable版本号相同时，
 * beta版本号大者为大版本；否则两者相同。如 2.2 > 2.1，3.1 > 2.3
 * 2 输入两个版本名，判断是否兼容：两个版本的stable版本号相同时表示兼容，否则表示不兼容。如 2.1 和 2.2 兼容， 3.1 和 2.1 不兼容。
 * <p>
 * 考核点：
 * 1 逻辑清晰正确
 * 2 编码规范、无编译错误
 * 3 异常情况处理完善
 * 4 时空复杂度最优
 * <p>
 * 实现语言：Java 或 C++，任选其一
 * 时间限制：30分钟
 * <p>
 * 备注：
 * 任何对题目描述不确定且影响实现的问题，可以自己设定，在注释中声明即可。
 *
 * @author zhangpei
 * @version 1.0
 * @date 2018/10/24
 */
public class XiaoMi {

    public static void main(String[] args) {
        String version1 = "2.1";
        String version2 = "2.1";
        try {
            System.out.println("谁大：" + isMore(version1, version2));
            System.out.println("是否兼容：" + isCompatible(version1, version2));
        } catch (XiaoMiException e) {
            System.out.println("错误：" + e.getMessage());
        }
    }

    /**
     * 1 输入两个版本名，判断版本大小：stable版本号不同，stable版本号大者为大版本；stable版本号相同时，
     * beta版本号大者为大版本；否则两者相同。如 2.2 > 2.1，3.1 > 2.3
     *
     * @param sample 需要判断的版本
     * @param target 目标版本
     * @return 0:两个相同 1:sample大 2:target大
     */
    public static int isMore(String sample, String target) throws XiaoMiException {
        if (!isQualified(sample) || !isQualified(target)) {
            throw new XiaoMiException("输入的参数格式不对,版本号格式应为：数字.数字");
        }
        if (sample.equals(target)) {
            return 0;
        } else {
            return Double.parseDouble(sample) > Double.parseDouble(target) ? 1 : 2;
        }
    }

    /**
     * 输入两个版本名，判断是否兼容：两个版本的stable版本号相同时表示兼容，
     * 否则表示不兼容。如 2.1 和 2.2 兼容， 3.1 和 2.1 不兼容。
     * 由题目给出的条件，版本号都应该是 数字.数字 因此需要判断版本是否是如此组合的
     *
     * @param sample 需要判断的版本
     * @param target 目标版本
     * @return 如果 sample 兼容 target 则返回true 否则返回false
     */
    public static boolean isCompatible(String sample, String target) throws XiaoMiException {
        if (!isQualified(sample) || !isQualified(target)) {
            throw new XiaoMiException("输入的参数格式不对,版本号格式应为：数字.数字");
        }
        return sample.split("\\.")[0].equals(target.split("\\.")[0]);
    }

    /**
     * 判断这个字符串是否符合要求
     *
     * @param version 需要判断的字符串
     * @return 如果是版本号的格式则返回true
     */
    public static boolean isQualified(String version) throws XiaoMiException {
        if (version == null) {
            throw new XiaoMiException("输入的版本号为空");
        }
        return version.matches("[0-9]+\\.[0-9]+");
    }

    /**
     * 异常类
     */
    static class XiaoMiException extends RuntimeException {
        public XiaoMiException(String message) {
            super(message);
        }
    }

}
