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
    public Team(String fromFile){
        /*
        int sepName = fromTextFile.indexOf(",");
        int sepAdmin = fromTextFile.indexOf(",", (sepName+1));
        int sepAnalyst = fromTextFile.indexOf(",",(sepAdmin+1));
        int sepCreative = fromTextFile.indexOf(",", (sepAnalyst+1));
        this.name = fromTextFile.substring(0, sepName);
        this.administrator = Integer.parseInt(fromTextFile.substring((sepName+1), sepAdmin));
        this.analyst = Integer.parseInt(fromTextFile.substring((sepAdmin+1), sepAnalyst));
        this.creative = Integer.parseInt(fromTextFile.substring((sepAnalyst+1),sepCreative));
        this.finisher = Integer.parseInt(fromTextFile.substring((sepCreative+1)));
        */
        
        int sepSemicolonOne = fromFile.indexOf(";");
        System.out.println(sepSemicolonOne);
        int sepSemicolonTwo;
        name = fromFile.substring(0,sepSemicolonOne);
        System.out.println(name);
        int counter = 0;
        for( int i=0; i<fromFile.length(); i++ ) {
            if( fromFile.charAt(i) == '$' ) {
                counter++;
            } 
        }
        for (int i=0;i<(counter-1);i++){
            sepSemicolonTwo = fromFile.indexOf(";", (sepSemicolonOne+1));
            System.out.println(sepSemicolonTwo);
            Person p = new Person(fromFile.substring((sepSemicolonOne+1), sepSemicolonTwo));
            System.out.println(p);
            team.add(p);
            sepSemicolonOne = sepSemicolonTwo;
        }
    }
    
    @Override
    public String toString(){
        //  Printer de personer der findes i arrayet, måske skal navn også printes med?
        
        return name;
    }
    public String toFile(){
        String str = name + ";";
        for (int i = 0; i<team.size();i++){
            str = str + team.get(i) + ";";
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
    public Person getPerson(int i){
        return team.get(i);
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
