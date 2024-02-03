package com.practice.programs.revise.medium.graph.directed;

import java.util.*;

/**
 * TC: n + E
 * AS: n + E
 */
public class CheapestFlightCostBetweenSourceToDestinationWithMaxKStops {

    public static int cheapestFlights(int n, List<List<Integer>> flight, int source, int des, int k) {
        List<List<Pair>> adjList = buildGraph(flight, n);
        // Use Dijkstra's algorithm
        // Find cheapest flight between source to destination with max k switch
        int[] prices = new int[n + 1];
        Arrays.fill(prices, Integer.MAX_VALUE);
        prices[source] = 0;

        // We can use linked list over priority queue because stop increases by 1 & min stop is the criteria
        Queue<StopsPair> q = new LinkedList<>();
        q.add(new StopsPair(source, 0, 0));
        while (!q.isEmpty()) {
            StopsPair currStop = q.poll();
            if (currStop.stops <= k) {
                List<Pair> adjNodes = adjList.get(currStop.v);
                for (Pair adjNode: adjNodes) {
                    int newPrice = currStop.price + adjNode.price;
                    int newStopCount = currStop.stops + 1;
                    if (newPrice < prices[adjNode.v]) {
                        prices[adjNode.v] = newPrice;
                        q.add(new StopsPair(adjNode.v, newPrice, newStopCount));
                    }
                }
            }
        }
        return prices[des] != Integer.MAX_VALUE ? prices[des] : -1;
    }

    private static List<List<Pair>> buildGraph(List<List<Integer>> flights, int n) {
        List<List<Pair>> adjList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (List<Integer> edge: flights) {
            int u = edge.get(0);
            int v = edge.get(1);
            int price = edge.get(2);
            adjList.get(u).add(new Pair(v, price));
        }
        return adjList;
    }

    private static class StopsPair implements Comparable<StopsPair> {
        int v;
        int price;
        int stops;
        StopsPair(int v, int p, int s) {
            this.v = v;
            this.price = p;
            this.stops = s;
        }
        @Override
        public int compareTo(StopsPair other) {
            return Integer.compare(this.price, other.price);
        }
    }

    private static class Pair {
        int v;
        int price;
        Pair(int v, int price) {
            this.v = v;
            this.price = price;
        }
    }
}
