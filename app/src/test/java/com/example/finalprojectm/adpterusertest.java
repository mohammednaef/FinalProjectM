package com.example.finalprojectm;

public class adpterusertest {

    // test statement

    onView(withId(R.id.textView_name_msg))            // withId(R.id.textView_name_msg) is a ViewMatcher
            .perform(click())               // click() is a ViewAction
            .check(matches(isDisplayed())); // matches(isDisplayed()) is a ViewAssertion

    // new test
    onView(withId(R.id.editText_message))
            .perform(click())
            .check(matches(not(isEnabled()));

}
