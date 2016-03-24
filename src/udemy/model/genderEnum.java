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
public enum genderEnum {
    //private int type;// 0:student, 1:teacher
    MALE(0),
    FEMALE(1);
    
    int code;
    genderEnum(int code){
        this.code = code;
    }
    
    public void setCode(int code){
        this.code = code;
    }
    public int getCode(){
        return code;
    }
}
