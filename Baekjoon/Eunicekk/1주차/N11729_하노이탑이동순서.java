import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 하노이 탑 이동 순서
public class N11729_하노이탑이동순서 {
	
	static StringBuilder sb;
	static int count = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		sb = new StringBuilder();
		hanoi(N, 1, 2, 3);
		
		System.out.println(count);
		System.out.println(sb);
	}
	
	static void hanoi(int num, int start, int mid, int fin) {
		// 기저 조건
		if (num == 1) {
			sb.append(start + " " + fin + "\n");
			count++;
			return;
		}
		
		// 재귀 부분
		count++;
		hanoi(num - 1, start, fin, mid);
		sb.append(start + " " + fin + "\n");
		hanoi(num - 1, mid, start, fin);
	}
	
}
