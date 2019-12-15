import POJOs.FirstPOJO;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.List;
import org.apache.log4j.Logger;


public class Main {

    private static final Logger log = Logger.getLogger(Main.class);
    private static StringBuilder str = new StringBuilder();

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

        log.info("123");

        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        SAXParser saxParser = saxParserFactory.newSAXParser();
        MyHandler handler = new MyHandler();
        saxParser.parse(new File("/home/denis/IntelliJIDEAProjects/SAXparser/src/main/resources/Univer.xml"), handler);

        try {
            List<Object> empList = handler.getEmpList();
            for (Object emp : empList)
                str.append(emp + "\n");

            System.out.println(str);
            log.info("Выполнено!");
        }
        catch (NullPointerException e){
            log.error(e.getMessage());
        }

    }
}
