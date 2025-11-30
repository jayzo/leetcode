class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        ret: int = 0
        if haystack == needle:
            return 0
        for i in range(len(haystack)):
            if haystack[i:i+len(needle)] == needle:
                return i
        return -1
def main():
    sol = Solution()
    haystack: str = "a"
    needle: str = "a"
    print(sol.strStr(haystack, needle))

if __name__ == "__main__":
    main()