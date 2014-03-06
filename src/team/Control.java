/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package team;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andreas Fisker
 */
public class Control {
    
    private ArrayList<Team> teamList;
    private ArrayList<Person> personList;
    private Scanner scanFile;
    PrintWriter pwTeam;
    PrintWriter pwPersons;
    
    public Control(){
        teamList = new ArrayList();
        personList = new ArrayList();
        Team teamFromFile = new Team();
        
        //Loads persons from the names.txt file
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
        try{
            scanFile = new Scanner(new File("teams.txt"));
        }
        catch(FileNotFoundException e){
            System.out.println("FNF Error: " + e);
        }
        catch(Exception e){
            System.out.println("Error: " + e);
        }
        while(scanFile.hasNext()){
            String str = scanFile.nextLine();
            Team t = new Team(str);
            teamList.add(t);
        }
        
    }
    public void createTeam(String name){
        Team team = new Team(name, "");
        teamList.add(team);
        try{
            pwTeam = new PrintWriter("teams.txt");
        }
        catch(FileNotFoundException ex){
            System.out.println("Error opening file");
        }
        for(int i=0; i<teamList.size();i++){
            pwTeam.println(teamList.get(i).toFile());
        }
        
        pwTeam.close();
    }
    public void saveAll(){
        try{
            pwTeam = new PrintWriter("teams.txt");
        }
        catch(FileNotFoundException ex){
            System.out.println("Error opening file");
        }
        for(int i=0; i<teamList.size();i++){
            pwTeam.println(teamList.get(i).toFile());
        }
        
        pwTeam.close();
        
        try{
            pwPersons = new PrintWriter("names.txt");
        }
        catch(FileNotFoundException ex){
            System.out.println("Error opening file");
        }
        for(int i=0; i<personList.size();i++){
            pwPersons.println(personList.get(i).toNoSpaceString());
        }
        
        pwPersons.close();
    }
    public void addPerson(Person p){
        personList.add(p);
    }
    public void removePerson(int selected){
        personList.remove(selected);
    }
    public void removeFromTeam(int selectedTeam, Person p){
        teamList.get(selectedTeam).removePerson(p);
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
