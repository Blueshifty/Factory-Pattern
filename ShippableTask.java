package java_exercise;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

public class ShippableTask implements Serializable, IShippableTask<Integer> {
    private static final long serialVersionUID = 1L;
    private final int state; 
    
    public ShippableTask(int state) {
	this.state = state;
    }

    @Override
    public Integer execute() throws InterruptedException {
	TimeUnit.SECONDS.sleep(1);
	return state;
    }

    @Override
    public String toString() {
	return "Task";
    }

}
