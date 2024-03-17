import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N14889_스타트와링크 {
	
	static int N;
	static int[][] ability; // 능력치를 담는 배열
	static boolean[] visit; // 팀 나누는 배열
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		ability = new int[N][N];
		visit = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < N; j++) {
				ability[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		combination(0, 0);
		System.out.println(min);
	}
	
	// 조합 구하는 함수
	static void combination(int idx, int count) {
		// 기저 조건
		if (count == N / 2) {
			diff();
			return;
		}
		
		// 재귀 조건
		for (int i = idx; i < N; i++) {
			if (!visit[i]) {
				visit[i] = true;
				combination(i + 1, count + 1);
				visit[i] = false;
			}
		}
	}
	
	// 능력치 차이 구하는 함수
	static void diff() {
		int start = 0;
		int link = 0;
		
		for (int i = 0; i < N-1; i++) {
			for (int j = i + 1; j < N; j++) {
				if (visit[i] == true && visit[j] == true) {
					start += ability[i][j];
					start += ability[j][i];
				} else if (visit[i] == false && visit[j] == false) {
					link += ability[i][j];
					link += ability[j][i];
				}
			}
		}
		
		int diff = Math.abs(start - link);
		min = Math.min(min, diff);
	}
}
