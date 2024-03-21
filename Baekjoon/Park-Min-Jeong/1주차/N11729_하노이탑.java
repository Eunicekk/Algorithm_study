import java.io.*;

public class N11729_하노이탑 {
	static int num = 0;

	static StringBuilder sb = new StringBuilder();

	static void hanoi(int n, int start, int end, int sub) throws IOException {

		if (n == 1) {
			num++;
			sb.append(String.format("%d %d\n", start, end));
			return;
		}

		else {
			hanoi(n - 1, start, sub, end);
			num++;
			sb.append(String.format("%d %d\n", start, end));
			hanoi(n - 1, sub, end, start);
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		hanoi(n, 1, 3, 2);

		bw.write(String.format("%d\n", num));
		bw.write(String.valueOf(sb.toString()));
		bw.flush();

		br.close();
		bw.close();

	}
}
