package boj.dfsbfs.example;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _2606_bfs {
		// N : 컴퓨터 수(정점의 수), M : 컴퓨터 쌍의 수(간선의 수)
		// A : 출발지, B : 목적지
		static int N, M, A, B;
		static int [][] MAT = new int[101][101];
		static int [] visited = new int[101];
		static Queue<Integer> queue = new LinkedList<Integer>();
		static int cnt;

		
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			N = sc.nextInt();
			M = sc.nextInt();
			cnt = 0;
			for (int i = 1; i <= M; i++) {
				A = sc.nextInt();
				B = sc.nextInt();
				MAT[A][B] = MAT[B][A] =1;
			}
			
			bfs(1);
			System.out.println(cnt);
			
		}
	    
		public static void bfs(int idx) {
			queue.add(idx);
			// 방문한 정점 체크
			visited[idx] = 1;
			
			while(!queue.isEmpty()) {
				idx = queue.poll();
				
				// 종료조건 - 생략해도 실행흐름은 동일하다.
				// if(idx == N+1) break;
				
				for (int i = 1; i <= N; i++) {
					if(MAT[idx][i] == 1 && visited[i] == 0) {
						queue.offer(i);
						visited[i] = 1;
	                    cnt++;
					}
				}
			}
		}
}
