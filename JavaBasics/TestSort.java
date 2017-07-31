/*
* @Author: aaronlai
* @Date:   2017-06-26 14:40:35
* @Last Modified by:   aaronlai
* @Last Modified time: 2017-06-26 16:10:39
*/
import org.junit.Test;
import static org.junit.Assert.*;


public class TestSort {
    /* Tests the Sort.sort method */
    @Test
    public static void testSort(){
        String[] inputs = {"milvia", "zero", "josh", "trump"};
        String[] expected = {"josh", "milvia", "trump", "zero"};
        String[] actual = Sort.sort(inputs);

        /* Don't reinvent the wheel. */
        // org.junit.Assert.assertArrayEquals(expected, actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public static void testIndexSmallest(){
        String[] inputs = {"milvia", "zero", "josh", "trump"};
        int expected = 2;
        // need "indexSmallest" to be public to test
        int actual = Sort.indexSmallest(inputs, 2);

        // org.junit.Assert.assertEquals(expected, actual);
        assertEquals(expected, actual);
    }

    public static void main(String[] args) {
        testSort();
        testIndexSmallest();
    }
}