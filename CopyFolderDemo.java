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
	 * 需求：复制单极文件夹
	 * 
	 * 数据源：e:\\demo
	 * 目的地：e:\\test
	 * 
	 * 分析：
	 * 		A:封装目录
	 * 		B:获取该目录下的所有文本的File数组
	 * 		C:遍历该File数组，得到每一个File对象
	 * 		D:把该File进行复制
	 */

	public static void main(String[] args) throws IOException 
	{
		//读入
		File srcfolder=new File("f:\\java" );
		
		//写出
		File deskfolder=new File("f:\\ritian");
		//如果没desk就创建
		if(!(deskfolder.exists()))
		{
			deskfolder.mkdir();
		}

		// 获取该目录下的所有文本的File数组
		File []files=srcfolder.listFiles();
		
		
		//遍历该File数组，得到每一个File对象
		for(File file:files)
		{
			//测试System.out.println(file);
			String name=file.getName();
			File newfFile=new File(deskfolder,name);
			copy(file,newfFile);
		}
		replaceName(".txt", ".java", "f:\\ritian");		
		
		
	}
/*将一个文件复制到另外一个地方，可以用字节拷贝，有四种方法
 * 1、缓冲
 * 1.1：单字节
 * 1.2：多字节（推荐）
 * 2、正常
 * 2.1：单字节
 * 2.2：多字节
 */
	private static void copy(File file, File newfFile) throws IOException
	{
		//创建对象
		BufferedInputStream bis=new BufferedInputStream(new FileInputStream(file));
		BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream(newfFile));
		
		//拷贝
		byte[] bys=new byte [1024];
		int len=0;
		while((len=bis.read(bys))!=-1)
		{
			bos.write(bys,0,len);
		}
		
		//关闭资源
		bis.close();
		bos.close();
		
	}
	private static void replaceName(String oldString ,String newString,String path)
	{
		//封装对象
		File srcFolder=new File(path);
		//获取该目录下所有的文件的File数组
		File []filearray=srcFolder.listFiles();
		//遍历该File数组，得到每一个File对象
		for(File file:filearray)
		{
			//得到文件的名字
			String name=file.getName();
			//修改名字，并创建一个新的字符串接收修改之后的名字
			String newName=name.replace(oldString,newString );
			
			//检测修改后的名字
			System.out.println(newName);
			
			//创建新的file来得以改变oldname		
			File newFile=new File(srcFolder,newName);
			file.renameTo(newFile);
		}
	}

}
