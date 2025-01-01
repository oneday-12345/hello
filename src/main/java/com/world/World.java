package com.world;

import com.world.hsbc.Birthday;

public class World {

    public static void main(String[] args) {
        World world = new World();
        System.out.println("----------begin----------");
        world.run(args);
        System.out.println("----------end----------");

    }

    private void run(String[] args) {
        // AlternativeSort.test_main_AlternativeSort();
        Birthday.test_main_Birthday();
    }

}
