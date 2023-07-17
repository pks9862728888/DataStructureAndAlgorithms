package com.projects.indiamapgenerator;

import java.util.*;
import java.util.stream.IntStream;

public class MapGeneratorHelper {

    private static final int COL_MAX = 72;
    private final List<List<MapNode>> mapData;

    public MapGeneratorHelper() {
        this.mapData = generateIndiaMapNodeData();
    }

    public void drawMap() {
        mapData.stream()
                .map(this::getMapColumnIndexes)
                .forEach(colIdxSet -> {
                    IntStream.range(0, COL_MAX + 1)
                            .mapToObj(colIdx -> colIdxSet.contains(colIdx) ? "1" : " ")
                            .forEach(System.out::print);
                    System.out.println();
                });
    }

    public Set<Integer> getMapColumnIndexes(List<MapNode> rowData) {
        Set<Integer> columnIndexes = new HashSet<>();
        rowData.forEach(mapNode -> IntStream.range(mapNode.startY, mapNode.endY + 1)
                .forEach(columnIndexes::add));
        return columnIndexes;
    }

    private static List<List<MapNode>> generateIndiaMapNodeData() {
        List<List<MapNode>> mapData = new ArrayList<>();

        // Put data
        mapData.add(Collections.emptyList());
        mapData.add(Arrays.asList(new MapNode(14, 19)));
        mapData.add(Arrays.asList(new MapNode(14, 23)));
        mapData.add(Arrays.asList(new MapNode(15, 29)));
        mapData.add(Arrays.asList(new MapNode(17, 30)));
        mapData.add(Arrays.asList(new MapNode(15, 29)));
        mapData.add(Arrays.asList(new MapNode(16, 27)));
        mapData.add(Arrays.asList(new MapNode(16, 27)));
        mapData.add(Arrays.asList(new MapNode(18, 29)));
        mapData.add(Arrays.asList(new MapNode(18, 25)));
        mapData.add(Arrays.asList(new MapNode(18, 27)));
        mapData.add(Arrays.asList(new MapNode(17, 30)));
        mapData.add(Arrays.asList(new MapNode(15, 30)));
        mapData.add(Arrays.asList(new MapNode(14, 29), new MapNode(65, 69)));
        mapData.add(Arrays.asList(new MapNode(12, 30), new MapNode(63, 72)));
        mapData.add(Arrays.asList(new MapNode(11, 33), new MapNode(51, 51), new MapNode(61, 71)));
        mapData.add(Arrays.asList(new MapNode(6, 35), new MapNode(50, 51), new MapNode(57, 69)));
        mapData.add(Arrays.asList(new MapNode(5, 41), new MapNode(50, 51), new MapNode(58, 64)));
        mapData.add(Arrays.asList(new MapNode(6, 65)));
        mapData.add(Arrays.asList(new MapNode(6, 51), new MapNode(53, 64)));
        mapData.add(Arrays.asList(new MapNode(7, 50), new MapNode(53, 64)));
        mapData.add(Arrays.asList(new MapNode(1, 6), new MapNode(8, 49), new MapNode(59, 63)));
        mapData.add(Arrays.asList(new MapNode(0, 52), new MapNode(59, 62)));
        mapData.add(Arrays.asList(new MapNode(4, 51), new MapNode(59, 61)));
        mapData.add(Arrays.asList(new MapNode(6, 11), new MapNode(13, 49)));
        mapData.add(Arrays.asList(new MapNode(7, 11), new MapNode(13, 47)));
        mapData.add(Arrays.asList(new MapNode(14, 46)));
        mapData.add(Arrays.asList(new MapNode(13, 45)));
        mapData.add(Arrays.asList(new MapNode(14, 41)));
        mapData.add(Arrays.asList(new MapNode(14, 41)));
        mapData.add(Arrays.asList(new MapNode(14, 39)));
        mapData.add(Arrays.asList(new MapNode(14, 37)));
        mapData.add(Arrays.asList(new MapNode(15, 37)));
        mapData.add(Arrays.asList(new MapNode(16, 34)));
        mapData.add(Arrays.asList(new MapNode(16, 33)));
        mapData.add(Arrays.asList(new MapNode(17, 31)));
        mapData.add(Arrays.asList(new MapNode(18, 32)));
        mapData.add(Arrays.asList(new MapNode(18, 31)));
        mapData.add(Arrays.asList(new MapNode(19, 31)));
        mapData.add(Arrays.asList(new MapNode(20, 30)));
        mapData.add(Arrays.asList(new MapNode(20, 30)));
        mapData.add(Arrays.asList(new MapNode(22, 28)));
        mapData.add(Arrays.asList(new MapNode(22, 26)));
        mapData.add(Arrays.asList(new MapNode(23, 25)));
        mapData.add(Collections.emptyList());

        return mapData;
    }
}
