package boj.pre.exam._10026;

import java.util.Scanner;

public class _10026_2 {
	// N
	static int N;
	static String [][] MAT = new String[101][101];
	static int [][] visited = new int[101][101];
	static int [] dr = {0,1,0,-1};
	static int [] dc = {1,0,-1,0};
	static int cnt, cnt2;  			// ���ϻ���X, ���ϻ���O
	
	
	public static void dfs(int x, int y) {
		
		String nowRGB = MAT[x][y];
		// ��������
		// Ž������
		for (int i = 0; i < 4; i++) {
			int nxt_row = x + dr[i];
			int nxt_col = y + dc[i];
			// ���ھȿ� �ִ� �� Ȯ��
			if( 1 <= nxt_row && nxt_row <= N &&
					1 <= nxt_col && nxt_col <= N ) {
				if( visited[nxt_row][nxt_col] == 0 &&
						MAT[nxt_row][nxt_col].equals(nowRGB) ) {
					visited[nxt_row][nxt_col] = 1;
					dfs(nxt_row, nxt_col);
				}
			}
			
		}
		
		
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		for (int i = 1; i <= N; i++) {
			String [] str = sc.next().split("");
			for (int j = 0; j < N; j++) {
				MAT[i][j+1] = str[j];
			}
		}
		
		
		
		// 1. ���ϻ����� �ƴ� ���, ������ ������ ����.
		// Ž�� - �ѱ����� Ž���� �� cnt++
		for (int i = 0; i < N*N; i++) {
			// ���� Ž���� ��ǥ�� ���Ѵ�.
			int nxt_row = (i / N) + 1;
			int nxt_col = (i % N) + 1;
			if( visited[nxt_row][nxt_col] == 0 ) {
					cnt++;
					dfs(nxt_row, nxt_col);
			}
		}
		
		

		// �ʱ�ȭ - visited �ʱ�ȭ
		visited = new int[101][101];
		
		
		// 2. ���ϻ����� ���, ������ ������ ����.
		// G -> R �� ����
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if( MAT[i][j].equals("G") ) 
					MAT[i][j] = "R";
			}
		}
		
		for (int i = 0; i < N*N; i++) {
			// ���� Ž���� ��ǥ�� ���Ѵ�.
			int nxt_row = (i / N) + 1;
			int nxt_col = (i % N) + 1;
			if( visited[nxt_row][nxt_col] == 0 ) {
					cnt2++;
					dfs(nxt_row, nxt_col);
			}
		}
		
		
		System.out.println(cnt + " " + cnt2);
	}
}









