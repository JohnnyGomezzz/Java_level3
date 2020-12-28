import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class NumArraysTest {
    private int[] expected;
    private int[] result;
    NumArrays numArrays;

    public NumArraysTest (int[] expected, int[] result) {
        this.result = result;
        this.expected = expected;
    }

    @Before
    public void init() {
        numArrays = new NumArrays();
    }

    @Test
    public void isOneFourTestTrue1() {
        Assert.assertTrue(numArrays.isOneFour(new int[]{1, 1, 1, 4, 4, 1}));
    }

    @Test
    public void isOneFourTestTrue2() {
        Assert.assertTrue(numArrays.isOneFour(new int[]{1, 4, 1}));
    }

    @Test
    public void isOneFourTestFalse1() {
        Assert.assertFalse(numArrays.isOneFour(new int[]{1, 1, 1, 1, 1, 1}));
    }

    @Test
    public void isOneFourTestFalse2() {
        Assert.assertFalse(numArrays.isOneFour(new int[]{4, 4, 4, 4}));
    }

    @Test
    public void isOneFourTestFalse3() {
        Assert.assertFalse(numArrays.isOneFour(new int[]{5, 1, 7, 4, 1, 8}));
    }

    @Test
    public void isOneFourTestFalse4() {
        Assert.assertFalse(numArrays.isOneFour(new int[]{1}));
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1, 2, 3, 4, 5, 6, 7, 8}, new int[]{5, 6, 7, 8}},
                {new int[]{1, 4, 3, 4, 5, 4, 7, 8}, new int[]{7, 8}},
                {new int[]{2, 4, 7, 8}, new int[]{7, 8}}
        });
    }

    @Test
    public void afterLastFourTest1() {
        Assert.assertArrayEquals(result, numArrays.afterLastFour(expected));
    }

    @Test(expected = RuntimeException.class)
    public void afterLastFourTestException1() {
        numArrays.afterLastFour(new int[]{1, 2, 7});
    }

    @Test(expected = RuntimeException.class)
    public void afterLastFourTestException2() {
        numArrays.afterLastFour(new int[]{1});
    }


}
