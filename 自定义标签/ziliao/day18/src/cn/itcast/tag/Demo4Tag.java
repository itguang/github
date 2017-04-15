package cn.itcast.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.IterationTag;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

public class Demo4Tag extends TagSupport {
	private int count;
	private int temp;
	//�ڵ���doStartTag֮ǰ������������Ե�ֵ�Զ���������
	public void setCount(int count) {
		this.count = count;
		this.temp = count;
	}
	@Override
	public int doStartTag() throws JspException {
		return Tag.EVAL_BODY_INCLUDE;
	}
	@Override
	public int doAfterBody() throws JspException {
		count--;
//		System.out.println(count);
		if(count>0){
		//count--,����0����Ūһ��
			return IterationTag.EVAL_BODY_AGAIN;
		}else{
		//���򣬽��������ǩ
			count = temp;
			return Tag.SKIP_BODY;
		}
	}

	
	
}
