package cn.itcast.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTag;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class Demo5Tag extends BodyTagSupport {
	//Ҫ��֤�������ݱ��������ݽ���
	@Override
	public int doStartTag() throws JspException {
		return BodyTag.EVAL_BODY_BUFFERED;
	}
	//���޸ĺ���������������ҳ����
	@Override
	public int doEndTag() throws JspException {
		//�õ���������
		String content = bodyContent.getString();
		try {
			pageContext.getOut().write(content.toUpperCase());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return super.doEndTag();
	}

	
	
}
