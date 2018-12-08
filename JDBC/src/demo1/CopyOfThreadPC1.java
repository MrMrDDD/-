package demo1;

import org.junit.Test;

public class CopyOfThreadPC1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Object object=new Object();
        new  Producer(object).start();
        new Consumer(object).start();

	}
	
	
	 /**
     * 产品
     */
    static class Produce{
       public volatile static String VALUE=null;
    }
    static class Consumer extends Thread
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
            	synchronized (object) {
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
    }

    /**
     * 生产者
     */
    static class Producer extends Thread
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
            	synchronized (object) {
            		 if (Produce.VALUE!=null)
                     {
                         try {
                             object.wait();
                         } catch (InterruptedException e) {
                             e.printStackTrace();
                         }
                     }
                     Produce.VALUE=""+System.currentTimeMillis();
                     System.out.println("产品标号："+Produce.VALUE);
                     object.notify();
				}
              
            }


        }
    }

}
//添加的内容//添加的内容