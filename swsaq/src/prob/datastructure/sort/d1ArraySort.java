package prob.datastructure.sort;


/*
 	[1���� �迭 ����]
 	- Arrays.sort(�迭�̸�, ����index, ������index+1); �� ����Ͽ� �����ϸ�, ������������ ���ĵȴ�.
 	
 	(�������� ����)
 	Arrays.sort(�迭�̸�, ����index, ������index+1);
 	
 	(�������� ����)
 	- ���1 : �������� �����ϰ� index�� �������������� �Ųٷ� ����Ѵ�.
 	- ���2 : ��� ��ҿ� (-1)�� ���ϰ� �������� ���� �� �ٽ� (-1)�� ���Ѵ�.
 	
 */

import java.util.Arrays;
public class d1ArraySort {
	public static void main(String[] args) {
		int arr[] = new int[5];
		arr[0] = 3;
		arr[1] = 2;
		arr[2] = 1;
		
		// �ʱⰪ ���
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		
		// ������ ������ �ʰ� sort(����)�� ������ ���
		Arrays.sort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		
		// �迭 �ʱ�ȭ
		arr = new int[]{3,2,1,0,0};
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		// �ǵ��� ��� : 1, 2, 3
		// �迭�� ũ�Ⱑ 10�̱� ������ ������ ���� �������� sort�ϰ� �Ǹ�
		// { 0,0,1,2,3 } ���� ���ĵǱ� ������ sort�� �� ������ �������־���Ѵ�.
		
		
		// Arrays.sort(�迭�̸�, ����index, ������index+1);
		Arrays.sort(arr, 0, 3);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		
		// �迭 �ʱ�ȭ
		arr = new int[]{3,5,2,4,1};
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		// �������� ���� 
		// (���1)
		// - �������� ���� �� �ڿ��� ���� ����Ѵ�.
		Arrays.sort(arr, 0, arr.length);
		// #���1-��¹��1
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[arr.length-1 -i] +" "); 
		}
		System.out.println();
		
		// #���1-��¹��2
		for (int i = arr.length-1; i >= 0; i--) {
			System.out.print(arr[i] +" "); 
		}
		System.out.println();
		
		
		// �迭 �ʱ�ȭ
		arr = new int[]{3,5,2,4,1};
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		
		// �������� ����
		// (���2) - ��� ���� ��ȣ�� �� ����
		// ���� �迭�� ��� (-1)�� ���Ѵ�.
		for (int i = 0; i < arr.length; i++) 
			arr[i] = (-1)*arr[i];
		// (-1)�� ������ �迭�� �������� �����Ѵ�.
		Arrays.sort(arr, 0, arr.length);
		// �ٽ� (-1)�� ���� ���� ������ �ٲ۴�.
		for (int i = 0; i < arr.length; i++) 
			arr[i] = (-1)*arr[i];
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
		
	}
}

