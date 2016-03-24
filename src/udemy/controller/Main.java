package udemy.controller;

import javax.swing.JComboBox;
import udemy.model.CategoriesComboBoxModel;
import udemy.model.Category;
import udemy.view.Login;

public class Main {
	public static void main(String[] args) throws BusinessException{
            JComboBox<Category>categorisComboBox = new JComboBox<Category>();
            categorisComboBox.setModel(new CategoriesComboBoxModel(Service.getAllCategories()));
            new Login().setVisible(true);
	}
}
