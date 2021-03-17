package com.user.file.manual.Controller;

import java.io.IOException;

import com.user.file.manual.DownloadUtils.DownloadUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value = "lease/")
public class UserManual {

    @RequestMapping(value = "manual/property")
    public ResponseEntity<Object> downloadFile() throws IOException {
        final String filename = "D:/Projects/Client/0 Omniyat/Lease/Documents/Manual/Doc/Lease Property.pdf";

        ResponseEntity<Object> responseEntity = DownloadUtils.filedownload(filename);

        return responseEntity;
    }




    @RequestMapping("/file")
    public void downloadPDFResource(
        HttpServletRequest request, 
        HttpServletResponse response
        ) throws IOException {

    String filepath = "D:/Projects/Client/0 Omniyat/Lease/Documents/Manual/Doc/Lease Property.pdf";

    DownloadUtils.filedownload(filepath, "SAVE", request, response);
    
    // DownloadUtils.filedownload(filepath, "ON_SCREEN", request, response);
    }

}
