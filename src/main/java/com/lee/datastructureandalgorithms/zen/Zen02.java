package com.lee.datastructureandalgorithms.zen;

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
        System.out.println("==========================");

        Map<Node, Integer> everyPathSums = getEveryPathSums(root);
        for (Node node : everyPathSums.keySet()) {
            System.out.printf("Root to %d: %d\n", node.val, everyPathSums.get(node));
        }
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
}