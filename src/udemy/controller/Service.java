package udemy.controller;

import java.util.ArrayList;
import udemy.model.Category;
import udemy.model.Course;
import udemy.model.DBManager;
import udemy.model.User;

public class Service {

    public static ArrayList<Course> getEnrolledCoursesByUserId(Long userId) throws BusinessException {
       ArrayList<Course> courses = DBManager.getEnrolledCoursesByUserId(userId);
        if(! courses.isEmpty()){
           return courses;
       }else{
           throw new BusinessException("You have no courses yet");
       }
    }

    // private constructor to prevent instantiation of this class
    private Service() {

    }

    public static boolean addNewUser(String userName, String password, String repeatPassword, String firstName,
            String lastName, int gender, int type) throws BusinessException {
        // validate mandatory fields
        if (userName == null || userName.trim().isEmpty()) {
            throw new BusinessException("userName can NOT be empty");
        }
        if (password == null || password.trim().isEmpty()) {
            throw new BusinessException("Password can NOT be empty");
        }
        
        if (repeatPassword == null || repeatPassword.trim().isEmpty() || !repeatPassword.equals(password)) {
            throw new BusinessException("Password mismatch");
        }
        if (firstName == null || firstName.trim().isEmpty()) {
            throw new BusinessException("first name can NOT be empty");
        }
        if (lastName == null || lastName.trim().isEmpty()) {
            throw new BusinessException("Last name can NOT be empty");
        }
        if (gender < 0 || gender > 1) {
            throw new BusinessException("Gender can be only male or female");
        }
        if (type < 0 || type > 1) {
            throw new BusinessException("Type can be only student or teacher");
        }

        // validate userName is NOT taken before
        if (checkUserNameIfAvaialble(userName)) {
            return DBManager.addUser(userName, password, firstName, lastName, gender, type);
        } else {
            throw new BusinessException("username " + userName + " is already taken");
        }
    }

    public static User loginUser(String userName, String password) throws BusinessException {
        // validate mandatory fields
        if (userName == null || userName.trim().isEmpty()) {
            throw new BusinessException("userName can NOT be empty");
        }
        if (password == null || password.trim().isEmpty()) {
            throw new BusinessException("Password can NOT be empty");
        }

        User user = DBManager.loginUser(userName, password);
        if (user != null) {
            return user;
        } else {
            throw new BusinessException("invalid login information");
        }

    }

    public static ArrayList<Course> getAllCourses() {
        return DBManager.getAllCourses();
    }
    public static ArrayList<Category> getAllCategories() {
        return DBManager.getAllCategories();
    }

    public static boolean enrollCourse(long userId, long courseId ) throws BusinessException{
        if(checkUserEnrolledInCourse(userId, courseId)){
            return DBManager.enrollNewCourse(userId, courseId);
        }else{
            throw new BusinessException("You are already enrolled in this course");
        }
    }
    
    private static boolean checkUserEnrolledInCourse(long userId, long courseId){
        if(DBManager.getUserCourseId(userId, courseId) == -1)
            return true;
        else
            return false;
    }
    public static boolean addNewCourse(String courseName, long category, long userId) throws BusinessException {
        if (courseName == null || courseName.trim().isEmpty()) {
            throw new BusinessException("courseName can NOT be empty");
        }
        
        if (checkCourseIfAvaialbe(courseName, category)) {
            System.out.println("");
        } else {
            throw new BusinessException("There is already a course with name: " + courseName
                    + " and category " + category);
        }
        
        return DBManager.addCourse(courseName, category, userId);
    }

    private static boolean checkUserNameIfAvaialble(String userName) {

        long userId = DBManager.getUserId(userName);
        if (userId == -1) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean checkCourseIfAvaialbe(String courseName, long categoryId) {
        if(DBManager.getCourseId(courseName, categoryId) == -1)
            return true;
        else
            return false;
    }

}
