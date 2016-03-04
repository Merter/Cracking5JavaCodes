
import java.util.*;


// CtCI5 9.4
public class AllSubsets<T> {

  public Set<Set<T>> getAllSubsetsRecursively(Set<T> set) {  
    Set<Set<T>> allSubsets = new HashSet<Set<T>>();
    allSubsets.add(new HashSet<T>());

    for (T item : set) {
      set.remove(item);
      Set<Set<T>> smallSubsets = getAllSubsetsRecursively(set);
      for (Set<T> sss : smallSubsets) {
        allSubsets.add(sss);
        Set<T> clonedSss = new HashSet<T>();
        clonedSss.addAll(sss);
        clonedSss.add(item);
        allSubsets.add(clonedSss);
      }
    }
    return allSubsets;
  }

  public Set<Set<T>> getAllSubsetsIteratively(Set<T> set) {
    Set<Set<T>> allSubsets = new HashSet<Set<T>>();
    allSubsets.add(Collections.emptySet());
    for (T element : set) {
      Set<Set<T>> moreSubsets = new HashSet<Set<T>>();
      for (Set<T> subset : allSubsets) {
        Set<T> newSubset = new HashSet<T>();
        newSubset.addAll(subset);
        newSubset.add(element);
        moreSubsets.add(newSubset);		
      }
      allSubsets.addAll(moreSubsets);
    }	
    return allSubsets;
  }

  public Set<Set<T>> getAllSubsetsWithCombinatorics(Set<T> set) {
    Set<Set<T>> allSubsets = new HashSet<Set<T>>();
    for (int i=0; i<(int)Math.pow(2, set.size()); i++) {			
      allSubsets.add(generateSubsetFromInteger(set, i));
    }
    return allSubsets;
  }

  private Set<T> generateSubsetFromInteger(Set<T> set, int bitSet) {
    Set<T> subset = new HashSet<T>();
    for (T element : set) {
      if ((1&bitSet) != 0) {
        subset.add(element);
      }
      bitSet >>>= 1;
    }
    return subset;
  }
}
