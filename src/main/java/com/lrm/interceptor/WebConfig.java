package com.lrm.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by limi on 2017/10/15.
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/admin/**")
                .excludePathPatterns("/admin")
                .excludePathPatterns("/admin/login");
    }




/*int A(int Arr[]){
    int Counts = Arr.length - 1;
    for (int i=0;i<Counts;i++) {
        for (int j = 0; j < Counts - i; j++) {
            if (Arr[j] > Arr[j + 1]) {
                int tmp = Arr[j + 1];
                Arr[j + 1] = Arr[i];
                Arr[j] = tmp;
            }
        }

    }
}*/



    /**
     * @param args
     *
     */
//多线程在控制台循环输出十次abc

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        PrintTask printTask=new PrintTask();
        Thread thread1=new Thread(printTask,"a");
        Thread thread2=new Thread(printTask,"b");
        Thread thread3=new Thread(printTask,"c");
        thread1.start();
        thread2.start();
        thread3.start();



    }


}

class PrintTask implements Runnable{
    //用来标识当前应该是a还是b或者c
    private int count=0;

    //    private ReentrantLock lock=new ReentrantLock();
    @Override
    public void run() {
        // TODO Auto-generated method stub
        String nameString=Thread.currentThread().getName();

//		lock.lock();
        //this的含义是什么
        while (count<30) {
            synchronized (this) {
                if (count%3==0) {
                    //a
                    if (nameString.equalsIgnoreCase("a")) {

                        //小偷问题
                        if(count==0) {
                            int[] nums = new int[]{8, 9, 2, 28,10,2 };
                            int a = 0, b = 0, m = 0;
                            a=nums[0];
                            for (int i = 1; i < nums.length; i++) {
                                if (a < nums[i]) {
                                    a = nums[i];
                                    b = i;
                                }
                            }
                            m = a;
                            for (int j = 1; (b - 2 * j) >= 0 || (b + 2) * j <= nums.length; j++) {
                                if ((b - 2 * j) >= 0 && (b + 2) * j <= nums.length) {
                                    m += (nums[b - 2 * j] + nums[b + 2 * j]);
                                } else if ((b - 2 * j) >= 0 && (b + 2) * j > nums.length) {
                                    m += nums[b - 2 * j];
                                } else if ((b - 2 * j) < 0 && (b + 2) * j <= nums.length) {
                                    m += nums[b + 2 * j];
                                } else {
                                    System.out.println("++++");
                                }

                            }
                            System.out.println("这是m:"+m);
                        }
                        System.out.print("a");
                        count++;
                        this.notifyAll();
                    }
                    else {
                        try {
                            this.wait();
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                }
                if (count%3==1) {
                    //b
                    if (nameString.equalsIgnoreCase("b")) {
                        System.out.print("b");
                        count++;
                        this.notifyAll();
                    }
                    else {
                        try {
                            this.wait();
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                }
                if (count%3==2) {
                    if (nameString.equalsIgnoreCase("c")) {
                        System.out.print("c");
                        count++;
                        this.notifyAll();
                    }
                    else {
                        try {
                            this.wait();
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                }
            }
        }


//		lock.unlock();


    }

}























