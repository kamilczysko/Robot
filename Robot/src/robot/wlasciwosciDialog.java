package robot;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.vecmath.Color3f;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JSeparator;
import java.awt.Toolkit;


public class wlasciwosciDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final JPanel contentPanel = new JPanel();
	Color color;
	grafika g;
	configLoader cl;

	JButton btnWybierz_2, btnWybierz, button, button_1, button_2, button_3, button_4;
	JLabel lblKolorTa, lblKolorwiataKierunkowego, lblruby;
	private JButton btnZakocz;
	private JButton button_5;
	private JLabel lblPodoga;
	

	public wlasciwosciDialog(grafika g, configLoader cl) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(wlasciwosciDialog.class.getResource("/robot/ikony/tut.png")));
		setResizable(false);

		this.g = g;
		this.cl = cl;

		setTitle("W\u0142a\u015Bciwo\u015Bci");
		setBounds(900, 450, 560, 465);
		setVisible(false);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblKolorTa = new JLabel();
		lblKolorTa.setText("Kolor t\u0142a:");
		lblKolorTa.setBounds(30, 55, 76, 15);
		contentPanel.add(lblKolorTa);

		btnWybierz = new JButton("Wybierz");
		btnWybierz.setBackground(Color.LIGHT_GRAY);
		btnWybierz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color col = Color.black;
				Color c = JColorChooser.showDialog(null, "Wybór koloru", col);
				btnWybierz.setBackground(c);
				bC(c);
			}
		});
		btnWybierz.setBounds(30, 81, 90, 50);
		contentPanel.add(btnWybierz);

		lblKolorwiataKierunkowego = new JLabel(
				"Kolor \u015Bwiat\u0142a kierunkowego:");
		lblKolorwiataKierunkowego.setBounds(225, 61, 183, 15);
		contentPanel.add(lblKolorwiataKierunkowego);

		btnWybierz_2 = new JButton("Wybierz");
		btnWybierz_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color col = Color.black;
				Color c = JColorChooser.showDialog(null, "Wybór koloru", col);
				btnWybierz_2.setBackground(c);
				dC(c);
			}
		});
		btnWybierz_2.setBackground(Color.LIGHT_GRAY);
		btnWybierz_2.setBounds(225, 81, 90, 50);
		contentPanel.add(btnWybierz_2);
		

		btnZakocz = new JButton("Zako\u0144cz");
		btnZakocz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnZakocz.setBounds(425, 406, 90, 20);
		contentPanel.add(btnZakocz);
		
		lblruby  = new JLabel("\u015Aruby");
		lblruby.setBounds(30, 203, 62, 14);
		contentPanel.add(lblruby);
		
		JLabel lblCzony = new JLabel("Cz\u0142ony");
		lblCzony.setBounds(225, 203, 95, 14);
		contentPanel.add(lblCzony);
		
		JLabel lblPodstawa = new JLabel("Podstawa");
		lblPodstawa.setBounds(425, 203, 90, 14);
		contentPanel.add(lblPodstawa);
		
		button = new JButton("Wybierz");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Color col = Color.black;
				Color c = JColorChooser.showDialog(null, "Wybór koloru", col);
				button.setBackground(c);
				srubyC(c);
				
			}
		});
		button.setBackground(Color.LIGHT_GRAY);
		button.setBounds(30, 228, 90, 50);
		contentPanel.add(button);
		
		button_1 = new JButton("Wybierz");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color col = Color.black;
				Color c = JColorChooser.showDialog(null, "Wybór koloru", col);
				button_1.setBackground(c);
				czlonyC(c);
			}
		});
		button_1.setBackground(Color.LIGHT_GRAY);
		button_1.setBounds(225, 228, 90, 50);
		contentPanel.add(button_1);
		
		button_2 = new JButton("Wybierz");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color col = Color.black;
				Color c = JColorChooser.showDialog(null, "Wybór koloru", col);
				button_2.setBackground(c);
				podstawaC(c);
			}
		});
		button_2.setBackground(Color.LIGHT_GRAY);
		button_2.setBounds(425, 228, 90, 50);
		contentPanel.add(button_2);
		
		JLabel lblNewLabel = new JLabel("Chwytak");
		lblNewLabel.setBounds(30, 299, 90, 14);
		contentPanel.add(lblNewLabel);
		
		button_3 = new JButton("Wybierz");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color col = Color.black;
				Color c = JColorChooser.showDialog(null, "Wybór koloru", col);
				button_3.setBackground(c);
				chwytakC(c);
			}
		});
		button_3.setBackground(Color.LIGHT_GRAY);
		button_3.setBounds(30, 324, 90, 50);
		contentPanel.add(button_3);
		
		JLabel lblPrzeguby = new JLabel("Przeguby");
		lblPrzeguby.setBounds(225, 299, 90, 14);
		contentPanel.add(lblPrzeguby);
		
		button_4 = new JButton("Wybierz");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color col = Color.black;
				Color c = JColorChooser.showDialog(null, "Wybór koloru", col).darker();
				button_4.setBackground(c);
				przegubyC(c);
			}
		});
		button_4.setBackground(Color.LIGHT_GRAY);
		button_4.setBounds(225, 324, 90, 50);
		contentPanel.add(button_4);
		
		button_5 = new JButton("Wybierz");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color col = Color.black;
				Color c = JColorChooser.showDialog(null, "Wybór koloru", col).darker();
				button_5.setBackground(c);
				podlogaC(c);
			}
		});
		button_5.setBackground(Color.LIGHT_GRAY);
		button_5.setBounds(425, 324, 90, 50);
		contentPanel.add(button_5);
		
		lblPodoga = new JLabel("Pod\u0142oga");
		lblPodoga.setBounds(425, 299, 90, 14);
		contentPanel.add(lblPodoga);
		
		JLabel lblRobot = new JLabel("Robot");
		lblRobot.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblRobot.setBounds(10, 155, 121, 37);
		contentPanel.add(lblRobot);
		
		JLabel lblScena = new JLabel("Scena");
		lblScena.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblScena.setBounds(10, 7, 121, 37);
		contentPanel.add(lblScena);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(548, 137, -539, 20);
		contentPanel.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLACK);
		separator_1.setBounds(10, 142, 528, 15);
		contentPanel.add(separator_1);
		
		loadProp(cl, g);
		
	}

	@SuppressWarnings("static-access")
	private void loadProp(configLoader cl, grafika g) {

		btnWybierz.setBackground(cl.bgColorbtn());
		btnWybierz_2.setBackground(cl.dLightColorbtn());
		
		button.setBackground(cl.srubyColor());
		button_1.setBackground(cl.czlonyColor());
		button_2.setBackground(cl.podstawaColor());
		button_3.setBackground(cl.chwytakColor());
		button_4.setBackground(cl.przegubyColor());
		button_5.setBackground(cl.podlogaColor());
		
		cl.saveProp("dLight", "" + cl.dLightColorbtn().getRGB());
		cl.saveProp("aLight", "" + cl.aLightColorbtn().getRGB());
		cl.saveProp("srubyCol", "" + cl.srubyColor().getRGB());
		cl.saveProp("przegubyCol", "" + cl.przegubyColor().getRGB());
		cl.saveProp("podstawaCol", "" + cl.podstawaColor().getRGB());
		cl.saveProp("chwyatakCol", "" + cl.chwytakColor().getRGB());
		cl.saveProp("czlonyCol", "" + cl.czlonyColor().getRGB());
		cl.saveProp("czpodlogaCol", "" + cl.podlogaColor().getRGB());
	}

	// zmiany kolorów
	@SuppressWarnings("static-access")
	private void bC(Color c) {
		cl.saveProp("background", "" + c.getRGB());
		g.setBackground(new Color3f(c));
	}

	@SuppressWarnings("static-access")
	private void dC(Color c) {
		cl.saveProp("dLight", "" + c.getRGB());
		g.setdLight(new Color3f(c));
	}
	
	@SuppressWarnings({ "static-access", "unused" })
	private void aC(Color c) {
		cl.saveProp("aLight", "" + c.getRGB());
		g.setaLight(new Color3f(c));
	}
	
	@SuppressWarnings("static-access")
	private void przegubyC(Color c) {
		cl.saveProp("przegubyCol", "" + c.getRGB());
		g.setaLight(new Color3f(c));
		g.setPrzegubyColor(g.nameMap, c);
	}
	
	@SuppressWarnings("static-access")
	private void czlonyC(Color c) {
		cl.saveProp("czlonyCol", "" + c.getRGB());
		g.setaLight(new Color3f(c));
		g.setCzlonyColor(g.nameMap, c);
	}
	
	@SuppressWarnings("static-access")
	private void srubyC(Color c) {
		cl.saveProp("srubyCol", "" + c.getRGB());
		g.setaLight(new Color3f(c));
		g.setSrubyColor(g.nameMap, c);
	}
	@SuppressWarnings("static-access")
	private void podstawaC(Color c) {
		cl.saveProp("podstawaCol", "" + c.getRGB());
		g.setaLight(new Color3f(c));
		g.setPodstawaColor(g.nameMap, c);
	}
	@SuppressWarnings("static-access")
	private void chwytakC(Color c) {
		cl.saveProp("chwytakCol", "" + c.getRGB());
		g.setChwytakColor(g.nameMap, c);
	}
	@SuppressWarnings("static-access")
	private void podlogaC(Color c) {
		cl.saveProp("podlogaCol", "" + c.getRGB());
		g.setaLight(new Color3f(c));
		g.setPodlogaColor(g.nameMap, c);
	}
}
