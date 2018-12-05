import java.io.File;

public interface FileSearchInterface {
	public int listFiles();
	public int listFiles(String path);
	public int listFiles(File f,String word);


}
