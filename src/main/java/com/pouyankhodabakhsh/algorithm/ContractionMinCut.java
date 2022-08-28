package com.pouyankhodabakhsh.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Stream;

public class ContractionMinCut {


    private final List<Integer> counts = new ArrayList<>();

    private final Random random = new Random();

    private final Graph graph;

    public ContractionMinCut(Graph graph) {
        this.graph = graph;
    }


    public void contract() {
//        int count = 0;
//        List<Integer> edgesU;
//        List<Integer> edgesV;
//        while (graph.getEdges().asMap().size() > 2) {
//            int u = random.nextInt(Collections.max(graph.getEdges().asMap().keySet()));
//            edgesU = (List<Integer>) graph.getEdges().get(u);
//            int v = 0;
//            if (!edgesU.isEmpty()) {
//                v = edgesU.get(random.nextInt(edgesU.size()));
//            }
//            edgesV = (List<Integer>) graph.getEdges().get(v);
//            List<Integer> newVertexEdges;
//            if (v != 0 && u != v) {
//                int finalV = v;
//                newVertexEdges = new ArrayList<>(Stream.concat(edgesU.stream(), edgesV.stream())
//                        .filter(e -> e != finalV)
//                        .filter(e -> e != u)
//                        .toList());
//                graph.getEdges().removeAll(v);
//                graph.getEdges().removeAll(u);
//                graph.getEdges().putAll(u, newVertexEdges);
//                graph.getEdges().values().removeIf(a -> Objects.equals(a, finalV));
//            }
//
//        }
//
//        count += graph.getEdges().values().size();
//        counts.add(count);
    }
    public Integer retrieveCount() {
        return Collections.min(counts);
    }
}
