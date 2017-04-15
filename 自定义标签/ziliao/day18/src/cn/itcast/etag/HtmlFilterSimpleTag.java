package cn.itcast.etag;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class HtmlFilterSimpleTag extends SimpleTagSupport {
	// < > " ' &进行转义输出即可
	@Override
	public void doTag() throws JspException, IOException {
		StringWriter sw = new StringWriter();
		getJspBody().invoke(sw);
		String content = sw.toString();//   <hr/>
		content = filter(content);//   <hr/>---->  &lt;ht/&gt;
		PageContext pc = (PageContext)getJspContext();
		pc.getOut().write(content);
	}

	private String filter(String message) {
		if (message == null)
            return (null);

        char content[] = new char[message.length()];
        message.getChars(0, message.length(), content, 0);
        StringBuffer result = new StringBuffer(content.length + 50);
        for (int i = 0; i < content.length; i++) {
            switch (content[i]) {
            case '<':
                result.append("&lt;");
                break;
            case '>':
                result.append("&gt;");
                break;
            case '&':
                result.append("&amp;");
                break;
            case '"':
                result.append("&quot;");
                break;
            default:
                result.append(content[i]);
            }
        }
        return (result.toString());
	}
	
}
