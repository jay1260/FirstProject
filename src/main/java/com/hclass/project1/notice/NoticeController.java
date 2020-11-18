package com.hclass.project1.notice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hclass.project1.member.MemberDTO;
import com.hclass.project1.qna.QnaDTO;
import com.hclass.project1.util.Pager;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
@RequestMapping ("/notice/**")
public class NoticeController {

   @Autowired
   private NoticeService noticeservice;
   
   
   @GetMapping("noticeList")
   public ModelAndView getList(Pager pager) throws Exception{
      ModelAndView mv = new ModelAndView();
      List<NoticeDTO> ar = noticeservice.getList(pager);
      mv.addObject("list", ar);
      mv.addObject("pager", pager);
      mv.setViewName("notice/noticeList");
      return mv;
      
   }
   
   @PostMapping("noticeWrite")
   public ModelAndView setOne(NoticeDTO noticeDTO) throws Exception{
      ModelAndView mv = new ModelAndView();
      int result = noticeservice.setOne(noticeDTO);
      String message ="입력 실패";
      if(result>0) {
         message ="입력 성공";
      }
      mv.addObject("msg",message);
      mv.addObject("path", "../");
      mv.setViewName("common/result");
      return mv;
   }
   
   @GetMapping("noticeWrite")
   public ModelAndView setOne(HttpSession Session) throws Exception {
      ModelAndView mv = new ModelAndView();
      NoticeDTO noticeDTO = new NoticeDTO();
      noticeDTO = (NoticeDTO) Session.getAttribute("notice");
      mv.addObject("notice", noticeDTO);
      mv.setViewName("notice/noticeWrite");
      return mv;
   }
   
}