package BarnTree;

import java.util.*;
import java.io.*;

public class BarnTree {

    public static int n;
    public static int[] hay;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        hay = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            hay[i] = Integer.parseInt(st.nextToken());
        }

        Graph g = new Graph(n);
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            g.addEdge(a, b);
        }

        int val = avg();
        for (int i = 0; i < n; i++) {
            hay[i] -= val;
            hay[i] *= -1;
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (hay[i] < 0) continue;
            for (int j = i + 1; j < n; j++) {
                if (hay[i] + hay[j] == 0) {
                    ans += g.bfs(j, i, hay);
                }
            }
        }

        System.out.println(ans);
    }

    public static int avg() {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += hay[i];
        }
        return sum / n;
    }
}

class Graph {
    private LinkedList<Integer>[] adj;
    private int v;
    private int[] d;

    public Graph(int vertex) {
        v = vertex;
        adj = new LinkedList[v];
        for (int i = 0; i < vertex; i++)
            adj[i] = new LinkedList<>();
    }

    public void addEdge(int source, int destination) {
        adj[source].addFirst(destination);
        adj[destination].addFirst(source);
    }

    public int bfs(int s, int t, int[] hay) {
        d = new int[v];
        boolean[] visited = new boolean[v];

        Queue<Integer> q = new LinkedList<>();
        q.add(s);

        while(q.size() != 0) {
            s = q.poll();

            if(!visited[s]) {
                visited[s] = true;
            }

            if (s == t) {
                return d[t];
            }

            for (int v : adj[s]) {
                if (!visited[v]) {
                    q.add(v);
                    d[v] = d[s] + 1;
                }
            }
        }
        return -1;
    }
}
