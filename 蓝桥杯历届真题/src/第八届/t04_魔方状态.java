package �ڰ˽�;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
 
public class t04_ħ��״̬
{
 
	/**
	 * 
	 * ���⣺ħ��״̬
	 * 
	 * ����ħ������ֻ��2���ħ����ֻ��8��С����ɡ� ��ͼp1.png��ʾ��
	 * 
	 * С������������ֻϲ��3����ɫ�����аѼ���Ķ���ħ������Ϳ����ɫ�����£�
	 * 
	 * ǰ�棺��ɫ ���棺��ɫ ���棺��ɫ ���棺��ɫ ���棺��ɫ ���棺��ɫ
	 * 
	 * �������һ�£�������ħ�������Һ�һ���ж����ֲ�ͬ��״̬��
	 * 
	 * �������״̬����ħ����������ת�󣬸��������ɫ��һ�£�����Ϊ��ͬһ״̬��
	 * 
	 * ���ύ��ʾ״̬������������Ҫ��д�κζ������ݻ�˵�����֡�
	 * 
	 * @param args
	 */
	//ȫ��������
	//ͨ����������ħ��һ���˿� �ֱ��� �Ƴ����Ŀ�  �ȳ�������  �ƻ�������
	//��������11112233��ȫ��������
	//����11112233��33221111��ͬ
	static int count;
	static List<String> list=new ArrayList<>();
	public static void main(String[] args)
	{
		String string="11112233";
		f(string.toCharArray(),0);
		System.out.println(count);
	}
 
	private static void f(char[] charArray, int i)
	{
		if (i==8)
		{
			String string=new String(charArray);
			String string2=reverse(string);
			if (list.contains(string)||list.contains(string2))
			{
				return;
			}
			count++;
			System.out.println(string);
			list.add(string);
		}
		
		for (int j = i; j < charArray.length; j++)
		{
			char old=charArray[i];
			charArray[i]=charArray[j];
			charArray[j]=old;
			
			f(charArray, i+1);
			
			old=charArray[i];
			charArray[i]=charArray[j];
			charArray[j]=old;
		}
	}
	private static String reverse(String string)
	{
		String string2="";
		for (int i = 0; i < string.length(); i++)
		{
			string2=string.charAt(i)+string2;
		}
		return string2;
	}                                                                                                                                                                                                                                                                                                               
}
//229878