package ma.infosat.gestion.adherent.metier;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class StorageService {
	
	Logger log=LoggerFactory.getLogger(this.getClass().getName());

	private final Path rootLocation=Paths.get("images");
	
	public void store(MultipartFile file) {
		try {
			Files.copy(file.getInputStream(), this.rootLocation.resolve(file.getOriginalFilename()));
			
		} catch (Exception e) {
			throw new RuntimeException("fail");
		}
	}
	public Resource loadFile(String filename) {
		try {
			Path file=rootLocation.resolve(filename);
			Resource resource=new UrlResource(file.toUri());
			if(resource.exists() || resource.isReadable()) {
				return resource;
			}else {
				throw new RuntimeException("Fail");
			}
			
		} catch (MalformedURLException e) {
			throw new RuntimeException("Fail");
		}
	}
	public void deleteAll() {
		FileSystemUtils.deleteRecursively(rootLocation.toFile());
	}
	public void init() {
		try {
			Files.createDirectory(rootLocation);
		} catch (IOException e) {
			throw new RuntimeException(" could not initialize storage");
		}
	}

}
