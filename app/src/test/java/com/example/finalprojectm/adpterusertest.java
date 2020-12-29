package com.example.finalprojectm;

import android.os.Build;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;

import java.util.List;
import java.util.stream.Collectors;

public class adpterusertest {
    @Mock
    AdapterUser adapterUser;

    @Test
    // test statement

    onView(withId(R.id.textView_name_msg))            // withId(R.id.textView_name_msg) is a ViewMatcher
            .perform(click())               // click() is a ViewAction
            .check(matches(isDisplayed())); // matches(isDisplayed()) is a ViewAssertion
    @Test
    // new test
    onView(withId(R.id.editText_message))
            .perform(click())
            .check(matches(not(isEnabled()));

    @Test
    public void Validmsg ()throws Exception{
        if (strSearch.length() == 0){
            userList.clear();
            userList.addAll(origenlusers);
    }
        @Test
        if (i.getFullName().toLowerCase().contains(strSearch)){
            userList.add(i);
        @Test
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            List<User> collect=   origenlusers.stream()
                    .filter(i->i.getFullName().toLowerCase().contains(strSearch))
                    .collect(Collectors.toList());
            userList.addAll(collect);

}
