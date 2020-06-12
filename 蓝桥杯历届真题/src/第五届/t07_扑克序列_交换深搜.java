/*
/*
标题：扑克序列

A A 2 2 3 3 4 4， 一共4对扑克牌。请你把它们排成一行。
要求：两个A中间有1张牌，两个2之间有2张牌，两个3之间有3张牌，两个4之间有4张牌。

请填写出所有符合要求的排列中，字典序最小的那个。

例如：22AA3344 比 A2A23344 字典序小。当然，它们都不是满足要求的答案。


请通过浏览器提交答案。“A”一定不要用小写字母a，也不要用“1”代替。字符间一定不要留空格。
 */
/*
 dfs全排列+check剪枝
 
 */
package 第五届;

public class t07_扑克序列_交换深搜 {
	
	static void dfs(char[] pork,int index) {
		//System.out.println(s+" "+cnt);
		if(index==8) {
			String s=new String(pork);
			if(check(s)) {
				System.out.println(s);
				
			}
			return;
		}
		for(int i=index;i<8;i++) {
			char c=pork[index];
			pork[index]=pork[i];
			pork[i]=c;
			
			dfs(pork,index+1);
			
			c=pork[i];
			pork[i]=pork[index];
			pork[index]=c;
		}
		
		
	}

	private static boolean check(String s) {
		if(s.lastIndexOf('A')-s.indexOf('A')==2&&
			s.lastIndexOf('2')-s.indexOf('2')==3&&
			s.lastIndexOf('3')-s.indexOf('3')==4&&
			s.lastIndexOf('4')-s.indexOf('4')==5) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		char[] pork= {'2','2','3','3','4','4','A','A'};
		dfs(pork,0);

	}

}
