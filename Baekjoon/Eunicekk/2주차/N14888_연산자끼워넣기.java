package com.baekjoon.day56;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 연산자 끼워넣기
public class Main_14888 {
	
	static int N;
	static int[] numbers;
	static List<Character> operator;
	static boolean[] visited;
	static char[] select;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		numbers = new int[N];
		operator = new ArrayList<Character>();
		visited = new boolean[N-1];
		select = new char[N-1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		int[] temp = new int[4];
		for (int i = 0; i < 4; i++) {
			temp[i] = Integer.parseInt(st.nextToken());
			for (int j = 0; j < temp[i]; j++) {
				if (i == 0) {
					operator.add('+');
				} else if (i == 1) {
					operator.add('-');
				} else if (i == 2) {
					operator.add('*');
				} else if (i == 3) {
					operator.add('/');
				}
			}
		}
		permutation(0);
		
		System.out.println(max);
		System.out.println(min);
	}
	
	static void permutation(int idx) {
		// 기저 조건
		if (idx >= N-1) {
			calculate(numbers, select);
			return;
		}
		
		// 재귀 부분
		for (int i = 0; i < N-1; i++) {
			if (!visited[i]) {
				visited[i] = true;
				select[idx] = operator.get(i);
				permutation(idx + 1);
				visited[i] = false;
			}
		}
	}
	
	static void calculate(int[] numbers, char[] select) {
		int result = 0;
		char[] formula = new char[2 * N - 1];
		
		for (int i = 0, j = 0; i < 2 * N - 1 && j < N-1; i+=2, j++) {
			formula[i] = (char) (numbers[j] + 48);
			formula[i+1] = select[j];
		}
		formula[formula.length - 1] = (char) (numbers[N-1] + 48);
		
		for (int i = 0; i < formula.length; i++) {
			if (i == 1) {
				if (formula[i] == '+') {
					result += (formula[i-1] - '0') + (formula[i+1] - '0');
				} else if (formula[i] == '-') {
					result += (formula[i-1] - '0') - (formula[i+1] - '0');
				} else if (formula[i] == '*') {
					result += (formula[i-1] - '0') * (formula[i+1] - '0');
				} else if (formula[i] == '/') {
					result += (formula[i-1] - '0') / (formula[i+1] - '0');
				}
			} else {
				if (formula[i] == '+') {
					result = result + (formula[i+1] - '0');
				} else if (formula[i] == '-') {
					result = result - (formula[i+1] - '0');
				} else if (formula[i] == '*') {
					result = result * (formula[i+1] - '0');
				} else if (formula[i] == '/') {
					if (result > 0) {
						result = result / (formula[i+1] - '0');
					} else {
						result = (int) ((Math.abs(result) / (formula[i+1] - '0')) * -1);
					}
				}
			}
		}
		
		max = Math.max(max, result);
		min = Math.min(min, result);
	}
	
}
