package ma.infosat.gestion.adherent;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ma.infosat.gestion.adherent.metier.StorageService;
import ma.infosat.gestion.adherent.tableSupplementaire.metier.ReportMetier;

@SpringBootApplication
public class GestionAdherentsApplication implements CommandLineRunner {
    @Resource
	StorageService storageService;
    
    @Resource
    ReportMetier reportMetier;
	public static void main(String[] args) {
		SpringApplication.run(GestionAdherentsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//storageService.deleteAll();   // Dossier des images 
		//storageService.init();
	//reportMetier.generateReport();
	//reportMetier.generateReportSortants();
	}
}
