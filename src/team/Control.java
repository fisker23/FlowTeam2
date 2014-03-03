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
public class Control {
    
    ArrayList<Team> teamList;
    ArrayList<Person> personList;
    
    public Control(){
        teamList = new ArrayList();
        personList = new ArrayList();
    }
    public void addPerson(Person p){
        personList.add(p);
    }
    public void removePerson(int selected){
        personList.remove(selected);
    }
    public Person getPerson(int i){
        return personList.get(i);
    }
    public ArrayList<Team> getTeamList() {
        return teamList;
    }
    public ArrayList<Person> getPersonList() {
        return personList;
    }
}
