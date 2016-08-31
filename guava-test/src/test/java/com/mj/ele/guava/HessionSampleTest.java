package com.mj.ele.guava;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by majun on 15/10/15.
 */
public class HessionSampleTest {

    @Test
    public void should_serialize_and_deserizlie_object_when_apply_java_serialize() throws Exception {
        //when
        HessionSample hessionSample = new HessionSample();
        Employee employee = new Employee("xiaoya", 1);
        //given
        byte[] serialize = hessionSample.Serialize(employee);
        Employee result = (Employee) hessionSample.deSerialize(serialize);
        //then
        assertThat(result, is(employee));
    }


}