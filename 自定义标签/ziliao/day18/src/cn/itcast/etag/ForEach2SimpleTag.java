package cn.itcast.etag;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ForEach2SimpleTag extends SimpleTagSupport {
	private Object items;
	private String var;
	private Collection collection;

	public void setItems(Object items) {// 把内容统一放到collection中
		if (items instanceof List) {
			collection = (List) items;
		} else if (items instanceof Set) {
			collection = (Set) items;
		} else if (items instanceof Map) {
			collection = ((Map) items).entrySet();
		} else if (items.getClass().isArray()) {//判断是否是数组：无论基本类型的还是引用类型的
			collection = new ArrayList();
			int length = Array.getLength(items);//得到数组的长度
			for(int i=0;i<length;i++){
				collection.add(Array.get(items, i));
			}
		}else {
			throw new RuntimeException("对不起！不支持该类型的迭代操作");
		}
	}

	public void setVar(String var) {
		this.var = var;
	}

	@Override
	public void doTag() throws JspException, IOException {
		PageContext pc = (PageContext) getJspContext();

		for (Object obj : collection) {
			pc.setAttribute(var, obj);
			getJspBody().invoke(null);
		}
	}

}
