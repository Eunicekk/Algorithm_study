package com.baekjoon.day56;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 퇴사
public class Main_14501 {
	
	static int N;
	static int[] date;
	static int[] profit;
	static int max = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		date = new int[N];
		profit = new int[N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			date[i] = Integer.parseInt(st.nextToken()); // 시간
			profit[i]= Integer.parseInt(st.nextToken()); // 이익
		}
		
		calMax(0, 0);
		System.out.println(max);
	}
	
	static void calMax (int day, int total) {
		// 기저 조건
		if (day >= N) {
			max = Math.max(max, total);
			return;
		}
		
		// 재귀 부분
		if (day + date[day] <= N) {
			calMax(day + date[day], total + profit[day]);
		}
		
		calMax(day + 1, total);
	}
}
