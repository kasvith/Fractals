/*
 * Created by JFormDesigner on Tue Jul 25 06:08:06 IST 2017
 */

package com.kasun.ui;

import com.kasun.fractal.AbstractFractal;
import com.kasun.fractal.Mandelbrot;

import javax.swing.*;

/**
 * @author Kasun Vithanage
 */
public class PanelManderboltPropeties extends JPanel implements FractalProperties {
    public PanelManderboltPropeties() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Kasun Vithanage
        panel1 = new JPanel();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        textFieldRealMin = new JTextField();
        textFieldRealMax = new JTextField();
        textFieldImgMin = new JTextField();
        textFieldImgMax = new JTextField();
        label5 = new JLabel();

        //======== panel1 ========
        {

            // JFormDesigner evaluation mark
            panel1.setBorder(new javax.swing.border.CompoundBorder(
                    new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                            "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                            javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                            java.awt.Color.red), panel1.getBorder()));
            panel1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
                public void propertyChange(java.beans.PropertyChangeEvent e) {
                    if ("border".equals(e.getPropertyName())) throw new RuntimeException();
                }
            });


            //---- label1 ----
            label1.setText("Real Min :");
            label1.setLabelFor(textFieldRealMin);
            label1.setHorizontalAlignment(SwingConstants.RIGHT);

            //---- label2 ----
            label2.setText("Real Max :");
            label2.setLabelFor(textFieldRealMax);
            label2.setHorizontalAlignment(SwingConstants.RIGHT);

            //---- label3 ----
            label3.setText("Imaginary Min :");
            label3.setLabelFor(textFieldImgMin);
            label3.setHorizontalAlignment(SwingConstants.RIGHT);

            //---- label4 ----
            label4.setText("Imaginary Max :");
            label4.setLabelFor(textFieldImgMax);
            label4.setHorizontalAlignment(SwingConstants.RIGHT);

            //---- label5 ----
            label5.setText("Region of Interest");

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                    panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                    .addGroup(panel1Layout.createParallelGroup()
                                            .addGroup(panel1Layout.createSequentialGroup()
                                                    .addContainerGap()
                                                    .addGroup(panel1Layout.createParallelGroup()
                                                            .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                    .addComponent(label3, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                    .addComponent(label1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                    .addComponent(label2, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE))
                                                            .addComponent(label4, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE))
                                                    .addGap(18, 18, 18)
                                                    .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                            .addComponent(textFieldImgMin)
                                                            .addComponent(textFieldImgMax, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 254, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(textFieldRealMin)
                                                            .addComponent(textFieldRealMax)))
                                            .addGroup(panel1Layout.createSequentialGroup()
                                                    .addGap(15, 15, 15)
                                                    .addComponent(label5)))
                                    .addContainerGap(7, Short.MAX_VALUE))
            );
            panel1Layout.setVerticalGroup(
                    panel1Layout.createParallelGroup()
                            .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                    .addContainerGap(12, Short.MAX_VALUE)
                                    .addComponent(label5)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(textFieldRealMin, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(label2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(textFieldRealMax, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(label3, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(textFieldImgMin, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(label4, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(textFieldImgMax, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                                    .addContainerGap())
            );
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents

        add(panel1);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Kasun Vithanage
    private JPanel panel1;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JTextField textFieldRealMin;
    private JTextField textFieldRealMax;
    private JTextField textFieldImgMin;
    private JTextField textFieldImgMax;
    private JLabel label5;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    @Override
    public void setFractalProperties(AbstractFractal fractal) {
        if (!(fractal instanceof Mandelbrot))
            return;

        Mandelbrot mandelbrot = (Mandelbrot) fractal;
        textFieldRealMax.setText(Double.toString(mandelbrot.getRealMax()));
        textFieldRealMin.setText(Double.toString(mandelbrot.getRealMin()));
        textFieldImgMin.setText(Double.toString(mandelbrot.getImgMin()));
        textFieldImgMax.setText(Double.toString(mandelbrot.getImgMax()));
    }

    public double getRealMax() throws NumberFormatException {
        return Double.parseDouble(textFieldRealMax.getText());
    }

    public double getRealMin() throws NumberFormatException {
        return Double.parseDouble(textFieldRealMin.getText());
    }

    public double getImgMax() throws NumberFormatException {
        return Double.parseDouble(textFieldImgMax.getText());
    }

    public double getImgMin() throws NumberFormatException {
        return Double.parseDouble(textFieldImgMin.getText());
    }
}
