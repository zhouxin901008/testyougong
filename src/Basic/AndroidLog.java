package Basic;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class AndroidLog{
	public static void writeToFile(String msg){
		String dirName = "/Users/zhouxin/Desktop";
		String fileName = "appium_android_log.txt";
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
