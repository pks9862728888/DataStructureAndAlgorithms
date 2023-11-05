package com.practice.programs.medium.priorityqueue;

import java.util.PriorityQueue;

class FindKPointsClosestToOrigin {

    /**
     * TC: O(n log k + k log k) -> O(n log k)
     * AS: O(2k)
     */
    public static long[][] kClosestPointsToOrigin(long[][] points, int k) {
        // Find k closest points to origin
        PriorityQueue<Tuple> pq = new PriorityQueue<>((p1, p2) ->
                -1 * Double.compare(p1.distance, p2.distance));
        for (int i = 0; i < points.length; i++) {
            long x = points[i][0];
            long y = points[i][1];
            double distanceFromOrigin = distanceFromOrigin(x, y);
            if (pq.size() < k || distanceFromOrigin < pq.peek().distance) {
                pq.add(new Tuple(x, y, distanceFromOrigin));
                if (pq.size() > k) {
                    pq.poll();
                }
            }
        }

        // Return result in any order
        int pqSize = pq.size();
        long[][] kClosestPoints = new long[pqSize][2];
        int idx = 0;
        while (!pq.isEmpty()) {
            Tuple point = pq.poll();
            kClosestPoints[idx][0] = point.x;
            kClosestPoints[idx][1] = point.y;
            idx++;
        }
        return kClosestPoints;
    }

    private static double distanceFromOrigin(long x, long y) {
        return Math.sqrt(x * x + y * y);
    }

    private static class Tuple {
        long x;
        long y;
        double distance;
        Tuple(long x, long y, double distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
}
