package decorator;

public class ConcludingDecorator extends OratorDecorator {

    public ConcludingDecorator(Orator orator) {
        super(orator);
    }

    @Override
    public void say(String message) {
        super.say(message + "That's all folks!");
    }
}
