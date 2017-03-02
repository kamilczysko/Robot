package robot;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class parametryDialog extends JDialog {

	
	private static final long serialVersionUID = 1L;
	
	private final JPanel contentPanel = new JPanel();
	private JTextField t1;
	private JTextField t2;
	private JTextField t3;
	private JTextField t4;
	private JTextField t5;
	private JTextField t6;
	private JTextField z;
	private JTextField l1;
	private JTextField l2;
	private JTextField l3;
	private JTextField e1;
	private JTextField e2;
	private JTextField e3;
	private JTextField w1;
	private JTextField w2;
	private JTextField w3;
	private JTextField alfa;
	private JTextField beta;
	private JTextField gama;
	private JTextField zv;
	private JTextField za;
	
	configLoader cl;
	grafika g;
	
	kontrolerDialog kd;
	

	public parametryDialog(final grafika g, final configLoader cl, final kontrolerDialog kd) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(parametryDialog.class.getResource("/robot/ikony/tut.png")));
		
		this.cl = cl;
		this.g = g;
		this.kd = kd;
		
		setTitle("Parametry robota");
		setResizable(false);
		setBounds(950, 350, 800, 650);
		setVisible(false);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(360, 10, 415, 560);
		
		contentPanel.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Zakresy k¹tów", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("<= \u03B8 1 <=");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(170, 150, 80, 20);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("<= \u03B8 2 <=");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(170, 225, 80, 20);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("<= \u03B8 3 <=");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(170, 300, 80, 20);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Z <=");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(170, 375, 80, 20);
		panel.add(lblNewLabel_3);
		
		t1 = new JTextField();
		t1.setToolTipText("K\u0105ty podajemy w stopniach");
		t1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		t1.setBounds(120, 150, 40, 20);
		panel.add(t1);
		t1.setColumns(10);
		
		t2 = new JTextField();
		t2.setToolTipText("K\u0105ty podajemy w stopniach");
		t2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		t2.setColumns(10);
		t2.setBounds(260, 150, 40, 20);
		panel.add(t2);
		
		t3 = new JTextField();
		t3.setToolTipText("K\u0105ty podajemy w stopniach");
		t3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		t3.setColumns(10);
		t3.setBounds(120, 223, 40, 20);
		panel.add(t3);
		
		t4 = new JTextField();
		t4.setToolTipText("K\u0105ty podajemy w stopniach");
		t4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		t4.setColumns(10);
		t4.setBounds(260, 223, 40, 20);
		panel.add(t4);
		
		t5 = new JTextField();
		t5.setToolTipText("K\u0105ty podajemy w stopniach");
		t5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		t5.setColumns(10);
		t5.setBounds(120, 298, 40, 20);
		panel.add(t5);
		
		t6 = new JTextField();
		t6.setToolTipText("K\u0105ty podajemy w stopniach");
		t6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		t6.setColumns(10);
		t6.setBounds(260, 298, 40, 20);
		panel.add(t6);
		
		z = new JTextField();
		z.setToolTipText("Maksymalny wysuw w mm");
		z.setFont(new Font("Tahoma", Font.PLAIN, 15));
		z.setColumns(10);
		z.setBounds(260, 373, 40, 20);
		panel.add(z);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Wymiary cz³onów", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblL = new JLabel("l1 =");
		lblL.setFont(new Font("Arial", Font.PLAIN, 15));
		lblL.setBounds(150, 200, 46, 14);
		panel_1.add(lblL);
		
		JLabel lblL_1 = new JLabel("l2 =");
		lblL_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblL_1.setBounds(150, 250, 46, 14);
		panel_1.add(lblL_1);
		
		JLabel lblL_2 = new JLabel("l3 =");
		lblL_2.setFont(new Font("Arial", Font.PLAIN, 15));
		lblL_2.setBounds(150, 300, 46, 14);
		panel_1.add(lblL_2);
		
		l1 = new JTextField();
		l1.setToolTipText("Wymiary podajemy w mm");
		l1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		l1.setBounds(185, 199, 55, 20);
		panel_1.add(l1);
		l1.setColumns(10);
		
		l2 = new JTextField();
		l2.setToolTipText("Wymiary podajemy w mm");
		l2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		l2.setColumns(10);
		l2.setBounds(185, 249, 55, 20);
		panel_1.add(l2);
		
		l3 = new JTextField();
		l3.setToolTipText("Wymiary podajemy w mm");
		l3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		l3.setColumns(10);
		l3.setBounds(185, 299, 55, 20);
		panel_1.add(l3);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Pozycja pocz¹tkowa", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("\u03B1 =");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(160, 170, 60, 20);
		panel_2.add(lblNewLabel_4);
		
		JLabel label_1 = new JLabel("\u03B2 =");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_1.setBounds(160, 240, 60, 20);
		panel_2.add(label_1);
		
		JLabel label_2 = new JLabel("\u03B3 =");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_2.setBounds(160, 310, 60, 20);
		panel_2.add(label_2);
		
		alfa = new JTextField();
		alfa.setToolTipText("K\u0105ty podajemy w stopniach");
		alfa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		alfa.setBounds(190, 170, 70, 20);
		panel_2.add(alfa);
		alfa.setColumns(10);
		
		beta = new JTextField();
		beta.setToolTipText("K\u0105ty podajemy w stopniach");
		beta.setFont(new Font("Tahoma", Font.PLAIN, 15));
		beta.setColumns(10);
		beta.setBounds(190, 240, 70, 20);
		panel_2.add(beta);
		
		gama = new JTextField();
		gama.setToolTipText("K\u0105ty podajemy w stopniach");
		gama.setFont(new Font("Tahoma", Font.PLAIN, 15));
		gama.setColumns(10);
		gama.setBounds(190, 310, 70, 20);
		panel_2.add(gama);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Prêdkoœci i przyspieszenia", null, panel_3, null);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("\u03B5 1 =");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(130, 25, 50, 20);
		panel_3.add(lblNewLabel_5);
		
		JLabel label_3 = new JLabel("\u03B5 2 =");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_3.setBounds(130, 75, 50, 20);
		panel_3.add(label_3);
		
		JLabel label_4 = new JLabel("\u03B5 3 =");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_4.setBounds(130, 125, 50, 20);
		panel_3.add(label_4);
		
		JLabel label_5 = new JLabel("\u03C9 1 =");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_5.setBounds(130, 255, 50, 20);
		panel_3.add(label_5);
		
		JLabel label_6 = new JLabel("\u03C9 2 =");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_6.setBounds(130, 305, 50, 20);
		panel_3.add(label_6);
		
		JLabel label_7 = new JLabel("\u03C9 3 =");
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_7.setBounds(130, 355, 50, 20);
		panel_3.add(label_7);
		
		e1 = new JTextField();
		e1.setToolTipText("Przyspieszenia k\u0105towe podajemy w stopniach na sekund\u0119 kwadrat");
		e1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		e1.setBounds(175, 27, 70, 20);
		panel_3.add(e1);
		e1.setColumns(10);
		
		e2 = new JTextField();
		e2.setToolTipText("Przyspieszenia k\u0105towe podajemy w stopniach na sekund\u0119 kwadrat");
		e2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		e2.setColumns(10);
		e2.setBounds(175, 77, 70, 20);
		panel_3.add(e2);
		
		e3 = new JTextField();
		e3.setToolTipText("Przyspieszenia k\u0105towe podajemy w stopniach na sekund\u0119 kwadrat");
		e3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		e3.setColumns(10);
		e3.setBounds(175, 127, 70, 20);
		panel_3.add(e3);
		
		w1 = new JTextField();
		w1.setToolTipText("Pr\u0119dko\u015Bci k\u0105towe podajemy w stopniach na sekund\u0119");
		w1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		w1.setColumns(10);
		w1.setBounds(175, 257, 70, 20);
		panel_3.add(w1);
		
		w2 = new JTextField();
		w2.setToolTipText("Pr\u0119dko\u015Bci k\u0105towe podajemy w stopniach na sekund\u0119");
		w2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		w2.setColumns(10);
		w2.setBounds(175, 307, 70, 20);
		panel_3.add(w2);
		
		w3 = new JTextField();
		w3.setToolTipText("Pr\u0119dko\u015Bci k\u0105towe podajemy w stopniach na sekund\u0119");
		w3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		w3.setColumns(10);
		w3.setBounds(175, 357, 70, 20);
		panel_3.add(w3);
		
		JLabel label_8 = new JLabel("\u017C  =");
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_8.setBounds(130, 440, 50, 20);
		panel_3.add(label_8);
		
		zv = new JTextField();
		zv.setToolTipText("Pr\u0119dko\u015Bci liniowe w mm na sekund\u0119");
		zv.setFont(new Font("Tahoma", Font.PLAIN, 15));
		zv.setColumns(10);
		zv.setBounds(175, 440, 70, 20);
		panel_3.add(zv);
		
		za = new JTextField();
		za.setToolTipText("Przyspieszenia liniowe w mm na sekund\u0119 kwadrat");
		za.setFont(new Font("Tahoma", Font.PLAIN, 15));
		za.setColumns(10);
		za.setBounds(175, 471, 70, 20);
		panel_3.add(za);
		
		JLabel lblp = new JLabel("a  =");
		lblp.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblp.setBounds(130, 471, 50, 20);
		panel_3.add(lblp);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(parametryDialog.class.getResource("/robot/ikony/schemat.png")));
		label.setBounds(10, 10, 340, 560);
		contentPanel.add(label);
		// do labela obrazek schematyczny

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		JButton okButton = new JButton("Zapisz");
		okButton.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				cl.saveProp(retVals());
				loadProp(cl,g);
				kd.loadProp(cl);
				
			}
		});
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);

		JButton cancelButton = new JButton("Anuluj");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				loadProp(cl,g);
			}
		});
		buttonPane.add(cancelButton);
		getRootPane().setDefaultButton(cancelButton);
		
		
		loadProp(cl,g);
	}
	
	String [][] retVals(){
		String [][] tab = new String[23][2];
		
		tab[0][0] = "gama0";
		tab[0][1] =	t1.getText();
		
		tab[1][0] = "alfa0";
		tab[1][1] = t3.getText();
		
		tab[2][0] = "beta0";
		tab[2][1] = t5.getText();
		
		tab[3][0] = "Z0";
		tab[3][1] = "0";
		
		tab[4][0] = "gama1";
		tab[4][1] = t2.getText();
		
		tab[5][0] = "beta1";
		tab[5][1] = t6.getText();
		
		tab[6][0] = "alfa1";
		tab[6][1] = t4.getText();
		
		tab[7][0] = "poczatkowaGama";
		tab[7][1] = gama.getText();
				
		tab[8][0] = "poczatkowaAlfa";
		tab[8][1] = alfa.getText();
		
		tab[9][0] = "poczatkowaBeta";
		tab[9][1] = beta.getText();
		
		tab[10][0] = "poczatkowyZ";
		tab[10][1] = "0";
		
		tab[11][0] = "l1";
		tab[11][1] = l1.getText();
		
		tab[12][0] = "l2";
		tab[12][1] = l2.getText();
		
		tab[13][0] = "l3";
		tab[13][1] = l3.getText();
		
		tab[14][0] = "omega1";
		tab[14][1] = w1.getText();
		
		tab[15][0] = "omega2";
		tab[15][1] = w2.getText();
		
		tab[16][0] = "omega3";
		tab[16][1] = w3.getText();
		
		tab[17][0] = "eps1";
		tab[17][1] = e1.getText();
		
		tab[18][0] = "eps2";
		tab[18][1] = e2.getText();
		
		tab[19][0] = "eps3";
		tab[19][1] = e3.getText();
		
		tab[20][0] = "zv";
		tab[20][1] = zv.getText();
		
		tab[21][0] = "za";
		tab[21][1] = za.getText();
		
		tab[22][0] = "Z1";
		tab[22][1] = z.getText();
		
		return tab;
	}
	
	void loadProp(configLoader cl,grafika g) {
		t1.setText(""+cl.gama0());
		t2.setText(""+cl.gama1());
		t3.setText(""+cl.alfa0());
		t4.setText(""+cl.alfa1());
		t5.setText(""+cl.beta0());
		t6.setText(""+cl.beta1());
		z.setText(""+cl.Z1());
		
		w1.setText(""+cl.w1());
		w2.setText(""+cl.w2());
		w3.setText(""+cl.w3());
		e1.setText(""+cl.e1());
		e2.setText(""+cl.e2());
		e3.setText(""+cl.e3());
		zv.setText(""+cl.zv());
		za.setText(""+cl.za());
		
		alfa.setText(""+cl.poczAlfa());
		beta.setText(""+cl.poczBeta());
		gama.setText(""+cl.poczGama());
		
		l1.setText(""+cl.l1());
		l2.setText(""+cl.l2());
		l3.setText(""+cl.l3());
	}
}
