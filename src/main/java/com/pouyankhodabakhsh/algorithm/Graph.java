package com.pouyankhodabakhsh.algorithm;

import java.io.Serializable;
import java.util.LinkedList;

public class Graph implements Serializable {
    private int vertex;
    public LinkedList[] edge;

    public Graph(int vertex) {
        this.vertex = vertex;
        edge = new LinkedList[vertex];
        for (int i = 1; i < vertex; i++) {
          edge[i] = new LinkedList<>();
        }
    }

    public void addEdge(int source, int destination) {
        edge[source].add(destination);
    }

    public int getVertex() {
        return vertex;
    }

    public void setVertex(int vertex) {
        this.vertex = vertex;
    }
}
