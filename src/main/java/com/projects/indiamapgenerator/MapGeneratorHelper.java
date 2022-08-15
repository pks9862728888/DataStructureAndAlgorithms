package com.projects.indiamapgenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MapGeneratorHelper {

    private static final int COL_MAX = 72;
    private static final int ROW_MAX = 46;
    private final HashMap<Integer, List<MapNode>> mapData;

    public MapGeneratorHelper() {
        this.mapData = generateIndiaMapNodeData();
    }

    public void drawMap() {
        for (int row = 0; row <= ROW_MAX; row++) {
            List<Integer> mapNodes = getMapColumnPoints(row);
            if (mapNodes.size() > 0) {
                for (int col = 0; col <= COL_MAX; col++) {
                    if (mapNodes.contains(col)) {
                        System.out.print("1");
                    } else {
                        System.out.print(" ");
                    }
                }
            }
            System.out.println();
        }
    }

    public List<Integer> getMapColumnPoints(int rowCount) {
        if (mapData.containsKey(rowCount)) {
            List<Integer> points = new ArrayList<>();
            for (MapNode mapNode: mapData.get(rowCount)) {
                for (int i = mapNode.startY; i <= mapNode.endY; i++) {
                    points.add(i);
                }
            }
            return points;
        }
        return List.of();
    }

    private static HashMap<Integer, List<MapNode>> generateIndiaMapNodeData() {
        HashMap<Integer, List<MapNode>> mapData = new HashMap<>();
        int rowCount = 0;

        // Put data
        mapData.put(rowCount++, List.of(new MapNode(14, 19)));
        mapData.put(rowCount++, List.of(new MapNode(14, 23)));
        mapData.put(rowCount++, List.of(new MapNode(15, 29)));
        mapData.put(rowCount++, List.of(new MapNode(17, 30)));
        mapData.put(rowCount++, List.of(new MapNode(15, 29)));
        mapData.put(rowCount++, List.of(new MapNode(16, 27)));
        mapData.put(rowCount++, List.of(new MapNode(16, 27)));
        mapData.put(rowCount++, List.of(new MapNode(18, 29)));
        mapData.put(rowCount++, List.of(new MapNode(18, 25)));
        mapData.put(rowCount++, List.of(new MapNode(18, 27)));
        mapData.put(rowCount++, List.of(new MapNode(17, 30)));
        mapData.put(rowCount++, List.of(new MapNode(15, 30)));
        mapData.put(rowCount++, List.of(new MapNode(14, 29), new MapNode(65, 69)));
        mapData.put(rowCount++, List.of(new MapNode(12, 30), new MapNode(63, 72)));
        mapData.put(rowCount++, List.of(new MapNode(11, 33), new MapNode(51, 51), new MapNode(61, 71)));
        mapData.put(rowCount++, List.of(new MapNode(6, 35), new MapNode(50, 51), new MapNode(57, 69)));
        mapData.put(rowCount++, List.of(new MapNode(5, 41), new MapNode(50, 51), new MapNode(58, 64)));
        mapData.put(rowCount++, List.of(new MapNode(6, 65)));
        mapData.put(rowCount++, List.of(new MapNode(6, 51), new MapNode(53, 64)));
        mapData.put(rowCount++, List.of(new MapNode(7, 50), new MapNode(53, 64)));
        mapData.put(rowCount++, List.of(new MapNode(1, 6), new MapNode(8, 49), new MapNode(59, 63)));
        mapData.put(rowCount++, List.of(new MapNode(0, 52), new MapNode(59, 62)));
        mapData.put(rowCount++, List.of(new MapNode(4, 51), new MapNode(59, 61)));
        mapData.put(rowCount++, List.of(new MapNode(6, 11), new MapNode(13, 49)));
        mapData.put(rowCount++, List.of(new MapNode(7, 11), new MapNode(13, 47)));
        mapData.put(rowCount++, List.of(new MapNode(14, 46)));
        mapData.put(rowCount++, List.of(new MapNode(13, 45)));
        mapData.put(rowCount++, List.of(new MapNode(14, 41)));
        mapData.put(rowCount++, List.of(new MapNode(14, 41)));
        mapData.put(rowCount++, List.of(new MapNode(14, 39)));
        mapData.put(rowCount++, List.of(new MapNode(14, 37)));
        mapData.put(rowCount++, List.of(new MapNode(15, 37)));
        mapData.put(rowCount++, List.of(new MapNode(16, 34)));
        mapData.put(rowCount++, List.of(new MapNode(16, 33)));
        mapData.put(rowCount++, List.of(new MapNode(17, 31)));
        mapData.put(rowCount++, List.of(new MapNode(18, 32)));
        mapData.put(rowCount++, List.of(new MapNode(18, 31)));
        mapData.put(rowCount++, List.of(new MapNode(19, 31)));
        mapData.put(rowCount++, List.of(new MapNode(20, 30)));
        mapData.put(rowCount++, List.of(new MapNode(20, 30)));
        mapData.put(rowCount++, List.of(new MapNode(22, 28)));
        mapData.put(rowCount++, List.of(new MapNode(22, 26)));
        mapData.put(rowCount++, List.of(new MapNode(23, 25)));

        return mapData;
    }
}
