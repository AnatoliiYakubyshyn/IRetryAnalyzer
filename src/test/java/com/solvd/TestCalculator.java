package com.solvd;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCalculator {

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void testAddition() {
        Assert.assertEquals(1 + 2, 4);
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void testSubtraction() {
        Assert.assertEquals(5 - 1, 1);
    }
}
