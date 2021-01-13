package com.museum.MuseumHibernate;

import javax.swing.*;
import java.awt.image.BufferedImage;

import java.io.IOException;

import com.museum.MuseumHibernate.queries.museumNavigation.ArtworkQueryHandler;
import com.museum.MuseumHibernate.model.Artwork;

public class Main {
	
	public static void show(BufferedImage image, BufferedImage miniature){
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JLabel label = new JLabel();
		JLabel miniatureLabel = new JLabel();
		ImageIcon imageIcon = new ImageIcon(image);
		ImageIcon miniatureIcon = new ImageIcon(miniature);
		label.setIcon(imageIcon);
		miniatureLabel.setIcon(miniatureIcon);
		
		panel.add(miniatureLabel);
		panel.add(label);
		
		frame.add(panel);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public static void main(String[] args) throws IOException{
		Artwork result = ArtworkQueryHandler.showImage(6);
		
		//show(result.image, result.miniature);
	}
}
