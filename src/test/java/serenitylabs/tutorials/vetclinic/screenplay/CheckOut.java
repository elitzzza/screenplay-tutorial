package serenitylabs.tutorials.vetclinic.screenplay;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.thucydides.core.annotations.Step;
import serenitylabs.tutorials.vetclinic.model.Pet;
import serenitylabs.tutorials.vetclinic.model.PetHotel;

public class CheckOut implements Performable {
    private final Pet pet;
    private final PetHotel petHotel;


    public CheckOut(Pet pet, PetHotel petHotel){
        this.pet = pet;
        this.petHotel = petHotel;
    }

    public static CheckOutBuilder aPet(Pet pet){
        return new CheckOutBuilder(pet);
    }
@Step("{0} checks-out #pet from #petHotel")
    @Override
    public <T extends Actor> void performAs(T actor) {
        petHotel.checkOut(pet);

    }

    public static class CheckOutBuilder{
        private final Pet pet;

        private CheckOutBuilder(Pet pet){
            this.pet = pet;
        }

        public Performable from(PetHotel petHotel){
            return Instrumented.instanceOf(CheckOut.class)
                    .withProperties(pet,petHotel);
        }
    }
}
