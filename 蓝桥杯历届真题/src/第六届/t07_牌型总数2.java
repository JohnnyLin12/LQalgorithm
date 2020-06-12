package 第六届;

public class t07_牌型总数2 {
	static int ans;
	static void dfs(int index,int cnt) {
		//返回不合法数据
		if(index>13)return;
		if(index==13&& cnt==13) {
			ans++;
			return;
		}
		//每种牌型有5种选择 分别为0 1 2 3 4张牌
		for(int i=0;i<5;i++) {
			//该种牌型选了i张 准备选下一种牌
			dfs(index+1,cnt+i);
		}
		
	}
	public static void main(String[] args) {
		dfs(0,0);
		System.out.println(ans);

	}

}
