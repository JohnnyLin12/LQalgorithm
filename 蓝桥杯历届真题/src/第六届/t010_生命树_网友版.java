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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class t010_������_���Ѱ� {
	static int[] nodeValue;//��Ÿ�����ĺ�гֵ
	static List<Integer>[] point;//��Ÿ�����İ������ڽӱ�
	static int[] value;//�����ĳ����Ϊ���ڵ�����µ�����гֵ��
	static int ans=0;//��¼�����
	static void dfs(int son,int father) {
		value[son]=nodeValue[son];//��sonΪ���ڵ㣬һ��ʼʱ������гֵΪ������
		for(int i=0;i<point[son].size();i++) {//ö����son�����Ľ��
			int next=point[son].get(i);
			//��ö�ٵ���һ�������son��ǰ�����ĵ�father ���� ��ֹ��Ȧ
			if(next==father)continue;//�����continue��˵���������Ҷ�ӽ��
			dfs(next,son);
			//���ݣ��ӽڵ�ƽ��״̬������û�����˻���˵״̬û��ת���˲Ż���ݣ��õ����ڵ����ӽڵ��
			if(value[next]>0)//�ӽڵ�ĺ�гֵ
				value[son]+=value[next];
			ans=Math.max(ans, value[son]);
		}
		
	}
	public static void main(String[] args) throws FileNotFoundException {
		//��������
		System.setIn(new FileInputStream(new File("src/data/in2.txt") ) );
		
		Scanner reader=new Scanner(System.in);
		int n=reader.nextInt();
		nodeValue=new int [n+1];
		value=new int[n+1];
		point=new LinkedList[n+1];
		for(int i=1;i<=n;i++) {
			nodeValue[i]=reader.nextInt();
			point[i]=new LinkedList();
		}
		for(int i=1;i<n;i++) {
			int x=reader.nextInt();
			int y=reader.nextInt();
			point[x].add(y);
			point[y].add(x);
		}
		dfs(1,-1);//��0�Ž�㿪ʼ���� �������ĸ��ڵ�Ϊ-1����Ϊ�������޹���
		System.err.println(ans);
	}

}
