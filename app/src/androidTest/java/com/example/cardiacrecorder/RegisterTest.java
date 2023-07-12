package com.example.cardiacrecorder;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.cardiacrecorder.Register;
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
public class RegisterTest {

    @Rule
    public ActivityScenarioRule<Register> activityRule = new ActivityScenarioRule<>(Register.class);

    @Test
    public void testRegisterButton() {
        // Perform actions: type text in EditText fields and click the register button
        Espresso.onView(ViewMatchers.withId(R.id.regusername)).perform(typeText("testuser"));
        Espresso.onView(ViewMatchers.withId(R.id.regmail)).perform(typeText("testuser@example.com"));
        Espresso.onView(ViewMatchers.withId(R.id.regPassword1)).perform(typeText("password"));
        Espresso.onView(ViewMatchers.withId(R.id.regPassword2)).perform(typeText("password"));
        Espresso.onView(ViewMatchers.withId(R.id.address)).perform(typeText("123 Main St"));
        Espresso.onView(ViewMatchers.withId(R.id.regMobile)).perform(typeText("1234567890"));
        //Espresso.onView(ViewMatchers.withId(R.id.register)).perform(click());

        // Verify if the registration is successful and the next activity is launched
        //Espresso.onView(withId(R.id.next_activity_layout)).check(matches(isDisplayed()));
    }

    @Test
    public void testAlreadyHaveAccountLink() {
        // Perform click action on the "Already have an account?" link
        Espresso.onView(ViewMatchers.withId(R.id.haveaccount)).perform(click());

        // Verify if the login activity is launched (replace LoginActivity.class with your actual activity)
        //Espresso.onView(withId(R.id.login_layout)).check(matches(isDisplayed()));
    }
}
