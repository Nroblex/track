package gpx.Impl;

import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by ueh093 on 5/7/15.
 */
public abstract class ImportEngine {

    private String myGpxFile = "";

    public void setGpxFile(String gpxFile) {
        this.myGpxFile = gpxFile;
    }

    public void saveGPX(byte[] gpxbytes) {

        File file = new File("/home/ueh093/fil.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();

                FileOutputStream fsOut = new FileOutputStream(file);

                fsOut.write(IOUtils.toString(gpxbytes, "UTF-8").getBytes());
                fsOut.flush();

                fsOut.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }



}
