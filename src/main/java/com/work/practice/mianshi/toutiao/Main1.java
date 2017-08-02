package work.wk.mianshi.toutiao;

import java.util.*;

/**
 * Created by wkhuahuo on 2017/3/30.
 */
public class Main1 {



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //第一行
        int jvzis = sc.nextInt();// jvzi
        int chaxuns = sc.nextInt();// chaxun
        //jvzis+chaxuns行
        List<String> str = new ArrayList<>();
        for (int i = 0; i <= jvzis + chaxuns; i++) {
            str.add(sc.nextLine());
        }

        // 拆解
        Sentence[] sents = new Sentence[jvzis];

        for (int i = 0; i < jvzis; i++) {
            sents[i] = new Sentence(str.get(i + 1));

        }

        for (int i = jvzis; i < chaxuns + jvzis; i++) {
            String query = str.get(i+1);
            Set<String> queriedWords = Sentence.retrieveWords(query);

            int countMax = -1;
            Sentence bestSent = null;// 有最多重复单词的句子
            for (Sentence sent : sents) {
                int Commonnums = sent.countComWords(queriedWords);
                if (Commonnums > countMax) {
                    bestSent = sent;
                    countMax = Commonnums;

                }
            }

            System.out.println(bestSent.original);
        }
    }

    private static class Sentence {

        public Set<String> words;//所有字母变成小写
        public String original;


        public Sentence(String sentence) {
            this.original = sentence;
            this.words = retrieveWords(sentence);
        }

        public int countComWords(Set<String> words) {
            int result = 0;
            for (String word : words) {
                if (this.words.contains(word)) {
                    result++;
                }
            }
            return result;
        }


        public static Set<String> retrieveWords(String sentence) {
            Set<String> result = new HashSet<String>();
            String[] words = sentence.split(" ");
            for (String word : words) {
                result.add(word.toLowerCase());
            }
            return result;
        }


    }

}
