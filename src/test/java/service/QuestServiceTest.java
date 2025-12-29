package service;

import model.QuestStep;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class QuestServiceTest {
    private QuestService questService;

    @BeforeEach
    void setUp() {
        questService = new QuestService();
    }

    @Test
    @DisplayName("Get initial step")
    void testGetStartStep() {
        QuestStep step = questService.getStep("start");

        assertNotNull(step, "Step 'start' should not be null");
        assertEquals("start", step.getId(), "Step ID should be 'start'");
        assertEquals("A tape asks if your life has been wasted so far. Do you agree?", step.getText());
        assertEquals("Agree", step.getOption1());
        assertEquals("My life was not wasted", step.getOption2());
        assertEquals("escape", step.getNextStepId1());
        assertEquals("lose1", step.getNextStepId2());
    }

    @Test
    @DisplayName("Get win step")
    void testGetWinStep() {
        QuestStep step = questService.getStep("win");

        assertNotNull(step, "Step 'win' should not be null");
        assertTrue(step.getText().contains("You could defeat your demons within and earn salvation. You are won!"),
                "Text should contain 'You could defeat your demons within and earn salvation. You are won!'");
        assertNull(step.getOption1(), "Final step should not have answer options");
        assertNull(step.getOption2(), "Final step should not have answer options");
    }

    @Test
    @DisplayName("Get non-existent step")
    void testGetNonExistentStep() {
        QuestStep step = questService.getStep("non-existent");
        assertNull(step, "Non-existent step should return null");
    }

    @Test
    @DisplayName("Final step check")
    void testIsFinalStep() {
        assertTrue(questService.isFinalStep("win"), "'win' should be final step");
        assertTrue(questService.isFinalStep("lose1"), "'lose1' should be the final step");
        assertTrue(questService.isFinalStep("lose2"), "'lose2' should be the final step");
        assertTrue(questService.isFinalStep("lose3"), "'lose3' should be the final step");
        assertTrue(questService.isFinalStep("lose4"), "'lose4' should be the final step");
        assertTrue(questService.isFinalStep("lose5"), "'lose5' should be the final step");

        assertFalse(questService.isFinalStep("start"), "'start' should not be the final step");
        assertFalse(questService.isFinalStep("escape"), "'escape' should not be the final step");
        assertFalse(questService.isFinalStep("admit_mistake"), "'admit_mistake' should not be the final " +
                "step");
        assertFalse(questService.isFinalStep("break_the_rules"), "'break_the_rules' should not be the final " +
                "step");

        assertFalse(questService.isFinalStep("non-existent"),
                "Non-existent step should not be the final step");
    }

    @Test
    @DisplayName("Options logic test")
    void testQuestBranching() {
        QuestStep start = questService.getStep("start");
        QuestStep escape = questService.getStep("escape");
        QuestStep admitMistake = questService.getStep("admit_mistake");
        QuestStep breakTheRules = questService.getStep("break_the_rules");
        QuestStep endurePain = questService.getStep("endure_pain");
        QuestStep win = questService.getStep("win");

        assertNotNull(start);
        assertNotNull(escape);
        assertNotNull(admitMistake);
        assertNotNull(breakTheRules);
        assertNotNull(endurePain);
        assertNotNull(win);

        assertEquals("escape", start.getNextStepId1());
        assertEquals("lose1", start.getNextStepId2());

        assertEquals("lose2", escape.getNextStepId1());
        assertEquals("admit_mistake", escape.getNextStepId2());

        assertEquals("break_the_rules", admitMistake.getNextStepId1());
        assertEquals("lose3", admitMistake.getNextStepId2());

        assertEquals("lose4", breakTheRules.getNextStepId1());
        assertEquals("endure_pain", breakTheRules.getNextStepId2());

        assertEquals("win", endurePain.getNextStepId1());
        assertEquals("lose5", endurePain.getNextStepId2());
    }
}
