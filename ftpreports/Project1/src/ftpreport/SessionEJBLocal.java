package ftpreport;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.activation.DataHandler;

import javax.ejb.Local;


@Local
public interface SessionEJBLocal {
    String ExportFTPReport(DataHandler document,
                           String filename) throws FileNotFoundException,
                                                   IOException;
}
