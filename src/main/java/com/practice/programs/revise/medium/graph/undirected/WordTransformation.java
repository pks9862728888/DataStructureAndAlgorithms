package com.practice.programs.revise.medium.graph.undirected;

import java.util.*;

/**
 * TC: O (m * n ^ 2), where m = length of words, n = total no of words
 * AS: O (m * n ^ 2), where m = length of words, n = total no of words ????
 */
public class WordTransformation {

    private static class WordPath {
        String word;
        int pathLength;
        WordPath(String w, int len) {
            word = w;
            pathLength = len;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> graph = initGraph(wordList, beginWord);
        Map<String, Boolean> visited = initVisitedMapWithFalse(wordList);
        Queue<WordPath> q = new LinkedList<>();
        q.add(new WordPath(beginWord, 1));
        while (!q.isEmpty()) {
            WordPath curr = q.poll();
            List<String> adjWords = graph.get(curr.word);
            for (String adjWd: adjWords) {
                if (!visited.get(adjWd)) {
                    if (adjWd.equals(endWord)) {
                        return curr.pathLength + 1;
                    }
                    visited.put(adjWd, true);
                    q.add(new WordPath(adjWd, curr.pathLength + 1));
                }
            }
        }
        return 0;
    }

    private Map<String, List<String>> initGraph(List<String> wordList, String beginWord) {
        Map<String, List<String>> graph = new HashMap<>();
        for (String w: wordList) {
            graph.put(w, new ArrayList<>());
        }
        graph.put(beginWord, new ArrayList<>());
        for (int i = 0; i < wordList.size(); i++) {
            String wd1 = wordList.get(i);
            for (int j = i + 1; j < wordList.size(); j++) {
                String wd2 = wordList.get(j);
                if (isCharDiffOne(wd1, wd2)) {
                    graph.get(wd1).add(wd2);
                    graph.get(wd2).add(wd1);
                }
            }
        }
        for (String wd: wordList) {
            if (isCharDiffOne(beginWord, wd)) {
                graph.get(beginWord).add(wd);
            }
        }
        return graph;
    }

    private boolean isCharDiffOne(String w1, String w2) {
        int charDiff = 0;
        for (int i = 0; i < w1.length(); i++) {
            if (w1.charAt(i) != w2.charAt(i)) {
                charDiff++;
                if (charDiff > 1) {
                    return false;
                }
            }
        }
        return true;
    }

    private Map<String, Boolean> initVisitedMapWithFalse(List<String> wordList) {
        Map<String, Boolean> map = new HashMap<>();
        for (String w: wordList) {
            map.put(w, false);
        }
        return map;
    }
}
