package com.example.mvc_dnd.DnD.Character;

public class Dice {
    private final static int NUMBERS = 3;

    public static int roll() {
        return (int) (1 + Math.round(Math.random() * 5));
    }

    public static int rollStat() {
        int[] nums = new int[6];
        int result = 0;

        for (int i = 0; i < nums.length; i++) {
            nums[i] = roll();
        }

        for (int i = 0; i < NUMBERS; i++) {
            int index = 0;
            int max = 0;
            for (int j = 0; j < nums.length; j++) {
                if (max < nums[j]) {
                    max = nums[j];
                    index = j;
                }
            }
            nums[index] = -1;
            result += max;
        }

        return result;
    }
}
