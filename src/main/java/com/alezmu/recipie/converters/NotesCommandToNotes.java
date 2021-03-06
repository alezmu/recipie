package com.alezmu.recipie.converters;

import com.alezmu.recipie.commands.IngredientCommand;
import com.alezmu.recipie.commands.NotesCommand;
import com.alezmu.recipie.domain.Ingredient;
import com.alezmu.recipie.domain.Notes;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class NotesCommandToNotes implements Converter<NotesCommand, Notes> {

    @Synchronized
    @Nullable
    @Override
    public Notes convert(NotesCommand notesCommand) {
        if(notesCommand == null){
        return null;
        }

        final Notes notes = new Notes();
        notes.setId(notesCommand.getId());
        notes.setRecipeNotes(notesCommand.getRecipeNotes());
        return notes;

    }

}
