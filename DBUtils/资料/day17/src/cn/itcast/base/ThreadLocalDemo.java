package cn.itcast.base;

public class ThreadLocalDemo {
	public static void main(String[] args) {
		ThreadLocal tl = new ThreadLocal();   //内部有一个Map：key,当前线程对象；value：你放的东东
		tl.set("pp");//向tl的Map中存放了一个对象pp。
		
		new AnotherThread(tl).start();
		
		Object obj = tl.get();
		System.out.println(obj);
	}
}
