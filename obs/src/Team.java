import java.util.ArrayList;
import java.util.List;

public abstract class Team implements Subject{
    private final List<Observer> observers = new ArrayList<>();
    private int score;

    public void goal() {
        this.score += 1;
        notifyObservers();
    }

    public void setScore(int score){
        this.score = score;
        notifyObservers();;
    }

    public int getScore(){
        return score;
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for(Observer o: observers){
            o.update(this);
        }
    }
}
