package boj.pre.exam._14889;

import java.util.Scanner;

public class _14889_second {
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
		MAT = new int[N+1][N+1];
		visited = new boolean[N+1];
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				MAT[i][j] = sc.nextInt();
			}
		}
		
		
		dfs(0, 0);
		System.out.println(Answer);
	}
	
	public static void dfs(int idx, int depth) {
		
		// depth ��(N/2)�̸�, �������� 
		if( N / 2 == depth) {
			divideTeam();
		} else {
			for (int i = idx + 1; i <= N ; i++) {
				if( !visited[i] ) {
					visited[i] = true;
					dfs( i, depth + 1 );
				}
			}
			
		}
		for (int i = 0; i <= N; i++) {
			System.out.println("visited[" + i + "] : " + visited[i] );
		}
		System.out.println("Answer: " + Answer);
		System.out.println();
		visited[idx] = false;
	}
	
	public static void divideTeam() {
		// a[] : ��ŸƮ ���� ������     (1)(2)(3)
		// b[] : ��ũ ���� ������        (4)(5)(6)
		int a[] = new int[N/2 + 1];
		int b[] = new int[N/2 + 1];
		
		int x = 1, y = 1;
		// ���� ��ȣ : i
		for (int i = 1; i <= N; i++) {
			if( visited[i] ) {
				// ��ŸƮ ���� ��
				a[x++] = i;
			} else {
				// ��ũ ���� ��
				b[y++] = i;
			}
		}
		for (int i = 1; i <= N/2 ; i++) {
			System.out.println("a[i] : " + a[i] );
			System.out.println("b[i] : " + b[i] );
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
		
		for (int i = 1; i <= N/2; i++) {
			for (int j = i + 1; j <= N/2; j++) {
				// S(i,j) �� S(j,i) �� ���Ѵ�.
				sum += MAT[arr[i]][arr[j]];
				sum += MAT[arr[j]][arr[i]];
			}
		}
		
		return sum;
	}
}



























