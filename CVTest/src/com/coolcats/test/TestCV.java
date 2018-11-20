package com.coolcats.test;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.Point;
import org.opencv.core.Range;
import org.opencv.core.Rect;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
/**
 * ≤ŒøºŒƒµµ£∫https://www.jianshu.com/p/2731f42882f4
 * @author CoolCats
 *
 */
public class TestCV {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// º”‘ÿ‘À––ø‚
		System.loadLibrary("opencv_java343");
		
		// CVæÿ’Û≤‚ ‘
		Mat m = Mat.eye(3, 3, CvType.CV_8UC1);
		System.out.println("m=" + m.dump());
		Mat A = m;
		System.out.println("A=" + A.dump());
//		Mat E = new Mat();
//		A.copyTo(E);

//		Mat B =((A),Rect(10,10,100,100));

//		Mat E = A.colRange(new Range(0,3));//(Range.all());
//		System.out.println("E="+E.dump());

		// º∏∫ŒÕº–Œ≤‚ ‘
		Point P = new Point(5.0, 1.0);
		System.out.println("P=" + P.toString());

		// ∂¡»°Õº∆¨≤‚ ‘
		String img1 = "F:\\IWork\\Hackathon2018\\Test\\ui1.jpg";
		String img2 = "F:\\IWork\\Hackathon2018\\Test\\img.jpg";
		Mat ui1 = Imgcodecs.imread(img1);
//		System.out.println(ui1.dump());
		Mat u1 = ui1.rowRange(new Range(0, 5));
		System.out.println(u1.dump());

		System.out.println("ui1_toString=" + ui1.toString());
		System.out.println("ui1_channels=" + ui1.channels());
		List<MatOfPoint> contours = new List<MatOfPoint>() {
			
			@Override
			public <T> T[] toArray(T[] a) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Object[] toArray() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public List<MatOfPoint> subList(int fromIndex, int toIndex) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public int size() {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public MatOfPoint set(int index, MatOfPoint element) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public boolean retainAll(Collection<?> c) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean removeAll(Collection<?> c) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public MatOfPoint remove(int index) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public boolean remove(Object o) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public ListIterator<MatOfPoint> listIterator(int index) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public ListIterator<MatOfPoint> listIterator() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public int lastIndexOf(Object o) {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public Iterator<MatOfPoint> iterator() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public boolean isEmpty() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public int indexOf(Object o) {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public MatOfPoint get(int index) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public boolean containsAll(Collection<?> c) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean contains(Object o) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public void clear() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public boolean addAll(int index, Collection<? extends MatOfPoint> c) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean addAll(Collection<? extends MatOfPoint> c) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public void add(int index, MatOfPoint element) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public boolean add(MatOfPoint e) {
				// TODO Auto-generated method stub
				return false;
			}
		}; Mat hierarchy = new Mat(); int mode; int method;
		Imgproc.findContours(ui1, contours, hierarchy, 0, 0);
		System.out.println("Contour:"+contours);
//		Core.ab
	}

}
