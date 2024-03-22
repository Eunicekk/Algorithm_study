import java.util.*;

public class N6603_로또 {
	static String makeReverseString(String str) {
		String result = "";
		
		for (int i = str.length() - 1; i >= 0; i--) {
			result += str.charAt(i);
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int k = -1;
		
		while (true) {			
			k = sc.nextInt();
			if (k == 0) {
				break;
			}
			
			int[] arr = new int[k];
			List<String> bitMask = new ArrayList<>();
			
			for (int i = 0; i < k; i++) {
				arr[i] = sc.nextInt();
			}
			
			for (int i = (1 << k); i >= 1; i--) {
				if (Integer.bitCount(i) == 6) {
					String bit = String.format("%6s", Integer.toBinaryString(i)).replace(' ', '0');
					String bitReverse = makeReverseString(bit);
					bitMask.add(bitReverse);
				}				
			}
			
			Collections.sort(bitMask);
						
			for (String reverseBit: bitMask) {
				String bit = makeReverseString(reverseBit);
				String temp = "";
				
				for (int j = 0; j < k; j++) {
					if ((Integer.parseInt(bit, 2) & (1 << j)) > 0) {
						temp += String.format("%d ", arr[j]);
					}
				}
				
				System.out.println(bit);
				System.out.println(temp);
				System.out.println(">>>");
			}
			
			System.out.println(); // 빈 줄 출력
		}
		
		sc.close();
	}
}
