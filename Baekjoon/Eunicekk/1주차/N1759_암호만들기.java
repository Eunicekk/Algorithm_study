import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 암호 만들기
public class N1759_암호만들기 {
	
	static int L;
	static int C;
	static char[] dict;
	static char[] select;
	static StringBuilder sb = new StringBuilder();
	static char[] vowel = {'a', 'e', 'i', 'o', 'u'};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		select = new char[L];
		dict = new char[C];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			dict[i] = st.nextToken().charAt(0);
		}
		
		Arrays.sort(dict);
		
		combination(0, 0);
		System.out.println(sb);
	}
	
	static void combination(int index, int sindex) {
		// 기저 조건
		if (sindex >= L) {
			if (countVowel(select)) {
				for (int i = 0; i < L; i++) {
					sb.append(select[i]);
				}
				sb.append("\n");
			}
			
			return;
		}
		
		if (index >= C) {
			return;
		}
		
		// 재귀 부분
		select[sindex] = dict[index];
		combination(index + 1, sindex + 1);
		combination(index + 1, sindex);
	}
	
	static boolean countVowel(char[] array) {
		int count = 0;
		
		for (int i = 0; i < array.length; i++) {
			for (Character v : vowel) {
				if (array[i] == v) {
					count++;
				}
			}
		}
		
		if (count >= 1 && array.length - count >= 2) {
			return true;
		} else {
			return false;
		}
	}
	
}
