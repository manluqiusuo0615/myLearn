package learn.enumeration;

import java.util.EnumSet;
import java.util.Iterator;

/**
 * @author 肖长路
 * @Description ${DESCRIPTION}
 * @create 2017-09-18 10:47
 */
public class EnumSetDemo {
    public static void main(String[] args) {
        EnumSet<FontConstant> enumSet = EnumSet.of(FontConstant.Bold,FontConstant.Plain);
        showEnumSet(enumSet);
        //showEnumSet(EnumSet.complementOf(enumSet));
        
    }

    public static void showEnumSet(EnumSet<FontConstant> enumSet){
        for (Iterator<FontConstant> it = enumSet.iterator(); it.hasNext();) {
            System.out.println(it.next());
        }
    }
}

enum FontConstant{
    Plain("普通字体"),Bold("粗体"),Italilc("斜体");
    private String name;

    public String getName() {
        return name;
    }

    FontConstant(String name){
        this.name = name;
    };

    
}
