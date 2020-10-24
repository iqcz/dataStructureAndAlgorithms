package com.lee.datastructureandalgorithms.tuling;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

class Point {
    int x;
    int y;
}

public class BFS {

    int n; // 地图的行
    int m; // 地图的列
    int dx; // 小美的位置x
    int dy; // 小美的位置y
    int data[][]; // 邻接矩阵
    boolean mark[][]; // 标记数据 走过的位置

    /**
     *  // x he y表示你当前的位置,就是求（x，y）->(dx,dy)能不能到
     * @param x
     * @param y
     */
    public void bfs(int x, int y) {
        if (x < 1 || x > n || y < 1 || y > m) {
            return;
        }
        if (x == dx && y == dy) {
            System.out.println("true");
            return;
        }
        mark[x][y] = true;
        // 因为最多也就是n*m个点
        Queue<Point> queue = new ArrayBlockingQueue<Point>(n * m);
        Point start = new Point();
        start.x = x;
        start.y = y;
        queue.add(start);
        // 经典
        int[][] next = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        while (!queue.isEmpty()) {        //O(n)
            // 拿出队列的第一个点
            Point point = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextx = point.x + next[i][0];
                int nexty = point.y + next[i][1];
                if (nextx < 1 || nextx > n || nexty < 1 || nexty > m) {
                    continue;
                }
                //表示可以走
                if (data[nextx][nexty] == 0 && !mark[nextx][nexty]) {
                    //表示可以到了 就不走了
                    if (nextx == dx && nexty == dy) {
                        System.out.println("true");
                        return;
                    }
                    Point newPoint = new Point();
                    newPoint.x = nextx;
                    newPoint.y = nexty;
                    mark[nextx][nexty] = true;
                    queue.add(newPoint);
                }
            }
        }
        System.out.println("false");
        return;
    }
}
