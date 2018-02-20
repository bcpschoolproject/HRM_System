/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
 
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class SimpleHeaderRenderer extends JLabel implements TableCellRenderer {
    private TableCellRenderer defaultRenderer;
     
    public SimpleHeaderRenderer(TableCellRenderer defaultRenderer) {
        this.defaultRenderer = defaultRenderer;
    }    
    
    public SimpleHeaderRenderer() {
        setFont(new Font("Tahoma", Font.BOLD, 12));
        setOpaque(true);
        setForeground(Color.white);
        setBackground(new Color(102,102,255));
        //setBackground(Color.RED);
        setHorizontalAlignment(CENTER);
        setVerticalAlignment(CENTER);
        setHorizontalTextPosition(CENTER);
        setVerticalTextPosition(CENTER);
        setBorder(BorderFactory.createEtchedBorder());
    }
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        setText(value.toString());
        setText(this.getText().toUpperCase());
        return this;
    }
    
 
}
