package wow.easy.ch202;

import java.util.Scanner;

public class ch202_solution {
	
	// �Է°��� �Է¹޴´�.
	// �Է¹��� ���� �����´�.
	// �Է¼��� ���������� ���Ѵ�.
	// �հ踦 ȸ������ �����Ѵ�.
	//  1. �Ϲݺ����� �հ踦 �迭���� ��´�.
	//  2. ���۰��� ������ ��ġ���� ������ break
	//  3.   �׷��� ������, ���۰�++, ����--
	//     ( ���۰� > ���� )
	 
	
	
	
	// �Է� ������ �����´�.       
	public static int reverse(int input) {
		// input : 123
		int reverse = 0;
		while( input != 0 ) {
			reverse = reverse*10 + (input % 10);
			input = input / 10;
		}
		
		return reverse;
	}
	
	
	// �Ϲݺ����� �迭������ ��´�.
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
	
	// ȸ������ �����Ѵ�.
	//  1. �Ϲݺ����� �հ踦 �迭���� ��´�.
	//  2. ���۰��� ������ ��ġ���� ������ break
	//  3.   �׷��� ������, ���۰�++, ����--
	//     ( ���۰� > ���� )
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
		// �Է°��� �Է¹޴´�.
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int input, reverse;
		int sum = 0;
		int[] arr = new int[8];
		int cnt = 0;
		boolean flag = true;
		
		
		for (int i = 0; i < T; i++) {
			input = sc.nextInt();
			// �Է¹��� ���� �����´�.
			reverse = reverse(input);
			// �Է¼��� ���������� ���Ѵ�.
			sum = input + reverse;
			// �հ踦 ȸ������ �����Ѵ�.
			// �Ϲݺ����� �迭���� ��´�.
			cnt = toArray( sum, cnt, arr);
			flag = isPalindrome(arr, cnt);
		}
		
		if( flag == false )
			System.out.println("no");
		else 
			System.out.println("yes");
		
	}
	
}

