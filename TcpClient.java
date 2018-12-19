package java_exercise;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TcpClient {
    private static final int POOL_SIZE = 10;
    private static final int RUNS = 100;
   
    TaskFactory Factory = new TaskFactory();
    
    
    
    
    void fire() {
	ExecutorService executor = Executors.newFixedThreadPool(POOL_SIZE);
	
	for ( int i = 0; i < RUNS; i++ ) {
            executor.execute(Factory.getTaskType("ClientTask", i));//Factory
            //executor.execute(new ClientTask(i));
	}
	executor.shutdown();
    }
    
    public static final void main(String[] args)  {
	new TcpClient().fire();
    }
    
}
