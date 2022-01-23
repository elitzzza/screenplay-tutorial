package serenitylabs.tutorials.vetclinic.screenplay;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import org.junit.Test;
import org.junit.runner.RunWith;
import serenitylabs.tutorials.vetclinic.model.Pet;
import serenitylabs.tutorials.vetclinic.model.PetHotel;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.hasItem;

@RunWith(SerenityRunner.class)
public class CheckingInToThePetHotel {

    @Test
    public void elitza_books_her_dog_into_the_hotel(){
        //Given
        Actor elitza = Actor.named("Elitza the pet owner");
        Pet rafi = Pet.dog().named("Rafi");
        PetHotel petHotel = new PetHotel("Hotel for pets");

        //When
        elitza.attemptsTo(
                CheckIn.aPet(rafi).into(petHotel));

        //Then


    }

    @Test
    public void elitza_checks_her_dog_out_of_the_hotel(){
        //Given
        Actor elitza = Actor.named("Elitza the pet owner");
        Pet rafi = Pet.dog().named("Rafi");
        PetHotel petHotel =PetHotel.called("Hotel for pets");

        elitza.wasAbleTo(CheckIn.aPet(rafi).into(petHotel));

        //When
        elitza.attemptsTo(
                CheckOut.aPet(rafi).from(petHotel));
    }
}
