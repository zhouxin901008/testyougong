package Basic.test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import android.os.Environment;

public class Loginfo{
	public static void writeToFile(String msg){
		String dirName = Environment.getExternalStorageDirectory().getAbsolutePath();
		String fileName = "robotium自动化输出日志.txt";
		File file = new File(dirName,fileName);
		// 当文件目录不存在时
		if (!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();// 创建文件目录
		}
			try {
				file.createNewFile();
				FileWriter fileWritter = new FileWriter(file,true);
				BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
				bufferWritter.write(msg);
				bufferWritter.newLine();
				bufferWritter.close();
			}
			catch (IOException e) {
			}
	}
}
