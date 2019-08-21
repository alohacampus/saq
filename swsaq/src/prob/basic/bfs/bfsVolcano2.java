package prob.basic.bfs;
/*
	Q.화산 폭발2
	 세로와 가로의 크기가 N인 정사각형 모양의 격자로 이루어진 섬에 화산이 폭발하였다.
	최초 격자의 상태는 초원, 바리케이트, 화산 세 가지 상태로 이루어져 있다. 용암은 화산에
	서 출발하여 상하좌우 네 방향 중 초원이 있는 곳들을 파괴된 초원으로 바꾸며 퍼져나간다.
	만약 네 방향 중 바리케이트가 설치되어 있거나 혹은 화산이 존재한다면 해당 영역을 지나 갈
	수 없다. 정부에서는 화산 폭발로 인한 용암의 피해를 최소한으로 하기 위해 기존에 설치된 바리케이트
	외에 M개의 바리케이트를 초원 위에 추가로 설치하기로 하였다. M개의 바리케이트를 모두 설치한
	 후 시간이 충분히 지나 용암이 퍼져나갈 수 있는 모든 영역으로 퍼져나갔을 때, 파괴되지 않은
	 초원의 크개를 구하는 프로그램을 작성하시오.
	
	[입력]
	  첫 번째 줄에 테스트케이스의 수 T(1 ≤ T ≤ 10)가 주어진다.
	각 테스트케이스마다 첫 번째 줄에 가로와 세로의 크기 N과 바리케이트의 수 M이 공백을 두고 주어진다(3 ≤ N ≤ 6, 0 ≤ M ≤ 3).
	  다음 N개의 줄에는 각 줄에 N개의 숫자들이 공백을 두고 주어지는데, 1번째 줄의 j번째
	 숫자는 섬의 i행 j열의 상태 MAT[i][j]를 나타낸다. MAT[i][j]값이 0인 경우에는 초원이며
	 1인 경우에는 이미 세워진 바리케이드, 2인 경우네는 화산이 폭발한 지점이다.
	 
	[제한조건]
	- M개의 추가 바리케이트는 초원인 곳에만 세울 수 있다.
	- M개의 추가 바리케이트는 화산이 폭발하여 용암이 퍼져나가기 전에 모두 설치된다고 가정한다.
	- M개의 추가 바리케이트가 설치할 공간(초원)이 있음은 항상 보장된다.
	 
	[출력]
	  각 줄마다 "#T"(T는 테스트케이스 번호)를 출력한 뒤, 공백을 두고 M개의 추가 바리케이트
	  설치 후 용암이 퍼져나가도 파괴되지 않는 초원의 최대 개수를 출력한다.
	 
	(입력예시)
	1
	4 2
	0 0 0 0
	0 2 1 0
	0 1 2 1
	0 0 1 0
	
	(출력예시)
	#1 8
*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bfsVolcano2 {
	// 입력할 변수들
	// 테스트케이스, 격자크기, 바리케이트 수
	static int T, N, M;
	// 화산의 위치를 담을 벡터 S
	static ArrayList<int[]> S = new ArrayList<int[]>();
	// BFS를 구현할 큐 
	static Queue<int[]> que = new LinkedList<int[]>();
	// MAT[][] - 인접행렬
	// C_MAT[][]
	static int MAT[][] = new int[7][7];
	static int C_MAT[][] = new int[7][7];
	// 우하좌상(동남서북) - 시계방향
	static int dr[] = {0,1,0,-1};
	static int dc[] = {1,0,-1,0};
	// 최종 답, 안전지역
	static int Answer, grass;
	
	// bfs() : 
	//	<bfs 구현단계>
	//	3. 기준점이 목적지이면 탐색을 종료한다.
	//	4. 그렇지 않은 경우 기준점에서 갈 수 있는 다음 정점들을 큐에 넣는다.
	//	5. 큐에 원소가 없을 때까지 2단계로 돌아가 반복한다.  
	
	public static void bfs() {
		// que를 초기화한다.
		que.clear();
		
		// 벽을 세운 격자를 카피한다. (MAT[][] -> C_MAT[][]) 
		// 기존에 용암이 퍼진 격자를 초기화해주기 위해서
		// 인접행렬 초기화
		// clone() - 2차원배열 복사
		// C_MAT = MAT.clone();
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				C_MAT[i][j] = MAT[i][j];
			}
		}
		
		// 현재 격자에서의 초원의 수 (매 탐색마다 초기화)
		int now_grass = 0;
		int now_vol = 0;
		
		// 화산의 벡터(x좌표,y좌표)를 가져와서 큐에 넣자
		for (int i = 0; i < S.size(); i++) {
			//	1. 시작점을 큐에 넣는다.
			que.add(S.get(i));
		}
		while(!que.isEmpty()) {
			//	2. 큐에서 한 점을 꺼내서 기준점으로 삼는다.
			int now[] = que.poll();
			int now_row = now[0];
			int now_col = now[1];
			// 현재 화산에서 다음좌표를 찾는다 (동남서북)
			for (int i = 0; i < 4; i++) {
				int nxt_row = now_row + dr[i];
				int nxt_col = now_col + dc[i];
				// 격자 안에 있는지 확인
				if( nxt_row >= 1 && nxt_row <= N 
						&& nxt_col >= 1 && nxt_col <= N ) {
					// 화산으로 부터 용암이 퍼질 수 있는 지 확인 
					// 즉, 초원 (0)인지 확인
					if( C_MAT[nxt_row][nxt_col] == 0 ) {
						// 초원이면 용암을 퍼뜨린다.
						C_MAT[nxt_row][nxt_col] = 2;
						now_vol++;						// 퍼뜨린 용암의 개수를 센다.
						// 퍼뜨린 용암의 위치를 큐에 넣는다 (다음 탐색을 위해)
						que.add(new int[] {nxt_row, nxt_col});
					}		
				}
			}
			
		}
		
		// 현재 격자에서 초원의 개수를 계산한다.
		now_grass = grass - now_vol;
		// 현재까지의 초원의 개수 최댓값을 구한다.
		if( Answer < now_grass ) {
			Answer = now_grass;
		}
		
		
	}
	
	
	// 벽을 M개 만큼 세우자!!
	// dfs() : (반환타입X), (매개변수: idx, cnt)
	public static void dfs(int idx, int cnt) {
		// 종료조건
		// 세운 바리케이트 수가 입력받은 M과 같아졌을 때 멈춘다.
		// cnt == M
		if( cnt == M ) {
			// 이제 벽을 다 세웠으니까
			// 화산을 폭발시키고 용암이 퍼질 때마다 세놓은 초원의 개수를 감소시키자.
			bfs();
		}
		// 탐색조건
		else {
			for (int i = idx; i < N*N; i++) {
				// 다음 탐색할 좌표를 구한다.
				int nxt_row = (i / N) + 1;
				int nxt_col = (i % N) + 1;
				
				// 바리케이트를 설치할 수 있는 초원인 경우
				if( MAT[nxt_row][nxt_col] == 0 ) {
					// 새로운 바리케이트 생성
					MAT[nxt_row][nxt_col] = 1;
					dfs(i+1, cnt+1);
					// 탐색을 한 바리케이트 원복(제거)
					MAT[nxt_row][nxt_col] = 0;
					
				}
				
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			M = sc.nextInt();
			
			// 인접행렬 초기화
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					MAT[i][j] = 0;
				}
			}
			// 화산의 위치 벡터 초기화
			S.clear();
			Answer = 0;
			grass = 0;  	// 최초 초원을 센 개수
			
			
			// 초원 : 0, 바리케이트 : 1, 화산 : 2
			// 인접행렬 입력
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					MAT[i][j] = sc.nextInt();
					// 초원인 경우
					if( MAT[i][j] == 0 ) {
						grass++;
					}
					// 화산인 경우
					else if( MAT[i][j] == 2 ) {
						// int[] {i,j} 는 화산의 x좌표(행), y좌표(열)
						S.add(new int[] {i, j});
					}
				}
			}
			// 새로 세울 바리케이트 개수 M (초원에 바리케이트를 세웠으니까)
			grass = grass - M;
			// dfs(현재위치, 바리케이트의 개수)
			dfs(0, 0);
			
			// 답을 출력한다.
			System.out.println("#" + test_case + " " + Answer);
			
			
			
		}
	}
			
}



















