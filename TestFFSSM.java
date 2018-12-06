/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FFSSM;

import static FFSSM.GroupeSanguin.APLUS;
import static FFSSM.GroupeSanguin.BPLUS;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Margaux
 */
public class TestFFSSM {

    public Club club;
    public Club club2;
    public Embauche embauche;
    public Embauche embauche2;
    //GroupeSanguin groupeSanguin;
    public Licence licence;
    public Moniteur moniteur;
    public Plongee plongee;
    public Plongeur plongeur;
    public Plongeur plongeur2;
    public Site site;
    public Calendar calendarE;
    public Calendar calendarL;
    public Calendar naissanceM;
    public Calendar naissanceP;
    public Calendar datePlongee;
    public Licence licence2;
    public Personne personne;
    public Calendar ddn;
    public Calendar delivrance;
    public Calendar delivrancefausse;
    public Calendar dateval;
    public HashSet<Plongee> plongees= new HashSet<>();

    @Before

    public void setUp() {
        Calendar ddn = Calendar.getInstance();
        Calendar delivrance = Calendar.getInstance();
        Calendar delivrancefausse =  Calendar.getInstance();
        Calendar dateval = Calendar.getInstance();
        dateval.set(2019,01,01);
        delivrancefausse.set(2015,11,20);
        delivrance.set(2018,11,17);
        ddn.set(1988, 11,2);
        Club club = new Club(moniteur, "castres", "0608090506");
        Licence licence2 = new Licence(moniteur, "002", delivrancefausse, 2, club);
        Licence licence = new Licence(plongeur, "001", delivrance, 2, club);
        Moniteur moniteur = new Moniteur("070809", "Sugner", "JP", "3 rue jaures", "0698786950", naissanceM, 3, APLUS, licence, 3);
        Site site = new Site("marseille", "RAD");
        Plongee plongee = new Plongee(site, moniteur, datePlongee, 500, 60);
        Plongeur plongeur = new Plongeur("346", "Bories", "Clothilde", "Rue mahuzies", "0675860987", naissanceP, 2, APLUS, licence2);
        Plongeur plongeur2 = new Plongeur("347", "Bilhac", "Flavie", "Rue mahuzies", "0675868908", naissanceP, 2, BPLUS, licence);
        Calendar calendarE = new GregorianCalendar(2013, 10, 23);
        Calendar calendarL = new GregorianCalendar(2013, 10, 26);
        Calendar naissanceM = new GregorianCalendar(1957, 11, 26);
        Calendar naissanceP = new GregorianCalendar(1997, 01, 12);
        Calendar datePlongee = new GregorianCalendar(2018, 10, 23);
        Personne personne = new Personne("070809", "Sugner","JP","3 rue jaures","0698786950",naissanceM );
        this.ddn=ddn;
        this.delivrance=delivrance;
        this.delivrancefausse=delivrancefausse;
        this.moniteur=moniteur;
        this.licence=licence;
        this.licence2=licence2;
        this.plongeur=plongeur;
        this.plongeur2=plongeur2;
        this.club=club;
        this.dateval=dateval;
        this.site=site;
        this.plongee=plongee;
        this.club2=club2;
        
    }

    @Test

    public void testLicence() {
        assertEquals(true,licence.estValide(dateval));
        assertEquals(false, licence2.estValide(dateval));

    }
   

    @Test
    
    public void testEmbauche(){
        embauche=new Embauche(delivrance,moniteur,club);
        embauche2=new Embauche(calendarL,moniteur,club);
        Calendar today= Calendar.getInstance();
        today.set(2018, 12,06);
        embauche.terminer(today);
        assertEquals(true,embauche.estTerminee());
        assertEquals(false,embauche2.estTerminee());
    }
    @Test
    
   public void testMoniteur(){
       assertEquals(null,moniteur.employeur());
       Calendar today= Calendar.getInstance();
       today.set(2018, 12,06);
       moniteur.nouvelleEmbauche(club, today);
       assertEquals(club,moniteur.employeur());
   }
   
   @Test
   
   public void ajoutPlongeur(){
       plongee.ajouteParticipant(moniteur);
       assertEquals(1,plongee.pl.size());
       
   }
  

}
