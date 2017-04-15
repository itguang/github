package cn.itcast.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

public class Demo3Tag extends TagSupport {
	//SKIP_PAGE:忽略结束标签之后的内容
	//EVAL_PAGE:不忽略结束标签之后的内容
	@Override
	public int doEndTag() throws JspException {
		return Tag.SKIP_PAGE;
	}
	
}
