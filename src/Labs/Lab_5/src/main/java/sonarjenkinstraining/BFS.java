package sonarjenkinstraining;

import java.util.*;

public class BFS {
    public static List<Integer> bfsShortestPath(List<Integer>[] graph, int src, int dst) {
        int n = graph.length;
        boolean[] vis = new boolean[n];
        int[] prev = new int[n];
        Arrays.fill(prev, -1);
        Queue<Integer> q = new ArrayDeque<>();
        q.add(src); vis[src] = true;
        while (!q.isEmpty()) {
            int u = q.poll();
            if (u == dst) break;
            for (int v : graph[u]) if (!vis[v]) { vis[v] = true; prev[v] = u; q.add(v); }
        }
        if (prev[dst] == -1 && src != dst) return Collections.emptyList();
        List<Integer> path = new ArrayList<>();
        for (int at = dst; at != -1; at = prev[at]) path.add(at);
        Collections.reverse(path);
        return path;
    }
    public static void main(String[] args) {
        List<Integer>[] g = new List[6];
        for (int i = 0; i < g.length; i++) g[i] = new ArrayList<>();
        g[0].add(1); g[0].add(2);
        g[1].add(3); g[2].add(3);
        g[3].add(4); g[4].add(5);
        System.out.println(bfsShortestPath(g, 0, 5));
    }
}
