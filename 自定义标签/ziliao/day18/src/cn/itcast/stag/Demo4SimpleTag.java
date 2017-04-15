package cn.itcast.stag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class Demo4SimpleTag extends SimpleTagSupport {
	private int count;//自动类型转换仅限基本类型

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public void doTag() throws JspException, IOException {
		for(int i=0;i<count;i++)
			getJspBody().invoke(null);
	}
	
	
}
