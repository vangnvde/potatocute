/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import dao.DAO;

/**
 *
 * @author tinqu
 */
public class UserCRUDValidator extends DAO {
    String usernameError;
    String passwordError;


    public UserCRUDValidator() {
        this.usernameError = "";
        this.passwordError = "";
    }

    public String getUsernameError() {
        return usernameError;
    }

    public String getPasswordError() {
        return passwordError;
    }

    public void setUsernameError(String usernameError) {
        this.usernameError = usernameError;
    }

    public void setPasswordError(String passwordError) {
        this.passwordError = passwordError;
    }
    
    public void checkUsernameExist( String currentUsername, String username ){
        if( !currentUsername.equals(username) && isUsernameExist(username) ){
            setUsernameError("Username @"+username+" đã tồn tại. Xin chọn Username khác!");
        }
    }
    
    public boolean hasError(){
        return !(usernameError.isEmpty() && passwordError.isEmpty());
    }
    
}
