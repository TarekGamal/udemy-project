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
public enum UsersTypesEnum {
    //private int type;// 0:student, 1:teacher
    STUDENT(0),
    TEACHER(1);
    
    int code;
    UsersTypesEnum(int code){
        this.code = code;
    }
    
    public void setCode(int code){
        this.code = code;
    }
    public int getCode(){
        return code;
    }
}
