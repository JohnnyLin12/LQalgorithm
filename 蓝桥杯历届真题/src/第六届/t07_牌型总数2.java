package ������;

public class t07_��������2 {
	static int ans;
	static void dfs(int index,int cnt) {
		//���ز��Ϸ�����
		if(index>13)return;
		if(index==13&& cnt==13) {
			ans++;
			return;
		}
		//ÿ��������5��ѡ�� �ֱ�Ϊ0 1 2 3 4����
		for(int i=0;i<5;i++) {
			//��������ѡ��i�� ׼��ѡ��һ����
			dfs(index+1,cnt+i);
		}
		
	}
	public static void main(String[] args) {
		dfs(0,0);
		System.out.println(ans);

	}

}
