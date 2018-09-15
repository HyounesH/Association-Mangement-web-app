package ma.infosat.gestion.adherent.tableSupplementaire.services;

import java.io.ByteArrayInputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ma.infosat.gestion.adherent.tableSupplementaire.metier.ReportMetier;

@RestController
@RequestMapping("/assocSat")
@CrossOrigin(origins="http://localhost:4200",allowedHeaders="*")
public class ReportRestService {

	@Autowired
	private ReportMetier reportMetier;
    
    @RequestMapping(value="report/sorties",method=RequestMethod.GET,produces=MediaType.APPLICATION_PDF_VALUE)
	public  ResponseEntity<InputStreamResource> generateReportSortants() {
		ByteArrayInputStream bis=reportMetier.generateReportSortants();
		HttpHeaders headers = new HttpHeaders();
		
        headers.add("Content-Disposition", "inline; filename=sorties.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
	}
    @RequestMapping(value="report/entrees",method=RequestMethod.GET,produces=MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<InputStreamResource> generateReportEntrants() {
		ByteArrayInputStream bis=reportMetier.generateReport();
HttpHeaders headers = new HttpHeaders();
		
        headers.add("Content-Disposition", "inline; filename=sorties.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
}
}
