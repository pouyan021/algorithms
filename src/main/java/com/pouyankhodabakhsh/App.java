package com.pouyankhodabakhsh;

import com.pouyankhodabakhsh.algorithm.Kosaraju;
import com.pouyankhodabakhsh.algorithm.utils.FileUtil;
import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DirectedAcyclicGraph;
import org.jgrapht.graph.SimpleDirectedGraph;

import java.io.IOException;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        try {
            List<String> lines = FileUtil.readFile("SCC.txt");
            Graph<Integer, DefaultEdge> graph = new DefaultDirectedGraph<>(DefaultEdge.class);
            for (String line : lines) {
                String[] columns = line.split(" ");
                int v = Integer.parseInt(columns[0]);
                int u = Integer.parseInt(columns[1]);
                graph.addVertex(v);
                graph.addVertex(u);
                graph.addEdge(v, u);
            }
            Kosaraju kosaraju = new Kosaraju(graph);
            System.out.println(kosaraju.computeSCC().toString());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
