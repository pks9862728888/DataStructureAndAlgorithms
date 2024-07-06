package com.practice.programs.revise.medium.greedyalgorithms;

import java.util.Arrays;

public class UseWeaponToGetMaxRating {

    /**
     * Find max rating which can be achieved
     * Initially we start with power p, and rating 0
     * We can perform 2 operations,
     * Sell a weapon if rating > 0, rating -= 1, p += weaponPower
     * Use a weapon if p > weaponPoser, rating += 1, p -= weaponPower
     * TC: O(n log n), AS: O(1)
     * Input: 300 200 500 100, power = 200
     * Answer: 2
     * Use Weapons in this order :-
     * Use weapon with 100 value, Putin power will become 200-100 = 100 and rating becomes 1 (0+1=1).
     * Sell weapon with 500 value, Putin power will become 100+500 = 600 and rating becomes 0(as selling will decrease rating by 1).
     * Use weapon with 300 value, Putin power will become 600-300 = 300 and rating becomes 1.
     * Use weapon with 200 value, Putin power will become 300-200 = 100 and rating becomes 2.
     * Concept:
     * GREEDY_ALGORITHM
     * TWO_POINTER
     * TWO_POINTER_START_N_END_OF_ARRAY
     */
    static int weapons(int n,int p,int weapon[]){
        int maxRating = 0;
        int currRating = 0;
        Arrays.sort(weapon);
        int low = 0;
        int high = weapon.length - 1;
        while (low <= high) {
            int lowestWeaponPower = weapon[low];
            int highestWeaponPower = weapon[high];
            // Greedy approach
            if (p >= lowestWeaponPower) { // try to use the weapon having lowest power if possible
                currRating++;
                p -= lowestWeaponPower;
                low++;
            } else if (currRating > 0) { // try to sell a weapon having highest power
                currRating--;
                p += highestWeaponPower;
                high--;
            } else {
                // if nothing is possible break
                // because skipping lowest power weapon is not possible because next weapon will require more power which we dont have
                // skipping highest power weapon is also not possible because selling a weapon will require rating which we cant get
                break;
            }

            // Calculate max rating
            maxRating = Math.max(maxRating, currRating);
        }
        return maxRating;
    }
}
