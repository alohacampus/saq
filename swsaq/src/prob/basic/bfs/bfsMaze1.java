package prob.basic.bfs;


/*
	Q. 미로 찾기1
	  세로 N, 가로 M 크기의 격자와 시작점(S_r, S_c)과 탈출구(E_r, E_c)가 주어졌을 때,
	시작점부터 탈출구까지 이동하기 위해 필요한 최소 이동 횟수를 구하는 프로그램을 작성하시오.
	한 번 이동시 상하좌우로 한 칸씩만 이동할 수 있으며, 벽이 있는 지점은 이동할 수 없다.
	만약 탈출구까지 이동할 수 있는 방법이 존재하지 않는다면 -1을 출력한다.
	
	[입력]
	 첫 번째 줄에 테스트케이스 수 T(1 ≤ T ≤ 10)가 주어진다.
	 각 테스트케이스마다 첫 번째 줄에는 격자의 세로의 길이 N과 가로의 길이 M이 공백을 두고
	주어진다.(3 ≤ N,M ≤ 1,000)
	 두 번째 줄에는 격자의 시작점(S_r, S_c)과 탈출구(E_r,E_c)를 나타내는 S_r, S_c, E_r, E_c가
	 각각 공백을 두고 주어진다. 각 좌표 쌍은 (행, 열)을 의미한다.
	다음 N개의 줄에는 각 줄마다 M개의 숫자들이 공백을 두고 주어지는데 i번째 줄의 j번째 숫자는
	격자의 (i, j)의 상태를 의미한다. 만약 값이 0인 경우 이동할 수 있는 곳이고, 1인 경우
	이동할 수 없는 벽이 설치되어 있다는 뜻이다.
	
	[출력]
	각 줄마다 "#T"(T는 테스트케이스 번호)를 출력한 뒤, 공백울 두고 시작점부터 탈출구 까지
	이동하는데 필요한 최소 횟수를 출력한다. 도달할 수 없다면 -1을 출력한다.
	
	[제한 조건]
	- 격자 밖으로 이동은 불가능하다.
	- 시작점과 탈출구가 벽(1)인 경우는 없다.
	- 좌측 상단의 좌표는 (1,1)이고 우측 하단의 좌표는 (N,M)이다.
	
	(입력예시)
	1
	3 4
	3 1 1 4
	0 0 1 0
	0 1 0 0
	0 0 0 1

	(출력예시)
	#1 5
	
*/

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bfsMaze1 {
	// 정점을 담을 큐 ((row, col, cost))
	static Queue <int[]> que = new LinkedList<>();
	
	// 격자( 0 : 이동 가능, 1 : 이동 불가능 )
	static int MAT[][] = new int[1001][1001];
	
	// 동남서북 순서로 탐색할 배열
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
			
			// 격자 초기화
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					MAT[i][j] = 0;
				}
			}
			
			// 큐 초기화
			que.clear();
			
			N = sc.nextInt();
			M = sc.nextInt();
			S_r = sc.nextInt();
			S_c = sc.nextInt();
			E_r = sc.nextInt();
			E_c = sc.nextInt();
			
			// 시작점(S_r, S_c 이동횟수  0) 삽입
			que.add(new int[] { S_r, S_c, 0 });
			MAT[S_r][S_c] = 1;
			
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					MAT[i][j] = sc.nextInt();
				}
			}
			// 탈출구에 도달하지 못하면 -1
			Answer = -1;
			while(!que.isEmpty()) {
				int now[] = que.poll();
				int now_row = now[0];			// 시작점의 행(S_r)
				int now_col = now[1];			// 시작점의 열(S_c)
				int now_cost = now[2];			// 이동횟수
				// 종료조건
				if( now_row == E_r && now_col == E_c) {
					Answer = now_cost;
					break;
				}
				// 탐색조건
				else {
					for (int i = 0; i < 4; i++) {
						int nxt_row = now_row + dr[i];
						int nxt_col = now_col + dc[i];
						int nxt_cost = now_cost + 1;
						// 이동지점이 격자 안에 있는 경우
						if( nxt_row >= 1 && nxt_row <= N
								&& nxt_col >= 1 && nxt_col <= M) {
							// 이동지점이 이동 가능한 곳일 경우
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




















