import java.io.File;

public class FileHelper implements FileSearchInterface {

	@Override
	public int listFiles() {
		return 0;
	}

	/**
	 * 列出根目录下文件名包含XXX关键字的文件路径
	 */
	@Override
	public int listFiles(String word) {
		File[] f = File.listRoots();
//		File f = new File(path);
		for (File ff : f) {
//			String fileName = ff.getName();
//			String filePath = ff.getPath();
//			System.out.println(filePath + " " + fileName);
			int count = listFiles(ff, word);
			System.out.println(ff.getAbsolutePath() + "目录下有" + count + "个满足条件的文件！");

		}
		// 将目录与文件名拆分
//		String fileName = f.getName();
//		String filePath = f.getPath();
		// 如果文件目录不存在，则创建

//		System.out.println(filePath+" "+fileName);
		return 0;
	}

	/**
	 * 递归查找当前目录及其子目录下是否具有包含word关键字的文件名
	 */
	@Override
	public int listFiles(File f, String word) {
		int count = 0;

//		String fileName = f.getName();
//		String filePath = f.getPath();
//		File path = new File(filePath);
//		File name = new File(fileName);
		File[] files = f.listFiles();
		if(files==null || files.length==0) {
			return 0;
		}
//		System.out.println(files);
//		f.lis
		for (File ff : files) {
			if (ff.isDirectory()) {
				count += listFiles(ff, word);
			} else {
				if (ff.getName().contains(word)) {
					System.out.println(ff.getAbsolutePath());
					count++;
				}
			}

		}
		return count;
	}

}
