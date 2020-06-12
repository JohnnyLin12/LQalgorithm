
/*题目描述

立方变自身

观察下面的现象,某个数字的立方，按位累加仍然等于自身。
1^3 = 1 
8^3  = 512    5+1+2=8
17^3 = 4913   4+9+1+3=17
...

请你计算包括1,8,17在内，符合这个性质的正整数一共有多少个？

请填写该数字，不要填写任何多余的内容或说明性的文字。
 答案：6
1 1
8 8
17 17
18 18
26 26
27 27
 */
package 第六届;

public class t02_立方变自身 {
	static int sum(int i) {
		String s=String.valueOf(i);
		int res=0;
		//按位求和
		for(int j=0;j<s.length();j++) {
			res=res+(s.charAt(j)-'0');
		}
		//System.out.println("i="+i+" "+res);
		return res;
	}
	public static void main(String[] args) {
		//根据数学性质 符合这一性质的正整数不会超过99
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
