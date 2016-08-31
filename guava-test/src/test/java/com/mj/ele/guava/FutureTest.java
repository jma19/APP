package com.mj.ele.guava;

import com.google.common.util.concurrent.*;
import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;

/**
 * Created by majun on 15/9/29.
 */
public class FutureTest {
    @Test
    public void should_run_future_tasks_in_parallel() throws Exception {
        ListeningExecutorService service = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(10));
        ListenableFuture<?> task1 = service.submit(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(2000);
                    System.out.println("future task1 done.....");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        ListenableFuture<?> task2 = service.submit(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(2000);
                    System.out.println("future task2 done.....");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        System.out.println("main task done.....");
        Thread.sleep(3000);
    }

    @Test
    public void should_block_the_current_thread() throws Exception {
        ListeningExecutorService service = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(10));
        ListenableFuture<Integer> task = service.submit(new Callable<Integer>() {
            public Integer call() throws Exception {
                Thread.sleep(2000);
                System.out.println("future task done......");
                return 1;
            }
        });
        System.out.println(task.get());
        System.out.println("main task done.....");
    }

    @Test
    public void should_call_back_the_future_task() throws Exception {
        ListeningExecutorService service = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(10));
        ListenableFuture<Integer> task = service.submit(new Callable<Integer>() {
            public Integer call() throws Exception {
                Thread.sleep(2000);
                System.out.println("future task done......");
                return 1;
            }
        });
        Futures.addCallback(task, new FutureCallback() {
            public void onSuccess(Object o) {
                System.out.println("异步处理成功,result="+o);
            }

            public void onFailure(Throwable throwable) {
                System.out.println("异步处理失败,e="+throwable);
            }
        });

        System.out.println("main task done.....");
        Thread.sleep(3000);
    }


    @Test
    public void should_get_immil_the_future_task() throws Exception {
        ListeningExecutorService service = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(10));
        ListenableFuture<Integer> task = service.submit(new Callable<Integer>() {
            public Integer call() throws Exception {
                Thread.sleep(2000);
                System.out.println("future task done......");
                return 1;
            }
        });
        Futures.addCallback(task, new FutureCallback() {
            public void onSuccess(Object o) {
                System.out.println("异步处理成功,result="+o);
            }

            public void onFailure(Throwable throwable) {
                System.out.println("异步处理失败,e="+throwable);
            }
        });

        System.out.println("main task done.....");
        Thread.sleep(3000);

    }

    @Test
    public void should_transform_to_another_future_obj() throws Exception {
        ListeningExecutorService service = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(10));
        ListenableFuture<Integer> task = service.submit(new Callable<Integer>() {
            public Integer call() throws Exception {
                Thread.sleep(2000);
                System.out.println("future task done......");
                return 1;
            }
        });
        ListenableFuture<Boolean> transform = Futures.transform(task, new AsyncFunction<Integer, Boolean>() {
            public ListenableFuture<Boolean> apply(Integer integer) throws Exception {
                return integer > 0 ? Futures.immediateFuture(Boolean.TRUE):
                        Futures.immediateFuture(Boolean.FALSE);
            }
        });
        System.out.println(transform.get());
        Thread.sleep(3000);
    }

}
