package model;

public class ShelterController {
    // Asociation
    private Shelter shelter;
    /**
     * Name: ShelterController
     * <br> Constructor method of ShelterController
     * <br> @param capacity - the capacity of the shelter
     * <br> @param name - the name of the shelter
     * <br> @param address - the address of the shelter
     * <br> @param budget - the budget of the shelter
     */
    public ShelterController(int capacity, String name, String address, double budget) {
        shelter = new Shelter(capacity, name, address, budget);
    }
    /**
     * Name: addAnimal
     * <br> Method used to add an animal to the shelter
     * <br> Post-condition: the animal is added to the shelter
     * <br> @param id - the id of the animal
     * <br> @param name - the name of the animal
     * <br> @param specie - the specie of the animal
     * <br> @param isSterilized - if the animal is sterilized
     * <br> @param isVaccinated - if the animal is vaccinated
     * <br> @return message - a message that indicates if the animal was added or not
     */
    public String addAnimal(String id, String name, String specie, boolean isSterilized, boolean isVaccinated) {
        String message = shelter.addAnimal(id, name, specie, isSterilized, isVaccinated);
        return message;
    }
    /**
     * Name: searchAnimalById
     * <br> Method used to search animals by id
     * <br> @param id - the id of the animal
     * <br> @return message - a message that indicates if the animal was found or not
     */
    public String searchAnimalById(String id) {
        String message = shelter.searchAnimalById(id).toString();
        if (message.equals("")) {
            message = "No se encontró el animal";
        }
        return message;
    }
    /**
     * Name: searchAnimalByName
     * <br> Method used to search animals by name
     * <br> @param name - the name of the animal
     * <br> @return message - a message that indicates if the animal was found or not
     */
    public String searchAnimalByName(String name) {
        String message = shelter.searchAnimalByName(name);
        if (message.equals("")) {
            message = "No se encontró el animal";
        }
        return message;
    }
    /**
     * Name: searchAnimalsBySpecie
     * <br> Method used to search animals by specie
     * <br> @param specie - the specie of the animal
     * <br> @return message - a message that indicates if the animal was found or not
     */
    public String searchAnimalsBySpecie(String specie) {
        String message = shelter.searchAnimalsBySpecie(specie);
        if (message.equals("")) {
            message = "No se encontró ningún animal de esa especie";
        }
        return message;
    }
    /**
     * Name: searchAnimalsBySterilization
     * <br> Method used to search animals by sterilization
     * <br> @param isSterilized - if the animal is sterilized
     * <br> @return message - a message that indicates if the animal was found or not
     */
    public String searchAnimalsBySterilization(boolean isSterilized) {
        String message = shelter.searchAnimalsBySterilization(isSterilized);
        if (message.equals("")) {
            message = "No se encontró ningún animal "+ (isSterilized ? "esterilizado" : "no esterilizado");
        }
        return message;
    }
    /**
     * Name: searchAnimalsByVaccination
     * <br> @param isVaccinated - if the animal is vaccinated
     * <br> @return message - a message that indicates if the animal was found or not
     */
    public String searchAnimalsByVaccination(boolean isVaccinated) {
        String message = shelter.searchAnimalsByVaccination(isVaccinated);
        if (message.equals("")) {
            message = "No se encontró ningún animal "+ (isVaccinated ? "vacunado" : "no vacunado");
        }
        return message;
    }
    /**
     * Name: getSpecieAmount
     * <br> Method used to get the amount of animals of a specific specie
     * <br> @param specie - the specie of the animal
     * <br> @return message - a message that indicates the amount of animals of a specific specie
     */
    public String getSpecieAmount(String specie) {
        String message = shelter.getSpecieAmount(specie);
        return message;
    }
    // Getters and Setters
    public Shelter getShelter() {
        return shelter;
    }
    public void setShelter(Shelter shelter) {
        this.shelter = shelter;
    }
}
