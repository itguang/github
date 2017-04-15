package cn.itcast.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

public class Demo2Tag extends TagSupport {
	//SKIP_BODY:忽略标签的主体内容
	//EVAL_BODY_INCLUDE:不忽略标签的主体内容
	@Override
	public int doStartTag() throws JspException {
		
		return Tag.SKIP_BODY;
	}
	
}
