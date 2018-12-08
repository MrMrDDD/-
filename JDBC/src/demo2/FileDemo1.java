package demo2;

import java.awt.im.InputContext;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;

import org.junit.Test;

public class FileDemo1 {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
	
//		创建文件夹
		File filedir=new File("./dir");
		System.out.println(filedir.mkdir());
//		创建文件
		File filetxt=new File("/f.txt");
		System.out.println(filetxt.createNewFile());
//		获取当前文件下全部的文件
//		String[] filelist=filetxt.list();
//		for (String string : filelist) {
//			System.out.println(string);
//		}
	
		FileInputStream in=new FileInputStream(filetxt);
		BufferedInputStream bufferedInputStream=new BufferedInputStream(in);
		
	}


//	@Test
	public void Test_RandomAccessFile() {
//		RamdomAccessFile的解析支持随机访问文件内容
//		支持随机访问文件内容
//		与OutputStream Writer不同，能够自由定位文件记录指针
//		只能读写文件，不能读写IO节点
		
//		创建RamdomAccessFile的MODO参数4种
//		“r”------以只读的方式打开指定的文件
//		“rw”-----以读写的方式打开指定的文件
//		“rws”-----以读写的方式打开指定的文件
//		“rwd”-----以读写的方式打开指定的文件
		try {
			RandomAccessFile raf=new RandomAccessFile("F:\\Code\\JavaWebCode\\JDBC\\src\\demo1\\ThreadPC.java", "rw");
//			返回文件记录指针的位置
			System.out.println(raf.getFilePointer());
//			该段将指针移动到300位置，从该段开始读
			raf.seek(300);
			byte[] b=new byte[1024];
			int read=0;
			while((read=raf.read(b))>0)
			{
				System.out.println(new String(b,0,read));
			}
			raf.seek(raf.length());
//			追加文件内容
			raf.write("//添加的内容".getBytes());
			
//			RandomAccessFile不能在指定位置保存，会覆盖原有的内容的
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void pointer_RandomFile() {
//		指定位置插入文件
//      1.将插入点的内容读入缓冲区
//		2.把需要的文件写入后再把缓冲区文件写入
		try {
			File temp=File.createTempFile("tmp", null);
			temp.deleteOnExit();
			FileInputStream fis=new FileInputStream(temp);
			FileOutputStream fos=new FileOutputStream(temp);
			RandomAccessFile raf=new RandomAccessFile("F:\\Code\\JavaWebCode\\JDBC\\src\\demo1\\ThreadPC.java", "rw");
			raf.seek(raf.length()-300);
			byte[] buff=new byte[1024];
			int b=0;
			while((b=raf.read(buff))>0)
			{
				fos.write(buff, 0, b);
			}
			raf.seek(raf.length()-300);
			raf.write("dingweitianjia".getBytes());
			while((b=fis.read(buff))>0)
			{
				raf.write(buff, 0, b);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

}
