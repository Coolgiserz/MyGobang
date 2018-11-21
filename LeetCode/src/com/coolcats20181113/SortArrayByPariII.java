package com.coolcats20181113;

/**
 *   奇偶排序
 * @author CoolCats
 *
 */
public class SortArrayByPariII {

	public static void main(String[] args) {

	}
	
	/**
	 * 添加輔助數組B,增加空間開銷，7ms
	 * @param A
	 * @return
	 */
    public int[] sortArrayByParityII(int[] A) {
        int[] B = new int[A.length];
        int p = 0;
        int q = 1;
        for(int i=0;i<A.length;i++){
            if(A[i]%2==0){
                B[p] = A[i];
                p=p+2;
            }else{
                B[q] = A[i];
                q = q+2;
            }
        }
        
        return B;
    }
    /**
     *  無需輔助數組，不失一般性，直接遍歷原數組奇數索引對應的變量如果他是偶數，則與偶數索引中的奇數
     *  數值交換
     * @param A
     * @return
     */
    public int[] sortArrayByParityII1(int[] A) {
    	int j = 0;
    	for(int i=1;i<A.length;i+=2) {
    		if(A[i]%2==0) {
    			while(A[j]%2==0) {
    				j += 2;	//保證跳到可交換的位置
    			}
    			//進行變量交換
    			int tmp = A[i];
    			A[i] = A[j];
    			A[j] = tmp;
    		}
    	}
    	
    	
		return A;
    	
    }
}
