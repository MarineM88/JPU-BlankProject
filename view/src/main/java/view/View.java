package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.Enumeration;
import java.util.Hashtable;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class View{
	private Model md;

	private JFrame frame; // cadre de la vue

	private Dimension dim; // dimension pour le héro
	private ImageIcon iconHero, iconGolem, iconMasked, iconZombie, iconRedHorns;

	private JPanel modelPanel;

	private JLabel labelHero; // label pour l'icone du héro
	private Hashtable<Monster , JLabel> labelMonsters;

	public View(Model md) {
		this.md = md;
		this.labelMonsters = new Hashtable<Monster, JLabel>();
	}

	public JFrame getFrame() {
		return frame;
	}

	public void createMonsterLabel(Monster m, ImageIcon iconMonsters) {
		JLabel monsterLabel = new JLabel(iconMonsters);
		monsterLabel.setBounds(m.getX() , m.getY() , m.getWidth() , m.getHeight());
		modelPanel.add(monsterLabel);
		labelMonsters.put(m, monsterLabel);
	}

	public void init() { // initialisation de la vue
		//Frame
		frame = new JFrame("Lorann"); // construction de la fenêtre
		frame.getContentPane().setLayout(new BorderLayout());
		
		//Center Panel
		dim = new Dimension(Worldmap.MAP_WIDTH, Worldmap.MAP_HEIGHT);
		modelPanel = new JPanel(); 
		modelPanel.setMinimumSize(dim);
		modelPanel.setMaximumSize(dim);
		modelPanel.setSize(dim);
		frame.getContentPane().add(modelPanel, BorderLayout.CENTER);
		modelPanel.setLayout(null);
		modelPanel.setBackground(Color.BLACK);
		modelPanel.setVisible(true);
		
		//Icons
		iconHero = new ImageIcon(this.getClass().getResource("lorann_r.png")); // création de l'icone
		iconGolem = new ImageIcon(this.getClass().getResource("monster_1.png"));
		iconMasked = new ImageIcon(this.getClass().getResource("monster_4.png"));
		iconZombie = new ImageIcon(this.getClass().getResource("monster_2.png"));
		iconRedHorns = new ImageIcon(this.getClass().getResource("monster_3.png"));
		
		//The hero
		labelHero = new JLabel(iconHero);
		labelHero.setBounds(md.getHero().getX(), md.getHero().getY(), Worldmap.HERO_WIDTH, Worldmap.HERO_HEIGHT);
		modelPanel.add(labelHero);
				
		//The Monsters
				for (Monster m: md.getMonsters()) createMonsterLabel(m, iconGolem);
				
				frame.setSize(dim);
				frame.setMinimumSize(dim);
				frame.setMaximumSize(dim);
				frame.pack();
				frame.setVisible(true);
			}
			
			private void createMonsterLabels() {
				for (Monster m : md.getMonsters()) {
					if (!labelMonsters.containsKey(m)) createMonsterLabel(m, iconGolem);
		 		}
			}
			
			private void refreshLabelEntity(JLabel l ,Entity e) {
				l.setBounds(e.getX(), e.getY(), e.getWidth(), e.getHeight());
			}
			
			public void refresh() {
				createMonsterLabels();
				
				//Monsters
				Enumeration<Monster> em = labelMonsters.keys();
				while  (em.hasMoreElements()) {
					Monster m = em.nextElement();
					if (m.getIsAlive()) refreshLabelEntity(labelMonsters.get(m), m);
				}
			}

			public JLabel getLabelHero() {
				return labelHero;
			}

}
