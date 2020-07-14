package com.alezmu.recipie.services;

import com.alezmu.recipie.commands.UnitOfMeasureCommand;

import java.util.Set;

public interface UnitOfMeasureService {

    Set<UnitOfMeasureCommand> listAllUoms();
}