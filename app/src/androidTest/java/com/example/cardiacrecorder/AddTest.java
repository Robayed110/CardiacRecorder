package com.example.cardiacrecorder;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.cardiacrecorder.Add;
import com.example.cardiacrecorder.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static java.util.function.Predicate.not;

@RunWith(AndroidJUnit4.class)
public class AddTest {
    @Rule
    public ActivityScenarioRule<Add> activityRule = new ActivityScenarioRule<>(Add.class);

    private DatabaseReference mockDatabaseReference;

    @Before
    public void setUp() {
        // Create a mock database reference for testing
        mockDatabaseReference = FirebaseDatabase.getInstance().getReference("mockPressureData");
    }

    @Test
    public void testAddButton() {
        Espresso.onView(withId(R.id.sp1)).perform(typeText("120"));
        Espresso.onView(withId(R.id.dp1)).perform(typeText("80"));

        // Close the soft keyboard (if opened)
        Espresso.closeSoftKeyboard();

        // Perform click action on the add button
        Espresso.onView(withId(R.id.add2)).perform(click());

        // Verify if the success Toast message is displayed


    }

}