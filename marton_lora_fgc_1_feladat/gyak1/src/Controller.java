import java.util.ArrayList;

public class Controller {
    private ArrayList<Button> buttons;

    public Controller() {
        buttons = new ArrayList<>();
    }

    public void addButton(Button b) {
        buttons.add(b);
    }

    public void pressAll() {
        for (Button b : buttons) {
            if (!b.getState()) {
                b.setState(true);
            }
        }
    }

    public void releaseAll() {
        for (Button b : buttons) {
            if (b.getState()) {
                b.setState(false);
            }
        }
    }

    public int getNumOfPressedBtns() {
        int numOfPressed = 0;
        for (Button b : buttons) {
            if (b.getState()) {
                numOfPressed++;
            }
        }
        return numOfPressed;
    }
}
