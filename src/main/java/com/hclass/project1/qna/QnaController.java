package com.hclass.project1.qna;

import java.util.List;

// import javax.annotation.processing.Generated;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.hclass.project1.member.MemberDTO;
import com.hclass.project1.util.Pager;

@Controller
@RequestMapping("/qna/**")
public class QnaController {

	@Autowired
	private QnaService qnaService ;
	
	@PostMapping("qnaReply")
	public ModelAndView setReply(QnaDTO qnaDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		System.out.println(qnaDTO.getContents());
		System.out.println(qnaDTO.getTitle());
		System.out.println(qnaDTO.getWriter());
		int result = qnaService.setReply(qnaDTO);
		System.out.println("확인");
		String message = "입력 실패";
		if(result>0) {
			message = "입력 성공";
		}
		mv.addObject("msg",message);
		mv.addObject("path", "./qnaList");
		mv.setViewName("common/result");
		return mv;	
	}
	
	
	@GetMapping("qnaReply")
	public ModelAndView setReply(QnaDTO qnaDTO,HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView();
		MemberDTO memberDTO= new MemberDTO();
		memberDTO = (MemberDTO) session.getAttribute("member");
		mv.addObject("member",memberDTO);
		mv.setViewName("qna/qnaReply");
		return mv;
		
	}
	@GetMapping("qnaDelete")
	public ModelAndView setDelete(QnaDTO qnaDTO)throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = qnaService.setDelete(qnaDTO);
		String message = "삭제 실패";
		if(result>0) {
			message = "삭제 성공";
		}
		mv.addObject("msg",message);
		mv.addObject("path", "./qnaList");
		mv.setViewName("common/result");
		return mv;
	}
	
	@PostMapping("qnaUpdate")
	public ModelAndView setUpdate(QnaDTO qnaDTO)throws Exception{
		ModelAndView mv = new ModelAndView();
		int result =qnaService.setUpdate(qnaDTO);
		String message = "글 수정 실패";
		if(result>0) {
			message = "글 수정 성공";
		}
		mv.addObject("msg",message);
		mv.addObject("path", "./qnaList");
		mv.setViewName("common/result");
		return mv;
	}
	@GetMapping("qnaUpdate")
	public ModelAndView setUpdate(Long num) throws Exception{
		ModelAndView mv =new ModelAndView();
		QnaDTO qnaDTO =new QnaDTO();
		qnaDTO.setNum(num);
		qnaDTO = qnaService.getOne(qnaDTO);
		mv.addObject("qna",qnaDTO);
		mv.setViewName("qna/qnaUpdate");
		return mv;
	}
	@GetMapping("qnaSelect")
	public ModelAndView getOne(QnaDTO qnaDTO,HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView();
		MemberDTO memberDTO =new MemberDTO();
		memberDTO=(MemberDTO) session.getAttribute("member");
		qnaDTO = qnaService.getOne(qnaDTO);
		mv.addObject("member", memberDTO);
		mv.addObject("qna",qnaDTO);
		mv.setViewName("qna/qnaSelect");
		return mv;
	}
	
	@GetMapping("qnaList")
	public ModelAndView getList(Pager pager) throws Exception{
		ModelAndView mv = new ModelAndView();
		List<QnaDTO> ar = qnaService.getList(pager);
		mv.addObject("list", ar);
		mv.addObject("pager", pager);
		mv.setViewName("qna/qnaList");
		return mv;
		
	}
	
	@PostMapping("qnaWrite")
	public ModelAndView setOne(QnaDTO qnaDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = qnaService.setOne(qnaDTO);
		String message ="입력 실패";
		if(result>0) {
			message ="입력 성공";
		}
		mv.addObject("msg",message);
		mv.addObject("path", "./qnaList");
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
