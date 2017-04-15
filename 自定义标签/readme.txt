自定义标签开发
1、自定义标签属于JSP技术中的

一、标签的作用
	移除掉JSP中的Java脚本(<%%>)
二、编写自定义标签的步骤(自定义EL函数，步骤相同)

	Tag接口：其中的方法都是由容器调用的。
	
	常量：
		SKIP_BODY:忽略标签的主体内容。只为doStartTag方法服务
		EVAL_BODY_INCLUDE:不忽略标签的主体内容。只为doStartTag方法服务
		SKIP_PAGE:忽略结束标签之后的内容。只为doEndTag方法服务
		EVAL_PAGE:不忽略结束标签之后的内容。只为doEndTag方法服务
	方法：
		int doStartTag():容器调用。遇到自定义标签的开始标签时被调用。
		int doEndTag():容器调用。遇到自定义标签的结束时被调用。
		void setPageContext(PageContext pc):由容器调用。处理标签之前就会调用。
		void setParent(Tag t):由容器调用。处理标签之前就会调用。目标传递进父标签，没有传递null。
		void release() :由容器调用，释放标签类占用的资源。
		
		
	IterationTag接口：继承Tag接口。增加重复执行主体内容的方法
		int doAfterBody():执行完主体后会被容器调用该方法。
			该方法的返回值只能是：Tag.SKIP_BODY,忽略主体，进入结束标签处理。
								  IterationTag.EVAL_BODY_AGAIN，再执行一次主体内容。
		
	BodyTag接口：继承IterationTag接口。增加了获取主体内容的方法。
		int EVAL_BODY_BUFFERED:给doStartTag()方法用的。只有返回该值，以下2个方法才会被容器调用。
		
		void doInitBody():初始化主体。容器调用
		void setBodyContent(BodyContent b) :设置主体内容。容器调用。BodyContent就代表着主体内容。
	
	SimpleTag接口：
		void doTag():遇到标签就执行。容器调用。
		void setJspBody(JspFragment jspBody):容器调用。传入标签的主体内容。
		void setJspContext(JspContext pc):容器调用。传入PageContext对象。
		void setParent(JspTag parent):容器调用。传入父标签。
		
	
	
	1、编写一个类，直接或间接实现javax.servlet.jsp.tagext.Tag接口
		package cn.itcast.tag;

		import java.io.IOException;

		import javax.servlet.jsp.JspException;
		import javax.servlet.jsp.tagext.TagSupport;
		//TagSupport实现了Tag接口
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
	2、在WEB-INF目录下建立一个扩展名为tld（Tag Libary Definition）的xml文件。
	<?xml version="1.0" encoding="UTF-8"?>
	<taglib xmlns="http://java.sun.com/xml/ns/j2ee"
		xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
		xsi:schemaLocation="http://java.sun.com/xml/ns/j2ee http://java.sun.com/xml/ns/j2ee/web-jsptaglibrary_2_0.xsd"
		version="2.0">
		<tlib-version>1.0</tlib-version>
		<short-name>itcast</short-name>
		<uri>http://www.itcast.cn/jsp/jstl</uri>
		<tag><!-- 描述标签 -->
			<description>Show Remote Address</description>
			<name>showRemoteIp</name>
			<tag-class>cn.itcast.tag.ShowRemoteIpTag</tag-class>
			<body-content>empty</body-content><!-- 指示标签的主体内容：没有就写empty -->
		</tag>
	</taglib>
	3、（可选的）在web.xml中对tld文件和名称空间进行映射对应。
	  <jsp-config>
		<taglib>
			<taglib-uri>http://www.itcast.cn/jsp/jstl</taglib-uri>
			<taglib-location>/WEB-INF/itcast.tld</taglib-location>
		</taglib>
	  </jsp-config>
	4、在JSP中使用
		<%@ taglib uri="http://www.itcast.cn/jsp/jstl" prefix="itcast"%>
三、标签执行步骤和原理

![](ziliao/标签的执行步骤和原理.jpg)

四、标签实现的附属功能
	控制jsp页面某一部分内容是否执行。
	控制结束标签后的JSP内容是否执行
	控制jsp页面内容重复执行。
	修改页面内容输出
五、JSP中标签继承体系
六、简单标签原理
七、标签的配置元素详解
	tld文件：
	taglib：根元素
		tlib-version:版本号
		short-name:引用标签时的短名称。一般与tld文件的文件名一致，好找。
		uri：标签绑定的名称空间。只是一个名字，没有实际的意义。
		tag：定义标签元素
			name：标签的名称。
			tag-class:标签的实现类的全名称。
			body-content:指示标签的主体内容的类型。
				可选值：
					empty:没有主体内容。适用于传统和简单标签。
					JSP:说明JSP文件中能出现啥，标签主体内容中就能出现啥。适用于传统标签。
					scriptless：说明标签的主体内容不能是java脚本。适用于简单标签。
					tagdependent：说明标签的主体内容是原封不动的传递给标签处理类的。
								而不是传递的运算结果
			attribute：定义标签的属性
				name：属性名。对应标签处理类中的setter方法
				required:是否是必须的属性
				rtexprvalue：是否支持表达式（EL或java表达式）。默认是false。
					
八、标签的实用案例：
	防盗链
	模拟c:if
	模拟c:when c:otherwise c:choose
	模拟c:forEach
		java.lang.reflect.Array
	过滤HTML标记的标签
九、JSTL中的剩余核心标签