package boj.pre.exam._14500;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class _14500 {
	public static void main(String[] args) throws FileNotFoundException {
		// N x M 열의 행렬에 입력
		int N, M;
		File file = new File("C:\\SAQ\\Java\\Test01\\_14500.txt");
		Scanner sc = new Scanner(file);
//		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		System.out.println("testcase: " + testcase);
		for (int T = 0; T < testcase; T++) {
		
			N = sc.nextInt();
			M = sc.nextInt();
			int Max = 0;
			System.out.println("N: " + N);
			System.out.println("M: " + M);
			int [][] a = new int[N][M];
			
			for (int i = 0; i < N ; i++) {
				for (int j = 0; j < M; j++) {
					a[i][j] = sc.nextInt();
				}
			}
			
			// 브루트포스 : 전체순회
			for (int i = 0; i < N ; i++) {
				for (int j = 0; j < M; j++) {
					// ㅁㅁㅁㅁ
					if( j+3 < M) {
						int sum = a[i][j] + a[i][j+1] + a[i][j+2] + a[i][j+3];
						if( Max < sum ) Max = sum;
					}
					
					// ㅁ
					// ㅁ
					// ㅁ
					// ㅁ
					if( i+3 < N) {
						int sum = a[i][j] + a[i+1][j] + a[i+2][j] + a[i+3][j];
						if( Max < sum ) Max = sum;
					}
					
					//  ㅁㅁㅁ
					//	     ㅁ
					if( i+1 < N  && j+2 < M ) {
						int sum = a[i][j] + a[i][j+1] + a[i][j+2] + a[i+1][j+2];
						if( Max < sum ) Max = sum;
					}
					
					//   ㅁ   
					//   ㅁ
					//  ㅁㅁ
					if( j-1 >= 0 && i+2 < N) {
						int sum = a[i][j] + a[i+1][j] + a[i+2][j] + a[i+2][j-1];
						if( Max < sum ) Max = sum;
					}
					
					// ㅁ
					// ㅁㅁㅁ
					if( i+1 < N && j+2 < M  ) {
						int sum = a[i][j] + a[i+1][j] + a[i+1][j+1] + a[i+1][j+2];
						if( Max < sum ) Max = sum;
					}
					
					//  ㅁㅁ
					//  ㅁ
					//  ㅁ
					if( i+2 < N && j+1 < M  ) {
						int sum = a[i][j] + a[i+1][j] + a[i+2][j] + a[i][j+1];
						if( Max < sum ) Max = sum;
					}
					
					
					//      ㅁ
					//	   ㅁㅁㅁ
					if( i-1 >= 0  && j+2 < M) {
						int sum = a[i][j] + a[i][j+1] + a[i][j+2] + a[i-1][j+2];
						if( Max < sum ) Max = sum;
					}
					
					//   ㅁ   
					//   ㅁ
					//   ㅁㅁ
					if( i+2 < N && j+1 < M ) {
						int sum = a[i][j] + a[i+1][j] + a[i+2][j] + a[i+2][j+1];
						if( Max < sum ) Max = sum;
					}
					
					// ㅁㅁㅁ
					// ㅁ
					if( i+1 < N && j+2 < M  ) {
						int sum = a[i][j] + a[i+1][j] + a[i+1][j+1] + a[i+1][j+2];
						if( Max < sum ) Max = sum;
					}
					
					//  ㅁㅁ
					//    ㅁ
					//    ㅁ
					if( i+2 < N && j+1 < M  ) {
						int sum = a[i][j] + a[i][j+1] + a[i+1][j+1] + a[i+2][j+1];
						if( Max < sum ) Max = sum;
					}
					
					
					
					
					// copy			
					//   ㅁ
					//  ㅁㅁ
					//  ㅁ
					if(i+2 < N && j-1 >= 0) {
						int sum = a[i][j] + a[i+1][j] + a[i+1][j-1] + a[i+2][j-1];
						if( Max < sum ) Max = sum;
					}
					if(i+2 < N && j+1 < M) {
						int sum = a[i][j] + a[i+1][j] + a[i+1][j+1] + a[i+2][j+1];
						if( Max < sum ) Max = sum;
					}
					if(i+1 < N && j+2 < M) {
						int sum = a[i][j] + a[i][j+1] + a[i+1][j+1] + a[i+1][j+2];
						if( Max < sum ) Max = sum;
					}
					if(i-1 >= 0 && j+2 < M) {
						int sum = a[i][j] + a[i][j+1] + a[i-1][j+1] + a[i-1][j+2];
						if( Max < sum ) Max = sum;
					}
					
					
					if(i+2 < N) {
						int sum = a[i][j] + a[i+1][j] + a[i+2][j];
						if(j-1 >= 0) {
							int sum2 = sum + a[i+1][j-1];
							if( Max < sum2 ) Max = sum2;
						}
						if(j+1 < M) {
							int sum2 = sum + a[i+1][j+1];
							if( Max < sum2 ) Max = sum2;
						}
					}
					if(j+2 < M) {
						int sum = a[i][j] + a[i][j+1] + a[i][j+2];
						if(i+1 < N) {
							int sum2 = sum + a[i+1][j+1];
							if( Max < sum2 ) Max = sum2;
						}
						if(i-1 >= 0) {
							int sum2 = sum + a[i-1][j+1];
							if( Max < sum2 ) Max = sum2;
						}
					}
					
					//  ㅁㅁ
					//  ㅁㅁ
					if(i+1 < N && j+1 < M) {
						int sum = a[i][j] + a[i][j+1] + a[i+1][j] + a[i+1][j+1];
						if(sum > Max) Max = sum;
					}
					
	
				}
			}
			
			
			for (int i = 0; i < N ; i++) {
				for (int j = 0; j < M; j++) {
					System.out.printf("%6d", a[i][j]);
				}
				System.out.println();
			}
			
			System.out.println(Max);
		
		}
		
		
	}
}
