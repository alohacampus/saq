package boj.prob.train;
/*
 	Q.�Ӹ����
 	�Ӹ������ �տ������� ���� ���� �ڿ������� ���� ���� �Ȱ��� �ܾ �ǹ��Ѵ�. 
 	���� ���, eve, eevee�� �Ӹ�����̰�, eeve�� �Ӹ������ �ƴϴ�. 
 	�ܾ �־����� ��, �Ӹ�������� �ƴ��� �Ǵ��غ���.
 	
 	[�Է�]
 	���̰� 20���� �۰ų� ���� �ܾ �־�����. �ܾ�� ���ĺ� �ҹ��ڷ� �̷���� �ִ�.
 	
 	[���]
 	�Է����� �־��� �ܾ �Ӹ�����̸� "true", �ƴϸ� "false"�� ����Ѵ�.
 */

import java.util.Scanner;

public class _13235 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		int length = input.length();
		boolean Answer = true;
		
		if(length == 1) System.out.println(Answer);
		else {
			for (int i = 0; i < length / 2; i++) {
				if( input.charAt(i) != input.charAt(length -1 -i) ) {
					Answer = false;
					break;
				}
				
			}
		}
		System.out.println(Answer);
	}
}













