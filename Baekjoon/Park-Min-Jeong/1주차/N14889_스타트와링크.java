import java.util.*;

public class N14889_스타트와링크 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int answer = Integer.MAX_VALUE;

		int[][] arr = new int[n][n];

		for (int y = 0; y < n; y++) {
			for (int x = 0; x < n; x++) {
				arr[y][x] = sc.nextInt();
			}
		}

		for (int i = 0; i < (1 << n); i++) {
			if (Integer.bitCount(i) == (n / 2)) {

				int[] startArr = new int[n / 2];
				int startIndex = 0;
				int[] endArr = new int[n / 2];
				int endIndex = 0;

				for (int j = 0; j < n; j++) {
					if ((i & (1 << j)) > 0) {
						startArr[startIndex++] = j;
					} else {
						endArr[endIndex++] = j;
					}
				}

				int start = 0;
				int end = 0;

				for (int a = 0; a < n / 2; a++) {
					for (int b = a; b < n / 2; b++) {
						start += arr[startArr[a]][startArr[b]];
						start += arr[startArr[b]][startArr[a]];
						end += arr[endArr[a]][endArr[b]];
						end += arr[endArr[b]][endArr[a]];
					}
				}

				int temp = Math.abs(start - end);

				if ((temp) < answer) {
					answer = temp;
				}
			}
		}

		System.out.println(answer);

		sc.close();
		
	}
}
