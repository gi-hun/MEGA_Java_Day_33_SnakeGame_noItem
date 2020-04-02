/*
 * # 스네이크 게임
 * 1. 10x10 배열을 0으로 채운다.
 * 2. 스네이크는 1234로 표시한다.
 * 3. 상하좌우로 이동이 가능하며, 꼬리가 따라온다.
 * 4. 자기몸하고 부딪히면, 사망한다.
 */
package day_37;

//핵심) 인덱스 0번째= 새로운 값을 가진다.	나머지 인덱스) 그전 인덱스의 값을 가진다.

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
			map[y[i]][x[i]]=i+1;		//snake 보여준다
			snake[i]=map[y[i]][x[i]];	//snake의 위치
		}
		
		while(true)
		{
			if(check==1)
			{
				System.out.println("자기 몸에 부딪혔습니다.");
				System.out.println("스네이크 게임 종료");
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
			
			//첫번째 인덱스만 옮겨주면 나머지 인덱스들은 그 전 인덱스의 값을 받는다.
			if(select == 1)				//상 
			{
				move_y = y[0]-1;	move_x = x[0];
			}
			else if(select == 2)				//하 
			{
				move_y = y[0]+1;	move_x = x[0];
			}
			else if(select == 3) 				//좌
			{
				move_y = y[0];		move_x = x[0]-1;
			}
			else if(select == 4) 				//우
			{
				move_y = y[0];		move_x = x[0]+1;
			}
			
			//map 범위 넘었을때 조건
			if(move_x<0||move_y<0||move_x>size||move_y>size) {System.out.println("입력하신 방향으로 움직이지 못합니다.");continue;}
			
			
						
			// 이동하기
			// 0번째 인덱스는 값을 정해주기 때문에 i=0을 제외한다
			// 나머지) 현재 인덱스는 그 전인덱스 의 값을 가진다.
			for(int i=snake.length-1; i>0; i--)
			{
				y[i] = y[i - 1];	x[i] = x[i - 1];
			}
			
			// 화면 초기화
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
						
			// 뱀 표시
			for(int i=0; i<snake.length; i++) 
			{
				map[y[i]][x[i]] = i + 1;
			}
		}
	}
}
