package com.appx.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.beans.factory.annotation.Autowired;

import com.appx.form.UserForm;
import com.appx.service.UserService;


public class LoginAction extends Action{
	
	private UserService userService = new UserService();
	
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		String username = request.getParameter("user");
		request.setAttribute("userInfo", ((UserForm)form).getUsername());		
        if(userService.Check((UserForm)form)){
        	request.setAttribute("message", "Hi~~" + ((UserForm)form).getUsername());
        	return mapping.findForward("helloUser");
        }else{
        	request.setAttribute("message", "帳號或密碼錯誤請重新輸入！！！");
        	return mapping.findForward("loginUser");
        }
		
	}
}
