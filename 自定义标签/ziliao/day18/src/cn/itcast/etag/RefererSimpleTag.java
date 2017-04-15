package cn.itcast.etag;

import java.io.IOException;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class RefererSimpleTag extends SimpleTagSupport {
	private String site;//允许直接访问的网站
	private String adPage;//广告页面。非法盗链者要先看广告
	
	public void setSite(String site) {
		this.site = site;
	}

	public void setAdPage(String adPage) {
		this.adPage = adPage;
	}

	@Override
	public void doTag() throws JspException, IOException {
		PageContext pc = (PageContext)getJspContext();
		ServletRequest req = pc.getRequest();
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)pc.getResponse();
		//得到请求的referer头
		String refererValue = request.getHeader("referer");
		//如果不是null，并且不是以site开头的：看广告
		if(refererValue!=null){
			if(!refererValue.startsWith(site)){
				if(adPage.startsWith("/")){
					response.sendRedirect(request.getContextPath()+adPage);//绝对路径
				}else{
					//广告页面的相对路径
					String uri = request.getRequestURI();//           /day18/example/index.jsp
					//找到路径
					String path = uri.substring(0, uri.lastIndexOf("/"));
//					System.out.println(path); //   /day18/example
					response.sendRedirect(path+"/"+adPage);
				}
				
			}
		}
	}
	
}
