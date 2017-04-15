package cn.itcast.etag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ChooseSimpleTag extends SimpleTagSupport {
	private boolean flag;

	protected boolean isFlag() {
		return flag;
	}

	protected void setFlag(boolean flag) {
		this.flag = flag;
	}

	@Override
	public void doTag() throws JspException, IOException {
		getJspBody().invoke(null);
	}
	
	
}
