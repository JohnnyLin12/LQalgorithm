package 第五届;

public class t07_扑克序列_深搜剪枝 {
	static char pork[]= {'A','A','2','2','3','3','4','4'};
	static boolean vis[]=new boolean[8];
	//cnt表示当前选了cnt个 当前序列为s
	static void dfs(int cnt,String s) {
		//System.out.println(index+" "+s);
		if(cnt==8) {
			if(check(s)) {
				System.out.println(s);
				s="";
			}
			return;
		}
		for(int k=0;k<8;k++) {
			if(!vis[k]) {
				vis[k]=true;
				dfs(cnt+1,s+pork[k]);
				vis[k]=false;
			}
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
		dfs(0,"");
	}

}
