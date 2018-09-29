package org.nix.learn.sort;

import java.util.*;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2018/9/25
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i <n ; i++) {
            a[i] = in.nextInt();
        }
        System.out.println(getResult(a));
    }

    public static int getResult(int[] a) {
        return getNumber(getSameValueNumber(a));
    }

    /**
     * 先将重复值分别放入不同的数组中
     *
     * @param a
     */
    public static List<Value> getSameValueNumber(int[] a) {
        Arrays.sort(a);

        int temp = 0;
        int tempValue = Integer.MAX_VALUE;

        List<Value> list = new ArrayList<>();

        boolean flag = false;

        for (int value : a) {
            if (list.size() != 0 && value != list.get(list.size() - 1).value) {
                list.add(new Value(value, 1));
            } else if (list.size() != 0) {
                list.get(list.size() - 1).setNumber(list.get(list.size() - 1).getNumber() + 1);
            } else {
                list.add(new Value(value, 1));
            }
        }
        return list;
    }

    /**
     * 得到可以看到多少个盒子
     *
     * @return
     */
    public static int getNumber(List<Value> values) {

        // 排序
        values.sort(new Comparator<Value>() {
            @Override
            public int compare(Value o1, Value o2) {
                return o1.value - o2.value;
            }
        });
        return getNumber(values,0);
    }

    public static int getNumber(List<Value> values,int temp){
        int len = values.size();
        if (len<=0){
            return temp;
        }
        Value value = values.get(len-1);
        temp++;
        return getNumber(deleteMaxValue(values,value.number),temp);
    }

    /**
     * 删除已经使用的了盒子
     *
     * @param values
     * @return
     */
    public static List<Value> deleteMaxValue(List<Value> values, int number) {
        Iterator<Value> iterator = values.iterator();
        while (iterator.hasNext()) {
            Value value = iterator.next();
            value.number = value.number - number;
            if (value.number <= 0) {
                iterator.remove();
            }
        }
        return values;
    }

    static class Value implements Comparable<Value> {
        private int value;
        private int number;

        public Value(int value, int number) {
            this.value = value;
            this.number = number;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        @Override
        public int compareTo(Value o) {
            return this.value - o.value;
        }

        @Override
        public String toString() {
            return "Value{" +
                    "value=" + value +
                    ", number=" + number +
                    '}';
        }
    }
}



