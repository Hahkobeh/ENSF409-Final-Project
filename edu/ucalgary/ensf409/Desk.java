package edu.ucalgary.ensf409;

public class Desk extends FurnitureItem {
    private char legs;
    private char top;
    private char drawer;

    public Desk(){
        
    }
    public char getLegs(){
        return this.legs;
    }
    public char getTop(){
        return this.top;
    }
    public char getDrawer(){
        return this.drawer;
    }
    public void setLegs(char legs){
       this.legs = legs;
    }
    public void setTop(char top){
       this.top = top;
    }
    public void setDrawer(char drawer){
         this.drawer = drawer;
    }
    
}
