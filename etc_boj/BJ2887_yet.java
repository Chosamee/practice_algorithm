// import java.io.BufferedReader;
// import java.io.InputStreamReader;
// import java.util.ArrayList;
// import java.util.PriorityQueue;
// import java.util.StringTokenizer;

// /** Vertex */
// class Planet {
// int idx;
// int x, y, z;

// public Planet(int idx, int x, int y, int z) {
// this.idx = idx;
// this.x = x;
// this.y = y;
// this.z = z;
// }
// }

// /** Edge */
// class Node implements Comparable<Node> {
// int to;
// int weight;

// public Node(int to, int weight) {
// super();
// this.to = to;
// this.weight = weight;
// }

// @Override
// public int compareTo(Node o) {
// return this.weight - o.weight;
// }
// }

// /** Main Class */
// public class BJ2887_yet {
// static BufferedReader br = new BufferedReader(new
// InputStreamReader(System.in));
// static StringBuilder sb = new StringBuilder();
// static StringTokenizer st;

// static int V;
// static PriorityQueue<Node> que;
// static ArrayList<ArrayList<Node>> nodes;
// static ArrayList<Planet> planets;
// static boolean[] visited;
// static long ret;

// /** initialize */
// public static void initial() throws Exception {
// V = Integer.parseInt(br.readLine());
// ret = 0;
// que = new PriorityQueue<>();
// nodes = new ArrayList<>();
// for (int i = 0; i < V; i++) {
// nodes.add(new ArrayList<>());
// }
// visited = new boolean[V];
// int x, y, z;
// planets = new ArrayList<>();
// for (int i = 0; i < V; i++) {
// st = new StringTokenizer(br.readLine());
// x = Integer.parseInt(st.nextToken());
// y = Integer.parseInt(st.nextToken());
// z = Integer.parseInt(st.nextToken());
// planets.add(new Planet(i, x, y, z));
// }
// }

// // /** add nodes to ArrayList<ArrayList<>> */
// // public static void addNodes() {
// // int dist;
// // for (int i = 0; i < V; i++) {
// // for (int j = i + 1; j < V; j++) {
// // dist = calDist(planets.get(i), planets.get(j));
// // nodes.get(i).add(new Node(j, dist));
// // nodes.get(j).add(new Node(i, dist));
// // }
// // }
// // }

// /** add line... macthing Planet */

// /** cal distance */
// public static int calDist(Planet p1, Planet p2) {
// int dx = Math.abs(p1.x - p2.x);
// int dy = Math.abs(p1.y - p2.y);
// int dz = Math.abs(p1.z - p2.z);
// return Math.min(dx, Math.min(dy, dz));
// }

// /** prim algorithm */
// public static void prim() {

// visited[0] = true;
// for (Node n : nodes.get(0)) {
// que.add(n);
// }

// Node n;
// int to, w;
// int cnt = 0;
// while (cnt != V - 1) {
// n = que.poll();
// to = n.to;
// w = n.weight;
// if (visited[to])
// continue;
// for (Node nn : nodes.get(to)) {
// if (!visited[nn.to])
// que.add(nn);
// }
// visited[to] = true;
// ret += w;
// cnt++;
// }
// }

// /** main */
// public static void main(String[] args) throws Exception {

// initial();
// prim();
// System.out.println(ret);

// }
// }
