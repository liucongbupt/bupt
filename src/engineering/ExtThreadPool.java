package engineering;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author liucong
 * @ClassName: ExtThreadPool
 * @Description:
 * @date 2017年04月06日 下午3:12
 **/
public class ExtThreadPool {
    List<String> l = new ArrayList<>();

    public static class MyTask implements Runnable{
        public String name;
        public MyTask(String name){
            this.name=name;
        }
        @Override
        public void run() {
            System.out.println("正在执行"+":Thread ID:"+Thread.currentThread().getId()+",Task Name="+name);
            try {
                Thread.sleep(100);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException{
        ExecutorService es = new ThreadPoolExecutor(5,5,0L, TimeUnit.MILLISECONDS,new LinkedBlockingDeque<Runnable>()){
            @Override
            protected void beforeExecute(Thread t, Runnable r) {
                super.beforeExecute(t, r);
                System.out.println("准备执行"+((MyTask)r).name);
            }

            @Override
            protected void afterExecute(Runnable r, Throwable t) {
                super.afterExecute(r, t);
                System.out.println("执行完成"+((MyTask)r).name);
            }

            @Override
            protected void terminated() {
                super.terminated();
                System.out.println("线程池退出");
            }
        };
        for (int i = 0; i < 5; i++) {
            MyTask mt =new MyTask("TASK_NAME"+i);
            es.execute(mt);
            Thread.sleep(10);
        }
        es.shutdown();
    }
}
