package boj.pre.exam._13460;
/*
	Q.구슬 탈출2
	스타트링크에서 판매하는 어린이용 장난감 중에서 가장 인기가 많은 제품은 구슬 탈출이다. 
	구슬 탈출은 직사각형 보드에 빨간 구슬과 파란 구슬을 하나씩 넣은 다음, 빨간 구슬을 구멍을 통해 빼내는 게임이다.
	
	보드의 세로 크기는 N, 가로 크기는 M이고, 편의상 1×1크기의 칸으로 나누어져 있다. 
	가장 바깥 행과 열은 모두 막혀져 있고, 보드에는 구멍이 하나 있다. 
	빨간 구슬과 파란 구슬의 크기는 보드에서 1×1크기의 칸을 가득 채우는 사이즈이고, 각각 하나씩 들어가 있다. 
	게임의 목표는 빨간 구슬을 구멍을 통해서 빼내는 것이다. 이때, 파란 구슬이 구멍에 들어가면 안 된다.
	
	이때, 구슬을 손으로 건드릴 수는 없고, 중력을 이용해서 이리 저리 굴려야 한다.
	왼쪽으로 기울이기, 오른쪽으로 기울이기, 위쪽으로 기울이기, 아래쪽으로 기울이기와 같은 네 가지 동작이 가능하다.
	
	각각의 동작에서 공은 동시에 움직인다. 빨간 구슬이 구멍에 빠지면 성공이지만, 파란 구슬이 구멍에 빠지면 실패이다. 
	빨간 구슬과 파란 구슬이 동시에 구멍에 빠져도 실패이다. 빨간 구슬과 파란 구슬은 동시에 같은 칸에 있을 수 없다. 
	또, 빨간 구슬과 파란 구슬의 크기는 한 칸을 모두 차지한다. 기울이는 동작을 그만하는 것은 더 이상 구슬이 움직이지 않을 때 까지이다.
	
	보드의 상태가 주어졌을 때, 최소 몇 번 만에 빨간 구슬을 구멍을 통해 빼낼 수 있는지 구하는 프로그램을 작성하시오.
	
	[입력]
	첫 번째 줄에는 보드의 세로, 가로 크기를 의미하는 두 정수 N, M (3 ≤ N, M ≤ 10)이 주어진다. 
	다음 N개의 줄에 보드의 모양을 나타내는 길이 M의 문자열이 주어진다. 이 문자열은 '.', '#', 'O', 'R', 'B' 로 이루어져 있다. 
	'.'은 빈 칸을 의미하고, '#'은 공이 이동할 수 없는 장애물 또는 벽을 의미하며, 'O'는 구멍의 위치를 의미한다. 'R'은 빨간 구슬의 위치, 'B'는 파란 구슬의 위치이다.
	입력되는 모든 보드의 가장자리에는 모두 '#'이 있다. 구멍의 개수는 한 개 이며, 빨간 구슬과 파란 구슬은 항상 1개가 주어진다.
	
	[출력]
	최소 몇 번 만에 빨간 구슬을 구멍을 통해 빼낼 수 있는지 출력한다. 
	만약, 10번 이하로 움직여서 빨간 구슬을 구멍을 통해 빼낼 수 없으면 -1을 출력한다.
	
	(예제 입력1)
	5 5
	#####
	#..B#
	#.#.#
	#RO.#
	#####
	
	(예제 출력1)
	1
	
	(예제 입력2)
	7 7
	#######
	#...RB#
	#.#####
	#.....#
	#####.#
	#O....#
	#######
	
	(예제 출력2)
	5
*/

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _13460_first {
	// 변수선언
	public static int N, M;
	public static int rx, ry, bx, by;
	public static int[] dx = {0, 1, 0, -1};
	public static int[] dy = {1, 0, -1, 0};
	public static char[] d = {'동','남','서','북'};
	public static char[] dp = {'→','↓','←','↑'};
	public static int [][] MAT;
	public static int [][][][] visited;
	public static Queue<Pair> que = new LinkedList<>();
	
	
	// class : 속성(변수), 기능(메소드)
	public static class Pair {
		int rx, ry, bx, by, cnt;

		// alt + shift + S  --> O
		public Pair(int rx, int ry, int bx, int by, int cnt) {
			this.rx = rx;
			this.ry = ry;
			this.bx = bx;
			this.by = by;
			this.cnt = cnt;
		}
	}
	
	
	// bfs()
	public static int bfs() {
		// 1. 시작점 Pair 를 큐에 넣는다.
		que.add(new Pair(rx, ry, bx, by, 0));
		visited[rx][ry][bx][by] = 1;
		
		// 5. 큐가 비어있지 않다면 반복
		while(!que.isEmpty()) {
			// 2. 큐에서 현재위치(R,B)를 꺼낸다.
			Pair p = que.poll();
			
			// 3. (종료조건)	
			// - 기울임 10번 초과시 실패(-1)
			// - 파란색 구슬이 구멍에 빠지면 continue
			// - 빨간색 구슬이 구멍에 빠지면 cnt
			if( p.cnt > 10 ) return -1;
			if( MAT[p.bx][p.by] == 4 ) continue;
			if( MAT[p.rx][p.ry] == 4 ) return p.cnt; 
			
			// 4. (탐색조건)
			// 빨간색 구슬 이동 
			for (int i = 0; i < 4; i++) {
				int nxt_rx = p.rx;
				int nxt_ry = p.ry;
				while(true) {
					// 다음 지점이 벽(1)이랑 구멍(4)이 아니면
					if( MAT[nxt_rx][nxt_ry] != 1 && MAT[nxt_rx][nxt_ry] != 4 ) {
						nxt_rx += dx[i];
						nxt_ry += dy[i];
					} else {
						// 다음 지점이 벽(1)이면
						if( MAT[nxt_rx][nxt_ry] == 1) {
							nxt_rx -= dx[i];
							nxt_ry -= dy[i];
						}
						break;
					}
				}
				System.out.println(d[i] + " 쪽으로로이동 : " + "(rx,ry) : " +  "( " + nxt_rx + ", " + nxt_ry + " )" + " <빨간구슬> -- " + dp[i] );
				
				// 파란색 구슬 이동
				int nxt_bx = p.bx;
				int nxt_by = p.by;
				while(true) {
					// 다음 지점이 벽(1)이랑 구멍(4)이 아니면
					if( MAT[nxt_bx][nxt_by] != 1 && MAT[nxt_bx][nxt_by] != 4 ) {
						nxt_bx += dx[i];
						nxt_by += dy[i];
					} else {
						// 다음 지점이 벽(1)이면
						if( MAT[nxt_bx][nxt_by] == 1 ) {
							nxt_bx -= dx[i];
							nxt_by -= dy[i];
						}
						break;
					}
				}
				System.out.println(d[i] + " 쪽으로로이동 : " + "(bx,by) : " +  "( " + nxt_bx + ", " + nxt_by + " )" + " <파란구슬> -- " + dp[i] );
				System.out.println();
				// 빨간색 구슬과 파란색 구슬 겹치는지 확인
				if( nxt_rx == nxt_bx && nxt_ry == nxt_by ) {
					if( MAT[nxt_rx][nxt_ry] != 4) {
						int red_cost = Math.abs(nxt_rx - p.rx) + Math.abs(nxt_ry - p.ry);
						int blue_cost = Math.abs(nxt_bx - p.bx) + Math.abs(nxt_by - p.by);
						if(red_cost > blue_cost) {
							nxt_rx -= dx[i];
							nxt_ry -= dy[i];
						} else {
							nxt_bx -= dx[i];
							nxt_by -= dy[i];
						}
					}
				}
				
				// 이동 위치, 이동 횟수를 Pair로 큐에 담는다.
				// 다음 큐에서 꺼낼 때, 
				// 파란 구슬부터 구멍에 빠졌는지 확인 (빠졌으면 다음 탐색) 
				// 빨간 구슬도 구멍에 빠졌는지 확인 
				if( visited[nxt_rx][nxt_ry][nxt_bx][nxt_by] == 0 ) {
					visited[nxt_rx][nxt_ry][nxt_bx][nxt_by] = 1;
					que.add( new Pair(nxt_rx, nxt_ry, nxt_bx, nxt_by, p.cnt +1) );
				}
				
			}
			
		}
		
		return -1;
	}
	
	
	
	
	
	
	// main()
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		sc.nextLine();
		
		MAT = new int[N+1][M+1];
		visited = new int[N+1][M+1][N+1][M+1];
		
		// 문자를 넘버링, R과 B의 입력좌표를 지정.
		for (int i = 1; i <= N ; i++) {
			String str = sc.nextLine();
			for (int j = 1; j <= str.length(); j++) {
				int num = 0;
				switch (str.charAt(j-1)) {
				case '.':  	num = 0;
							break;
				case '#':  	num = 1;
							break;
				case 'R':  	num = 2;
							rx = i;
							ry = j;
							break;
				case 'B':  	num = 3;
							bx = i;
							by = j;
							break;
				case 'O':  	num = 4;
							break;
				}
				MAT[i][j] = num;
			}
		}
		
		System.out.println(bfs());
	}

}




















