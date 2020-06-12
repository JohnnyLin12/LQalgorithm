/*

标题：奇怪的分式


    上小学的时候，小明经常自己发明新算法。一次，老师出的题目是：

    1/4 乘以 8/5 

    小明居然把分子拼接在一起，分母拼接在一起，答案是：18/45 （参见图1.png）

    老师刚想批评他，转念一想，这个答案凑巧也对啊，真是见鬼！

    对于分子、分母都是 1~9 中的一位数的情况，还有哪些算式可以这样计算呢？

    请写出所有不同算式的个数（包括题中举例的）。

    显然，交换分子分母后，例如：4/1 乘以 5/8 是满足要求的，这算做不同的算式。

    但对于分子分母相同的情况，2/2 乘以 3/3 这样的类型太多了，不在计数之列!

注意：答案是个整数（考虑对称性，肯定是偶数）。请通过浏览器提交。不要书写多余的内容。
i/j  *  k/m=(i*10+k)/(j*10+m)

转/除法为乘法即满足：
i*k*(j*10+m)=j*m*(i*10+k)

 */

package 第五届;

public class t06_奇怪的分数 {
	
	public static void main(String[] args) {
		int cnt=0;
		for(double i=1;i<=9;i++) {//枚举第一个数的分子
			for(double j=1;j<=9;j++) {//枚举第一个数的分母
				if(i==j) continue;
				for(double k=1;k<=9;k++) {
					for(double m=1;m<=9;m++) {
						if(k==m) continue;
						double first=i*k*(10*j+m);
						double last=j*m*(10*i+k);
						if(first==last) {
							cnt++;
							System.out.println(first);
						}
					}
				}
			}
		}
		System.out.println(cnt);

	}

}
