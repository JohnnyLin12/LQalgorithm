package �ھŽ�;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

/**
* @author JohnnyLin
* @version Creation Time��2020��6��2�� ����5:32:31
*/
public class ������� {

	public static void main(String[] args) throws FileNotFoundException {
		/*
		 *System.out��ϵͳ�ı�׼�������Ĭ�������̨�����Ϣ
		 *���ǿ���ͨ��System.setOut()���������������ļ��������ط� 
		 */
		//�ļ����� ���ļ�Ĭ�ϻ�����Ŀ���������� Ҳ������ʾָ��λ�� ��:E:\abc.txt
		File file = new File("abc.txt");
		
		PrintStream p=new PrintStream(file);
		String s="Hello Johnny!";
		p.print(s);
		System.setOut(p);

	}

}
