package ma.infosat.gestion.adherent.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import ma.infosat.gestion.adherent.metier.StorageService;

@Controller
@RequestMapping("/assocSat")
@CrossOrigin(origins="http://localhost:4200",allowedHeaders="*")
public class UploadController {
	@Autowired
	StorageService storageService;
	
	@PostMapping("/post")
	public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file){
		String message="";
		try {
			storageService.store(file);
			message="you successfully uploaded "+file.getOriginalFilename()+" ! ";
			return ResponseEntity.status(HttpStatus.OK).body(message);
		} catch (Exception e) {
			message=" failed to upload file "+file.getOriginalFilename()+" ! ";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
		}
	}
	@GetMapping("/files/{filename}")
	@ResponseBody
	public ResponseEntity<Resource> getFile(@PathVariable String filename){
		 Resource file=storageService.loadFile(filename);
	     return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,"attachement; filename\""+file.getFilename()+"\"").body(file);
			
	}

}
