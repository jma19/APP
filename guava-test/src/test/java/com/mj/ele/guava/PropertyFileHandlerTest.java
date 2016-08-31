package com.mj.ele.guava;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by majun on 15/10/11.
 */
public class PropertyFileHandlerTest {
    @Test
    public void should_get_string_value() throws Exception {
        String name = PropertyFileHandler.getString("name");
        assertThat(name.equals("xiaoya"), is(true));
    }

    @Test
    public void should_get_int_value() throws Exception {
        int passwd = PropertyFileHandler.getInt("passwd");
        assertThat(passwd, is(123));
    }
}