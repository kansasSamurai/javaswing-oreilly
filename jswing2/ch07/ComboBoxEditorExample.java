import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;

//ComboBoxEditorExample.java
//A custom combobox editor for use with the EditableComboBox class.
//
public class ComboBoxEditorExample implements ComboBoxEditor {
	
    private ImageIcon questionIcon;
    private ImagePanel panel;
    private Map<String,BookEntry> map;
 
    public ComboBoxEditorExample(Map<String,BookEntry> m, BookEntry defaultChoice) {
        map = m;
        panel = new ImagePanel(defaultChoice); 
        questionIcon = new ImageIcon( "/C:/dev/workspaces/git/book.javaswing_oreilly/jswing2/ch07/" // modified
        		+ "question.gif"); 
    }

    public void setItem(Object anObject) {
        if (anObject != null) {
            panel.setText(anObject.toString());
            BookEntry entry = (BookEntry)map.get(anObject.toString());
            if (entry != null)
                panel.setIcon(entry.getImage());
            else
                panel.setIcon(questionIcon);
        } 
    }

    public void selectAll() { panel.selectAll(); }

    public Object getItem() { return panel.getText(); }
    
    public Component getEditorComponent() { return panel; }
    
    public void addActionListener(ActionListener l) {
        panel.addActionListener(l); 
    }

    public void removeActionListener(ActionListener l) {
        panel.removeActionListener(l); 
    }

    //  We create our own inner class to handle setting and
    //  repainting the image and the text.
    class ImagePanel extends JPanel {
       
		private static final long serialVersionUID = 1L;

		JLabel imageIconLabel;        
		JTextField textField;

        public ImagePanel(BookEntry initialEntry) {
            setLayout(new BorderLayout());

            imageIconLabel = new JLabel(initialEntry.getImage());
            imageIconLabel.setBorder(new BevelBorder(BevelBorder.RAISED));

            textField = new JTextField(initialEntry.getTitle());
            textField.setColumns(45);
            textField.setBorder(new BevelBorder(BevelBorder.LOWERED));

            add(textField, BorderLayout.SOUTH); // EAST
            add(imageIconLabel, BorderLayout.NORTH); // WEST
        }

        public void setText(String s) { textField.setText(s); }
        
        public String getText() { return (textField.getText()); }

        public void setIcon(Icon i) {
            imageIconLabel.setIcon(i);
            repaint();
        }

        public void selectAll() { textField.selectAll(); }

        public void addActionListener(ActionListener l) {
            textField.addActionListener(l); 
        }
        
        public void removeActionListener(ActionListener l) {
            textField.removeActionListener(l); 
        }
    }
    
} 
