package prob.basic;

import java.util.Scanner;

/*
       *인접행렬 
	1부터 N까지의 번호가 있는 정점들과 이 정점들을 잇는 간선들로 이루어진 방향 그래프
	(directed graph)가 있다. 이 정점들 간의 관계를 인접 배열로 구성하여
	아래의 규칙대로 출력하는 프로그램을 작성하시오.
	
   [인접행렬 (인접배열)]
   - 각 줄에 N개의 숫자를 공백을 두고 N줄에 걸쳐 출력한다.
   - i번째 줄의 j번째 숫자에는 i번 정점과 j번 정점 사이에 
          직접 연결된 간선이 있을 경우 1을, 없을 경우 0을 출력한다.
	
	[입력]
	첫 번째 줄에 테스트케이스의 수( 1 ≤ T ≤ 50 )가 주어진다.
	각 테스트케이스마다 첫 번째 줄에 정점의 수 N과 간선의 수 M이 공백을 두고 주어진다.
	(1 ≤ N ≤ 100, 1 ≤ M ≤ min(2,000, Nx(N-1)) 두 번째 줄부터 M줄에 걸쳐 
	간선이 연결하는 두 개의  정점을 공백을 두고 주어진다. 단, 두 정점이 같은 값으로 주어지는
	경우는 없으며, 기존에 주어진 간선이 중복해서 다시 주어지는 경우는 없다.
	
	[출력]
	각 줄마다 "#T"를 출력한 뒤, 두 번째 줄부터 N줄에 걸쳐 인접배열을 출력한다.
 */
public class adjacencyMatrix {
	// 준비할 변수
	static int T, N, M, A, B;
	// 인접배열
	static int MAT[][] = new int[101][101];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			M = sc.nextInt();
			// 인접 배열 초기화
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					MAT[i][j] = 0;
				}
			}
			
			for (int i = 1; i <= M; i++) {
				A = sc.nextInt();
				B = sc.nextInt();
				MAT[A][B] = 1;
			}
			System.out.println("#" + test_case);
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					System.out.print(MAT[i][j] + " ");
				}
				System.out.println();
			}
		}
	}
}
















