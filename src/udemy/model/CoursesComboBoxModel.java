/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udemy.model;

import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Tarek
 */
public class CoursesComboBoxModel extends DefaultComboBoxModel<Course>{

    ArrayList<Course> items;
    public CoursesComboBoxModel(ArrayList<Course> items){
        this.items = items;
        setSelectedItem(items.get(0));
    }

    @Override
    public Course getElementAt(int index) {
        return items.get(index);
    }

    @Override
    public int getSize() {
        return items.size();
    }
    
}
