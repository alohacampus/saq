package prob.basic;

import java.util.ArrayList;
import java.util.Scanner;

/*
 	*��������Ʈ
	1���� N������ ��ȣ�� �ִ� ������� �� �������� �մ� ������� �̷���� ���� �׷���
	(directed graph)�� �ִ�. �� ������ ���� ���踦 ���� ����Ʈ�� �����Ͽ�
	�Ʒ��� ��Ģ��� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
	
   [��������Ʈ]
   - �� �ٿ� N���� ���ڸ� ������ �ΰ� N�ٿ� ���� ����Ѵ�.
   - i��° �ٿ��� i�� ������ ����� ������ ��ȣ�� ����Ѵ�. 
   	  ��, ����� ������ ������ �Ű澲�� �ʴ´�.
   
	[�Է�]
	ù ��° �ٿ� �׽�Ʈ���̽��� ��( 1 �� T �� 50 )�� �־�����.
	�� �׽�Ʈ���̽����� ù ��° �ٿ� ������ �� N�� ������ �� M�� ������ �ΰ� �־�����.
	(1 �� N �� 100, 1 �� M �� min(2,000, Nx(N-1)) �� ��° �ٺ��� M�ٿ� ���� 
	������ �����ϴ� �� ����  ������ ������ �ΰ� �־�����. ��, �� ������ ���� ������ �־�����
	���� ������, ������ �־��� ������ �ߺ��ؼ� �ٽ� �־����� ���� ����.
	
	[���]
	�� �ٸ��� "#T"�� ����� ��, �� ��° �ٺ��� N�ٿ� ���� �� ������ ����� �������� ����Ʈ, ��������Ʈ�� ����Ѵ�.
	
	(�Է� ����)
	1
	4 3
	1 4
	3 2
	2 1
 */
public class adjacencyList {
	// T : �׽�Ʈ���̽�, N : ����, M : ����, A :�����(����), B :������(����)
	static int T, N, M, A, B;
	// ���� ����Ʈ
	static ArrayList<Integer> alist[] = new ArrayList[101];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int i = 1; i <= 100; i++) {
			alist[i] = new ArrayList <Integer>();
		}
		T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			M = sc.nextInt();
			// ���� ����Ʈ �ʱ�ȭ
			for (int i = 1; i <= N; i++) {
				alist[i].clear();
			}
			// ���� ����Ʈ�� �׷��� ������ ���� �Է�
			for (int i = 1; i <= M; i++) {
				A = sc.nextInt();
				B = sc.nextInt();
				alist[A].add(B);
			}
			
			// ��������Ʈ ������ ���
			for (int i = 1; i <= N; i++) {
				for (int j = 0; j < alist[i].size(); j++) {
					System.out.print(alist[i].get(j) + " ");
				}
				System.out.println();
				
			}
			
		}
	}
}
















