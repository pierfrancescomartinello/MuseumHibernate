package com.museum.MuseumHibernate.modal;

import java.util.ArrayList;
import com.museum.MuseumHibernate.modal.Visitor;

public class Sales {
	
	public Sales() {
		
	}
	
	private String visitorID;
	private ArrayList<Ticket> soldTickets;
	
	/*
	 * To implement in the next Scrum
	 * 	private ArrayList<Gadget> soldGadgets;
	 */
	
	//Getters and Setters Methods
	public ArrayList<Ticket> getSoldTickets() {
		return this.soldTickets;
	}
	
	public void addTicket(Ticket ticket){
		this.soldTickets.add(ticket);
	}
	
	public void removeTicket(Ticket ticket){
		this.soldTickets.remove(ticket);
	}
	
	/*public void removeGadget(Gadget gadget) {
		this.soldGadgets.remove(gadget);
	}*/
	

	public void setSoldTickets(ArrayList<Ticket> soldTickets) {
		this.soldTickets = soldTickets;
	}
	
	public void setVisitorID(String visitorID) {
		this.visitorID = visitorID;
	}

}
