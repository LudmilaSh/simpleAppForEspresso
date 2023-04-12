package ru.kkuzmichev.simpleappforespresso;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.appcompat.widget.AppCompatImageButton;
import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class IdlingTest2 {

    @Rule
    public ActivityScenarioRule<MainActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void idlingTest2() {
        ViewInteraction appCompatImageButton = onView(isAssignableFrom(AppCompatImageButton.class));
        appCompatImageButton.check(matches(isDisplayed()));
        appCompatImageButton.perform(click());

        ViewInteraction navigationMenuItemView = onView(withId(R.id.nav_gallery));
        navigationMenuItemView.check(matches(isDisplayed()));
        navigationMenuItemView.perform(click());

        ViewInteraction textView = onView(allOf(withId(R.id.item_number), withText("7")));
        textView.check(matches(withText("7")));
    }

    @Test
    public void testRecyclerView() {
        ViewInteraction appCompatImageButton = onView(isAssignableFrom(AppCompatImageButton.class));
        appCompatImageButton.check(matches(isDisplayed()));
        appCompatImageButton.perform(click());

        ViewInteraction navigationMenuItemView = onView(withId(R.id.nav_gallery));
        navigationMenuItemView.check(matches(isDisplayed()));
        navigationMenuItemView.perform(click());

        ViewInteraction recyclerView = onView(withId(R.id.recycle_view));
        recyclerView.check(matches(isDisplayed()));
        recyclerView.check(CustomViewAssertions.isRecyclerView());
        recyclerView.check(matches(CustomViewMatcher.recyclerViewSizeMatcher(10)));
    }

};


