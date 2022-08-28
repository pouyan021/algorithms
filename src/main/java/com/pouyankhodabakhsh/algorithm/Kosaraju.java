package com.pouyankhodabakhsh.algorithm;


import org.jgrapht.alg.connectivity.KosarajuStrongConnectivityInspector;
import org.jgrapht.alg.interfaces.StrongConnectivityAlgorithm;
import org.jgrapht.graph.DefaultEdge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class Kosaraju {

    private final org.jgrapht.Graph graph;
    private List<Boolean> explored;

    private final Stack<Long> fV;

    private final List<Long> sccs;

    private long numScc = 0L;


    public Kosaraju(org.jgrapht.Graph<Integer, DefaultEdge> graph) {
        this.graph = (org.jgrapht.Graph) graph;
        fV = new Stack<>();
        sccs = new ArrayList<>();
    }

    public List<Long> computeSCC() {
        StrongConnectivityAlgorithm<Integer, Integer> strongConnectivityAlgorithm
                = new KosarajuStrongConnectivityInspector<>(graph);
       List<Set<Integer>> subgraphs = strongConnectivityAlgorithm.stronglyConnectedSets();
        for (Set<Integer> subgraph : subgraphs) {
            sccs.add((long) subgraph.size());
        }
//        explored = new ArrayList<>(Collections.nCopies(graph.getVertex(), Boolean.FALSE));
//        topoSort(reverseGraph(graph));
//        explored = new ArrayList<>(Collections.nCopies(graph.getVertex(), Boolean.FALSE));
//        int i = fV.size() - 1;
//        while (i > 1) {
//            Long aLong = fV.get(i);
//            if (Boolean.FALSE.equals(explored.get(aLong.intValue()))) {
//                numScc++;
//                sccs.add(dfsScc(graph, aLong));
//            }
//            i--;
//        }
//
        sccs.sort(Collections.reverseOrder());
        return sccs.subList(0, 20);
    }



    private void topoSort(Graph graph) {
        int i = graph.getVertex() - 1;
        while (i >= 1) {
            if (Boolean.FALSE.equals(explored.get(i))) {
                dFSTopo(graph, i);
            }
            i--;
        }
    }

    private void dFSTopo(Graph graph, long vertex) {
        explored.set((int) vertex, Boolean.TRUE);
        for (int v : (Iterable<Integer>) graph.edge[(int) vertex]) {
            if (Boolean.FALSE.equals(explored.get(v))) {
                dFSTopo(graph, v);
            }
        }
        fV.push(vertex);
    }

    private long dfsScc(Graph graph, long vertex) {
        explored.set((int) vertex, Boolean.TRUE);
        for (int v : (Iterable<Integer>) graph.edge[(int) vertex]) {
            if (Boolean.FALSE.equals(explored.get(v))) {
                dfsScc(graph, v);
            }
        }
        return numScc;
    }

    private Graph reverseGraph(Graph graph) {
        Graph reverseGraph = new Graph(graph.getVertex());
        for (int i = 1; i < graph.getVertex(); i++) {
            LinkedList<Integer> nodeList = graph.edge[i];
            for (int destination : nodeList) {
                reverseGraph.addEdge(destination, i);
            }
        }
        return reverseGraph;
    }

}
