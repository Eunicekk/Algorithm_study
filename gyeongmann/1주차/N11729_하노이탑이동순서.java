package N11729_하노이탑이동순서;

import java.util.Scanner;

public class Main {
	static int N, ans;
	static StringBuilder sb;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sb = new StringBuilder();
		
		N = sc.nextInt();
		
		move(N, 1, 3);
		System.out.println(ans);
		System.out.println(sb);
	}
	
	static void move(int N, int from, int to) {
		if (N == 1) {
			sb.append(from + " " + to).append('\n');
			ans++;
			return;
		}
		
		int another = 6 - from - to;
		move(N - 1, from, another);
		move(1, from, to);
		move(N - 1, another, to);
	}
}
