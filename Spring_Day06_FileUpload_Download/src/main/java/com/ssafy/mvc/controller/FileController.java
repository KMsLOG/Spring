package com.ssafy.mvc.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileController {
	// 스프링에서 파일이나 클래스 등등 리소스를 로드할 때는 ResourceLoader 인터페이스를 이용해서 가져온다.
	private ResourceLoader resourceLoader;
//	@Autowired 없어도 들어있음
	public FileController(ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;
	}
	
	@GetMapping("/singleFileForm")
	public String singleFileForm() {
		return "singleFileForm";
	}
	@PostMapping("/singleFileUpload")
	public String singleFileUpload(@RequestParam("file") MultipartFile file,Model model) throws IllegalStateException, IOException {
		// 파일이 있는지 검사
		if(file != null && file.getSize() > 0) {
			String fileName = file.getOriginalFilename();
			
			// 코드로 저기 있는 img라고 하는 폴더를 가지고 와야겠다.
			Resource resource = resourceLoader.getResource("classpath:/static/img"); // static/img 폴더에 임의의 파일 하나 있어야 target에 static/img 폴더 생김
			
			file.transferTo(new File(resource.getFile(),fileName));
			
			model.addAttribute("fileName",fileName);
		}
		return "result";
	}
	
	@GetMapping("/download")
	public String fileDownload(@RequestParam("fileName") String fileName, Model model) {
		model.addAttribute("fileName",fileName);
		return "fileDownloadView";
	}
	
	@GetMapping("/multiFileForm")
	public String multiFileForm() {
		return "multiFileForm";
	}
	
	@PostMapping("/multiFileUpload")
	public String multiFileUpload(@RequestParam("files") MultipartFile[] files,Model model) throws IllegalStateException, IOException {
		for(MultipartFile file : files) {
			// 반복문으로 업로드 코드 넣기
			System.out.println(file.getOriginalFilename());
		}
		return "result";
	}
}
