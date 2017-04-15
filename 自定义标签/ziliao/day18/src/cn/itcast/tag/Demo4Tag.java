package cn.itcast.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.IterationTag;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

public class Demo4Tag extends TagSupport {
	private int count;
	private int temp;
	//在调用doStartTag之前，容器会把属性的值自动传进来。
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
		//count--,大于0，再弄一次
			return IterationTag.EVAL_BODY_AGAIN;
		}else{
		//否则，进入结束标签
			count = temp;
			return Tag.SKIP_BODY;
		}
	}

	
	
}
