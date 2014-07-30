package ftpreport;

import java.io.FileNotFoundException;

import java.io.IOException;

import javax.activation.DataHandler;

import javax.ejb.Remote;

import oracle.bi.action.annotation.OBIActionParameter;

@Remote
public interface SessionEJB {
    String ExportFTPReport(@OBIActionParameter(name = "Analysis",
                                               prompt = "Report to Export:")
        DataHandler document,
        @OBIActionParameter(name = "Enter FTP Location", prompt =
                            "Enter FTP Location:")
        String filename) throws FileNotFoundException, IOException;
}
