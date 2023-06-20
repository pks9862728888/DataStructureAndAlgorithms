package com.demo.datastructures.impl.heaps.minheap;

import lombok.extern.slf4j.Slf4j;

import java.util.PriorityQueue;

@Slf4j
class MinHeapDemo {

    public static final String CUSTOM_IMPL = "customImpl";
    public static final String PQ = "pQ";

    public static void main(String[] args) {
        int[] arr = new int[]{20, 10, 5, 3, -1, 7};

        // Verify add operation
        MinHeap<Integer> minHeapCustomImpl = getMinHeapCustomImpl(arr);
        PriorityQueue<Integer> minPQ = getMinHeapPQ(arr);
        log.info("{} add: {}", CUSTOM_IMPL, minHeapCustomImpl);
        log.info("{} add: {}", PQ, minPQ);

        // Verify peek operation
        log.info("{} peek: {}", CUSTOM_IMPL, minHeapCustomImpl.peek());
        log.info("{} peek: {}", PQ, minPQ.peek());

        // Verify poll operation
        log.info("{} poll: {}", CUSTOM_IMPL, minHeapCustomImpl.poll());
        log.info("{} poll: {}", PQ, minPQ.poll());

        // Value after poll
        log.info("{} afterPoll: {}", CUSTOM_IMPL, minHeapCustomImpl);
        log.info("{} afterPoll: {}", PQ, minPQ);

        // Decrease key (increase priority)
        minHeapCustomImpl.increasePriority(3, -1);
        log.info("{} afterIncreasePriority: {}", CUSTOM_IMPL, minHeapCustomImpl);
        log.info("{} poll: {}", CUSTOM_IMPL, minHeapCustomImpl.poll());
        log.info("{} afterPoll: {}", CUSTOM_IMPL, minHeapCustomImpl);

        // Delete key
        int idxToDelete = 1;
        log.info("{} deleted key at idx: {} having value: {}", CUSTOM_IMPL, idxToDelete,
                minHeapCustomImpl.deleteAtIdx(idxToDelete));
        log.info("{} after deleteKey: {}", CUSTOM_IMPL, minHeapCustomImpl);
    }

    private static PriorityQueue<Integer> getMinHeapPQ(int[] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int ele: arr) {
            pq.add(ele);
        }
        return pq;
    }

    private static MinHeap<Integer> getMinHeapCustomImpl(int[] arr) {
        MinHeap<Integer> minHeap = new MinHeap<>(5);
        for (int ele: arr) {
            minHeap.add(ele, ele);
        }
        return minHeap;
    }
}
