package prob.basic;

import java.util.Scanner;

/*
       *������� 
	1���� N������ ��ȣ�� �ִ� ������� �� �������� �մ� ������� �̷���� ���� �׷���
	(directed graph)�� �ִ�. �� ������ ���� ���踦 ���� �迭�� �����Ͽ�
	�Ʒ��� ��Ģ��� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
	
   [������� (�����迭)]
   - �� �ٿ� N���� ���ڸ� ������ �ΰ� N�ٿ� ���� ����Ѵ�.
   - i��° ���� j��° ���ڿ��� i�� ������ j�� ���� ���̿� 
          ���� ����� ������ ���� ��� 1��, ���� ��� 0�� ����Ѵ�.
	
	[�Է�]
	ù ��° �ٿ� �׽�Ʈ���̽��� ��( 1 �� T �� 50 )�� �־�����.
	�� �׽�Ʈ���̽����� ù ��° �ٿ� ������ �� N�� ������ �� M�� ������ �ΰ� �־�����.
	(1 �� N �� 100, 1 �� M �� min(2,000, Nx(N-1)) �� ��° �ٺ��� M�ٿ� ���� 
	������ �����ϴ� �� ����  ������ ������ �ΰ� �־�����. ��, �� ������ ���� ������ �־�����
	���� ������, ������ �־��� ������ �ߺ��ؼ� �ٽ� �־����� ���� ����.
	
	[���]
	�� �ٸ��� "#T"�� ����� ��, �� ��° �ٺ��� N�ٿ� ���� �����迭�� ����Ѵ�.
 */
public class adjacencyMatrix {
	// �غ��� ����
	static int T, N, M, A, B;
	// �����迭
	static int MAT[][] = new int[101][101];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			M = sc.nextInt();
			// ���� �迭 �ʱ�ȭ
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					MAT[i][j] = 0;
				}
			}
			
			for (int i = 1; i <= M; i++) {
				A = sc.nextInt();
				B = sc.nextInt();
				MAT[A][B] = 1;
			}
			System.out.println("#" + test_case);
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					System.out.print(MAT[i][j] + " ");
				}
				System.out.println();
			}
		}
	}
}
















