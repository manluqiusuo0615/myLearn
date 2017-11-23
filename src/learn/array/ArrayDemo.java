package learn.array;

/**
 * @author 肖长路
 * @Description 数组，就是相同数据类型的元素按一定顺序排列的集合，
 * 就是把有限个类型相同的变量用一个名字命名，然后用编号区分他们的变量的集合，
 * 这个名字称为数组名，编号称为下标。
 * 组成数组的各个变量称为数组的分量，也称为数组的元素，有时也称为下标变量。
 *
 * 常用的排序方法有冒泡排序、快速排序、
 * 选择排序、插入排序、
 * 希尔（Shell）排序、堆排序。
 * @create 2017-09-07 13:43
 */
public class ArrayDemo {
    /**
	 * @Description 数组的初始化
	 * @author: Xiao ChangLu
	 * @date:2017-8-29下午8:00:14
	 */
	public static void Initialization(){
		//动态初始化
		int[] array = new int[3];
		array[0] = 0;
		array[1] = 1;
		array[2] = 2;
		getArrayEvery(array);
		//静态初始化
		int[] array1 = new int[] { 1, 2, 3, 4 };
		getArrayEvery(array1);
	}
	/**
	 * @Description 数组的迭代获取元素
	 * @param array
	 * @author: Xiao ChangLu
	 * @date:2017-8-29下午8:06:44
	 */
	public static void getArrayEvery(int[] array){
		System.out.print("===");
		for(int one:array){
			System.out.print(one);
		}
		System.out.print("===");
		System.out.println();
	}

	/**
	 * @Description 在深入学习更多排序算法后和在实际使用情况中，
	 * 冒泡排序的使用还是极少的。它适合数据规模很小的时候，而且它的效率也比较低，
	 * 但是作为入门的排序算法，还是值得学习的
	 * 其实就是前一个和后面所有的元素进行比较，如果出现状况就替换
	 * @author: Xiao ChangLu
	 * @date:2017-8-29下午8:30:52
	 */
	public static void BubbleSort(){
		int[] arr = {1,5,2,4,6,3,9,7,8,10};
		for(int i=0;i<arr.length;i++){
			for(int j=i+1;j<arr.length;j++){
				if (arr[i] > arr[j]){
					int temp = arr[i];
					arr[i] = arr[j] ;
					arr[j] = temp ;
				}
			}
		}

		for (int i = 0; i <arr.length; i++){
			System.out.print(arr[i]+"==");
		}
	}
	/**
	 * @Description 快速排序（Quicksort）是对冒泡排序的一种改进
	 * 基本思想是：通过一趟排序将要排序的数据分割成独立的两部分，
	 * 其中一部分的所有数据都比另外一部分的所有数据都要小，
	 * 然后再按此方法对这两部分数据分别进行快速排序，
	 * 整个排序过程可以递归进行，
	 * 以此达到整个数据变成有序序列。
	 * 快速排序思想----分治法
	 * @author: Xiao ChangLu
	 * @date:2017-8-29下午8:35:51
	 */
//	public static void QuickSort(){
//		int[] arr = {1,5,2,4,6,3,9,7,8,10};
//		int i;
//		int left ;
//		int right ;
//		int x =
//	}
	/**
	 * @Description 交换位置
	 * 经过该方法后前后位置互换
	 * @param a 前面的位置
	 * @param b 后面的位置
	 * @author: Xiao ChangLu
	 * @date:2017-8-29下午8:18:52
	 */
	public static void swap(int a,int b){
		int temp = a;
		a = b ;
		b = temp ;
	}
	/** @Description
	 * @param args
	 * @author: Xiao ChangLu
	 * @date:2017-8-29下午7:57:06
	 */
	public static void main(String[] args) {
		//Initialization();
		BubbleSort();
	}
}
