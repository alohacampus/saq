package boj.pre.exam._14888;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

/*
 	[문제]
 	N개의 수로 이루어진 수열 A1, A2, ..., AN이 주어진다. 또, 수와 수 사이에 끼워넣을 수 있는 N-1개의 연산자가 주어진다. 
 	연산자는 덧셈(+), 뺄셈(-), 곱셈(×), 나눗셈(÷)으로만 이루어져 있다.
	우리는 수와 수 사이에 연산자를 하나씩 넣어서, 수식을 하나 만들 수 있다. 이때, 주어진 수의 순서를 바꾸면 안 된다.
	예를 들어, 6개의 수로 이루어진 수열이 1, 2, 3, 4, 5, 6이고, 주어진 연산자가 덧셈(+) 2개, 뺄셈(-) 1개, 곱셈(×) 1개, 나눗셈(÷) 1개인 경우에는 총 60가지의 식을 만들 수 있다. 예를 들어, 아래와 같은 식을 만들 수 있다.

	1+2+3-4×5÷6
	1÷2+3+4-5×6
	1+2÷3×4-5+6
	1÷2×3-4+5+6
	식의 계산은 연산자 우선 순위를 무시하고 앞에서부터 진행해야 한다. 또, 나눗셈은 정수 나눗셈으로 몫만 취한다. 음수를 양수로 나눌 때는 C++14의 기준을 따른다. 즉, 양수로 바꾼 뒤 몫을 취하고, 그 몫을 음수로 바꾼 것과 같다. 이에 따라서, 위의 식 4개의 결과를 계산해보면 아래와 같다.

	1+2+3-4×5÷6 = 1
	1÷2+3+4-5×6 = 12
	1+2÷3×4-5+6 = 5
	1÷2×3-4+5+6 = 7
	
	N개의 수와 N-1개의 연산자가 주어졌을 때, 만들 수 있는 식의 결과가 최대인 것과 최소인 것을 구하는 프로그램을 작성하시오.
	
	(입력)
	첫째 줄에 수의 개수 N(2 ≤ N ≤ 11)가 주어진다. 
	둘째 줄에는 A1, A2, ..., AN이 주어진다. (1 ≤ Ai ≤ 100) 
	셋째 줄에는 합이 N-1인 4개의 정수가 주어지는데, 
	차례대로 덧셈(+)의 개수, 뺄셈(-)의 개수, 곱셈(×)의 개수, 나눗셈(÷)의 개수이다. 
	
	(출력)
	첫째 줄에 만들 수 있는 식의 결과의 최댓값을, 
	둘째 줄에는 최솟값을 출력한다.
	(10억보다 크거나 같고, 10억보다 작거나 같은 결과가 나오도록 입력이 주어진다.)
	
 */
public class _14888 {
	
	
	static int N;  						// 입력 숫자의 개수
	static int [] arr;					// 입력 숫자 값
	static int [] op = new int[4];		// 연산자의 개수
	static ArrayList<Integer> list;		// 모든 연산 결과 list
	
	
	public static void dfs(int depth, int sum ) {
		
		// 연산자 개수 확인
		for (int i = 0; i < op.length; i++) {
			// 연산자 개수가 남아있으면
			if( op[i] != 0 ) {
				// 해당 연산자를 하나 쓸거니까 연산자 개수 -1감소
				op[i]--;
				// 연산자 구분 ( + : 0 , - : 1 , * : 2 , / : 3 )
				switch (i) {
				// + 	: sum = sum + arr[depth]
				case 0:	dfs(depth+1, sum + arr[depth]);
						break;
				// - 	: sum = sum - arr[depth]
				case 1:	dfs(depth+1, sum - arr[depth]);
						break;
				// * 	: sum = sum * arr[depth]
				case 2:	dfs(depth+1, sum * arr[depth]);
						break;
				// / 	: sum = sum / arr[depth]
				case 3:	dfs(depth+1, sum / arr[depth]);
						break;

				}
				// 다음 케이스를 위해서 연산가 개수 원복
				op[i]++;
			}
		}
		
		if( depth == N ) {
			// 계산결과를 리스트에 담는다
			list.add(sum);
		}
		
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];
		list = new ArrayList<Integer>();
		
		// 숫자 입력
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		// 연산자의 개수 입력
		for (int i = 0; i < op.length; i++) {
			op[i] = sc.nextInt();
		}
		
		
		// dfs 탐색을 통해 연산  
		// 종료조건 depth == N 
		int depth = 1;
		dfs( depth, arr[0] );
		
		// 리스트 정렬
		Collections.sort(list);
		int max = list.get(list.size() -1);	// 최댓값
		int min = list.get(0);				// 최솟값
		
		System.out.println(max);
		System.out.println(min);
		
	}
}
















