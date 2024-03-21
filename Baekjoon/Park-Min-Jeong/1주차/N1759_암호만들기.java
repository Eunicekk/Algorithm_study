import java.io.*;
import java.util.*;


public class N1759_암호만들기 {
	static List<String> vowel = Arrays.asList("a", "e", "i", "o", "u");

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] lc = br.readLine().split(" ");

		int l = Integer.parseInt(lc[0]);
		int c = Integer.parseInt(lc[1]);

		String[] characters = br.readLine().split(" ");
		Arrays.sort(characters);

		List<String> secrets = new ArrayList<>();

		for (int i = 1; i < (1 << c); i++) {
			if (Integer.bitCount(i) == l) {

				String secret = "";
				int vowelCnt = 0;

				for (int j = 0; j < c; j++) {
					if ((i & (1 << j)) > 0) {
						String temp = characters[j];
						secret += temp;

						if (vowel.contains(temp)) {
							vowelCnt++;
						}
					}
				}

				if ((vowelCnt >= 1) && (l - vowelCnt >= 2)) {
					// bw.write(String.format("%s\n", secret));
					secrets.add(secret);
				}
			}
		}

		secrets.sort(String.CASE_INSENSITIVE_ORDER);

		for (String secret : secrets) {
			bw.write(String.format("%s\n", secret));
		}

		bw.flush();

		br.close();
		bw.close();
	}
}
