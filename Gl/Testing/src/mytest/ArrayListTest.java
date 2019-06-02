package mytest;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class ArrayListTest {
    private ArrayList<String> list = new ArrayList();

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testInsertion (){
        list.add("Beijing");
        assertEquals("Beijing", list.get(0));
        list.add("Shanghai");
        list.add("Hongkong");
        assertEquals("Hongkong", list.get(list.size()-1));
    }

    @Test
    public void testDeletation() {
        list.clear();
        assertTrue(list.isEmpty());

        list.add("a");
        list.add("b");
        list.add("c");
        list.remove("b");
        assertEquals(2,list.size());
    }
}
