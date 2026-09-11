import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class UserDom {

    public static void main(String args[]) throws Exception {

        String xml =
            "<usersinformation>" +

            "<user>" +
            "<rollno>501</rollno>" +
            "<name>aaa</name>" +
            "<branch>cse</branch>" +
            "<college>mrcet</college>" +
            "</user>" +

            "<user>" +
            "<rollno>502</rollno>" +
            "<name>bbb</name>" +
            "<branch>cse</branch>" +
            "<college>mrcet</college>" +
            "</user>" +

            "<user>" +
            "<rollno>503</rollno>" +
            "<name>ccc</name>" +
            "<branch>cse</branch>" +
            "<college>mrcet</college>" +
            "</user>" +

            "<user>" +
            "<rollno>504</rollno>" +
            "<name>ddd</name>" +
            "<branch>cse</branch>" +
            "<college>mrcet</college>" +
            "</user>" +

            "<user>" +
            "<rollno>505</rollno>" +
            "<name>eee</name>" +
            "<branch>cse</branch>" +
            "<college>mrcet</college>" +
            "</user>" +

            "<user>" +
            "<rollno>506</rollno>" +
            "<name>fff</name>" +
            "<branch>cse</branch>" +
            "<college>mrcet</college>" +
            "</user>" +

            "<user>" +
            "<rollno>507</rollno>" +
            "<name>ggg</name>" +
            "<branch>cse</branch>" +
            "<college>mrcet</college>" +
            "</user>" +

            "<user>" +
            "<rollno>508</rollno>" +
            "<name>hhh</name>" +
            "<branch>cse</branch>" +
            "<college>mrcet</college>" +
            "</user>" +

            "<user>" +
            "<rollno>509</rollno>" +
            "<name>iii</name>" +
            "<branch>cse</branch>" +
            "<college>mrcet</college>" +
            "</user>" +

            "<user>" +
            "<rollno>510</rollno>" +
            "<name>jjj</name>" +
            "<branch>cse</branch>" +
            "<college>mrcet</college>" +
            "</user>" +

            "</usersinformation>";

        DocumentBuilderFactory fac =
                DocumentBuilderFactory.newInstance();

        DocumentBuilder b = fac.newDocumentBuilder();

        Document doc = b.parse(
                new ByteArrayInputStream(
                        xml.getBytes(StandardCharsets.UTF_8)
                )
        );

        doc.getDocumentElement().normalize();

        Element root = doc.getDocumentElement();

        Scanner in = new Scanner(System.in);

        System.out.println("Enter User ID:");
        int n = in.nextInt();

        int flag = 0;

        NodeList nl = doc.getElementsByTagName("user");

        for (int i = 0; i < nl.getLength(); i++) {

            Node node = nl.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE) {

                Element e = (Element) node;

                int x = Integer.parseInt(
                        e.getElementsByTagName("rollno")
                                .item(0)
                                .getTextContent()
                );

                if (x == n) {

                    System.out.println(root.getNodeName());
                    System.out.println();

                    System.out.println(
                            "rollno:\t" +
                            e.getElementsByTagName("rollno")
                                    .item(0)
                                    .getTextContent()
                    );

                    System.out.println(
                            "name:\t" +
                            e.getElementsByTagName("name")
                                    .item(0)
                                    .getTextContent()
                    );

                    System.out.println(
                            "branch:\t" +
                            e.getElementsByTagName("branch")
                                    .item(0)
                                    .getTextContent()
                    );

                    System.out.println(
                            "college:\t" +
                            e.getElementsByTagName("college")
                                    .item(0)
                                    .getTextContent()
                    );

                    flag = 1;
                    break;
                }
            }
        }

        if (flag == 0) {
            System.out.println("User not available");
        }

        in.close();
    }
}