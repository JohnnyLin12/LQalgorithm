/*
标题：扑克序列


A A 2 2 3 3 4 4， 一共4对扑克牌。请你把它们排成一行。
要求：两个A中间有1张牌，两个2之间有2张牌，两个3之间有3张牌，两个4之间有4张牌。

请填写出所有符合要求的排列中，字典序最小的那个。

例如：22AA3344 比 A2A23344 字典序小。当然，它们都不是满足要求的答案。


请通过浏览器提交答案。“A”一定不要用小写字母a，也不要用“1”代替。字符间一定不要留空格。

25314876 对应 4A3A2432
51237468 对应 2342A3A4
字典序最小的是2342A3A4
 */
package 第五届;

import java.util.Arrays;

public class t07_扑克序列_暴力枚举 {

	public static void main(String[] args) {
		for(int ia=1;ia<=6;ia++) {
			for(int i2=1;i2<=5;i2++) {
				for(int i3=1;i3<=4;i3++) {
					for(int i4=1;i4<=3;i4++) {
						int i5=ia+2;int i6=(i2+3);
						int i7=(i3+4);int i8=(i4+5);
					
						String s=""+ia+i2+i3+i4+i5+i6+i7+i8;
						//只要各下标不相等 那么就是一个合法解
						boolean flag=true;
						if(ia==i2||ia==i3||ia==i4||ia==i6||ia==i7||ia==i8||
								i2==i3||i2==i4||i2==i5||i2==i7||i2==i8||
								i3==i4||i3==i5||i3==i6||i3==i8||
								i4==i5||i4==i6||i4==i7||
								i5==i6||i5==i7||i5==i8||
								i6==i7||i6==i8||
								i7==i8
								
							) {
							flag=false;
							break;
						}
						if(flag) {
							System.out.println(s);
						}
					}
				}
				
			}
		}
		for(int ma = 1 ; ma <= 6 ; ma++){
			for(int m2 = 1 ; m2 <= 5 ; m2++){
				for(int m3 = 1 ; m3 <= 4 ; m3++){
					for(int m4 = 1 ; m4 <= 3 ; m4++){
						String str = "" +ma+m2+m3+m4+(ma+2)+(m2+3)+(m3+4)+(m4+5) ;
						//split("")将下标逐个分开作为getStr的元素
						String[] getStr = str.split("");
						boolean flag = true ;
						//将下标从小到大排序
						Arrays.sort(getStr);
					
						for (int i = 0; i < getStr.length-1; i++) {
							if(getStr[i].equals(getStr[i+1])){
								flag = false ;
								break ;
							}
						}
						if(flag){
							System.out.println(str);
						}
					}
				}
			}
		}

	}

}
