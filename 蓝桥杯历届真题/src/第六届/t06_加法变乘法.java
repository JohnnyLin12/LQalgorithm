/*
加法变乘法

我们都知道：1+2+3+ ... + 49 = 1225
现在要求你把其中两个不相邻的加号变成乘号，使得结果为2015

比如：
1+2+3+4+5+6...7+8+9+10*11+12+...+27*28+29+...46+47+48+49 = 2015
就是符合要求的答案。

请你寻找另外一个可能的答案，并把位置靠前的那个乘号左边的数字提交（对于示例，就是提交10）。
 */
package 第六届;

public class t06_加法变乘法 {
	static int sum(int s,int t,int []nums) {
		if(s<1||s>49||t>49) return 0;
		int res=0;
		for(int i=s;i<=t ;i++) {
			res+=nums[i];
		}
		return res;
	}
	public static void main(String[] args) {
		//0 1 49
		int []nums=new int[50];
		for(int i=1;i<=49;i++) {
			nums[i]=i;
		}
		//第一个乘号最多只能到46后面
		for(int i=1;i<=46;i++) {
			//第二个乘号最多只能到48后面
			for(int j=i+2;j<=48;j++) {
				int s3=0,s4=0,s5=0;
				int s1=nums[i]*nums[i+1];
				if(i>1) {
					s5=sum(1,i-1,nums);
				}
				if(i+2!=j) {
					s3=sum(i+2,j-1,nums);
				}
				if(j+1>49) continue;
				int s2=nums[j]*nums[j+1];
				s4=sum(j+2,49,nums);
				if(s1+s2+s3+s4+s5==2015) {
					System.out.println(nums[i]);
					System.out.println(nums[j]);
				}
			}
		}
	}

}
