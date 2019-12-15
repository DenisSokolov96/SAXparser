import java.util.ArrayList;
import java.util.List;

import POJOs.FirstPOJO;
import POJOs.SecondPOJO;
import org.apache.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;


public class MyHandler extends DefaultHandler {

    private static final Logger log = Logger.getLogger(MyHandler.class);
    private List<Object> empList = null;
    private FirstPOJO emp1 = null;
    private SecondPOJO emp2 = null;
    private StringBuilder data = null;

    public List<Object> getEmpList() {
        return empList;
    }

    @Override
    public void startDocument() {
        log.info("Start XML parse");
    }

    @Override
    public void endDocument() {
        log.info("End XML parse");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {

        String [] mas = {"university","faculty","department","group"};
        for (int i = 0; i<4; i++){

            if (qName.equalsIgnoreCase(mas[i])){

                if (empList == null)
                    empList = new ArrayList<Object>();
                String unname = attributes.getValue("name");
                String val;
                switch (i){
                    case 0:
                    case 1:
                    case 2:
                        emp2 = new SecondPOJO();
                        emp2.setName(unname);
                        emp2.setTeg(mas[i]);
                        empList.add(emp2);
                        break;
                    case 3:
                        val = attributes.getValue("val");
                        emp1 = new FirstPOJO();
                        emp1.setName(unname);
                        emp1.setVal(Integer.parseInt(val));
                        empList.add(emp1);
                        break;
                }

            }
        }
        data = new StringBuilder();
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
    }

    @Override
    public void characters(char ch[], int start, int length) {
        data.append(new String(ch, start, length));
    }
}