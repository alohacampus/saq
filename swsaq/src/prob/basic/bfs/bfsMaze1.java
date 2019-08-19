package prob.basic.bfs;


/*
	Q. �̷� ã��1
	  ���� N, ���� M ũ���� ���ڿ� ������(S_r, S_c)�� Ż�ⱸ(E_r, E_c)�� �־����� ��,
	���������� Ż�ⱸ���� �̵��ϱ� ���� �ʿ��� �ּ� �̵� Ƚ���� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
	�� �� �̵��� �����¿�� �� ĭ���� �̵��� �� ������, ���� �ִ� ������ �̵��� �� ����.
	���� Ż�ⱸ���� �̵��� �� �ִ� ����� �������� �ʴ´ٸ� -1�� ����Ѵ�.
	
	[�Է�]
	 ù ��° �ٿ� �׽�Ʈ���̽� �� T(1 �� T �� 10)�� �־�����.
	 �� �׽�Ʈ���̽����� ù ��° �ٿ��� ������ ������ ���� N�� ������ ���� M�� ������ �ΰ�
	�־�����.(3 �� N,M �� 1,000)
	 �� ��° �ٿ��� ������ ������(S_r, S_c)�� Ż�ⱸ(E_r,E_c)�� ��Ÿ���� S_r, S_c, E_r, E_c��
	 ���� ������ �ΰ� �־�����. �� ��ǥ ���� (��, ��)�� �ǹ��Ѵ�.
	���� N���� �ٿ��� �� �ٸ��� M���� ���ڵ��� ������ �ΰ� �־����µ� i��° ���� j��° ���ڴ�
	������ (i, j)�� ���¸� �ǹ��Ѵ�. ���� ���� 0�� ��� �̵��� �� �ִ� ���̰�, 1�� ���
	�̵��� �� ���� ���� ��ġ�Ǿ� �ִٴ� ���̴�.
	
	[���]
	�� �ٸ��� "#T"(T�� �׽�Ʈ���̽� ��ȣ)�� ����� ��, ����� �ΰ� ���������� Ż�ⱸ ����
	�̵��ϴµ� �ʿ��� �ּ� Ƚ���� ����Ѵ�. ������ �� ���ٸ� -1�� ����Ѵ�.
	
	[���� ����]
	- ���� ������ �̵��� �Ұ����ϴ�.
	- �������� Ż�ⱸ�� ��(1)�� ���� ����.
	- ���� ����� ��ǥ�� (1,1)�̰� ���� �ϴ��� ��ǥ�� (N,M)�̴�.
	
	(�Է¿���)
	1
	3 4
	3 1 1 4
	0 0 1 0
	0 1 0 0
	0 0 0 1

	(��¿���)
	#1 5
	
*/

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bfsMaze1 {
	// ������ ���� ť ((row, col, cost))
	static Queue <int[]> que = new LinkedList<>();
	
	// ����( 0 : �̵� ����, 1 : �̵� �Ұ��� )
	static int MAT[][] = new int[1001][1001];
	
	// �������� ������ Ž���� �迭
	static int dr[] = { 0, 1, 0, -1 };
	static int dc[] = { 1, 0, -1, 0 };
	static int T;
	static int N, M;
	static int S_r, S_c, E_r, E_c;
	static int Answer;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			
			// ���� �ʱ�ȭ
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					MAT[i][j] = 0;
				}
			}
			
			// ť �ʱ�ȭ
			que.clear();
			
			N = sc.nextInt();
			M = sc.nextInt();
			S_r = sc.nextInt();
			S_c = sc.nextInt();
			E_r = sc.nextInt();
			E_c = sc.nextInt();
			
			// ������(S_r, S_c �̵�Ƚ��  0) ����
			que.add(new int[] { S_r, S_c, 0 });
			MAT[S_r][S_c] = 1;
			
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					MAT[i][j] = sc.nextInt();
				}
			}
			// Ż�ⱸ�� �������� ���ϸ� -1
			Answer = -1;
			while(!que.isEmpty()) {
				int now[] = que.poll();
				int now_row = now[0];			// �������� ��(S_r)
				int now_col = now[1];			// �������� ��(S_c)
				int now_cost = now[2];			// �̵�Ƚ��
				// ��������
				if( now_row == E_r && now_col == E_c) {
					Answer = now_cost;
					break;
				}
				// Ž������
				else {
					for (int i = 0; i < 4; i++) {
						int nxt_row = now_row + dr[i];
						int nxt_col = now_col + dc[i];
						int nxt_cost = now_cost + 1;
						// �̵������� ���� �ȿ� �ִ� ���
						if( nxt_row >= 1 && nxt_row <= N
								&& nxt_col >= 1 && nxt_col <= M) {
							// �̵������� �̵� ������ ���� ���
							if(MAT[nxt_row][nxt_col] == 0) {
								MAT[nxt_row][nxt_col] = 1;
								que.add(new int[] { nxt_row, nxt_col, nxt_cost });
							}
						}
					}
				}
			}
			System.out.println("#" + test_case + " " + Answer);
		}
	}
	
	
}




















