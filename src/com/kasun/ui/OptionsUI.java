/*
 * Created by JFormDesigner on Mon Jul 24 18:22:54 IST 2017
 */

package com.kasun.ui;

import com.kasun.events.FractalEvent;
import com.kasun.events.FractalEventHandler;
import com.kasun.fractal.AbstractFractal;
import com.kasun.fractal.Julia;
import com.kasun.fractal.Mandelbrot;
import com.kasun.math.Complex;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.util.HashMap;

/**
 * @author Kasun Vithanage
 */
public class OptionsUI extends JPanel {
    public final static String JULIA = "Julia";
    public final static String MANDELBROT = "Mandelbrot";

    private AbstractFractal currentFractal = null;
    private String currentFractalName = "";
    private CardLayout cardLayout = new CardLayout();
    private PanelJuliaProperties juliaProperties;
    private PanelManderboltPropeties manderboltPropeties;

    private FractalEventHandler fractalEventHandler = new FractalEventHandler();
    private HashMap<String, FractalProperties> propertiesHashMap = new HashMap<>();

    public OptionsUI() {
        initComponents();
        postInit();
    }

    public FractalEventHandler getFractalEventHandler() {
        return fractalEventHandler;
    }

    private void postInit() {
        juliaProperties = new PanelJuliaProperties();
        manderboltPropeties = new PanelManderboltPropeties();

        cardProperties.setLayout(cardLayout);
        cardProperties.add(manderboltPropeties, MANDELBROT);
        cardProperties.add(juliaProperties, JULIA);

        propertiesHashMap.put(MANDELBROT, manderboltPropeties);
        propertiesHashMap.put(JULIA, juliaProperties);
    }

    public void setFractalProperties(String name, AbstractFractal fractal) {
        CardLayout layout = (CardLayout) (cardProperties.getLayout());
        layout.show(cardProperties, name);


        if (fractal == null) {
            switch (name) {
                case MANDELBROT:
                    fractal = new Mandelbrot(-1f, 1f, -1f, 1f, 1000);
                    break;

                case JULIA:
                    fractal = new Julia(new Complex(-.4, .6), 1000);
                    break;

                default:
                    fractal = new Mandelbrot(-1f, 1f, -1f, 1f, 1000);
            }
        }


        if (cmbFractalType.getSelectedItem().toString() != name) {
            int index = getIndexOf(name);

            if (index == -1) {
                JOptionPane.showMessageDialog(this.getParent(), "Fatal error !");
                System.exit(200);
            }

            cmbFractalType.setSelectedIndex(index);
        }


        if (fractal != null) {
            fractalEventHandler.dispatchEvent(new FractalEvent(fractal, name));
        }

        this.txtIterations.setText(Integer.valueOf(fractal.getIterations()).toString());
        propertiesHashMap.get(name).setFractalProperties(fractal);

        currentFractal = fractal;
        currentFractalName = name;
    }

    private int getIndexOf(String key) {
        for (int i = 0; i < cmbFractalType.getItemCount(); i++) {
            if (cmbFractalType.getItemAt(i) == key)
                return i;
        }

        return -1;
    }

    private void cmbFractalTypeItemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            setFractalProperties(e.getItem().toString(), null); // in here we initialize default fractal
        }
    }

    private void btnRenderActionPerformed(ActionEvent e) {
        try {
            int iter = Integer.parseInt(txtIterations.getText());
            currentFractal.setIterations(iter);

            switch (currentFractalName) {
                case MANDELBROT:
                    currentFractal.setBounds(manderboltPropeties.getRealMin(), manderboltPropeties.getRealMax(),
                            manderboltPropeties.getImgMin(), manderboltPropeties.getImgMax());
                    break;

                case JULIA:
                    Julia julia = (Julia) currentFractal;
                    julia.setC(new Complex(juliaProperties.getCReal(), juliaProperties.getCImaginary()));
                    currentFractal = julia;
            }

            fractalEventHandler.dispatchEvent(new FractalEvent(currentFractal, currentFractalName));
            propertiesHashMap.get(currentFractalName).setFractalProperties(currentFractal);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(getParent(), "Invalid number inserted", "Warning", JOptionPane.ERROR_MESSAGE);
        }
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Kasun Vithanage
        container = new JPanel();
        label1 = new JLabel();
        cmbFractalType = new JComboBox<>();
        label2 = new JLabel();
        txtIterations = new JFormattedTextField();
        btnRender = new JButton();
        cardProperties = new JPanel();

        //======== container ========
        {

            // JFormDesigner evaluation mark
            container.setBorder(new javax.swing.border.CompoundBorder(
                    new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                            "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                            javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                            java.awt.Color.red), container.getBorder()));
            container.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
                public void propertyChange(java.beans.PropertyChangeEvent e) {
                    if ("border".equals(e.getPropertyName())) throw new RuntimeException();
                }
            });


            //---- label1 ----
            label1.setText("Fractal Type : ");
            label1.setLabelFor(cmbFractalType);

            //---- cmbFractalType ----
            cmbFractalType.setModel(new DefaultComboBoxModel<>(new String[]{
                    "Mandelbrot",
                    "Julia"
            }));
            cmbFractalType.addItemListener(e -> cmbFractalTypeItemStateChanged(e));

            //---- label2 ----
            label2.setText("Iterations : ");
            label2.setLabelFor(txtIterations);

            //---- txtIterations ----
            txtIterations.setColumns(20);
            txtIterations.setText("1000");

            //---- btnRender ----
            btnRender.setText("Render");
            btnRender.addActionListener(e -> btnRenderActionPerformed(e));

            //======== cardProperties ========
            {
                cardProperties.setLayout(new CardLayout(10, 10));
            }

            GroupLayout containerLayout = new GroupLayout(container);
            container.setLayout(containerLayout);
            containerLayout.setHorizontalGroup(
                    containerLayout.createParallelGroup()
                            .addGroup(containerLayout.createSequentialGroup()
                                    .addGroup(containerLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                            .addGroup(containerLayout.createSequentialGroup()
                                                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addGroup(containerLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                            .addComponent(label1)
                                                            .addComponent(label2))
                                                    .addGap(18, 18, 18)
                                                    .addGroup(containerLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                            .addComponent(txtIterations, GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                                                            .addComponent(cmbFractalType, GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE))
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(btnRender, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
                                            .addGroup(GroupLayout.Alignment.LEADING, containerLayout.createSequentialGroup()
                                                    .addContainerGap()
                                                    .addComponent(cardProperties, GroupLayout.PREFERRED_SIZE, 386, GroupLayout.PREFERRED_SIZE)))
                                    .addContainerGap(8, Short.MAX_VALUE))
            );
            containerLayout.setVerticalGroup(
                    containerLayout.createParallelGroup()
                            .addGroup(GroupLayout.Alignment.TRAILING, containerLayout.createSequentialGroup()
                                    .addGap(10, 10, 10)
                                    .addGroup(containerLayout.createParallelGroup()
                                            .addGroup(containerLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                    .addComponent(label1)
                                                    .addComponent(cmbFractalType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                            .addComponent(btnRender))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(containerLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(label2)
                                            .addComponent(txtIterations, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addComponent(cardProperties, GroupLayout.PREFERRED_SIZE, 473, GroupLayout.PREFERRED_SIZE)
                                    .addContainerGap(10, Short.MAX_VALUE))
            );
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents

        container.setPreferredSize(new Dimension(400, 800));
        add(container);

        setPreferredSize(new Dimension(400, 800));
        setSize(getPreferredSize());

    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Kasun Vithanage
    private JPanel container;
    private JLabel label1;
    private JComboBox<String> cmbFractalType;
    private JLabel label2;
    private JFormattedTextField txtIterations;
    private JButton btnRender;
    private JPanel cardProperties;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
