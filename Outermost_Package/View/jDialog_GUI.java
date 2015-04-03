/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Outermost_Package.View;

import Outermost_Package.RunGame;

/**
 *
 * @author JohnMichaelReed
 */
public class jDialog_GUI extends javax.swing.JDialog {

    private static jDialog_GUI singleton_ = null;

    /**
     * Creates new form jDialog_GUI
     */
    public jDialog_GUI(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        uiThreadCheck();
        this.setModalityType(jDialog_GUI.ModalityType.APPLICATION_MODAL);
        if (this.getModalityType() != jDialog_GUI.ModalityType.APPLICATION_MODAL) {
            RunGame.printStackTraceAndCrashTheProgramBecause("It was supposed to be modal.");
        }
    }

    /**
     * Returns a reference to the singleton.
     *
     * @return
     */
    public static jDialog_GUI get_GUI() {
        if (singleton_ == null) {
            try {
                for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                    if ("Metal".equals(info.getName())) {
                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                java.util.logging.Logger.getLogger(jDialog_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }

            /* Create and display the form */
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    jDialog_GUI.singleton_ = new jDialog_GUI(new javax.swing.JFrame(), true);
                    singleton_.addWindowListener(new java.awt.event.WindowAdapter() {
                        @Override
                        public void windowClosing(java.awt.event.WindowEvent e) {
                            System.exit(0);
                        }
                    });
                    singleton_.requestFocus();
                    singleton_.setVisible(true);
                }
            });
        }
        return jDialog_GUI.singleton_;
    }

    /**
     * Checks to see if the program is running on the UI thread in the GUI.
     */
    private void uiThreadCheck() {
        if (!java.awt.EventQueue.isDispatchThread()) {
            RunGame.printStackTraceAndCrashTheProgramBecause("Only the UI thread can access this data");
        }
    }

// <editor-fold defaultstate="collapsed" desc="Accessors">
    public javax.swing.JPanel getGameScreenjPanel_() {
        this.uiThreadCheck();
        return gameScreenjPanel_;
    }

    public void setGameScreenjPanel_(javax.swing.JPanel gameScreenjPanel_) {
        this.uiThreadCheck();
        this.gameScreenjPanel_ = gameScreenjPanel_;
    }

    public javax.swing.JLabel getHelmetSlotEquipmentjLabel_() {
        this.uiThreadCheck();
        return helmetSlotEquipmentjLabel_;
    }

    public void setHelmetSlotEquipmentjLabel_(javax.swing.JLabel helmetSlotEquipmentjLabel_) {
        this.uiThreadCheck();
        this.helmetSlotEquipmentjLabel_ = helmetSlotEquipmentjLabel_;
    }

    public javax.swing.JTextArea getIncomingChatjTextArea_() {
        this.uiThreadCheck();
        return incomingChatjTextArea_;
    }

    public void setIncomingChatjTextArea_(javax.swing.JTextArea incomingChatjTextArea_) {
        this.uiThreadCheck();
        this.incomingChatjTextArea_ = incomingChatjTextArea_;
    }

    public javax.swing.JLabel getItem1jLabel_() {
        this.uiThreadCheck();
        return item1jLabel_;
    }

    public void setItem1jLabel_(javax.swing.JLabel item1jLabel_) {
        this.uiThreadCheck();
        this.item1jLabel_ = item1jLabel_;
    }

    public javax.swing.JLabel getItem2jLabel_() {
        this.uiThreadCheck();
        return item2jLabel_;
    }

    public void setItem2jLabel_(javax.swing.JLabel item2jLabel_) {
        this.uiThreadCheck();
        this.item2jLabel_ = item2jLabel_;
    }

    public javax.swing.JLabel getItem3jLabel_() {
        this.uiThreadCheck();
        return item3jLabel_;
    }

    public void setItem3jLabel_(javax.swing.JLabel item3jLabel_) {
        this.uiThreadCheck();
        this.item3jLabel_ = item3jLabel_;
    }

    public javax.swing.JLabel getItem4jLabel_() {
        this.uiThreadCheck();
        return item4jLabel_;
    }

    public void setItem4jLabel_(javax.swing.JLabel item4jLabel_) {
        this.uiThreadCheck();
        this.item4jLabel_ = item4jLabel_;
    }

    public javax.swing.JPanel getMiniMapjPanel_() {
        this.uiThreadCheck();
        return miniMapjPanel_;
    }

    public void setMiniMapjPanel_(javax.swing.JPanel miniMapjPanel_) {
        this.uiThreadCheck();
        this.miniMapjPanel_ = miniMapjPanel_;
    }

    public javax.swing.JScrollPane getOutgoingChatjScrollPane() {
        this.uiThreadCheck();
        return outgoingChatjScrollPane;
    }

    public void setOutgoingChatjScrollPane(javax.swing.JScrollPane outgoingChatjScrollPane) {
        this.uiThreadCheck();
        this.outgoingChatjScrollPane = outgoingChatjScrollPane;
    }

    public javax.swing.JTextField getOutgoingChatjTextField_() {
        this.uiThreadCheck();
        return outgoingChatjTextField_;
    }

    public void setOutgoingChatjTextField_(javax.swing.JTextField outgoingChatjTextField_) {
        this.uiThreadCheck();
        this.outgoingChatjTextField_ = outgoingChatjTextField_;
    }

    public javax.swing.JPanel getPlayerEquipmentjPanel_() {
        this.uiThreadCheck();
        return playerEquipmentjPanel_;
    }

    public void setPlayerEquipmentjPanel_(javax.swing.JPanel playerEquipmentjPanel_) {
        this.uiThreadCheck();
        this.playerEquipmentjPanel_ = playerEquipmentjPanel_;
    }

    public javax.swing.JPanel getPlayerItemsjPanel_() {
        this.uiThreadCheck();
        return playerItemsjPanel_;
    }

    public void setPlayerItemsjPanel_(javax.swing.JPanel playerItemsjPanel_) {
        this.uiThreadCheck();
        this.playerItemsjPanel_ = playerItemsjPanel_;
    }

    public javax.swing.JPanel getPlayerItemsjPanel_1() {
        this.uiThreadCheck();
        return playerItemsjPanel_1;
    }

    public void setPlayerItemsjPanel_1(javax.swing.JPanel playerItemsjPanel_1) {
        this.uiThreadCheck();
        this.playerItemsjPanel_1 = playerItemsjPanel_1;
    }

    public javax.swing.JButton getPlayerSpelljButton1_() {
        this.uiThreadCheck();
        return playerSpelljButton1_;
    }

    public void setPlayerSpelljButton1_(javax.swing.JButton playerSpelljButton1_) {
        this.uiThreadCheck();
        this.playerSpelljButton1_ = playerSpelljButton1_;
    }

    public javax.swing.JButton getPlayerSpelljButton2_() {
        this.uiThreadCheck();
        return playerSpelljButton2_;
    }

    public void setPlayerSpelljButton2_(javax.swing.JButton playerSpelljButton2_) {
        this.uiThreadCheck();
        this.playerSpelljButton2_ = playerSpelljButton2_;
    }

    public javax.swing.JButton getPlayerSpelljButton3_() {
        this.uiThreadCheck();
        return playerSpelljButton3_;
    }

    public void setPlayerSpelljButton3_(javax.swing.JButton playerSpelljButton3_) {
        this.uiThreadCheck();
        this.playerSpelljButton3_ = playerSpelljButton3_;
    }

    public javax.swing.JButton getPlayerSpelljButton4_() {
        this.uiThreadCheck();
        return playerSpelljButton4_;
    }

    public void setPlayerSpelljButton4_(javax.swing.JButton playerSpelljButton4_) {
        this.uiThreadCheck();
        this.playerSpelljButton4_ = playerSpelljButton4_;
    }

    public javax.swing.JPanel getPlayerSpellsjPanel_() {
        this.uiThreadCheck();
        return playerSpellsjPanel_;
    }

    public void setPlayerSpellsjPanel_(javax.swing.JPanel playerSpellsjPanel_) {
        this.uiThreadCheck();
        this.playerSpellsjPanel_ = playerSpellsjPanel_;
    }

    public javax.swing.JScrollPane getPlayerStatsjScrollPane_() {
        this.uiThreadCheck();
        return playerStatsjScrollPane_;
    }

    public void setPlayerStatsjScrollPane_(javax.swing.JScrollPane playerStatsjScrollPane_) {
        this.uiThreadCheck();
        this.playerStatsjScrollPane_ = playerStatsjScrollPane_;
    }

    public javax.swing.JTextPane getPlayerStatsjTextPane_() {
        this.uiThreadCheck();
        return playerStatsjTextPane_;
    }

    public void setPlayerStatsjTextPane_(javax.swing.JTextPane playerStatsjTextPane_) {
        this.uiThreadCheck();
        this.playerStatsjTextPane_ = playerStatsjTextPane_;
    }

    public javax.swing.JLabel getSheildSlotEquipmentjLabel_() {
        this.uiThreadCheck();
        return sheildSlotEquipmentjLabel_;
    }

    public void setSheildSlotEquipmentjLabel_(javax.swing.JLabel sheildSlotEquipmentjLabel_) {
        this.uiThreadCheck();
        this.sheildSlotEquipmentjLabel_ = sheildSlotEquipmentjLabel_;
    }

    public javax.swing.JTabbedPane getStatsItemsEquipmentjTabbedPane_() {
        this.uiThreadCheck();
        return statsItemsEquipmentjTabbedPane_;
    }

    public void setStatsItemsEquipmentjTabbedPane_(javax.swing.JTabbedPane statsItemsEquipmentjTabbedPane_) {
        this.uiThreadCheck();
        this.statsItemsEquipmentjTabbedPane_ = statsItemsEquipmentjTabbedPane_;
    }

    public javax.swing.JLabel getSwordSlotEquipmentjLabel_() {
        this.uiThreadCheck();
        return swordSlotEquipmentjLabel_;
    }

    public void setSwordSlotEquipmentjLabel_(javax.swing.JLabel swordSlotEquipmentjLabel_) {
        this.uiThreadCheck();
        this.swordSlotEquipmentjLabel_ = swordSlotEquipmentjLabel_;
    }
// </editor-fold>

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        statsItemsEquipmentjTabbedPane_ = new javax.swing.JTabbedPane();
        playerStatsjScrollPane_ = new javax.swing.JScrollPane();
        playerStatsjTextPane_ = new javax.swing.JTextPane();
        playerItemsjPanel_ = new javax.swing.JPanel();
        item2jLabel_ = new javax.swing.JLabel();
        item3jLabel_ = new javax.swing.JLabel();
        item4jLabel_ = new javax.swing.JLabel();
        item1jLabel_ = new javax.swing.JLabel();
        playerEquipmentjPanel_ = new javax.swing.JPanel();
        playerItemsjPanel_1 = new javax.swing.JPanel();
        helmetSlotEquipmentjLabel_ = new javax.swing.JLabel();
        sheildSlotEquipmentjLabel_ = new javax.swing.JLabel();
        swordSlotEquipmentjLabel_ = new javax.swing.JLabel();
        playerSpellsjPanel_ = new javax.swing.JPanel();
        playerSpelljButton1_ = new javax.swing.JButton();
        playerSpelljButton2_ = new javax.swing.JButton();
        playerSpelljButton3_ = new javax.swing.JButton();
        playerSpelljButton4_ = new javax.swing.JButton();
        outgoingChatjTextField_ = new javax.swing.JTextField();
        outgoingChatjScrollPane = new javax.swing.JScrollPane();
        incomingChatjTextArea_ = new javax.swing.JTextArea();
        gameScreenjPanel_ = new javax.swing.JPanel();
        miniMapjPanel_ = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setModal(true);
        setPreferredSize(new java.awt.Dimension(1280, 800));
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                formFocusLost(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
                formWindowLostFocus(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                formKeyTyped(evt);
            }
        });

        playerStatsjScrollPane_.setViewportView(playerStatsjTextPane_);

        statsItemsEquipmentjTabbedPane_.addTab("playerStats", playerStatsjScrollPane_);

        item2jLabel_.setText(" item2jLabel_");
        item2jLabel_.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        item2jLabel_.setPreferredSize(new java.awt.Dimension(80, 80));

        item3jLabel_.setText(" item3jLabel_");
        item3jLabel_.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        item3jLabel_.setPreferredSize(new java.awt.Dimension(80, 80));

        item4jLabel_.setText(" item4jLabel_");
        item4jLabel_.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        item4jLabel_.setPreferredSize(new java.awt.Dimension(80, 80));

        item1jLabel_.setText(" item1jLabel_");
        item1jLabel_.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        item1jLabel_.setPreferredSize(new java.awt.Dimension(80, 80));

        javax.swing.GroupLayout playerItemsjPanel_Layout = new javax.swing.GroupLayout(playerItemsjPanel_);
        playerItemsjPanel_.setLayout(playerItemsjPanel_Layout);
        playerItemsjPanel_Layout.setHorizontalGroup(
            playerItemsjPanel_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(playerItemsjPanel_Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(playerItemsjPanel_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, playerItemsjPanel_Layout.createSequentialGroup()
                        .addComponent(item1jLabel_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                        .addComponent(item2jLabel_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(playerItemsjPanel_Layout.createSequentialGroup()
                        .addComponent(item3jLabel_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(item4jLabel_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        playerItemsjPanel_Layout.setVerticalGroup(
            playerItemsjPanel_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(playerItemsjPanel_Layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addGroup(playerItemsjPanel_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(item2jLabel_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(item1jLabel_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(playerItemsjPanel_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(item3jLabel_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(item4jLabel_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(326, Short.MAX_VALUE))
        );

        statsItemsEquipmentjTabbedPane_.addTab("playerItems", playerItemsjPanel_);

        helmetSlotEquipmentjLabel_.setText(" helmetSlot");
        helmetSlotEquipmentjLabel_.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        helmetSlotEquipmentjLabel_.setPreferredSize(new java.awt.Dimension(80, 80));

        sheildSlotEquipmentjLabel_.setText(" sheildSlot");
        sheildSlotEquipmentjLabel_.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sheildSlotEquipmentjLabel_.setPreferredSize(new java.awt.Dimension(80, 80));

        swordSlotEquipmentjLabel_.setText(" swordSlot");
        swordSlotEquipmentjLabel_.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        swordSlotEquipmentjLabel_.setPreferredSize(new java.awt.Dimension(80, 80));

        javax.swing.GroupLayout playerItemsjPanel_1Layout = new javax.swing.GroupLayout(playerItemsjPanel_1);
        playerItemsjPanel_1.setLayout(playerItemsjPanel_1Layout);
        playerItemsjPanel_1Layout.setHorizontalGroup(
            playerItemsjPanel_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(playerItemsjPanel_1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sheildSlotEquipmentjLabel_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(swordSlotEquipmentjLabel_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, playerItemsjPanel_1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(helmetSlotEquipmentjLabel_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57))
        );
        playerItemsjPanel_1Layout.setVerticalGroup(
            playerItemsjPanel_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(playerItemsjPanel_1Layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(helmetSlotEquipmentjLabel_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(playerItemsjPanel_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sheildSlotEquipmentjLabel_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(swordSlotEquipmentjLabel_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(149, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout playerEquipmentjPanel_Layout = new javax.swing.GroupLayout(playerEquipmentjPanel_);
        playerEquipmentjPanel_.setLayout(playerEquipmentjPanel_Layout);
        playerEquipmentjPanel_Layout.setHorizontalGroup(
            playerEquipmentjPanel_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 195, Short.MAX_VALUE)
            .addGroup(playerEquipmentjPanel_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(playerEquipmentjPanel_Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(playerItemsjPanel_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        playerEquipmentjPanel_Layout.setVerticalGroup(
            playerEquipmentjPanel_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 576, Short.MAX_VALUE)
            .addGroup(playerEquipmentjPanel_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(playerEquipmentjPanel_Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(playerItemsjPanel_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        statsItemsEquipmentjTabbedPane_.addTab("playerEquipment", playerEquipmentjPanel_);

        playerSpelljButton1_.setText("playerSpelljButton1_");
        playerSpelljButton1_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playerSpelljButton1_ActionPerformed(evt);
            }
        });

        playerSpelljButton2_.setText("playerSpelljButton2_");
        playerSpelljButton2_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playerSpelljButton2_ActionPerformed(evt);
            }
        });

        playerSpelljButton3_.setText("playerSpelljButton3_");
        playerSpelljButton3_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playerSpelljButton3_ActionPerformed(evt);
            }
        });

        playerSpelljButton4_.setText("playerSpelljButton3_");
        playerSpelljButton4_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playerSpelljButton4_ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout playerSpellsjPanel_Layout = new javax.swing.GroupLayout(playerSpellsjPanel_);
        playerSpellsjPanel_.setLayout(playerSpellsjPanel_Layout);
        playerSpellsjPanel_Layout.setHorizontalGroup(
            playerSpellsjPanel_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(playerSpellsjPanel_Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(playerSpellsjPanel_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(playerSpelljButton1_, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(playerSpelljButton2_, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(playerSpelljButton3_, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(playerSpelljButton4_, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        playerSpellsjPanel_Layout.setVerticalGroup(
            playerSpellsjPanel_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(playerSpellsjPanel_Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(playerSpelljButton1_, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(playerSpelljButton2_, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(playerSpelljButton3_, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(playerSpelljButton4_, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        statsItemsEquipmentjTabbedPane_.addTab("playerSpells", playerSpellsjPanel_);

        outgoingChatjTextField_.setText("outgoingChatjTextField_");

        incomingChatjTextArea_.setColumns(20);
        incomingChatjTextArea_.setRows(5);
        incomingChatjTextArea_.setText("incomingChatjTextArea_\n\n\n\n\n\ndf\ndfv");
        incomingChatjTextArea_.setMinimumSize(new java.awt.Dimension(593, 123));
        incomingChatjTextArea_.setPreferredSize(new java.awt.Dimension(593, 123));
        outgoingChatjScrollPane.setViewportView(incomingChatjTextArea_);

        gameScreenjPanel_.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout gameScreenjPanel_Layout = new javax.swing.GroupLayout(gameScreenjPanel_);
        gameScreenjPanel_.setLayout(gameScreenjPanel_Layout);
        gameScreenjPanel_Layout.setHorizontalGroup(
            gameScreenjPanel_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        gameScreenjPanel_Layout.setVerticalGroup(
            gameScreenjPanel_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        miniMapjPanel_.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout miniMapjPanel_Layout = new javax.swing.GroupLayout(miniMapjPanel_);
        miniMapjPanel_.setLayout(miniMapjPanel_Layout);
        miniMapjPanel_Layout.setHorizontalGroup(
            miniMapjPanel_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 198, Short.MAX_VALUE)
        );
        miniMapjPanel_Layout.setVerticalGroup(
            miniMapjPanel_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 198, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(outgoingChatjScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 659, Short.MAX_VALUE)
                    .addComponent(outgoingChatjTextField_))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(statsItemsEquipmentjTabbedPane_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(gameScreenjPanel_, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(miniMapjPanel_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(miniMapjPanel_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(statsItemsEquipmentjTabbedPane_))
            .addGroup(layout.createSequentialGroup()
                .addComponent(gameScreenjPanel_, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(outgoingChatjScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(outgoingChatjTextField_, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void playerSpelljButton1_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playerSpelljButton1_ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_playerSpelljButton1_ActionPerformed

    private void playerSpelljButton2_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playerSpelljButton2_ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_playerSpelljButton2_ActionPerformed

    private void playerSpelljButton3_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playerSpelljButton3_ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_playerSpelljButton3_ActionPerformed

    private void playerSpelljButton4_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playerSpelljButton4_ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_playerSpelljButton4_ActionPerformed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_formKeyPressed

    private void formKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_formKeyTyped

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_formMousePressed

    private void formWindowLostFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowLostFocus
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowLostFocus

    private void formFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_formFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel gameScreenjPanel_;
    private javax.swing.JLabel helmetSlotEquipmentjLabel_;
    private javax.swing.JTextArea incomingChatjTextArea_;
    private javax.swing.JLabel item1jLabel_;
    private javax.swing.JLabel item2jLabel_;
    private javax.swing.JLabel item3jLabel_;
    private javax.swing.JLabel item4jLabel_;
    private javax.swing.JPanel miniMapjPanel_;
    private javax.swing.JScrollPane outgoingChatjScrollPane;
    private javax.swing.JTextField outgoingChatjTextField_;
    private javax.swing.JPanel playerEquipmentjPanel_;
    private javax.swing.JPanel playerItemsjPanel_;
    private javax.swing.JPanel playerItemsjPanel_1;
    private javax.swing.JButton playerSpelljButton1_;
    private javax.swing.JButton playerSpelljButton2_;
    private javax.swing.JButton playerSpelljButton3_;
    private javax.swing.JButton playerSpelljButton4_;
    private javax.swing.JPanel playerSpellsjPanel_;
    private javax.swing.JScrollPane playerStatsjScrollPane_;
    private javax.swing.JTextPane playerStatsjTextPane_;
    private javax.swing.JLabel sheildSlotEquipmentjLabel_;
    private javax.swing.JTabbedPane statsItemsEquipmentjTabbedPane_;
    private javax.swing.JLabel swordSlotEquipmentjLabel_;
    // End of variables declaration//GEN-END:variables
}
