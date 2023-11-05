package com.practice.programs.medium.priorityqueue;

import java.util.*;

/**
 * TC: O(n) AS: O(1), because distinct tasks are constant size A-Z as per problem statement
 * <a href="https://www.codingninjas.com/studio/problems/task-scheduler_1070424?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf">Practice Link</a>
 */
class TaskScheduler {

    // First try largest freq elements every time
    // If largest freq elements can't be scheduled then only try to schedule lowest freq elements

    public static int taskScheduler(String s, int k) {
        PriorityQueue<Task> taskQueue = buildTaskQueue(s);
        int timeTaken = 0;
        int currInstant = 0;
        while (!taskQueue.isEmpty()) {
            timeTaken++;
            currInstant++;
            Queue<Task> suspendedQ = new LinkedList<>();
            while (!taskQueue.isEmpty()) {
                Task task = taskQueue.poll();
                if (currInstant >= task.scheduledInterval) {
                    task.scheduledInterval = currInstant + k + 1;
                    task.freq--;
                    if (task.freq > 0) {
                        taskQueue.add(task);
                    }
                    break;
                } else {
                    suspendedQ.add(task);
                }
            }
            taskQueue.addAll(suspendedQ);
        }
        return timeTaken;
    }

    private static PriorityQueue<Task> buildTaskQueue(String s) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }
        PriorityQueue<Task> pq = new PriorityQueue<>();
        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            pq.add(new Task(entry.getKey(), entry.getValue()));
        }
        return pq;
    }

    private static class Task implements Comparable<Task> {
        char ch;
        int freq;
        int scheduledInterval;

        Task(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
            scheduledInterval = 1;
        }

        @Override
        public int compareTo(Task b) {
            int freqComp = -1 * Integer.compare(freq, b.freq);
            return freqComp == 0 ? Integer.compare(scheduledInterval, b.scheduledInterval) : freqComp;
        }
    }
}
