/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Outermost_Package.RunGame;

/**
 * The only way to write to this Singleton is to pass Runnables to it via
 * java.awt.EventQueue.invokeLater( new Runnable() {public void run(...){}} )
 *
 * @author JohnReedLOL
 */
public class JFrame_GUI extends javax.swing.JFrame {

    private static JFrame_GUI singleton_ = null;

    /**
     * Creates new form JFrame_GUI. 
     */
    private JFrame_GUI() {
        initComponents();
    }
// <editor-fold defaultstate="collapsed" desc="Getters">
    /**
     * @return the game_Screen_JPanel_
     */
    public View.Game_Screen_JPanel getGame_Screen_JPanel_() {
        return game_Screen_JPanel_;
    }

    /**
     * @param game_Screen_JPanel_ the game_Screen_JPanel_ to set
     */
    public void setGame_Screen_JPanel_(View.Game_Screen_JPanel game_Screen_JPanel_) {
        this.game_Screen_JPanel_ = game_Screen_JPanel_;
    }

    /**
     * @return the helmetjLabel_
     */
    public javax.swing.JLabel getHelmetjLabel_() {
        return helmetjLabel_;
    }

    /**
     * @param helmetjLabel_ the helmetjLabel_ to set
     */
    public void setHelmetjLabel_(javax.swing.JLabel helmetjLabel_) {
        this.helmetjLabel_ = helmetjLabel_;
    }

    /**
     * @return the incomingChatjScrollPane_
     */
    public javax.swing.JScrollPane getIncomingChatjScrollPane_() {
        return incomingChatjScrollPane_;
    }

    /**
     * @param incomingChatjScrollPane_ the incomingChatjScrollPane_ to set
     */
    public void setIncomingChatjScrollPane_(javax.swing.JScrollPane incomingChatjScrollPane_) {
        this.incomingChatjScrollPane_ = incomingChatjScrollPane_;
    }

    /**
     * @return the incomingChatjTextArea_
     */
    public javax.swing.JTextArea getIncomingChatjTextArea_() {
        return incomingChatjTextArea_;
    }

    /**
     * @param incomingChatjTextArea_ the incomingChatjTextArea_ to set
     */
    public void setIncomingChatjTextArea_(javax.swing.JTextArea incomingChatjTextArea_) {
        this.incomingChatjTextArea_ = incomingChatjTextArea_;
    }

    /**
     * @return the inventoryStatsEquipmentjTabbedPane_
     */
    public javax.swing.JTabbedPane getInventoryStatsEquipmentjTabbedPane_() {
        return inventoryStatsEquipmentjTabbedPane_;
    }

    /**
     * @param inventoryStatsEquipmentjTabbedPane_ the inventoryStatsEquipmentjTabbedPane_ to set
     */
    public void setInventoryStatsEquipmentjTabbedPane_(javax.swing.JTabbedPane inventoryStatsEquipmentjTabbedPane_) {
        this.inventoryStatsEquipmentjTabbedPane_ = inventoryStatsEquipmentjTabbedPane_;
    }

    /**
     * @return the item1jLabel_
     */
    public javax.swing.JLabel getItem1jLabel_() {
        return item1jLabel_;
    }

    /**
     * @param item1jLabel_ the item1jLabel_ to set
     */
    public void setItem1jLabel_(javax.swing.JLabel item1jLabel_) {
        this.item1jLabel_ = item1jLabel_;
    }

    /**
     * @return the item2jLabel_
     */
    public javax.swing.JLabel getItem2jLabel_() {
        return item2jLabel_;
    }

    /**
     * @param item2jLabel_ the item2jLabel_ to set
     */
    public void setItem2jLabel_(javax.swing.JLabel item2jLabel_) {
        this.item2jLabel_ = item2jLabel_;
    }

    /**
     * @return the item3jLabel_
     */
    public javax.swing.JLabel getItem3jLabel_() {
        return item3jLabel_;
    }

    /**
     * @param item3jLabel_ the item3jLabel_ to set
     */
    public void setItem3jLabel_(javax.swing.JLabel item3jLabel_) {
        this.item3jLabel_ = item3jLabel_;
    }

    /**
     * @return the item4jLabel_
     */
    public javax.swing.JLabel getItem4jLabel_() {
        return item4jLabel_;
    }

    /**
     * @param item4jLabel_ the item4jLabel_ to set
     */
    public void setItem4jLabel_(javax.swing.JLabel item4jLabel_) {
        this.item4jLabel_ = item4jLabel_;
    }

    /**
     * @return the minimap_JTextPanel_
     */
    public View.Minimap_JTextPanel getMinimap_JTextPanel_() {
        return minimap_JTextPanel_;
    }

    /**
     * @param minimap_JTextPanel_ the minimap_JTextPanel_ to set
     */
    public void setMinimap_JTextPanel_(View.Minimap_JTextPanel minimap_JTextPanel_) {
        this.minimap_JTextPanel_ = minimap_JTextPanel_;
    }

    /**
     * @return the musicOptionjRadioButton_
     */
    public javax.swing.JRadioButton getMusicOptionjRadioButton_() {
        return musicOptionjRadioButton_;
    }

    /**
     * @param musicOptionjRadioButton_ the musicOptionjRadioButton_ to set
     */
    public void setMusicOptionjRadioButton_(javax.swing.JRadioButton musicOptionjRadioButton_) {
        this.musicOptionjRadioButton_ = musicOptionjRadioButton_;
    }

    /**
     * @return the optionsjPanel_
     */
    public javax.swing.JPanel getOptionsjPanel_() {
        return optionsjPanel_;
    }

    /**
     * @param optionsjPanel_ the optionsjPanel_ to set
     */
    public void setOptionsjPanel_(javax.swing.JPanel optionsjPanel_) {
        this.optionsjPanel_ = optionsjPanel_;
    }

    /**
     * @return the outgoingChatjTextField_
     */
    public javax.swing.JTextField getOutgoingChatjTextField_() {
        return outgoingChatjTextField_;
    }

    /**
     * @param outgoingChatjTextField_ the outgoingChatjTextField_ to set
     */
    public void setOutgoingChatjTextField_(javax.swing.JTextField outgoingChatjTextField_) {
        this.outgoingChatjTextField_ = outgoingChatjTextField_;
    }

    /**
     * @return the playerControlsjScrollPane_
     */
    public javax.swing.JScrollPane getPlayerControlsjScrollPane_() {
        return playerControlsjScrollPane_;
    }

    /**
     * @param playerControlsjScrollPane_ the playerControlsjScrollPane_ to set
     */
    public void setPlayerControlsjScrollPane_(javax.swing.JScrollPane playerControlsjScrollPane_) {
        this.playerControlsjScrollPane_ = playerControlsjScrollPane_;
    }

    /**
     * @return the playerControlsjTextArea_
     */
    public javax.swing.JTextArea getPlayerControlsjTextArea_() {
        return playerControlsjTextArea_;
    }

    /**
     * @param playerControlsjTextArea_ the playerControlsjTextArea_ to set
     */
    public void setPlayerControlsjTextArea_(javax.swing.JTextArea playerControlsjTextArea_) {
        this.playerControlsjTextArea_ = playerControlsjTextArea_;
    }

    /**
     * @return the playerEquipmentjPanel_
     */
    public javax.swing.JPanel getPlayerEquipmentjPanel_() {
        return playerEquipmentjPanel_;
    }

    /**
     * @param playerEquipmentjPanel_ the playerEquipmentjPanel_ to set
     */
    public void setPlayerEquipmentjPanel_(javax.swing.JPanel playerEquipmentjPanel_) {
        this.playerEquipmentjPanel_ = playerEquipmentjPanel_;
    }

    /**
     * @return the playerSpecialjPanel_
     */
    public javax.swing.JPanel getPlayerSpecialjPanel_() {
        return playerSpecialjPanel_;
    }

    /**
     * @param playerSpecialjPanel_ the playerSpecialjPanel_ to set
     */
    public void setPlayerSpecialjPanel_(javax.swing.JPanel playerSpecialjPanel_) {
        this.playerSpecialjPanel_ = playerSpecialjPanel_;
    }

    /**
     * @return the playerStatsjScrollPane_
     */
    public javax.swing.JScrollPane getPlayerStatsjScrollPane_() {
        return playerStatsjScrollPane_;
    }

    /**
     * @param playerStatsjScrollPane_ the playerStatsjScrollPane_ to set
     */
    public void setPlayerStatsjScrollPane_(javax.swing.JScrollPane playerStatsjScrollPane_) {
        this.playerStatsjScrollPane_ = playerStatsjScrollPane_;
    }

    /**
     * @return the playerStatsjTextArea_
     */
    public javax.swing.JTextArea getPlayerStatsjTextArea_() {
        return playerStatsjTextArea_;
    }

    /**
     * @param playerStatsjTextArea_ the playerStatsjTextArea_ to set
     */
    public void setPlayerStatsjTextArea_(javax.swing.JTextArea playerStatsjTextArea_) {
        this.playerStatsjTextArea_ = playerStatsjTextArea_;
    }

    /**
     * @return the sheildSlotjLabel_
     */
    public javax.swing.JLabel getSheildSlotjLabel_() {
        return sheildSlotjLabel_;
    }

    /**
     * @param sheildSlotjLabel_ the sheildSlotjLabel_ to set
     */
    public void setSheildSlotjLabel_(javax.swing.JLabel sheildSlotjLabel_) {
        this.sheildSlotjLabel_ = sheildSlotjLabel_;
    }

    /**
     * @return the soundOptionjRadioButton_
     */
    public javax.swing.JRadioButton getSoundOptionjRadioButton_() {
        return soundOptionjRadioButton_;
    }

    /**
     * @param soundOptionjRadioButton_ the soundOptionjRadioButton_ to set
     */
    public void setSoundOptionjRadioButton_(javax.swing.JRadioButton soundOptionjRadioButton_) {
        this.soundOptionjRadioButton_ = soundOptionjRadioButton_;
    }

    /**
     * @return the spelljButton1_
     */
    public javax.swing.JButton getSpelljButton1_() {
        return spelljButton1_;
    }

    /**
     * @param spelljButton1_ the spelljButton1_ to set
     */
    public void setSpelljButton1_(javax.swing.JButton spelljButton1_) {
        this.spelljButton1_ = spelljButton1_;
    }

    /**
     * @return the spelljButton2_
     */
    public javax.swing.JButton getSpelljButton2_() {
        return spelljButton2_;
    }

    /**
     * @param spelljButton2_ the spelljButton2_ to set
     */
    public void setSpelljButton2_(javax.swing.JButton spelljButton2_) {
        this.spelljButton2_ = spelljButton2_;
    }

    /**
     * @return the spelljButton3_
     */
    public javax.swing.JButton getSpelljButton3_() {
        return spelljButton3_;
    }

    /**
     * @param spelljButton3_ the spelljButton3_ to set
     */
    public void setSpelljButton3_(javax.swing.JButton spelljButton3_) {
        this.spelljButton3_ = spelljButton3_;
    }

    /**
     * @return the spelljButton4_
     */
    public javax.swing.JButton getSpelljButton4_() {
        return spelljButton4_;
    }

    /**
     * @param spelljButton4_ the spelljButton4_ to set
     */
    public void setSpelljButton4_(javax.swing.JButton spelljButton4_) {
        this.spelljButton4_ = spelljButton4_;
    }

    /**
     * @return the weaponSlotjLabel_
     */
    public javax.swing.JLabel getWeaponSlotjLabel_() {
        return weaponSlotjLabel_;
    }

    /**
     * @param weaponSlotjLabel_ the weaponSlotjLabel_ to set
     */
    public void setWeaponSlotjLabel_(javax.swing.JLabel weaponSlotjLabel_) {
        this.weaponSlotjLabel_ = weaponSlotjLabel_;
    }
// </editor-fold>

    /**
     * Returns a reference to the singleton.
     * @return 
     */
    public static JFrame_GUI get_GUI() {
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
                java.util.logging.Logger.getLogger(JFrame_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }

            /* Create and display the form */
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    JFrame_GUI.singleton_ = new JFrame_GUI();
                    singleton_.setVisible(true);
                }
            });
        }
        return JFrame_GUI.singleton_;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="DO NOT READ WRITE OR MODIFY">
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        outgoingChatjTextField_ = new javax.swing.JTextField();
        incomingChatjScrollPane_ = new javax.swing.JScrollPane();
        incomingChatjTextArea_ = new javax.swing.JTextArea();
        inventoryStatsEquipmentjTabbedPane_ = new javax.swing.JTabbedPane();
        playerStatsjScrollPane_ = new javax.swing.JScrollPane();
        playerStatsjTextArea_ = new javax.swing.JTextArea();
        playerInventoryjPanel_ = new javax.swing.JPanel();
        item2jLabel_ = new javax.swing.JLabel();
        item4jLabel_ = new javax.swing.JLabel();
        item1jLabel_ = new javax.swing.JLabel();
        item3jLabel_ = new javax.swing.JLabel();
        playerEquipmentjPanel_ = new javax.swing.JPanel();
        weaponSlotjLabel_ = new javax.swing.JLabel();
        helmetjLabel_ = new javax.swing.JLabel();
        sheildSlotjLabel_ = new javax.swing.JLabel();
        playerSpecialjPanel_ = new javax.swing.JPanel();
        spelljButton1_ = new javax.swing.JButton();
        spelljButton2_ = new javax.swing.JButton();
        spelljButton3_ = new javax.swing.JButton();
        spelljButton4_ = new javax.swing.JButton();
        optionsjPanel_ = new javax.swing.JPanel();
        musicOptionjRadioButton_ = new javax.swing.JRadioButton();
        soundOptionjRadioButton_ = new javax.swing.JRadioButton();
        controlsSplitPane_ = new javax.swing.JSplitPane();
        keyBindingsjScrollPane_ = new javax.swing.JScrollPane();
        keyCommandsjScrollPane_ = new javax.swing.JScrollPane();
        keyCommandsjTextArea_ = new javax.swing.JTextArea();
        keyBindingsjScrollPane2_ = new javax.swing.JScrollPane();
        keyBindingsjTextArea_ = new javax.swing.JTextArea();
        game_Screen_JPanel_ = new View.Game_Screen_JPanel();
        minimap_JTextPanel_ = new View.Minimap_JTextPanel();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Welcome to RunarScape");
        setPreferredSize(new java.awt.Dimension(800, 600));
        setResizable(false);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
                formWindowLostFocus(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
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

        outgoingChatjTextField_.setText("  outgoingChatjTextField_");
        outgoingChatjTextField_.setFocusable(false);

        incomingChatjTextArea_.setEditable(false);
        incomingChatjTextArea_.setColumns(20);
        incomingChatjTextArea_.setRows(5);
        incomingChatjTextArea_.setText("  incomingChatjTextArea_");
        incomingChatjTextArea_.setFocusable(false);
        incomingChatjScrollPane_.setViewportView(incomingChatjTextArea_);

        playerStatsjTextArea_.setEditable(false);
        playerStatsjTextArea_.setColumns(20);
        playerStatsjTextArea_.setRows(5);
        playerStatsjTextArea_.setText(" playerStatsjTextArea_ ");
        playerStatsjTextArea_.setFocusable(false);
        playerStatsjScrollPane_.setViewportView(playerStatsjTextArea_);

        inventoryStatsEquipmentjTabbedPane_.addTab("Stats", playerStatsjScrollPane_);

        playerInventoryjPanel_.setFocusable(false);

        item2jLabel_.setText("item2jLabel_");
        item2jLabel_.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        item2jLabel_.setPreferredSize(new java.awt.Dimension(80, 80));

        item4jLabel_.setText("item4jLabel_");
        item4jLabel_.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        item4jLabel_.setPreferredSize(new java.awt.Dimension(80, 80));

        item1jLabel_.setText("item1jLabel_");
        item1jLabel_.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        item1jLabel_.setPreferredSize(new java.awt.Dimension(80, 80));

        item3jLabel_.setText("item3jLabel_");
        item3jLabel_.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        item3jLabel_.setPreferredSize(new java.awt.Dimension(80, 80));

        javax.swing.GroupLayout playerInventoryjPanel_Layout = new javax.swing.GroupLayout(playerInventoryjPanel_);
        playerInventoryjPanel_.setLayout(playerInventoryjPanel_Layout);
        playerInventoryjPanel_Layout.setHorizontalGroup(
            playerInventoryjPanel_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(playerInventoryjPanel_Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(playerInventoryjPanel_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(playerInventoryjPanel_Layout.createSequentialGroup()
                        .addComponent(item1jLabel_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(item2jLabel_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, playerInventoryjPanel_Layout.createSequentialGroup()
                        .addComponent(item3jLabel_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(item4jLabel_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))))
        );
        playerInventoryjPanel_Layout.setVerticalGroup(
            playerInventoryjPanel_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(playerInventoryjPanel_Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(playerInventoryjPanel_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(item1jLabel_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(item2jLabel_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(playerInventoryjPanel_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(item4jLabel_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(item3jLabel_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(82, Short.MAX_VALUE))
        );

        inventoryStatsEquipmentjTabbedPane_.addTab("Items", playerInventoryjPanel_);

        playerEquipmentjPanel_.setFocusable(false);

        weaponSlotjLabel_.setText("weaponSlotjLabel_");
        weaponSlotjLabel_.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        weaponSlotjLabel_.setPreferredSize(new java.awt.Dimension(80, 80));

        helmetjLabel_.setText("helmetjLabel_");
        helmetjLabel_.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        helmetjLabel_.setPreferredSize(new java.awt.Dimension(80, 80));

        sheildSlotjLabel_.setText("sheildSlotjLabel_");
        sheildSlotjLabel_.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sheildSlotjLabel_.setPreferredSize(new java.awt.Dimension(80, 80));

        javax.swing.GroupLayout playerEquipmentjPanel_Layout = new javax.swing.GroupLayout(playerEquipmentjPanel_);
        playerEquipmentjPanel_.setLayout(playerEquipmentjPanel_Layout);
        playerEquipmentjPanel_Layout.setHorizontalGroup(
            playerEquipmentjPanel_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, playerEquipmentjPanel_Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sheildSlotjLabel_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(weaponSlotjLabel_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, playerEquipmentjPanel_Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(helmetjLabel_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59))
        );
        playerEquipmentjPanel_Layout.setVerticalGroup(
            playerEquipmentjPanel_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, playerEquipmentjPanel_Layout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addComponent(helmetjLabel_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(playerEquipmentjPanel_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sheildSlotjLabel_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(weaponSlotjLabel_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(95, 95, 95))
        );

        inventoryStatsEquipmentjTabbedPane_.addTab("Gear", playerEquipmentjPanel_);

        playerSpecialjPanel_.setFocusable(false);

        spelljButton1_.setText("spelljButton1_");
        spelljButton1_.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                spelljButton1_MousePressed(evt);
            }
        });

        spelljButton2_.setText("spelljButton2_");
        spelljButton2_.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                spelljButton2_MousePressed(evt);
            }
        });

        spelljButton3_.setText("spelljButton3_");
        spelljButton3_.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                spelljButton3_MousePressed(evt);
            }
        });

        spelljButton4_.setText("spelljButton4_");
        spelljButton4_.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                spelljButton4_MousePressed(evt);
            }
        });

        javax.swing.GroupLayout playerSpecialjPanel_Layout = new javax.swing.GroupLayout(playerSpecialjPanel_);
        playerSpecialjPanel_.setLayout(playerSpecialjPanel_Layout);
        playerSpecialjPanel_Layout.setHorizontalGroup(
            playerSpecialjPanel_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(playerSpecialjPanel_Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(playerSpecialjPanel_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(spelljButton1_, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                    .addComponent(spelljButton2_, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(spelljButton3_, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(spelljButton4_, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        playerSpecialjPanel_Layout.setVerticalGroup(
            playerSpecialjPanel_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(playerSpecialjPanel_Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(spelljButton1_, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(spelljButton2_, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(spelljButton3_, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(spelljButton4_, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        inventoryStatsEquipmentjTabbedPane_.addTab("Special", playerSpecialjPanel_);

        optionsjPanel_.setFocusable(false);

        musicOptionjRadioButton_.setText("musicOptionjRadioButton_");
        musicOptionjRadioButton_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                musicOptionjRadioButton_ActionPerformed(evt);
            }
        });

        soundOptionjRadioButton_.setText("soundOptionjRadioButton_");
        soundOptionjRadioButton_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                soundOptionjRadioButton_ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout optionsjPanel_Layout = new javax.swing.GroupLayout(optionsjPanel_);
        optionsjPanel_.setLayout(optionsjPanel_Layout);
        optionsjPanel_Layout.setHorizontalGroup(
            optionsjPanel_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(optionsjPanel_Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(optionsjPanel_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(musicOptionjRadioButton_, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(soundOptionjRadioButton_, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        optionsjPanel_Layout.setVerticalGroup(
            optionsjPanel_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(optionsjPanel_Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(musicOptionjRadioButton_, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(soundOptionjRadioButton_, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(191, Short.MAX_VALUE))
        );

        inventoryStatsEquipmentjTabbedPane_.addTab("Options", optionsjPanel_);

        controlsSplitPane_.setDividerLocation(60);
        controlsSplitPane_.setFocusable(false);
        controlsSplitPane_.setLeftComponent(keyBindingsjScrollPane_);

        keyCommandsjTextArea_.setEditable(false);
        keyCommandsjTextArea_.setColumns(20);
        keyCommandsjTextArea_.setRows(5);
        keyCommandsjTextArea_.setText("Commands:\nWalk up\nWalk left\nWalk down\nWalk right\n...");
        keyCommandsjScrollPane_.setViewportView(keyCommandsjTextArea_);

        controlsSplitPane_.setRightComponent(keyCommandsjScrollPane_);

        keyBindingsjTextArea_.setColumns(20);
        keyBindingsjTextArea_.setRows(5);
        keyBindingsjTextArea_.setText("Keys:\nW\nA\nS\nD\n...");
        keyBindingsjScrollPane2_.setViewportView(keyBindingsjTextArea_);

        controlsSplitPane_.setLeftComponent(keyBindingsjScrollPane2_);

        inventoryStatsEquipmentjTabbedPane_.addTab("Controls", controlsSplitPane_);

        game_Screen_JPanel_.setFocusable(false);

        javax.swing.GroupLayout game_Screen_JPanel_Layout = new javax.swing.GroupLayout(game_Screen_JPanel_);
        game_Screen_JPanel_.setLayout(game_Screen_JPanel_Layout);
        game_Screen_JPanel_Layout.setHorizontalGroup(
            game_Screen_JPanel_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        game_Screen_JPanel_Layout.setVerticalGroup(
            game_Screen_JPanel_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        minimap_JTextPanel_.setFocusable(false);
        minimap_JTextPanel_.setPreferredSize(new java.awt.Dimension(200, 200));

        javax.swing.GroupLayout minimap_JTextPanel_Layout = new javax.swing.GroupLayout(minimap_JTextPanel_);
        minimap_JTextPanel_.setLayout(minimap_JTextPanel_Layout);
        minimap_JTextPanel_Layout.setHorizontalGroup(
            minimap_JTextPanel_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 198, Short.MAX_VALUE)
        );
        minimap_JTextPanel_Layout.setVerticalGroup(
            minimap_JTextPanel_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 198, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(outgoingChatjTextField_, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(incomingChatjScrollPane_, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
                    .addComponent(game_Screen_JPanel_, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 14, Short.MAX_VALUE)
                        .addComponent(minimap_JTextPanel_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(inventoryStatsEquipmentjTabbedPane_, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(minimap_JTextPanel_, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inventoryStatsEquipmentjTabbedPane_, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(game_Screen_JPanel_, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(incomingChatjScrollPane_, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(outgoingChatjTextField_, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // <editor-fold>

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // Add your event handling code here:
    }//GEN-LAST:event_formKeyPressed

    private void formKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyTyped
        // Add your event handling code here:
    }//GEN-LAST:event_formKeyTyped

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        // Add your event handling code here:
    }//GEN-LAST:event_formMousePressed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // Add your event handling code here:
    }//GEN-LAST:event_formWindowClosing

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // Add your event handling code here:
        RunGame.printStackTraceAndCrashTheProgramBecause("Program is finished.");
    }//GEN-LAST:event_formWindowClosed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // Add your event handling code here:
    }//GEN-LAST:event_formWindowOpened

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        // Add your event handling code here:
    }//GEN-LAST:event_formWindowGainedFocus

    private void formWindowLostFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowLostFocus
        // Add your event handling code here:
    }//GEN-LAST:event_formWindowLostFocus

    private void soundOptionjRadioButton_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_soundOptionjRadioButton_ActionPerformed
        // Add your event handling code here:
    }//GEN-LAST:event_soundOptionjRadioButton_ActionPerformed

    private void musicOptionjRadioButton_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_musicOptionjRadioButton_ActionPerformed
        // Add your event handling code here:
    }//GEN-LAST:event_musicOptionjRadioButton_ActionPerformed

    private void spelljButton1_MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_spelljButton1_MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_spelljButton1_MousePressed

    private void spelljButton2_MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_spelljButton2_MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_spelljButton2_MousePressed

    private void spelljButton3_MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_spelljButton3_MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_spelljButton3_MousePressed

    private void spelljButton4_MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_spelljButton4_MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_spelljButton4_MousePressed

// <editor-fold defaultstate="collapsed" desc="DO NOT MODIFY">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSplitPane controlsSplitPane_;
    private View.Game_Screen_JPanel game_Screen_JPanel_;
    private javax.swing.JLabel helmetjLabel_;
    private javax.swing.JScrollPane incomingChatjScrollPane_;
    private javax.swing.JTextArea incomingChatjTextArea_;
    private javax.swing.JTabbedPane inventoryStatsEquipmentjTabbedPane_;
    private javax.swing.JLabel item1jLabel_;
    private javax.swing.JLabel item2jLabel_;
    private javax.swing.JLabel item3jLabel_;
    private javax.swing.JLabel item4jLabel_;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane keyBindingsjScrollPane2_;
    private javax.swing.JScrollPane keyBindingsjScrollPane_;
    private javax.swing.JTextArea keyBindingsjTextArea_;
    private javax.swing.JScrollPane keyCommandsjScrollPane_;
    private javax.swing.JTextArea keyCommandsjTextArea_;
    private View.Minimap_JTextPanel minimap_JTextPanel_;
    private javax.swing.JRadioButton musicOptionjRadioButton_;
    private javax.swing.JPanel optionsjPanel_;
    private javax.swing.JTextField outgoingChatjTextField_;
    private javax.swing.JPanel playerEquipmentjPanel_;
    private javax.swing.JPanel playerInventoryjPanel_;
    private javax.swing.JPanel playerSpecialjPanel_;
    private javax.swing.JScrollPane playerStatsjScrollPane_;
    private javax.swing.JTextArea playerStatsjTextArea_;
    private javax.swing.JLabel sheildSlotjLabel_;
    private javax.swing.JRadioButton soundOptionjRadioButton_;
    private javax.swing.JButton spelljButton1_;
    private javax.swing.JButton spelljButton2_;
    private javax.swing.JButton spelljButton3_;
    private javax.swing.JButton spelljButton4_;
    private javax.swing.JLabel weaponSlotjLabel_;
    // End of variables declaration//GEN-END:variables
// <editor-fold>
}
