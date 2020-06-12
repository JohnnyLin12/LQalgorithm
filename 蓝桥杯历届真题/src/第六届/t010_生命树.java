/*��������
����֮��

��Xɭ����ϵ۴���������֮����

����ÿ������ÿ���ڵ㣨Ҷ��Ҳ��Ϊһ���ڵ㣩�ϣ�������һ�����������������ĺ�гֵ��
�ϵ�Ҫ���������ѡ��һ���ǿսڵ㼯S��ʹ�ö���S�е�����������a,b��
������һ������ {a, v1, v2, ..., vk, b} 
ʹ����������е�ÿ���㶼��S�����Ԫ�أ����������������������һ����������
�����ǰ���£��ϵ�Ҫʹ��S�еĵ�����Ӧ�������ĺ;�����
������ĺ;����ϵ۸�����֮�������֡�
����atm��Ŭ�������Ѿ�֪�����ϵ۸�ÿ������ÿ���ڵ��ϵ�������
�������� atm ���ó����㣬����֪��������Ч�������֡�����Ҫ��Ϊ��дһ������������һ�����ķ�����

�������ʽ��
��һ��һ������ n ��ʾ������� n ���ڵ㡣
�ڶ��� n �����������α�ʾÿ���ڵ�����֡�
������ n-1 �У�ÿ�� 2 ������ u, v����ʾ����һ�� u �� v �ıߡ���������һ�����������ǲ����ڻ��ġ�

�������ʽ��
���һ��һ��������ʾ�ϵ۸�������ķ�����

���������롹
5
1 -2 -3 4 5
4 2
3 1
1 2
2 5

�����������
8

�����ݷ�Χ��
���� 30% �����ݣ�n <= 10
���� 100% �����ݣ�0 < n <= 10^5, ÿ���ڵ�����ֵľ���ֵ������ 10^6 ��

��ԴԼ����
��ֵ�ڴ����ģ���������� < 256M
CPU����  < 3000ms
 */
package ������;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class t010_������ {
	static List<Integer> [] g;
	static int n;
	static int[] weight;
	static int ans=Integer.MIN_VALUE;
	//�޸���ת�и��� �����Ȩֵ��
	static void dfs(int root,int father) {
		//System.out.println(root);
		//������root���ڵĽ��
		for(int i=0;i<g[root].size();i++) {
			Integer son = g[root].get(i);
			//���ڽ��Ϊ���ڵ�
			if(son==father) continue;
			dfs(son,root);
			if(weight[son]>0) {//������Ȩֵ�����������������
				weight[root]+=weight[son];
			}
		}
		if(ans<weight[root])
			ans=weight[root];
	}
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Scanner reader=new Scanner(System.in);
		//������
		 n=reader.nextInt();
		
		 //��Ŷ�����б�
		g=new LinkedList[n+1];
		//�洢��гֵ
		weight=new int[n+1];
		int x=0,y=0;
		for(int i=1;i<=n;i++) {
			weight[i]=reader.nextInt();
			//����n������
			g[i]=new LinkedList<Integer>();
		}
		for(int i=1;i<n;i++) {
			x=reader.nextInt();
			y=reader.nextInt();
			g[x].add(y);
			g[y].add(x);
		}
		dfs(1,0);
		System.out.println(ans);
	}

}
