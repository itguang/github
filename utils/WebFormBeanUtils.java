package utils;

import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;


public class WebFormBeanUtils {
	/**
	 * ����������еĲ�����װ��FormBean��
	 * @param request
	 * @return ��װ�õ�FormBean
	 */
//	public static RegistFormBean fillFormBean(HttpServletRequest request){
//		try {
//			RegistFormBean bean = new RegistFormBean();
//			BeanUtils.populate(bean, request.getParameterMap());
//			return bean;
//		} catch (Exception e) {
//			throw new RuntimeException(e);
//		}
//		
//	}
//	public static Object fillFormBean(HttpServletRequest request,Class clazz){
//		try {
//			Object bean = clazz.newInstance();
//			BeanUtils.populate(bean, request.getParameterMap());
//			return bean;
//		} catch (Exception e) {
//			throw new RuntimeException(e);
//		}
//		
//	}
	public static <T>T fillFormBean(HttpServletRequest request,Class<T> clazz){
		try {
			T bean = clazz.newInstance();
			BeanUtils.populate(bean, request.getParameterMap());
			return bean;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}
}
