package service;

import model.QuestStep;

import java.util.HashMap;
import java.util.Map;

public class QuestService {
    private final Map<String, QuestStep> steps = new HashMap<>();

    public QuestService() {
        initSteps();
    }

    private void initSteps() {
        steps.put("start", new QuestStep(
                "start",
                "A tape asks if your life has been wasted so far. Do you agree?",
                "Agree",
                "My life was not wasted",
                "escape",
                "lose1",
                "introduction.jpg"
        ));

        steps.put("escape", new QuestStep(
                "escape",
                "You are given a choice to escape now, knowing someone else will take your place. Do you leave?",
                "Yes, leave",
                "Do not leave",
                "lose2",
                "admit_mistake",
                "escape.png"
        ));

        steps.put("admit_mistake", new QuestStep(
                "admit_mistake",
                "The device will stop if you admit your worst mistake out loud. Do you confess?",
                "Confess",
                "I have nothing to confess",
                "break_the_rules",
                "lose3",
                "admit_mistake.jpg"
        ));

        steps.put("break_the_rules", new QuestStep(
                "break_the_rules",
                "You can end the game immediately by breaking the rules. Do you break them?",
                "Break the rules",
                "Don't break the rules",
                "lose4",
                "endure_pain",
                "break_the_rules.jpg"
        ));

        steps.put("endure_pain", new QuestStep(
                "endure_pain",
                "You are told survival requires pain, not luck. Are you willing to endure it?",
                "Endure pain",
                "No, I am not",
                "win",
                "lose5",
                "endure_pain.jpg"
        ));

        steps.put("lose1", new QuestStep(
                "lose1",
                "Your life was wasted that is why you are here. Defeat!",
                null,
                null,
                null,
                null,
                "defeat.jpg"
        ));

        steps.put("lose2", new QuestStep(
                "lose2",
                "Do you think someone else can earn redemption for you? Defeat!",
                null,
                null,
                null,
                null,
                "defeat.jpg"
        ));

        steps.put("lose3", new QuestStep(
                "lose3",
                "Only a fool does not admit his mistakes. Defeat!",
                null,
                null,
                null,
                null,
                "defeat.jpg"
        ));

        steps.put("lose4", new QuestStep(
                "lose4",
                "Nobody should break the rules. Defeat!",
                null,
                null,
                null,
                null,
                "defeat.jpg"
        ));

        steps.put("lose5", new QuestStep(
                "lose5",
                "Only with pain you can change something. Defeat!",
                null,
                null,
                null,
                null,
                "defeat.jpg"
        ));

        steps.put("win", new QuestStep(
                "win",
                "You could defeat your demons within and earn salvation. You are won!",
                null,
                null,
                null,
                null,
                "win.jpg"
        ));
    }

    public QuestStep getStep(String id) {
        return steps.get(id);
    }

    public boolean isFinalStep(String stepId) {
        QuestStep step = steps.get(stepId);
        return step != null && step.getOption1() == null;
    }

}