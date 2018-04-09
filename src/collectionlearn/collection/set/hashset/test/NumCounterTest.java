package collectionlearn.collection.set.hashset.test;

import java.util.Spliterator;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * @author 肖长路
 * @description
 * @date 2018年04月08日 13:59
 */
public class NumCounterTest {
    private static int countNum(Stream<Character> stream){
        NumCounter numCounter = stream.reduce(new NumCounter(0, 0, false), NumCounter::accumulate, NumCounter::combine);
        return numCounter.getSum();
    }

    public static void main(String[] args) {
        String arr = "12%3 21sdas s34d dfsdz45   R3 jo34 sjkf8 3$1P 213ikflsd fdg55 kfd";
        Stream<Character> stream = IntStream.range(0, arr.length()).mapToObj(arr::charAt);
        System.out.println("ordered total: " + countNum(stream));
        // 调用parallel()变成并行流
        //为什么会执行错误，是因为默认的Spliterator在并行时并不知道整个字符串从哪里开始切割，
        //由于切割错误，导致把本来完整的数字比如123，可能就切成了12和3，这样加起来的数字肯定不对
        //System.out.println("ordered total: " + countNum(stream.parallel()));

        Spliterator<Character> spliterator = new NumCounterSpliterator(arr);
        // 传入true表示是并行流
        Stream<Character> parallelStream = StreamSupport.stream(spliterator, true);
        System.out.println("parallel total: " + countNum(parallelStream));
    }
}
