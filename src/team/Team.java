/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package team;

import java.util.ArrayList;

/**
 *
 * @author Andreas & Michael
 */
public class Team {
    private String name, description;
    private ArrayList<Person> team = new ArrayList(); 
    
    public Team(){}
    
    public Team(String name, String description){
        //Vores første team constructor, bruges af create team knappen
        this.name = name;
        this.description = description;
    }
    public Team(String fromFile){
        //Vores team anden team constructor, der læser fra filen og opretter teams
        int sepSemicolonOne = fromFile.indexOf(";");
        int sepSemicolonTwo;
        name = fromFile.substring(0,sepSemicolonOne);
        System.out.println(name);
        int counter = 0;
        for( int i=0; i<fromFile.length(); i++ ) {
            if( fromFile.charAt(i) == ';' ) {
                counter++;
            } 
        }
        for (int i=0;i<(counter-1);i++){
            sepSemicolonTwo = fromFile.indexOf(";", (sepSemicolonOne+1));
            Person p = new Person(fromFile.substring((sepSemicolonOne+1), sepSemicolonTwo));
            System.out.println(p);
            team.add(i, p);
            sepSemicolonOne = sepSemicolonTwo;
        }
    }
    
    @Override
    public String toString(){
        return name;
    }
    public String toFullString(){
        //  Printer de personer der findes i arrayet, måske skal navn også printes med?
        String str = name + "\n\n";
        for (int i = 0; i<team.size();i++){
            str = str + team.get(i) + "\n";
        }
        return str;
    }
    public String toFile(){
        String str = name + ";";
        for (int i = 0; i<team.size();i++){
            str = str + team.get(i).toNoSpaceString() + ";";
        }
        return str;
    }
    public void removeAll(){
        team.clear();
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
