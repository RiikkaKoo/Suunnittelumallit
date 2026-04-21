public interface Mediator {
    void registerChatter(Colleague chatter);
    void updateChatters();
    void relayMessage(String message, String sender, String receiver);
}
