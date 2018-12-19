package java_exercise;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ServerTask implements Runnable {
    private Socket socket;
    private ObjectOutputStream out;
    private ObjectInputStream in;
    

    public ServerTask(Socket socket) throws IOException {
	this.socket = socket;
	out = new ObjectOutputStream(socket.getOutputStream());
	in = new ObjectInputStream(socket.getInputStream());

    }


    @Override
    public void run() {
	try { 
	    ShippableTask task = (ShippableTask) in.readObject();
	    Object result = task.execute();
	    out.writeObject(result);
	    out.flush();
	    socket.close();
	} catch (Exception e) {
	    e.printStackTrace();
	} 
    }


    @Override
    public String toString() {
	return "TcpTask [port=" + socket.getLocalPort() + "]";
    }
    
    
}
