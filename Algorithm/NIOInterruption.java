package com.csdhsm.concurrent;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousCloseException;
import java.nio.channels.ClosedByInterruptException;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/** 
 * @Title: NIOInterruption.java
 * @Package: com.csdhsm.concurrent
 * @Description 
 * @author Han
 * @date 2016-4-11 下午6:25:29 
 * @version V1.0
 */ 
  	
class NIOBlocked implements Runnable{

	private final SocketChannel sc;
	
	public NIOBlocked(SocketChannel sc) {
		
		this.sc = sc;
	}
	
	@Override
	public void run() {
		
		try {
			
			System.out.println("Waiting for read() in " + this);
			sc.read(ByteBuffer.allocate(1));
			
		} catch (ClosedByInterruptException e){
			
			System.out.println("ClosedByInterruptException");
		} catch (AsynchronousCloseException e){
			
			System.out.println("AsynchronousCloseException");
		} catch (IOException e) {
			
			throw new RuntimeException(e);
		}
		
		System.out.println("Exiting NIOBlocked.run() " + this);
	}
}

public class NIOInterruption {
		
	@SuppressWarnings("unused")
	public static void main(String[] args) throws IOException, Exception {
		
		ExecutorService service = Executors.newCachedThreadPool();
		ServerSocket socket = new ServerSocket(8080);
		
		InetSocketAddress isa = new InetSocketAddress("localhost", 8080);
		
		SocketChannel sc1 = SocketChannel.open(isa);
		SocketChannel sc2 = SocketChannel.open(isa);
		
		Future<?> f = service.submit(new NIOBlocked(sc1));
		service.execute(new NIOBlocked(sc2));
		
		service.shutdown();
		
		TimeUnit.SECONDS.sleep(1);
		
		f.cancel(true);

		TimeUnit.SECONDS.sleep(1);
		
		sc2.close();
	}
}
