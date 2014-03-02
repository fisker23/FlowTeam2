/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package team;

import java.util.ArrayList;

/**
 *
 * @author Andreas Fisker
 */
public class Team {
    private String name, description;
    private ArrayList<Person> team = new ArrayList(); 
    //Det skal nok bare være et array i stedet for 4 persons, det kan vi ændre når vi ser på det
    
    public Team(){}
    
    public Team(String name, String description){
        //  Sådan som vores lo-fi virker lige skal man kun bruge team-navn og beskrivelse når man opretter teamet, personer bliver smidt ind senere
        this.name = name;
        this.description = description;
    }
    
    @Override
    public String toString(){
        //  Printer de personer der findes i arrayet, måske skal navn også printes med?
        String str = "";
        for (int i = 0; i<team.size();i++){
            str = str + team.get(i) + "\n";
        }
        return str;
    }
    
    public void addPerson(Person p1){
        team.add(p1);
    }
    
    public void removePerson(Person p1){
        team.remove(p1);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public ArrayList getTeam(){
        return team;
    }
}
