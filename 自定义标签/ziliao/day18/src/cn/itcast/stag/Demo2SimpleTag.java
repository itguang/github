package cn.itcast.stag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class Demo2SimpleTag extends SimpleTagSupport {
	//该方法什么都不做，那么主体内容就不现实
	@Override
	public void doTag() throws JspException, IOException {
//		//获取主体内容
//		JspFragment jf = getJspBody();
//		//输入即可
//		PageContext pc = (PageContext)getJspContext();
//		JspWriter out = pc.getOut();
//		jf.invoke(out);//把主体内容输出到指定的流中。
		
		getJspBody().invoke(null);//作用与以上代码完全相同
		
	}
	
}
