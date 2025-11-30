class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        ret: bool = False
        _s = ''.join(sorted(s))
        _t = ''.join(sorted(t))
        return _s == _t
def main():
    sol = Solution()
    haystack: str = "anagram"
    needle: str = "nagarams"
    print(sol.isAnagram(s=haystack, t=needle))

if __name__ == "__main__":
    main()