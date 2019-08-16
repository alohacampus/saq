package prob.basic.dfs;
/*
 	Q.ȭ�� ����1
 	 ���ο� ������ ũ�Ⱑ N�� ���簢�� ����� ���ڷ� �̷���� ���� ȭ���� �����Ͽ���.
 	���� ������ ���´� �ʿ�, �ٸ�����Ʈ, ȭ�� �� ���� ���·� �̷���� �ִ�. ����� ȭ�꿡
 	�� ����Ͽ� �����¿� �� ���� �� �ʿ��� �ִ� ������ �ı��� �ʿ����� �ٲٸ� ����������.
 	���� �� ���� �� �ٸ�����Ʈ�� ��ġ�Ǿ� �ְų� Ȥ�� ȭ���� �����Ѵٸ� �ش� ������ ���� ��
 	�� ����. ���� ����(��)�� ����� �͵� ������ �ʴ´�. �ð��� ����� ���� �����
 	�������� �� �ִ� ��� �������� ���������� ��, �ı����� �ʴ� �ʿ��� �ִ� ũ�⸦ ���ϴ�
 	���α׷��� �ۼ��Ͻÿ�.
 	
 	[�Է�]
 	  ù ��° �ٿ� �׽�Ʈ���̽��� �� T(1 �� T �� 10)�� �־�����.
 	�� �׽�Ʈ���̽����� ù ���� �ٿ� ���ο� ������ ũ�� N�� ������ �ΰ� �־�����(3 �� N �� 100).
 	
 	  ���� N���� �ٿ��� �� �ٿ� N���� ���ڵ��� ������ �ΰ� �־����µ� 1���� ���� j��°
 	 ���ڴ� ���� i�� j���� ���� MAT[i][j]�� ��Ÿ����. MAT[i][j]���� 0�� ��쿡�� �ʿ��̸�
 	 1�� ��쿡�� �̹� ������ �ٸ����̵�, 2�� ���״� ȭ���� ������ �����̴�.
 	 
 	[���]
 	  �� �ٸ��� "#T"(T�� �׽�Ʈ���̽� ��ȣ)�� ����� ��, ������ �ΰ� ����� ���������� 
 	 �ı����� �ʴ� �ʿ��� �ִ� ������ ����Ѵ�.
 	 
 	(�Է¿���)
 	1
 	4
 	0 0 0 0
 	0 2 1 0
 	0 1 2 1
 	0 0 1 0
 	��
 	(��¿���)
 	#1 1
 */

import java.util.ArrayList;
import java.util.Scanner;

public class dfsVolcano1 {
	static int T, N;
	
	// ȭ���� ��ġ�� ���� ���� S
	static ArrayList<int[]> S = new ArrayList<int[]>();
	// MAT�� ��
	// -1: �ı��� �ʿ� , 0: �ʿ�, 1: �ٸ�����Ʈ, 2:ȭ��
	static int MAT[][] = new int[10][20];
	// �����¿� Ž���� ���� dr,dc  - ��,��,��,�� (�ð����)
	static int dr[] = { 0,1,0,-1 };
	static int dc[] = { 1,0,-1,0 };
	static int Answer;
	
	public static void dfs(int now_row, int now_col) {
		// ���ٸ� ���������� �ʿ����� ����
		// Ž������
		for (int i = 0; i < 4; i++) {
			int nxt_row = now_row + dr[i];
			int nxt_col = now_col + dc[i];
			// ���� ������ ���� �ȿ� �ִ� ���
			if(nxt_row >= 1 && nxt_row <= N
				&& nxt_col >= 1 && nxt_col <= N ) {
				// ���� ������ �ʿ��� ���
				if(MAT[nxt_row][nxt_col] == 0) {
					MAT[nxt_row][nxt_col] = -1;
					Answer--;
					dfs(nxt_row, nxt_col);
					// MAT[nxt_row][nxt_col]�� �ʱ�ȭ���� ����
				}
			}
				
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			// �ʱ�ȭ
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					MAT[i][j] = 0;
				}
			}
			S.clear();
			Answer = 0;
			
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					MAT[i][j] = sc.nextInt();
					// �ʿ��� ���
					if(MAT[i][j] == 0) {
						Answer++;
					}
					// ȭ���� ���
					else if(MAT[i][j] == 2) {
						S.add(new int[] {i, j});
					}
				}
			}
			for (int i = 0; i <= S.size(); i++) {
				dfs(S.get(i)[0], S.get(i)[1]);
			}
			System.out.println("#" + test_case + " " + Answer);
		}
	}
	
}

















