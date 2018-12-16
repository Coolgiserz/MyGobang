package com.dsinterface;


public interface LinkedInterface<E> {

	/**
	 * ���Ԫ��
	 * 
	 * @param eҪ��ӵ�Ԫ��
	 */
	void add(E e);

	/**
	 * ��������ɾ��Ԫ�صķ���
	 * 
	 * @param indexҪɾ�����ݵ�����
	 * @return ����ɾ��������
	 */
	E remove(int index);

	E get(int index);

	void insert(E e,int index);
	
	void update(E e,int index);
	
	int size();

}