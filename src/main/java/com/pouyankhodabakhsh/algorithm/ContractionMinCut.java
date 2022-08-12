package com.pouyankhodabakhsh.algorithm;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.pouyankhodabakhsh.algorithm.config.Configuration;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Stream;

public class ContractionMinCut {


    private final List<Integer> counts = new ArrayList<>();

    private final Random random = new Random();

    public ContractionMinCut() throws NoSuchAlgorithmException {
        // TODO document why this constructor is empty
    }

    public static Graph createGraph() throws IOException {

        Configuration configuration = Configuration.getInstance();
        String filepath = configuration.getFilepath();
        File file = new File(filepath + "kargerMinCut.txt");
        List<String> lines = FileUtils.readLines(file, StandardCharsets.UTF_8);
        Graph graph = new Graph();
        List<Integer> vertexes = new ArrayList<>();
        Multimap<Integer, Integer> edges = ArrayListMultimap.create();
        for (String line : lines) {
            String[] columns = line.split("\t");
            Integer v = Integer.parseInt(columns[0]);
            for (int j = 1; j < columns.length; j++) {
                int e = Integer.parseInt(columns[j]);
                edges.put(v, e);
            }
        }
        graph.setVertexList(vertexes);
        graph.setEdges(edges);
        return graph;
    }

    public void contract(Graph graph) {
        int count = 0;
        List<Integer> edgesU;
        List<Integer> edgesV;
        while (graph.getEdges().asMap().size() > 2) {
            int u = random.nextInt(Collections.max(graph.getEdges().asMap().keySet()));
            edgesU = (List<Integer>) graph.getEdges().get(u);
            int v = 0;
            if (!edgesU.isEmpty()) {
                v = edgesU.get(random.nextInt(edgesU.size()));
            }
            edgesV = (List<Integer>) graph.getEdges().get(v);
            List<Integer> newVertexEdges;
            if (v != 0 && u != v) {
                int finalV = v;
                newVertexEdges = new ArrayList<>(Stream.concat(edgesU.stream(), edgesV.stream())
                        .filter(e -> e != finalV)
                        .filter(e -> e != u)
                        .toList());
                graph.getEdges().removeAll(v);
                graph.getEdges().removeAll(u);
                graph.getEdges().putAll(u, newVertexEdges);
                graph.getEdges().values().removeIf(a -> Objects.equals(a, finalV));
            }

        }

        count += graph.getEdges().values().size();
        counts.add(count);
    }
    public Integer retrieveCount() {
        return Collections.min(counts);
    }
}
