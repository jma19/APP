package com.mj.ele.guava;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by majun on 15/10/1.
 */
public class SupplierTest {

    @Test
    public void should_init_the_supplier_wrapped_object_when_get_object() throws Exception {
        Supplier<Integer> memoize = Suppliers.memoize(new Supplier<Integer>() {
            public Integer get() {
                System.out.println("init supplier wrapped object");
                return 1;
            }
        });
        System.out.println("main thread block");
        Thread.sleep(2000);
        System.out.println(memoize.get());
    }
    @Test
    public void should_init_the_supplier_wrapped_object_for_only_one_time() throws Exception {
        Supplier<Integer> memoize = Suppliers.memoize(new Supplier<Integer>() {
            public Integer get() {
                System.out.println("init supplier wrapped object");
                return 1;
            }
        });
        System.out.println(memoize.get());
        System.out.println(memoize.get());
    }
    @Test
    public void should_re_init_the_supplier_wrapped_object_when_set_the_expire_time() throws Exception {
        Supplier<Integer> memoize = Suppliers.memoizeWithExpiration(new Supplier<Integer>() {
            public Integer get() {
                System.out.println("init supplier wrapped object");
                return 1;
            }
        }, 5, TimeUnit.SECONDS);

        System.out.println(memoize.get());
        Thread.sleep(6000);
        System.out.println(memoize.get());
    }

}
