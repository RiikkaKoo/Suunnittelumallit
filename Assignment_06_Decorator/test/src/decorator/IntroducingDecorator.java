package decorator;

public class IntroducingDecorator extends OratorDecorator {

    public IntroducingDecorator(Orator orator) {
        super(orator);
    }

    @Override
    public void say(String message) {
        super.say("Dear user, an important message follows:" + message);
    }
}
