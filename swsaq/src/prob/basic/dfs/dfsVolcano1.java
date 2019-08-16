package prob.basic.dfs;
/*
 	Q.화산 폭발1
 	 세로와 가로의 크기가 N인 정사각형 모양의 격자로 이루어진 섬에 화산이 폭발하였다.
 	최초 격자의 상태는 초원, 바리케이트, 화산 세 가지 상태로 이루어져 있다. 용암은 화산에
 	서 출발하여 상하좌우 네 방향 중 초원이 있는 곳들을 파괴된 초원으로 바꾸며 퍼져나간다.
 	만약 네 방향 중 바리케이트가 설치되어 있거나 혹은 화산이 존재한다면 해당 영역을 지나 갈
 	수 없다. 또한 격자(섬)를 벗어나는 것도 허용되지 않는다. 시간이 충분히 지나 용암이
 	퍼져나갈 수 있는 모든 영역으로 퍼저나갔을 때, 파괴되지 않는 초원의 최대 크기를 구하는
 	프로그램을 작성하시오.
 	
 	[입력]
 	  첫 번째 줄에 테스트케이스의 수 T(1 ≤ T ≤ 10)가 주어진다.
 	각 테스트케이스마다 첫 번재 줄에 가로와 세로의 크기 N이 공백을 두고 주어진다(3 ≤ N ≤ 100).
 	
 	  다음 N개의 줄에는 각 줄에 N개의 숫자들이 공백을 두고 주어지는데 1번재 줄의 j번째
 	 숫자는 섬의 i행 j열의 상태 MAT[i][j]를 나타낸다. MAT[i][j]값이 0인 경우에는 초원이며
 	 1인 경우에는 이미 세워진 바리케이드, 2인 경우네는 화산이 폭발한 지점이다.
 	 
 	[출력]
 	  각 줄마다 "#T"(T는 테스트케이스 번호)를 출력한 뒤, 공백을 두고 용암이 퍼저나가도 
 	 파괴되지 않는 초원의 최대 개수를 출력한다.
 	 
 	(입력예시)
 	1
 	4
 	0 0 0 0
 	0 2 1 0
 	0 1 2 1
 	0 0 1 0
 	ㅕ
 	(출력예시)
 	#1 1
 */

import java.util.ArrayList;
import java.util.Scanner;

public class dfsVolcano1 {
	static int T, N;
	
	// 화산의 위치를 담을 벡터 S
	static ArrayList<int[]> S = new ArrayList<int[]>();
	// MAT의 값
	// -1: 파괴된 초원 , 0: 초원, 1: 바리케이트, 2:화산
	static int MAT[][] = new int[10][20];
	// 상하좌우 탐색을 위한 dr,dc  - 동,남,서,북 (시계방향)
	static int dr[] = { 0,1,0,-1 };
	static int dc[] = { 1,0,-1,0 };
	static int Answer;
	
	public static void dfs(int now_row, int now_col) {
		// 별다른 종료조건이 필요하지 않음
		// 탐색조건
		for (int i = 0; i < 4; i++) {
			int nxt_row = now_row + dr[i];
			int nxt_col = now_col + dc[i];
			// 다음 지점이 격자 안에 있는 경우
			if(nxt_row >= 1 && nxt_row <= N
				&& nxt_col >= 1 && nxt_col <= N ) {
				// 다음 지점이 초원인 경우
				if(MAT[nxt_row][nxt_col] == 0) {
					MAT[nxt_row][nxt_col] = -1;
					Answer--;
					dfs(nxt_row, nxt_col);
					// MAT[nxt_row][nxt_col]를 초기화하지 않음
				}
			}
				
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			// 초기화
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
					// 초원이 경우
					if(MAT[i][j] == 0) {
						Answer++;
					}
					// 화산인 경우
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

















