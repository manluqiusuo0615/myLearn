package annotation20180705;

public class Test {

	/** @Description
	 * @param args
	 * @author: Xiao ChangLu
	 * @date:2017-9-4下午2:45:32
	 */
	public static void main(String[] args) {
		Filter f1 = new Filter();
		f1.setId(1);
		
		Filter f2 = new Filter();
		f2.setEmail("xiao@163.com,610505674@qq.com,878787@sina.com,89797@192.com");
		
		
		Filter f3 = new Filter();
		f3.setAge(15);
		f3.setCity("北京");
		
		String sql1 = AnnotationParsingUtile.getSql(f1);
		String sql2 = AnnotationParsingUtile.getSql(f2);
		String sql3 = AnnotationParsingUtile.getSql(f3);
		
		System.out.println(sql1);
		System.out.println(sql2);
		System.out.println(sql3);
	}

}
