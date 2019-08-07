package prob.basic;
/*
 
	너비 우선 탐색(Breadth First Search, BFS)
	- 너비 우선 탐색은 트리나 그래프를 탐색하는 알고리즘 중 하나로,
	 시작 정점에서 시작하여 인접한 정점을 먼저 탐색하는 방법이다.
	 
	- bfs는 최소비용 경로를 찾는 데에 장점이 있으며,
	Queue를 이용해서 구현한다.
	
	<bfs 구현단계>
	1. 시작점을 큐에 넣는다.
	2. 큐에서 한 점을 꺼내서 기준점으로 삼는다.
	3. 기준점이 목적지이면 탐색을 종료한다.
	4. 그렇지 않은 경우 기준점에서 갈 수 있는 다음 정점들을 큐에 넣는다.
	5. 큐에 원소가 없을 때까지 2단계로 돌아가 반복한다.        
	
	(입력예시)
	1
	7 6
	1 7
	1 2
	2 4
	2 5
	1 3
	3 6
	6 7
	
	(그래프 예시)
	    1
	   /  \
	  2    3   
	 / \    \
	4   5    6
			 |
			 7

*/

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bfs_Samplecode {
	static int T, N, M, A, B;
	// 정점을 담을 큐 (row, col, cost)
	static Queue<Integer> que = new LinkedList<Integer>();
	
	// 출발지 S, 목적지 E
	static int S, E;
	
	// 인접 행렬
	static int MAT[][] = new int[101][101];
	
	// i번째 정점을 방문했는 지 여부를 체크할 배열
	// i번째 정점을 방문(O) visitied[i] = 1
	// i번째 정점을 방문(X) visitied[i] = 0
	static int visited[] = new int[101];
	
	
	public static void bfs() {
		// 1. 시작점 S를 큐에 넣는다.
		que.add(S);
		visited[S] = 1;
		// 5. 큐가 비어있지 않다면 반복
		while(!que.isEmpty()) {
			// 2. 큐에서 한점을 뽑아 기준점으로 삼는다.
			System.out.println("now : " + que.peek());
			int now = que.poll();
			// 3. 기준점이 목적지이면 종료
			if(now == E) {
				break;
			}
			// 4. 그렇지 않은 경우 탐색
			else {
				for (int i = 1; i <= N; i++) {
					// 기존에 방문하지 않고
					// 현재 정점과 연결된 점을 탐색
					if(visited[i] == 0 && MAT[now][i] == 1) {
						visited[i] = 1;
						// 해당 지점을 큐에 넣는다.
						que.add(i);
						System.out.println(i + "번 정점 방문");
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int test_case = 0; test_case < T; test_case++) {
			// N : 정점의 수
			// M : 간선의 수
			N = sc.nextInt();
			M = sc.nextInt();
			
			// S : 출발지
			// E : 목적지
			S = sc.nextInt();
			E = sc.nextInt();
			
			// visited배열 초기화
			for (int i = 0; i < N; i++) {
				visited[i] = 0;
			}
			
			// 인접배열 초기화
			for (int i = 1; i <= N ; i++) {
				for (int j = 1; j <= M; j++) {
					MAT[i][j] = 0;
				}
			}
			
			// 인접배열 정점간의 관계 지정
			for (int i = 1; i <= M; i++) {
				A = sc.nextInt();
				B = sc.nextInt();
				MAT[A][B] = 1;
			}
			
			// 인접배열 출력
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					System.out.print(MAT[i][j] + " ");
				}
				System.out.println();
			}
			
			// 그래프 탐색 - BFS(Breadth First Search)
			bfs();
			
			// 정점 방문 수
		}
	}
}
















