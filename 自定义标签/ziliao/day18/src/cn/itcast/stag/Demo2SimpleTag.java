package cn.itcast.stag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class Demo2SimpleTag extends SimpleTagSupport {
	//�÷���ʲô����������ô�������ݾͲ���ʵ
	@Override
	public void doTag() throws JspException, IOException {
//		//��ȡ��������
//		JspFragment jf = getJspBody();
//		//���뼴��
//		PageContext pc = (PageContext)getJspContext();
//		JspWriter out = pc.getOut();
//		jf.invoke(out);//���������������ָ�������С�
		
		getJspBody().invoke(null);//���������ϴ�����ȫ��ͬ
		
	}
	
}
