package prob.datastructure;


/*
	[�迭]
	- �迭�̶� ��ȣ(index)�� �� ��ȣ�� �����ϴ� �����͵�� �̷���� �ڷᱸ���� ���Ѵ�.
*/
public class d2Array {
	static int arr[][];
	public static void main(String[] args) {
		arr = new int[3][2];
		arr[0][0] = 11;
		arr[0][1] = 12;
		arr[1][0] = 21;
		arr[1][1] = 22;
		arr[2][0] = 31;
		arr[2][1] = 32;
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
			
		}
	}
}
