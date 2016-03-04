
import java.util.*;


// CtCI5 11.7
public class CircusTower {

  private class Person implements Comparable<Person> {
    private int height;
    private int weight;

    public int compareTo(Person other) {
      if (height == other.height) {
        if (weight == other.weight) return 0;
        return (weight > other.weight) ? 1 : -1;
      }
      return (height > other.height) ? 1 : -1;
    }		
  }

  public int maxTowerPeople(Person[] people) {
    Arrays.sort(people);
    ArrayList<LinkedList<Person>> allLists = new ArrayList<LinkedList<Person>>();
    for (Person person : people) {
      int maxList = -1;
      for (int i=0; i<allLists.size(); i++) {
        LinkedList<Person> list = allLists.get(i);
        Person lastPerson = list.peek();
        if (person.weight >= lastPerson.weight) {
          if (maxList==-1 || allLists.get(maxList).size()<list.size())
            maxList = i;
        }
      }
      if (maxList == -1) {
        allLists.add(createNewList(person));
      } else {
        allLists.get(maxList).addFirst(person);
      }
    }
    int maxPeople = 0;
    for (List<Person> list : allLists) {
      if (list.size() > maxPeople)
        maxPeople = list.size();
    }
    return maxPeople;
  }

  private LinkedList<Person> createNewList(Person person) {
    LinkedList<Person> list = new LinkedList<Person>();
    list.add(person);	
    return list;
  }

}


// 1 4	1	1 4
// 2 3	1	1 4	(2 3)
// 2 5	2	1 4	2 5
// 3 6	3	1 4	2 5	3 6
// 3 7	4	1 4	2 5	3 7
// 4 5	4

// 2 3	1	2 3
// 1 4	1	2 3 (1 4)
// 2 5	2	
// 4 5
// 3 6
// 3 7

// 1 4
// 2 5
// 3 6
// 3 7
