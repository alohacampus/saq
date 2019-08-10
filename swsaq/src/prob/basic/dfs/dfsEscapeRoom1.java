package prob.basic.dfs;

import java.util.Scanner;

/*
 	Q.방탈출게임1
 	  가원이는 방탈출게임 지역대회에 참가하였다. 이 게임은 1부터 N번까지 번호가 매겨진
 	 N개의 방 앞에서 출구를 찾아가는 게임이다. N번째 방을 제외한 각 방마다 하나의 포탈을
 	 가지고 있고, 이 포탈을 통해서만 방과 방 사이를 이동할 수 있다. 포탈은 단방향으로만
 	 이동이 가능하며 포탈을 한 번 이용하 때마다 100점의 점수를 얻게 된다. 게임을 시작하는
 	 방은 출구인 M번째 방을 제외한 어떤 방에서든 시작할 수 있다. 가원이가 이 게임에서 얻을
 	 수 있는 최대 점수를 출력하는 프로그램을 작성하시오.
 	 
 	 [제한조건]
 	 - i번째 방의 포탈을 a(i)번째 방으로 이동하는데 이 때 a(i)의 값은 i < a(i) ≤ N을 만족한다.
 	 - 포탈을 지나면서 얻은 점수는 출구인 N번째 방에 도달한 경우에만 점수로 인정한다.
 	 - 포탈은 단방향으로마 이동이 가능하다. 즉 i번째 방에서 a(i)번째 방으로 이동은 가능하지만,
 	   a(i)번째 방에서 i번째 방으로의 이동은 불가능하다.
 	   
 	 [입력]
 	  첫 번째 줄에 테스트케이스 수 T(1 ≤ T ≤ 10)가 주어진다.
 	 각 테스트케이스의 첫 번째 줄에는 방의 수 N(3 ≤ N ≤ 10^3)과 출구 M(2 ≤ M ≤ N)
 	 이 공백을 주고 주어진다.
 	  다음 줄에는 1번방부터 N-1번째 방에 있는 포탈로 이동 할 수 있는 방 번호 a(i) (i < a(i) ≤ N)가
 	 공백을 두고 주어진다.
 	 
 	 [출력]
 	 각 줄마다 "#T(T는 테스트케이스 번호)를 출력한 뒤, 공백을 두고 가원이가 얻을 수 있는
 	 최대점수를 출력한다. 만약, 출구로 갈 방법이 없다면 -1을 출력한다.
 	 
 	 (입력예시)
 	 1
 	 8 4
 	 2 4 4 6 6 9 9
 	 
 	 (출력예시)
 	 #1 2
 	
 */

public class dfsEscapeRoom1 {
	static int T, N, M;
	// P[i] : i번째 방의 포탈
	static int P[] = new int[3001];
	static int Answer;
	 
	public static void dfs(int idx, int sum) {
		// 종료조건
		if( idx == M ) { // 가지치기
			if(sum > Answer) {
				Answer = sum;
			}
		}
		// 탐색조건
		else {
			if (P[idx] <= M) {
				dfs(P[idx], sum + 1);
			}
		}
		   
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			M = sc.nextInt();
			for (int i = 1; i <= N - 1; i++) {
				P[i] = sc.nextInt();
			}
			// 출구를 찾지 못한다면 -1
			Answer = -1;
			// i번째 포탈은 i보다 큰 방으로 이동하므로
			// 출구보다 큰 방번호는 살펴볼 필요가 없다
			for (int i = 1; i <= M; i++) {
				dfs(i, 0);
			}
			System.out.println("#" + test_case + " " + Answer);
		}
	}
	
}














