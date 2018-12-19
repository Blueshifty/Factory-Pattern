package java_exercise;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientTask implements Runnable {
    private final int state;
    public ClientTask(int state) {
	this.state = state;

    }
    
    public void run(){
	try {
	    Socket socket = new Socket("localhost", TcpServer.PORT);
	    ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
	    out.writeObject(new ShippableTask(state));
	    out.flush();
	    ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
	    Integer result = (Integer) in.readObject();
	    System.out.println(result);
	    socket.close();
	} catch (Exception e) {
	    e.printStackTrace();
	}
	
    }
    
}
