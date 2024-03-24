import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	static int dasom, ans;
	static int[] arr = new int[25];
	static int[] sel = new int[7];
	static char[][] map = new char[5][5];
	static int[][] check;
	static boolean[][] vis;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 5; i++) {
			map[i] = in.readLine().toCharArray();
		}

		for (int i = 0; i < 25; i++) {
			arr[i] = i;
		}

		comb(0, 0);
		
		System.out.println(ans);
	}

	private static void comb(int idx, int sidx) {
		if (sidx == 7) {
			check = new int[5][5];
			vis = new boolean[5][5];

			int row = 0, col = 0;
			for (int i = 0; i < 7; i++) {
				int grid = sel[i];
				row = grid / 5;
				col = grid % 5;
				check[row][col] = 1;
			}
			
			dasom = 0;
			if (BFS(row, col) == 7 && dasom >= 4) {
				ans++;
			}
			return;
		}
		
		if (idx == 25) return;
		
		sel[sidx] = arr[idx];
		comb(idx + 1, sidx + 1); // 다음 위치에 다음거 뽑아줘
		comb(idx + 1, sidx);	// 해당 위치 덮어쓰기
		

	}

	private static int BFS(int r, int c) {
		int cnt = 1;
		Queue<Integer[]> q = new LinkedList<>();
		q.add(new Integer[] { r, c });
		vis[r][c] = true;
		if (map[r][c] == 'S')
			dasom++;

		while (!q.isEmpty()) {
			Integer[] pair = q.poll();

			r = pair[0];
			c = pair[1];

			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];

				if (isValid(nr, nc)) {
					q.add(new Integer[] { nr, nc });
					vis[nr][nc] = true;
					cnt++;
					if (map[nr][nc] == 'S')
						dasom++;
				}
			}
		}

		return cnt;
	}

	private static boolean isValid(int nr, int nc) {
		if (nr < 0 || nc < 0 || nr >= 5 || nc >= 5) {
			return false;
		}

		if (vis[nr][nc] || check[nr][nc] == 0) {
			return false;
		}

		return true;
	}

}
