/*

���⣺��־ͳ��

С��ά����һ������Ա��̳���������ռ���һ��"����"��־����־����N�С�����ÿһ�еĸ�ʽ�ǣ�

ts id  

��ʾ��tsʱ�̱��id�������յ�һ��"��"��  

����С����ͳ������Щ����������"����"�����һ��������������һ������ΪD��ʱ������յ�������K���ޣ�С������Ϊ�����������"����"��  

������˵���������ĳ��ʱ��T���������[T, T+D)���ʱ����(ע��������ҿ�����)�յ�������K���ޣ�����������"����"��  [1,12) 

������־���������С��ͳ�Ƴ���������"����"�����ӱ�š�  

�������ʽ��
��һ�а�����������N��D��K��  
����N��ÿ��һ����־��������������ts��id��  

����50%�����ݣ�1 <= K <= N <= 1000  
����100%�����ݣ�1 <= K <= N <= 100000 0 <= ts <= 100000 0 <= id <= 100000  

�������ʽ��
����С�����˳���������id��ÿ��idһ�С�  

������������
7 10 2  
0 1  
0 10    
10 10  
10 1  
9 1
100 3  
100 3  

�����������
1  
3  

��ԴԼ����
��ֵ�ڴ����ģ���������� < 256M
CPU����  < 1000ms


���ϸ�Ҫ���������Ҫ��������ش�ӡ���ƣ�����������...�� �Ķ������ݡ�

���д������ͬһ��Դ�ļ��У�����ͨ���󣬿����ύ��Դ�롣
��Ҫʹ��package��䡣��Ҫʹ��jdk1.7�����ϰ汾�����ԡ�
��������ֱ����ǣ�Main��������Ч���봦��
 */
/*
�Ƚ���ͬid������ �����յ��޵�ʱ�䱣������
Ҫ�õ�һ�Զ�ṹ
id	ts
1	0	9	10	
3	100	100
10	0	10
Ȼ��ö��ÿһ�����ܵ�ʱ���T  ͳ��[T,T+D)ʱ���ڵ������Ƿ񳬹�K
01�������ܼ�ֵҪ�ﵽ��ֵV ������������W
	����Ҫ�ﵽK	ʱ����������D			

ע��� ��
1��Ҫ���С�����˳���������id
 */
package �ھŽ�;

import java.util.Arrays;
import java.util.Scanner;

/**
* @author JohnnyLin
* @version Creation Time��2020��5��30�� ����2:48:40
* ��˵��
*/
public class t08_��־ͳ��2 {
	//record����ÿ����¼��Ӧ��ʱ���id
	//recordʵ��comparable�ӿ� ��ʵ��ÿ����¼������
	public static class record implements Comparable<record>{
		int id,ts;
		record(int id,int ts){
			this.id=id;
			this.ts=ts;
		}
		//��дcompareTo���� �Ȱ�id�Ƚ� ��ͬid��ts��
		@Override
		public int compareTo(record o) {
			if(this.id==o.id)
				return this.ts-o.ts;
			else
				return this.id-o.id;
		}
		
	}
	public static void main(String[] args) {
		Scanner reader=new Scanner(System.in);
		int N=reader.nextInt();
		int D=reader.nextInt();
		int K=reader.nextInt();
		//����һ�����ÿһ�����޼�¼������
		record blog[]=new record[N];
		boolean flag[]=new boolean[100000];
		for(int i=0;i<N;i++) {
			int ts=reader.nextInt();
			int id=reader.nextInt();
			//ÿһ��blog[i]��Ӧ���һ����¼
			blog[i]=new record(id,ts);
		}
		Arrays.sort(blog);
		/*
		 * ������֮��
		 	1 0
			1 9
			1 10
			3 100
			3 100
			10 0
			10 10
		 */
//		for(int i=0;i<N;i++) {
//			System.out.println(blog[i].id+" "+blog[i].ts);
//			
//		}
		for(int i=0;i+K-1<N;i++) {
			int id = blog[i].id;
			int next=i+K-1;
			
			//���Ҫ�����٣������K-1��������Ȼ����ͬid ��ʱ������D��Χ��
			if(!flag[id]&&blog[ next].id==id&& (blog[next].ts-blog[i].ts)<D) {
				flag[id]=true;
				System.out.println(id);
			}
		}

	}
	

}
