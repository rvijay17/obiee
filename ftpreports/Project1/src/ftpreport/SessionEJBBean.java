package ftpreport;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import java.text.SimpleDateFormat;

import java.util.Date;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;


@Stateless(name = "ftpreport", mappedName = "ejb/ftpreport")
@TransactionManagement(TransactionManagementType.BEAN)
@Remote
@Local
public class SessionEJBBean implements SessionEJB, SessionEJBLocal {
    public SessionEJBBean() {
    }

    public String ExportFTPReport(javax.activation.DataHandler report,
                                  String filename) throws FileNotFoundException,
                                                          IOException {
        
        String path = filename.substring(0, filename.indexOf("CURRENT_DATE"));
        String current_date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
        File f = new File(path + "\\" + current_date);
        if(!f.exists()) {
            f.mkdir();
        }
        
        String new_filename = filename.replaceFirst("CURRENT_DATE", current_date);
        f = new File(new_filename);
        
        FileOutputStream outputStream = new FileOutputStream(f);
        report.writeTo(outputStream);
        outputStream.close();
        
        return "Report exported";
    }
}
