package boj.pre.exam._14889;

import java.lang.Thread.State;
import java.util.Scanner;

public class _14889_first {
	// MAT, visited, N, answer
	
	// 0. �Է�
	// 1. dfs()
	//   �� 2. ��������()     -> 4.�ּڰ�
	// 	       �� 3. �������ϱ�()     
	 	
	static int[][] MAT;
	static boolean[] visited;
	static int N;
	static int Answer = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		MAT = new int[N][N];
		visited = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				MAT[i][j] = sc.nextInt();
			}
		}
		
		dfs(-1, 0);
		System.out.println(Answer);
	}
	
	public static void dfs(int idx, int depth) {
		
		// depth ��(N/2)�̸�, �������� 
		if( N / 2   == depth) {
			divideTeam();
		} else {
			for (int i = idx + 1; i < N ; i++) {
				if( !visited[i] ) {
					visited[i] = true;
					dfs( i, depth + 1 );
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			System.out.println("visited[" + i + "] : " + visited[i] );
		}
		System.out.println("Answer: " + Answer);
		System.out.println();
		if(idx != -1) {
			visited[idx] = false;
		}
	}
	
	public static void divideTeam() {
		// a[] : ��ŸƮ ���� ������     (1)(2)(3)
		// b[] : ��ũ ���� ������        (4)(5)(6)
		int a[] = new int[N/2];
		int b[] = new int[N/2];
		
		int x = 0, y = 0;
		// ���� ��ȣ : i
		for (int i = 0; i < N; i++) {
			if( visited[i] ) {
				// ��ŸƮ ���� ��
				a[x++] = i;
			} else {
				// ��ũ ���� ��
				b[y++] = i;
			}
		}
		
		// �ɷ�ġ ���ϱ�
		int startSum = getSum(a) ;
		int linkSum = getSum(b) ;
		int diff = Math.abs(startSum - linkSum);
		
		System.out.println("startSum : " + startSum);
		System.out.println("linkSum : " + linkSum);
		
		if(Answer > diff ) 
			Answer = diff;
	}

	// �ɷ�ġ ���ϱ�
	public static int getSum(int[] arr) {
		int sum = 0;
		
		for (int i = 0; i < N/2; i++) {
			for (int j = i + 1; j < N/2; j++) {
				// S(i,j) �� S(j,i) �� ���Ѵ�.
				sum += MAT[arr[i]][arr[j]];
				sum += MAT[arr[j]][arr[i]];
				System.out.println("MAT[" + arr[i] + "][" + arr[j] + "]");
				System.out.println("MAT[" + arr[j] + "][" + arr[i] + "]");
			}
		}
		
		return sum;
	}
}



























