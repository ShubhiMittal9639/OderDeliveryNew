package com.example.orderdelivery;

import java.util.*;

public class Graph {

    LinkedList<Edge>[] adjList;
    Integer noOfVertices;

    class Edge {
        public Integer startLocation;
        public Integer endLocation;
        public double distance;

        public Edge(Integer startLocation, Integer endLocation, double distance) {
            this.startLocation = startLocation;
            this.endLocation = endLocation;
            this.distance = distance;
        }

    }

    public Graph(Integer noOfVertices) {
        this.noOfVertices = noOfVertices;
        adjList = new LinkedList[noOfVertices];
        for (int i = 0; i < noOfVertices; i++)
            adjList[i] = new LinkedList<>();
    }

    public void addEdge(Integer startLocation, Integer endLocation, double distance) {
        adjList[startLocation].add(new Edge(startLocation, endLocation, distance));
        adjList[endLocation].add(new Edge(endLocation, startLocation, distance));
    }
}
