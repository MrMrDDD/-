package com.example.cn.application.chenjinshi;

import org.junit.Test;
public class Main2ActivityTest {


    @Test
    public void useAppContext() {
//        // Context of the app under test.
//        Context appContext = InstrumentationRegistry.getTargetContext();
//
//        assertEquals("com.example.cn.application", appContext.getPackageName());
//        System.out.println("测试")
        Object object=new Object();
        new  Producer(object).start();
        new Consumer(object).start();


    }

    /**
     * 产品
     */
    static class Produce{
       volatile static String VALUE=null;
    }
    class Consumer extends Thread
    {
        Object object;
        public Consumer(Object object)
        {
            this.object=object;
        }
        @Override
        public void run() {
            super.run();
            while(true)
            {
                if(Produce.VALUE==null)
                {
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("消费编号"+Produce.VALUE);
                Produce.VALUE=null;
                object.notify();
            }

        }
    }

    /**
     * 生产者
     */
    class Producer extends Thread
    {
        Object object;
        public Producer(Object object)
        {
            this.object=object;
        }
        @Override
        public void run() {
            super.run();
            while(true)
            {
               if (Produce.VALUE!=null)
               {
                   try {
                       object.wait();
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }
               Produce.VALUE="产品标号："+System.currentTimeMillis();
               System.out.println(Produce.VALUE);
               object.notify();
            }


        }
    }
}