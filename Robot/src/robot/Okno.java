package robot;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.media.j3d.Canvas3D;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import obliczenia.DenHa;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class Okno extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static private grafika grap;
	static private kontrolerDialog k;
	static private wlasciwosciDialog w;
	static private parametryDialog p;
	public static configLoader cl;
	private static prostaKin pk;
	//private static PredkosciPrzyspieszenia pp;
	static Okno frame;
	static DenHa dh;
	
	private JPanel contentPane;

	Canvas3D c3d;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cl = new configLoader();
					grap = new grafika(cl);
					pk = new prostaKin(null);
					//pp = new PredkosciPrzyspieszenia(cl.w2(),cl.w3(),cl.zv(),cl.poczAlfa(),cl.poczBeta(),cl.l2(),cl.l3(),cl.Z1());
					k = new kontrolerDialog(grap, cl,pk);
					w = new wlasciwosciDialog(grap, cl);
					p = new parametryDialog(grap, cl, k);
					dh = new DenHa();
					
					
					frame = new Okno();
					k.setVisible(true);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Okno() throws Exception {
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				Okno.class.getResource("/robot/ikony/glownaIkona.png")));
		setTitle("Robot");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 700);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnProgram = new JMenu("Program");
		menuBar.add(mnProgram);

		final String mess = "\n-Piotr \"Gunio\" Goniowski \n-Kamil \"Ludwiczek\" Walczak \n-Marcin \"Sanko\" Zubrzycki";
		JMenuItem mntmOProgramie = new JMenuItem("O  programie");
		mntmOProgramie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, mess);
			}
		});
		mnProgram.add(mntmOProgramie);

		JMenuItem mntmKoniec = new JMenuItem("Koniec");
		mntmKoniec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		mnProgram.add(mntmKoniec);

		JMenu mnObliczenia = new JMenu("Obliczenia");
		menuBar.add(mnObliczenia);

		JMenuItem mntmKinematykaProstadenavithartenberg = new JMenuItem(
				"Kinematyka prosta (Denavit-Hartenberg)");
		mntmKinematykaProstadenavithartenberg
				.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (!pk.isVisible())
							pk.setVisible(true);
						//setDH(dh.dh(k.gama,k.alfa-90 ,k.beta, k.l1, k.l2, k.l3, k.z));
					}
				});
		mnObliczenia.add(mntmKinematykaProstadenavithartenberg);

		JMenu mnRobot = new JMenu("Robot");
		menuBar.add(mnRobot);

		JMenuItem mntmKontroler = new JMenuItem("Kontroler");
		mntmKontroler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!k.isVisible())
					k.setVisible(true);
			}
		});
		mnRobot.add(mntmKontroler);

		JMenuItem mntmWaciwociRobota = new JMenuItem(
				"W\u0142a\u015Bciwo\u015Bci");
		mntmWaciwociRobota.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!w.isVisible())
					w.setVisible(true);
			}
		});
		mnRobot.add(mntmWaciwociRobota);

		JMenuItem mntmWaciwoci = new JMenuItem("Parametry robota");
		mntmWaciwoci.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!p.isVisible())
					p.setVisible(true);
			}
		});
		mnRobot.add(mntmWaciwoci);

		JMenuItem mntmResetuj = new JMenuItem("Resetuj");
		mntmResetuj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				k.loadProp(cl);
				k.loadStartProp(cl);
				p.loadProp(cl, grap);
				//pp.setVels(cl.w2(),cl.w3(),cl.zv(),cl.poczAlfa(),cl.poczBeta(),cl.l2(),cl.l3(),cl.Z1());
				
			}
		});
		mnRobot.add(mntmResetuj);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		contentPane.setLayout(new BorderLayout(0, 0));

		setContentPane(contentPane);

		c3d = grap.init3D();

		contentPane.add(c3d);
	}	
}
