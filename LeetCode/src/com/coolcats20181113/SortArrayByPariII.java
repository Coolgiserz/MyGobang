package com.coolcats20181113;

/**
 *   ��ż����
 * @author CoolCats
 *
 */
public class SortArrayByPariII {

	public static void main(String[] args) {

	}
	
	/**
	 * ����o�����MB,���ӿ��g�_�N��7ms
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
     *  �o���o�����M����ʧһ���ԣ�ֱ�ӱ�vԭ���M�攵����������׃���������ż�����t�cż�������е��攵
     *  ��ֵ���Q
     * @param A
     * @return
     */
    public int[] sortArrayByParityII1(int[] A) {
    	int j = 0;
    	for(int i=1;i<A.length;i+=2) {
    		if(A[i]%2==0) {
    			while(A[j]%2==0) {
    				j += 2;	//���C�����ɽ��Q��λ��
    			}
    			//�M��׃�����Q
    			int tmp = A[i];
    			A[i] = A[j];
    			A[j] = tmp;
    		}
    	}
    	
    	
		return A;
    	
    }
}
