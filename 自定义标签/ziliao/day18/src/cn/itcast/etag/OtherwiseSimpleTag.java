package cn.itcast.etag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class OtherwiseSimpleTag extends SimpleTagSupport {

	@Override
	public void doTag() throws JspException, IOException {
		ChooseSimpleTag parent = (ChooseSimpleTag)getParent();
		if(!parent.isFlag())
			getJspBody().invoke(null);
	}
	
}
