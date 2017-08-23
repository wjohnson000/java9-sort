package sort.java9.xml;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.WindowConstants;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;

public class XMLTreeViewer {

    private static final Font fixedFont = new Font("Monospaced", Font.PLAIN, 12);

    private JTree xmlJTree;
    private JTextField txtFile;
    private DefaultMutableTreeNode currentNode;

    void expandAll(JTree tree) {
        int row = 0;
        while (row < tree.getRowCount()) {
            tree.expandRow(row++);
        }
    }

    void startDocument() {
        currentNode = new DefaultMutableTreeNode("XML Viewer");
        ((DefaultTreeModel) xmlJTree.getModel()).setRoot(currentNode);
    }

    void endDocument() {
        ((DefaultTreeModel) xmlJTree.getModel()).reload();
        expandAll(xmlJTree);
    }

    void startElement(String name, String... attrs) {
        DefaultMutableTreeNode newElement = new DefaultMutableTreeNode(name);
        currentNode.add(newElement);
        currentNode = newElement;

        if (attrs != null) {
            for (int i=0;  i<attrs.length;  i+=2) {
                DefaultMutableTreeNode newAttr = new DefaultMutableTreeNode("ATTR [ " + attrs[i] + " = " + attrs[i+1] + " ]");
                currentNode.add(newAttr);
            }
        }
    }

    void endElement(String text) {
        if (text != null  &&  ! text.isEmpty()) {
            DefaultMutableTreeNode newElement = new DefaultMutableTreeNode(text);
            currentNode.add(newElement);
        }
        currentNode = (DefaultMutableTreeNode) currentNode.getParent();
    }

    void xmlSetUp(File xmlFile) {
        XMLInputFactory factory = XMLInputFactory.newDefaultFactory();
        try (FileInputStream fis = new FileInputStream(xmlFile)) {
            String text = "";
            startDocument();  // Apparently we do NOT get the "START_DOCUMENT" event ...
            XMLStreamReader reader = factory.createXMLStreamReader(fis);
            while(reader.hasNext()) {
                int event = reader.next();
                System.out.println("EVENT: " + event);
                switch(event) {
                case XMLStreamConstants.START_DOCUMENT:
                    startDocument();
                    break;
                case XMLStreamConstants.START_ELEMENT:
                    String name = reader.getLocalName();
                    int attrCnt = reader.getAttributeCount();
                    String[] attrs = new String[attrCnt*2];
                    for (int i=0;  i<attrCnt;  i++) {
                        attrs[i*2] = reader.getAttributeLocalName(i);
                        attrs[i*2+1] = reader.getAttributeValue(i);
                    }
                    startElement(name, attrs);
                    break;
                case XMLStreamConstants.CHARACTERS:
                    text = reader.getText().trim();
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    endElement(text);
                    break;
                case XMLStreamConstants.END_DOCUMENT:
                    endDocument();
                    break;
                }
            }
        } catch(Exception ex) {
            System.out.println("ACK!!  " + ex.getLocalizedMessage());
            ex.printStackTrace();
        }
    }

    void createUI() {
        JFrame windows = new JFrame();
        windows.setTitle("XML Tree Viewer using SAX Parser in JAVA");

        DefaultTreeModel treeModel = new DefaultTreeModel(currentNode);
        xmlJTree = new JTree(treeModel);
        xmlJTree.setFont(fixedFont);
        JScrollPane scrollPane = new JScrollPane(xmlJTree);

        JPanel pnl = new JPanel();
        pnl.setLayout(null);
        JLabel lbl = new JLabel("File :");
        txtFile = new JTextField("Selected File Name Here");
        JButton btn = new JButton("Select File");

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                JFileChooser fileopen = new JFileChooser();
                FileFilter filter = new FileNameExtensionFilter("xml files", "xml");
                fileopen.addChoosableFileFilter(filter);

                int ret = fileopen.showDialog(null, "Open file");

                if (ret == JFileChooser.APPROVE_OPTION) {
                    File file = fileopen.getSelectedFile();
                    txtFile.setText(file.getPath() + File.separator + file.getName());
                    xmlSetUp(file);
                }
            }
        });

        lbl.setBounds(8, 0, 32, 22);
        txtFile.setBounds(40, 0, 690, 22);
        btn.setBounds(735, 0, 80, 22);
        scrollPane.setBounds(0, 32, 820, 720);

        pnl.add(lbl);
        pnl.add(txtFile);
        pnl.add(btn);
        pnl.add(scrollPane);

        windows.add(pnl);
        windows.setSize(840, 800);
        windows.setResizable(false);
        windows.setVisible(true);
        windows.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        XMLTreeViewer treeViewer = new XMLTreeViewer();
        treeViewer.createUI();
        File xmlFile = new File("C:/Users/wjohnson000/git/std-ws-place/pom.xml");
        treeViewer.txtFile.setText(xmlFile.getAbsolutePath());
        treeViewer.xmlSetUp(xmlFile);
    }

}