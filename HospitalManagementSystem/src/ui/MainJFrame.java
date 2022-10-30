/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui;

import data.DoctorDirectory;
import data.EncounterHistory;
import data.HospitalDirectory;
import data.PatientDirectory;
import data.PersonDirectory;
import java.awt.CardLayout;
import java.util.ArrayList;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.City;
import model.Community;
import model.Doctor;
import model.Encounter;
import model.Hospital;
import model.House;
import model.Patient;
import model.Person;
import model.VitalSigns;

/**
 *
 * @author riyavirani
 */
public class MainJFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainJFrame
     */
    
    PersonDirectory personDirectory;
    PatientDirectory patientDirectory;
    HospitalDirectory hospitalDirectory;
    DoctorDirectory doctorDirectory;
    House house;
    CardLayout cl;
    CardLayout clPatient;
    CardLayout clDoctor;
    CardLayout clHospAdmin, clHospAdminManageDoctor, clHospAdminManagePatient;
    //CardLayout ;
    //CardLayout ;
    CardLayout clCommAdmin, clCommAdminManageHospitals, clCommAdminManageCommunity;
    int patientCount;
    int doctorCount;
    int selectedRowIndex, selectedRowIndex1, selectedRowIndex2;
    Patient currentPatient;
    Doctor currentDoctor;
    ArrayList<City> cityList;
    City c1;
    public MainJFrame() {
        initComponents();
        patientCount = 1;
        doctorCount = 1;
        personDirectory = new PersonDirectory();
        patientDirectory = new PatientDirectory();
        hospitalDirectory = new HospitalDirectory();
        doctorDirectory = new DoctorDirectory();
        btnLogout.setVisible(false);
        btnLoginAfterSignUp.setVisible(false);
        cityList = new ArrayList<City>();
        c1 = new City();
        c1.setCityId(1);
        c1.setCityName("Boston");
        c1.setCommunityList(new ArrayList<Community>());
        Person sysAdmin = new Person("Riya Kesarwani", new House("Boylston St", "31", "MA", "Back Bay", "Boston", "02199"), "Female", "10/13/1998", 24, "riya13","123","System Admin");
        personDirectory.addPerson(sysAdmin);
        Person commAdmin = new Person("Shashank Kesarwani", new House("Park Dr", "7", "MA", "Back bay", "Boston", "02199"), "Male", "08/24/1997", 25, "shash24","123","Community Admin");
        personDirectory.addPerson(commAdmin);
        Person hospAdmin = new Person("Sakshi Jain", new House("Allston St", "12", "MA", "Allston", "Boston", "02134"), "Female", "03/30/1998", 24, "sakshi30","123","Hospital Admin");
        personDirectory.addPerson(hospAdmin);
        Person doctor = new Person("Divya Dubey", new House("Acorn St", "7b", "MA", "Beacon Hill", "Boston", "02108"), "Female", "10/14/1998", 24, "divya14","123","Doctor");
        personDirectory.addPerson(doctor);
        Doctor d = new Doctor(doctorCount++,1,"Divya Dubey", new House("Acorn St", "7b", "MA", "Beacon Hill", "Boston", "02108"), "Female", "10/14/1998", 24, "divya14","123","Doctor");
        doctorDirectory.addDoctor(d);
        Person patient = new Person("Nikhita Biradar", new House("Allston St", "23", "MA", "Allston", "Boston", "02134"), "Female", "01/17/1998", 24, "nikki17","123","Patient");
        personDirectory.addPerson(patient);
        Patient p = new Patient(patientCount++, new EncounterHistory(),new Encounter(),"Nikhita Biradar", new House("Allston St", "23", "MA", "Allston", "Boston", "02134"), "Female", "01/17/1998", 24, "nikki17","123","Patient");
        patientDirectory.addPatient(p);
        Hospital hosp = new Hospital(1,"Appolo Hospital","Allston");
        hospitalDirectory.addHospital(hosp);
        
        cl = (CardLayout) (card.getLayout());
        card.add(mainRightPanel, "mainRightPanel");
        card.add(PatientMainJPanel,"patientMainJPanel");
        card.add(PatientSignUpJPanel, "patientSignUpJPanel");
        card.add(CommAdminMainJPanel,"commAdminMainJPanel");
        card.add(HospAdminMainJPanel,"hospAdminMainJPanel");
        card.add(DoctorMainJPanel,"doctorMainJPanel");
        card.add(SystemAdminMainJPanel,"systemAdminMainJPanel");
        cl.show(card, "mainRightPanel");
        
        clPatient = (CardLayout) (cardPatient.getLayout());
        cardPatient.add(WelcomePatientJPanel, "welcomePatientJPanel");
        cardPatient.add(PatientSearchHospJPanel1, "patientSearchHospJPanel1");
        cardPatient.add(PatientViewEncounterHistoryJPanel, "patientViewEncounterHistoryJPanel");
        cardPatient.add(PatientAddVitalsJPanel, "patientAddVitalsJPanel");
        clPatient.show(cardPatient, "welcomePatientJPanel");
        
        clDoctor = (CardLayout) (cardDoctor.getLayout());
        cardDoctor.add(WelcomeDoctorJPanel, "welcomeDoctorJPanel");
        cardDoctor.add(DiagnosePatientJPanel, "diagnosePatientJPanel");
        clDoctor.show(cardDoctor, "welcomeDoctorJPanel");
        
        clHospAdmin = (CardLayout) (cardHospAdmin.getLayout());
        cardHospAdmin.add(WelcomeHospAdminJPanel, "welcomeHospAdminJPanel");
        cardHospAdmin.add(HospAdminManageDoctorJPanel, "hospAdminManageDoctorJPanel");
        cardHospAdmin.add(HospAdminManagePatientJPanel, "hospAdminManagePatientJPanel");        
        clHospAdmin.show(cardHospAdmin,"welcomeHospAdminJPanel");
        
        clHospAdminManageDoctor = (CardLayout) (cardHospAdminManageDoctor.getLayout());
        cardHospAdminManageDoctor.add(WelcomeHospAdminManageDoctorJPanel, "welcomeHospAdminManageDoctorJPanel");
        cardHospAdminManageDoctor.add(HospAdminAddDoctorJPanel, "hospAdminAddDoctorJPanel");
        clHospAdminManageDoctor.show(cardHospAdminManageDoctor,"welcomeHospAdminManageDoctorJPanel");
        
        
        clHospAdminManagePatient = (CardLayout) (cardHospAdminManagePatient.getLayout());
        cardHospAdminManagePatient.add(WelcomeHospAdminManagePatientJPanel, "welcomeHospAdminManageDoctorJPanel");
        cardHospAdminManagePatient.add(HospAdminAddPatientJPanel, "hospAdminAddPatientJPanel");
        clHospAdminManagePatient.show(cardHospAdminManagePatient,"welcomeHospAdminManageDoctorJPanel");
        
        clCommAdmin = (CardLayout) (cardCommAdmin.getLayout());
        cardCommAdmin.add(WelcomeCommAdminJPanel, "WelcomeCommAdminJPanel");
        cardCommAdmin.add(CommAdminManageCommunityJPanel, "CommAdminManageCommunityJPanel");
        cardCommAdmin.add(CommAdminManageHospitalsJPanel, "CommAdminManageHospitalsJPanel");        
        clCommAdmin.show(cardCommAdmin,"WelcomeCommAdminJPanel");
                
        
        clCommAdminManageHospitals = (CardLayout) (cardCommAdminManageHospitals.getLayout());
        cardCommAdminManageHospitals.add(WelcomeCommAdminManageHospitalsJPanel, "WelcomeCommAdminManageHospitalsJPanel");
        cardCommAdminManageHospitals.add(CommAdminAddHospitalJPanel, "CommAdminAddHospitalJPanel");
        clCommAdminManageHospitals.show(cardCommAdminManageHospitals,"WelcomeCommAdminManageHospitalsJPanel");
        
        
        clCommAdminManageCommunity = (CardLayout) (cardCommAdminManageCommunity.getLayout());
        cardCommAdminManageCommunity.add(WelcomeCommAdminManageCommunityJPanel, "WelcomeCommAdminManageCommunityJPanel");
        cardCommAdminManageCommunity.add(CommAdminAddCommunityJPanel, "CommAdminAddCommunityJPanel");
        clCommAdminManageCommunity.show(cardCommAdminManageCommunity,"WelcomeCommAdminManageCommunityJPanel");
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainSplitFrame = new javax.swing.JSplitPane();
        navPanel = new javax.swing.JPanel();
        btnLogout = new javax.swing.JButton();
        btnLoginAfterSignUp = new javax.swing.JButton();
        card = new javax.swing.JPanel();
        mainRightPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        txtPassword = new javax.swing.JTextField();
        btnLogin = new javax.swing.JButton();
        btnSignUp = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        PatientSignUpJPanel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtFullName = new javax.swing.JTextField();
        txtUsernamePatient = new javax.swing.JTextField();
        txtPasswordPatient = new javax.swing.JTextField();
        txtDob = new javax.swing.JTextField();
        txtAge = new javax.swing.JTextField();
        txtStreetName = new javax.swing.JTextField();
        txtAptNo = new javax.swing.JTextField();
        txtCityName = new javax.swing.JTextField();
        txtState = new javax.swing.JTextField();
        txtZipcode = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        btnSignUpPatient = new javax.swing.JButton();
        ddGender = new javax.swing.JComboBox<>();
        ddCommName = new javax.swing.JComboBox<>();
        jLabel20 = new javax.swing.JLabel();
        PatientMainJPanel = new javax.swing.JPanel();
        splitPane = new javax.swing.JSplitPane();
        PatientNavPanel = new javax.swing.JPanel();
        btnSearchHosp = new javax.swing.JButton();
        btnEncounterHistory = new javax.swing.JButton();
        btnAddNewVitals = new javax.swing.JButton();
        cardPatient = new javax.swing.JPanel();
        WelcomePatientJPanel = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        PatientSearchHospJPanel1 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblHospList1 = new javax.swing.JTable();
        jLabel22 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblDoctorList1 = new javax.swing.JTable();
        btnSelectHospital1 = new javax.swing.JButton();
        PatientViewEncounterHistoryJPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblEncounterHistory = new javax.swing.JTable();
        PatientAddVitalsJPanel = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        txtTemperature = new javax.swing.JTextField();
        txtPulse = new javax.swing.JTextField();
        txtBloodPressure = new javax.swing.JTextField();
        txtAptDate = new javax.swing.JTextField();
        btnRecordVitals = new javax.swing.JButton();
        DoctorMainJPanel = new javax.swing.JPanel();
        doctorSplitPane = new javax.swing.JSplitPane();
        doctorNavPanel = new javax.swing.JPanel();
        btnDiagnosePatients = new javax.swing.JButton();
        cardDoctor = new javax.swing.JPanel();
        WelcomeDoctorJPanel = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        DiagnosePatientJPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPatientList = new javax.swing.JTable();
        btnViewRecentVitals = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        lblTemperature = new javax.swing.JLabel();
        lblPulse = new javax.swing.JLabel();
        lblBloodPressure = new javax.swing.JLabel();
        txtDiagnosis = new javax.swing.JTextField();
        btnSubmitDiagnosis = new javax.swing.JButton();
        HospAdminMainJPanel = new javax.swing.JPanel();
        hospAdminSplitPane = new javax.swing.JSplitPane();
        hospAdminNavPanel = new javax.swing.JPanel();
        btnManageDoctors = new javax.swing.JButton();
        btnManagePatients = new javax.swing.JButton();
        cardHospAdmin = new javax.swing.JPanel();
        WelcomeHospAdminJPanel = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        HospAdminManageDoctorJPanel = new javax.swing.JPanel();
        hospAdminManageDoctorSplitPane = new javax.swing.JSplitPane();
        hospAdminManageDoctorNavPaneL = new javax.swing.JPanel();
        btnRegisterDoctor = new javax.swing.JButton();
        cardHospAdminManageDoctor = new javax.swing.JPanel();
        WelcomeHospAdminManageDoctorJPanel = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        HospAdminAddDoctorJPanel = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        txtDoctorFullName = new javax.swing.JTextField();
        txtDoctorUsername = new javax.swing.JTextField();
        txtDoctorPassword = new javax.swing.JTextField();
        txtDoctorDob = new javax.swing.JTextField();
        txtDoctorAge = new javax.swing.JTextField();
        txtDoctorStreetName = new javax.swing.JTextField();
        txtDoctorAptNo = new javax.swing.JTextField();
        txtDoctorCityName = new javax.swing.JTextField();
        txtDoctorState = new javax.swing.JTextField();
        txtDoctorZipcode = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        btnAddDoctor = new javax.swing.JButton();
        ddDoctorGender = new javax.swing.JComboBox<>();
        ddDoctorCommName = new javax.swing.JComboBox<>();
        jLabel44 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        txtDoctorHospId = new javax.swing.JTextField();
        HospAdminManagePatientJPanel = new javax.swing.JPanel();
        hospAdminManagePatientSplitPane = new javax.swing.JSplitPane();
        hospAdminManagePatientNavPanel = new javax.swing.JPanel();
        btnRegisterPatient = new javax.swing.JButton();
        cardHospAdminManagePatient = new javax.swing.JPanel();
        WelcomeHospAdminManagePatientJPanel = new javax.swing.JPanel();
        jLabel47 = new javax.swing.JLabel();
        HospAdminAddPatientJPanel = new javax.swing.JPanel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        txtPatientFullName = new javax.swing.JTextField();
        txtPatientUsername = new javax.swing.JTextField();
        txtPatientPassword = new javax.swing.JTextField();
        txtPatientDob = new javax.swing.JTextField();
        txtPatientAge = new javax.swing.JTextField();
        txtPatientStreetName = new javax.swing.JTextField();
        txtPatientAptNo = new javax.swing.JTextField();
        txtPatientCityName = new javax.swing.JTextField();
        txtPatientState = new javax.swing.JTextField();
        txtPatientZipcode = new javax.swing.JTextField();
        jLabel59 = new javax.swing.JLabel();
        btnAddPatient = new javax.swing.JButton();
        ddPatientGender = new javax.swing.JComboBox<>();
        ddPatientCommName = new javax.swing.JComboBox<>();
        jLabel60 = new javax.swing.JLabel();
        SystemAdminMainJPanel = new javax.swing.JPanel();
        CommAdminMainJPanel = new javax.swing.JPanel();
        commAdminSplitPane = new javax.swing.JSplitPane();
        commAdminNavPanel = new javax.swing.JPanel();
        btnManageHospitals = new javax.swing.JButton();
        btnManageCommunity = new javax.swing.JButton();
        cardCommAdmin = new javax.swing.JPanel();
        CommAdminManageCommunityJPanel = new javax.swing.JPanel();
        commAdminManageCommunitySplitPane = new javax.swing.JSplitPane();
        commAdminManageCommunityNavPanel = new javax.swing.JPanel();
        btnRegisterCommunity = new javax.swing.JButton();
        cardCommAdminManageCommunity = new javax.swing.JPanel();
        WelcomeCommAdminManageCommunityJPanel = new javax.swing.JPanel();
        jLabel77 = new javax.swing.JLabel();
        CommAdminAddCommunityJPanel = new javax.swing.JPanel();
        jLabel78 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        txtCommAdminCommName1 = new javax.swing.JTextField();
        txtCommAdminCityName = new javax.swing.JTextField();
        jLabel89 = new javax.swing.JLabel();
        btnAddCommunity = new javax.swing.JButton();
        WelcomeCommAdminJPanel = new javax.swing.JPanel();
        jLabel61 = new javax.swing.JLabel();
        CommAdminManageHospitalsJPanel = new javax.swing.JPanel();
        commAdminManageHospitalsSplitPane = new javax.swing.JSplitPane();
        commAdminManageHospitalsNavPanel = new javax.swing.JPanel();
        btnRegisterHospital = new javax.swing.JButton();
        cardCommAdminManageHospitals = new javax.swing.JPanel();
        WelcomeCommAdminManageHospitalsJPanel = new javax.swing.JPanel();
        jLabel91 = new javax.swing.JLabel();
        CommAdminAddHospitalJPanel = new javax.swing.JPanel();
        jLabel92 = new javax.swing.JLabel();
        jLabel93 = new javax.swing.JLabel();
        jLabel94 = new javax.swing.JLabel();
        txtCommAdminHospID = new javax.swing.JTextField();
        txtCommAdminHospName = new javax.swing.JTextField();
        txtCommAdminCommName = new javax.swing.JTextField();
        jLabel103 = new javax.swing.JLabel();
        btnAddHospital = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(181, 212, 243));

        mainSplitFrame.setDividerLocation(215);

        navPanel.setBackground(new java.awt.Color(181, 212, 243));
        navPanel.setPreferredSize(new java.awt.Dimension(215, 1223));

        btnLogout.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        btnLogout.setText("Logout");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        btnLoginAfterSignUp.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        btnLoginAfterSignUp.setText("Navigate to Login Page");
        btnLoginAfterSignUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginAfterSignUpActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout navPanelLayout = new javax.swing.GroupLayout(navPanel);
        navPanel.setLayout(navPanelLayout);
        navPanelLayout.setHorizontalGroup(
            navPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navPanelLayout.createSequentialGroup()
                .addGroup(navPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(navPanelLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(btnLoginAfterSignUp))
                    .addGroup(navPanelLayout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(btnLogout)))
                .addContainerGap())
        );
        navPanelLayout.setVerticalGroup(
            navPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navPanelLayout.createSequentialGroup()
                .addGap(211, 211, 211)
                .addComponent(btnLogout)
                .addGap(18, 18, 18)
                .addComponent(btnLoginAfterSignUp)
                .addContainerGap(969, Short.MAX_VALUE))
        );

        mainSplitFrame.setLeftComponent(navPanel);

        card.setBackground(new java.awt.Color(181, 212, 243));
        card.setLayout(new java.awt.CardLayout());

        mainRightPanel.setBackground(new java.awt.Color(181, 212, 243));

        jLabel1.setText("Username");
        jLabel1.setPreferredSize(new java.awt.Dimension(115, 17));

        jLabel2.setText("Password");
        jLabel2.setPreferredSize(new java.awt.Dimension(115, 17));

        txtUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsernameActionPerformed(evt);
            }
        });

        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });

        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        btnSignUp.setText("New patient? Sign up here!");
        btnSignUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignUpActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Welcome!");

        javax.swing.GroupLayout mainRightPanelLayout = new javax.swing.GroupLayout(mainRightPanel);
        mainRightPanel.setLayout(mainRightPanelLayout);
        mainRightPanelLayout.setHorizontalGroup(
            mainRightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainRightPanelLayout.createSequentialGroup()
                .addGroup(mainRightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainRightPanelLayout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addGroup(mainRightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(mainRightPanelLayout.createSequentialGroup()
                                .addGroup(mainRightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(115, 115, 115)
                                .addGroup(mainRightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                                    .addComponent(txtUsername)))
                            .addComponent(btnSignUp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(mainRightPanelLayout.createSequentialGroup()
                        .addGap(197, 197, 197)
                        .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(1352, Short.MAX_VALUE))
        );
        mainRightPanelLayout.setVerticalGroup(
            mainRightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainRightPanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel3)
                .addGap(34, 34, 34)
                .addGroup(mainRightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(mainRightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnLogin)
                .addGap(18, 18, 18)
                .addComponent(btnSignUp)
                .addContainerGap(1015, Short.MAX_VALUE))
        );

        card.add(mainRightPanel, "card7");

        PatientSignUpJPanel.setBackground(new java.awt.Color(181, 212, 243));

        jLabel4.setText("Full Name");

        jLabel5.setText("Username");

        jLabel6.setText("Password");

        jLabel7.setText("Date of Birth");

        jLabel8.setText("Age");

        jLabel9.setText("Gender");

        jLabel10.setText("Street name");

        jLabel11.setText("Apt No");

        jLabel12.setText("City Name");

        jLabel13.setText("State");

        jLabel14.setText("Zip Code");

        txtZipcode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtZipcodeActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel15.setText("Please register by entering the following details");

        btnSignUpPatient.setText("Sign Up");
        btnSignUpPatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignUpPatientActionPerformed(evt);
            }
        });

        ddGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female", "Other" }));

        ddCommName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Allston", "Back Bay", "Beacon Hill" }));
        ddCommName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ddCommNameActionPerformed(evt);
            }
        });

        jLabel20.setText("Community Name");

        javax.swing.GroupLayout PatientSignUpJPanelLayout = new javax.swing.GroupLayout(PatientSignUpJPanel);
        PatientSignUpJPanel.setLayout(PatientSignUpJPanelLayout);
        PatientSignUpJPanelLayout.setHorizontalGroup(
            PatientSignUpJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PatientSignUpJPanelLayout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addGroup(PatientSignUpJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSignUpPatient)
                    .addGroup(PatientSignUpJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PatientSignUpJPanelLayout.createSequentialGroup()
                            .addGroup(PatientSignUpJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addComponent(jLabel5)
                                .addComponent(jLabel6)
                                .addComponent(jLabel7)
                                .addComponent(jLabel8)
                                .addComponent(jLabel9)
                                .addComponent(jLabel10)
                                .addComponent(jLabel11)
                                .addComponent(jLabel12)
                                .addComponent(jLabel13)
                                .addComponent(jLabel14)
                                .addComponent(jLabel20))
                            .addGap(86, 86, 86)
                            .addGroup(PatientSignUpJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtState, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtCityName, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(ddCommName, javax.swing.GroupLayout.Alignment.LEADING, 0, 218, Short.MAX_VALUE)
                                .addComponent(txtAptNo, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtStreetName, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(ddGender, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtAge, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtDob, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtPasswordPatient, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtUsernamePatient, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtFullName)
                                .addComponent(txtZipcode)))
                        .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.LEADING)))
                .addContainerGap(1285, Short.MAX_VALUE))
        );
        PatientSignUpJPanelLayout.setVerticalGroup(
            PatientSignUpJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PatientSignUpJPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel15)
                .addGap(18, 18, 18)
                .addGroup(PatientSignUpJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtFullName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PatientSignUpJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtUsernamePatient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PatientSignUpJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtPasswordPatient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PatientSignUpJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtDob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PatientSignUpJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PatientSignUpJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(ddGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PatientSignUpJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtStreetName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PatientSignUpJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtAptNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PatientSignUpJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ddCommName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addGap(18, 18, 18)
                .addGroup(PatientSignUpJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtCityName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PatientSignUpJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtState, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PatientSignUpJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtZipcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnSignUpPatient)
                .addContainerGap(672, Short.MAX_VALUE))
        );

        card.add(PatientSignUpJPanel, "card8");

        PatientMainJPanel.setBackground(new java.awt.Color(181, 212, 243));
        PatientMainJPanel.setPreferredSize(new java.awt.Dimension(1250, 1200));

        splitPane.setBackground(new java.awt.Color(181, 212, 243));
        splitPane.setDividerLocation(215);

        PatientNavPanel.setBackground(new java.awt.Color(181, 212, 243));
        PatientNavPanel.setPreferredSize(new java.awt.Dimension(215, 1222));

        btnSearchHosp.setText("Search Hospitals/Doctors");
        btnSearchHosp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchHospActionPerformed(evt);
            }
        });

        btnEncounterHistory.setText("View Previous Encounters");
        btnEncounterHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEncounterHistoryActionPerformed(evt);
            }
        });

        btnAddNewVitals.setText("Add New Vitals");
        btnAddNewVitals.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddNewVitalsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PatientNavPanelLayout = new javax.swing.GroupLayout(PatientNavPanel);
        PatientNavPanel.setLayout(PatientNavPanelLayout);
        PatientNavPanelLayout.setHorizontalGroup(
            PatientNavPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PatientNavPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PatientNavPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnSearchHosp)
                    .addComponent(btnEncounterHistory)
                    .addComponent(btnAddNewVitals))
                .addGap(17, 17, 17))
        );

        PatientNavPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAddNewVitals, btnEncounterHistory, btnSearchHosp});

        PatientNavPanelLayout.setVerticalGroup(
            PatientNavPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PatientNavPanelLayout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(btnSearchHosp)
                .addGap(40, 40, 40)
                .addComponent(btnEncounterHistory)
                .addGap(41, 41, 41)
                .addComponent(btnAddNewVitals)
                .addContainerGap(972, Short.MAX_VALUE))
        );

        splitPane.setLeftComponent(PatientNavPanel);

        cardPatient.setBackground(new java.awt.Color(181, 212, 243));
        cardPatient.setLayout(new java.awt.CardLayout());

        WelcomePatientJPanel.setBackground(new java.awt.Color(181, 212, 243));

        jLabel16.setFont(new java.awt.Font("Helvetica Neue", 1, 48)); // NOI18N
        jLabel16.setText("Welcome");

        javax.swing.GroupLayout WelcomePatientJPanelLayout = new javax.swing.GroupLayout(WelcomePatientJPanel);
        WelcomePatientJPanel.setLayout(WelcomePatientJPanelLayout);
        WelcomePatientJPanelLayout.setHorizontalGroup(
            WelcomePatientJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(WelcomePatientJPanelLayout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1148, Short.MAX_VALUE))
        );
        WelcomePatientJPanelLayout.setVerticalGroup(
            WelcomePatientJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(WelcomePatientJPanelLayout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1054, Short.MAX_VALUE))
        );

        cardPatient.add(WelcomePatientJPanel, "card3");

        PatientSearchHospJPanel1.setBackground(new java.awt.Color(181, 212, 243));
        PatientSearchHospJPanel1.setPreferredSize(new java.awt.Dimension(1250, 1200));

        jLabel21.setText("Here is the list of hospitals that are in your community");

        tblHospList1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Names"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblHospList1.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tblHospList1);

        jLabel22.setText("Here is the list of doctors that are in your chosen hospital");

        tblDoctorList1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Names", "Gender"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDoctorList1.setColumnSelectionAllowed(true);
        tblDoctorList1.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(tblDoctorList1);
        tblDoctorList1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        btnSelectHospital1.setText("Select Hospital");
        btnSelectHospital1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectHospital1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PatientSearchHospJPanel1Layout = new javax.swing.GroupLayout(PatientSearchHospJPanel1);
        PatientSearchHospJPanel1.setLayout(PatientSearchHospJPanel1Layout);
        PatientSearchHospJPanel1Layout.setHorizontalGroup(
            PatientSearchHospJPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PatientSearchHospJPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(PatientSearchHospJPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSelectHospital1)
                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel21)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(1181, Short.MAX_VALUE))
        );
        PatientSearchHospJPanel1Layout.setVerticalGroup(
            PatientSearchHospJPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PatientSearchHospJPanel1Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel21)
                .addGap(20, 20, 20)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btnSelectHospital1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel22)
                .addGap(20, 20, 20)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(783, Short.MAX_VALUE))
        );

        cardPatient.add(PatientSearchHospJPanel1, "card9");

        tblEncounterHistory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Date", "Temperature", "Pulse", "Blood Pressure", "Diagnosis"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblEncounterHistory);

        javax.swing.GroupLayout PatientViewEncounterHistoryJPanelLayout = new javax.swing.GroupLayout(PatientViewEncounterHistoryJPanel);
        PatientViewEncounterHistoryJPanel.setLayout(PatientViewEncounterHistoryJPanelLayout);
        PatientViewEncounterHistoryJPanelLayout.setHorizontalGroup(
            PatientViewEncounterHistoryJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PatientViewEncounterHistoryJPanelLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1065, Short.MAX_VALUE))
        );
        PatientViewEncounterHistoryJPanelLayout.setVerticalGroup(
            PatientViewEncounterHistoryJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PatientViewEncounterHistoryJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1047, Short.MAX_VALUE))
        );

        cardPatient.add(PatientViewEncounterHistoryJPanel, "card5");

        PatientAddVitalsJPanel.setBackground(new java.awt.Color(181, 212, 243));

        jLabel17.setBackground(new java.awt.Color(181, 212, 243));
        jLabel17.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel17.setText("Please add the following details to record your vitals");

        jLabel18.setText("Temperature");

        jLabel19.setText("Pulse");

        jLabel23.setText("Blood Pressure");

        jLabel24.setText("Date");

        txtTemperature.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTemperatureActionPerformed(evt);
            }
        });

        txtPulse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPulseActionPerformed(evt);
            }
        });

        btnRecordVitals.setFont(new java.awt.Font("Helvetica Neue", 1, 15)); // NOI18N
        btnRecordVitals.setText("Record Vitals");
        btnRecordVitals.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecordVitalsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PatientAddVitalsJPanelLayout = new javax.swing.GroupLayout(PatientAddVitalsJPanel);
        PatientAddVitalsJPanel.setLayout(PatientAddVitalsJPanelLayout);
        PatientAddVitalsJPanelLayout.setHorizontalGroup(
            PatientAddVitalsJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PatientAddVitalsJPanelLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(PatientAddVitalsJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnRecordVitals)
                    .addGroup(PatientAddVitalsJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(PatientAddVitalsJPanelLayout.createSequentialGroup()
                            .addComponent(jLabel24)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtAptDate, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(PatientAddVitalsJPanelLayout.createSequentialGroup()
                            .addComponent(jLabel23)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtBloodPressure, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(PatientAddVitalsJPanelLayout.createSequentialGroup()
                            .addComponent(jLabel19)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtPulse, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(PatientAddVitalsJPanelLayout.createSequentialGroup()
                            .addComponent(jLabel18)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtTemperature, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel17)))
                .addContainerGap(1058, Short.MAX_VALUE))
        );

        PatientAddVitalsJPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel18, jLabel19, jLabel23, jLabel24});

        PatientAddVitalsJPanelLayout.setVerticalGroup(
            PatientAddVitalsJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PatientAddVitalsJPanelLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel17)
                .addGap(18, 18, 18)
                .addGroup(PatientAddVitalsJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTemperature, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addGap(18, 18, 18)
                .addGroup(PatientAddVitalsJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(txtPulse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PatientAddVitalsJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(txtBloodPressure, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PatientAddVitalsJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(txtAptDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnRecordVitals)
                .addContainerGap(968, Short.MAX_VALUE))
        );

        cardPatient.add(PatientAddVitalsJPanel, "card4");

        splitPane.setRightComponent(cardPatient);

        javax.swing.GroupLayout PatientMainJPanelLayout = new javax.swing.GroupLayout(PatientMainJPanel);
        PatientMainJPanel.setLayout(PatientMainJPanelLayout);
        PatientMainJPanelLayout.setHorizontalGroup(
            PatientMainJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PatientMainJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(splitPane)
                .addContainerGap())
        );
        PatientMainJPanelLayout.setVerticalGroup(
            PatientMainJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PatientMainJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(splitPane, javax.swing.GroupLayout.PREFERRED_SIZE, 1222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        card.add(PatientMainJPanel, "card10");

        DoctorMainJPanel.setBackground(new java.awt.Color(181, 212, 243));

        doctorSplitPane.setBackground(new java.awt.Color(181, 212, 243));
        doctorSplitPane.setDividerLocation(215);

        doctorNavPanel.setBackground(new java.awt.Color(181, 212, 243));

        btnDiagnosePatients.setFont(new java.awt.Font("Helvetica Neue", 1, 15)); // NOI18N
        btnDiagnosePatients.setText("Diagnose Patients");
        btnDiagnosePatients.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDiagnosePatientsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout doctorNavPanelLayout = new javax.swing.GroupLayout(doctorNavPanel);
        doctorNavPanel.setLayout(doctorNavPanelLayout);
        doctorNavPanelLayout.setHorizontalGroup(
            doctorNavPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(doctorNavPanelLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(btnDiagnosePatients)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        doctorNavPanelLayout.setVerticalGroup(
            doctorNavPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(doctorNavPanelLayout.createSequentialGroup()
                .addGap(193, 193, 193)
                .addComponent(btnDiagnosePatients)
                .addContainerGap(1016, Short.MAX_VALUE))
        );

        doctorSplitPane.setLeftComponent(doctorNavPanel);

        cardDoctor.setBackground(new java.awt.Color(181, 212, 243));
        cardDoctor.setLayout(new java.awt.CardLayout());

        WelcomeDoctorJPanel.setBackground(new java.awt.Color(181, 212, 243));

        jLabel25.setFont(new java.awt.Font("Helvetica Neue", 1, 48)); // NOI18N
        jLabel25.setText("Welcome");

        javax.swing.GroupLayout WelcomeDoctorJPanelLayout = new javax.swing.GroupLayout(WelcomeDoctorJPanel);
        WelcomeDoctorJPanel.setLayout(WelcomeDoctorJPanelLayout);
        WelcomeDoctorJPanelLayout.setHorizontalGroup(
            WelcomeDoctorJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(WelcomeDoctorJPanelLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel25)
                .addContainerGap(1284, Short.MAX_VALUE))
        );
        WelcomeDoctorJPanelLayout.setVerticalGroup(
            WelcomeDoctorJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(WelcomeDoctorJPanelLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel25)
                .addContainerGap(1140, Short.MAX_VALUE))
        );

        cardDoctor.add(WelcomeDoctorJPanel, "card2");

        DiagnosePatientJPanel.setBackground(new java.awt.Color(181, 212, 243));

        tblPatientList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Patient Id", "Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblPatientList);

        btnViewRecentVitals.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        btnViewRecentVitals.setText("View Recent Vitals");
        btnViewRecentVitals.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewRecentVitalsActionPerformed(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jLabel26.setText("Select a patient to view their vitals and provide a diagnosis");

        jLabel27.setText("Temperature");

        jLabel28.setText("Pulse");

        jLabel29.setText("Blood Pressure");

        jLabel30.setText("Diagnosis");

        btnSubmitDiagnosis.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        btnSubmitDiagnosis.setText("Submit Diagnosis");
        btnSubmitDiagnosis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitDiagnosisActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout DiagnosePatientJPanelLayout = new javax.swing.GroupLayout(DiagnosePatientJPanel);
        DiagnosePatientJPanel.setLayout(DiagnosePatientJPanelLayout);
        DiagnosePatientJPanelLayout.setHorizontalGroup(
            DiagnosePatientJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DiagnosePatientJPanelLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(DiagnosePatientJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel26)
                    .addGroup(DiagnosePatientJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(DiagnosePatientJPanelLayout.createSequentialGroup()
                            .addComponent(btnViewRecentVitals)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSubmitDiagnosis))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(DiagnosePatientJPanelLayout.createSequentialGroup()
                            .addGroup(DiagnosePatientJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel27)
                                .addComponent(jLabel28)
                                .addComponent(jLabel29)
                                .addComponent(jLabel30))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(DiagnosePatientJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtDiagnosis)
                                .addComponent(lblTemperature, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblPulse, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                                .addComponent(lblBloodPressure, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)))))
                .addContainerGap(1062, Short.MAX_VALUE))
        );

        DiagnosePatientJPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel27, jLabel28, jLabel29, jLabel30});

        DiagnosePatientJPanelLayout.setVerticalGroup(
            DiagnosePatientJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DiagnosePatientJPanelLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel26)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(DiagnosePatientJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnViewRecentVitals)
                    .addComponent(btnSubmitDiagnosis))
                .addGap(18, 18, 18)
                .addGroup(DiagnosePatientJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(lblTemperature))
                .addGap(18, 18, 18)
                .addGroup(DiagnosePatientJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(lblPulse))
                .addGap(18, 18, 18)
                .addGroup(DiagnosePatientJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(lblBloodPressure))
                .addGap(18, 18, 18)
                .addGroup(DiagnosePatientJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(txtDiagnosis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(835, Short.MAX_VALUE))
        );

        DiagnosePatientJPanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel27, jLabel28, jLabel29, jLabel30, lblBloodPressure, lblPulse, lblTemperature});

        cardDoctor.add(DiagnosePatientJPanel, "card3");

        doctorSplitPane.setRightComponent(cardDoctor);

        javax.swing.GroupLayout DoctorMainJPanelLayout = new javax.swing.GroupLayout(DoctorMainJPanel);
        DoctorMainJPanel.setLayout(DoctorMainJPanelLayout);
        DoctorMainJPanelLayout.setHorizontalGroup(
            DoctorMainJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DoctorMainJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(doctorSplitPane)
                .addContainerGap())
        );
        DoctorMainJPanelLayout.setVerticalGroup(
            DoctorMainJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DoctorMainJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(doctorSplitPane)
                .addContainerGap())
        );

        card.add(DoctorMainJPanel, "card6");

        HospAdminMainJPanel.setBackground(new java.awt.Color(181, 212, 243));

        hospAdminSplitPane.setBackground(new java.awt.Color(181, 212, 243));
        hospAdminSplitPane.setDividerLocation(215);

        hospAdminNavPanel.setBackground(new java.awt.Color(181, 212, 243));

        btnManageDoctors.setFont(new java.awt.Font("Helvetica Neue", 0, 15)); // NOI18N
        btnManageDoctors.setText("Manage Doctors");
        btnManageDoctors.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageDoctorsActionPerformed(evt);
            }
        });

        btnManagePatients.setFont(new java.awt.Font("Helvetica Neue", 0, 15)); // NOI18N
        btnManagePatients.setText("Manage Patients");
        btnManagePatients.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManagePatientsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout hospAdminNavPanelLayout = new javax.swing.GroupLayout(hospAdminNavPanel);
        hospAdminNavPanel.setLayout(hospAdminNavPanelLayout);
        hospAdminNavPanelLayout.setHorizontalGroup(
            hospAdminNavPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hospAdminNavPanelLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(hospAdminNavPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnManagePatients)
                    .addComponent(btnManageDoctors))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        hospAdminNavPanelLayout.setVerticalGroup(
            hospAdminNavPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hospAdminNavPanelLayout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(btnManageDoctors)
                .addGap(18, 18, 18)
                .addComponent(btnManagePatients)
                .addContainerGap(1076, Short.MAX_VALUE))
        );

        hospAdminSplitPane.setLeftComponent(hospAdminNavPanel);

        cardHospAdmin.setBackground(new java.awt.Color(181, 212, 243));
        cardHospAdmin.setLayout(new java.awt.CardLayout());

        WelcomeHospAdminJPanel.setBackground(new java.awt.Color(181, 212, 243));

        jLabel31.setFont(new java.awt.Font("Helvetica Neue", 1, 48)); // NOI18N
        jLabel31.setText("Welcome!");

        javax.swing.GroupLayout WelcomeHospAdminJPanelLayout = new javax.swing.GroupLayout(WelcomeHospAdminJPanel);
        WelcomeHospAdminJPanel.setLayout(WelcomeHospAdminJPanelLayout);
        WelcomeHospAdminJPanelLayout.setHorizontalGroup(
            WelcomeHospAdminJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(WelcomeHospAdminJPanelLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jLabel31)
                .addContainerGap(1269, Short.MAX_VALUE))
        );
        WelcomeHospAdminJPanelLayout.setVerticalGroup(
            WelcomeHospAdminJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(WelcomeHospAdminJPanelLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel31)
                .addContainerGap(1124, Short.MAX_VALUE))
        );

        cardHospAdmin.add(WelcomeHospAdminJPanel, "card2");

        HospAdminManageDoctorJPanel.setBackground(new java.awt.Color(181, 212, 243));

        hospAdminManageDoctorSplitPane.setDividerLocation(215);

        btnRegisterDoctor.setText("Register A New Doctor");
        btnRegisterDoctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterDoctorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout hospAdminManageDoctorNavPaneLLayout = new javax.swing.GroupLayout(hospAdminManageDoctorNavPaneL);
        hospAdminManageDoctorNavPaneL.setLayout(hospAdminManageDoctorNavPaneLLayout);
        hospAdminManageDoctorNavPaneLLayout.setHorizontalGroup(
            hospAdminManageDoctorNavPaneLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hospAdminManageDoctorNavPaneLLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(btnRegisterDoctor)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        hospAdminManageDoctorNavPaneLLayout.setVerticalGroup(
            hospAdminManageDoctorNavPaneLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hospAdminManageDoctorNavPaneLLayout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(btnRegisterDoctor)
                .addContainerGap(1120, Short.MAX_VALUE))
        );

        hospAdminManageDoctorSplitPane.setLeftComponent(hospAdminManageDoctorNavPaneL);

        cardHospAdminManageDoctor.setLayout(new java.awt.CardLayout());

        jLabel45.setFont(new java.awt.Font("Helvetica Neue", 1, 48)); // NOI18N
        jLabel45.setText("Welcome!");

        javax.swing.GroupLayout WelcomeHospAdminManageDoctorJPanelLayout = new javax.swing.GroupLayout(WelcomeHospAdminManageDoctorJPanel);
        WelcomeHospAdminManageDoctorJPanel.setLayout(WelcomeHospAdminManageDoctorJPanelLayout);
        WelcomeHospAdminManageDoctorJPanelLayout.setHorizontalGroup(
            WelcomeHospAdminManageDoctorJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(WelcomeHospAdminManageDoctorJPanelLayout.createSequentialGroup()
                .addGap(143, 143, 143)
                .addComponent(jLabel45)
                .addContainerGap(953, Short.MAX_VALUE))
        );
        WelcomeHospAdminManageDoctorJPanelLayout.setVerticalGroup(
            WelcomeHospAdminManageDoctorJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(WelcomeHospAdminManageDoctorJPanelLayout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(jLabel45)
                .addContainerGap(1097, Short.MAX_VALUE))
        );

        cardHospAdminManageDoctor.add(WelcomeHospAdminManageDoctorJPanel, "card3");

        HospAdminAddDoctorJPanel.setBackground(new java.awt.Color(181, 212, 243));

        jLabel32.setText("Full Name");

        jLabel33.setText("Username");

        jLabel34.setText("Password");

        jLabel35.setText("Date of Birth");

        jLabel36.setText("Age");

        jLabel37.setText("Gender");

        jLabel38.setText("Street name");

        jLabel39.setText("Apt No");

        jLabel40.setText("City Name");

        jLabel41.setText("State");

        jLabel42.setText("Zip Code");

        txtDoctorZipcode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDoctorZipcodeActionPerformed(evt);
            }
        });

        jLabel43.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel43.setText("Please register by entering the following details");

        btnAddDoctor.setText("Add Doctor");
        btnAddDoctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddDoctorActionPerformed(evt);
            }
        });

        ddDoctorGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female", "Other" }));

        ddDoctorCommName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Allston", "Back Bay", "Beacon Hill" }));

        jLabel44.setText("Community Name");

        jLabel46.setText("Hospital Id");

        txtDoctorHospId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDoctorHospIdActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout HospAdminAddDoctorJPanelLayout = new javax.swing.GroupLayout(HospAdminAddDoctorJPanel);
        HospAdminAddDoctorJPanel.setLayout(HospAdminAddDoctorJPanelLayout);
        HospAdminAddDoctorJPanelLayout.setHorizontalGroup(
            HospAdminAddDoctorJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HospAdminAddDoctorJPanelLayout.createSequentialGroup()
                .addGap(139, 139, 139)
                .addGroup(HospAdminAddDoctorJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAddDoctor)
                    .addGroup(HospAdminAddDoctorJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, HospAdminAddDoctorJPanelLayout.createSequentialGroup()
                            .addGroup(HospAdminAddDoctorJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel32)
                                .addComponent(jLabel33)
                                .addComponent(jLabel34)
                                .addComponent(jLabel35)
                                .addComponent(jLabel36)
                                .addComponent(jLabel37)
                                .addComponent(jLabel38)
                                .addComponent(jLabel39)
                                .addComponent(jLabel40)
                                .addComponent(jLabel41)
                                .addComponent(jLabel42)
                                .addComponent(jLabel44)
                                .addComponent(jLabel46))
                            .addGap(86, 86, 86)
                            .addGroup(HospAdminAddDoctorJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtDoctorState, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtDoctorCityName, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(ddDoctorCommName, javax.swing.GroupLayout.Alignment.LEADING, 0, 218, Short.MAX_VALUE)
                                .addComponent(txtDoctorAptNo, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtDoctorStreetName, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(ddDoctorGender, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtDoctorAge, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtDoctorDob, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtDoctorPassword, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtDoctorUsername, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtDoctorFullName)
                                .addComponent(txtDoctorZipcode)
                                .addComponent(txtDoctorHospId, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addComponent(jLabel43, javax.swing.GroupLayout.Alignment.LEADING)))
                .addContainerGap(775, Short.MAX_VALUE))
        );
        HospAdminAddDoctorJPanelLayout.setVerticalGroup(
            HospAdminAddDoctorJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HospAdminAddDoctorJPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel43)
                .addGap(18, 18, 18)
                .addGroup(HospAdminAddDoctorJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(txtDoctorFullName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(HospAdminAddDoctorJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(txtDoctorUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(HospAdminAddDoctorJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(txtDoctorPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(HospAdminAddDoctorJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(txtDoctorDob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(HospAdminAddDoctorJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(txtDoctorAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(HospAdminAddDoctorJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37)
                    .addComponent(ddDoctorGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(HospAdminAddDoctorJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(txtDoctorStreetName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(HospAdminAddDoctorJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39)
                    .addComponent(txtDoctorAptNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(HospAdminAddDoctorJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ddDoctorCommName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel44))
                .addGap(18, 18, 18)
                .addGroup(HospAdminAddDoctorJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40)
                    .addComponent(txtDoctorCityName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(HospAdminAddDoctorJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41)
                    .addComponent(txtDoctorState, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(HospAdminAddDoctorJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel42)
                    .addComponent(txtDoctorZipcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(HospAdminAddDoctorJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel46)
                    .addComponent(txtDoctorHospId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnAddDoctor)
                .addContainerGap(619, Short.MAX_VALUE))
        );

        cardHospAdminManageDoctor.add(HospAdminAddDoctorJPanel, "card8");

        hospAdminManageDoctorSplitPane.setRightComponent(cardHospAdminManageDoctor);

        javax.swing.GroupLayout HospAdminManageDoctorJPanelLayout = new javax.swing.GroupLayout(HospAdminManageDoctorJPanel);
        HospAdminManageDoctorJPanel.setLayout(HospAdminManageDoctorJPanelLayout);
        HospAdminManageDoctorJPanelLayout.setHorizontalGroup(
            HospAdminManageDoctorJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HospAdminManageDoctorJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(hospAdminManageDoctorSplitPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1542, Short.MAX_VALUE))
        );
        HospAdminManageDoctorJPanelLayout.setVerticalGroup(
            HospAdminManageDoctorJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(hospAdminManageDoctorSplitPane)
        );

        cardHospAdmin.add(HospAdminManageDoctorJPanel, "card3");

        HospAdminManagePatientJPanel.setBackground(new java.awt.Color(181, 212, 243));

        hospAdminManagePatientSplitPane.setDividerLocation(215);

        btnRegisterPatient.setText("Register A New Patient");
        btnRegisterPatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterPatientActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout hospAdminManagePatientNavPanelLayout = new javax.swing.GroupLayout(hospAdminManagePatientNavPanel);
        hospAdminManagePatientNavPanel.setLayout(hospAdminManagePatientNavPanelLayout);
        hospAdminManagePatientNavPanelLayout.setHorizontalGroup(
            hospAdminManagePatientNavPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hospAdminManagePatientNavPanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(btnRegisterPatient)
                .addContainerGap(37, Short.MAX_VALUE))
        );
        hospAdminManagePatientNavPanelLayout.setVerticalGroup(
            hospAdminManagePatientNavPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hospAdminManagePatientNavPanelLayout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(btnRegisterPatient)
                .addContainerGap(1120, Short.MAX_VALUE))
        );

        hospAdminManagePatientSplitPane.setLeftComponent(hospAdminManagePatientNavPanel);

        cardHospAdminManagePatient.setLayout(new java.awt.CardLayout());

        jLabel47.setFont(new java.awt.Font("Helvetica Neue", 1, 48)); // NOI18N
        jLabel47.setText("Welcome!");

        javax.swing.GroupLayout WelcomeHospAdminManagePatientJPanelLayout = new javax.swing.GroupLayout(WelcomeHospAdminManagePatientJPanel);
        WelcomeHospAdminManagePatientJPanel.setLayout(WelcomeHospAdminManagePatientJPanelLayout);
        WelcomeHospAdminManagePatientJPanelLayout.setHorizontalGroup(
            WelcomeHospAdminManagePatientJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(WelcomeHospAdminManagePatientJPanelLayout.createSequentialGroup()
                .addGap(143, 143, 143)
                .addComponent(jLabel47)
                .addContainerGap(953, Short.MAX_VALUE))
        );
        WelcomeHospAdminManagePatientJPanelLayout.setVerticalGroup(
            WelcomeHospAdminManagePatientJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(WelcomeHospAdminManagePatientJPanelLayout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(jLabel47)
                .addContainerGap(1097, Short.MAX_VALUE))
        );

        cardHospAdminManagePatient.add(WelcomeHospAdminManagePatientJPanel, "card3");

        HospAdminAddPatientJPanel.setBackground(new java.awt.Color(181, 212, 243));

        jLabel48.setText("Full Name");

        jLabel49.setText("Username");

        jLabel50.setText("Password");

        jLabel51.setText("Date of Birth");

        jLabel52.setText("Age");

        jLabel53.setText("Gender");

        jLabel54.setText("Street name");

        jLabel55.setText("Apt No");

        jLabel56.setText("City Name");

        jLabel57.setText("State");

        jLabel58.setText("Zip Code");

        txtPatientZipcode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPatientZipcodeActionPerformed(evt);
            }
        });

        jLabel59.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel59.setText("Please register by entering the following details");

        btnAddPatient.setText("Add Patient");
        btnAddPatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddPatientActionPerformed(evt);
            }
        });

        ddPatientGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female", "Other" }));

        ddPatientCommName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Allston", "Back Bay", "Beacon Hill" }));

        jLabel60.setText("Community Name");

        javax.swing.GroupLayout HospAdminAddPatientJPanelLayout = new javax.swing.GroupLayout(HospAdminAddPatientJPanel);
        HospAdminAddPatientJPanel.setLayout(HospAdminAddPatientJPanelLayout);
        HospAdminAddPatientJPanelLayout.setHorizontalGroup(
            HospAdminAddPatientJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HospAdminAddPatientJPanelLayout.createSequentialGroup()
                .addGap(139, 139, 139)
                .addGroup(HospAdminAddPatientJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAddPatient)
                    .addGroup(HospAdminAddPatientJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, HospAdminAddPatientJPanelLayout.createSequentialGroup()
                            .addGroup(HospAdminAddPatientJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel48)
                                .addComponent(jLabel49)
                                .addComponent(jLabel50)
                                .addComponent(jLabel51)
                                .addComponent(jLabel52)
                                .addComponent(jLabel53)
                                .addComponent(jLabel54)
                                .addComponent(jLabel55)
                                .addComponent(jLabel56)
                                .addComponent(jLabel57)
                                .addComponent(jLabel58)
                                .addComponent(jLabel60))
                            .addGap(86, 86, 86)
                            .addGroup(HospAdminAddPatientJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtPatientState, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtPatientCityName, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(ddPatientCommName, javax.swing.GroupLayout.Alignment.LEADING, 0, 218, Short.MAX_VALUE)
                                .addComponent(txtPatientAptNo, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtPatientStreetName, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(ddPatientGender, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtPatientAge, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtPatientDob, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtPatientPassword, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtPatientUsername, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtPatientFullName)
                                .addComponent(txtPatientZipcode)))
                        .addComponent(jLabel59, javax.swing.GroupLayout.Alignment.LEADING)))
                .addContainerGap(775, Short.MAX_VALUE))
        );
        HospAdminAddPatientJPanelLayout.setVerticalGroup(
            HospAdminAddPatientJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HospAdminAddPatientJPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel59)
                .addGap(18, 18, 18)
                .addGroup(HospAdminAddPatientJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel48)
                    .addComponent(txtPatientFullName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(HospAdminAddPatientJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel49)
                    .addComponent(txtPatientUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(HospAdminAddPatientJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel50)
                    .addComponent(txtPatientPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(HospAdminAddPatientJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel51)
                    .addComponent(txtPatientDob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(HospAdminAddPatientJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel52)
                    .addComponent(txtPatientAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(HospAdminAddPatientJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel53)
                    .addComponent(ddPatientGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(HospAdminAddPatientJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel54)
                    .addComponent(txtPatientStreetName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(HospAdminAddPatientJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel55)
                    .addComponent(txtPatientAptNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(HospAdminAddPatientJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ddPatientCommName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel60))
                .addGap(18, 18, 18)
                .addGroup(HospAdminAddPatientJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel56)
                    .addComponent(txtPatientCityName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(HospAdminAddPatientJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel57)
                    .addComponent(txtPatientState, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(HospAdminAddPatientJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel58)
                    .addComponent(txtPatientZipcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnAddPatient)
                .addContainerGap(660, Short.MAX_VALUE))
        );

        cardHospAdminManagePatient.add(HospAdminAddPatientJPanel, "card8");

        hospAdminManagePatientSplitPane.setRightComponent(cardHospAdminManagePatient);

        javax.swing.GroupLayout HospAdminManagePatientJPanelLayout = new javax.swing.GroupLayout(HospAdminManagePatientJPanel);
        HospAdminManagePatientJPanel.setLayout(HospAdminManagePatientJPanelLayout);
        HospAdminManagePatientJPanelLayout.setHorizontalGroup(
            HospAdminManagePatientJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HospAdminManagePatientJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(hospAdminManagePatientSplitPane))
        );
        HospAdminManagePatientJPanelLayout.setVerticalGroup(
            HospAdminManagePatientJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(hospAdminManagePatientSplitPane)
        );

        cardHospAdmin.add(HospAdminManagePatientJPanel, "card3");

        hospAdminSplitPane.setRightComponent(cardHospAdmin);

        javax.swing.GroupLayout HospAdminMainJPanelLayout = new javax.swing.GroupLayout(HospAdminMainJPanel);
        HospAdminMainJPanel.setLayout(HospAdminMainJPanelLayout);
        HospAdminMainJPanelLayout.setHorizontalGroup(
            HospAdminMainJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HospAdminMainJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(hospAdminSplitPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1768, Short.MAX_VALUE)
                .addContainerGap())
        );
        HospAdminMainJPanelLayout.setVerticalGroup(
            HospAdminMainJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HospAdminMainJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(hospAdminSplitPane)
                .addContainerGap())
        );

        card.add(HospAdminMainJPanel, "card4");

        SystemAdminMainJPanel.setBackground(new java.awt.Color(181, 212, 243));

        javax.swing.GroupLayout SystemAdminMainJPanelLayout = new javax.swing.GroupLayout(SystemAdminMainJPanel);
        SystemAdminMainJPanel.setLayout(SystemAdminMainJPanelLayout);
        SystemAdminMainJPanelLayout.setHorizontalGroup(
            SystemAdminMainJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1780, Short.MAX_VALUE)
        );
        SystemAdminMainJPanelLayout.setVerticalGroup(
            SystemAdminMainJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1246, Short.MAX_VALUE)
        );

        card.add(SystemAdminMainJPanel, "card3");

        CommAdminMainJPanel.setBackground(new java.awt.Color(181, 212, 243));

        commAdminSplitPane.setBackground(new java.awt.Color(181, 212, 243));
        commAdminSplitPane.setDividerLocation(215);

        commAdminNavPanel.setBackground(new java.awt.Color(181, 212, 243));

        btnManageHospitals.setFont(new java.awt.Font("Helvetica Neue", 0, 15)); // NOI18N
        btnManageHospitals.setText("Manage Hospitals");
        btnManageHospitals.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageHospitalsActionPerformed(evt);
            }
        });

        btnManageCommunity.setFont(new java.awt.Font("Helvetica Neue", 0, 15)); // NOI18N
        btnManageCommunity.setText("Manage Community");
        btnManageCommunity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageCommunityActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout commAdminNavPanelLayout = new javax.swing.GroupLayout(commAdminNavPanel);
        commAdminNavPanel.setLayout(commAdminNavPanelLayout);
        commAdminNavPanelLayout.setHorizontalGroup(
            commAdminNavPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, commAdminNavPanelLayout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(commAdminNavPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnManageCommunity)
                    .addComponent(btnManageHospitals))
                .addGap(24, 24, 24))
        );

        commAdminNavPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnManageCommunity, btnManageHospitals});

        commAdminNavPanelLayout.setVerticalGroup(
            commAdminNavPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(commAdminNavPanelLayout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(btnManageHospitals)
                .addGap(18, 18, 18)
                .addComponent(btnManageCommunity)
                .addContainerGap(1076, Short.MAX_VALUE))
        );

        commAdminSplitPane.setLeftComponent(commAdminNavPanel);

        cardCommAdmin.setBackground(new java.awt.Color(181, 212, 243));
        cardCommAdmin.setLayout(new java.awt.CardLayout());

        CommAdminManageCommunityJPanel.setBackground(new java.awt.Color(181, 212, 243));

        commAdminManageCommunitySplitPane.setBackground(new java.awt.Color(181, 212, 243));
        commAdminManageCommunitySplitPane.setDividerLocation(215);

        commAdminManageCommunityNavPanel.setBackground(new java.awt.Color(181, 212, 243));

        btnRegisterCommunity.setText("Register A New Community");
        btnRegisterCommunity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterCommunityActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout commAdminManageCommunityNavPanelLayout = new javax.swing.GroupLayout(commAdminManageCommunityNavPanel);
        commAdminManageCommunityNavPanel.setLayout(commAdminManageCommunityNavPanelLayout);
        commAdminManageCommunityNavPanelLayout.setHorizontalGroup(
            commAdminManageCommunityNavPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(commAdminManageCommunityNavPanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(btnRegisterCommunity)
                .addContainerGap(11, Short.MAX_VALUE))
        );
        commAdminManageCommunityNavPanelLayout.setVerticalGroup(
            commAdminManageCommunityNavPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(commAdminManageCommunityNavPanelLayout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(btnRegisterCommunity)
                .addContainerGap(1120, Short.MAX_VALUE))
        );

        commAdminManageCommunitySplitPane.setLeftComponent(commAdminManageCommunityNavPanel);

        cardCommAdminManageCommunity.setBackground(new java.awt.Color(181, 212, 243));
        cardCommAdminManageCommunity.setLayout(new java.awt.CardLayout());

        WelcomeCommAdminManageCommunityJPanel.setBackground(new java.awt.Color(181, 212, 243));

        jLabel77.setFont(new java.awt.Font("Helvetica Neue", 1, 48)); // NOI18N
        jLabel77.setText("Welcome!");

        javax.swing.GroupLayout WelcomeCommAdminManageCommunityJPanelLayout = new javax.swing.GroupLayout(WelcomeCommAdminManageCommunityJPanel);
        WelcomeCommAdminManageCommunityJPanel.setLayout(WelcomeCommAdminManageCommunityJPanelLayout);
        WelcomeCommAdminManageCommunityJPanelLayout.setHorizontalGroup(
            WelcomeCommAdminManageCommunityJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(WelcomeCommAdminManageCommunityJPanelLayout.createSequentialGroup()
                .addGap(143, 143, 143)
                .addComponent(jLabel77)
                .addContainerGap(953, Short.MAX_VALUE))
        );
        WelcomeCommAdminManageCommunityJPanelLayout.setVerticalGroup(
            WelcomeCommAdminManageCommunityJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(WelcomeCommAdminManageCommunityJPanelLayout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(jLabel77)
                .addContainerGap(1097, Short.MAX_VALUE))
        );

        cardCommAdminManageCommunity.add(WelcomeCommAdminManageCommunityJPanel, "card3");

        CommAdminAddCommunityJPanel.setBackground(new java.awt.Color(181, 212, 243));

        jLabel78.setText("Community Name");

        jLabel79.setText("City Name");

        jLabel89.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel89.setText("Please register by entering the following details");

        btnAddCommunity.setText("Add Community");
        btnAddCommunity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddCommunityActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout CommAdminAddCommunityJPanelLayout = new javax.swing.GroupLayout(CommAdminAddCommunityJPanel);
        CommAdminAddCommunityJPanel.setLayout(CommAdminAddCommunityJPanelLayout);
        CommAdminAddCommunityJPanelLayout.setHorizontalGroup(
            CommAdminAddCommunityJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CommAdminAddCommunityJPanelLayout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addGroup(CommAdminAddCommunityJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAddCommunity)
                    .addGroup(CommAdminAddCommunityJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, CommAdminAddCommunityJPanelLayout.createSequentialGroup()
                            .addGroup(CommAdminAddCommunityJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel78)
                                .addComponent(jLabel79))
                            .addGap(86, 86, 86)
                            .addGroup(CommAdminAddCommunityJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtCommAdminCityName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                                .addComponent(txtCommAdminCommName1)))
                        .addComponent(jLabel89, javax.swing.GroupLayout.Alignment.LEADING)))
                .addContainerGap(820, Short.MAX_VALUE))
        );
        CommAdminAddCommunityJPanelLayout.setVerticalGroup(
            CommAdminAddCommunityJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CommAdminAddCommunityJPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel89)
                .addGap(18, 18, 18)
                .addGroup(CommAdminAddCommunityJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel78)
                    .addComponent(txtCommAdminCommName1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(CommAdminAddCommunityJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel79)
                    .addComponent(txtCommAdminCityName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnAddCommunity)
                .addContainerGap(1070, Short.MAX_VALUE))
        );

        cardCommAdminManageCommunity.add(CommAdminAddCommunityJPanel, "card8");

        commAdminManageCommunitySplitPane.setRightComponent(cardCommAdminManageCommunity);

        javax.swing.GroupLayout CommAdminManageCommunityJPanelLayout = new javax.swing.GroupLayout(CommAdminManageCommunityJPanel);
        CommAdminManageCommunityJPanel.setLayout(CommAdminManageCommunityJPanelLayout);
        CommAdminManageCommunityJPanelLayout.setHorizontalGroup(
            CommAdminManageCommunityJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CommAdminManageCommunityJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(commAdminManageCommunitySplitPane))
        );
        CommAdminManageCommunityJPanelLayout.setVerticalGroup(
            CommAdminManageCommunityJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(commAdminManageCommunitySplitPane)
        );

        cardCommAdmin.add(CommAdminManageCommunityJPanel, "card3");

        WelcomeCommAdminJPanel.setBackground(new java.awt.Color(181, 212, 243));

        jLabel61.setFont(new java.awt.Font("Helvetica Neue", 1, 48)); // NOI18N
        jLabel61.setText("Welcome!");

        javax.swing.GroupLayout WelcomeCommAdminJPanelLayout = new javax.swing.GroupLayout(WelcomeCommAdminJPanel);
        WelcomeCommAdminJPanel.setLayout(WelcomeCommAdminJPanelLayout);
        WelcomeCommAdminJPanelLayout.setHorizontalGroup(
            WelcomeCommAdminJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(WelcomeCommAdminJPanelLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jLabel61)
                .addContainerGap(1269, Short.MAX_VALUE))
        );
        WelcomeCommAdminJPanelLayout.setVerticalGroup(
            WelcomeCommAdminJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(WelcomeCommAdminJPanelLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel61)
                .addContainerGap(1124, Short.MAX_VALUE))
        );

        cardCommAdmin.add(WelcomeCommAdminJPanel, "card2");

        CommAdminManageHospitalsJPanel.setBackground(new java.awt.Color(181, 212, 243));

        commAdminManageHospitalsSplitPane.setBackground(new java.awt.Color(181, 212, 243));
        commAdminManageHospitalsSplitPane.setDividerLocation(215);

        commAdminManageHospitalsNavPanel.setBackground(new java.awt.Color(181, 212, 243));

        btnRegisterHospital.setText("Register A New Hospital");
        btnRegisterHospital.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterHospitalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout commAdminManageHospitalsNavPanelLayout = new javax.swing.GroupLayout(commAdminManageHospitalsNavPanel);
        commAdminManageHospitalsNavPanel.setLayout(commAdminManageHospitalsNavPanelLayout);
        commAdminManageHospitalsNavPanelLayout.setHorizontalGroup(
            commAdminManageHospitalsNavPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, commAdminManageHospitalsNavPanelLayout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(btnRegisterHospital)
                .addGap(19, 19, 19))
        );
        commAdminManageHospitalsNavPanelLayout.setVerticalGroup(
            commAdminManageHospitalsNavPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(commAdminManageHospitalsNavPanelLayout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(btnRegisterHospital)
                .addContainerGap(1121, Short.MAX_VALUE))
        );

        commAdminManageHospitalsSplitPane.setLeftComponent(commAdminManageHospitalsNavPanel);

        cardCommAdminManageHospitals.setBackground(new java.awt.Color(181, 212, 243));
        cardCommAdminManageHospitals.setLayout(new java.awt.CardLayout());

        WelcomeCommAdminManageHospitalsJPanel.setBackground(new java.awt.Color(181, 212, 243));

        jLabel91.setFont(new java.awt.Font("Helvetica Neue", 1, 48)); // NOI18N
        jLabel91.setText("Welcome!");

        javax.swing.GroupLayout WelcomeCommAdminManageHospitalsJPanelLayout = new javax.swing.GroupLayout(WelcomeCommAdminManageHospitalsJPanel);
        WelcomeCommAdminManageHospitalsJPanel.setLayout(WelcomeCommAdminManageHospitalsJPanelLayout);
        WelcomeCommAdminManageHospitalsJPanelLayout.setHorizontalGroup(
            WelcomeCommAdminManageHospitalsJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(WelcomeCommAdminManageHospitalsJPanelLayout.createSequentialGroup()
                .addGap(143, 143, 143)
                .addComponent(jLabel91)
                .addContainerGap(953, Short.MAX_VALUE))
        );
        WelcomeCommAdminManageHospitalsJPanelLayout.setVerticalGroup(
            WelcomeCommAdminManageHospitalsJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(WelcomeCommAdminManageHospitalsJPanelLayout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(jLabel91)
                .addContainerGap(1097, Short.MAX_VALUE))
        );

        cardCommAdminManageHospitals.add(WelcomeCommAdminManageHospitalsJPanel, "card3");

        CommAdminAddHospitalJPanel.setBackground(new java.awt.Color(181, 212, 243));

        jLabel92.setText("Hospital ID");

        jLabel93.setText("Hospital Name");

        jLabel94.setText("Community Name");

        jLabel103.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel103.setText("Please register by entering the following details");

        btnAddHospital.setText("Add Hospital");
        btnAddHospital.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddHospitalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout CommAdminAddHospitalJPanelLayout = new javax.swing.GroupLayout(CommAdminAddHospitalJPanel);
        CommAdminAddHospitalJPanel.setLayout(CommAdminAddHospitalJPanelLayout);
        CommAdminAddHospitalJPanelLayout.setHorizontalGroup(
            CommAdminAddHospitalJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CommAdminAddHospitalJPanelLayout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addGroup(CommAdminAddHospitalJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAddHospital)
                    .addGroup(CommAdminAddHospitalJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, CommAdminAddHospitalJPanelLayout.createSequentialGroup()
                            .addGroup(CommAdminAddHospitalJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel92)
                                .addComponent(jLabel93)
                                .addComponent(jLabel94))
                            .addGap(86, 86, 86)
                            .addGroup(CommAdminAddHospitalJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtCommAdminCommName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                                .addComponent(txtCommAdminHospName, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtCommAdminHospID)))
                        .addComponent(jLabel103, javax.swing.GroupLayout.Alignment.LEADING)))
                .addContainerGap(820, Short.MAX_VALUE))
        );
        CommAdminAddHospitalJPanelLayout.setVerticalGroup(
            CommAdminAddHospitalJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CommAdminAddHospitalJPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel103)
                .addGap(18, 18, 18)
                .addGroup(CommAdminAddHospitalJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel92)
                    .addComponent(txtCommAdminHospID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(CommAdminAddHospitalJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel93)
                    .addComponent(txtCommAdminHospName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(CommAdminAddHospitalJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel94)
                    .addComponent(txtCommAdminCommName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnAddHospital)
                .addContainerGap(1029, Short.MAX_VALUE))
        );

        cardCommAdminManageHospitals.add(CommAdminAddHospitalJPanel, "card8");

        commAdminManageHospitalsSplitPane.setRightComponent(cardCommAdminManageHospitals);

        javax.swing.GroupLayout CommAdminManageHospitalsJPanelLayout = new javax.swing.GroupLayout(CommAdminManageHospitalsJPanel);
        CommAdminManageHospitalsJPanel.setLayout(CommAdminManageHospitalsJPanelLayout);
        CommAdminManageHospitalsJPanelLayout.setHorizontalGroup(
            CommAdminManageHospitalsJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CommAdminManageHospitalsJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(commAdminManageHospitalsSplitPane))
        );
        CommAdminManageHospitalsJPanelLayout.setVerticalGroup(
            CommAdminManageHospitalsJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(commAdminManageHospitalsSplitPane)
        );

        cardCommAdmin.add(CommAdminManageHospitalsJPanel, "card3");

        commAdminSplitPane.setRightComponent(cardCommAdmin);

        javax.swing.GroupLayout CommAdminMainJPanelLayout = new javax.swing.GroupLayout(CommAdminMainJPanel);
        CommAdminMainJPanel.setLayout(CommAdminMainJPanelLayout);
        CommAdminMainJPanelLayout.setHorizontalGroup(
            CommAdminMainJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CommAdminMainJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(commAdminSplitPane)
                .addContainerGap())
        );
        CommAdminMainJPanelLayout.setVerticalGroup(
            CommAdminMainJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CommAdminMainJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(commAdminSplitPane)
                .addContainerGap())
        );

        card.add(CommAdminMainJPanel, "card4");

        jPanel2.setBackground(new java.awt.Color(181, 212, 243));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1780, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1246, Short.MAX_VALUE)
        );

        card.add(jPanel2, "card2");

        mainSplitFrame.setRightComponent(card);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainSplitFrame)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainSplitFrame)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        // TODO add your handling code here:
        cl.show(card, "mainRightPanel");
        txtUsername.setText("");
        txtPassword.setText("");
        btnLogout.setVisible(false);
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnLoginAfterSignUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginAfterSignUpActionPerformed
        // TODO add your handling code here:
        cl.show(card, "mainRightPanel");
        txtUsername.setText("");
        txtPassword.setText("");
        btnLogout.setVisible(false);
        btnLoginAfterSignUp.setVisible(false);
    }//GEN-LAST:event_btnLoginAfterSignUpActionPerformed

    private void txtUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsernameActionPerformed

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPasswordActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // TODO add your handling code here:

        
        
        String username = txtUsername.getText();
        String password = txtPassword.getText();
        if(username.matches("") || password.matches("")){
            JOptionPane.showMessageDialog(this, "Please enter username and password or sign up if you are a new user.");
        }
        else{
            String role = personDirectory.login(username, password);
            String commName = personDirectory.getCommunityNameOfSelectedPatient(username, password);
            
            if(role.equals("System Admin")){
                btnLogout.setVisible(true);
                cl.show(card, "systemAdminMainJPanel");
            }
            else {
                if(role.equals("Hospital Admin")){
                    btnLogout.setVisible(true);
                    cl.show(card, "hospAdminMainJPanel");
                    clHospAdmin.show(cardHospAdmin,"welcomeHospAdminJPanel");
                    clHospAdminManageDoctor.show(cardHospAdminManageDoctor,"welcomeHospAdminManageDoctorJPanel");
                    clHospAdminManagePatient.show(cardHospAdminManagePatient,"welcomeHospAdminManageDoctorJPanel");
                }
                else {
                    if(role.equals("Community Admin")){
                        btnLogout.setVisible(true);
                        cl.show(card, "commAdminMainJPanel");
                        clCommAdmin.show(cardCommAdmin,"WelcomeCommAdminJPanel");
                        clCommAdminManageCommunity.show(cardCommAdminManageCommunity,"WelcomeCommAdminManageCommunityJPanel");
                        clCommAdminManageHospitals.show(cardCommAdminManageHospitals,"WelcomeCommAdminManageHospitalsJPanel");
                    }
                    else {
                        if(role.equals("Doctor")){
                            btnLogout.setVisible(true);
                            currentDoctor = doctorDirectory.getCurrentDoctor(username, password);
                            cl.show(card, "doctorMainJPanel");
                            clDoctor.show(cardDoctor, "welcomeDoctorJPanel");
                        }
                        else {
                            if(role.equals("Patient")){
                                btnLogout.setVisible(true);
                                populateHospitalTable(commName);
                                currentPatient = patientDirectory.getCurrentPatient(username, password);
                                cl.show(card, "patientMainJPanel");
                                clPatient.show(cardPatient, "welcomePatientJPanel");
                            }
                            else {
                                if(role.equals("Null")){
                                    JOptionPane.showMessageDialog(this, "Invalid credentials. Please try again!");
                                    txtUsername.setText("");
                                    txtPassword.setText("");
                                    btnLogout.setVisible(false);
                                }
                            }
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnSignUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignUpActionPerformed
        // TODO add your handling code here:
        cl.show(card, "patientSignUpJPanel");
        btnLoginAfterSignUp.setVisible(true);

    }//GEN-LAST:event_btnSignUpActionPerformed

    private void btnSignUpPatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignUpPatientActionPerformed
        // TODO add your handling code here:
        

        if(txtFullName.getText().matches("") || txtUsernamePatient.getText().matches("") || txtPasswordPatient.getText().matches("") || txtDob.getText().matches("") || txtAge.getText().matches("") || txtStreetName.getText().matches("") || txtAptNo.getText().matches("") || txtCityName.getText().matches("") || txtState.getText().matches("") || txtZipcode.getText().matches("")){
            JOptionPane.showMessageDialog(this, "None of the fields should be left blank. Please enter valid data in all fields.");
            return;
        }
        else{
            String fullName = txtFullName.getText();
            String username = txtUsernamePatient.getText();
            String password = txtPasswordPatient.getText();
            String dob = txtDob.getText();
            int age=0;
            if(Pattern.matches("^[0-9]*$",txtAge.getText())){
                age = Integer.parseInt(txtAge.getText());
            }
            String gender = ddGender.getSelectedItem().toString();
            String streetName = txtStreetName.getText();
            String aptNo = txtAptNo.getText();
            String commName = ddCommName.getSelectedItem().toString();
            String cityName = txtCityName.getText();
            String state = txtState.getText();
            String zipcode = txtZipcode.getText();
            String role = "Patient";

            boolean bFullName = Pattern.matches("^[A-Za-z0-9]*$", fullName);
            //boolean bUsername = personDirectory.checkDuplicateUsername(username);
            boolean bUsername = Pattern.matches("^[A-Za-z0-9]*$", username);
            boolean bAge = Pattern.matches("(01|02|03|04|05|06|07|08|09|[1-9][0-9])$", Integer.toString(age));
            boolean bDob = Pattern.matches("(0[1-9]|1[0-2])\\/(0[1-9]|1\\d|2\\d|3[01])\\/(19|20)\\d{2}$", dob);
            boolean bState = Pattern.matches("(AL|AK|AZ|AR|CA|CO|CT|DE|DC|FL|GA|HI|ID|IL|IN|IA|KS|KY|LA|ME|MD|MA|MI|MN|MS|MO|MT|NE|NV|NH|NJ|NM|NY|NC|ND|OH|OK|OR|PA|RI|SC|SD|TN|TX|UT|VT|VA|WA|WV|WI|WY)$",state);
            boolean bZipcode = Pattern.matches("\\b\\d{5}\\b",zipcode);
            
            if(!bFullName){
                JOptionPane.showMessageDialog(this, "Name field should only have Alphanumeric characters. Special characters are not allowed. Please try again!");
                txtFullName.setText("");
                return;
            }
            else {
                if(!bUsername){
                    JOptionPane.showMessageDialog(this, "Username field should only have Alphanumeric characters. Special characters are not allowed. Please try again!");
                    txtUsernamePatient.setText("");
                    return;
                }
                else {
                    if(!bDob){
                        JOptionPane.showMessageDialog(this, "Please enter your DOB in MM/DD/YYYY format.");
                        txtDob.setText("");
                        return;
                    }
                    else {
                        if(!bAge){
                            JOptionPane.showMessageDialog(this, "Please enter valid age. If you are 1-9 years old, enter your age in 01, 02,...,09 format.");
                            txtAge.setText("");
                            return;
                        }
                        else {
                            if(!bState){
                                JOptionPane.showMessageDialog(this, "Please enter 2 letter state code. Ex - \"MA\" for Massachusetts");
                                txtState.setText("");
                                return;
                            }
                            else {
                                if(!bZipcode){
                                    JOptionPane.showMessageDialog(this, "Please enter valid 5 digit zipcode");
                                    txtZipcode.setText("");
                                    return;
                                }
                                else {

                                    
                                    Person person = new Person(fullName, new House(streetName, aptNo, state, commName, cityName, zipcode), gender, dob, age, username, password, "Patient");
                                    Patient patient = new Patient(patientCount++,new EncounterHistory(),new Encounter(), fullName, new House(streetName, aptNo, state, commName, cityName, zipcode), gender, dob, age, username, password, "Patient");
                                    if(!personDirectory.checkDuplicateUsername(username)){
                                        personDirectory.addPerson(person);
                                        patientDirectory.addPatient(patient);
                                        JOptionPane.showMessageDialog(this, "Sign up successful! Please click on navigate to login page button to login.");
                                        clearFields();
                                    }
                                    else{
                                        JOptionPane.showMessageDialog(this, "This username already exists");
                                        txtUsernamePatient.setText("");
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_btnSignUpPatientActionPerformed

    private void clearFields(){
        txtFullName.setText("");
        txtUsernamePatient.setText("");
        txtPasswordPatient.setText("");
        txtDob.setText("");
        txtAge.setText("");
        ddGender.setSelectedIndex(0);
        txtStreetName.setText("");
        txtAptNo.setText("");
        txtState.setText("");
        txtCityName.setText("");
        txtZipcode.setText("");
    }
    
    private void populateHospitalTable(String commName) {
        
        DefaultTableModel model = (DefaultTableModel) tblHospList1.getModel();
        model.setRowCount(0);
        for(Hospital h : hospitalDirectory.getHospital()){
            if(commName.equals(h.getCommunityName())){
                Object[] row = new Object[2];
                row[0] = h;
                model.addRow(row);
            } 
        }
    }
    
    private void populateDoctorTable(Hospital h) {
        
        DefaultTableModel model = (DefaultTableModel) tblDoctorList1.getModel();
        model.setRowCount(0);
        for(Doctor d : doctorDirectory.getDoctor()){
            if(d.getHospitalId() == h.getHospitalId()){
                Object[] row = new Object[2];
                row[0] = d.getFullName();
                row[1] = d.getGender();
                model.addRow(row);
            } 
        }
    }
    
    private void populatePatientTable(int hospId){
        DefaultTableModel model = (DefaultTableModel) tblPatientList.getModel();
        model.setRowCount(0);
        for(Patient p : patientDirectory.getPatient()){
            if(p.getHospitalId() == hospId){
                Object[] row = new Object[2];
                row[0] = p.getPatientId();
                row[1] = p;
                model.addRow(row);
            }
        }
    }
    private void btnSearchHospActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchHospActionPerformed
        // TODO add your handling code here:
        clPatient.show(cardPatient, "patientSearchHospJPanel1");
        
    }//GEN-LAST:event_btnSearchHospActionPerformed

    private void txtZipcodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtZipcodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtZipcodeActionPerformed

    private void btnSelectHospital1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectHospital1ActionPerformed
        // TODO add your handling code here:
        selectedRowIndex = tblHospList1.getSelectedRow();
        if (selectedRowIndex<0) {
            JOptionPane.showMessageDialog(this, "Please select a hospital to view the list of doctors in that hospital.");
            return;
        }
        
        DefaultTableModel model = (DefaultTableModel) tblHospList1.getModel();
        Hospital selectedHospital = (Hospital)model.getValueAt(selectedRowIndex, 0);
        populateDoctorTable(selectedHospital);
        currentPatient.setHospitalId(selectedHospital.getHospitalId());
    }//GEN-LAST:event_btnSelectHospital1ActionPerformed

    private void txtTemperatureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTemperatureActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTemperatureActionPerformed

    private void txtPulseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPulseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPulseActionPerformed

    private void btnRecordVitalsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecordVitalsActionPerformed
        // TODO add your handling code here:
        if(txtTemperature.getText().matches("") || txtPulse.getText().matches("") || txtBloodPressure.getText().matches("") || txtAptDate.getText().matches("")){
            JOptionPane.showMessageDialog(this, "None of the fields should be left blank. Please enter valid data in all fields.");
        }
        else{
            String temp = txtTemperature.getText();
            int pulse = 0;
            if(Pattern.matches("^[0-9]*$",txtPulse.getText())){
                pulse = Integer.parseInt(txtPulse.getText());
            }
            String bloodP = txtBloodPressure.getText();
            String aptDate = txtAptDate.getText();
            
            boolean bTemp = Pattern.matches("\\b(5[3-9]|[6-9][0-9]|10[0-9]|11[0-5])\\b$", temp);
            boolean bPulse = Pattern.matches("\\b(2[7-9]|[3-9][0-9]|[1-3][0-9][0-9]|4[0-7][0-9]|480)\\b$", Integer.toString(pulse));
            boolean bBloodP = Pattern.matches("[0-9]{2,3}/[0-9]{2,3}", bloodP);
            boolean bAptDate = Pattern.matches("(0[1-9]|1[0-2])\\/(0[1-9]|1\\d|2\\d|3[01])\\/(18|19|20)\\d{2}$", aptDate);
            
            if(!bTemp){
                JOptionPane.showMessageDialog(this, "Please enter valid body temperature in Farenheit.");
            }
            else {
                if(!bPulse){
                    JOptionPane.showMessageDialog(this, "Please enter valid pulse.");
                }
                else {
                    if(!bBloodP){
                        JOptionPane.showMessageDialog(this, "Please enter valid blood pressure in the format systolic/diastolic.");
                    }
                    else {
                        if(!bAptDate){
                            JOptionPane.showMessageDialog(this, "Please enter the date in MM/DD/YYYY format.");
                        }
                        else {
                            VitalSigns v = new VitalSigns(temp, pulse, bloodP);
                            Encounter e = new Encounter();
                            e.setVitalSign(v);
                            e.setAptDate(aptDate);
                            currentPatient.setEncounter(e);
                            
                            JOptionPane.showMessageDialog(this, "Vital signs recorded successfully! Please visit our hospital to get a diagnosis by a doctor.");
                            
                            txtTemperature.setText("");
                            txtPulse.setText("");
                            txtBloodPressure.setText("");
                            txtAptDate.setText("");
                        }
                    }
                }
            }
        }
        
        
    }//GEN-LAST:event_btnRecordVitalsActionPerformed

    private void btnAddNewVitalsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddNewVitalsActionPerformed
        // TODO add your handling code here:
        clPatient.show(cardPatient, "patientAddVitalsJPanel");
    }//GEN-LAST:event_btnAddNewVitalsActionPerformed

    private void btnDiagnosePatientsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDiagnosePatientsActionPerformed
        // TODO add your handling code here:
        clDoctor.show(cardDoctor, "diagnosePatientJPanel");
        populatePatientTable(currentDoctor.getHospitalId());
         
    }//GEN-LAST:event_btnDiagnosePatientsActionPerformed

    private void txtDoctorZipcodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDoctorZipcodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDoctorZipcodeActionPerformed

    private void btnAddDoctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddDoctorActionPerformed
        // TODO add your handling code here:
        if(txtDoctorFullName.getText().matches("") || txtDoctorUsername.getText().matches("") || txtDoctorPassword.getText().matches("") || txtDoctorDob.getText().matches("") || txtDoctorAge.getText().matches("") || txtDoctorStreetName.getText().matches("") || txtDoctorAptNo.getText().matches("") || txtDoctorCityName.getText().matches("") || txtDoctorState.getText().matches("") || txtDoctorZipcode.getText().matches("") || txtDoctorHospId.getText().matches("")){
            JOptionPane.showMessageDialog(this, "None of the fields should be left blank. Please enter valid data in all fields.");
            return;
        }
        else{
            String fullName = txtDoctorFullName.getText();
            String username = txtDoctorUsername.getText();
            String password = txtDoctorPassword.getText();
            String dob = txtDoctorDob.getText();
            int age=0;
            if(Pattern.matches("^[0-9]*$",txtDoctorAge.getText())){
                age = Integer.parseInt(txtDoctorAge.getText());
            }
            String gender = ddDoctorGender.getSelectedItem().toString();
            String streetName = txtDoctorStreetName.getText();
            String aptNo = txtDoctorAptNo.getText();
            String commName = ddDoctorCommName.getSelectedItem().toString();
            String cityName = txtDoctorCityName.getText();
            String state = txtDoctorState.getText();
            String zipcode = txtDoctorZipcode.getText();
            int hospId=0;
            if(Pattern.matches("^[0-9]*$",txtDoctorHospId.getText())){
                hospId = Integer.parseInt(txtDoctorHospId.getText());
            }
            
            boolean bFullName = Pattern.matches("^[A-Za-z0-9]*$", fullName);
            //boolean bUsername = personDirectory.checkDuplicateUsername(username);
            boolean bUsername = Pattern.matches("^[A-Za-z0-9]*$", username);
            boolean bAge = Pattern.matches("(01|02|03|04|05|06|07|08|09|[1-9][0-9])$", Integer.toString(age));
            boolean bDob = Pattern.matches("(0[1-9]|1[0-2])\\/(0[1-9]|1\\d|2\\d|3[01])\\/(19|20)\\d{2}$", dob);
            boolean bState = Pattern.matches("(AL|AK|AZ|AR|CA|CO|CT|DE|DC|FL|GA|HI|ID|IL|IN|IA|KS|KY|LA|ME|MD|MA|MI|MN|MS|MO|MT|NE|NV|NH|NJ|NM|NY|NC|ND|OH|OK|OR|PA|RI|SC|SD|TN|TX|UT|VT|VA|WA|WV|WI|WY)$",state);
            boolean bZipcode = Pattern.matches("\\b\\d{5}\\b",zipcode);
            
            if(!bFullName){
                JOptionPane.showMessageDialog(this, "Name field should only have Alphanumeric characters. Special characters are not allowed. Please try again!");
                txtDoctorFullName.setText("");
                return;
            }
            else {
                if(!bUsername){
                    JOptionPane.showMessageDialog(this, "Username field should only have Alphanumeric characters. Special characters are not allowed. Please try again!");
                    txtDoctorUsername.setText("");
                    return;
                }
                else {
                    if(!bDob){
                        JOptionPane.showMessageDialog(this, "Please enter your DOB in MM/DD/YYYY format.");
                        txtDoctorDob.setText("");
                        return;
                    }
                    else {
                        if(!bAge){
                            JOptionPane.showMessageDialog(this, "Please enter valid age. If you are 1-9 years old, enter your age in 01, 02,...,09 format.");
                            txtDoctorAge.setText("");
                            return;
                        }
                        else {
                            if(!bState){
                                JOptionPane.showMessageDialog(this, "Please enter 2 letter state code. Ex - \"MA\" for Massachusetts");
                                txtDoctorState.setText("");
                                return;
                            }
                            else {
                                if(!bZipcode){
                                    JOptionPane.showMessageDialog(this, "Please enter valid 5 digit zipcode");
                                    txtDoctorZipcode.setText("");
                                    return;
                                }
                                else {

                                    
                                    Person person = new Person(fullName, new House(streetName, aptNo, state, commName, cityName, zipcode), gender, dob, age, username, password, "Doctor");
                                    Doctor doctor = new Doctor(doctorCount++,hospId, fullName, new House(streetName, aptNo, state, commName, cityName, zipcode), gender, dob, age, username, password, "Patient");
                                    if(!personDirectory.checkDuplicateUsername(username)){
                                        personDirectory.addPerson(person);
                                        doctorDirectory.addDoctor(doctor);
                                        JOptionPane.showMessageDialog(this, "Doctor added successfully!");
                                        clearDoctorFields();
                                    }
                                    else{
                                        JOptionPane.showMessageDialog(this, "This username already exists");
                                        txtDoctorUsername.setText("");
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        
        
    }//GEN-LAST:event_btnAddDoctorActionPerformed

    private void btnManageDoctorsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageDoctorsActionPerformed
        // TODO add your handling code here:
        clHospAdmin.show(cardHospAdmin,"hospAdminManageDoctorJPanel");
    }//GEN-LAST:event_btnManageDoctorsActionPerformed

    private void btnRegisterDoctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterDoctorActionPerformed
        // TODO add your handling code here:
        clHospAdminManageDoctor.show(cardHospAdminManageDoctor,"hospAdminAddDoctorJPanel");
    }//GEN-LAST:event_btnRegisterDoctorActionPerformed

    private void txtDoctorHospIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDoctorHospIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDoctorHospIdActionPerformed

    private void btnRegisterPatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterPatientActionPerformed
        // TODO add your handling code here:
        clHospAdminManagePatient.show(cardHospAdminManagePatient,"hospAdminAddPatientJPanel");
    }//GEN-LAST:event_btnRegisterPatientActionPerformed

    private void txtPatientZipcodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPatientZipcodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPatientZipcodeActionPerformed

    private void btnAddPatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddPatientActionPerformed
        // TODO add your handling code here:
        if(txtPatientFullName.getText().matches("") || txtPatientUsername.getText().matches("") || txtPatientPassword.getText().matches("") || txtPatientDob.getText().matches("") || txtPatientAge.getText().matches("") || txtPatientStreetName.getText().matches("") || txtPatientAptNo.getText().matches("") || txtPatientCityName.getText().matches("") || txtPatientState.getText().matches("") || txtPatientZipcode.getText().matches("")){
            JOptionPane.showMessageDialog(this, "None of the fields should be left blank. Please enter valid data in all fields.");
            return;
        }
        else{
            String fullName = txtPatientFullName.getText();
            String username = txtPatientUsername.getText();
            String password = txtPatientPassword.getText();
            String dob = txtPatientDob.getText();
            int age=0;
            if(Pattern.matches("^[0-9]*$",txtPatientAge.getText())){
                age = Integer.parseInt(txtPatientAge.getText());
            }
            String gender = ddPatientGender.getSelectedItem().toString();
            String streetName = txtPatientStreetName.getText();
            String aptNo = txtPatientAptNo.getText();
            String commName = ddPatientCommName.getSelectedItem().toString();
            String cityName = txtPatientCityName.getText();
            String state = txtPatientState.getText();
            String zipcode = txtPatientZipcode.getText();
            String role = "Patient";

            boolean bFullName = Pattern.matches("^[A-Za-z0-9]*$", fullName);
            //boolean bUsername = personDirectory.checkDuplicateUsername(username);
            boolean bUsername = Pattern.matches("^[A-Za-z0-9]*$", username);
            boolean bAge = Pattern.matches("(01|02|03|04|05|06|07|08|09|[1-9][0-9])$", Integer.toString(age));
            boolean bDob = Pattern.matches("(0[1-9]|1[0-2])\\/(0[1-9]|1\\d|2\\d|3[01])\\/(19|20)\\d{2}$", dob);
            boolean bState = Pattern.matches("(AL|AK|AZ|AR|CA|CO|CT|DE|DC|FL|GA|HI|ID|IL|IN|IA|KS|KY|LA|ME|MD|MA|MI|MN|MS|MO|MT|NE|NV|NH|NJ|NM|NY|NC|ND|OH|OK|OR|PA|RI|SC|SD|TN|TX|UT|VT|VA|WA|WV|WI|WY)$",state);
            boolean bZipcode = Pattern.matches("\\b\\d{5}\\b",zipcode);
            
            if(!bFullName){
                JOptionPane.showMessageDialog(this, "Name field should only have Alphanumeric characters. Special characters are not allowed. Please try again!");
                txtPatientFullName.setText("");
                return;
            }
            else {
                if(!bUsername){
                    JOptionPane.showMessageDialog(this, "Username field should only have Alphanumeric characters. Special characters are not allowed. Please try again!");
                    txtPatientUsername.setText("");
                    return;
                }
                else {
                    if(!bDob){
                        JOptionPane.showMessageDialog(this, "Please enter your DOB in MM/DD/YYYY format.");
                        txtPatientDob.setText("");
                        return;
                    }
                    else {
                        if(!bAge){
                            JOptionPane.showMessageDialog(this, "Please enter valid age. If you are 1-9 years old, enter your age in 01, 02,...,09 format.");
                            txtPatientAge.setText("");
                            return;
                        }
                        else {
                            if(!bState){
                                JOptionPane.showMessageDialog(this, "Please enter 2 letter state code. Ex - \"MA\" for Massachusetts");
                                txtPatientState.setText("");
                                return;
                            }
                            else {
                                if(!bZipcode){
                                    JOptionPane.showMessageDialog(this, "Please enter valid 5 digit zipcode");
                                    txtPatientZipcode.setText("");
                                    return;
                                }
                                else {

                                    
                                    Person person = new Person(fullName, new House(streetName, aptNo, state, commName, cityName, zipcode), gender, dob, age, username, password, "Patient");
                                    Patient patient = new Patient(patientCount++,new EncounterHistory(),new Encounter(), fullName, new House(streetName, aptNo, state, commName, cityName, zipcode), gender, dob, age, username, password, "Patient");
                                    if(!personDirectory.checkDuplicateUsername(username)){
                                        personDirectory.addPerson(person);
                                        patientDirectory.addPatient(patient);
                                        JOptionPane.showMessageDialog(this, "Patient added successfully!");
                                        clearPatientFields();
                                    }
                                    else{
                                        JOptionPane.showMessageDialog(this, "This username already exists");
                                        txtPatientUsername.setText("");
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        
        
    }//GEN-LAST:event_btnAddPatientActionPerformed

    private void btnManagePatientsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManagePatientsActionPerformed
        // TODO add your handling code here:
        clHospAdmin.show(cardHospAdmin,"hospAdminManagePatientJPanel");
    }//GEN-LAST:event_btnManagePatientsActionPerformed

    private void btnViewRecentVitalsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewRecentVitalsActionPerformed
        // TODO add your handling code here:
        selectedRowIndex1 = tblPatientList.getSelectedRow();
        if (selectedRowIndex1<0) {
            JOptionPane.showMessageDialog(this, "Please select a patient to view their vitals.");
            return;
        }
        
        DefaultTableModel model = (DefaultTableModel) tblPatientList.getModel();
        Patient selectedPatient = (Patient)model.getValueAt(selectedRowIndex1, 1);
        
        lblTemperature.setText(selectedPatient.getEncounter().getVitalSign().getTemp());
        lblPulse.setText(String.valueOf(selectedPatient.getEncounter().getVitalSign().getPulse()));
        lblBloodPressure.setText(selectedPatient.getEncounter().getVitalSign().getBloodPressure());
        
        
    }//GEN-LAST:event_btnViewRecentVitalsActionPerformed

    private void btnSubmitDiagnosisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitDiagnosisActionPerformed
        // TODO add your handling code here:
        
        DefaultTableModel model = (DefaultTableModel) tblPatientList.getModel();
        
        Patient selectedPatient = (Patient)model.getValueAt(selectedRowIndex1, 1);
        if(!txtDiagnosis.getText().equals("")){
            selectedPatient.getEncounter().setDiagnosis(txtDiagnosis.getText());
            selectedPatient.addEncounterHistory(selectedPatient.getEncounter());
            JOptionPane.showMessageDialog(this, "Diagnosis submitted successfully!");
            lblBloodPressure.setText("");
            lblPulse.setText("");
            lblTemperature.setText("");
            txtDiagnosis.setText("");
        }
        else{
            JOptionPane.showMessageDialog(this, "Please provide diagnosis.");
        }
       
        
        
        
    }//GEN-LAST:event_btnSubmitDiagnosisActionPerformed

    private void btnEncounterHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEncounterHistoryActionPerformed
        // TODO add your handling code here:
        clPatient.show(cardPatient, "patientViewEncounterHistoryJPanel");
        populateEncounterHistoryTable(currentPatient.getEncounterHistory());
        
    }//GEN-LAST:event_btnEncounterHistoryActionPerformed

    private void btnManageHospitalsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageHospitalsActionPerformed
        // TODO add your handling code here:
        clCommAdmin.show(cardCommAdmin,"CommAdminManageHospitalsJPanel");
        clCommAdminManageHospitals.show(cardCommAdminManageHospitals,"WelcomeCommAdminManageHospitalsJPanel");
    }//GEN-LAST:event_btnManageHospitalsActionPerformed

    private void btnManageCommunityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageCommunityActionPerformed
        // TODO add your handling code here:
        clCommAdmin.show(cardCommAdmin,"CommAdminManageCommunityJPanel");
        clCommAdminManageCommunity.show(cardCommAdminManageCommunity,"WelcomeCommAdminManageCommunityJPanel");
    }//GEN-LAST:event_btnManageCommunityActionPerformed

    private void btnRegisterCommunityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterCommunityActionPerformed
        // TODO add your handling code here:
        clCommAdminManageCommunity.show(cardCommAdminManageCommunity,"CommAdminAddCommunityJPanel");
        
    }//GEN-LAST:event_btnRegisterCommunityActionPerformed

    private void btnAddCommunityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddCommunityActionPerformed
        // TODO add your handling code here:
        if(txtCommAdminCommName1.getText().equals("") || txtCommAdminCityName.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Please add data in all fields.");
        }
        else {
            if(txtCommAdminCommName1.getText().matches("^[A-Za-z]*$") && txtCommAdminCityName.getText().matches("^[A-Za-z]*$")){
                Community c = new Community(txtCommAdminCommName1.getText(),txtCommAdminCityName.getText());
                c1.getCommunityList().add(c);
                JOptionPane.showMessageDialog(this, "Community added successfully!");
                txtCommAdminCommName1.setText("");
                txtCommAdminCityName.setText("");
                ddCommName.addItem(c.getCommunityName());
                ddDoctorCommName.addItem(c.getCommunityName());
                ddPatientCommName.addItem(c.getCommunityName());
            }
            else {
                JOptionPane.showMessageDialog(this, "Please enter Alphabets in City and Community names.");
            }
        }
    }//GEN-LAST:event_btnAddCommunityActionPerformed

    private void btnRegisterHospitalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterHospitalActionPerformed
        // TODO add your handling code here:
        clCommAdminManageHospitals.show(cardCommAdminManageHospitals,"CommAdminAddHospitalJPanel");
    }//GEN-LAST:event_btnRegisterHospitalActionPerformed

    private void btnAddHospitalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddHospitalActionPerformed
        // TODO add your handling code here:
        if(txtCommAdminHospID.getText().equals("") || txtCommAdminHospName.getText().equals("") || txtCommAdminCommName.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Please add data in all fields.");
        }
        else {
            if(txtCommAdminHospID.getText().matches("^[0-9]*$") && txtCommAdminHospName.getText().matches("^[A-Za-z]*$") && txtCommAdminCommName.getText().matches("^[A-Za-z]*$")){
                Hospital h = new Hospital(Integer.parseInt(txtCommAdminHospID.getText()), txtCommAdminHospName.getText(),txtCommAdminCommName.getText());
                hospitalDirectory.addHospital(h);
                JOptionPane.showMessageDialog(this, "Hospital added successfully!");
                txtCommAdminHospID.setText("");
                txtCommAdminHospName.setText("");
                txtCommAdminCommName.setText("");
            }
            else {
                JOptionPane.showMessageDialog(this, "Please enter numeric data in Hospital Id field and Alphabets in Hospital and Community names.");
            }
        }
        
        
        
    }//GEN-LAST:event_btnAddHospitalActionPerformed

    private void ddCommNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ddCommNameActionPerformed
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_ddCommNameActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CommAdminAddCommunityJPanel;
    private javax.swing.JPanel CommAdminAddHospitalJPanel;
    private javax.swing.JPanel CommAdminMainJPanel;
    private javax.swing.JPanel CommAdminManageCommunityJPanel;
    private javax.swing.JPanel CommAdminManageHospitalsJPanel;
    private javax.swing.JPanel DiagnosePatientJPanel;
    private javax.swing.JPanel DoctorMainJPanel;
    private javax.swing.JPanel HospAdminAddDoctorJPanel;
    private javax.swing.JPanel HospAdminAddPatientJPanel;
    private javax.swing.JPanel HospAdminMainJPanel;
    private javax.swing.JPanel HospAdminManageDoctorJPanel;
    private javax.swing.JPanel HospAdminManagePatientJPanel;
    private javax.swing.JPanel PatientAddVitalsJPanel;
    private javax.swing.JPanel PatientMainJPanel;
    private javax.swing.JPanel PatientNavPanel;
    private javax.swing.JPanel PatientSearchHospJPanel1;
    private javax.swing.JPanel PatientSignUpJPanel;
    private javax.swing.JPanel PatientViewEncounterHistoryJPanel;
    private javax.swing.JPanel SystemAdminMainJPanel;
    private javax.swing.JPanel WelcomeCommAdminJPanel;
    private javax.swing.JPanel WelcomeCommAdminManageCommunityJPanel;
    private javax.swing.JPanel WelcomeCommAdminManageHospitalsJPanel;
    private javax.swing.JPanel WelcomeDoctorJPanel;
    private javax.swing.JPanel WelcomeHospAdminJPanel;
    private javax.swing.JPanel WelcomeHospAdminManageDoctorJPanel;
    private javax.swing.JPanel WelcomeHospAdminManagePatientJPanel;
    private javax.swing.JPanel WelcomePatientJPanel;
    private javax.swing.JButton btnAddCommunity;
    private javax.swing.JButton btnAddDoctor;
    private javax.swing.JButton btnAddHospital;
    private javax.swing.JButton btnAddNewVitals;
    private javax.swing.JButton btnAddPatient;
    private javax.swing.JButton btnDiagnosePatients;
    private javax.swing.JButton btnEncounterHistory;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnLoginAfterSignUp;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnManageCommunity;
    private javax.swing.JButton btnManageDoctors;
    private javax.swing.JButton btnManageHospitals;
    private javax.swing.JButton btnManagePatients;
    private javax.swing.JButton btnRecordVitals;
    private javax.swing.JButton btnRegisterCommunity;
    private javax.swing.JButton btnRegisterDoctor;
    private javax.swing.JButton btnRegisterHospital;
    private javax.swing.JButton btnRegisterPatient;
    private javax.swing.JButton btnSearchHosp;
    private javax.swing.JButton btnSelectHospital1;
    private javax.swing.JButton btnSignUp;
    private javax.swing.JButton btnSignUpPatient;
    private javax.swing.JButton btnSubmitDiagnosis;
    private javax.swing.JButton btnViewRecentVitals;
    private javax.swing.JPanel card;
    private javax.swing.JPanel cardCommAdmin;
    private javax.swing.JPanel cardCommAdminManageCommunity;
    private javax.swing.JPanel cardCommAdminManageHospitals;
    private javax.swing.JPanel cardDoctor;
    private javax.swing.JPanel cardHospAdmin;
    private javax.swing.JPanel cardHospAdminManageDoctor;
    private javax.swing.JPanel cardHospAdminManagePatient;
    private javax.swing.JPanel cardPatient;
    private javax.swing.JPanel commAdminManageCommunityNavPanel;
    private javax.swing.JSplitPane commAdminManageCommunitySplitPane;
    private javax.swing.JPanel commAdminManageHospitalsNavPanel;
    private javax.swing.JSplitPane commAdminManageHospitalsSplitPane;
    private javax.swing.JPanel commAdminNavPanel;
    private javax.swing.JSplitPane commAdminSplitPane;
    private javax.swing.JComboBox<String> ddCommName;
    private javax.swing.JComboBox<String> ddDoctorCommName;
    private javax.swing.JComboBox<String> ddDoctorGender;
    private javax.swing.JComboBox<String> ddGender;
    private javax.swing.JComboBox<String> ddPatientCommName;
    private javax.swing.JComboBox<String> ddPatientGender;
    private javax.swing.JPanel doctorNavPanel;
    private javax.swing.JSplitPane doctorSplitPane;
    private javax.swing.JPanel hospAdminManageDoctorNavPaneL;
    private javax.swing.JSplitPane hospAdminManageDoctorSplitPane;
    private javax.swing.JPanel hospAdminManagePatientNavPanel;
    private javax.swing.JSplitPane hospAdminManagePatientSplitPane;
    private javax.swing.JPanel hospAdminNavPanel;
    private javax.swing.JSplitPane hospAdminSplitPane;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblBloodPressure;
    private javax.swing.JLabel lblPulse;
    private javax.swing.JLabel lblTemperature;
    private javax.swing.JPanel mainRightPanel;
    private javax.swing.JSplitPane mainSplitFrame;
    private javax.swing.JPanel navPanel;
    private javax.swing.JSplitPane splitPane;
    private javax.swing.JTable tblDoctorList1;
    private javax.swing.JTable tblEncounterHistory;
    private javax.swing.JTable tblHospList1;
    private javax.swing.JTable tblPatientList;
    private javax.swing.JTextField txtAge;
    private javax.swing.JTextField txtAptDate;
    private javax.swing.JTextField txtAptNo;
    private javax.swing.JTextField txtBloodPressure;
    private javax.swing.JTextField txtCityName;
    private javax.swing.JTextField txtCommAdminCityName;
    private javax.swing.JTextField txtCommAdminCommName;
    private javax.swing.JTextField txtCommAdminCommName1;
    private javax.swing.JTextField txtCommAdminHospID;
    private javax.swing.JTextField txtCommAdminHospName;
    private javax.swing.JTextField txtDiagnosis;
    private javax.swing.JTextField txtDob;
    private javax.swing.JTextField txtDoctorAge;
    private javax.swing.JTextField txtDoctorAptNo;
    private javax.swing.JTextField txtDoctorCityName;
    private javax.swing.JTextField txtDoctorDob;
    private javax.swing.JTextField txtDoctorFullName;
    private javax.swing.JTextField txtDoctorHospId;
    private javax.swing.JTextField txtDoctorPassword;
    private javax.swing.JTextField txtDoctorState;
    private javax.swing.JTextField txtDoctorStreetName;
    private javax.swing.JTextField txtDoctorUsername;
    private javax.swing.JTextField txtDoctorZipcode;
    private javax.swing.JTextField txtFullName;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtPasswordPatient;
    private javax.swing.JTextField txtPatientAge;
    private javax.swing.JTextField txtPatientAptNo;
    private javax.swing.JTextField txtPatientCityName;
    private javax.swing.JTextField txtPatientDob;
    private javax.swing.JTextField txtPatientFullName;
    private javax.swing.JTextField txtPatientPassword;
    private javax.swing.JTextField txtPatientState;
    private javax.swing.JTextField txtPatientStreetName;
    private javax.swing.JTextField txtPatientUsername;
    private javax.swing.JTextField txtPatientZipcode;
    private javax.swing.JTextField txtPulse;
    private javax.swing.JTextField txtState;
    private javax.swing.JTextField txtStreetName;
    private javax.swing.JTextField txtTemperature;
    private javax.swing.JTextField txtUsername;
    private javax.swing.JTextField txtUsernamePatient;
    private javax.swing.JTextField txtZipcode;
    // End of variables declaration//GEN-END:variables

    private void clearDoctorFields() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        
        txtDoctorFullName.setText("");
        txtDoctorUsername.setText("");
        txtDoctorPassword.setText("");
        txtDoctorDob.setText("");
        txtDoctorAge.setText("");
        ddDoctorGender.setSelectedIndex(0);
        txtDoctorStreetName.setText("");
        txtDoctorAptNo.setText("");
        txtDoctorCityName.setText("");
        txtDoctorState.setText("");
        txtDoctorZipcode.setText("");
        txtDoctorHospId.setText("");
    }
    
    private void clearPatientFields() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        
        txtPatientFullName.setText("");
        txtPatientUsername.setText("");
        txtPatientPassword.setText("");
        txtPatientDob.setText("");
        txtPatientAge.setText("");
        ddPatientGender.setSelectedIndex(0);
        txtPatientStreetName.setText("");
        txtPatientAptNo.setText("");
        txtPatientCityName.setText("");
        txtPatientState.setText("");
        txtPatientZipcode.setText("");
    }

    private void populateEncounterHistoryTable(EncounterHistory encounterHistory) {
        DefaultTableModel model = (DefaultTableModel) tblEncounterHistory.getModel();
        model.setRowCount(0);
        for(Encounter e : encounterHistory.getEncounter()){
           
                Object[] row = new Object[5];
                row[0] = e.getAptDate();
                row[1] = e.getVitalSign().getTemp();
                row[2] = e.getVitalSign().getPulse();
                row[3] = e.getVitalSign().getBloodPressure();
                row[4] = e.getDiagnosis();
                model.addRow(row);
        }
    }
}
