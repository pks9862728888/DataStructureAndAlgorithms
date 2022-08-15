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
                        System.out.print("!");
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

        return mapData;
    }
}
