package test3;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class CopyFolderDemo 
{
	/*
	 * ���󣺸��Ƶ����ļ���
	 * 
	 * ����Դ��e:\\demo
	 * Ŀ�ĵأ�e:\\test
	 * 
	 * ������
	 * 		A:��װĿ¼
	 * 		B:��ȡ��Ŀ¼�µ������ı���File����
	 * 		C:������File���飬�õ�ÿһ��File����
	 * 		D:�Ѹ�File���и���
	 */

	public static void main(String[] args) throws IOException 
	{
		//����
		File srcfolder=new File("f:\\java" );
		
		//д��
		File deskfolder=new File("f:\\ritian");
		//���ûdesk�ʹ���
		if(!(deskfolder.exists()))
		{
			deskfolder.mkdir();
		}

		// ��ȡ��Ŀ¼�µ������ı���File����
		File []files=srcfolder.listFiles();
		
		
		//������File���飬�õ�ÿһ��File����
		for(File file:files)
		{
			//����System.out.println(file);
			String name=file.getName();
			File newfFile=new File(deskfolder,name);
			copy(file,newfFile);
		}
		replaceName(".txt", ".java", "f:\\ritian");		
		
		
	}
/*��һ���ļ����Ƶ�����һ���ط����������ֽڿ����������ַ���
 * 1������
 * 1.1�����ֽ�
 * 1.2�����ֽڣ��Ƽ���
 * 2������
 * 2.1�����ֽ�
 * 2.2�����ֽ�
 */
	private static void copy(File file, File newfFile) throws IOException
	{
		//��������
		BufferedInputStream bis=new BufferedInputStream(new FileInputStream(file));
		BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream(newfFile));
		
		//����
		byte[] bys=new byte [1024];
		int len=0;
		while((len=bis.read(bys))!=-1)
		{
			bos.write(bys,0,len);
		}
		
		//�ر���Դ
		bis.close();
		bos.close();
		
	}
	private static void replaceName(String oldString ,String newString,String path)
	{
		//��װ����
		File srcFolder=new File(path);
		//��ȡ��Ŀ¼�����е��ļ���File����
		File []filearray=srcFolder.listFiles();
		//������File���飬�õ�ÿһ��File����
		for(File file:filearray)
		{
			//�õ��ļ�������
			String name=file.getName();
			//�޸����֣�������һ���µ��ַ��������޸�֮�������
			String newName=name.replace(oldString,newString );
			
			//����޸ĺ������
			System.out.println(newName);
			
			//�����µ�file�����Ըı�oldname		
			File newFile=new File(srcFolder,newName);
			file.renameTo(newFile);
		}
	}

}
