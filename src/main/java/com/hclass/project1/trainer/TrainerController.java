package com.hclass.project1.trainer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hclass.project1.util.Pager;


@Controller
@RequestMapping(value="/trainer/**")
public class TrainerController {

	@Autowired
	private TrainerService trainerService;
	
	@GetMapping("trainerReserve")
	@RequestMapping(value="trainerReserve", method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView setTrainerReserve()throws Exception{
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("trainer/trainerReserve");
		
		return mv;
	}
	
	@GetMapping("trainerInfoPage")
	public ModelAndView getTrainerPage(TrainerDTO trainerDTO)throws Exception{
		ModelAndView mv = new ModelAndView();
		
		trainerDTO = trainerService.getTrainerPage(trainerDTO);
		if(trainerDTO != null) {
			mv.addObject("page", trainerDTO);
			mv.setViewName("trainer/trainerInfoPage");
		}else {
			mv.addObject("msg", "잘못된 경로입니다.");
			mv.addObject("path", "./trainerSearch");
			mv.setViewName("common/result");
		}
		return mv;
	}
	
	@GetMapping("trainerWindowSearch")
	public ModelAndView getSearchList(Pager pager)throws Exception{
		ModelAndView mv = new ModelAndView();

		List<TrainerDTO> ar = trainerService.getSearchList(pager);
		
		mv.addObject("list", ar);
		mv.addObject("pager", pager);
		mv.setViewName("trainer/trainerWindowSearch");
		
		return mv;
	}
	@GetMapping("trainerSearch")
	public ModelAndView getTrainer()throws Exception{
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("trainer/trainerSearch");
		return mv;
	}
	
	@GetMapping("trainerDetailSearch")
	public ModelAndView getSearch(Pager pager)throws Exception{
		ModelAndView mv = new ModelAndView();
		
		List<TrainerDTO> ar = trainerService.getSearch(pager);
		
		mv.addObject("search", ar);
		mv.setViewName("trainer/trainerDetailSearch");
		
		return mv;
	}
	
	@GetMapping("map")
	public ModelAndView getMap()throws Exception{
		
		ModelAndView mv =new ModelAndView();
		
		mv.setViewName("trainer/map");
		
		return mv;
	}
}
