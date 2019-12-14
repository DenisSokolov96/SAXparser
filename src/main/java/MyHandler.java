import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.List;

import POJOs.FirstPOJO;
import POJOs.SecondPOJO;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class MyHandler extends DefaultHandler {

    // List to hold Employees object
    private List<Object> empList = null;
    private FirstPOJO emp = null;
    private SecondPOJO emp1 = null;
    private StringBuilder data = null;

    // getter method for employee list
    public List<Object> getEmpList() {
        return empList;
    }

    boolean bAge = false;
    boolean bName = false;
    boolean bGender = false;
    boolean bRole = false;

    boolean bMark = false;
    boolean bModel = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {




        if (qName.equalsIgnoreCase("Employee")) {
            // create a new Employee and put it in Map
            String id = attributes.getValue("id");
            // initialize Employee object and set id attribute
            emp = new FirstPOJO();
            emp.setId(Integer.parseInt(id));
            // initialize list
            if (empList == null)
                empList = new ArrayList<>();
        } else if (qName.equalsIgnoreCase("name")) {
            // set boolean values for fields, will be used in setting Employee variables
            bName = true;
        } else if (qName.equalsIgnoreCase("age")) {
            bAge = true;
        } else if (qName.equalsIgnoreCase("gender")) {
            bGender = true;
        } else if (qName.equalsIgnoreCase("role")) {
            bRole = true;
        } else if (qName.equalsIgnoreCase("OtherEmployee")){
            String id = attributes.getValue("id");
            emp1 = new SecondPOJO();
            emp1.setId(Integer.parseInt(id));
            if (empList == null)
                empList = new ArrayList<>();
        } else if (qName.equalsIgnoreCase("mark")){
            bMark = true;
        } else if (qName.equalsIgnoreCase("model")){
            bModel = true;
        }
        // create the data container
        data = new StringBuilder();
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (bAge) {
            // age element, set Employee age
            emp.setAge(Integer.parseInt(data.toString()));
            bAge = false;
        } else if (bName) {
            emp.setName(data.toString());
            bName = false;
        } else if (bRole) {
            emp.setRole(data.toString());
            bRole = false;
        } else if (bGender) {
            emp.setGender(data.toString());
            bGender = false;
        }

        if (qName.equalsIgnoreCase("Employee")) {
            // add Employee object to list
            empList.add(emp);
        }

        if (bModel) {
            emp1.setModel(data.toString());
            bModel = false;
        } else if (bMark) {
            emp1.setMark(data.toString());
            bMark = false;
        }

        if (qName.equalsIgnoreCase("OtherEmployee")){
            empList.add(emp1);
        }
    }

    @Override
    public void characters(char ch[], int start, int length) throws SAXException {
        data.append(new String(ch, start, length));
    }
}