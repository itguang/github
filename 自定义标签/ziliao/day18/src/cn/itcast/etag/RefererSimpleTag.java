package cn.itcast.etag;

import java.io.IOException;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class RefererSimpleTag extends SimpleTagSupport {
	private String site;//����ֱ�ӷ��ʵ���վ
	private String adPage;//���ҳ�档�Ƿ�������Ҫ�ȿ����
	
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
		//�õ������refererͷ
		String refererValue = request.getHeader("referer");
		//�������null�����Ҳ�����site��ͷ�ģ������
		if(refererValue!=null){
			if(!refererValue.startsWith(site)){
				if(adPage.startsWith("/")){
					response.sendRedirect(request.getContextPath()+adPage);//����·��
				}else{
					//���ҳ������·��
					String uri = request.getRequestURI();//           /day18/example/index.jsp
					//�ҵ�·��
					String path = uri.substring(0, uri.lastIndexOf("/"));
//					System.out.println(path); //   /day18/example
					response.sendRedirect(path+"/"+adPage);
				}
				
			}
		}
	}
	
}
