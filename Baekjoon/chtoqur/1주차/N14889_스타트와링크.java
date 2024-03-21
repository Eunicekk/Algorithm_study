import java.util.Scanner;

class Main {
	
	public static int N;
	public static int[][] arr;
	public static int[] teamA;
	public static int[] teamB;
	
	public static int makeTeam(int[][] arr) {
		
		int answer = Integer.MAX_VALUE;
		
		for (int i = 1; i < (1 << N) / 2; i++) {
			if (Integer.bitCount(i) == N / 2) {
				for (int j = 0, idxA = 0, idxB = 0; j < N; j++) {
					if ((i & (1 << j)) > 0) {
						teamA[idxA++] = j;
					} else {
						teamB[idxB++] = j;
					}
				}
			
				int sumA = 0;
				int sumB = 0;
				for (int x = 0; x < (N / 2) - 1; x++) {
					for (int y = 1; y < N / 2; y++) {
						sumA += arr[teamA[x]][teamA[y]] + arr[teamA[y]][teamA[x]];
						sumB += arr[teamB[x]][teamB[y]] + arr[teamB[y]][teamB[x]];
					}
				}
				
				if (Math.abs(sumA - sumB) < answer)
					answer = Math.abs(sumA - sumB);
			}
		}
		
		return answer;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();		// N명
		arr = new int[N][N];
		teamA = new int[N / 2];
		teamB = new int[N / 2];
		
		// 입력
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		System.out.println(makeTeam(arr));
	}
}
