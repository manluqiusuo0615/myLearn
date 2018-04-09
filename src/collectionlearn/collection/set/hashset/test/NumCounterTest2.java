package collectionlearn.collection.set.hashset.test;

import java.util.Spliterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * @author 肖长路
 * @description
 * @date 2018年04月08日 14:43
 */
public class NumCounterTest2 {
    private static int countNum(Stream<Character> stream){
        NumCounter numCounter = stream.reduce(new NumCounter(0, 0, false), NumCounter::accumulate, NumCounter::combine);
        return numCounter.getSum();
    }

    public static void main(String[] args) {
        String arr = "12%3 21sdas s34d dfsdz45   R3 jo34 sjkf8 3$1P 213ikflsd fdg55 kfd";

        //Spliterator<Character> spliterator = new NumCounterSpliterator2(0,arr.length(),arr.toCharArray(),true);
        Spliterator<Character> spliterator = new NumCounterSpliterator3(0,arr.length()-1,arr.toCharArray(),true);
        // 传入true表示是并行流
        Stream<Character> parallelStream = StreamSupport.stream(spliterator, true);
        System.out.println("parallel total: " + countNum(parallelStream));
        //parallelStream.sorted().forEach(System.out::print);
    }

}
