package cn.itcast.base;

public class AnotherThread extends Thread {
	private ThreadLocal tl;
	public AnotherThread(ThreadLocal tl){
		this.tl = tl;
	}
	public void run() {
		System.out.println("����һ���߳�ȡ������"+tl.get());
	}
	
}
