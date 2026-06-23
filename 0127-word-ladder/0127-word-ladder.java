class Solution {
    static class Pair{
        String first;
        int second;
        public Pair(String first,int second){
            this.first = first;
            this.second = second;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int len = wordList.size();
        Set<String> set = new HashSet<>();
        for(int i=0;i<len;i++){
            set.add(wordList.get(i));
        }
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(beginWord,1));
        set.remove(beginWord);
        while(!q.isEmpty()){
          String word = q.peek().first;
          int steps = q.peek().second;
          q.poll();
          if(word.equals(endWord)) return steps;
          for(int i=0;i<word.length();i++){
            for(char ch='a';ch<='z';ch++){
                char[] replaceCharArray = word.toCharArray();
                replaceCharArray[i] = ch;
                String replacedString = new String(replaceCharArray);
                if(set.contains(replacedString)){
                    set.remove(replacedString);
                    q.offer(new Pair(replacedString,steps+1));
                } 
            }
          }
        }
        return 0;
    }
}