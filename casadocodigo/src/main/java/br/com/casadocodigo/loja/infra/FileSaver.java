package br.com.casadocodigo.loja.infra;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileSaver {
	
	@Autowired
	private HttpServletRequest request;
	
	//@Value("${path.file}")
	private String path = "C:/ALURA/SpringMVC";
	
	public String writeFile(String baseFolder, MultipartFile multipartFile) {
		
		String folderAndFile = baseFolder + "/" +multipartFile.getOriginalFilename(); 
//		String path = request.getServletContext().getRealPath("/" + folderAndFile);
		File file = new File(this.path + "/" + folderAndFile);
		try {
			multipartFile.transferTo(file);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return folderAndFile;
	}
}
