package boj.pre.exam._14503;

import java.util.Scanner;

/*
 	Q.로봇청소기
 	로봇 청소기가 주어졌을 때, 청소하는 영역의 개수를 구하는 프로그램을 작성하시오.
	로봇 청소기가 있는 장소는 N×M 크기의 직사각형으로 나타낼 수 있으며, 1×1크기의 정사각형 칸으로 나누어져 있다.
	 각각의 칸은 벽 또는 빈 칸이다. 청소기는 바라보는 방향이 있으며, 이 방향은 동, 서, 남, 북중 하나이다. 
	 지도의 각 칸은 (r, c)로 나타낼 수 있고, r은 북쪽으로부터 떨어진 칸의 개수, c는 서쪽으로 부터 떨어진 칸의 개수이다.
	로봇 청소기는 다음과 같이 작동한다.
	
		현재 위치를 청소한다.
		현재 위치에서 현재 방향을 기준으로 왼쪽방향부터 차례대로 탐색을 진행한다.
		왼쪽 방향에 아직 청소하지 않은 공간이 존재한다면, 그 방향으로 회전한 다음 한 칸을 전진하고 1번부터 진행한다.
		왼쪽 방향에 청소할 공간이 없다면, 그 방향으로 회전하고 2번으로 돌아간다.
		네 방향 모두 청소가 이미 되어있거나 벽인 경우에는, 바라보는 방향을 유지한 채로 한 칸 후진을 하고 2번으로 돌아간다.
		네 방향 모두 청소가 이미 되어있거나 벽이면서, 뒤쪽 방향이 벽이라 후진도 할 수 없는 경우에는 작동을 멈춘다.
		로봇 청소기는 이미 청소되어있는 칸을 또 청소하지 않으며, 벽을 통과할 수 없다.
		
	[입력]
		첫째 줄에 세로 크기 N과 가로 크기 M이 주어진다. (3 ≤ N, M ≤ 50)
		둘째 줄에 로봇 청소기가 있는 칸의 좌표 (r, c)와 바라보는 방향 d가 주어진다. 
		d가 0인 경우에는 북쪽을, 1인 경우에는 동쪽을, 2인 경우에는 남쪽을, 3인 경우에는 서쪽을 바라보고 있는 것이다.
		셋째 줄부터 N개의 줄에 장소의 상태가 북쪽부터 남쪽 순서대로, 각 줄은 서쪽부터 동쪽 순서대로 주어진다. 빈 칸은 0, 벽은 1로 주어진다. 장소의 모든 외곽은 벽이다.
		로봇 청소기가 있는 칸의 상태는 항상 빈 칸이다.
	[출력]
		로봇 청소기가 청소하는 칸의 개수를 출력한다.
	
	(입력예시)
	3 3
	1 1 0
	1 1 1
	1 0 1
	1 1 1
	
	(출력예시)
	1
	
		
		
 */

public class _14503 {
	
	static int N, M;
	static int r, c, d;
	
	// 왼쪽 방향부터 - 0북,1동,2남,3서
	static int dr[] = {-1,0,1,0};
	static int dc[] = {0,1,0,-1};
	static int MAT[][];
	static int cnt = 1;
			
	public static void dfs(int r, int c, int d) {
		// 청소를 한다.
		MAT[r][c] = 2;
		
		// 종료조건
		
		// 탐색조건
		// 서남동북 방향확인
		for (int i = 0; i < 4; i++) {
			d = (d + 3) % 4;		// 북->서(0->3),  동->남(1->2), 남->서(2->3), 서->북(3->0)   (왼쪽)
			int nxt_row = r + dr[d];
			int nxt_col = c + dc[d];
			
			if( nxt_row >= 1 && nxt_row <= N 
					&& nxt_col >= 1 && nxt_col <= M ) {
				if(MAT[nxt_row][nxt_col] == 0) {
					// 청소한다.
					cnt++;
					dfs(nxt_row, nxt_col, d);
					return;
				}
			}
		}
		// 후진
		int back = (d + 2) % 4;
		int back_row = r + dr[back];
		int back_col = c + dc[back];
		
		if( back_row >= 1 && back_row <= N 
				&& back_col >= 1 && back_col <= M ) {
			if(MAT[back_row][back_col] != 1) {
				// 후진한다.
				dfs(back_row, back_col, d);
			}
		}
		
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 격자의 크기 N행, M열
		N = sc.nextInt();
		M = sc.nextInt();
		
		MAT = new int[N+1][M+1];
		
		// 로봇청소기의 위치 (r,c), 바라보고있는 방향 d
		r = sc.nextInt();
		c = sc.nextInt();
		d = sc.nextInt();
		
		
		// 격자 정보 - 빈칸 : 0, 벽 : 1
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				MAT[i][j] = sc.nextInt();
			}
		}
		
		// (0,0)이 첫번째 좌표이고, MAT[N][M]에서 0번재 index를 사용하지 않기 때문에
		// r+1, c+1
		dfs(r+1, c+1, d);
		
		System.out.println(cnt);
		
	}
}























