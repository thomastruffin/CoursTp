package data.bo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cours")
public class CoursBo {
@Id @GeneratedValue(strategy = GenerationType.AUTO)
private int ID;
private String nom;

public int getID() {
	return ID;
}
public void setID(int iD) {
	ID = iD;
}
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
 
}
