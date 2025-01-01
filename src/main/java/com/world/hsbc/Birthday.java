package com.world.hsbc;

import java.util.ArrayList;
import java.util.List;

public class Birthday {

    void backtrack(List<Integer[]> friends,
            int friendIndex, int choiceIndex,
            List<Integer> current,
            List<List<Integer>> result) {

        System.out.printf("friendIndex=%d, choiceIndex=%d\n", friendIndex, choiceIndex);

        if (friendIndex >= friends.size()) {
            List<Integer> al = new ArrayList<>(current);
            result.add(al);
            return;
        } // if

        Integer[] choices = friends.get(friendIndex);

        for (int j = choiceIndex; j < choices.length; ++j) {
            int choice = choices[j];
            if (!current.contains(choice)) {
                current.add(choice);
                int nextFriendIndex = friendIndex;
                int nextChoiceIndex = j + 1;
                if (j == choices.length - 1) {
                    nextFriendIndex = friendIndex + 1;
                    nextChoiceIndex = 0;
                }
                backtrack(friends, nextFriendIndex, nextChoiceIndex, current, result);
                current.remove(current.size() - 1);
            } // if
        } // for
    }

    public void test_Birthday_backtrack() {

        List<Integer[]> friends = List.of(new Integer[] { 1, 2, 3 }, new Integer[] { 2 }, new Integer[] { 1 });
        List<Integer> current = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        backtrack(friends, 0, 0, current, result);

        int max = 0;

        for (int i = 0; i < result.size(); ++i) {
            max = Math.max(result.get(i).size(), max);
        }

        System.out.printf("max = %d\n", max);

    }

    public static void test_main_Birthday() {
        Birthday birthday = new Birthday();
        birthday.test_Birthday_backtrack();
    }

}
