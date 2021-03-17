package com.user.file.manual.DownloadUtils;

import org.springframework.http.ResponseEntity;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

/*2nd method***********************/
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.URLConnection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.util.FileCopyUtils;




public class DownloadUtils {

    
// In POM.xml add below code if not work
// <!-- <properties>
// 	<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
// 	<project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
// 	<java.version>1.8</java.version>
// </properties> -->

  public static ResponseEntity<Object> filedownload(String filename) throws IOException{

    File file = new File(filename);
    InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
    
    HttpHeaders headers = new HttpHeaders();
    headers.add("Content-Disposition",
            String.format("attachment; filename=\"%s\"", file.getName()));
    headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
    headers.add("Pragma", "no-cache");
    headers.add("Expires", "0");

	ResponseEntity<Object> responseEntity = ResponseEntity.ok().headers(headers)
				.contentLength(file.length())
				.contentType(MediaType.parseMediaType("application/txt")).body(resource);
    return responseEntity;

  }


  public static void filedownload(
                            String filePath,
                            String downloadType, 
                            HttpServletRequest request, 
                            HttpServletResponse response
)throws IOException{
    File file = new File(filePath);
    if (file.exists()) {

        // get the mimetype
        String mimeType = URLConnection.guessContentTypeFromName(file.getName());
        if (mimeType == null) {
            // unknown mimetype so set the mimetype to application/octet-stream
            mimeType = "application/octet-stream";
        }

        response.setContentType(mimeType);

        /**
         * In a regular HTTP response, the Content-Disposition response header is a
         * header indicating if the content is expected to be displayed inline in the
         * browser, that is, as a Web page or as part of a Web page, or as an
         * attachment, that is downloaded and saved locally.
         * 
         */

        /**
         * Here we have mentioned it to show inline
         */
        // response.setHeader("Content-Disposition", String.format("inline; filename=\""+ file.getName() + "\""));

        // Here we have mentioned it to show as attachment
        // response.setHeader("Content-Disposition", String.format("attachment; filename=\"" + file.getName() + "\""));


         if(downloadType.equals("ON_SCREEN")){
            response.setHeader("Content-Disposition", String.format("inline; filename=\""+ file.getName() + "\""));
         }else if(downloadType.equals("SAVE")){
            response.setHeader("Content-Disposition", String.format("attachment; filename=\"" + file.getName() + "\""));
         }else{
            response.setHeader("Content-Disposition", String.format("attachment; filename=\"" + file.getName() + "\""));
         }
        
        response.setContentLength((int) file.length());

        InputStream inputStream = new BufferedInputStream(new FileInputStream(file));

        FileCopyUtils.copy(inputStream, response.getOutputStream());

    }
  }




}
