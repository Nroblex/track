package gpx.Impl;

import gpx.GpxService;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.jboss.resteasy.plugins.providers.multipart.InputPart;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;

import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * Created by ueh093 on 5/7/15.
 */
public class GpxServiceImpl extends ImportEngine implements GpxService {

    public Response importGpx(MultipartFormDataInput input) {

        Logger myLog = Logger.getLogger(this.getClass());

        String fileName = "";

        Map<String, List<InputPart>> uploadForm = input.getFormDataMap();
        List<InputPart> inputParts = uploadForm.get("uploadedFile");

        for (InputPart inputPart : inputParts) {
            try {

                MultivaluedMap<String, String> header = inputPart.getHeaders();
                fileName = getFilname(header);

                if (fileName.length() > 0) {
                    myLog.info(String.format("Saving actual file %s", fileName));
                }
                // Converting uploaded file to inputstream.
                InputStream inputStream = inputPart.getBody(InputStream.class, null);

                byte[] bytes = IOUtils.toByteArray(inputStream);
                saveGPX(bytes);

                // fileName = "/home/ueh093/" + fileName;
                // writeFile(bytes, fileName);

            } catch (IOException ep) {
                ep.printStackTrace();
            }
        }

        return null;
    }

    private void writeFile(byte[] bytes, String fileName) throws IOException {
        File fin = new File(fileName);
        if (!fin.exists()) {

            fin.createNewFile();

        }

        FileOutputStream fop = new FileOutputStream(fin);
        fop.write(bytes);
        fop.flush();
        fop.close();

    }

    private String getFilname(MultivaluedMap<String, String> header) {
        String[] contentDisposition = header.getFirst("Content-Disposition").split(";");
        for (String fileName : contentDisposition) {
            if ((fileName.trim().startsWith("filename"))) {
                String[] name = fileName.split("=");
                String finalFilename = name[1].trim().replaceAll("\"", "");
                return finalFilename;
            }
        }

        return "unkown_file";
    }

}
