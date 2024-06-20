package com.solvd;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {


    private final int maxRetry;

    private int cnt;

    public RetryAnalyzer() throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/test/resources/retryCnt.properties"));
        maxRetry = Integer.parseInt((String) properties.get("retry_cnt"));

    }

    @Override
    public boolean retry(ITestResult iTestResult) {
        return cnt++ < maxRetry;
    }
}
