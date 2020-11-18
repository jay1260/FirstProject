package com.hclass.project1.qna;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hclass.project1.member.MemberDTO;

@Controller
@RequestMapping("/qna/**")
public class QnaController {

	@Autowired
	private QnaService qnaService ;
	
	@PostMapping("qnaWrite")
	public ModelAndView setOne(QnaDTO qnaDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = qnaService.setOne(qnaDTO);
		String message ="입력 실패";
		if(result>0) {
			message ="입력 성공";
		}
		mv.addObject("msg",message);
		mv.addObject("path", "../");
		mv.setViewName("common/result");
		return mv;
	}
	
	@GetMapping("qnaWrite")
	public ModelAndView setOne(HttpSession Session) throws Exception {
		ModelAndView mv = new ModelAndView();
		MemberDTO memberdto = new MemberDTO();
		memberdto = (MemberDTO) Session.getAttribute("member");
		mv.addObject("member", memberdto);
		mv.setViewName("qna/qnaWrite");
		return mv;
	}
}
