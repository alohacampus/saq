package boj.dfsbfs.example;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/*
 	Q.DFS�� BFS
	 �׷����� DFS�� Ž���� ����� BFS�� Ž���� ����� ����ϴ� ���α׷��� �ۼ��Ͻÿ�. 
	 ��, �湮�� �� �ִ� ������ ���� ���� ��쿡�� ���� ��ȣ�� ���� ���� ���� �湮�ϰ�, 
	 �� �̻� �湮�� �� �ִ� ���� ���� ��� �����Ѵ�. ���� ��ȣ�� 1������ N�������̴�.
	 
	[�Է�]
	ù° �ٿ� ������ ���� N(1 �� N �� 1,000), 
	������ ���� M(1 �� M �� 10,000), 
	Ž���� ������ ������ ��ȣ V�� �־�����. 
	���� M���� �ٿ��� ������ �����ϴ� �� ������ ��ȣ�� �־�����. 
	� �� ���� ���̿� ���� ���� ������ ���� �� �ִ�. �Է����� �־����� ������ ������̴�.
	
	[���]
	ù° �ٿ� DFS�� ������ �����, 
	�� ���� �ٿ��� BFS�� ������ ����� ����Ѵ�. 
	V���� �湮�� ���� ������� ����ϸ� �ȴ�.
	
	(�Է¿���)
	4 5 1
	1 2
	1 3
	1 4
	2 4
	3 4
	
	(��¿���)
	1 2 4 3
	1 2 3 4
	
 */
public class _1260 {
	
	static int[][] MAT;
	static int[] visited;
	static int N, M, V, A, B;
	
	
	public static void ResetVisit() {
		for (int i = 1; i <= N; i++) {
			visited[i]= 0;
		}
		System.out.println();
	}
	
	// ���� �켱 Ž��(Depth First Search) - ����Լ�
	public static void dfs(int idx) {
		// �湮�� ���� üũ
		visited[idx] = 1;
		System.out.print(idx + " ");
		
		for (int i = 1; i <= N; i++) {
			if(MAT[idx][i] == 1 && visited[i] == 0) {
				dfs(i);
			}
		}
	}
	
	// ���� �켱 Ž��(Depth First Search) - ����
	public static void dfs2(int idx) {
		Stack<Integer> stack = new Stack<>();
		stack.push(idx);
		// Ž������ ����
		int p;
		boolean flag;
		
		visited[idx] = 1;
		System.out.print(idx + " ");
		
		while(!stack.isEmpty()) {
			p = stack.peek();
			flag = false;
			
			for (int i = 1; i <= N; i++) {
				if(MAT[p][i] == 1 && visited[i] == 0) {
					stack.push(i);
					visited[i] = 1;
					System.out.print(i + " ");
					flag = true;
					break;
					
				}
			}
			
			// ������ �������� ���� ��� �������� ����
			if(!flag)
				stack.pop();
			
		}
	}
	
	
	// �ʺ� �켱 Ž��(Breadth First Search) - ť
	public static void bfs(int idx) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(idx);
		// �湮�� ���� üũ
		visited[idx] = 1;
		
		while(!queue.isEmpty()) {
			idx = queue.poll();
			System.out.print(idx + " ");
			
			for (int i = 1; i <= N; i++) {
				if(MAT[idx][i] == 1 && visited[i] == 0) {
					queue.offer(i);
					visited[i] = 1;
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		V = sc.nextInt();
		
		MAT = new int[N+1][N+1];
		visited = new int[N+1];
		
		for (int i = 1; i <= M; i++) {
			A = sc.nextInt();
			B = sc.nextInt();
			MAT[A][B] = MAT[B][A] = 1;
		}
		
		dfs2(V);
		ResetVisit();
		bfs(V);
	}
	

	
}















