package com.acme.a3csci3130;

import org.junit.Rule;
import android.support.test.runner.AndroidJUnit4;
import org.junit.Test;
import org.junit.runner.RunWith;
import android.support.test.rule.ActivityTestRule;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.hasToString;
import static org.hamcrest.Matchers.startsWith;
import static org.junit.matchers.JUnitMatchers.*;
import static org.hamcrest.Matchers.anything;


@RunWith(AndroidJUnit4.class)

public class CRUDInstrumentedTest {
    @Rule
    //Access the main activity
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule(MainActivity.class);

    @Test
    /**
     * Tests to create, read, update, and delete data.
     *
     */
    public void clickCreateBusinessTest() {
        onView(withId(R.id.submitButton)).perform(click());
        onView(withId(R.id.businessname)).check(matches(withText("")));
        createTest();
        readTest();
        updateTest();
        deleteTest();
    }

    public void createTest() {
        onView(withId(R.id.businessname)).perform(click());
        onView(withId(R.id.businessname)).perform(typeText("Jackson's New Fishing Business"));
        onView(withId(R.id.businessnumber)).perform(click());
        onView(withId(R.id.businessnumber)).perform(typeText("887766552"));
        onView(withId(R.id.businesstype)).perform(click());
        onData(allOf(is(instanceOf(String.class)))).atPosition(2).perform(click());
        onView(withId(R.id.businessaddress)).perform(click());
        onView(withId(R.id.businessaddress)).perform(typeText("567 Sycamore Lane"));
        onView(withId(R.id.businessprovince)).perform(click());
        onData(allOf(is(instanceOf(String.class)))).atPosition(5).perform(click());
        onView(withId(R.id.submitButton)).perform(click());
    }

    public void readTest() {
        onData(anything()).inAdapterView(withId(R.id.listView)).atPosition(0).perform(click());
    }

    public void updateTest() {
        onView(withId(R.id.businessname)).perform(click());
        onView(withId(R.id.businessname)).perform(typeText("Jackson's Second Fishing Business"));
        onView(withId(R.id.updateButton)).perform(click());
    }

    public void deleteTest() {
        onData(anything()).inAdapterView(withId(R.id.listView)).atPosition(0).perform(click());
        onView(withId(R.id.deleteButton)).perform(click());
    }
}
