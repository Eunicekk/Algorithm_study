package N14889_스타트와링크;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, R, min;
	static int[] arr;
	static boolean[] select;
	static int[][] matrix;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		R = N / 2;
		min = Integer.MAX_VALUE;
		
		arr = new int[N];
		matrix = new int[N][N];
		for (int i = 0; i < N; i++) { // row
			arr[i] = i;
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) { // col
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		select = new boolean[N];
		select[0] = true;
		comb(1, 1);
		System.out.println(min);
	}

	private static void comb(int idx, int sidx) {
		if (sidx == R) {
			int ans = calculate(select);
			if (ans < min) min = ans;
			return;
		}
		
		if (idx == N) return;
		
		select[arr[idx]] = true;
		comb(idx + 1, sidx + 1);
		select[arr[idx]] = false;
		comb(idx + 1, sidx);
	}

	private static int calculate(boolean[] select) {
		int start = 0, link = 0;
		
		for (int r = 0; r < N; r++) { // row
			for (int c = 0; c < N; c++) { // col
				if (select[r] && select[c]) start += matrix[r][c];
				else if (!select[r] && !select[c]) link += matrix[r][c];
			}
		}
		
		return Math.abs(start - link);
	}
}
