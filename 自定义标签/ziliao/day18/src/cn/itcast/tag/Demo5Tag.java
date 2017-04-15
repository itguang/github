package cn.itcast.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTag;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class Demo5Tag extends BodyTagSupport {
	//要保证主体内容被容器传递进来
	@Override
	public int doStartTag() throws JspException {
		return BodyTag.EVAL_BODY_BUFFERED;
	}
	//把修改后的主体内容输出到页面上
	@Override
	public int doEndTag() throws JspException {
		//得到主体内容
		String content = bodyContent.getString();
		try {
			pageContext.getOut().write(content.toUpperCase());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return super.doEndTag();
	}

	
	
}
