package de.willers.view;

/**
 * Von Dennis Willers (A13A316) am 04.10.2018 erstellt
 */
public interface Text {

    String HELP          = "Tja, Hilfe gibt es hier leider nicht - Belastend! ";
    String STOP          = "Ich hoffe dein restlicher Tag wird so belastend wie meiner. ";
    String FALLBACK      = "Belastend. Ich habe dich nicht verstanden. ";

    String KOPF          = "Kopf";
    String ZAHL          = "Zahl";

    //SSML Aussprache

    String HELP_SSML          = "<prosody pitch=\"high\">Tja, Hilfe gibt es hier leider nicht. <prosody volume=\"x-loud\"><emphasis level=\"strong\">Belastend</emphasis>!</prosody></prosody> ";
    String STOP_SSML          = "<prosody pitch=\"high\">Ich hoffe dein restlicher Tag wird so <prosody volume=\"x-loud\"><emphasis level=\"strong\">belastend</emphasis> wie meiner.</prosody></prosody> ";
    String FALLBACK_SSML      = "<prosody pitch=\"high\"><prosody volume=\"x-loud\"><emphasis level=\"strong\">Belastend</emphasis>. Ich habe dich nicht verstanden.</prosody></prosody> ";
}
