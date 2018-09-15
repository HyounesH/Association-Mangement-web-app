package ma.infosat.gestion.adherent.tableSupplementaire.metier;

import java.io.ByteArrayInputStream;

public interface ReportMetier {
public ByteArrayInputStream generateReport();
public ByteArrayInputStream generateReportSortants();
}
