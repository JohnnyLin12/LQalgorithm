/*
��������

С�����ٳֵ�X�ĳǣ�����������3�����ơ�
һ���˿��ƣ�ȥ����С���ƣ���52�ţ������ȷ���4���ˣ�ÿ����13�š�
��ʱ��С��������ͻȻð��һ�����⣺
��������ǻ�ɫ��ֻ���ǵ�����Ҳ�������Լ��õ����Ƶ��Ⱥ�˳���Լ��������õ��ĳ�ʼ�������һ���ж������أ�
 */
package ������;

public class t07_�������� {
	//��13���� A-K ÿ���ƿ���ѡ��0-4��
	//type��������+1��ʾ���� Ԫ��ֵΪ����
	static int []type=new int[13];
	static int ans;
	static void dfs(int index) {
		//��ö�ٵ����һ���� ��ʼ�����Ѿ��õ��Ƶ�����
		if(index==13) 
		{
			int sum=0;
			for(int i=0;i<13;i++) {
				sum+=type[i];
			}
			if(sum==13) {
				ans++;	
			}
			return;
		}
		for(int i=0;i<=4;i++) {
			type[index]=i;
			dfs(index+1);
		}
	
		
	}
	public static void main(String[] args) {
		dfs(0);
		System.out.println(ans);
		
		
	}

}
