import java.util.Arrays;
import java.util.Scanner;

class Main {
	
	public static int L;				// L개를 뽑아서 암호를 구성
	public static int C;				// C개의 문자 중에서 선택
	public static char[] arr;			// 문자 배열
	public static boolean[] visited;	// 알파벳 사용 확인
	
	public static StringBuilder sb = new StringBuilder();
	
	/**
	 * 
	 * @param idx
	 * @param count : 현재 사용된 알파벳의 개수
	 */
	public static void makeCode(int idx, int count) {
		
		// 알파벳 사용 개수가 조건으로 주어진 개수 L과 동일해진다면
		if (count >= L) {
			
			String str = "";	// 임시로 단어를 구성할 변수
			int vowel = 0;		// 모음 개수 : 최소 1개
			int consonant = 0;	// 자음 개수 : 최소 2개
			
			// 문자 배열 길이만큼 순회
			for (int i = 0; i < C; i++) {
				// i번째 문자가 사용되었다면 
				if (visited[i]) {
					// 해당 문자가 모음인지 자음인지 확인
					if (arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i' ||
						arr[i] == 'o' || arr[i] == 'u') {
						vowel++;
					} else {
						consonant++;
					}
					// 임시 변수 str에 알파벳 추가
					str += arr[i];
				}
			}
			
			// 모음과 자음 개수 조건을 만족할 경우 스트링빌더에 추가
			if (vowel >= 1 && consonant >= 2) {
				sb.append(str + "\n");
			}
			return;
		}
		
		// 단어 길이만큼 반복하면서 순회
		for (int i = idx; i < C; i++) {
			// 사용하지 않은 알파벳이라면
			if (!visited[i]) {
				// 사용처리 후
				visited[i] = true;
				// 다음 알파벳으로 이동
				makeCode(i + 1, count + 1);
				visited[i] = false;
			}
		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		L = sc.nextInt();			
		C = sc.nextInt();			
		
		arr = new char[C];			
		visited = new boolean[C];	
		
		// 문자 입력
		for (int i = 0; i < C; i++) {
			arr[i] = sc.next().charAt(0);
		}
		
		Arrays.sort(arr);			// 알파벳 순으로 정렬
		makeCode(0, 0);
		System.out.println(sb.toString());	// 출력
	}
}
