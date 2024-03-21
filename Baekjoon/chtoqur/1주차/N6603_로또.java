import java.util.Scanner;

class Main {
	
	public static StringBuilder sb = new StringBuilder();
	
	public static int K;				// k개의 수 중에서 6개 선택
	public static int[] arr;			// 수의 집합
	public static boolean[] visited;	// 숫자 사용 확인 배열
	
	public static void selectNum(int idx, int count) {
		
		// 7번째 수를 뽑는 경우까지 내려온 경우 중단 및 출력
		if (count == 6) {
			for (int i = 0; i < K; i++) {
				if (visited[i]) {
					sb.append(arr[i] + " ");
				}
			}
			sb.append("\n");
		}
		
		// 전체 수의 개수(k)만큼 반복
		for (int i = idx; i < K; i++) {
			if (!visited[i]) {
				visited[i] = true;
				selectNum(i + 1, count + 1);
				visited[i] = false;
			}
		}
		
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		while (true) {
			
			K = sc.nextInt();		
			if (K == 0)					// 0이 입력된 경우 중단
				break;
			
			arr = new int[K];
			visited = new boolean[K];
			
			for (int i = 0; i < K; i++) {
				arr[i] = sc.nextInt();
			}
			
			selectNum(0, 0);
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
