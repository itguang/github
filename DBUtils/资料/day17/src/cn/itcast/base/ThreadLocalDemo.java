package cn.itcast.base;

public class ThreadLocalDemo {
	public static void main(String[] args) {
		ThreadLocal tl = new ThreadLocal();   //�ڲ���һ��Map��key,��ǰ�̶߳���value����ŵĶ���
		tl.set("pp");//��tl��Map�д����һ������pp��
		
		new AnotherThread(tl).start();
		
		Object obj = tl.get();
		System.out.println(obj);
	}
}
