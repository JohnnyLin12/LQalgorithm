package 搜索类;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class 九宫重排 {

	public static void main(String[] args) {
		Scanner reader=new Scanner(System.in);
		String first=reader.next();
		String last=reader.next();
		
		if(first.equals(last)) {
			System.out.println(0);
			return;
		}
		
		int []dir= {-3,-1,3,1};
		Queue<String> q=new LinkedList<String>();
		Set<String> set=new HashSet<>();
	
		int ans=0;
		q.offer(first);
		set.add(first);
		
		while(!q.isEmpty()) {		
			int size=q.size();//同一层（相同步数到达的状态）的个数
			for(int i=0;i<size;i++) {
				String grid=q.poll();
				
				int index=grid.indexOf('.');
						
				for(int j=0;j<4;j++) {
					if((index%3==0&&j==1)||(index%3==2&&j==3)) {
					continue;}
					int newIndex=index+dir[j];
					if(newIndex>=0&&newIndex<=8) {
				
						char []array=grid.toCharArray();
						
						char temp=array[index];
						array[index]=array[newIndex];
						array[newIndex]=temp;
						//String s=array.toString(); Index -1 out of bounds for length 11
						String s=new String(array);
						
						
						if(s.equals(last)) {
							System.out.println(ans+1);
							System.exit(0);
						}else if(!set.contains(s)) {
							q.offer(s);
							set.add(s);
							
						}
				
					}
				}
			}
			ans++;
		}
		System.out.println(-1);
	}

}
