/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Student.model;

/**
 *
 * @author ASOS
 */
public class studentModel {
    int id;
    String name;
    double grade;

     public studentModel(){
     }
    
    public studentModel(Integer id, String name, Double grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }
    
    
    
}
