package cn.itcast.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

public class Demo2Tag extends TagSupport {
	//SKIP_BODY:���Ա�ǩ����������
	//EVAL_BODY_INCLUDE:�����Ա�ǩ����������
	@Override
	public int doStartTag() throws JspException {
		
		return Tag.SKIP_BODY;
	}
	
}
