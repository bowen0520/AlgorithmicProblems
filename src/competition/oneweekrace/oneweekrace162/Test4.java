package competition.oneweekrace.oneweekrace162;

public class Test4 {
	public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int len = words.length;
        int[][] word = new int[len][27];
        for (int i = 0, j; i < len; i++) {
            for (char c : words[i].toCharArray()) {
                j = c - 'a';
                word[i][j]++;
                word[i][26] += score[j];
            }
        }

        int[] letter = new int[26];
        for (char c : letters) letter[c - 'a']++;
        
        return maxScoreWords(word, 0, letter, 0);
    }

    private int maxScoreWords(int[][] word, int i, int[] letter, int score) {
        if (i == word.length) return score;
        int v = maxScoreWords(word, i + 1, letter, score);
        boolean valid = true;
        for (int j = 0; j < 26; j++) {
            letter[j] -= word[i][j];
            if (letter[j] < 0) valid = false;
        }

        if (valid) {//如果这个单词可以拼接，比较是否拼接这个单词哪个收益高
            score += word[i][26];
            v = Math.max(v, maxScoreWords(word, i + 1, letter, score));
        }

        for (int j = 0; j < 26; j++) {
            letter[j] += word[i][j];
        }

        return v;
    }
}
