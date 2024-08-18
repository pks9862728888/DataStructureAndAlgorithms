package com.practice.programs.revise.medium.strings;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/encode-and-decode-strings/description/
 * Concept:
 * STRING
 * ENCODING_DECODING
 * CHUNKED_TRANSFER_ENCODING (specify chunk size before next n chars)
 */
public class EncodeAndDecodeString {

    private static final String DELIMITER = "/:";

    // Encodes a list of strings to a single string.
    // Input string: "aba", "def"
    // Encoded string: 3/:aba3/:def
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str: strs) {
            sb.append(str.length());
            sb.append(DELIMITER);
            sb.append(str);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res =  new ArrayList<>();
        int n = s.length();
        int i = 0;
        while (i < n) {
            int dIdx = s.indexOf(DELIMITER, i);
            int charCount = Integer.parseInt(s.substring(i, dIdx));
            i = dIdx + DELIMITER.length();
            res.add(s.substring(i, i + charCount));
            i = i + charCount;
        }
        return res;
    }
}
