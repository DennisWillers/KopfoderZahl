package de.willers.controller;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.model.Response;
import com.amazon.ask.model.interfaces.display.*;
import de.willers.model.Parameter;
import de.willers.view.Card;
import de.willers.view.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

/**
 * Von Dennis Willers (A13A316) am 05.11.2018 erstellt
 */
public class KopfOderZahlGenerieren {

    public Optional<Response> getKopfOderZahl(HandlerInput input){
        Random random = new Random();
        int zufallsZahl = random.nextInt(2);
        if(zufallsZahl == 0){
            Image image = getImage(Parameter.KOPF_IMAGE);
            Template template = getBodyTemplate3(Text.KOPF,image);
            return  kopfOderZahlAntwort(input,Text.KOPF,template);
        }
        else {
            Image image = getImage(Parameter.ZAHL_IMAGE);
            Template template = getBodyTemplate3(Text.ZAHL,image);

            return kopfOderZahlAntwort(input,Text.ZAHL,template);
        }
    }

    private Optional<Response> kopfOderZahlAntwort(HandlerInput input, String kopfOderZahl, Template template){
        // Device supports display interface
        if(null!=input.getRequestEnvelope().getContext().getDisplay()) {
            return input.getResponseBuilder()
                    .withSpeech(kopfOderZahl)
                    .withSimpleCard(Card.TITEL, kopfOderZahl)
                    .addRenderTemplateDirective(template)
                    .build();
        } else {
            // Headless device
            return input.getResponseBuilder()
                    .withSpeech(kopfOderZahl)
                    .withSimpleCard(Card.TITEL, kopfOderZahl)
                    .build();
        }
    }

    private Image getImage(String imageUrl) {
        List<ImageInstance> instances = getImageInstance(imageUrl);
        return Image.builder()
                .withContentDescription("Context")
                .withSources(instances)
                .build();
    }

    private List<ImageInstance> getImageInstance(String imageUrl) {
        List<ImageInstance> instances = new ArrayList<>();
        ImageInstance instance = ImageInstance.builder()
                .withUrl(imageUrl)
                .withSize(ImageSize.MEDIUM)
                .build();
        instances.add(instance);
        return instances;
    }

    private Template getBodyTemplate3(String title, Image image) {
        return BodyTemplate3.builder()
                .withImage(image)
                .withTitle(title)
                .build();
    }
}
