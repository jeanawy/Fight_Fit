package th.fight.fit.mpybackoffice.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FileUploadController {

	@GetMapping("/fileUploadController-initFileUploadForm")
	public ModelAndView initFileUploadForm(Model model) {

		return new ModelAndView("file.upload");
	}

	// Handling single file upload request
	@PostMapping("/fileUploadController-singleFileUpload")
	public ModelAndView singleFileUpload(@RequestParam("file") MultipartFile file, Model model)
			throws IOException {

		// Save file on system
		if (!file.getOriginalFilename().isEmpty()) {
			BufferedOutputStream outputStream = new BufferedOutputStream(
					new FileOutputStream(
							new File("D:/SingleFileUpload", file.getOriginalFilename())));
			outputStream.write(file.getBytes());
			outputStream.flush();
			outputStream.close();

			model.addAttribute("msg", "File uploaded successfully.");
		} else {
			model.addAttribute("msg", "Please select a valid file..");
		}

		return new ModelAndView("file.upload");
	}

	// Handling multiple files upload request
	@PostMapping("/fileUploadController-multipleFileUpload")
	public ModelAndView multipleFileUpload(@RequestParam("file") MultipartFile[] files,
			Model model) throws IOException {

		// Save file on system
		for (MultipartFile file : files) {
			if (!file.getOriginalFilename().isEmpty()) {
				BufferedOutputStream outputStream = new BufferedOutputStream(
						new FileOutputStream(
								new File("D:/MultipleFileUpload", file.getOriginalFilename())));

				outputStream.write(file.getBytes());
				outputStream.flush();
				outputStream.close();
			} else {
				model.addAttribute("msg", "Please select at least one file..");
				return new ModelAndView("file.upload");
			}
		}
		model.addAttribute("msg", "Multiple files uploaded successfully.");
		return new ModelAndView("file.upload");
	}

}
