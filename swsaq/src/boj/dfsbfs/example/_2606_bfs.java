package boj.dfsbfs.example;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _2606_bfs {
		// N : ��ǻ�� ��(������ ��), M : ��ǻ�� ���� ��(������ ��)
		// A : �����, B : ������
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
			// �湮�� ���� üũ
			visited[idx] = 1;
			
			while(!queue.isEmpty()) {
				idx = queue.poll();
				
				// �������� - �����ص� �����帧�� �����ϴ�.
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
