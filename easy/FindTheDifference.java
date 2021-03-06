/**
Given two strings s and t which consist of only lowercase letters.

String t is generated by random shuffling string s and then add one more letter at a random position.

Find the letter that was added in t.

Example:

Input:
s = "abcd"
t = "abcde"

Output:
e

Explanation:
'e' is the letter that was added.
*/


public char findTheDifference(String s, String t) {
    Map<Character, Integer> map = new HashMap<>();
    int N = s.length();

    for (int i = 0; i < N; i++) {
        Integer count = map.remove(s.charAt(i));
        if (count == null) {
            count = 1;
        } else {
            count ++;
        }
        map.put(s.charAt(i), count);
    }

    int M = N + 1;
    for (int i = 0; i < M; i++) {
        Integer count = map.remove(t.charAt(i));
        if (count == null) {
            return t.charAt(i);
        } else {
            count --;
            if (count > 0) {
                map.put(t.charAt(i), count);
            }
        }
    }

    return '\0';
}
