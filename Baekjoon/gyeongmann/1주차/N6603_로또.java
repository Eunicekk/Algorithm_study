package N6603_로또;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, R;
	static int[] arr, sel;
	static List<String> lines = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		R = 6;
		sel = new int[R];
		
		String s;
		while (!(s = in.readLine()).equals("0")) {
			lines.add(s);
		}
		
		StringTokenizer st = null;
		for (String line : lines) {
			st = new StringTokenizer(line);
			N = Integer.parseInt(st.nextToken());
			arr = new int[N];
			
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			comb(0, 0);
			sb.append('\n');
		}
		
		System.out.println(sb);
	}

	private static void comb(int idx, int sidx) {
		if (sidx == R) {
			for (int i = 0; i < R; i++) {
				sb.append(sel[i] + " ");
			}
			sb.append('\n');
			return;
		}
		
//		if (idx == N) return;
		sel[sidx] = arr[idx];
		comb(idx + 1, sidx + 1);
		comb(idx + 1, sidx);
	}
}
