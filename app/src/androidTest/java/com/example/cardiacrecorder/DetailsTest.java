package com.example.cardiacrecorder;

import static androidx.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;
import static java.util.regex.Pattern.matches;

import android.view.View;
import androidx.test.espresso.ViewAssertion;

import org.hamcrest.Matcher;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.ViewAssertion;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import static androidx.test.espresso.assertion.ViewAssertions.matches;


import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;

public class DetailsTest {

    @Rule
    public ActivityScenarioRule<Details> activityRule = new ActivityScenarioRule<>(Details.class);

    @Test
    public void testDisplayedData() {
        Espresso.onView(withId(R.id.systolic1)).check(matches(isCompletelyDisplayed()));
       // Espresso.onView(withId(R.id.systolic1)).check(matches(isDisplayed()));
//        Espresso.onView(withId(R.id.diastolic1)).check(matches(isDisplayed()));
//        Espresso.onView(withId(R.id.date1)).check(matches(isDisplayed()));
//        Espresso.onView(withId(R.id.time1)).check(matches(isDisplayed()));
//        Espresso.onView(withId(R.id.comment)).check(matches(isDisplayed()));
//        Espresso.onView(withId(R.id.button)).check(matches(isDisplayed()));
//        Espresso.onView(withId(R.id.delete1)).check(matches(isDisplayed()));
    }


//    public static ViewAssertion matches(final Matcher<View> matcher) {
//        return (view, noViewFoundException) -> {
//            if (!matcher.matches(view)) {
//                throw new AssertionError("View assertion failed: " + matcher.toString());
//            }
//        };
//    }

//    @Test
//    public void testCommentText() {
//        Espresso.onView(withId(R.id.comment)).check(matches(withText("Good Health.")));
//    }
}