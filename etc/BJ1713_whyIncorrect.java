import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class BJ1713_whyIncorrect {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    // 사진틀, 추천 횟수
    static int N, cnt;
    static int[] students;
    static int[] choo;
    static boolean[] isThere;
    static int[] wb = new int[2];
    // [학생 번호, 언제 들어오는지]
    static PriorityQueue<int[]> heap = new PriorityQueue<>((s1, s2) -> {
        if (students[s1[0]] == students[s2[0]])
            return Integer.compare(s1[1], s2[1]);
        return Integer.compare(students[s1[0]], students[s2[0]]);
    });

    /** initialize */
    public static void initial() throws Exception {
        N = Integer.parseInt(br.readLine());
        cnt = Integer.parseInt(br.readLine());

        // 추천 순서
        choo = new int[cnt];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < cnt; i++) {
            choo[i] = Integer.parseInt(st.nextToken());
        }

        isThere = new boolean[101];
        students = new int[101];
    }

    /** search */
    public static void search() {
        int s, del;
        for (int i = 0; i < cnt; i++) {
            s = choo[i];
            students[s]++;
            heap.add(new int[] { 0, 0 });
            heap.poll();
            if (!isThere[s]) {
                if (heap.size() == N) {
                    del = heap.poll()[0];
                    isThere[del] = false;
                    students[del] = 0;
                }
                heap.add(new int[] { s, i });
                isThere[s] = true;
            }
        }

        PriorityQueue<int[]> heapF = new PriorityQueue<>((s1, s2) -> {
            return s1[0] - s2[0];
        });
        heapF.addAll(heap);
        while (!heapF.isEmpty()) {
            sb.append(heapF.poll()[0]).append(' ');
        }
    }

    public static void main(String[] args) throws Exception {
        initial();
        search();
        System.out.println(sb);
    }
}