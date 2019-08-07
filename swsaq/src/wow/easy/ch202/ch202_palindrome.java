package wow.easy.ch202;

import java.util.Scanner;


/*
	1. 문제
		평소 숫자를 가지고 놀기 좋아하는 종섭이는 숫자를 쓰고 더하고 뒤집고 놀다가 재미있는
		성질을 발견했다. 수자 120을 뒤집어서 배열하면 021이 되는데, 원래 숫자를 뒤집은 숫자를
		더하면 141( =120 + 021)이 된다. 합한 결과인 141은 앞으로 읽으나 뒤로 읽으나 같은 숫자
		가 된다는 것이다. 이렇게 앞으로 읽으나 뒤로 읽으나 같은 것을 회문( Palindrome ) 이라고
		하는데, 정수가 주어졌을 때, 정수를 뒤집어 더했을 경우 더해진 숫자가 회문이 되는지 판단
		하는 프로그램을 만들자.
		
	2. 문제 제시
		주어진 정수가 회줌이 되는지 판단하여라.
		
	3. 제약사항
		주어진 정수 N은 0 ≤ N ≤ 10,000,000 이다.
	
	4. 입력 및 출력 형태
	(1) 입력
	첫 번째 줄에 입력되는 테스트 케이스 수 T( 1 ≤ T ≤ 1,000 )를 입력한다.
	두 번째 줄부터 T+1번재 줄까지 한 줄에 하나씩 정수 N(0 ≤ N ≤ 10,000,000)이 주어진다.
	
	(입력 예)
	3
	121
	120
	46

	(3) 출력
	한 줄에 하나씩, 입력된 정수를 뒤집어 더했을 때, 회문이 되는지 확인한다. 회문이 되면 yes, 그렇지 않으면 no를 출력한다.
	
	(출력 예)
	yes
	yse
	no
	
 */
public class ch202_palindrome {
	
	// 정수를 뒤집어 주는 메소드
	public static int reverse(int n) {
		// 131
		int tmp = n;
		int rev = 0;
		while( tmp != 0 ) {
			rev = rev * 10 + tmp % 10; 		// rev : 1    /  10 + 3   /  130 + 1
			tmp /= 10;						// rev : 13   /  1        /  0
		}
		// 131
		return rev;
	}
	
	// 회문인지 검증하는 함수
	public static boolean isPalindrome(int [] arr, int cnt) {
		int start = 0;
		int end = cnt - 1;
		boolean flag = true;
		
		while(start <= end) {
			if(arr[start] != arr[end]) {
				flag = false;
				break;
			}
			else {
				start++;
				end--;
			}
		}
		return flag;
	}
	
	// 정수의 각 자리를 구하여 배열에 저장하는 함수
	public static int divN(int n, int cnt, int [] arr) {
		int tmp = n;
		while(tmp != 0) {
			arr[cnt] = tmp % 10;
			tmp /= 10;
			cnt++;
		}
		return cnt;
	}
	
	public static void main(String[] args) {
		int T;  				
		int N;				
		int reverseN;
		int sum;
		int cnt = 0;
		boolean flag = true;		// 회문 판단 후 0이면 회문, 1이면 회문 아님
		int arr[] = new int[10];
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		while(T-- != 0) {
			N = sc.nextInt();
			reverseN = 0;
			// 입력된 숫자의 리버스된 수를 구한다.
			reverseN = reverse(N);
			
			// (입력 정수) + (리버스된 정수)
			sum = N + reverseN;
			
			cnt = 0;
			cnt = divN(sum, cnt, arr);
			
			flag = isPalindrome(arr, cnt);
			if(flag == false)
				System.out.println("no");
			else
				System.out.println("yes");
		}
		
	}
}














