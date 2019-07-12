package com.ss.junit.core;

import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;

/**
 * InvokeMethodRecycle
 *
 * @author shisong
 * @date 2019/7/11
 */
public class InvokeMethodRecycle extends Statement {

    private final FrameworkMethod testMethod;
    private final Object target;

    public InvokeMethodRecycle(FrameworkMethod testMethod, Object target) {
        this.testMethod = testMethod;
        this.target = target;
    }

    @Override
    public void evaluate() throws Throwable {
        RepeatFixedTimes annotation = testMethod.getAnnotation(RepeatFixedTimes.class);
        long S = System.currentTimeMillis();
        long maxCost = 0L;
        long minCost = 0L;
        int totalTimes = 0;
        if(annotation != null){
            totalTimes = annotation.value();
            for(int i  = 0; i < totalTimes; i++) {
                long start = System.currentTimeMillis();
                testMethod.invokeExplosively(target);
                long end = System.currentTimeMillis();
                long cost = end - start;
                if (annotation.printDetail()) {
                    System.out.println("第" + (i + 1) + "次: cost:" + cost + "ms");
                }
                if (cost > maxCost) {
                    maxCost = cost;
                }

                if (cost < minCost) {
                    minCost = cost;
                }
            }
        }else {
            testMethod.invokeExplosively(target);
        }

        long E = System.currentTimeMillis();
        long totalCost = E - S;
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println("\t总次数:" + totalTimes + "");
        System.out.println("\t总耗时:" + totalCost + "ms");
        System.out.println("\t\t平均:" + totalCost / (long)totalTimes + "ms");
        System.out.println("\t\t最高:" + maxCost + "ms");
        System.out.println("\t\t最低:" + minCost + "ms");
        if (totalCost > 0L) {
            System.out.println("\t\ttps:" + (double)totalTimes * 1000.0D / (double)totalCost + " /s");
        } else {
            System.out.println("\t\ttps 总耗时过小 无法估算");
        }

        if (totalTimes > 2 && totalCost > 0L) {
            long reducedTimes = (long)(totalTimes - 2);
            long reducedTotalCost = totalCost - maxCost - minCost;
            System.out.println("\t\ttps(去掉最高和最低):" + (double)reducedTimes * 1000.0D / (double)reducedTotalCost + " /s");
        }

        System.out.println("------------------------------------------------");
    }
}
