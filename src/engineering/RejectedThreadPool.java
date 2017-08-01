package engineering;

import java.util.concurrent.*;

/**
 * @author liucong
 * @ClassName: RejectedThreadPool
 * @Description:
 * @date 2017年04月06日 下午3:02
 **/
public class RejectedThreadPool {
    public static class MyTask implements Runnable{
        @Override
        public void run() {
            System.out.println(System.currentTimeMillis()+":Thread ID:"+Thread.currentThread().getId());
            try{
                Thread.sleep(100);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException{
        MyTask mytask = new MyTask();
        ExecutorService es = new ThreadPoolExecutor(5,5,
                0, TimeUnit.MILLISECONDS,
                new LinkedBlockingDeque<Runnable>(10),
                Executors.defaultThreadFactory(),
                new RejectedExecutionHandler(){
                    @Override
                    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                        System.out.println(r.toString()+" is Discard");
                    }
                });
        for (int i = 0; i < 1000; i++) {
            es.submit(mytask);
            Thread.sleep(10);
        }
    }
}
