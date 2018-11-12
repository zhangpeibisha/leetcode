package org.nix.learn.offer.gaosi;

import java.util.*;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2018/11/9
 */
public class Main {

    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        List<Integer> list = new ArrayList<>();
//        while (in.hasNext()) {
//            list.add(in.nextInt());
//        }
//        Integer[] temp = new Integer[list.size()];
//        temp = list.toArray(temp);
        Integer[] temp = {4,5,6,5,4,3,5,5,7,8,7,7,8,5,5,4,4,7,8};
        customSort(temp);
        for (int val : temp) {
            System.out.print(val);
        }
    }

    public static void customSort(Integer[] arr) {
        // 首先排序
        Arrays.sort(arr);
        int len = arr.length;
        int pre = arr[0];
        int number = 1;
        List<Node> nodes = new ArrayList<>();
        for (int i = 1; i < len; i++) {
            if (pre == arr[i]) {
                number++;
            } else {
                nodes.add(new Node(pre, number));
                pre = arr[i];
                number = 1;
            }
        }
        nodes.add(new Node(pre, number));
        List<Integer> list = result(nodes);
        for (int i = 0; i < len; i++) {
            arr[i] = list.get(i);
        }
    }


    public static List<Integer> result(List<Node> nodes) {
        List<Integer> result = new ArrayList<>();
        // 首先按次数排序
        nodes.sort(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o2.number - o1.number;
            }
        });
        int size = nodes.size();
        List<Node> temp = new ArrayList<>();
        int numer = nodes.get(0).number;
        int index = 0;
        for (int i = 0; i < size; i++) {
            Node node = nodes.get(i);
            if (node.number == numer) {
                temp.add(node);
            } else {
                int tempSize = temp.size();
                List<Integer> tempResult = new ArrayList<>();
                for (int j = 0; j < tempSize; j++) {
                    Node tempNode = temp.get(j);
                    for (int k = 0; k < tempNode.number; k++) {
                        tempResult.add(tempNode.val);
                    }
                }
                // 从大到小排序
                tempResult.sort(new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o2 - o1;
                    }
                });
                result.addAll(tempResult);
                temp.clear();
                numer = nodes.get(i--).number;
                // 退出时，从该节点的后续节点肯定次数相同
                index = i+1;
            }
        }

        nodes = nodes.subList(index, nodes.size());
        size = nodes.size();
        List<Integer> tempResult = new ArrayList<>();
        for (int j = 0; j < size; j++) {
            Node tempNode = nodes.get(j);
            for (int k = 0; k < tempNode.number; k++) {
                tempResult.add(tempNode.val);
            }
        }
        // 从大到小排序
        tempResult.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        result.addAll(tempResult);
        return result;
    }


    static class Node {
        int val;
        int number;

        public Node(int val, int number) {
            this.val = val;
            this.number = number;
        }
    }


}
