package org.nix.learn.applcation;


/**
 *  kmp算法求解过程
 *  1.求出部分匹配值（next）
 *  2.给出三个指针：
 *      1.记录字串的匹配指针（用来指定匹配到了哪儿了，当未完全匹配时用于计算位移值）
 *      2.记录母串的开始匹配位子（用于如果未匹配而计算下一次指针应该在哪儿）
 *      3.记录母串指针的当前值（跟随着匹配状态移动）
 *  3.返回匹配的结果
 * @author zhangpei
 * @version 1.0
 * @date 2018/9/19
 */
public class KMP {

    public static void main(String[] args) {
        String test = "fasjkghagfjkashfkajshfawjh";
        String str = "fkajsh";
//        System.out.println(getNext(preStr(str), suffixStr(str)));
//        for (String s : suffixStr(str)) {
//            System.out.print(s + " ");
//        }
//        System.out.println();
//        for (int s : getNexts(str)) {
//            System.out.print(s + " ");
//        }
//        System.out.println();
        System.out.println(kmp(test,str));
    }

    /**
     * 调用kmp算法获取到 model字符串在target字符串中的位子
     * @param target 模板字符串
     * @param model 需要查找的字符串
     * @return model的首字母在target的位子
     */
    public static int kmp(String target,String model){

        int lenTar = target.length();

        int lenModel = model.length();

        // 得到next数组
        int[] next = getNexts(model);

        // 指向目标字符串
        int tarPoin = 0;

        // targetPoin的开始值
        int tempTarPoin = tarPoin;

        // 指向已经匹配的字符
        int modelPoin = 0;

        for (int i = 0; i < lenTar; i++) {

            if (tarPoin >= lenTar){
                return -2;
            }

            // 匹配完整，返回首个字符匹配的位子
            if (modelPoin == lenModel){
               return tempTarPoin;
            }

            // 当不能匹配时
            if (target.charAt(tarPoin)!=model.charAt(modelPoin)){
                // 查询上一个匹配的值的部分匹配值是多少
                int n = next[modelPoin];
                int move = modelPoin-n;
                // 下一次指针坐标
                tarPoin = tempTarPoin + move+1;
                // 这一次的记录坐标
                tempTarPoin = tarPoin;

                modelPoin = 0;
            }else {
                tarPoin++;
                modelPoin++;
            }

        }

        return -1;
    }


    /**
     * 求出前缀
     * 前缀：除了最后一个字符外的所有其他字符的组合
     *
     * @param str 目标字符串
     * @return 前缀集合
     */
    public static String[] preStr(String str) {
        // 去除最后个字符
        String air = str.substring(0, str.length() - 1);
        int airLen = air.length();
        String[] returnStr = new String[airLen];
        char[] temps = air.toCharArray();
        for (int i = 0; i < airLen; i++) {
            if (i == 0) {
                returnStr[i] = String.valueOf(temps[i]);
            } else {
                returnStr[i] = returnStr[i - 1] + String.valueOf(temps[i]);
            }
        }
        return returnStr;
    }

    /**
     * 求出后缀
     * 除了第一个字符外的字符的全部组合
     *
     * @param str 目标字符串
     * @return 后缀集合
     */
    public static String[] suffixStr(String str) {
        // 去除第一个字符
        String air = str.substring(1, str.length());
        int airLen = air.length();
        String[] reult = new String[airLen];
        for (int i = 0; i < airLen; i++) {
            reult[i] = air.substring(i, airLen);
        }
        return reult;
    }

    /**
     * "部分匹配值"就是"前缀"和"后缀"的最长的共有元素的长度
     *
     * @param pre    前缀
     * @param suffix 后缀
     * @return 最长的共有元素的长度
     */
    public static int getNext(String[] pre, String[] suffix) {
        int len = suffix.length;
        int startSuffix = len;
        int temp = 0;
        for (int i = 0; i < len; i++) {
            if (pre[i].equals(suffix[--startSuffix])) {
                int preLen = pre[i].length();
                if (temp < preLen) {
                    temp = preLen;
                }
            }
        }
        return temp;
    }

    public static int[] getNexts(String str){
        int len = str.length();
        int[] next = new int[len];

        for (int i = 0; i <len ; i++) {
            String son = str.substring(0,i+1);
            next[i] = getNext(preStr(son),suffixStr(son));
        }

        return next;
    }
}
