class Solution(object):
    def findWordsContaining(self, words, x):
        """
        Shout out to me. 
        FRANKEN_stein
        nd me too notsoprishiii <3
        
        This is the best code ever made!!!!! By obviously Shivang
        nd me toooooo
        nooo
        """
        result = []

        for i in range(len(words)):
            if x in words[i]:
                result.append(i)

        return result