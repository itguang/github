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

	public void setItems(Object items) {// ������ͳһ�ŵ�collection��
		if (items instanceof List) {
			collection = (List) items;
		} else if (items instanceof Set) {
			collection = (Set) items;
		} else if (items instanceof Map) {
			collection = ((Map) items).entrySet();
		} else if (items.getClass().isArray()) {//�ж��Ƿ������飺���ۻ������͵Ļ����������͵�
			collection = new ArrayList();
			int length = Array.getLength(items);//�õ�����ĳ���
			for(int i=0;i<length;i++){
				collection.add(Array.get(items, i));
			}
		}else {
			throw new RuntimeException("�Բ��𣡲�֧�ָ����͵ĵ�������");
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
