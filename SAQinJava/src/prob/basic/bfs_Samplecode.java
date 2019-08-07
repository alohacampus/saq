package prob.basic;
/*
 
	�ʺ� �켱 Ž��(Breadth First Search, BFS)
	- �ʺ� �켱 Ž���� Ʈ���� �׷����� Ž���ϴ� �˰��� �� �ϳ���,
	 ���� �������� �����Ͽ� ������ ������ ���� Ž���ϴ� ����̴�.
	 
	- bfs�� �ּҺ�� ��θ� ã�� ���� ������ ������,
	Queue�� �̿��ؼ� �����Ѵ�.
	
	<bfs �����ܰ�>
	1. �������� ť�� �ִ´�.
	2. ť���� �� ���� ������ ���������� ��´�.
	3. �������� �������̸� Ž���� �����Ѵ�.
	4. �׷��� ���� ��� ���������� �� �� �ִ� ���� �������� ť�� �ִ´�.
	5. ť�� ���Ұ� ���� ������ 2�ܰ�� ���ư� �ݺ��Ѵ�.        
	
	(�Է¿���)
	1
	7 6
	1 7
	1 2
	2 4
	2 5
	1 3
	3 6
	6 7
	
	(�׷��� ����)
	    1
	   /  \
	  2    3   
	 / \    \
	4   5    6
			 |
			 7

*/

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bfs_Samplecode {
	static int T, N, M, A, B;
	// ������ ���� ť (row, col, cost)
	static Queue<Integer> que = new LinkedList<Integer>();
	
	// ����� S, ������ E
	static int S, E;
	
	// ���� ���
	static int MAT[][] = new int[101][101];
	
	// i��° ������ �湮�ߴ� �� ���θ� üũ�� �迭
	// i��° ������ �湮(O) visitied[i] = 1
	// i��° ������ �湮(X) visitied[i] = 0
	static int visited[] = new int[101];
	
	
	public static void bfs() {
		// 1. ������ S�� ť�� �ִ´�.
		que.add(S);
		visited[S] = 1;
		// 5. ť�� ������� �ʴٸ� �ݺ�
		while(!que.isEmpty()) {
			// 2. ť���� ������ �̾� ���������� ��´�.
			System.out.println("now : " + que.peek());
			int now = que.poll();
			// 3. �������� �������̸� ����
			if(now == E) {
				break;
			}
			// 4. �׷��� ���� ��� Ž��
			else {
				for (int i = 1; i <= N; i++) {
					// ������ �湮���� �ʰ�
					// ���� ������ ����� ���� Ž��
					if(visited[i] == 0 && MAT[now][i] == 1) {
						visited[i] = 1;
						// �ش� ������ ť�� �ִ´�.
						que.add(i);
						System.out.println(i + "�� ���� �湮");
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int test_case = 0; test_case < T; test_case++) {
			// N : ������ ��
			// M : ������ ��
			N = sc.nextInt();
			M = sc.nextInt();
			
			// S : �����
			// E : ������
			S = sc.nextInt();
			E = sc.nextInt();
			
			// visited�迭 �ʱ�ȭ
			for (int i = 0; i < N; i++) {
				visited[i] = 0;
			}
			
			// �����迭 �ʱ�ȭ
			for (int i = 1; i <= N ; i++) {
				for (int j = 1; j <= M; j++) {
					MAT[i][j] = 0;
				}
			}
			
			// �����迭 �������� ���� ����
			for (int i = 1; i <= M; i++) {
				A = sc.nextInt();
				B = sc.nextInt();
				MAT[A][B] = 1;
			}
			
			// �����迭 ���
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					System.out.print(MAT[i][j] + " ");
				}
				System.out.println();
			}
			
			// �׷��� Ž�� - BFS(Breadth First Search)
			bfs();
			
			// ���� �湮 ��
		}
	}
}
















