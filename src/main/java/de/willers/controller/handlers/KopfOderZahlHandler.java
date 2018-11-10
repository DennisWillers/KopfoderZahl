package de.willers.controller.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import de.willers.controller.KopfOderZahlGenerieren;
import de.willers.model.Intentnamen;

import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;

/**
 * Von Dennis Willers (A13A316) am 05.11.2018 erstellt
 */
public class KopfOderZahlHandler extends KopfOderZahlGenerieren implements RequestHandler {

    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(intentName(Intentnamen.KOPF_ODER_ZAHL_INTENT));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
        return getKopfOderZahl(input);
    }
}
