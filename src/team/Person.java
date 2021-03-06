/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package team;

/**
 *
 * @author Andreas & Michael
 */
public class Person {
    //Her deklerer vi lidt attributter
    private String name;
    private int administrator, analyst, creative, finisher;
    
    public Person(String name, int admin, int analyst, int creative, int finisher){
    //Vores Person constructor
        this.name = name;
        this.administrator = admin;
        this.analyst = analyst;
        this.creative = creative;
        this.finisher = finisher;
    }
    public Person(String fromTextFile){
        //  finder komma seperatorene i String inputtet og bruger dem til at lave object af personen
        int sepName = fromTextFile.indexOf(",");
        int sepAdmin = fromTextFile.indexOf(",", (sepName+1));
        int sepAnalyst = fromTextFile.indexOf(",",(sepAdmin+1));
        int sepCreative = fromTextFile.indexOf(",", (sepAnalyst+1));
        this.name = fromTextFile.substring(0, sepName);
        this.administrator = Integer.parseInt(fromTextFile.substring((sepName+1), sepAdmin));
        this.analyst = Integer.parseInt(fromTextFile.substring((sepAdmin+1), sepAnalyst));
        this.creative = Integer.parseInt(fromTextFile.substring((sepAnalyst+1),sepCreative));
        this.finisher = Integer.parseInt(fromTextFile.substring((sepCreative+1)));
    }
    
//Igen lidt metoder der ikke kræver videre forklaring (kig navn)
    @Override
    public String toString(){
        String str;
        str = name + ", " + administrator + ", " + analyst + ", " + creative + ", " + finisher;
        return str;
    }
    public String toNoSpaceString(){
        String str;
        str = name + "," + administrator + "," + analyst + "," + creative + "," + finisher;
        return str;
    }

    public String getName() {
        return name;
    }

    public int getAdministrator() {
        return administrator;
    }

    public int getAnalyst() {
        return analyst;
    }

    public int getCreative() {
        return creative;
    }

    public int getFinisher() {
        return finisher;
    }
    
}
