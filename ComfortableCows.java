package ComfortableCows;

import java.util.*;
import java.io.*;

public class ComfortableCows {

    static int n;
    static ArrayList<Pair> coords;
    static boolean[] visited;
    static Queue<Pair> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        coords = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            coords.add(new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        for (int i = 0; i < n; i++) {
            visited = new boolean[n];
            System.out.println(bfs(coords.get(0), i));
        }
    }

    static boolean ok(Pair p, int res) {
        for (int i = 0; i <= res; i++) {
            if (p.isEqual(coords.get(i))) {
                return true;
            }
        }
        return false;
    }

    static void vis(Pair p) {
        int ind = 0;
        for (int i = 0; i < coords.size(); i++) {
            if (p.isEqual(coords.get(i))) {
                ind = i;
                break;
            }
        }

        if (!visited[ind]) {
            q.add(p);
            visited[ind] = true;
        }
    }

    static int bfs(Pair p, int res) {
        int[] dRow = {-1, 0, 1, 0};
        int[] dCol = {0, 1, 0, -1};

        int ans = 0;

        q = new LinkedList<>();
        q.add(p);
        visited[0] = true;

        while (!q.isEmpty()) {
            int adj = 0;

            Pair v = q.poll();

            Pair[] add = new Pair[4];
            for (int i = 0; i < 4; i++) {
                int adj_x = v.getX() + dRow[i];
                int adj_y = v.getY() + dCol[i];

                add[i] = new Pair(adj_x, adj_y);

                if (ok(add[i], res)) {
                    adj++;
                    vis(add[i]);
                }
            }

            if (adj == 3) {
                ans++;
                for (Pair q : add) {
                    if (!ok(q, res)) {
                        coords.add(q);
                        break;
                    }
                }
            }
        }

        return ans;
    }
}

class Pair {
    private int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isEqual(Pair p) {
        return getX() == p.getX() && getY() == p.getY();
    }

    public void print() {
        System.out.println("(" + getX() + ", " + getY() + ")");
    }
}
