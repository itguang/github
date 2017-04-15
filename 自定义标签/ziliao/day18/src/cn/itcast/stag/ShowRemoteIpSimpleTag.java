package cn.itcast.stag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ShowRemoteIpSimpleTag extends SimpleTagSupport {
	public ShowRemoteIpSimpleTag(){
		System.out.println("调用了简单标签类的构造方法");
	}
	@Override
	public void doTag() throws JspException, IOException {
		PageContext pc = (PageContext)getJspContext();
		String remoteIp = pc.getRequest().getRemoteAddr();
	    pc.getOut().write(remoteIp);
	}
	
}
