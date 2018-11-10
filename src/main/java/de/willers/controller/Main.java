package de.willers.controller;

import com.amazon.ask.Skill;
import com.amazon.ask.SkillStreamHandler;
import com.amazon.ask.Skills;
import de.willers.controller.handlers.*;
import de.willers.model.Parameter;

public class Main extends SkillStreamHandler {

    private static Skill getSkill() {
        return Skills.standard()
                .addRequestHandlers(
                        new CancelandStopIntentHandler(),
                        new HelpIntentHandler(),
                        new LaunchRequestHandler(),
                        new SessionEndedRequestHandler(),
                        new FallbackIntentHandler(),

                        new KopfOderZahlHandler())
                .withSkillId(Parameter.SKILL_ID)
                .build();
    }

    public Main() {
        super(getSkill());
    }

}