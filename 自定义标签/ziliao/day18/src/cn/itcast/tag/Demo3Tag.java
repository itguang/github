package cn.itcast.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

public class Demo3Tag extends TagSupport {
	//SKIP_PAGE:���Խ�����ǩ֮�������
	//EVAL_PAGE:�����Խ�����ǩ֮�������
	@Override
	public int doEndTag() throws JspException {
		return Tag.SKIP_PAGE;
	}
	
}
