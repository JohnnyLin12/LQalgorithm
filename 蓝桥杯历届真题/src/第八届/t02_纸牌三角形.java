/*
 
标题：纸牌三角形

A,2,3,4,5,6,7,8,9 共9张纸牌排成一个正三角形（A按1计算）。要求每个边的和相等。
下图就是一种排法（如有对齐问题，参看p1.png）。

      A				
     9 6
    4   8
   3 7 5 2

   
这样的排法可能会有很多。

如果考虑旋转、镜像后相同的算同一种，一共有多少种不同的排法呢？

请你计算并提交该数字。

注意：需要提交的是一个整数，不要提交任何多余内容。
 */
/*
 * 与第七届的第三题凑算式类似 
用到知识点： 
 1、常规的dfs：
 	每个数字只能使用一次 vis标记
 	dfs出口：num==9时 在此基础上，每条边和相等则满足条件，ans++

注意点：
1、这样选出来的实际上是包括旋转和对称的

答案：144
 */
package 第八届;
public class t02_纸牌三角形 {
	static int ans = 0;
	static int vis[] = new int[10];//初始值为0
	static int a[] = new int[9];
	/**
	 * @param num 表示当前为数组a的num位置选择数字
	 */
	public static void dfs(int num) {
		
		if(num==9){
		if(a[0]+a[1]+a[2]+a[3]==a[3]+a[4]+a[5]+a[6] 
				&& a[3]+a[4]+a[5]+a[6]==a[6]+a[7]+a[8]+a[0]){
				System.out.println(a[0]+" "+a[1]+" "+a[2]+" "+a[3]+" "+a[4]+" "
						+a[5]+" "+a[6]+" "+a[7]+" "+a[8]);
				ans++;
			}		
			return ;
		}
		for(int i=1;i<=9;i++){
			if(vis[i]==0){
				vis[i]=1;
				a[num]=i;
				dfs(num+1);
				vis[i]=0;
			}
		}
 
	}
 
	public static void main(String[] args) {
		dfs(0);
		//除掉旋转、镜像
		System.out.println(ans/3/2);
	}
 
}
