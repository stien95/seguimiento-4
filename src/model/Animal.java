package model;

public class Animal {
    // Attributes
    private String id;
    private String name;
    private String specie;
    private boolean isSterilized;
    private boolean isVaccinated;
    /**
     * Name: Animal
     * <br> Constructor method of Animal
     * <br> @param id - the id of the animal
     * <br> @param name - the name of the animal
     * <br> @param specie - the specie of the animal
     * <br> @param isSterilized - if the animal is sterilized
     * <br> @param isVaccinated - if the animal is vaccinated
     */
    public Animal(String id, String name, String specie, boolean isSterilized, boolean isVaccinated) {
        this.id = id;
        this.name = name;
        this.specie = specie;
        this.isSterilized = isSterilized;
        this.isVaccinated = isVaccinated;
    }
    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getSpecie() {
        return specie;
    }
    public void setSpecie(String specie) {
        this.specie = specie;
    }

    public boolean isSterilized() {
        return isSterilized;
    }

    public void setSterilized(boolean isSterilized) {
        this.isSterilized = isSterilized;
    }

    public boolean isVaccinated() {
        return isVaccinated;
    }

    public void setVaccinated(boolean isVaccinated) {
        this.isVaccinated = isVaccinated;
    }
    // Methods
    /**
     * Name: toString
     * <br> Method used to convert an animal to a string
     * <br> @return String - the animal as a string
     */
    @Override
    public String toString() {
        return "Id: " + id + "\n" +
                "Nombre: " + name + "\n" +
                "Especie: " + specie + "\n" +
                "Esterilizado: " + (isSterilized ? "si" : "no") + "\n" +
                "Vacunado: " + (isVaccinated ? "si" : "no");
    }
    
}
