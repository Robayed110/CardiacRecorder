package com.example.cardiacrecorder;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.cardiacrecorder.Login;
import com.example.cardiacrecorder.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)

public class LoginActivityTest {
    @Rule
    public ActivityScenarioRule<Login> activityRule = new ActivityScenarioRule<>(Login.class);

    @Test
    public void testLoginButton() {
        // Perform actions: type text in EditText fields and click the login button
        Espresso.onView(ViewMatchers.withId(R.id.username)).perform(typeText("testuser"));
        Espresso.onView(ViewMatchers.withId(R.id.Contact)).perform(typeText("01352468956"));
        Espresso.onView(ViewMatchers.withId(R.id.password)).perform(typeText("password"));
        Espresso.onView(ViewMatchers.withId(R.id.login)).perform(click());

        // Verify if the next activity is launched (replace NextActivity.class with your actual next activity)
       //Espresso.onView(withId(R.id.main_activity)).check(matches(isDisplayed()));
    }

    @Test
    public void testForgotPasswordLink() {
        // Perform click action on the forgot password link
        Espresso.onView(ViewMatchers.withId(R.id.fgtpassword)).perform(click());

        // Verify if the forgot password activity is launched (replace ForgotPasswordActivity.class with your actual activity)
       // Espresso.onView(withId(R.id.forgot_password_layout)).check(matches(isDisplayed()));
    }

    @Test
    public void testSignUpButton() {
        // Perform click action on the sign up button
        Espresso.onView(ViewMatchers.withId(R.id.signup)).perform(click());

        // Verify if the sign up activity is launched (replace SignUpActivity.class with your actual activity)
       // Espresso.onView(withId(R.id.sign_up_layout)).check(matches(isDisplayed()));
    }
}
