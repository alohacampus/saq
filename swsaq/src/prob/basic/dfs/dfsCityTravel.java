package prob.basic.dfs;

import java.util.Scanner;

/*
 	Q.외판원순회
 	 1번부터 N번까지 번호가 매겨져 있는 도시가 있고, 도시들 사이에 길이 있는 경우에만
 	 이동할 수 있다. 여행을 좋아하는 영준이는 M번 도시에서 출발하여 출발지를 제외한 모든
 	 도시를 정확히 한 번씩만 방문한 후 처음 출발지인 M번 도시로 돌아오려고 한다. 이때 도시
 	 들 사이의 길을 지나갈 때 지불해야 하는 통행료가 있어, 종민이는 최소한의 비용으로 모든
 	 도시를 여행하고 싶다. 종민이가 모든 도시를 여행할 때 필요한 최소비용을 출력하는 프로
 	 그램을 작성하시오.
 	 
 	 [입력]
 	  첫 번째 줄에 테스트케이스의 수T(1 ≤ T ≤ 10)가 주어진다.
 	 각 테스트케이스마다 첫 번째 줄에는 도시의 수 N과 출발지 M이 공백을 두고 주어진다
 	 (3 ≤ N ≤ 10, 1 ≤ M ≤ N). 다음 N개의 줄에는 각 줄에 N개의 숫자들이 공백을 두고 주어지는
 	 데 i번째 줄의 j번째 숫자는 i번째 도시에서 j번째 도시로 가는데 드는 통행료 MAT[i][j]를
 	 의미한다. 만약 통행료가 0인 경우는 i도시에서 j도시로 가는 길이없을을 의미한다.(0 ≤ MAT[i][j] ≤ 50)
 	 
 	 [제한조건]
 	 - 도시를 잇은 도로는 일방통행이다. 심지어 i번째 도시에서 j번째 도시로 가는 길은
 	     있어도, j번재 도시에서 i번째로 돌아서 가는 길은 없을 수도 있다.
 	 - 모든 도시를 정확히 한 번씩만 지나야 함을 유의하라.
 	 
 	 [출력]
 	   각 줄마다 "#T"(T는 테스트케이스 번호)를 출력한 뒤, 영준이가 M번 도시부터 시작하여
 	 모든 도시를 정확히 한 번씩 순회하고 오는데 드는 통행룔 최솟값을 출력하시오. 단, 불가능
 	 할 경우 -1을 출력한다.
 	 
 	 (입력예시)
 	 1
 	 3 1
 	 0 1 1
 	 1 0 10
 	 2 20 0
 	 
 	 (출력예시)
 	 #1 13
 */
public class dfsCityTravel {
	static int T, N, M;
	static int Answer;
	static int visited[] = new int[11];
	static int MAT[][] = new int[11][11]; 	// 인접행렬
	
	// 현재 방문중인 정점 번호, 현재까지 누적된 통행료, 방문한 도시 수
	public static void dfs(int idx, int cost, int cnt) {
		// 모든 도시를 전부 방문했을 때
		if(cnt == N) {
			// 시작점에서 돌아갈 길이 있을 경우만
			if(MAT[idx][M] != 0) {
				// 기존 답보다 새로운 비용이 더 적게 든다면
				if(Answer == -1 || Answer > cost + MAT[idx][M]) {
					Answer = cost + MAT[idx][M];
				}
			}
		}
		else {
			for (int i = 1; i <= N; i++) {
				// 방문한 적이 없고, 길이 있는 도시만 탐색
				if(visited[i] == 0 && MAT[idx][i] != 0) {
					// 가지치기, 기존 정답보다 누적비용이 작을 경우에만 탐색
					if( Answer == -1 || Answer > cost + MAT[idx][i]) {
						visited[i] = 1;
						dfs(i, cost + MAT[idx][i], cnt + 1);
						visited[i] = 0;
					}
						
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
			// 초기화
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					MAT[i][j] = 0;
				}
			}
			for (int i = 1; i <= N; i++) {
				visited[i] = 0;
			}
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					MAT[i][j] = sc.nextInt();
				}
			}
			Answer = -1;
			visited[M] = 1;
			// DFS 탐색(위치, 비용, 현재까지 방문한 도시의 수)
			// 시작점 : M,  비용 : 0, 방문한 도시수 : 1
			dfs(M, 0, 1);
			System.out.println("#" + test_case + " " + Answer);
			
		}
	}
}

















