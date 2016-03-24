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
public class CategoriesComboBoxModel extends DefaultComboBoxModel<Category>{

    ArrayList<Category> items;
    public CategoriesComboBoxModel(ArrayList<Category> items){
        this.items = items;
        setSelectedItem(items.get(0));
    }

    @Override
    public Category getElementAt(int index) {
        return items.get(index);
    }

    @Override
    public int getSize() {
        return items.size();
    }
    
}
