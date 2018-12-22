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
 * 哈夫曼二叉树-最优二叉树 带权路径之和最小
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
		// 统计词频
		int[] words = hftree.calcWordFrequency(s);

		// 将统计后信息转用列表存储
		hftree._list = hftree.array2List(words);

		// 打印列表
		hftree.printList(hftree._list);

		// 对列表进行排序
		hftree.sortList(hftree._list);

		// 打印列表
		hftree.printList(hftree._list);

		// 构建哈夫曼树
		hftree.createHfTree(hftree._list);

		// 遍历哈夫曼树并将各个叶子节点的哈夫曼编码保存
		System.out.println("********后序遍历********");
		hftree.postOrder(hftree._root, "");

		// 得到原始数据的哈夫曼编码
		System.out.println("哈夫曼树大小：" + map.size());
		StringBuilder builder = new StringBuilder();// 用于存储哈夫曼编码串
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
//			System.out.println();
//			System.out.print(map.get(ch+""));
			builder.append(map.get(ch + ""));
		}
		System.out.println(builder.toString());
		// 将哈夫曼编码每8个编码作为一个byte进行存储，如果编码个数不是8的整数倍则补0
		byte[] b = builder.toString().getBytes();
		System.out.println("Test getBytes:" + b.length);

		for (int i = 0; i < b.length; i++) {
			System.out.print((char) b[i]);
		}
		System.out.println("文件：");
		hftree.hfcode2file("src/hf.txt", builder.toString());
		//打开压缩文件
		String rescode = hftree.file2hfcode("src/hf.txt");
		System.out.println(rescode);
	}

	/**
	 * @param b 压缩的字节
	 * @param comple 补0的个数
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
		//解译
		code = builder.toString();
//		code = code.
		System.out.println();
		System.out.println("code的长度"+code.length());
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
		int comple;// 读取补充0的个数
		File file = new File(path);
		try {
			in = new FileInputStream(file);
			din = new DataInputStream(in);
//			int b;
			comple = din.readInt();// 读出补0的个数
			System.out.println("补0的个数："+comple);
			byte[] bb = new byte[1024];
			int res = din.read(bb);
			System.out.println("结果："+res);

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
	 * 根据给定的路径以及哈夫曼编码将哈夫曼码存进相应的文件中 要存入压缩文件的信息，补了多少个0
	 * 
	 * @param path 压缩文件的路径
	 * @param code 哈夫曼编码
	 */
	private void hfcode2file(String path, String code) {
		int len = code.length();
		System.out.println("哈夫曼编码长度：" + len);

		int comple = 8 - len % 8;
		if (comple < 8) {
			// 应该补0
			System.out.println("应该补0的个数：" + comple);
			System.out.println("压缩后数据字节数：" + ((len + comple) / 8));
			for (int i = 0; i < comple; i++) {
				code = code + "0";
			}
		} else {
			// 不需要补0
			System.out.println("应该补0的个数：" + 0);
			System.out.println("压缩后数据字节数：" + ((len) / 8));
		}

//		InputStream in = null;
		OutputStream out = null;
		DataOutputStream dout = null;
		File file = new File(path);

		// 把字符串当作
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
			System.out.println("压缩文件完成");
		}

	}

	/**
	 * 后序遍历
	 * 
	 * @param root
	 * @param code
	 */
	private void postOrder(Node root, String code) {
		if (root.left != null)
			// 左路径标记为0
			postOrder(root.left, code + "0");
		if (root.right != null) {
			// 右路径标记为1
			postOrder(root.right, code + "1");
		}
//		System.out.println(root.toString());
		// 输出哈夫曼树叶子节点编码
		if (root.left == null && root.right == null) {
			System.out.println(root.data + "<>" + code);
			// 将各个字符的哈夫曼编码存储
			map.put(root.data, code);
			map1.put(code, root.data);
		}
	}

	/**
	 * 前序遍历
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
	 * 由子节点获得父节点
	 * 
	 * @param left  左子节点
	 * @param right 右子节点
	 * @return
	 */
	private Node getParent(Node left, Node right) {
		Node father = new Node(left.data + right.data, left.weight + right.weight);
		father.left = left;
		father.right = right;
		return father;
	}

	/**
	 * 构建哈夫曼树
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
	 * 列表排序
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
			// 如果选择排序法中没有这一步会怎样？
			if (min != i) {
				Node tmpNode = list.get(i);
				list.set(i, list.get(min));
				list.set(min, tmpNode);
			}
		}

	}

	/**
	 * 统计词频
	 * 
	 * @param s 原始数据
	 * @return int[] 词频统计数组
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
	 * 数组转列表
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
	 * 打印列表
	 * 
	 * @param list
	 */
	private void printList(ArrayList<Node> list) {
		System.out.println("******列表打印开始*********");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).toString());
		}
		System.out.println("******列表打印结束*********");

	}
}
