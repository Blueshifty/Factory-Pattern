package java_exercise;

import java.net.Socket;
import java.io.IOException;

public class TaskFactory {
    
    public Runnable getTaskType(String task,int state){
        if(task == null){
            return null;
        }
        if(task.equals("ClientTask")){
            return new ClientTask(state);
        }
        return null;
    }
    
    public Runnable getTaskType(String task,Socket socket)throws IOException{
        if(task == null){
            return null;
        }
        if(task.equals("ServerTask")){
            return new ServerTask(socket);
        }
        return null;
    }
    
    
    
   
    
    
}
