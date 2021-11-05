package com.lee.datastructureandalgorithms.zen;

import com.google.common.collect.Lists;

import java.util.*;

/**
 * 给你一个排好序的整数类型数组，
 */
public class Zen02 {

    public static void main(String[] args) {
        int[] data = {1, 2, 3, 4, 5, 6, 7};
        Node root = buildTree(data, 0, data.length - 1);
        System.out.println("root = " + root);

        System.out.println("getPathSums(node) = " + getPathSums(root));

        System.out.println("==========getPathSumsRecursion================");
        List<Integer> sums = Lists.newArrayList();
        getPathSumsRecursion(root, 0, sums);
        System.out.println(sums);

        System.out.println("==========getEveryPathSums================");
        Map<Node, Integer> everyPathSums = getEveryPathSums(root);
        for (Node node : everyPathSums.keySet()) {
            System.out.printf("Root to %d: %d\n", node.val, everyPathSums.get(node));
        }

        System.out.println("==========collectSums================");
        List<Integer> sums1 = collectSums(root);
        System.out.println("sums1 = " + sums1);

        System.out.println("==========collectSumsEnhance================");
        List<Integer> sums2 = collectSumsEnhance(root);
        System.out.println("sums2 = " + sums2);
    }

    /**
     * 如何能够把它转化成一颗平衡的二叉搜索树；
     *
     * @param data
     * @param lowIndex
     * @param highIndex
     * @return
     */
    public static Node buildTree(int[] data, int lowIndex, int highIndex) {
        // 越界补偿
        if (lowIndex > highIndex) {
            return null;
        }

        int middleIndex = lowIndex + (highIndex - lowIndex) / 2;
        Node root = new Node(data[middleIndex]);
        root.left = buildTree(data, lowIndex, middleIndex - 1);
        root.right = buildTree(data, middleIndex + 1, highIndex);
        return root;
    }

    /**
     *
     * 用递推代码实现递推思想
     * 从root到每个叶子节点的路径和
     *
     * @param root
     * @return
     */
    public static List<Integer> getPathSums(Node root) {
        List<Integer> sums = new ArrayList<>();
        // 存储到父级结点的不完全路径和
        Queue<Integer> sumQ = new LinkedList<>();
        Queue<Node> nodeQ = new LinkedList<>();

        sumQ.offer(0);
        nodeQ.offer(root);

        while (!nodeQ.isEmpty()) {
            Node curNode = nodeQ.poll();
            if (curNode == null) {
                continue;
            }

            int curSum = curNode.val + sumQ.poll();
            if (curNode.left == null && curNode.right == null) {
                sums.add(curSum);
            }

            sumQ.offer(curSum);
            nodeQ.offer(curNode.left);
            sumQ.offer(curSum);
            nodeQ.offer(curNode.right);
        }

        return sums;
    }

    /**
     * 用递归代码实现递推思想
     * @param root
     * @return
     */
    public static void getPathSumsRecursion(Node root, int parentSum, List<Integer> sums) {
        if (root == null) {
            return;
        }
        int curSum = root.val + parentSum;
        if (root.left == null || root.right == null) {
            sums.add(curSum);
        }
        getPathSumsRecursion(root.left, curSum, sums);
        getPathSumsRecursion(root.right, curSum, sums);

    }

    public static Map<Node, Integer> getEveryPathSums(Node root) {
        HashMap<Node, Integer> sums = new HashMap<>(16);
        Queue<Node> nodeQ = new LinkedList<>();
        // 绑定结点与到当前结点的路径和
        sums.put(root, root.val);
        nodeQ.offer(root);

        while (!nodeQ.isEmpty()) {
            Node curNode = nodeQ.poll();
            Integer curSum = sums.get(curNode);

            // 去掉不完全路径和
            /* 这段代码注释后，运行结果同getPathSums方法
            if (curNode.left != null || curNode.right != null) {
                sums.remove(curNode);
            }
            */

            if (curNode.left != null) {
                nodeQ.offer(curNode.left);
                sums.put(curNode.left, curSum + curNode.left.val);
            }

            if (curNode.right != null) {
                nodeQ.offer(curNode.right);
                sums.put(curNode.right, curSum + curNode.right.val);
            }
        }
        return sums;
    }

    /**
     * 用递归代码实现递归思想
     * @param node
     * @return
     */
    public static List<Integer> collectSums(Node node) {
        List<Integer> sums = Lists.newArrayList();
        if (node == null) {
            return sums;
        }

        sums.addAll(collectSums(node.left));
        sums.addAll(collectSums(node.right));

        for (int i = 0; i < sums.size(); i++) {
            sums.set(i, sums.get(i) + node.val);
        }

        if (sums.isEmpty()) {
            sums.add(node.val);
        }

        return sums;
    }
    /**
     * 用递归代码实现递归思想：改进版
     * @param node
     * @return
     */
    public static List<Integer> collectSumsEnhance(Node node) {
        List<Integer> sums = Lists.newArrayList();
        // 越界补偿
        if (node == null) {
            return sums;
        }

        for (int sum : collectSumsEnhance(node.left)) {
            sums.add(sum + node.val);
        }

        for (int sum : collectSumsEnhance(node.right)) {
            sums.add(sum + node.val);
        }
        if (sums.isEmpty()) {
            // 左右孩子均为null
            sums.add(node.val);
        }
        return sums;
    }
}