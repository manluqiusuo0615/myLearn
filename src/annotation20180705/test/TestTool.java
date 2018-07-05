package annotation20180705.test;

import java.lang.reflect.Method;

/**
 * @author Ф��·
 * @description
 * @date 2018��07��05�� 15:03
 */
public class TestTool {
    public static void main(String[] args) {
        NoBug testobj = new NoBug();

        Class clazz = testobj.getClass();

        Method[] method = clazz.getDeclaredMethods();
        //������¼���Բ����� log ��Ϣ
        StringBuilder log = new StringBuilder();
        // ��¼�쳣�Ĵ���
        int errornum = 0;

        for ( Method m: method ) {
            // ֻ�б� @Jiecha ��ע���ķ����Ž��в���
            if ( m.isAnnotationPresent( Jiecha.class )) {
                try {
                    m.setAccessible(true);
                    m.invoke(testobj, null);

                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    //e.printStackTrace();
                    errornum++;
                    log.append(m.getName());
                    log.append(" ");
                    log.append("has error:");
                    log.append("\n\r  caused by ");
                    //��¼���Թ����У��������쳣������
                    log.append(e.getCause().getClass().getSimpleName());
                    log.append("\n\r");
                    //��¼���Թ����У��������쳣�ľ�����Ϣ
                    log.append(e.getCause().getMessage());
                    log.append("\n\r");
                }
            }
        }

        log.append(clazz.getSimpleName());
        log.append(" has  ");
        log.append(errornum);
        log.append(" error.");

        // ���ɲ��Ա���
        System.out.println(log.toString());

    }
}
