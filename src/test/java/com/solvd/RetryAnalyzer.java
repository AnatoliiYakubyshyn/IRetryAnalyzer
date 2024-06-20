package com.solvd;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Properties;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

public class RetryAnalyzer implements IRetryAnalyzer, IAnnotationTransformer {


    private final int maxRetry;

    private int cnt;

    public RetryAnalyzer() throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/test/resources/retryCnt.properties"));
        maxRetry = Integer.parseInt((String) properties.get("retry_cnt"));

    }

    public void transform(ITestAnnotation testannotation, Class testClass, Constructor testConstructor,
                          Method testMethod) {
        testannotation.setRetryAnalyzer(RetryAnalyzer.class);
    }

    @Override
    public boolean retry(ITestResult iTestResult) {
        return cnt++ < maxRetry;
    }
}
