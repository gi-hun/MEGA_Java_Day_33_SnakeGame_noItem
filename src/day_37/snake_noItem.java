/*
 * # ������ũ ����
 * 1. 10x10 �迭�� 0���� ä���.
 * 2. ������ũ�� 1234�� ǥ���Ѵ�.
 * 3. �����¿�� �̵��� �����ϸ�, ������ ����´�.
 * 4. �ڱ���ϰ� �ε�����, ����Ѵ�.
 */
package day_37;

//�ٽ�) �ε��� 0��°= ���ο� ���� ������.	������ �ε���) ���� �ε����� ���� ������.

import java.util.Scanner;

public class snake_noItem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int size=10;			int check=-1;
		int[][] map=new int[size][size];
		
		int[] x=new int[4];		int[] y=new int[4];		int[] snake=new int[4];
		
		for(int i=0;i<4;i++)
		{
			x[i]=i;
			map[y[i]][x[i]]=i+1;		//snake �����ش�
			snake[i]=map[y[i]][x[i]];	//snake�� ��ġ
		}
		
		while(true)
		{
			if(check==1)
			{
				System.out.println("�ڱ� ���� �ε������ϴ�.");
				System.out.println("������ũ ���� ����");
				break;
			}
			for(int i=0;i<size;i++)
			{
				for(int j=0;j<size;j++)
				{
					System.out.print(map[i][j]+" ");
				}
				System.out.println();
			}
			System.out.println();
			
			System.out.print("1)up 2)down 3)left 4)right: ");
			int select = sc.nextInt();
			
			int move_y =0;			int move_x =0;
			
			//ù��° �ε����� �Ű��ָ� ������ �ε������� �� �� �ε����� ���� �޴´�.
			if(select == 1)				//�� 
			{
				move_y = y[0]-1;	move_x = x[0];
			}
			else if(select == 2)				//�� 
			{
				move_y = y[0]+1;	move_x = x[0];
			}
			else if(select == 3) 				//��
			{
				move_y = y[0];		move_x = x[0]-1;
			}
			else if(select == 4) 				//��
			{
				move_y = y[0];		move_x = x[0]+1;
			}
			
			//map ���� �Ѿ����� ����
			if(move_x<0||move_y<0||move_x>size||move_y>size) {System.out.println("�Է��Ͻ� �������� �������� ���մϴ�.");continue;}
			
			
						
			// �̵��ϱ�
			// 0��° �ε����� ���� �����ֱ� ������ i=0�� �����Ѵ�
			// ������) ���� �ε����� �� ���ε��� �� ���� ������.
			for(int i=snake.length-1; i>0; i--)
			{
				y[i] = y[i - 1];	x[i] = x[i - 1];
			}
			
			// ȭ�� �ʱ�ȭ
			for(int i=0; i<size; i++) 
			{
				for(int j=0; j<size; j++) 
				{
					map[i][j] = 0;
				}
			}
			
			y[0] = move_y;
			x[0] = move_x;
			
			for(int i=1;i<snake.length;i++)
			{
				if(y[0]==y[i] && x[0]==x[i])
				{
					check=1;
				}
			}
						
			// �� ǥ��
			for(int i=0; i<snake.length; i++) 
			{
				map[y[i]][x[i]] = i + 1;
			}
		}
	}
}
