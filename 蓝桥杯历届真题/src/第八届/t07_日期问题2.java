/*

���⣺��������

С����������һ����ʷ���ס���Щ��ʷ�����г����˺ܶ����ڡ�
С��֪����Щ���ڶ���1960��1��1����2059��12��31�ա�
��С��ͷ�۵��ǣ���Щ���ڲ��õĸ�ʽ�ǳ���ͳһ��
�в�����/��/�յģ��в�����/��/��ģ����в�����/��/��ġ�
�����鷳���ǣ����Ҳ��ʡ����ǰ��λ��ʹ�������ϵ�һ�����ڣ����ںܶ���ܵ����������Ӧ��  

����02/03/04��������2002��03��04�ա�2004��02��03�ջ�2004��03��02�ա�  

����һ�������ϵ����ڣ����ܰ���С���ж�����Щ���ܵ����ڶ����Ӧ��

����
----
һ�����ڣ���ʽ��"AA/BB/CC"��  (0 <= A, B, C <= 9)  

����
----
������ɸ�����ͬ�����ڣ�ÿ������һ�У���ʽ��"yyyy-MM-dd"��������ڰ����絽�����С�  

��������
----
02/03/04  

�������
----
2002-03-04  
2004-02-03  
2004-03-02  

��ԴԼ����
��ֵ�ڴ����ģ���������� < 256M
CPU����  < 1000ms


���ϸ�Ҫ���������Ҫ��������ش�ӡ���ƣ�����������...�� �Ķ������ݡ�

���д������ͬһ��Դ�ļ��У�����ͨ���󣬿����ύ��Դ�롣
��Ҫʹ��package��䡣��Ҫʹ��jdk1.7�����ϰ汾�����ԡ�
��������ֱ����ǣ�Main��������Ч���봦��



 */
/*
1960=<yyyy<= 2059

yy/mm/dd	
mm/dd/yy
dd/mm/yy

02/03/04
yy/mm/dd��ʽ		��02Ϊyy:
1902:	false
2002:	true
	  2002-03-04

mm/dd/yy
dd/mm/yy��ʽ		��04Ϊyy
1904	false
2004	true
		2004-02-03
		2004-03-02

String ��compare����
		
System.out.println("1902".compareTo("1964"));//С�� -
System.out.println("1964".compareTo("1964"));//���� 0
System.out.println("1964".compareTo("1902"));//���� +



�õ�����oj��ȥ�� ���� �������� �ŷ���˼ά©�� 2002-02-29�����ڲ����� 
2029-02-02��2029-02-02�ظ���

02/02/29
2002-02-29
2029-02-02
2029-02-02

check�����ж��Ǹ������Ƿ�Ϸ�
  ��    	ƽ	
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



�����ֵ�����ȥ���������ݹ����� gg �����������ݲ�֪��
����������Ϊ��00/02/29
2000-02-29
2029-00-02
2029-02-00
Ӧ���޳����·ݺ����Ϊ00�� ʵ����ֻ��2000-02-29

��֪������ת�������Ͳ�����Ҳ©��Ҳ©��
1=<dd<=31
1=<mm<=12

 */
/*
�����ؼ���
1�������ж�
2�������絽������
3������
68/12/31

 */
package �ڰ˽�;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

/**
* @author JohnnyLin
* @version Creation Time��2020��5��24�� ����4:56:02
*/
public class t07_��������2 { 
	static final String s1 ="19";
	static final String s2 ="20";
	static String date[];
	static TreeSet<Integer>  set = new TreeSet<Integer>();  
	static List<Integer> list =new ArrayList<Integer>(); 
	static boolean isValid(String str) {
		return (str.compareTo("1964"))>=0 && (str.compareTo("2059")<=0);
	}
	static boolean check(String y,String m,String d) {
		//���ж������껹��ƽ�� 2 29
		//���·�
		//System.out.println("check"+y+"-"+m+"-"+d);
		if(d.compareTo("00")<=0||d.compareTo("31")>0)
			return false;
		if(m.equals("02")) {
			Integer year = Integer.valueOf(y);
			if( !( (year%400==0)||(year%4==0&&year%100!=0) )	) {//ƽ��
				//System.out.println(":  a"+y+"-"+m+"-"+d);
				if(d.equals("29")) {
					//System.out.println("b:"+y+"-"+m+"-"+d);
					return false;
				}
			}
		}
		//4 6 9 11 ��Ϊ30 ��
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
	//yy/mm/dd��ʽ	
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
	//	mm/dd/yy  dd/mm/yy��ʽ
	static void toDate2(String y) {
		if(isValid(y)	) {
			if( (date[0].compareTo("00")>0)&&(date[0].compareTo("12")<=0) ) {//�·ݷ��Ϸ�Χ
				if(check(y,date[0],date[1])) {//���������Ƿ���ȷ
					Integer time=Integer.parseInt(y+date[0]+date[1]);
					set.add(time);
				}
			
			}
			if( (date[1].compareTo("00")>0)&&(date[1].compareTo("12")<=0) ) {//�·ݷ��Ϸ�Χ
				if(check(y,date[1],date[0])) {//���������Ƿ���ȷ
					Integer time=Integer.parseInt(y+date[1]+date[0]);
					set.add(time);
				}
			
			}
		}
	}
	public static void main(String[] args) {
		//02/03/04 
		//1960��1��1����2059��12��31��
		//02/05/04
		
		Scanner reader=new Scanner(System.in);
		String s=reader.next();
		date=s.split("/");
		//1=<dd<=31
		//1=<mm<=12
		//yy/mm/dd��ʽ	
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