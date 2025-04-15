package org.gycoding.fallofthegods.shared;

import org.gycoding.fallofthegods.infrastructure.external.database.model.TranslatedString;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Qualifier;

@Qualifier
public class StringTranslator {
    @Named("Translate")
    public static String translate(TranslatedString translatedString, String language) {
        return translatedString != null ? translatedString.get(language) : "";
    }
}
