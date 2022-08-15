package com.pouyankhodabakhsh.algorithm.utils;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.pouyankhodabakhsh.algorithm.Graph;

import java.io.IOException;
import java.util.List;

public class GraphUtils {

    public static Graph createGraph(List<String> lines) throws IOException {

        Multimap<Integer, Integer> edges = ArrayListMultimap.create();
        for (String line : lines) {
            String[] columns = line.split("\t");
            Integer v = Integer.parseInt(columns[0]);
            for (int j = 1; j < columns.length; j++) {
                int e = Integer.parseInt(columns[j]);
                edges.put(v, e);
            }
        }
        Graph graph = new Graph();
        graph.setEdges(edges);
        return graph;
    }
}
