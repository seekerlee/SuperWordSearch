package me.qingkou.superws;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static junit.framework.Assert.assertNull;
import static junit.framework.Assert.assertTrue;

/**
 * User: seeker
 * Date: 11/16/13
 * Time: 2:18 PM
 */
public class WordSearchTest {
    private static WordSearch wrapSearch;
    private static WordSearch noWrapSearch;
    /*
    ABCD
    EFGH
    IJKL
     */
    @Before
    public void init() throws Exception {
        wrapSearch = new WordSearch(3, 3, WordSearch.Mode.WRAP, "ABCD", "EFGH", "IJKL");
        noWrapSearch = new WordSearch(3, 3, WordSearch.Mode.NO_WRAP, "ABCD", "EFGH", "IJKL");
    }

    @Test
    public void testWrapSearch() {
        List<Position> r0 = wrapSearch.search("ABCD");
        List<Position> r1 = wrapSearch.search("CDA");
        List<Position> r2 = wrapSearch.search("C");
        List<Position> r3 = wrapSearch.search("CLEB");
        List<Position> r4 = wrapSearch.search("KLK");
        assertTrue("ABCD found: ", r0 != null);
        for(Position position : r0) {
            System.out.print(position);
        }
        System.out.println();
        assertTrue("CDA found: ", r1 != null);
        for(Position position : r1) {
            System.out.print(position);
        }
        System.out.println();
        assertTrue("C found: ", r2 != null);
        for(Position position : r2) {
            System.out.print(position);
        }
        System.out.println();
        assertTrue("CLEB found: ", r3 != null);
        for(Position position : r3) {
            System.out.print(position);
        }
        System.out.println();
        assertNull("KLK not found", r4);
    }

    @Test
    public void testNoWrapSearch() {
        List<Position> r0 = noWrapSearch.search("ABCD");
        List<Position> r1 = noWrapSearch.search("CDA");
        List<Position> r2 = noWrapSearch.search("C");
        List<Position> r3 = noWrapSearch.search("BGLA");
        List<Position> r4 = noWrapSearch.search("KLK");
        assertTrue("ABCD found: ", r0 != null);
        for(Position position : r0) {
            System.out.print(position);
        }
        System.out.println();
        assertTrue("CDA not found: ", r1 == null);
        assertTrue("C found: ", r2 != null);
        for(Position position : r2) {
            System.out.print(position);
        }
        System.out.println();
        assertTrue("BGLA not found: ", r3 == null);
        assertNull("KLK not found", r4);
    }
}
