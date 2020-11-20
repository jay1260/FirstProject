package com.hclass.project1.Interceptor;

import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.hclass.project1.member.MemberDTO;
import com.hclass.project1.pay.PayDAO;
import com.hclass.project1.pay.PayDTO;

@Component
public class PayMemberInterceptor extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("PayMemberInterceptor");
		
		String id = request.getParameter("id");
		
		System.out.println("Pay" + id);
		
		PayDTO payDTO = new PayDTO();
		payDTO.setId(id);
		
		
		HttpSession session = request.getSession();
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		
		
		boolean check = false;
		
		if(payDTO.getId().equals(memberDTO.getId())) {
			check = true;
		}
		else {
			request.setAttribute("msg", "권한이 없는 경로입니다.");
			request.setAttribute("path", "../");
			RequestDispatcher view = request.getRequestDispatcher("../WEB-INF/views/common/result.jsp");
			view.forward(request, response);
		}
		return check;
	}
	
}
