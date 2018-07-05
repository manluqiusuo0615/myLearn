package annotation20180705;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
/**
 * @Description 注解解析工具
 * 通过注解,实现了从实体类到表的映射(类与表名映射,类中属性与表中字段映射)
 * (解析注解是通过反射获取类,函数或成员上的运行时注解信息,
 * 从而实现动态控制程序运行的逻辑.)
 * @author: Xiao ChangLu
 * @date:2017-9-4下午2:40:15
 */
public class AnnotationParsingUtile {
	public static String getSql(Object obj){
		StringBuilder sb = new StringBuilder();
		//1.获取到class
		Class<?> clazz = obj.getClass();
		//2.获得table的名称
		
		//isAnnotationPresent()指定类型的注释存在于此元素上
		//是为了方便访问标记注释
		boolean exists = clazz.isAnnotationPresent(TableAnnotation.class);
		if(!exists){
			return null ;
		}
		//返回改程序元素上存在的,指定类型的注解,如果该类型注解不存在,则返回null
		TableAnnotation t = clazz.getAnnotation(TableAnnotation.class);
		String tableName = t.value();
		
		sb.append("select * from ").append(tableName).append(" where 1=1 ");
		//遍历所有的字段
		Field[] fArray = clazz.getDeclaredFields();
		for(Field one:fArray){
			//处理每个字段对应的sql映射的表中的字段名
			boolean fExists = one.isAnnotationPresent(FieldAnnotation.class);
			if(!fExists){
				continue ;
			}
			//数据库表中的字段名称
			FieldAnnotation tableField = one.getAnnotation(FieldAnnotation.class);
			String tableFieldName = tableField.value();
			//拿到传入的对象的属性值
			String fieldName = one.getName();
			//获得对象属性对应的get方法
			String getMethodName = "get"+fieldName.substring(0, 1).toUpperCase()+fieldName.substring(1);
			Object fieldValue = null;
			try{
				//反射获取到get方法
				Method getMethod = clazz.getMethod(getMethodName);
				//通过反射,调用对象属性的get方法  获取到值
				fieldValue = getMethod.invoke(obj);
			}catch(Exception e){
				e.printStackTrace();
			}
			//拼装sql
			if(fieldValue==null||(fieldValue instanceof Integer && (Integer)fieldValue==0)){
				continue ;
			}
			sb.append(" and ").append(tableFieldName);
			if(fieldValue instanceof String){
				if(((String) fieldValue).contains(",")){
					String[] values = ((String) fieldValue).split(",");
					sb.append(" in (");
					for(String v:values){
						sb.append("'").append(v).append("'").append(",");
					}
					sb.deleteCharAt(sb.length()-1);
					sb.append(")");
				}else{
					sb.append("=").append("'").append(fieldValue).append("'");
				}
			}else{
				sb.append("=").append(fieldValue);
			}
		}
		return sb.toString();
	}
}
