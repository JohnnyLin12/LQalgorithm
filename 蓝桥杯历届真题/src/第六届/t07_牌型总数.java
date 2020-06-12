/*
牌型种数

小明被劫持到X赌城，被迫与其他3人玩牌。
一副扑克牌（去掉大小王牌，共52张），均匀发给4个人，每个人13张。
这时，小明脑子里突然冒出一个问题：
如果不考虑花色，只考虑点数，也不考虑自己得到的牌的先后顺序，自己手里能拿到的初始牌型组合一共有多少种呢？
 */
package 第六届;

public class t07_牌型总数 {
	//有13种牌 A-K 每种牌可以选择0-4张
	//type数组索引+1表示点数 元素值为个数
	static int []type=new int[13];
	static int ans;
	static void dfs(int index) {
		//当枚举到最后一种牌 开始计算已经拿到牌的数量
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
