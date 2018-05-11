package com.hc.java.day_3;
/** 
* @author cathcool
* @version 创建时间：2018年4月16日 下午8:59:27 
* 类说明 
* 
* https://www.cnblogs.com/linkworld/p/7819270.html
*/
public class TestVolatile {
	 public static void main(String[] args){
	        ThreadDemo td = new ThreadDemo();
	        new Thread(td).start();

	        while(true){
	            if(td.isFlag()){
	                System.out.println("########");
	                break;
	            }
	        }
	    }
	}

	class ThreadDemo implements Runnable{
		// 
	    private volatile boolean flag = false;

	    public void run(){
	        try{
	            // 该线程 sleep(200), 导致了程序无法执行成功
	            Thread.sleep(200);
	        }catch(InterruptedException e){
	            e.printStackTrace();
	        }

	        flag = true;

	        System.out.println("flag="+isFlag());
	    }

	    public boolean isFlag(){
	        return flag;
	    }

	    public void setFlag(boolean flag){
	        this.flag = flag;
	    }
}
