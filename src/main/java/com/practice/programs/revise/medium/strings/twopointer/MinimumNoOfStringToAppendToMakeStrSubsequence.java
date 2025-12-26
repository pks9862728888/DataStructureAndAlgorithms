package com.practice.programs.revise.medium.strings.twopointer;

/**
 * TC: O(n)
 * AS: O(1)
 * Concepts:
 * TWO_POINTER
 */
class MinimumNoOfStringToAppendToMakeStrSubsequence {

  public int appendCharacters(String s, String t) {
    int lens = s.length();
    int lent = t.length();

    int sp = 0;
    int tp = 0;
    while (sp < lens && tp < lent) {
      if (s.charAt(sp) == t.charAt(tp)) {
        sp++;
        tp++;
      } else {
        sp++;
      }
    }

    return lent - tp;
  }
}
