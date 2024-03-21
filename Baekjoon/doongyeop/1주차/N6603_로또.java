package solved;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main6603 {

	static int k, arr[];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
	
		while (true) {
			// 줄 첫번째 K, 0이면 종료
			k = sc.nextInt();
			if (k == 0)
				break;
			// K개 중 6개 고를 수 담을 배열
			arr = new int[k];
			for (int i = 0; i < k; i++) {
				arr[i] = sc.nextInt();
			}
			// 답 담을 리스트
			List<Integer> lottery = new ArrayList<>();
			combination(lottery, 0);
			sb.append("\n");
		}

		System.out.print(sb.toString());
		sc.close();

	}

	static void combination(List<Integer> lottery, int lastIdx) {
		if (lottery.size() == 6) {
			for (int l : lottery) {
				sb.append(l + " ");
			}
			sb.append("\n");
			return;
		}

		for (int i = lastIdx; i < k; i++) {
			lottery.add(arr[i]);
			combination(lottery, i + 1);
			lottery.remove(lottery.size() - 1);
		}
	}
}
