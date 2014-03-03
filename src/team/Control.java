/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package team;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Andreas Fisker
 */
public class Control {
    
    ArrayList<Team> teamList;
    ArrayList<Person> personList;
    Scanner scanFile;
    
    public Control(){
        teamList = new ArrayList();
        personList = new ArrayList();
        Team teamFromFile = new Team();
        
        try{
            scanFile = new Scanner(new File("names.txt"));
        }
        catch(FileNotFoundException e){
            System.out.println("FNF Error: " + e);
        }
        catch(Exception e){
            System.out.println("Error: " + e);
        }
        while(scanFile.hasNext()){
            String str = scanFile.nextLine();
            System.out.println(str);
            Person p = new Person(str);
            personList.add(p);
        }
    }
    public void createTeam(String name){
        Team team = new Team(name, "");
        teamList.add(team);
    }
    public void addPerson(Person p){
        personList.add(p);
    }
    public void removePerson(int selected){
        personList.remove(selected);
    }
    public void removeTeam(int selected){
        for(int i=0;i<teamList.get(selected).getTeam().size(); i++){
            Person p;
            p = new Person(teamList.get(selected).getTeam().get(i).toString());
            personList.add(p);
        }
        teamList.remove(selected);
    }
    public Person getPerson(int i){
        return personList.get(i);
    }
    public Team getTeam(int i){
        return teamList.get(i);
    }
    public ArrayList<Team> getTeamList() {
        return teamList;
    }
    public ArrayList<Person> getPersonList() {
        return personList;
    }
}
