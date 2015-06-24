package gpx.Impl;

import gpx.GpxService;
import org.apache.log4j.Logger;
import org.jboss.resteasy.plugins.providers.multipart.InputPart;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.xml.XMLConstants;
import javax.xml.namespace.NamespaceContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
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
                    myLog.info(String.format("If this file is a valid GPXfile it will be processed... %s", fileName));
                }
                // Converting uploaded file to inputstream.
                InputStream inputStream = inputPart.getBody(InputStream.class, null);

                //byte[] bytes = IOUtils.toByteArray(inputStream);

                DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
                docFactory.setNamespaceAware(true);

                DocumentBuilder documentBuilder=null;

                try {
                    documentBuilder= docFactory.newDocumentBuilder();

                } catch (ParserConfigurationException e) {
                    e.printStackTrace();
                }

                try {
                    Document document = documentBuilder.parse(inputStream);

                    XPath xPath = XPathFactory.newInstance().newXPath();
                    xPath.setNamespaceContext(new NamespaceContext() {

                        public String getNamespaceURI(String prefix) {
                            if (prefix == null) throw new NullPointerException("Null Prefix");
                            else if ("sh".equals(prefix))
                                return "http://www.topografix.com/GPX/1/1";
                            else if ("sh".equals(prefix))
                                return XMLConstants.XML_NS_URI;

                            return XMLConstants.XML_NS_URI;
                        }

                        public String getPrefix(String namespaceURI) {
                            if (namespaceURI.equals("http://www.topografix.com/GPX/1/1"))
                                return "sh";

                            return null;
                        }

                        public Iterator getPrefixes(String namespaceURI) {
                            ArrayList list = new ArrayList<String>();

                            if (namespaceURI.equals("http://www.topografix.com/GPX/1/1"))
                                list.add("sh");
                            return null;
                        }
                    });

                } catch (SAXException e) {
                    e.printStackTrace();
                }

                //saveGPX(bytes);

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
