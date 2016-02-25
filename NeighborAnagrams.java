
import java.util.*;


// CtCI5 11.2
public class NeighborAnagrams {

  private class AnagramComparator implements Comparator<String> {
    public int compare(String s1, String s2) {
      return sortChars(s1).compareTo(sortChars(s2));
    }

    private String sortChars(String string) {
      char[] chars = string.toCharArray();
      Arrays.sort(chars);
      return new String(chars);
    }
  }

  public void sortAccordingToAnagrams(String[] words) {
    Arrays.sort(words, new AnagramComparator());
  }

  public void sortAccordingToAnagramsWithHash(String[] words) {
    Map<String, List<String>> sortedWords = new HashMap<String, List<String>>();
    for (String word : words) {
      String canonical = getCanonicalForm(word);
      if (sortedWords.get(word) != null) {
        List<String> wordListHavingSameCanonicalForm = sortedWords.get(word);
        wordListHavingSameCanonicalForm.add(word);
      } else {
        List<String> wordListHavingSameCanonicalForm = new ArrayList<String>();
        wordListHavingSameCanonicalForm.add(word);
        sortedWords.put(canonical, wordListHavingSameCanonicalForm);
      }
    }
    int i = 0;
    for (String canonical : sortedWords.keySet()) {
      List<String> wordListHavingSameCanonicalForm = sortedWords.get(canonical);
      for (String word : wordListHavingSameCanonicalForm) {
        words[i++] = word;
      }
    }

  }

  private static String getCanonicalForm(String string) {
    char[] chars = string.toCharArray();
    Arrays.sort(chars);
    return new String(chars);	
  }

  private class AnagramWord {
    private String word;

    public AnagramWord(String word) {
      this.word = word;
    }

    @Override
      public int hashCode() {
        return getCanonicalForm(word).hashCode();
      }

    @Override
      public boolean equals(Object other) {
        if (this == other)
          return true;
        if (!(other instanceof AnagramWord))
          return false;
        return getCanonicalForm(this.word).equals(getCanonicalForm(((AnagramWord)other).word));
      }
  }

  public void sortAccordingToAnagramsWithHashCode(String words[]) {
    Set<AnagramWord> sortedSet = new TreeSet<AnagramWord>();
    for (String word : words)
      sortedSet.add(new AnagramWord(word));
    String[] newWords = new String[sortedSet.size()];
    int i = 0;
    for (AnagramWord aw : sortedSet) {
      newWords[i++] = aw.word;
    }
    words = newWords;
  }
}

