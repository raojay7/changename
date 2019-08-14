import java.io.*;

public class FileMoveUtils {
    public static void moveFilesToClassedDictory (String src) throws Exception{
        File srcfolder=new File(src);//源

        // 获取该目录下的所有文本的File数组
        File []filearray=srcfolder.listFiles();

        //遍历该File数组，得到每一个File对象
        for(File file:filearray)
        {
            //得到文件的名字
            String name=file.getName();
            System.out.println(name);
            //取得文件的前4个字符，并根据这个字符创建文件夹
            String subFolderStr=name.substring(0,4);
            //将得到的文件存储到对应的文件夹中
            File subFolder=new File(subFolderStr);

            //如果没子文件夹就创建
            if(!(subFolder.exists()))
            {
                subFolder.mkdir();
            }

            //将当前的文件拷贝到subFolder中
            File newFile=new File(subFolder,name);
            copy(file,newFile);
        }


    }

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


    public static void main(String[] args) throws Exception{
        FileMoveUtils.moveFilesToClassedDictory("/Users/jay/Downloads/jpg2");
    }
}
