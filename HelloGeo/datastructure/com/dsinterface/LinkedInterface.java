package com.dsinterface;


public interface LinkedInterface<E> {

	/**
	 * 添加元素
	 * 
	 * @param e要添加的元素
	 */
	void add(E e);

	/**
	 * 根据索引删除元素的方法
	 * 
	 * @param index要删除数据的索引
	 * @return 返回删除的数据
	 */
	E remove(int index);

	E get(int index);

	void insert(E e,int index);
	
	void update(E e,int index);
	
	int size();

}