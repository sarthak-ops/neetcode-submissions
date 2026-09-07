class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t): return False
        count = [0] * 26
        for _ in range(len(s)):
            sc = s[_];
            tc = t[_];
            count[ord(sc)-ord('a')] += 1
            count[ord(tc)-ord('a')] -= 1
        for i in range(len(count)):
            if count[i] != 0: return False
        return True