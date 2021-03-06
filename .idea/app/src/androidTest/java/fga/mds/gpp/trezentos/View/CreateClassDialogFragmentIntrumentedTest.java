package fga.mds.gpp.trezentos.View;

import android.support.test.rule.ActivityTestRule;

import junit.framework.Assert;

import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import fga.mds.gpp.trezentos.Exception.UserException;
import fga.mds.gpp.trezentos.R;
import fga.mds.gpp.trezentos.View.LoginActivity;

import static android.support.test.espresso.Espresso.closeSoftKeyboard;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasErrorText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static fga.mds.gpp.trezentos.R.id.classname;
import static fga.mds.gpp.trezentos.R.id.frame;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(JUnit4.class)
public class CreateClassDialogFragmentIntrumentedTest  {

    @Rule
    public ActivityTestRule<MainActivity> rule = new ActivityTestRule<>(MainActivity.class);
    public CreateClassDialogFragment fragmentTest = new CreateClassDialogFragment();


    @Test
    public void shouldAssertNotNullActivity(){
        onView(withId(R.id.salas_item))
                .perform(click());

        assertNotNull(rule);
    }

    @Test
    public void shouldAssertNotNullClassFragment(){
        onView(withId(R.id.salas_item))
                .perform(click());

        assertNotNull(rule.getActivity().getSupportFragmentManager().findFragmentById(frame));
    }

    @Test
    public void shouldStartClassDialog(){
        onView(withId(R.id.salas_item))
                .perform(click());
        onView(withId(R.id.class_image_button))
                .perform(click());
        assertNotNull(rule.getActivity().getSupportFragmentManager().findFragmentByTag("dialog"));

    }

    @Test
    public void shouldValidateNullClassName() throws UserException{

        onView(withId(R.id.salas_item))
                .perform(click());
        onView(withId(R.id.class_image_button))
                .perform(click());

        onView(withId(R.id.classname))
                .perform(typeText(""));
        closeSoftKeyboard();
        onView(withId(R.id.institution))
                .perform(typeText("UnB"));
        closeSoftKeyboard();
        onView(withId(R.id.password))
                .perform(typeText("Senha1"));
        closeSoftKeyboard();
        onView(withId(R.id.cutoff))
                .perform(typeText(String.valueOf(4.5)));
        closeSoftKeyboard();
        onView(withId(R.id.sizegroups))
                .perform(typeText(String.valueOf(5)));
        closeSoftKeyboard();
        onView(withId(R.id.addition))
                .perform(typeText(String.valueOf(0.5)));
        closeSoftKeyboard();


        onView(withId(R.id.ok_create_button))
                .perform(click());

        onView(withId(R.id.classname)).check(matches(hasErrorText("Preencha todos os campos!")));
    }


    @Test
    public void shouldValidateNullPassword() throws UserException{

        onView(withId(R.id.salas_item))
                .perform(click());
        onView(withId(R.id.class_image_button))
                .perform(click());

        onView(withId(R.id.classname))
                .perform(typeText("Calculo 1"));
        closeSoftKeyboard();
        onView(withId(R.id.institution))
                .perform(typeText("UnB"));
        closeSoftKeyboard();
        onView(withId(R.id.password))
                .perform(typeText(""));
        closeSoftKeyboard();
        onView(withId(R.id.cutoff))
                .perform(typeText(String.valueOf(4.5)));
        closeSoftKeyboard();
        onView(withId(R.id.sizegroups))
                .perform(typeText(String.valueOf(5)));
        closeSoftKeyboard();
        onView(withId(R.id.addition))
                .perform(typeText(String.valueOf(0.5)));
        closeSoftKeyboard();


        onView(withId(R.id.ok_create_button))
                .perform(click());

        onView(withId(R.id.classname)).check(matches(hasErrorText("Preencha todos os campos!")));
    }

    @Test
    public void shouldValidateNullCutOff() throws UserException{

        onView(withId(R.id.salas_item))
                .perform(click());
        onView(withId(R.id.class_image_button))
                .perform(click());

        onView(withId(R.id.classname))
                .perform(typeText("Calculo 1"));
        closeSoftKeyboard();
        onView(withId(R.id.institution))
                .perform(typeText("UnB"));
        closeSoftKeyboard();
        onView(withId(R.id.password))
                .perform(typeText("Senha1"));
        closeSoftKeyboard();
        onView(withId(R.id.cutoff))
                .perform(typeText(""));
        closeSoftKeyboard();
        onView(withId(R.id.sizegroups))
                .perform(typeText(String.valueOf(5)));
        closeSoftKeyboard();
        onView(withId(R.id.addition))
                .perform(typeText(String.valueOf(0.5)));
        closeSoftKeyboard();


        onView(withId(R.id.ok_create_button))
                .perform(click());

        onView(withId(R.id.classname)).check(matches(hasErrorText("Preencha todos os campos!")));
    }

    @Test
    public void shouldValidateNullSizeGroup() throws UserException{

        onView(withId(R.id.salas_item))
                .perform(click());
        onView(withId(R.id.class_image_button))
                .perform(click());

        onView(withId(R.id.classname))
                .perform(typeText("Calculo 1"));
        closeSoftKeyboard();
        onView(withId(R.id.institution))
                .perform(typeText("UnB"));
        closeSoftKeyboard();
        onView(withId(R.id.password))
                .perform(typeText("Senha1"));
        closeSoftKeyboard();
        onView(withId(R.id.cutoff))
                .perform(typeText(String.valueOf(4.5)));
        closeSoftKeyboard();
        onView(withId(R.id.sizegroups))
                .perform(typeText(""));
        closeSoftKeyboard();
        onView(withId(R.id.addition))
                .perform(typeText(String.valueOf(0.5)));
        closeSoftKeyboard();


        onView(withId(R.id.ok_create_button))
                .perform(click());

        onView(withId(R.id.classname)).check(matches(hasErrorText("Preencha todos os campos!")));
    }

    @Test
    public void shouldValidateNullAddition() throws UserException{

        onView(withId(R.id.salas_item))
                .perform(click());
        onView(withId(R.id.class_image_button))
                .perform(click());

        onView(withId(R.id.classname))
                .perform(typeText("Calculo 1"));
        closeSoftKeyboard();
        onView(withId(R.id.institution))
                .perform(typeText("UnB"));
        closeSoftKeyboard();
        onView(withId(R.id.password))
                .perform(typeText("Senha1"));
        closeSoftKeyboard();
        onView(withId(R.id.cutoff))
                .perform(typeText(String.valueOf(4.5)));
        closeSoftKeyboard();
        onView(withId(R.id.sizegroups))
                .perform(typeText(String.valueOf(5)));
        closeSoftKeyboard();
        onView(withId(R.id.addition))
                .perform(typeText(""));
        closeSoftKeyboard();


        onView(withId(R.id.ok_create_button))
                .perform(click());

        onView(withId(R.id.classname)).check(matches(hasErrorText("Preencha todos os campos!")));
    }


    @Test
    public void shouldValidateClassNameMinLength() throws UserException{

        onView(withId(R.id.salas_item))
                .perform(click());
        onView(withId(R.id.class_image_button))
                .perform(click());

        onView(withId(R.id.classname))
                .perform(typeText("DS"));
        closeSoftKeyboard();
        onView(withId(R.id.institution))
                .perform(typeText("UnB"));
        closeSoftKeyboard();
        onView(withId(R.id.password))
                .perform(typeText("Senha1"));
        closeSoftKeyboard();
        onView(withId(R.id.cutoff))
                .perform(typeText(String.valueOf(4.5)));
        closeSoftKeyboard();
        onView(withId(R.id.sizegroups))
                .perform(typeText(String.valueOf(5)));
        closeSoftKeyboard();
        onView(withId(R.id.addition))
                .perform(typeText(String.valueOf(0.5)));
        closeSoftKeyboard();


        onView(withId(R.id.ok_create_button))
                .perform(click());

        onView(withId(R.id.classname)).check(matches(
                        hasErrorText("O nome da sala deve ter de 3 a 20 caracteres.")));
    }

    @Test
    public void shouldValidateClassNameMaxLength() throws UserException{

        onView(withId(R.id.salas_item))
                .perform(click());
        onView(withId(R.id.class_image_button))
                .perform(click());

        onView(withId(R.id.classname))
                .perform(typeText("Metodo de Desenvolvimento de Software"));
        closeSoftKeyboard();
        onView(withId(R.id.institution))
                .perform(typeText("UnB"));
        closeSoftKeyboard();
        onView(withId(R.id.password))
                .perform(typeText("Senha1"));
        closeSoftKeyboard();
        onView(withId(R.id.cutoff))
                .perform(typeText(String.valueOf(4.5)));
        closeSoftKeyboard();
        onView(withId(R.id.sizegroups))
                .perform(typeText(String.valueOf(5)));
        closeSoftKeyboard();
        onView(withId(R.id.addition))
                .perform(typeText(String.valueOf(0.5)));
        closeSoftKeyboard();


        onView(withId(R.id.ok_create_button))
                .perform(click());

        onView(withId(R.id.classname)).check(matches(
                hasErrorText("O nome da sala deve ter de 3 a 20 caracteres.")));
    }

    @Test
    public void shouldValidateInstitutionMinLength() throws UserException{

        onView(withId(R.id.salas_item))
                .perform(click());
        onView(withId(R.id.class_image_button))
                .perform(click());

        onView(withId(R.id.classname))
                .perform(typeText("MDS"));
        closeSoftKeyboard();
        onView(withId(R.id.institution))
                .perform(typeText("IF"));
        closeSoftKeyboard();
        onView(withId(R.id.password))
                .perform(typeText("Senha1"));
        closeSoftKeyboard();
        onView(withId(R.id.cutoff))
                .perform(typeText(String.valueOf(4.5)));
        closeSoftKeyboard();
        onView(withId(R.id.sizegroups))
                .perform(typeText(String.valueOf(5)));
        closeSoftKeyboard();
        onView(withId(R.id.addition))
                .perform(typeText(String.valueOf(0.5)));
        closeSoftKeyboard();


        onView(withId(R.id.ok_create_button))
                .perform(click());

        onView(withId(R.id.institution)).check(matches(
                hasErrorText("O nome da instituicao deve ter de 3 a 20 caracteres.")));
    }


    @Test
    public void shouldValidateInstitutionMaxLength() throws UserException{

        onView(withId(R.id.salas_item))
                .perform(click());
        onView(withId(R.id.class_image_button))
                .perform(click());

        onView(withId(R.id.classname))
                .perform(typeText("MDS"));
        closeSoftKeyboard();
        onView(withId(R.id.institution))
                .perform(typeText("Universidade de Brasilia"));
        closeSoftKeyboard();
        onView(withId(R.id.password))
                .perform(typeText("Senha1"));
        closeSoftKeyboard();
        onView(withId(R.id.cutoff))
                .perform(typeText(String.valueOf(4.5)));
        closeSoftKeyboard();
        onView(withId(R.id.sizegroups))
                .perform(typeText(String.valueOf(5)));
        closeSoftKeyboard();
        onView(withId(R.id.addition))
                .perform(typeText(String.valueOf(0.5)));
        closeSoftKeyboard();


        onView(withId(R.id.ok_create_button))
                .perform(click());

        onView(withId(R.id.institution)).check(matches(
                hasErrorText("O nome da instituicao deve ter de 3 a 20 caracteres.")));
    }

    @Test
    public void shouldValidatePasswordMinLength() throws UserException{

        onView(withId(R.id.salas_item))
                .perform(click());
        onView(withId(R.id.class_image_button))
                .perform(click());

        onView(withId(R.id.classname))
                .perform(typeText("MDS"));
        closeSoftKeyboard();
        onView(withId(R.id.institution))
                .perform(typeText("UnB"));
        closeSoftKeyboard();
        onView(withId(R.id.password))
                .perform(typeText("Senha"));
        closeSoftKeyboard();
        onView(withId(R.id.cutoff))
                .perform(typeText(String.valueOf(4.5)));
        closeSoftKeyboard();
        onView(withId(R.id.sizegroups))
                .perform(typeText(String.valueOf(5)));
        closeSoftKeyboard();
        onView(withId(R.id.addition))
                .perform(typeText(String.valueOf(0.5)));
        closeSoftKeyboard();


        onView(withId(R.id.ok_create_button))
                .perform(click());

        onView(withId(R.id.password)).check(matches(
                hasErrorText("A senha deve ter entre 6 e 16 caracteres")));
    }


    @Test
    public void shouldValidatePasswordMaxLength() throws UserException{

        onView(withId(R.id.salas_item))
                .perform(click());
        onView(withId(R.id.class_image_button))
                .perform(click());

        onView(withId(R.id.classname))
                .perform(typeText("MDS"));
        closeSoftKeyboard();
        onView(withId(R.id.institution))
                .perform(typeText("UnB"));
        closeSoftKeyboard();
        onView(withId(R.id.password))
                .perform(typeText("Esqueciminhasenha"));
        closeSoftKeyboard();
        onView(withId(R.id.cutoff))
                .perform(typeText(String.valueOf(4.5)));
        closeSoftKeyboard();
        onView(withId(R.id.sizegroups))
                .perform(typeText(String.valueOf(5)));
        closeSoftKeyboard();
        onView(withId(R.id.addition))
                .perform(typeText(String.valueOf(0.5)));
        closeSoftKeyboard();


        onView(withId(R.id.ok_create_button))
                .perform(click());

        onView(withId(R.id.password)).check(matches(
                hasErrorText("A senha deve ter entre 6 e 16 caracteres")));
    }

   @Test
    public void shouldValidateZeroCutOff() throws UserException{

        onView(withId(R.id.salas_item))
                .perform(click());
        onView(withId(R.id.class_image_button))
                .perform(click());

        onView(withId(R.id.classname))
                .perform(typeText("Calculo 1"));
        closeSoftKeyboard();
        onView(withId(R.id.password))
                .perform(typeText("Senha1"));
        closeSoftKeyboard();
        onView(withId(R.id.cutoff))
                .perform(typeText(String.valueOf(0)));
        closeSoftKeyboard();
        onView(withId(R.id.sizegroups))
                .perform(typeText(String.valueOf(5)));
        closeSoftKeyboard();
        onView(withId(R.id.addition))
                .perform(typeText(String.valueOf(0.5)));
        closeSoftKeyboard();


        onView(withId(R.id.ok_create_button))
                .perform(click());

        onView(withId(R.id.cutoff)).check(matches(hasErrorText("A nota de corte nao pode ser zero.")));
    }

    @Test
    public void shouldValidateZeroSizeGroups() throws UserException{

        onView(withId(R.id.salas_item))
                .perform(click());
        onView(withId(R.id.class_image_button))
                .perform(click());

        onView(withId(R.id.classname))
                .perform(typeText("Calculo 1"));
        closeSoftKeyboard();
        onView(withId(R.id.password))
                .perform(typeText("Senha1"));
        closeSoftKeyboard();
        onView(withId(R.id.cutoff))
                .perform(typeText(String.valueOf(4.5)));
        closeSoftKeyboard();
        onView(withId(R.id.sizegroups))
                .perform(typeText(String.valueOf(0)));
        closeSoftKeyboard();
        onView(withId(R.id.addition))
                .perform(typeText(String.valueOf(0.5)));
        closeSoftKeyboard();


        onView(withId(R.id.ok_create_button))
                .perform(click());

        onView(withId(R.id.sizegroups)).check(matches
                    (hasErrorText("O tamanho do grupo nao pode ser zero.")));
    }

    @Test
    public void shouldValidateZeroAddition() throws UserException{

        onView(withId(R.id.salas_item))
                .perform(click());
        onView(withId(R.id.class_image_button))
                .perform(click());

        onView(withId(R.id.classname))
                .perform(typeText("Calculo 1"));
        closeSoftKeyboard();
        onView(withId(R.id.password))
                .perform(typeText("Senha1"));
        closeSoftKeyboard();
        onView(withId(R.id.cutoff))
                .perform(typeText(String.valueOf(4.5)));
        closeSoftKeyboard();
        onView(withId(R.id.sizegroups))
                .perform(typeText(String.valueOf(5)));
        closeSoftKeyboard();
        onView(withId(R.id.addition))
                .perform(typeText(String.valueOf(0)));
        closeSoftKeyboard();


        onView(withId(R.id.ok_create_button))
                .perform(click());

        onView(withId(R.id.addition)).check(matches(hasErrorText("O acrescimo nao pode ser zero.")));
    }


}