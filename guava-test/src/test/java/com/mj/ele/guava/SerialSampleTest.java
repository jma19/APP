package com.mj.ele.guava;

import org.junit.Before;
import org.junit.Test;

import java.io.Serializable;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by majun on 15/10/15.
 */
public class SerialSampleTest {


    @Test
    public void should_serialize_and_deserizlie_when_given_a_seriable_object() throws Exception {
        //given
        SerialSample serialSample=new SerialSample();
        Employee employee=new Employee("xiaoya",1);
        //when
        byte[] serialize = serialSample.Serialize(employee);
        Employee result = (Employee) serialSample.deSerialize(serialize);
        //then
        assertThat(result,is(employee));
    }


}