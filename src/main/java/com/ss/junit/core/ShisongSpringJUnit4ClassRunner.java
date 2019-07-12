package com.ss.junit.core;

import org.junit.internal.runners.statements.InvokeMethod;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.Statement;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
/**
 * ShisongSpringJUnit4ClassRunner
 *
 * @author shisong
 * @date 2019/7/11
 */
public class ShisongSpringJUnit4ClassRunner extends SpringJUnit4ClassRunner{

    public ShisongSpringJUnit4ClassRunner(Class<?> clazz) throws InitializationError {
        super(clazz);
    }

    @Override
    protected Statement methodInvoker(FrameworkMethod method, Object test) {
        return new InvokeMethodRecycle(method,test);
    }
}
