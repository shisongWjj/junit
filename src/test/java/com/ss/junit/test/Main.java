package com.ss.junit.test;

import com.ss.junit.core.RepeatFixedTimes;
import com.ss.junit.core.ShisongSpringJUnit4ClassRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Main
 *
 * @author shisong
 * @date 2019/7/11
 */
@RunWith(ShisongSpringJUnit4ClassRunner.class)
public class Main {

    List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);

    @Test
    @RepeatFixedTimes(value = 5000,printDetail = true)
    public void test(){
        Collections.shuffle(integers);
        System.out.println(integers);
    }
}
