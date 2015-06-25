package gpx.Impl;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import position.Model.GpxInformation;

import javax.xml.XMLConstants;
import javax.xml.namespace.NamespaceContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by ueh093 on 6/25/15.
 */
public class GpxParser {

    static Logger myLog = Logger.getLogger(GpxParser.class);

    private static String getStringValue(String path, XPath xpath, Document document){

        XPathExpression xPathExpression = null;
        String searchedValue = "";
        try {

            xPathExpression = xpath.compile(path);
            Object metadata = xPathExpression.evaluate(document, XPathConstants.NODESET);
            NodeList nd = (NodeList) metadata;

            searchedValue = nd.item(0).getTextContent();


        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }

        return searchedValue;
    }

    private static NodeList getTrackPoints(String path, XPath xpath, Document document ){

        XPathExpression xPathExpression = null;
        NodeList nodes = null;
        try {

            xPathExpression = xpath.compile(path);
            Object metadata = xPathExpression.evaluate(document, XPathConstants.NODESET);
            nodes = (NodeList) metadata;

        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }

        return nodes;

    }

    private static void trackPointsToObject(NodeList trackPoints, GpxInformation gpxInfo){

        for (int nd = 0; nd <= trackPoints.getLength(); nd++){

            Node trackPoint = trackPoints.item(nd);

            

        }

    }


    public static GpxInformation getGpxInformation (InputStream gpxStream) {

        GpxInformation gpxInfo = new GpxInformation();

        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        docFactory.setNamespaceAware(true);

        DocumentBuilder documentBuilder=null;

        try {
            documentBuilder= docFactory.newDocumentBuilder();

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

        try {
            Document document = documentBuilder.parse(gpxStream);

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

            String author = getStringValue("/sh:gpx/sh:metadata/sh:author/sh:name",xPath, document );
            String creator = getStringValue("/sh:gpx/sh:metadata/sh:link/sh:text",xPath, document );

            myLog.info(String.format("This file is created by %s, with %s", author, creator));

            NodeList trackNodes = getTrackPoints("/sh:gpx/sh:trk/sh:trkseg/sh:trkpt", xPath, document);

            myLog.info(String.format("There are %s trackpoints", trackNodes.getLength()));



        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return gpxInfo;
    }

}
