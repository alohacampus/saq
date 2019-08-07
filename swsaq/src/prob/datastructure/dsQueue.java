package prob.datastructure;

import java.util.LinkedList;
import java.util.Queue;

/*
 	[ť(Queue)]
 	- ���� ���� �����Ͱ� ���� ������ �ڷᱸ��.
 	- ���Լ���(First In, First Out:FIFO), ��������(Last In, Last Out:LILO)�� ������ ������.
 	
 	*ť(Queue)�� Java ���� LikedList Ŭ������ Queue�� �ν��Ͻ�ȭ �Ͽ� ����Ѵ�.
 	
 	* [java lib - ť(Queue) ����(LikedList) ���� �޼ҵ�]
 	- add(data)
 		Queue�� ������ ����
 	
 	- poll()
 	 	Queue���� ������ Ȯ�� �� ����
 	
 	- peek()
 	 	Queue���� ������ Ȯ��
 	
 	- size()
 		Queue�� ũ�� ���
 	 
 	- clear()
 		Queue �ʱ�ȭ
 		
 	**Ȱ��
 	- �ʺ� �켱 Ž��(BFS, Breath-First Search) ����
 		ó���ؾ� �� ����� ����Ʈ�� �����ϴ� �뵵�� ť(Queue)�� ����Ѵ�.
 		��带 �ϳ� ó���� ������ �ش� ���� ������ ������ ť�� �ٽ� �����Ѵ�.
 		��带 ������ ������� ó���� �� �ִ�.
 */
public class dsQueue {
	static Queue<Integer> que;
	public static void main(String[] args) {
		// queue�� Likedlist Ŭ������ �����Ѵ�.
		que = new LinkedList<Integer>();
		// queue �ʱ�ȭ
		que.clear();
		// queue ������ 10, 20, 30 ����
		que.add(10);
		que.add(20);
		que.add(30);
		// queue�� size ���
		System.out.println("que.size : " + que.size());
		// queue���� ������ Ȯ��
		System.out.println("data(peek) : " + que.peek());
		// queue���� ������ Ȯ�� �� ����
		System.out.println("data(poll) : " + que.poll());
		System.out.println("data(poll) : " + que.poll());
		System.out.println("data(poll) : " + que.poll());
		// queue���� �ƹ��͵� ������ Ȯ��
		if(que.isEmpty())
			System.out.println("queue is empty");
		
	}
}
