package org.gycoding.heraldsofchaos.shared.util;

import org.gycoding.heraldsofchaos.infrastructure.external.database.model.TranslatedString;

public class StringTranslator {
    public static String translate(TranslatedString translatedString, String language) {
        return translatedString != null ? translatedString.get(language) : "";
    }
}
