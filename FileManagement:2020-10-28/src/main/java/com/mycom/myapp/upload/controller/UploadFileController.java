package com.mycom.myapp.upload.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mycom.myapp.upload.service.IuploadFileService;


@Controller
public class UploadFileController {
	//static final Logger logger = Logger.getLogger(UploadFileController.class);
	
	@Autowired
	IuploadFileService uploadService;
	
	@RequestMapping(value="/upload", method=RequestMethod.GET)
	public String home() {
		return "upload/index";
	}
	
	@RequestMapping(value="/upload/new", method=RequestMethod.GET)
	public String uploadFile(Model model) {
		model.addAttribute("dir", "/");
		return "upload/form";
	}
	
	@ExceptionHandler({RuntimeException.class})
	public ModelAndView runtimeException(HttpServletRequest request, Exception ex) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("url", request.getRequestURI());
		mav.addObject("exception", ex);
		mav.setViewName("error/runtime");
		return mav;
	}
	
	/*@RequestMapping(value="/upload/new", method=RequestMethod.POST)
	public String uploadFile(@RequestParam(value="dir", required=false, defaultValue="/") String dir, @RequestParam MultipartFile file,
			RedirectAttributes redirectAttrs) {
		logger.info(file.getOriginalFilename());
		try {
			if(file!=null && !file.isEmpty()) {
				logger.info("/upload : " + file.getOriginalFilename());
				UploadFileVO newFile = new UploadFileVO();
				newFile.setDirectoryName(dir);
				newFile.setFileName(file.getOriginalFilename());
				newFile.setFileSize(file.getSize());
				newFile.setFileContentType(file.getContentType());
				newFile.setFileData(file.getBytes());
				logger.info("/upload : " + newFile.toString());
			}
		}catch(Exception e) {
			e.printStackTrace();
			redirectAttrs.addFlashAttribute("message", e.getMessage());
		}
		return "redirect:/upload/list"; //+dir;
	}
	*/

}
