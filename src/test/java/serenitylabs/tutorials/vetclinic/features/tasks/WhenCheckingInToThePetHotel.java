package serenitylabs.tutorials.vetclinic.features.tasks;

import io.cucumber.java.en_old.Ac;
import net.serenitybdd.screenplay.Actor;
import org.junit.Test;
import serenitylabs.tutorials.vetclinic.model.APetHotel;
import serenitylabs.tutorials.vetclinic.model.Pet;
import serenitylabs.tutorials.vetclinic.model.PetHotel;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class WhenCheckingInToThePetHotel {

    @Test
    public void petra_books_her_pet_cat_into_the_hotel_that_is_already_full(){
        Actor  petra = Actor.named("Petra the pet owner");
        Pet rafi = Pet.dog().named("Rafi");
        Actor harry = Actor.named("Harry");

        //Given
        PetHotel petHotel = APetHotel.called("Pet hotel California").withResidents(30);

        //When
        petra.attemptsTo(CheckIn.aPet(rafi).into(petHotel));

        //Then
        harry.should(
                seeThat(TheGuests.onTheWaitingListAt(petHotel),hasItem(rafi)),
                seeThat(TheGuests.resistratedInTheHotel(petHotel), not(hasItem(rafi)))
        );
    }

}
