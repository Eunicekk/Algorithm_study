package com.baekjoon.day45;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 로또
public class Main_6603 {
	
	static int K;
	static int[] selection;
	static int[] lotto;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			K = Integer.parseInt(st.nextToken());
			
			if (K == 0) {
				break;
			}
			
			selection = new int[6];
			lotto = new int[K];
			sb = new StringBuilder();
			
			for (int i = 0; i < K; i++) {
				lotto[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(lotto);
			select(0, 0);
			
			System.out.println(sb);
		}
	}
	
	static void select(int index, int sindex) {
		// 기저 조건
		if (sindex == 6) {
			for (int i = 0; i < 5; i++) {
				sb.append(selection[i] + " ");
			}
			sb.append(selection[5] + "\n");
			return;
		}
		
		if (index == K) {
			return;
		}
		
		// 재귀 부분
		selection[sindex] = lotto[index];
		select(index + 1, sindex + 1);
		select(index + 1, sindex);
	}
	
}
