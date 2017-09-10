/*
 * Created by JFormDesigner on Tue Jul 25 06:22:51 IST 2017
 */

package com.kasun.ui;

import com.kasun.fractal.AbstractFractal;
import com.kasun.fractal.Julia;

import javax.swing.*;

/**
 * @author Kasun Vithanage
 */
public class PanelJuliaProperties extends JPanel implements FractalProperties {
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Kasun Vithanage
    private JLabel label1;
    private JLabel label2;
    private JTextField txtReal;
    private JLabel label3;
    private JTextField txtImaginary;
    public PanelJuliaProperties() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Kasun Vithanage
        label1 = new JLabel();
        label2 = new JLabel();
        txtReal = new JTextField();
        label3 = new JLabel();
        txtImaginary = new JTextField();

        //======== this ========

        //---- label1 ----
        label1.setText("Parameters for C :");

        //---- label2 ----
        label2.setText("Real : ");

        //---- label3 ----
        label3.setText("Imaginary : ");

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup()
                                        .addComponent(label1)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup()
                                                        .addComponent(label3)
                                                        .addComponent(label2, GroupLayout.Alignment.TRAILING))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(txtImaginary, GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                                                        .addComponent(txtReal, GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE))))
                                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(label1)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtReal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label2))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup()
                                        .addComponent(label3)
                                        .addComponent(txtImaginary, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(36, Short.MAX_VALUE))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    @Override
    public void setFractalProperties(AbstractFractal fractal) {
        if (!(fractal instanceof Julia))
            return;

        Julia julia = (Julia) fractal;

        txtReal.setText(Double.toString(julia.getC().getX()));
        txtImaginary.setText(Double.toString(julia.getC().getY()));
    }

    public double getCReal() throws NumberFormatException {
        return Double.parseDouble(txtReal.getText());
    }

    public double getCImaginary() throws NumberFormatException {
        return Double.parseDouble(txtImaginary.getText());
    }
}
