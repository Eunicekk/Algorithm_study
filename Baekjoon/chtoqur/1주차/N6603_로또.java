import java.util.Scanner;

class Main {
	
	public static StringBuilder sb = new StringBuilder();
	public static int[] arr;
	public static boolean[] visited;
	
	// 백트래킹
	public static void selectNum(int idx, int depth) {
		
		// 7번째 수를 뽑는 경우까지 내려온 경우 중단 및 출력
		if (depth == 6) {
			for (int i = 0; i < visited.length; i++) {
				if (visited[i]) {
					sb.append(arr[i] + " ");
				}
			}
			sb.append("\n");
		}
		
		// 전체 수의 개수(k)만큼 반복
		for (int i = idx; i < arr.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				selectNum(i, depth + 1);
				visited[i] = false;
			}
		}
		
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		while (true) {
			
			int k = sc.nextInt();		// k개의 수 중에서 6개 선택
			if (k == 0)
				break;
			
			arr = new int[k];
			visited = new boolean[k];
			
			for (int i = 0; i < k; i++) {
				arr[i] = sc.nextInt();
			}
			
			selectNum(0, 0);
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
