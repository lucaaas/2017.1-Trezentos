package fga.mds.gpp.trezentos.Controller;


import org.junit.Test;

import fga.mds.gpp.trezentos.Exception.UserException;
import fga.mds.gpp.trezentos.Model.UserClass;

import static junit.framework.Assert.assertFalse;

public class UserClassControlUnitTest {

    public UserClassControl testUser;

    @Test
    public void ShouldValidateNullName()throws UserException {

        boolean isValid = false;
        UserClass userClass = new UserClass(null, "UnB", 4.5f, "Senha1", 1, 0.5f);


        try{

            testUser = new UserClassControl();
            testUser.validateInformation(userClass);
            isValid = true;

        } catch (UserException userException) {

            if(userException.getMessage().equals("Preencha todos os campos!")) {
                isValid = false;
            }
        }

        assertFalse(isValid);
    }


    @Test
    public void ShouldValidateNullInstitutionName()throws UserException{

        boolean isValid = false;
        UserClass userClass = new UserClass("Calculo 1", null, 4.5f, "Senha1", 1, 0.5f);


        try{

            testUser = new UserClassControl();
            testUser.validateInformation(userClass);
            isValid = true;

        } catch (UserException userException) {

            if(userException.getMessage().equals("Preencha todos os campos!")) {
                isValid = false;
            }
        }

        assertFalse(isValid);
    }


    @Test
    public void ShouldValidateNullCutOff()throws UserException{

        boolean isValid = false;
        UserClass userClass = new UserClass("Calculo 1", "UnB", 0, "Senha1", 1, 0.5f);


        try{

            testUser = new UserClassControl();
            testUser.validateInformation(userClass);
            isValid = true;

        } catch (UserException userException) {

            if(userException.getMessage().equals("Preencha todos os campos!")) {
                isValid = false;
            }
        }

        assertFalse(isValid);
    }

    @Test
    public void ShouldValidateNullClassPassword()throws UserException{

        boolean isValid = false;
        UserClass userClass = new UserClass("Calculo 1", "UnB", 4.5f, null, 1, 0.5f);


        try{

            testUser = new UserClassControl();
            testUser.validateInformation(userClass);
            isValid = true;

        } catch (UserException userException) {

            if(userException.getMessage().equals("Preencha todos os campos!")) {
                isValid = false;
            }
        }

        assertFalse(isValid);
    }


    @Test
    public void ShouldValidateAddition()throws UserException{

        boolean isValid = false;
        UserClass userClass = new UserClass("Calculo 1", "UnB", 4.5f, "Senha1", 1, 0);


        try{

            testUser = new UserClassControl();
            testUser.validateInformation(userClass);
            isValid = true;

        } catch (UserException userException) {

            if(userException.getMessage().equals("Preencha todos os campos!")) {
                isValid = false;
            }
        }

        assertFalse(isValid);
    }



    @Test
    public void ShouldValidateClassNameMaxLength()throws UserException{

        boolean isValid = false;
        UserClass userClass = new UserClass("Metodo De Desenvolvimento de Software", "UnB", 4.5f, "Senha1", 1, 0.5f);


        try{

            testUser = new UserClassControl();
            testUser.validateInformation(userClass);
            isValid = true;

        } catch (UserException userException) {

            if(userException.getMessage().equals("O nome deve ter de 3 a 20 caracteres.")) {
                isValid = false;
            }
        }

        assertFalse(isValid);
    }

    @Test
    public void ShouldValidateClassNameMinLength()throws UserException{

        boolean isValid = false;
        UserClass userClass = new UserClass("DS", "UnB", 4.5f, "Senha1", 1, 0.5f);


        try{

            testUser = new UserClassControl();
            testUser.validateInformation(userClass);
            isValid = true;

        } catch (UserException userException) {

            if(userException.getMessage().equals("O nome deve ter de 3 a 20 caracteres.")) {
                isValid = false;
            }
        }

        assertFalse(isValid);
    }

    @Test
    public void ShouldValidatePasswordMinLength()throws UserException{

        boolean isValid = false;
        UserClass userClass = new UserClass("MDS", "UnB", 4.5f, "Senha", 1, 0.5f);

        try{

            testUser = new UserClassControl();
            testUser.validateInformation(userClass);
            isValid = true;

        } catch (UserException userException) {

            if(userException.getMessage().equals("A senha deve ter de 6 a 16 caracteres.")) {

                isValid = false;
            }
        }

        assertFalse(isValid);
    }

    @Test
    public void ShouldValidatePasswordMaxLength()throws UserException{

        boolean isValid = false;
        UserClass userClass = new UserClass("MDS", "UnB", 4.5f, "Senha", 1, 0.5f);

        try{

            testUser = new UserClassControl();
            testUser.validateInformation(userClass);
            isValid = true;

        } catch (UserException userException) {

            if(userException.getMessage().equals("A senha deve ter de 6 a 16 caracteres.")) {

                isValid = false;
            }
        }

        assertFalse(isValid);
    }



}
