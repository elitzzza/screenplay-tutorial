package serenitylabs.tutorials.vetclinic.features.tasks;

import serenitylabs.tutorials.vetclinic.model.PetHotel;

public class TheGuests {
    public static TheRegisteredGuests registeredInTheHotel(PetHotel petHotel){
        return TheregisteredGuests.in(petHotel);
    }

    public static  TheGuestsOnTheWaitingList onTheWaitingListAt(PetHotel petHotel){
        return TheGuestsOnTheWaitingList.forHotel(petHotel);
    }
}
