package com.practice.programs.revise.medium.graph.undirected;

class TotalNoOfUndirectedGraphWhichCanBeFormedUsingNVertices {

    public static int countingGraphs(int n) {
        return 1 << (n * (n - 1) / 2);
    }
}
