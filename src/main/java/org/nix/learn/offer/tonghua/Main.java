package org.nix.learn.offer.tonghua;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2018/11/8
 */
public class Main {

    public static void main(String[] args) {
        System.out.println((int) 'a' + " " + (int) 'z' + " " + (int) 'A' + " " + (int) 'Z');
        System.out.println((char)changIndex( 'A'));
        System.out.println((char)changMax('a'));
        System.out.println(strChange("sdSdsfdAdsdsdfsfdsdASDSDFDSFs"));
    }

    /**
     * 对下面字符串进行转换，将”sdSdsfdAdsdsdfsfdsdASDSDFDSFs”字符串大写变小写，
     * 并且将字符串变为镜像字符串，例如：’A’变成’Z’，’b’变成’y’
     *
     * @param str
     * @return
     */
    public static String strChange(String str) {
        if (str == null){
            return null;
        }
        char[] chars = str.toCharArray();
        StringBuilder builder = new StringBuilder();
        for (char c : chars) {
            c = (char) changIndex(c);
            c = (char) changMax(c);
            builder.append(c);
        }
        return builder.toString();
    }

    public static int changIndex(char c) {
        int temp = c - 'a';
        if (0 < temp && temp < 26) {
            return 26 - temp + 96;
        }
        temp = c - 'A';
        return 26 - temp + 64;
    }

    public static int changMax(char c){
        int temp = c - 'a';
        if (0 <= temp && temp < 26) {
            return 65 + temp;
        }
        temp = c - 'A';
        return 97 + temp;
    }
}
