package prob.basic.dfs;

import java.util.Scanner;

/*
 	Q. ���� ����ϱ�
 	1���� N������ ���� ���Ƿ� �迭�� ������ �� ���� �켱�Ͽ�
 	�������� ������� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
 	 
 	���� ���, N=3 �� ��� {1,2,3}, {1,3,2}, {2,1,3}, {3,1,2}, {3,1,2}�� ������
 	������ �� �ִ�. ù ��° ���� ���� ���� �����󿡼� �ռ���, ù ��° ���� ������ �� ��° ���� ���� ����
 	�� ��° ���� ������ �� ��° ���� ���� ���� ���� ����Ѵ�.
 	
 	[�Է�]
 	ù ��° �ٿ� �׽�Ʈ���̽� �� T(1 �� T �� 5)�� �־�����.
 	�� �׽�Ʈ���̽����� ������ ���� N(3 �� N �� 6)�� �־�����.
 	
 	[���]
 	�� �ٸ��� "#T"(T�� �׽�Ʈ���̽� ��ȣ)�� ����� ��, �� ��° ���� N!(Nx(N-1)x...x1)
 	�ٿ� ���� ������ ������� ����Ѵ�. ������ �� ���� ���̿� ������ �ΰ� ����Ѵ�.
 	
 	(�Է¿���)
 	1
 	3
 	
 	(��¿���)
 	#1
 	1 2 3
 	1 3 2
 	2 1 3
 	2 3 1
 	3 1 2
 	3 2 1
 */

public class dfsPermutation {
	// �Է¿� �ʿ��� ����
	static int T, N;
	// i��° ���ڸ� �̹� �����ߴ��� ���θ� üũ�� �迭
	// i���ڸ� �̹� ������ ��� visited[i]= = 1
	// i���ڸ� ���� �������� ���� ��� visited[1] = 0
	static int visited[] = new int[7];
	static int Answer[] = new int[7];
	
	public static void dfs(int depth) {
		// ��������
		if( depth == N + 1 ) {
			for (int i = 1; i <= N; i++) {
				System.out.print(Answer[i] + " ");
			}
			System.out.println();
		} 
		// Ž������ 
		else {
			for (int i = 1; i <= N; i++) {
				// ���� �������� ���� ����i�� ����.
				if(visited[i] == 0) {
					visited[i] = 1;
					Answer[depth] = i;
					dfs(depth + 1);
				// Ž���� ������ ���� i�� �����ϱ� �� ��Ȳ���� ����
					visited[i] = 0;
					Answer[depth] = 0;
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			// visited�迭 �ʱ�ȭ
			for (int i = 1; i <= N; i++) {
				visited[i] = 0;
			}
			System.out.println("#" + test_case);
			dfs(1);
		}
	}
}












