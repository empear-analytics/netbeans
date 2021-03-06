/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.netbeans.modules.bugtracking.commons;

import org.netbeans.modules.bugtracking.commons.LinkButton;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

/**
 *
 * @author Ondrej Vrabec
 */
public final class SectionPanel extends javax.swing.JPanel {

    final boolean isGTK = "GTK".equals( UIManager.getLookAndFeel().getID() );
    final boolean isNimbus = "Nimbus".equals( UIManager.getLookAndFeel().getID() );
    final boolean isAqua = "Aqua".equals( UIManager.getLookAndFeel().getID() );
    
    /**
     * Creates new form CollapsibleSectionPanel
     */
    public SectionPanel () {
        initComponents();
        Color c = getHeaderBackground();
        headerPanel.setBackground(c);
    }

    public void setLabel (String label) {
        lblTitle.setText(label);
    }

    public String getLabel () {
        return lblTitle.getText();
    }

    public void setContent (JComponent content) {
        ((GroupLayout) getLayout()).replace(this.content, content);
        this.content = content;
    }

    public JLabel getLabelComponent () {
        return lblTitle;
    }

    public void setActions (Action[] sectionActions) {
        ActionsBuilder builder = new ActionsBuilder(actionsPanel);
        for (Action action : sectionActions) {
            builder.addAction(action);
        }
        builder.finish();
    }

    private Color getHeaderBackground () {
        if (isAqua) {
            Color defBk = UIManager.getColor("NbExplorerView.background");
            if (null == defBk) {
                defBk = Color.gray;
            }
            return new Color(defBk.getRed() - 10, defBk.getGreen() - 10, defBk.getBlue() - 10);
        }
        Color bkColor;
        if (isGTK || isNimbus) {
            bkColor = new Color(UIManager.getColor("Menu.background").getRGB());//NOI18N
        } else {
            bkColor = UIManager.getColor("PropSheet.setBackground"); //NOI18N
        }
        // hack for high-contrast black
        Color c = lblTitle.getForeground();
        if (c != null && (c.getRed() >= 240 || c.getGreen() >= 240 || c.getBlue() >= 240)
                && bkColor != null && (bkColor.getRed() >= 192 || bkColor.getGreen() >= 192 || bkColor.getBlue() >= 192)) {
            bkColor = Color.darkGray;
        }
        return bkColor;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        headerPanel = new javax.swing.JPanel();
        actionsPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();

        javax.swing.GroupLayout dummyContentPanelLayout = new javax.swing.GroupLayout(dummyContentPanel);
        dummyContentPanel.setLayout(dummyContentPanelLayout);
        dummyContentPanelLayout.setHorizontalGroup(
            dummyContentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 371, Short.MAX_VALUE)
        );
        dummyContentPanelLayout.setVerticalGroup(
            dummyContentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        headerPanel.setBackground(getHeaderBackground());

        actionsPanel.setOpaque(false);

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, " "); // NOI18N

        javax.swing.GroupLayout actionsPanelLayout = new javax.swing.GroupLayout(actionsPanel);
        actionsPanel.setLayout(actionsPanelLayout);
        actionsPanelLayout.setHorizontalGroup(
            actionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1)
        );
        actionsPanelLayout.setVerticalGroup(
            actionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(actionsPanelLayout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jLabel1))
        );

        org.openide.awt.Mnemonics.setLocalizedText(lblTitle, org.openide.util.NbBundle.getBundle("org.netbeans.modules.bugtracking.commons.Bundle2", java.util.Locale.getDefault(), SectionPanel.class.getClassLoader()).getString("SectionPanel.title")); // NOI18N

        javax.swing.GroupLayout headerPanelLayout = new javax.swing.GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(actionsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        headerPanelLayout.setVerticalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(actionsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTitle)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dummyContentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(headerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(headerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(dummyContentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel actionsPanel;
    private final javax.swing.JPanel dummyContentPanel = new javax.swing.JPanel();
    private javax.swing.JPanel headerPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblTitle;
    // End of variables declaration//GEN-END:variables
    private JComponent content = dummyContentPanel;

    private static class ActionsBuilder {
        private final GroupLayout.SequentialGroup horizontalSeqGroup;
        private final GroupLayout.ParallelGroup verticalParallelGroup;
        private boolean notEmpty = false;

        public ActionsBuilder (JPanel panel) {
            panel.removeAll();
            GroupLayout layout = (GroupLayout) panel.getLayout();
            horizontalSeqGroup = layout.createSequentialGroup();
            layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(horizontalSeqGroup)
            );
            verticalParallelGroup = layout.createParallelGroup(GroupLayout.Alignment.BASELINE);
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(verticalParallelGroup)
            );
        }

        private void addAction (Action action) {
            String name = (String) action.getValue(Action.NAME);
            LinkButton btn = new LinkButton(name);
            btn.addActionListener(action);
            
            if (notEmpty) {
                JLabel separator = new javax.swing.JLabel();
                separator.setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createEmptyBorder(2, 0, 2, 0),
                        BorderFactory.createLineBorder(Color.BLACK, 1)
                ));
                horizontalSeqGroup
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(separator)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED);
                verticalParallelGroup
                    .addComponent(separator, GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE);
            }
            
            horizontalSeqGroup
                    .addComponent(btn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE);
            verticalParallelGroup
                    .addComponent(btn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE);
            notEmpty = true;
        }

        private void finish () {
            horizontalSeqGroup.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE);
        }
    }

}
