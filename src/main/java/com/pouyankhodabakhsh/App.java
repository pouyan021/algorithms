package com.pouyankhodabakhsh;

import com.pouyankhodabakhsh.algorithm.Graph;
import com.pouyankhodabakhsh.algorithm.Kosaraju;
import com.pouyankhodabakhsh.algorithm.utils.FileUtil;
import com.pouyankhodabakhsh.algorithm.utils.GraphUtils;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        try {
            Graph graph = GraphUtils.createGraph(FileUtil.readFile("SCC.txt"));
            Kosaraju kosaraju = new Kosaraju(graph);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
