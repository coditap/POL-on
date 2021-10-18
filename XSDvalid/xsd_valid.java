package xsdvalid;
import java.io.File;
import java.io.IOException;
import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import org.xml.sax.SAXException;
public class XsdValid {
 public static void main(String[] args) {
 validate(args[0], args[1]);
 }
 static void validate(final String xsdFile, final String xmlFile) {
 SchemaFactory factory;
 Validator validator;
 Schema schema;
 try {
 factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
 schema = factory.newSchema(new File(xsdFile));
 validator = schema.newValidator();
 validator.validate(new StreamSource(new File(xmlFile)));

 System.out.println("Plik " + xmlFile + " OK");
 } catch (IOException | SAXException ex) {
 System.out.println(ex.getMessage());
 }
 }
}