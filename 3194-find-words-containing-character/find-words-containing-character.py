class Solution(object):
    def findWordsContaining(self, words, x):
        """
        Shout out to me. 
        FRANKEN_stein
        nd me too notsoprishiii <3
        """
        return [i for i, word in enumerate(words) if x in word]