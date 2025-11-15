import java.io.*;
import java.util.*;

class Solution {
    private static Map<Integer, Point> map = new HashMap<>();
    private static Queue<Point>[] record;
    private static int[][] points, routes;

    public int solution(int[][] point, int[][] route) {
        int answer = 0;
        points = point;
        routes = route;
        int pointSize = points.length;

        for (int i = 0; i < pointSize; i++) {
            int x = points[i][0];
            int y = points[i][1];
            map.put(i + 1, new Point(x, y));
        }

        int robotNum = routes.length;
        record = new ArrayDeque[robotNum];
        for (int i = 0; i < robotNum; i++) {
            record[i] = new ArrayDeque<>();
        }

        // 이동 경로 생성
        makeRoute();

        // 충돌 계산
        answer = checkCrash(robotNum);
        return answer;
    }

    private static int checkCrash(int size) {
        int count = 0;
        int finished = 0;

        while (finished < size) {
            Map<Point, Integer> mapCrash = new HashMap<>();

            finished = 0;

            for (int i = 0; i < size; i++) {
                if (record[i].isEmpty()) {
                    finished++;
                    continue;
                }

                Point now = record[i].poll();

                mapCrash.put(now, mapCrash.getOrDefault(now, 0) + 1);
            }

            for (Map.Entry<Point, Integer> entry : mapCrash.entrySet()) {
                if (entry.getValue() > 1) count++;
            }
        }
        return count;
    }

    private static void makeRoute() {
        int size = routes.length;

        for (int i = 0; i < size; i++) {
            int from = routes[i][0];
            Point start = map.get(from);

            // start의 좌표를 복사본으로 생성
            Point current = new Point(start.x, start.y);
            record[i].offer(new Point(current.x, current.y));

            for (int j = 1; j < routes[i].length; j++) {
                int to = routes[i][j];
                Point target = map.get(to);

                // X 이동
                while (current.x != target.x) {
                    if (current.x < target.x) current.x++;
                    else current.x--;
                    record[i].offer(new Point(current.x, current.y));
                }

                // Y 이동
                while (current.y != target.y) {
                    if (current.y < target.y) current.y++;
                    else current.y--;
                    record[i].offer(new Point(current.x, current.y));
                }
            }
        }
    }

    private static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        // 충돌 판정 위해 반드시 필요
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Point)) return false;
            Point p = (Point) o;
            return x == p.x && y == p.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
