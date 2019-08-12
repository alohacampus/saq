package prob.basic.dfs;

import java.util.Scanner;

/*
 	Q. 순열 출력하기
 	1부터 N까지의 수를 임의로 배열한 순열을 앞 수를 우선하여
 	오름차순 순서대로 출력하는 프로그램을 작성하시오.
 	 
 	예를 들어, N=3 인 경우 {1,2,3}, {1,3,2}, {2,1,3}, {3,1,2}, {3,1,2}의 순서로
 	생각할 수 있다. 첫 번째 수가 작은 것이 순서상에서 앞서며, 첫 번째 수가 같으면 두 번째 수가 작은 것이
 	두 번째 수도 같으면 세 번째 수가 작은 것을 먼저 출력한다.
 	
 	[입력]
 	첫 번째 줄에 테스트케이스 수 T(1 ≤ T ≤ 5)가 주어진다.
 	각 테스트케이스마다 숫자의 범위 N(3 ≤ N ≤ 6)가 주어진다.
 	
 	[출력]
 	각 줄마다 "#T"(T는 테스트케이스 번호)를 출력한 뒤, 두 번째 부터 N!(Nx(N-1)x...x1)
 	줄에 걸쳐 순열을 순서대로 출력한다. 순열은 각 숫자 사이에 공백을 두고 출력한다.
 	
 	(입력예시)
 	1
 	3
 	
 	(출력예시)
 	#1
 	1 2 3
 	1 3 2
 	2 1 3
 	2 3 1
 	3 1 2
 	3 2 1
 */

public class dfsPermutation {
	// 입력에 필요한 변수
	static int T, N;
	// i번째 숫자를 이미 선택했는지 여부를 체크할 배열
	// i숫자를 이미 선택한 경우 visited[i]= = 1
	// i숫자를 아직 선택하지 않은 경우 visited[1] = 0
	static int visited[] = new int[7];
	static int Answer[] = new int[7];
	
	public static void dfs(int depth) {
		// 종료조건
		if( depth == N + 1 ) {
			for (int i = 1; i <= N; i++) {
				System.out.print(Answer[i] + " ");
			}
			System.out.println();
		} 
		// 탐색조건 
		else {
			for (int i = 1; i <= N; i++) {
				// 아직 선택하지 않은 숫자i를 고른다.
				if(visited[i] == 0) {
					visited[i] = 1;
					Answer[depth] = i;
					dfs(depth + 1);
				// 탐색이 끝나면 숫자 i를 선택하기 전 상황으로 원복
					visited[i] = 0;
					Answer[depth] = 0;
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			// visited배열 초기화
			for (int i = 1; i <= N; i++) {
				visited[i] = 0;
			}
			System.out.println("#" + test_case);
			dfs(1);
		}
	}
}












