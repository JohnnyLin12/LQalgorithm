
/*��Ŀ����

����������

�۲����������,ĳ�����ֵ���������λ�ۼ���Ȼ��������
1^3 = 1 
8^3  = 512    5+1+2=8
17^3 = 4913   4+9+1+3=17
...

����������1,8,17���ڣ�����������ʵ�������һ���ж��ٸ���

����д�����֣���Ҫ��д�κζ�������ݻ�˵���Ե����֡�
 �𰸣�6
1 1
8 8
17 17
18 18
26 26
27 27
 */
package ������;

public class t02_���������� {
	static int sum(int i) {
		String s=String.valueOf(i);
		int res=0;
		//��λ���
		for(int j=0;j<s.length();j++) {
			res=res+(s.charAt(j)-'0');
		}
		//System.out.println("i="+i+" "+res);
		return res;
	}
	public static void main(String[] args) {
		//������ѧ���� ������һ���ʵ����������ᳬ��99
		int cnt=0;
		for(int i=1;i<99;i++) {
			int i1=i*i*i;
			if(sum(i1)==i) {
				cnt++;
				System.out.println(i+" "+sum(i1));
			}
		}
		System.out.println(cnt);
	}

}
