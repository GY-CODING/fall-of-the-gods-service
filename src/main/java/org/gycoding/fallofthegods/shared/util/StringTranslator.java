package org.gycoding.fallofthegods.shared.util;

import org.gycoding.fallofthegods.infrastructure.external.database.model.TranslatedString;

public class StringTranslator {
    public static String translate(TranslatedString translatedString, String language) {
        return translatedString != null ? translatedString.get(language) : "";
    }
}
