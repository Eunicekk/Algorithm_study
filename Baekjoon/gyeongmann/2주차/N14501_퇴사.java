package N14501_퇴사;

import java.util.Scanner;

public class Main {
	static int N, R, max;
	static int[] arr, sel;
	static int[][] schedule;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		schedule = new int[N][2];
		for (int i = 0; i < N; i++) {
			schedule[i][0] = sc.nextInt(); // term
			schedule[i][1] = sc.nextInt(); // payment
		}
		
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = i;
		}
		
		for (R = 1; R <= N; R++) {
			sel = new int[R];
			comb(0, 0);
		}
		
		System.out.println(max);
	}
	
	private static void comb(int idx, int sidx) {
		if (sidx == R) {
			int sum = calSum(sel);
			if (isValid(sel) && sum > max) {
				max = sum;
			}
			return;
		}
		
		if (idx == N) return;
		
		sel[sidx] = arr[idx];
		comb(idx + 1, sidx + 1);
		comb(idx + 1, sidx);
	}

	private static boolean isValid(int[] sel) {
		for (int i = 0; i < sel.length - 1; i++) {
			int today = sel[i];
			int term = schedule[today][0];
			int next = sel[i + 1];
			
			if (today + term > next) return false;
		}
		
		int lastDay = sel[sel.length - 1];
		int term = schedule[lastDay][0];
		if (lastDay + term > N) return false;
		
		return true;
	}

	private static int calSum(int[] sel) {
		int sum = 0;
		
		for (int i = 0; i < sel.length; i++) {
			sum += schedule[sel[i]][1];
		}
		
		return sum;
	}
}
