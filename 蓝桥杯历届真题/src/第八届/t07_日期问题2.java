/*

标题：日期问题

小明正在整理一批历史文献。这些历史文献中出现了很多日期。
小明知道这些日期都在1960年1月1日至2059年12月31日。
令小明头疼的是，这些日期采用的格式非常不统一，
有采用年/月/日的，有采用月/日/年的，还有采用日/月/年的。
更加麻烦的是，年份也都省略了前两位，使得文献上的一个日期，存在很多可能的日期与其对应。  

比如02/03/04，可能是2002年03月04日、2004年02月03日或2004年03月02日。  

给出一个文献上的日期，你能帮助小明判断有哪些可能的日期对其对应吗？

输入
----
一个日期，格式是"AA/BB/CC"。  (0 <= A, B, C <= 9)  

输入
----
输出若干个不相同的日期，每个日期一行，格式是"yyyy-MM-dd"。多个日期按从早到晚排列。  

样例输入
----
02/03/04  

样例输出
----
2002-03-04  
2004-02-03  
2004-03-02  

资源约定：
峰值内存消耗（含虚拟机） < 256M
CPU消耗  < 1000ms


请严格按要求输出，不要画蛇添足地打印类似：“请您输入...” 的多余内容。

所有代码放在同一个源文件中，调试通过后，拷贝提交该源码。
不要使用package语句。不要使用jdk1.7及以上版本的特性。
主类的名字必须是：Main，否则按无效代码处理。



 */
/*
1960=<yyyy<= 2059

yy/mm/dd	
mm/dd/yy
dd/mm/yy

02/03/04
yy/mm/dd格式		即02为yy:
1902:	false
2002:	true
	  2002-03-04

mm/dd/yy
dd/mm/yy格式		即04为yy
1904	false
2004	true
		2004-02-03
		2004-03-02

String 的compare方法
		
System.out.println("1902".compareTo("1964"));//小于 -
System.out.println("1964".compareTo("1964"));//等于 0
System.out.println("1964".compareTo("1902"));//大于 +



拿到官网oj上去跑 错误 看了样例 才发现思维漏洞 2002-02-29这日期不存在 
2029-02-02与2029-02-02重复了

02/02/29
2002-02-29
2029-02-02
2029-02-02

check函数判断是该日期是否合法
  润    	平	
1 31	31
2 29	28
3 31	31
4 30	30
5 31	31
6 30	30
7 31	31
8 31	31
9 30	30
10 31	31
11 30	30
12 31	31



做完又到官网去跑两个数据过不了 gg 看了评测数据才知道
输入如样例为是00/02/29
2000-02-29
2029-00-02
2029-02-00
应该剔除掉月份和年份为00的 实际上只有2000-02-29

早知道把它转成整数就不会这也漏那也漏了
1=<dd<=31
1=<mm<=12

 */
/*
几个关键点
1、闰年判断
2、按从早到晚排列
3、判重
68/12/31

 */
package 第八届;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

/**
* @author JohnnyLin
* @version Creation Time：2020年5月24日 下午4:56:02
*/
public class t07_日期问题2 { 
	static final String s1 ="19";
	static final String s2 ="20";
	static String date[];
	static TreeSet<Integer>  set = new TreeSet<Integer>();  
	static List<Integer> list =new ArrayList<Integer>(); 
	static boolean isValid(String str) {
		return (str.compareTo("1964"))>=0 && (str.compareTo("2059")<=0);
	}
	static boolean check(String y,String m,String d) {
		//先判断是闰年还是平年 2 29
		//二月份
		//System.out.println("check"+y+"-"+m+"-"+d);
		if(d.compareTo("00")<=0||d.compareTo("31")>0)
			return false;
		if(m.equals("02")) {
			Integer year = Integer.valueOf(y);
			if( !( (year%400==0)||(year%4==0&&year%100!=0) )	) {//平年
				//System.out.println(":  a"+y+"-"+m+"-"+d);
				if(d.equals("29")) {
					//System.out.println("b:"+y+"-"+m+"-"+d);
					return false;
				}
			}
		}
		//4 6 9 11 皆为30 天
		if(m.equals("04")||
			m.equals("06")||
			m.equals("09")||
			m.equals("11")) {
			if(d.equals("31"))
				return false;
		}
		return true;
	}
	//1=<dd<=31
	//1=<mm<=12
	//yy/mm/dd格式	
	static void toDate1(String y) {
		if(	isValid(y)	) {
			if( (date[1].compareTo("00")>0)&&(date[1].compareTo("12")<=0) ) {
				if(check(y,date[1],date[2])) {
					Integer time=Integer.parseInt(y+date[1]+date[2]);
					set.add(time);
				}
			}
		}
	}
	//	mm/dd/yy  dd/mm/yy格式
	static void toDate2(String y) {
		if(isValid(y)	) {
			if( (date[0].compareTo("00")>0)&&(date[0].compareTo("12")<=0) ) {//月份符合范围
				if(check(y,date[0],date[1])) {//检查该日期是否正确
					Integer time=Integer.parseInt(y+date[0]+date[1]);
					set.add(time);
				}
			
			}
			if( (date[1].compareTo("00")>0)&&(date[1].compareTo("12")<=0) ) {//月份符合范围
				if(check(y,date[1],date[0])) {//检查该日期是否正确
					Integer time=Integer.parseInt(y+date[1]+date[0]);
					set.add(time);
				}
			
			}
		}
	}
	public static void main(String[] args) {
		//02/03/04 
		//1960年1月1日至2059年12月31日
		//02/05/04
		
		Scanner reader=new Scanner(System.in);
		String s=reader.next();
		date=s.split("/");
		//1=<dd<=31
		//1=<mm<=12
		//yy/mm/dd格式	
		String ny1=s1+date[0];
		String ny2=s2+date[0];
		String ny3 =s1+date[2];
		String ny4 =s2+date[2];
		toDate1(ny1);
		toDate1(ny2);
		toDate2(ny3);
		toDate2(ny4);
		list.addAll(set);  
		for(int i=0;i<list.size();i++){  
	        String ans = ""+list.get(i);  
	        System.out.println(ans.substring(0, 4)+"-"+ans.substring(4,6)+"-"+ans.substring(6,8));  
		}  
	}
}