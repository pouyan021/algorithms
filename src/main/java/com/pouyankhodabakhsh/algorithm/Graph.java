package com.pouyankhodabakhsh.algorithm;

import com.google.common.collect.Multimap;

import java.io.Serializable;
import java.util.List;

public class Graph implements Serializable {
    private List<Integer> vertexList;
    private Multimap<Integer, Integer> edges;

    public List<Integer> getVertexList() {
        return vertexList;
    }

    public void setVertexList(List<Integer> vertexList) {
        this.vertexList = vertexList;
    }

    public Multimap<Integer, Integer> getEdges() {
        return edges;
    }

    public void setEdges(Multimap<Integer, Integer> edges) {
        this.edges = edges;
    }

    public void removeEdge(String u , String v) {
        edges.remove(u, Integer.parseInt(v));
        edges.remove(v, Integer.parseInt(u));
    }

    public void removeVertex(int v) {
        vertexList.remove(v);
    }

    public void addVertex(Integer uv) {
        vertexList.add(uv);
    }

    public void addEdge(Integer v, List<Integer> val) {
        for (Integer i : val) {
            edges.put(v, i);
        }
    }
}
