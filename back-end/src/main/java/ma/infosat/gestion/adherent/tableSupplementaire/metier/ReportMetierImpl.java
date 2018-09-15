package ma.infosat.gestion.adherent.tableSupplementaire.metier;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import ma.infosat.gestion.adherent.cotisation.entities.Don;
import ma.infosat.gestion.adherent.cotisation.entities.Espece;
import ma.infosat.gestion.adherent.cotisation.entities.Materiel;
import ma.infosat.gestion.adherent.cotisation.entities.PersonneMorale;
import ma.infosat.gestion.adherent.cotisation.entities.PersonnePhysique;
import ma.infosat.gestion.adherent.cotisation.metier.DonMetier;
import ma.infosat.gestion.adherent.cotisation.metier.DonneurMetier;
import ma.infosat.gestion.adherent.entities.Adherent;
import ma.infosat.gestion.adherent.metier.AdherentMetier;
import ma.infosat.gestion.adherent.tableSupplementaire.entities.Liquide;

@Service
public class ReportMetierImpl implements ReportMetier {
	
	@Autowired
	private AdherentMetier adherentMetier;
	@Autowired
	private DonneurMetier donateurMetier;
	@Autowired
	private DonMetier donMetier;
	@Autowired
	private LiquideMetier liquideMetier;
	@Override
	public ByteArrayInputStream generateReport() {
		Document document=new Document(PageSize.A4);
		ByteArrayOutputStream in = new ByteArrayOutputStream();
		try {
			PdfWriter.getInstance(document,in);
			document.open();
			Image img=Image.getInstance("assoc6.png");
			img.scaleToFit(300, 100);
			img.setAbsolutePosition(20,PageSize.A4.getHeight()-img.getScaledHeight());
			img.setAlignment(Element.ALIGN_TOP);
		    document.add(img);
            Paragraph title=new Paragraph();
		    Font fontTitle=new Font(Font.FontFamily.HELVETICA,19,Font.BOLD,BaseColor.BLUE);
		    title.add(new Phrase("Rapport des entrées",fontTitle));
		    title.add(new Phrase(Chunk.NEWLINE));
		    title.setAlignment(Element.ALIGN_CENTER);
		    title.setSpacingAfter(11f);
		    title.setSpacingBefore(58f);
			document.add(title);
			Paragraph matEntree=new Paragraph();
			Font subtitleFont=new Font(Font.FontFamily.TIMES_ROMAN,18,Font.BOLD,BaseColor.BLACK);
			Chunk text=new Chunk("Matériel Entrants",subtitleFont);
			text.setBackground(new BaseColor(30,144,255));
			matEntree.add(text);
			matEntree.setFont(subtitleFont);
			matEntree.setSpacingAfter(11f);
			matEntree.setSpacingBefore(21f);
			document.add(matEntree);
			
			//table des matériels entrants
			PdfPTable table =new PdfPTable(8);
			table.setWidthPercentage(105);
			table.setSpacingAfter(11f);
			table.setSpacingBefore(10f);
			PdfPCell date_reception=new PdfPCell(new Paragraph("Date de réception"));
			date_reception.setRowspan(2);
			Paragraph description_para=new Paragraph("Description");
			description_para.setAlignment(Element.ALIGN_CENTER);
			PdfPCell description=new PdfPCell();
			description.addElement(description_para);
			description.setRowspan(2);
			description.setColspan(2);
			Paragraph phraseDonnateur=new Paragraph("Donnateur");
			phraseDonnateur.setAlignment(Element.ALIGN_CENTER);
			PdfPCell donnateur=new PdfPCell();
			donnateur.addElement(phraseDonnateur);
			donnateur.setColspan(2);
			donnateur.setRowspan(2);
			Paragraph receveur_don_para=new Paragraph("Receveur du don");
			receveur_don_para.setAlignment(Element.ALIGN_CENTER);
			PdfPCell receveur_don=new PdfPCell();
			receveur_don.addElement(receveur_don_para);
	        receveur_don.setColspan(3);
			table.addCell(date_reception);
			table.addCell(description);
			table.addCell(donnateur);
			table.addCell(receveur_don);
			Paragraph nomComplet_para=new Paragraph("Nom complet");
			nomComplet_para.setAlignment(Element.ALIGN_CENTER);
			PdfPCell nom_complet=new PdfPCell();
			nom_complet.addElement(nomComplet_para);
			nom_complet.setColspan(2);
			Paragraph cin_para=new Paragraph("CIN");
			cin_para.setAlignment(Element.ALIGN_CENTER);
			PdfPCell cin=new PdfPCell();
			cin.addElement(cin_para);
			table.addCell(cin);
			table.addCell(nom_complet);
			//data 
			List<Materiel> listMateriel=new ArrayList<>();
			listMateriel=donMetier.listMateriel();
			for(Don d:listMateriel) {
				table.getDefaultCell().setColspan(1);
				table.addCell(d.getDate_don().toString());
				table.getDefaultCell().setColspan(2);
				table.addCell(d.getDescription_don());
				PersonneMorale pMoral=donateurMetier.getDonnateurMoral(d.getDonneur().getId_donneur());
				PersonnePhysique pPhysique=donateurMetier.getDonnateurPhysique(d.getDonneur().getId_donneur());
				if(pPhysique==null) {
					table.addCell(pMoral.getNom_moral());
				}else {
					table.addCell(pPhysique.getNom()+" "+pPhysique.getPrenom());
				}
				table.getDefaultCell().setColspan(1);
				Adherent a=adherentMetier.getAdherent(d.getReceveur_don().getCode_employe());
				table.addCell(a.getCin());
				table.getDefaultCell().setColspan(2);
				table.addCell(a.getNom_adherent()+" "+a.getPrenom_adherent());
			}
			document.add(table);
			//table data caisse
			Paragraph caisseEntrants=new Paragraph();
			Chunk textCaisse=new Chunk("Caisse",subtitleFont);
			textCaisse.setBackground(new BaseColor(30,144,255));
			caisseEntrants.add(textCaisse);
			caisseEntrants.setFont(subtitleFont);
			caisseEntrants.setSpacingAfter(11f);
			caisseEntrants.setSpacingBefore(21f);
			document.add(caisseEntrants);
			PdfPTable tableCaise =new PdfPTable(9);
			tableCaise.setWidthPercentage(105);
			tableCaise.setSpacingAfter(11f);
			tableCaise.setSpacingBefore(10f);
			Paragraph montant_value=new Paragraph("Montant");
			montant_value.setAlignment(Element.ALIGN_CENTER);
			PdfPCell montant=new PdfPCell();
			montant.addElement(montant_value);
			montant.setRowspan(2);
			tableCaise.addCell(date_reception);
			tableCaise.addCell(montant);
			tableCaise.addCell(description);
			tableCaise.addCell(donnateur);
			tableCaise.addCell(receveur_don);
			
			tableCaise.addCell(cin);
			tableCaise.addCell(nom_complet);
			
		List<Espece> listCaisse=donMetier.listArgent();
		double montant_total=0;
		for(Don d:listCaisse) {
			tableCaise.getDefaultCell().setColspan(1);
			tableCaise.addCell(d.getDate_don().toString());
			montant_total+=d.getMontant();
			tableCaise.addCell(String.valueOf(d.getMontant()));
			tableCaise.getDefaultCell().setColspan(2);
			tableCaise.addCell(d.getDescription_don());
			PersonneMorale pMoral=donateurMetier.getDonnateurMoral(d.getDonneur().getId_donneur());
			PersonnePhysique pPhysique=donateurMetier.getDonnateurPhysique(d.getDonneur().getId_donneur());
			if(pPhysique==null) {
				tableCaise.addCell(pMoral.getNom_moral());
			}else {
				tableCaise.addCell(pPhysique.getNom()+" "+pPhysique.getPrenom());
			}
			tableCaise.getDefaultCell().setColspan(1);
			Adherent a=adherentMetier.getAdherent(d.getReceveur_don().getCode_employe());
			tableCaise.addCell(a.getCin());
			tableCaise.getDefaultCell().setColspan(2);
			tableCaise.addCell(a.getNom_adherent()+" "+a.getPrenom_adherent());
		}
		
		Paragraph somme=new Paragraph("Montant : "+montant_total);
		somme.setSpacingBefore(9f);
		somme.setSpacingAfter(15f);
		somme.setAlignment(2);
		document.add(somme);
        document.add(tableCaise);
		}catch(DocumentException de) {
         System.err.println(de.getMessage());
		}catch(Exception ioe) {
			System.out.println(ioe.getMessage());
		}
		document.close();
       return new ByteArrayInputStream(in.toByteArray());
       
	}
	@Override
	public ByteArrayInputStream generateReportSortants() {
	
		Document document=new Document(PageSize.A4);
		ByteArrayOutputStream out = new ByteArrayOutputStream();		
		try {
			PdfWriter.getInstance(document,out);
			document.open();
			Image img=Image.getInstance("assoc6.png");
			img.scaleToFit(300, 100);
			img.setAbsolutePosition(20,PageSize.A4.getHeight()-img.getScaledHeight());
			img.setAlignment(Element.ALIGN_TOP);
		    document.add(img);
			Paragraph title=new Paragraph();
		    Font fontTitle=new Font(Font.FontFamily.HELVETICA,19,Font.BOLD,BaseColor.BLUE);
		    title.add(new Phrase("Rapport des sorties",fontTitle));
		    title.add(new Phrase(Chunk.NEWLINE));
		    title.setAlignment(Element.ALIGN_CENTER);
		    title.setSpacingAfter(11f);
		    title.setSpacingBefore(58f);
			document.add(title);
			Paragraph matEntree=new Paragraph();
			Font subtitleFont=new Font(Font.FontFamily.TIMES_ROMAN,18,Font.BOLD,BaseColor.BLACK);
			Chunk text=new Chunk("Matériel Sortants",subtitleFont);
			text.setBackground(new BaseColor(30,144,255));
			matEntree.add(text);
			matEntree.setFont(subtitleFont);
			matEntree.setSpacingAfter(11f);
			matEntree.setSpacingBefore(21f);
			document.add(matEntree);
			
			//table des matériels entrants
			PdfPTable table =new PdfPTable(7);
			table.setWidthPercentage(105);
			table.setSpacingAfter(11f);
			table.setSpacingBefore(10f);
			PdfPCell date_reception=new PdfPCell(new Paragraph("Date de sortie"));
			Paragraph description_para=new Paragraph("Description");
			description_para.setAlignment(Element.ALIGN_CENTER);
			PdfPCell description=new PdfPCell();
			description.addElement(description_para);
			description.setColspan(2);
			Paragraph lieuEnvoie=new Paragraph("Lieu d'envoi");
			lieuEnvoie.setAlignment(Element.ALIGN_CENTER);
			PdfPCell lieuEnvoi_cell=new PdfPCell();
			lieuEnvoi_cell.addElement(lieuEnvoie);
			lieuEnvoi_cell.setColspan(2);
			Paragraph phraseDonnateur=new Paragraph("Donnateur");
			phraseDonnateur.setAlignment(Element.ALIGN_CENTER);
			PdfPCell donnateur=new PdfPCell();
			donnateur.addElement(phraseDonnateur);
			donnateur.setColspan(2);
			table.addCell(date_reception);
			table.addCell(lieuEnvoi_cell);
			table.addCell(description);
			table.addCell(donnateur);
			//data 
			List<Materiel> listMateriel=new ArrayList<>();
			listMateriel=donMetier.listMaterielSortant();
			for(Materiel d:listMateriel) {
				table.getDefaultCell().setColspan(1);
				table.addCell(d.getDateSortie().toString());
				table.getDefaultCell().setColspan(2);
				table.addCell(d.getLieuSortie());
				table.addCell(d.getDescription_don());
				PersonneMorale pMoral=donateurMetier.getDonnateurMoral(d.getDonneur().getId_donneur());
				PersonnePhysique pPhysique=donateurMetier.getDonnateurPhysique(d.getDonneur().getId_donneur());
				if(pPhysique==null) {
					table.addCell(pMoral.getNom_moral());
				}else {
					table.addCell(pPhysique.getNom()+" "+pPhysique.getPrenom());
				}
			}
			
			document.add(table);
			
			Paragraph sortie=new Paragraph();
			Chunk textSortie=new Chunk("Les dépenses de la caisse",subtitleFont);
			textSortie.setBackground(new BaseColor(30,144,255));
			sortie.add(textSortie);
			sortie.setFont(subtitleFont);
			sortie.setSpacingAfter(11f);
			sortie.setSpacingBefore(21f);
			document.add(sortie);
			
			PdfPTable depenses=new PdfPTable(3);
			depenses.setWidthPercentage(105);
			depenses.setSpacingBefore(15f);
			
			Paragraph date_depense=new Paragraph("Date de dépense");
			date_depense.setAlignment(Element.ALIGN_CENTER);
			PdfPCell date_depense_cell=new PdfPCell();
			date_depense_cell.addElement(date_depense);
			
			Paragraph type_depense=new Paragraph("type de dépense");
			type_depense.setAlignment(Element.ALIGN_CENTER);
			PdfPCell type_depense_cell=new PdfPCell();
			type_depense_cell.addElement(type_depense);
			
			Paragraph montant=new Paragraph("Montant");
			montant.setAlignment(Element.ALIGN_CENTER);
			PdfPCell montant_cell=new PdfPCell();
			montant_cell.addElement(montant);
			
			depenses.addCell(date_depense_cell);
			depenses.addCell(type_depense_cell);
			depenses.addCell(montant_cell);
			List<Liquide> listLiquides=liquideMetier.listLiquide();
			for(Liquide l:listLiquides) {
				depenses.addCell(l.getDate_depense().toString());
				depenses.addCell(l.getType_depense());
				depenses.addCell(String.valueOf(l.getMontant()));
				
			}
			document.add(depenses);
		}catch(DocumentException de) {
         System.err.println(de.getMessage());
		}catch(Exception ioe) {
			System.out.println(ioe.getMessage());
		}
		document.close();
       return new ByteArrayInputStream(out.toByteArray());
	}

}
