import java.io.File;

public class FileHelper implements FileSearchInterface {

	@Override
	public int listFiles() {
		return 0;
	}

	/**
	 * �г���Ŀ¼���ļ�������XXX�ؼ��ֵ��ļ�·��
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
			System.out.println(ff.getAbsolutePath() + "Ŀ¼����" + count + "�������������ļ���");

		}
		// ��Ŀ¼���ļ������
//		String fileName = f.getName();
//		String filePath = f.getPath();
		// ����ļ�Ŀ¼�����ڣ��򴴽�

//		System.out.println(filePath+" "+fileName);
		return 0;
	}

	/**
	 * �ݹ���ҵ�ǰĿ¼������Ŀ¼���Ƿ���а���word�ؼ��ֵ��ļ���
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
