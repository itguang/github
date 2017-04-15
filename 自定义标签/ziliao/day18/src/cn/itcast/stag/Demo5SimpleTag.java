package cn.itcast.stag;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class Demo5SimpleTag extends SimpleTagSupport {
	//必须拿到主体内容
	@Override
	public void doTag() throws JspException, IOException {
		StringWriter sw = new StringWriter();//缓存字符串输出流
		JspFragment jf = getJspBody();
		jf.invoke(sw);
		String content = sw.toString();// 取到了主体内容
		//自己输出
		PageContext pc = (PageContext)getJspContext();
		pc.getOut().write(content.toUpperCase());
		
	}
	
}
