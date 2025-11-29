class Solution:
    def findTheDifference(self, s: str, t: str) -> str:
        """
        找不同
        """
        setT = {}
        for c in t:
            if c in setT:
                setT[c] += 1
            else:
                setT[c] = 1
        for c in s:
            if setT[c] == 1:
                del setT[c]
            else:
                setT[c] -= 1
        for key in setT:
            return key

def main():
    word1: str = "aaa"
    word2: str = "aaaa"
    print(Solution().findTheDifference(s=word1, t=word2))

if __name__ == "__main__":
    main()