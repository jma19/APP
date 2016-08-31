import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by majun on 15/11/1.
 */
public class POJ1002Test {
    POJ1002 poj1002 = new POJ1002();

    @Test
    public void should_map_to_tele_number() throws Exception {
        assertThat(poj1002.mapToTeleNUmber("4873279"), is("487-3279"));
    }

    @Test
    public void testName() throws Exception {
        System.out.println(poj1002.mapToTeleNUmber("ITS-EASY"));
    }

    @Test
    public void shoud_be_char() throws Exception {
        assertThat(poj1002.isChar('A'), is(true));
    }

    @Test
    public void shoud_be_char_number() throws Exception {
        assertThat(poj1002.isDigit('9'), is(true));
    }

}