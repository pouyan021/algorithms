package com.pouyankhodabakhsh;

import com.pouyankhodabakhsh.algorithm.ContractionMinCut;
import com.pouyankhodabakhsh.algorithm.Graph;
import org.apache.commons.lang.SerializationUtils;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

/**
 * Hello world!
 *
 */
public class App 
{
    static Graph graph;

    static {
        try {
            graph = ContractionMinCut.createGraph();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main( String[] args )
    {

        ContractionMinCut contractionMinCut = null;
        try {
            contractionMinCut = new ContractionMinCut();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        for (int i = 0; i < 20000; i++) {
            contractionMinCut.contract(graph);
        }
        System.out.println(contractionMinCut.retrieveCount());
    }
}
