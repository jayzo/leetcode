class Solution:
    def mergeAlternately(self, word1: str, word2: str) -> str:
        """
        交替合并两个字符串
        """
        if len(word1) == 0:
            return word2
        if len(word2) == 0:
            return word1
        ret: str = ""
        idx: int = 0;
        for c in word1:
            ret += c
            if len(word2) > idx:
                ret += word2[idx]
            idx += 1
        if len(word2) > idx:
            ret += word2[idx:len(word2)]
        return ret

def main():
    word1 = "abc"
    word2 = "pqrdd"
    print(Solution().mergeAlternately(word1, word2))

if __name__ == "__main__":
    main()