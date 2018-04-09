package collectionlearn.collection.set.hashset.test;

import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * @author 肖长路
 * @description
 * @date 2018年04月08日 14:42
 */
public class NumCounterSpliterator2 implements Spliterator<Character> {
    private char[] str;
    private int currentChar = 0;
    private int end = Integer.MAX_VALUE;
    private boolean canSplit = true;

    public NumCounterSpliterator2(int currentChar,int end,char[] str,boolean canSplit) {
        this.str = str;
        this.currentChar = currentChar;
        this.canSplit = canSplit;
        this.end = end;
    }




    @Override
    public boolean tryAdvance(Consumer<? super Character> action) {
        action.accept( str[currentChar++] );
        return currentChar < end;
    }



    @Override
    public Spliterator<Character> trySplit() {
        int i = currentChar;
        for(;canSplit && i < end; ++i){
            if(!Character.isDigit(str[i])){
                int splitBeforeEnd = end;
                end = i ;
                canSplit = false;
                if(i + 1 < splitBeforeEnd){
                    return new NumCounterSpliterator2(i+1,splitBeforeEnd,str,true);
                }else{
                    return null;
                }
            }
        }

        canSplit = false;
        return null;
    }

    @Override
    public long estimateSize() {
        return end - currentChar;
    }

    @Override
    public int characteristics() {
        return ORDERED | SIZED | SUBSIZED | NONNULL | IMMUTABLE;
    }
}
