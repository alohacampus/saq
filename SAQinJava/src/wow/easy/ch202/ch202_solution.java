package wow.easy.ch202;

import java.util.Scanner;

public class ch202_solution {
	
	// 입력값을 입력받는다.
	// 입력받은 수를 뒤집는다.
	// 입력수와 리버스수를 더한다.
	// 합계를 회문인지 검증한다.
	//  1. 일반변수인 합계를 배열변수 담는다.
	//  2. 시작값과 끝값이 일치하지 않으면 break
	//  3.   그렇지 않으면, 시작값++, 끝값--
	//     ( 시작값 > 끝값 )
	 
	
	
	
	// 입력 정수를 뒤집는다.       
	public static int reverse(int input) {
		// input : 123
		int reverse = 0;
		while( input != 0 ) {
			reverse = reverse*10 + (input % 10);
			input = input / 10;
		}
		
		return reverse;
	}
	
	
	// 일반변수를 배열변수에 담는다.
	public static int toArray(int sum, int cnt, int[] arr){
		// sum,  cnt, arr
		// 456    0    []
		while( sum != 0 ) {
			arr[cnt] = sum % 10;		// 6    5   4
			sum /= 10;					// 45   4   0
			cnt++;						//  1   2   3
		}
		return cnt;
	}
	
	// 회문인지 검증한다.
	//  1. 일반변수인 합계를 배열변수 담는다.
	//  2. 시작값과 끝값이 일치하지 않으면 break
	//  3.   그렇지 않으면, 시작값++, 끝값--
	//     ( 시작값 > 끝값 )
	public static boolean isPalindrome(int[] pal, int cnt) {
		boolean flag = true;
		int start = 0;
		int end = cnt-1;
		// [0][1][2]
		//  4  5  6
		while( start <= end ) {
			if( pal[start] != pal[end] ) {
				flag = false;
				break;
			} else {
				start++;
				end--;
			}
		}
		return flag;
	}
	
	public static void main(String[] args) {
		// 입력값을 입력받는다.
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int input, reverse;
		int sum = 0;
		int[] arr = new int[8];
		int cnt = 0;
		boolean flag = true;
		
		
		for (int i = 0; i < T; i++) {
			input = sc.nextInt();
			// 입력받은 수를 뒤집는다.
			reverse = reverse(input);
			// 입력수와 리버스수를 더한다.
			sum = input + reverse;
			// 합계를 회문인지 검증한다.
			// 일반변수를 배열변수 담는다.
			cnt = toArray( sum, cnt, arr);
			flag = isPalindrome(arr, cnt);
		}
		
		if( flag == false )
			System.out.println("no");
		else 
			System.out.println("yes");
		
	}
	
}

