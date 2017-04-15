package cn.itcast.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
//TagSupportʵ����Tag�ӿ�
public class ShowRemoteIpTag extends TagSupport {
	public ShowRemoteIpTag(){
		System.out.println("������Ĭ�ϵĹ��췽��");
	}
	public int doStartTag() throws JspException {
		String remoteIp = pageContext.getRequest().getRemoteAddr();
		try {
			pageContext.getOut().write(remoteIp);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return super.doStartTag();
	}
}
