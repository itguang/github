�Զ����ǩ����
1���Զ����ǩ����JSP�����е�

һ����ǩ������
	�Ƴ���JSP�е�Java�ű�(<%%>)
������д�Զ����ǩ�Ĳ���(�Զ���EL������������ͬ)

	Tag�ӿڣ����еķ����������������õġ�
	
	������
		SKIP_BODY:���Ա�ǩ���������ݡ�ֻΪdoStartTag��������
		EVAL_BODY_INCLUDE:�����Ա�ǩ���������ݡ�ֻΪdoStartTag��������
		SKIP_PAGE:���Խ�����ǩ֮������ݡ�ֻΪdoEndTag��������
		EVAL_PAGE:�����Խ�����ǩ֮������ݡ�ֻΪdoEndTag��������
	������
		int doStartTag():�������á������Զ����ǩ�Ŀ�ʼ��ǩʱ�����á�
		int doEndTag():�������á������Զ����ǩ�Ľ���ʱ�����á�
		void setPageContext(PageContext pc):���������á������ǩ֮ǰ�ͻ���á�
		void setParent(Tag t):���������á������ǩ֮ǰ�ͻ���á�Ŀ�괫�ݽ�����ǩ��û�д���null��
		void release() :���������ã��ͷű�ǩ��ռ�õ���Դ��
		
		
	IterationTag�ӿڣ��̳�Tag�ӿڡ������ظ�ִ���������ݵķ���
		int doAfterBody():ִ���������ᱻ�������ø÷�����
			�÷����ķ���ֵֻ���ǣ�Tag.SKIP_BODY,�������壬���������ǩ����
								  IterationTag.EVAL_BODY_AGAIN����ִ��һ���������ݡ�
		
	BodyTag�ӿڣ��̳�IterationTag�ӿڡ������˻�ȡ�������ݵķ�����
		int EVAL_BODY_BUFFERED:��doStartTag()�����õġ�ֻ�з��ظ�ֵ������2�������Żᱻ�������á�
		
		void doInitBody():��ʼ�����塣��������
		void setBodyContent(BodyContent b) :�����������ݡ��������á�BodyContent�ʹ������������ݡ�
	
	SimpleTag�ӿڣ�
		void doTag():������ǩ��ִ�С��������á�
		void setJspBody(JspFragment jspBody):�������á������ǩ���������ݡ�
		void setJspContext(JspContext pc):�������á�����PageContext����
		void setParent(JspTag parent):�������á����븸��ǩ��
		
	
	
	1����дһ���ֱ࣬�ӻ���ʵ��javax.servlet.jsp.tagext.Tag�ӿ�
		package cn.itcast.tag;

		import java.io.IOException;

		import javax.servlet.jsp.JspException;
		import javax.servlet.jsp.tagext.TagSupport;
		//TagSupportʵ����Tag�ӿ�
		public class ShowRemoteIpTag extends TagSupport {

			public int doStartTag() throws JspException {
				String remoteIp = pageContext.getRequest().getRemoteAddr();
				try {
					pageContext.getOut().write(remoteIp);
				} catch (IOException e) {
					e.printStackTrace();
				}
				return super.doStartTag();
			}
		}
	2����WEB-INFĿ¼�½���һ����չ��Ϊtld��Tag Libary Definition����xml�ļ���
	<?xml version="1.0" encoding="UTF-8"?>
	<taglib xmlns="http://java.sun.com/xml/ns/j2ee"
		xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
		xsi:schemaLocation="http://java.sun.com/xml/ns/j2ee http://java.sun.com/xml/ns/j2ee/web-jsptaglibrary_2_0.xsd"
		version="2.0">
		<tlib-version>1.0</tlib-version>
		<short-name>itcast</short-name>
		<uri>http://www.itcast.cn/jsp/jstl</uri>
		<tag><!-- ������ǩ -->
			<description>Show Remote Address</description>
			<name>showRemoteIp</name>
			<tag-class>cn.itcast.tag.ShowRemoteIpTag</tag-class>
			<body-content>empty</body-content><!-- ָʾ��ǩ���������ݣ�û�о�дempty -->
		</tag>
	</taglib>
	3������ѡ�ģ���web.xml�ж�tld�ļ������ƿռ����ӳ���Ӧ��
	  <jsp-config>
		<taglib>
			<taglib-uri>http://www.itcast.cn/jsp/jstl</taglib-uri>
			<taglib-location>/WEB-INF/itcast.tld</taglib-location>
		</taglib>
	  </jsp-config>
	4����JSP��ʹ��
		<%@ taglib uri="http://www.itcast.cn/jsp/jstl" prefix="itcast"%>
������ǩִ�в����ԭ��

![](ziliao/��ǩ��ִ�в����ԭ��.jpg)

�ġ���ǩʵ�ֵĸ�������
	����jspҳ��ĳһ���������Ƿ�ִ�С�
	���ƽ�����ǩ���JSP�����Ƿ�ִ��
	����jspҳ�������ظ�ִ�С�
	�޸�ҳ���������
�塢JSP�б�ǩ�̳���ϵ
�����򵥱�ǩԭ��
�ߡ���ǩ������Ԫ�����
	tld�ļ���
	taglib����Ԫ��
		tlib-version:�汾��
		short-name:���ñ�ǩʱ�Ķ����ơ�һ����tld�ļ����ļ���һ�£����ҡ�
		uri����ǩ�󶨵����ƿռ䡣ֻ��һ�����֣�û��ʵ�ʵ����塣
		tag�������ǩԪ��
			name����ǩ�����ơ�
			tag-class:��ǩ��ʵ�����ȫ���ơ�
			body-content:ָʾ��ǩ���������ݵ����͡�
				��ѡֵ��
					empty:û���������ݡ������ڴ�ͳ�ͼ򵥱�ǩ��
					JSP:˵��JSP�ļ����ܳ���ɶ����ǩ���������о��ܳ���ɶ�������ڴ�ͳ��ǩ��
					scriptless��˵����ǩ���������ݲ�����java�ű��������ڼ򵥱�ǩ��
					tagdependent��˵����ǩ������������ԭ�ⲻ���Ĵ��ݸ���ǩ������ġ�
								�����Ǵ��ݵ�������
			attribute�������ǩ������
				name������������Ӧ��ǩ�������е�setter����
				required:�Ƿ��Ǳ��������
				rtexprvalue���Ƿ�֧�ֱ��ʽ��EL��java���ʽ����Ĭ����false��
					
�ˡ���ǩ��ʵ�ð�����
	������
	ģ��c:if
	ģ��c:when c:otherwise c:choose
	ģ��c:forEach
		java.lang.reflect.Array
	����HTML��ǵı�ǩ
�š�JSTL�е�ʣ����ı�ǩ