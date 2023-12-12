package Moocast;

import java.util.*;
import java.io.*;

public class Moocast {

    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("moocast.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("moocast.out")));

        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int ans = 0;

        int[] x = new int[n];
        int[] y = new int[n];
        int[] p = new int[n];
        Graph g = new Graph(n);

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(f.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int xDist = x[i] - x[j];
                int yDist = y[i] - y[j];
                if (Math.sqrt(xDist * xDist + yDist * yDist) <= p[i]) {
                    g.addEdge(i, j);
                }
                if (Math.sqrt(xDist * xDist + yDist * yDist) <= p[j]) {
                    g.addEdge(j, i);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, g.numNodes(i));
        }

        out.println(ans);
        out.close();
    }
}

class Graph {

        private int n;
        private LinkedList<Integer>[] adjList;

        Graph(int n) {
            this.n = n;
            adjList = new LinkedList[n];
            for (int i = 0; i < n; i++)
                adjList[i] = new LinkedList<>();
        }

    public void addEdge(int source, int destination) {
        adjList[source].addFirst(destination);
    }

    public void DFS(int v, boolean[] visited) {
        visited[v] = true;
        for (int i : adjList[v]) {
            if (!visited[i]) {
                DFS(i, visited);
            }
        }
    }

    public int numNodes(int v) {
        boolean[] visited = new boolean[n];
        DFS(v, visited);
        int r = 0;
        for (boolean i : visited) {
            if (i) {
                r++;
            }
        }
        return r;
    }
}
