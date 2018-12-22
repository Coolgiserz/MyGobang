package com.coolcats20181220;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * ������������-���Ŷ����� ��Ȩ·��֮����С
 * 
 * @author CoolCats
 *
 */
public class HfTree {

	private Node _root;
	private ArrayList<Node> _list;

	static HashMap<String, String> map = new HashMap<>();
	static HashMap<String, String> map1 = new HashMap<>();

	public static void main(String[] args) {

		HfTree hftree = new HfTree();
		String s = "qqqqqqqqqqqwwwwwweeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeppppppppppppppptttttttttttttttttttttttttttttttttrrr";
//		String s = "qqqqqqqiillllllllllllloooovvvvvvvvvvvvvvvvvvvvvvvvvveeeeeeeeeeepp";
		System.out.println(s.length());

		System.out.println(s);
		// ͳ�ƴ�Ƶ
		int[] words = hftree.calcWordFrequency(s);

		// ��ͳ�ƺ���Ϣת���б�洢
		hftree._list = hftree.array2List(words);

		// ��ӡ�б�
		hftree.printList(hftree._list);

		// ���б��������
		hftree.sortList(hftree._list);

		// ��ӡ�б�
		hftree.printList(hftree._list);

		// ������������
		hftree.createHfTree(hftree._list);

		// ��������������������Ҷ�ӽڵ�Ĺ��������뱣��
		System.out.println("********�������********");
		hftree.postOrder(hftree._root, "");

		// �õ�ԭʼ���ݵĹ���������
		System.out.println("����������С��" + map.size());
		StringBuilder builder = new StringBuilder();// ���ڴ洢���������봮
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
//			System.out.println();
//			System.out.print(map.get(ch+""));
			builder.append(map.get(ch + ""));
		}
		System.out.println(builder.toString());
		// ������������ÿ8��������Ϊһ��byte���д洢����������������8����������0
		byte[] b = builder.toString().getBytes();
		System.out.println("Test getBytes:" + b.length);

		for (int i = 0; i < b.length; i++) {
			System.out.print((char) b[i]);
		}
		System.out.println("�ļ���");
		hftree.hfcode2file("src/hf.txt", builder.toString());
		//��ѹ���ļ�
		String rescode = hftree.file2hfcode("src/hf.txt");
		System.out.println(rescode);
	}

	/**
	 * @param b ѹ�����ֽ�
	 * @param comple ��0�ĸ���
	 * @return
	 */
	private String hfcode2String(byte[] bb,int offset,int comple) {
		String code = null;
		StringBuilder builder = new StringBuilder();
		String tmp = "";
//		int bblen = bb.length-(comple+1)*8;
//		System.out.println("bblen:"+bblen);
		for(int i=0;i<offset-comple;i++) {
			tmp += (char)bb[i];
			if(map1.containsKey(tmp)) {
				String value = map1.get(tmp);
//				System.out.print(value);
				builder.append(value);
//				System.out.println(tmp+"<>"+value);
				tmp = "";
			}
//			builder.append((char)bb[i]);
//			System.out.print((char)bb[i]);
		}
		//����
		code = builder.toString();
//		code = code.
		System.out.println();
		System.out.println("code�ĳ���"+code.length());
//		code = code.substring(0, code.length()-comple*8);
		System.out.println(code.length());
		return code;
	}
	/**
	 * 
	 * @param path
	 * @return
	 */
	private String file2hfcode(String path) {
		String code = null;
		InputStream in = null;
		DataInputStream din = null;
		int comple;// ��ȡ����0�ĸ���
		File file = new File(path);
		try {
			in = new FileInputStream(file);
			din = new DataInputStream(in);
//			int b;
			comple = din.readInt();// ������0�ĸ���
			System.out.println("��0�ĸ�����"+comple);
			byte[] bb = new byte[1024];
			int res = din.read(bb);
			System.out.println("�����"+res);

			code = hfcode2String(bb,res,comple);

			
//			byte[] bb = new int[];
//			while ((b = in.read()) != -1) {
//				code =
//			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
//		while()
		return code;
	}

	/**
	 * ���ݸ�����·���Լ����������뽫������������Ӧ���ļ��� Ҫ����ѹ���ļ�����Ϣ�����˶��ٸ�0
	 * 
	 * @param path ѹ���ļ���·��
	 * @param code ����������
	 */
	private void hfcode2file(String path, String code) {
		int len = code.length();
		System.out.println("���������볤�ȣ�" + len);

		int comple = 8 - len % 8;
		if (comple < 8) {
			// Ӧ�ò�0
			System.out.println("Ӧ�ò�0�ĸ�����" + comple);
			System.out.println("ѹ���������ֽ�����" + ((len + comple) / 8));
			for (int i = 0; i < comple; i++) {
				code = code + "0";
			}
		} else {
			// ����Ҫ��0
			System.out.println("Ӧ�ò�0�ĸ�����" + 0);
			System.out.println("ѹ���������ֽ�����" + ((len) / 8));
		}

//		InputStream in = null;
		OutputStream out = null;
		DataOutputStream dout = null;
		File file = new File(path);

		// ���ַ�������
		try {
			out = new FileOutputStream(file);
			dout = new DataOutputStream(out);

//			byte[] b = new byte[8];
			int count = (len + comple) / 8;
			byte[] b = code.getBytes();
			dout.writeInt(comple);
//			dout.writeBytes(b);
			dout.write(b);
//			out.write(b);
			//
			for (int i = 0; i < count; i++) {
//				out.write((char)b[i], 8, 0);
//				out.write(b, 8, 10);

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
//				in.close();
				out.close();
				dout.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("ѹ���ļ����");
		}

	}

	/**
	 * �������
	 * 
	 * @param root
	 * @param code
	 */
	private void postOrder(Node root, String code) {
		if (root.left != null)
			// ��·�����Ϊ0
			postOrder(root.left, code + "0");
		if (root.right != null) {
			// ��·�����Ϊ1
			postOrder(root.right, code + "1");
		}
//		System.out.println(root.toString());
		// �����������Ҷ�ӽڵ����
		if (root.left == null && root.right == null) {
			System.out.println(root.data + "<>" + code);
			// �������ַ��Ĺ���������洢
			map.put(root.data, code);
			map1.put(code, root.data);
		}
	}

	/**
	 * ǰ�����
	 * 
	 * @param root
	 */
	private void preOrder(Node root) {
		System.out.println(root.toString());
		if (root.left != null)
			preOrder(root.left);
		if (root.right != null) {
			preOrder(root.right);
		}
	}

	/**
	 * ���ӽڵ��ø��ڵ�
	 * 
	 * @param left  ���ӽڵ�
	 * @param right ���ӽڵ�
	 * @return
	 */
	private Node getParent(Node left, Node right) {
		Node father = new Node(left.data + right.data, left.weight + right.weight);
		father.left = left;
		father.right = right;
		return father;
	}

	/**
	 * ������������
	 * 
	 * @param sortlist
	 */
	private void createHfTree(ArrayList<Node> sortlist) {
		while (sortlist.size() > 1) {
			Node father = getParent(sortlist.remove(0), sortlist.remove(0));
			sortlist.add(0, father);
			this.sortList(sortlist);
		}
		this._root = sortlist.get(0);

	}

	/**
	 * �б�����
	 * 
	 * @param list
	 */
	private void sortList(ArrayList<Node> list) {
		Node minNode = null;
		Node jNode = null;

		for (int i = 0; i < list.size() - 1; i++) {
			int min = i;
			for (int j = i + 1; j < list.size(); j++) {
				minNode = list.get(min);
				jNode = list.get(j);
				if (minNode.weight > jNode.weight) {
					min = j;
				}
			}
			// ���ѡ��������û����һ����������
			if (min != i) {
				Node tmpNode = list.get(i);
				list.set(i, list.get(min));
				list.set(min, tmpNode);
			}
		}

	}

	/**
	 * ͳ�ƴ�Ƶ
	 * 
	 * @param s ԭʼ����
	 * @return int[] ��Ƶͳ������
	 */
	public int[] calcWordFrequency(String s) {
		int[] ascii = new int[256];
		for (int i = 0; i < s.length(); i++) {
			int ch = s.charAt(i);
			ascii[ch]++;
		}
		return ascii;
	}

	/**
	 * ����ת�б�
	 * 
	 * @param words
	 * @return
	 */
	public ArrayList<Node> array2List(int[] words) {
		ArrayList<Node> list = new ArrayList<>();
		for (int i = 0; i < words.length; i++) {
			if (words[i] != 0) {
				list.add(new Node((char) i + "", words[i]));
			}
		}

		return list;
	}

	/**
	 * ��ӡ�б�
	 * 
	 * @param list
	 */
	private void printList(ArrayList<Node> list) {
		System.out.println("******�б��ӡ��ʼ*********");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).toString());
		}
		System.out.println("******�б��ӡ����*********");

	}
}
