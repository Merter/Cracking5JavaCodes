
import java.util.*;


// CtCI5 3.7
public class AnimalShelter {

  private LinkedList<Cat> cats = new LinkedList<Cat>();
  private LinkedList<Dog> dogs = new LinkedList<Dog>();

  private abstract class Animal {
    Date arrivalTime;

    public abstract void enqueue();
  }

  private class Cat extends Animal {
    public void enqueue() {
      cats.add(this);
    }
  }

  private class Dog extends Animal {
    public void enqueue() {
      dogs.add(this);
    }
  }

  public void enqueue(Animal animal) {
    animal.arrivalTime = new Date();
    animal.enqueue();
  }

  public Animal dequeueAny() {
    Cat oldestCat = cats.peek();
    Dog oldestDog = dogs.peek();
    if (oldestCat == null) return oldestDog;
    if (oldestDog == null) return oldestCat;
    boolean isCatOlder = oldestCat.arrivalTime.compareTo(oldestDog.arrivalTime) <= 0;
    if (isCatOlder) return dequeueCat();
    return dequeueDog();
  }

  public Dog dequeueDog() {
    return dogs.poll();
  }

  public Cat dequeueCat() {
    return cats.poll();
  }

}
