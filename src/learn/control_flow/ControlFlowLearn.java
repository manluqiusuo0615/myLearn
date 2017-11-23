package learn.control_flow;

import java.util.Scanner;

/**
 * @author 肖长路
 * @Description java控制流程例子
 * 程序流程控制结构分为：顺序、选择、循环以及异常处理结构。
 * @create 2017-09-07 13:41
 */
public class ControlFlowLearn{
    /**
	 * @Description 选择结构
	 * 选择结构用于根据不同的条件,实现不同的操作，
	 * 它提供了一种机制,使得程序根据相应的条件运行对应的语句。
	 * java言语实现选择结构有两种形式:
	 * 一种是两路分支选择的if-else语句,另一种是多分枝选择的switch语句。
	 * 第一种:
	 * 根据条件表达的世界(true||false)
	 * 来判断是否进入语句块 if(条件表达式){ 语句块 } 继续执行后面的语句
	 * 第二种:分支语句：
	 * switch case key：需要比较的表达式 value：与表达式进行比较的值
	 * 执行流程：如果key和value比较的结果为true，那么将执行case部分的代码，
	 * case部分可以有多个 类似于else if 部分
	 * 区别是key和value之间的比较只能是==
	 * default部分是不满足以上任何去执行的代码 ，类似于else
	 * switch 后面括号中的表达式的值必须是符合byte，char，short，int
	 * 类型的常量表达式 jdk1.7以后可以使用string
	 * 但不能用浮点型或long类型
	 * @author: Xiao ChangLu
	 * @date:2017-8-29下午7:26:33
	 */
	public static  void selective_structure(){
		System.out.println("请输入分数!");
		Scanner scanner = new Scanner(System.in);
		int score = scanner.nextInt();
		if (score > 60) {
            System.out.println("及格!");
        } else {
            System.out.println("不及格!");
        }

		// 场景：将一个5(score)分制分为 :5分的评价等级A B C D E
		//标准写法 break不能少 跳出当前语句块，如果没有break会直接进入下一个case语句
		System.out.println("请输入5分制分数!");
		Scanner scanner_five = new Scanner(System.in);
		int score_five = scanner_five.nextInt();
		switch (score_five) {
		case 1:
			System.out.println("E级");
			break;
		case 2:
			System.out.println("D级");
			break;
		case 3:
			System.out.println("C级");
			break;
		case 4:
			System.out.println("B级");
			break;
		case 5:
			System.out.println("A级");
			break;
		default:
			System.out.println("作废");
			break;
		}
	}
	/**
	 * @Description 循环
	 * while(条件表达式){ 需要执行的代码部分 } 后面的语句
	 * 执行流程： 当条件表达式为true的时候进入代码块，
	 * 执行需要执行的代码 当条件表达式为false的时候执行后面的语句
	 * do--while
	 * for循环
	 * @author: Xiao ChangLu
	 * @date:2017-8-29下午7:41:48
	 */
	public static void circulate(){
		int i = 5 ;
		while(i>0){//要进入循环体的条件(同时也是跳出的条件)
			System.out.println("当前循环的状态值为:"+i);
			i--;
		}
		System.out.println("++while循环结束++");
		System.out.println("====================");
		int k = 5 ;
		do{//语句块中的内容无论条件是否满足都会执行一次
			System.out.println("当前循环的状态值为:"+k);
			k--;
		}while(k<0);
		System.out.println("==do--while循环结束==");
		System.out.println("====================");
		int j = 5 ;
		do{//语句块中的内容无论条件是否满足都会执行一次
			System.out.println("当前循环的状态值为:"+j);
			j--;
		}while(j>0);
		System.out.println("==do--while循环结束==");
		System.out.println("====================");

		for(int l=0;l<5;l++){
			System.out.println("for循环状态值:"+l);
		}
		String arr = "1,2,3,4,5";
		String[] str_arr = arr.split(",");
		for(String one:str_arr){
			System.out.println("数组中的值为:"+one);
		}
	}
	/** @Description
	 * @param args
	 * @author: Xiao ChangLu
	 * @date:2017-8-29下午7:24:25
	 */
	public static void main(String[] args) {
		//selective_structure();
		circulate();
	}
}
