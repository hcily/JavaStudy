package com.hc.java.day_7;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;

import javax.security.auth.callback.Callback;

/**
 * @author cathcool
 * @version 创建时间：2018年4月22日 下午10:26:12 类说明
 */
public class ExecutorServiceTest {

	public static void main(String[] args) {
		ExecutorService executorService = new ScheduledThreadPoolExecutor(1);

		RunnableFuture<Integer> runnableFuture = new FutureTask<>(new Callable<Integer>() {
			@Override
			public Integer call() throws Exception {
				// TODO Auto-generated method stub
				Thread.sleep(2000);
				System.out.println("call.");
				return 99;
			}
		});

		System.out.println("isDone:" + runnableFuture.isDone());

//		executorService.submit(runnableFuture);
		executorService.execute(runnableFuture);
		
		executorService.shutdown();
		
		//executorService.execute(runnableFuture);
		
		try {
			System.out.println("get:" + runnableFuture.get());
			System.out.println("isDone:" + runnableFuture.isDone());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		ExecutorCompletionService<Integer> executorCompletionService = new ExecutorCompletionService<>(executorService);
		
		
	}
}
