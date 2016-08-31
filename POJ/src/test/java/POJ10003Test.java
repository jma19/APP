import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by majun on 15/11/1.
 */
public class POJ10003Test {
    //    //1.00
//    3.71
//            0.04
//            5.19
//            0.00

    @Test
    public void should_get_3_card_number_when_input_1() throws Exception {
        double cardsNmberByResult = POJ10003.getCardsNmberByResult(1.00);
        assertThat(cardsNmberByResult, is(3.0));
    }
    @Test
    public void should_get_61_card_number_when_input_3_71() throws Exception {
        double cardsNmberByResult = POJ10003.getCardsNmberByResult(3.71);
        System.out.println(cardsNmberByResult);
//        assertThat(cardsNmberByResult, is(61));
    }

    @Test
    public void should_get_1_card_number_when_input_0_04() throws Exception {
        double cardsNmberByResult = POJ10003.getCardsNmberByResult(0.04);
        assertThat(cardsNmberByResult, is(1.0));
    }

    @Test
    public void should_get_5_19_card_number_when_input_273() throws Exception {
        double cardsNmberByResult = POJ10003.getCardsNmberByResult(5.19);
        assertThat(cardsNmberByResult, is(273.0));
    }


}