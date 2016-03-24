/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udemy.model;

/**
 *
 * @author Tarek
 */
public class Course {
    long id;
    String name;
    long instructorId;
    String instructorName;

    public Course(long id, String name, long instructorId) {
        this.id = id;
        this.name = name;
        this.instructorId = instructorId;
    }

    public Course(long id, String name, long instructorId, String instructorName) {
        this.id = id;
        this.name = name;
        this.instructorId = instructorId;
        this.instructorName = instructorName;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(long instructorId) {
        this.instructorId = instructorId;
    }

    @Override
    public String toString() {
        return name;
    }
    
    
    
    
}
