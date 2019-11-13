package placeholder.people;

public class TextObserver implements Observer {
    private ObservableValue ov;

    public TextObserver(ObservableValue ov) {
        this.ov = ov;
    }

    @Override
    public void update(Observable obs, Object obj) {
        if (obs.equals(ov)) {
            System.out.println(ov.getValue());
        }
    }
}