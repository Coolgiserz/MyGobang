package com.csuzhuge.gisinterface;
import com.csuzhuge.gis.geom.*;
import java.io.File;
import java.util.List;
/**
 * ����ָ�����ļ�·�� ��ȡ��д��Ҫ������
 * @author CoolCats
 *
 */
public interface FeatureStream {
	public List<Geometry> readerStream(File input);
	public void writerStream(List<Geometry> geoms);

}
