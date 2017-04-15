package cn.itcast.test;

import cn.itcast.service.impl.AccountServiceImpl;

public class Client {

	public static void main(String[] args) {
		AccountServiceImpl s = new AccountServiceImpl();
		s.transfer("bbb", "aaa", 100);
		System.out.println(Integer.MAX_VALUE);
	}

}
