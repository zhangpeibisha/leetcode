package org.nix.learn.offer.pdd;

import java.util.*;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2018/11/8
 */
public class Four {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        int m = in.nextInt();
//        int n = in.nextInt();
//        int[] l = new int[m];
        int m = 5;
        int n = 3;
        int[] l = {1, 8,10,56,12};
//        for (int i = 0; i < m; i++) {
//            l[i] = in.nextInt();
//        }
        System.out.println(run(n, l));
    }


    public static int run(int n, int[] l) {
        Arrays.sort(l);
        int len = l.length;
        // 找出相同的数字有多少个
        int pre = l[0];
        int temp = 1;
        List<Node> nodes = new ArrayList<>();
        for (int i = 1; i < len; i++) {
            if (pre == l[i]) {
                temp++;
            } else {
                nodes.add(new Node(pre, temp));
                temp = 1;
                pre = l[i];
            }
        }
        nodes.add(new Node(pre, temp));
        // 按次数降序排序
        nodes.sort(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o2.numer - o1.numer;
            }
        });
        // 如果数量直接大于需求的，则直接不用管理了
        int nodeLen = nodes.size();
        if (nodeLen != 0) {
            if (nodes.get(0).numer >= n) {
                return 0;
            }
        }

        // 肯定只有低的给高的添加，所以应该按值降序排序
        nodes.sort(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o2.val - o1.val;
            }
        });
        int[] tainjia = new int[nodeLen];
        int index = 0;
        for (int i = 0; i < nodeLen; i++) {
            Node nodeI = nodes.get(i);
            // 还差几栋楼
            int cha = n - nodeI.numer;
            boolean wancheng = false;
            for (int j = i + 1; j < nodeLen; j++) {
                Node nodeJ = nodes.get(j);
                // 差的高度
                int tempV = (nodeI.val - nodeJ.val);
                if (nodeJ.numer >= cha) {
                    tainjia[index] += tempV * cha;
                    index++;
                    wancheng = true;
                    break;
                }
                if (nodeJ.numer < cha) {
                    cha = cha - nodeJ.numer;
                    tainjia[index] += tempV * nodeJ.numer;
                }
            }
            if (!wancheng){
                tainjia[--index] = 0;
            }
        }
        Arrays.sort(tainjia);
        return getMin(tainjia);
    }

    public static int getMin(int[] val) {
        int len = val.length;
        for (int i = 0; i < len; i++) {
            if (val[i] != 0) {
                return val[i];
            }
        }
        return 0;
    }

    static class Node implements Comparable<Node> {
        int val;
        int numer;

        public Node(int val, int numer) {
            this.val = val;
            this.numer = numer;
        }

        @Override
        public int compareTo(Node o) {
            return numer - o.numer;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return val == node.val &&
                    numer == node.numer;
        }

        @Override
        public int hashCode() {

            return Objects.hash(val, numer);
        }
    }
}
