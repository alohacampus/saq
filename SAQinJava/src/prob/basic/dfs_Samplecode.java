package prob.basic;

import java.util.Scanner;
/*
	���� �켱 Ž��(Depth First Search, DFS)
	- ���� �켱Ž���� Ʈ���� �׷����� Ž���ϴ� �˰��� �� �ϳ���,
	�� �������� ����Ͽ� ������ �ָ����� Ž���ϴ� ����̴�.
	
	- dfs�� ������ ��θ� ���� �ľ��� �� �ִ� ������ ������, 
	����(Stack) �̳� ����Լ�(Recursion Func)�� ������ �� �ִ�.
	
	(�Է¿���)
	1
	6 5
	1 2
	2 3
	2 4
	1 5
	5 6
 */


public class dfs_Samplecode {
	static int T, N, M, A, B;
	// i��° ������ �湮�ߴ� �� ���θ� üũ�� �迭
	// i��° ������ �湮(O) visitied[i] = 1
	// i��° ������ �湮(X) visitied[i] = 0
	static int visited[] = new int[101];
	static int Answer[] = new int[101];
	
	// ���� �迭
	static int MAT[][] = new int[101][101];
	//
	static int cnt = 0;
	
	public static void dfs(int idx, int depth) {
		// ��������
		if(depth == N) {
		}
		// Ž������
		else {
			for(int i = 1 ; i <= N ; i++) {
				// ������ �湮�� ������ �ƴϰ�
				// ���� ������ ����� ������ ��츸 Ž��
				if(visited[i] == 0 && MAT[idx][i] == 1) {
					// i��° ������ �湮
					System.out.println(i + "�� ���� �湮");
					visited[i] = 1;
					dfs(i, depth+1);
					// Ž���� ������ ����
					System.out.println(i + "������ ���ƿ�");
					visited[i] = 0;
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
			
			for (int i = 1; i <= M; i++) {
				A = sc.nextInt();
				B = sc.nextInt();
				MAT[A][B] = 1;
			}
			
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					System.out.print(MAT[i][j] + " ");
				}
				System.out.println();
			}
			dfs(1, 2);
			System.out.println(cnt);
			
		}
	}
}
