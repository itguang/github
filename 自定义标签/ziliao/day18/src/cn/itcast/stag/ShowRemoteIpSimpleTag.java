package cn.itcast.stag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ShowRemoteIpSimpleTag extends SimpleTagSupport {
	public ShowRemoteIpSimpleTag(){
		System.out.println("�����˼򵥱�ǩ��Ĺ��췽��");
	}
	@Override
	public void doTag() throws JspException, IOException {
		PageContext pc = (PageContext)getJspContext();
		String remoteIp = pc.getRequest().getRemoteAddr();
	    pc.getOut().write(remoteIp);
	}
	
}
