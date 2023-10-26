package com.lee.datastructureandalgorithms.geek.no212;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

/**
 * @author alphayosemite
 * <p>
 * JMH(the Java Microbenchmark Harness)
 * 定位热点代码，测试性能数据，评估改善情况
 * <p>
 * see <a href="https://zhuanlan.zhihu.com/p/434083702">基准测试JMH</a>
 */
@Warmup(iterations = 3, time = 1)
@Measurement(iterations = 2, time = 1)
@BenchmarkMode(Mode.Throughput)
public class Sample {


    public static void main(String[] args) throws RunnerException {
        Options options = new OptionsBuilder()
                .include(Sample.class.getSimpleName())
                .forks(1)
                .build();

        // 启动基准测试
        new Runner(options).run();
    }

    @Benchmark // 被测试的方法
    public void helloWorld() {
        System.out.println("Hello World!");
    }
}
