package wow.easy.ch202;

import java.util.Scanner;


/*
	1. ����
		��� ���ڸ� ������ ��� �����ϴ� �����̴� ���ڸ� ���� ���ϰ� ������ ��ٰ� ����ִ�
		������ �߰��ߴ�. ���� 120�� ����� �迭�ϸ� 021�� �Ǵµ�, ���� ���ڸ� ������ ���ڸ�
		���ϸ� 141( =120 + 021)�� �ȴ�. ���� ����� 141�� ������ ������ �ڷ� ������ ���� ����
		�� �ȴٴ� ���̴�. �̷��� ������ ������ �ڷ� ������ ���� ���� ȸ��( Palindrome ) �̶��
		�ϴµ�, ������ �־����� ��, ������ ������ ������ ��� ������ ���ڰ� ȸ���� �Ǵ��� �Ǵ�
		�ϴ� ���α׷��� ������.
		
	2. ���� ����
		�־��� ������ ȸ���� �Ǵ��� �Ǵ��Ͽ���.
		
	3. �������
		�־��� ���� N�� 0 �� N �� 10,000,000 �̴�.
	
	4. �Է� �� ��� ����
	(1) �Է�
	ù ��° �ٿ� �ԷµǴ� �׽�Ʈ ���̽� �� T( 1 �� T �� 1,000 )�� �Է��Ѵ�.
	�� ��° �ٺ��� T+1���� �ٱ��� �� �ٿ� �ϳ��� ���� N(0 �� N �� 10,000,000)�� �־�����.
	
	(�Է� ��)
	3
	121
	120
	46

	(3) ���
	�� �ٿ� �ϳ���, �Էµ� ������ ������ ������ ��, ȸ���� �Ǵ��� Ȯ���Ѵ�. ȸ���� �Ǹ� yes, �׷��� ������ no�� ����Ѵ�.
	
	(��� ��)
	yes
	yse
	no
	
 */
public class ch202_palindrome {
	
	// ������ ������ �ִ� �޼ҵ�
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
	
	// ȸ������ �����ϴ� �Լ�
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
	
	// ������ �� �ڸ��� ���Ͽ� �迭�� �����ϴ� �Լ�
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
		boolean flag = true;		// ȸ�� �Ǵ� �� 0�̸� ȸ��, 1�̸� ȸ�� �ƴ�
		int arr[] = new int[10];
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		while(T-- != 0) {
			N = sc.nextInt();
			reverseN = 0;
			// �Էµ� ������ �������� ���� ���Ѵ�.
			reverseN = reverse(N);
			
			// (�Է� ����) + (�������� ����)
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














