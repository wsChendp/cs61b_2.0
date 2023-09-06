package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE
    @Test
    public void testThreeAddThreeRemove(){
        AListNoResizing<Integer> correct = new AListNoResizing<>();
        BuggyAList<Integer> broken = new BuggyAList<>();
        int N = 10;
        for (int i = 0; i < 10; i++) {
            int randVal = StdRandom.uniform(0,100);
            correct.addLast(randVal);
            broken.addLast(randVal);
        }
        assertEquals(correct.size(),broken.size());
        for (int i = 0; i < N; i++) {
            assertEquals(broken.removeLast(),correct.removeLast());
        }
    }

    @Test
    public void randomizedTest(){
        AListNoResizing<Integer> correct = new AListNoResizing<>();
        BuggyAList<Integer> broken = new BuggyAList<>();
        int N = 5000;
        int operation = 0;
        int randVal = 0;
        for (int i = 0; i < N; i++) {
            operation = StdRandom.uniform(0,4);
            if(operation == 0){
                randVal = StdRandom.uniform(0,100);
                correct.addLast(randVal);
                broken.addLast(randVal);
            } else if (correct.size() == 0) {
                continue;
            } else if (operation == 1) {
                assertEquals(correct.size(),broken.size());
            } else if (operation == 2) {
                assertEquals(correct.getLast(),correct.getLast());
            } else if (operation == 3) {
                assertEquals(correct.removeLast(),broken.removeLast());
            }
        }
    }



}
