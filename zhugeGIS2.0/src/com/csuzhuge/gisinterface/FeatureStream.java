package com.csuzhuge.gisinterface;
import com.csuzhuge.gis.geom.*;
import java.io.File;
import java.util.List;
/**
 * 根据指定的文件路径 读取或写入要素数据
 * @author CoolCats
 *
 */
public interface FeatureStream {
	public List<Geometry> readerStream(File input);
	public void writerStream(List<Geometry> geoms);

}
