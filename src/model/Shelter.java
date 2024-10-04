package model;

public class Shelter {
    // Attributes
    private int capacity;
    private String name;
    private String address;
    private double budget;
    // Association
    private Animal[] animals;

    /**
     * Name: Shelter
     * <br> Constructor method of Shelter
     * <br> 
     * <br> @param capacity - the capacity of the shelter
     * <br> @param name     - the name of the shelter
     * <br> @param address  - the address of the shelter
     * <br> @param budget   - the budget of the shelter
     */
    public Shelter(int capacity, String name, String address, double budget) {
        this.capacity = capacity;
        this.name = name;
        this.address = address;
        this.budget = budget;
        animals = new Animal[capacity];
    }

    // Getters and Setters
    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public Animal[] getAnimals() {
        return animals;
    }

    public void setAnimals(Animal[] animals) {
        this.animals = animals;
    }

    /**
     * Name: addAnimal
     * <br> Method used to add an animal to the shelter
     * <br> 
     * <br> @param id           - the identification of the animal
     * <br> @param name         - the name of the animal
     * <br> @param specie       - the specie of the animal
     * <br> @param isSterilized - if the animal is sterilized
     * <br> @param isVaccinated - if the animal is vaccinated
     * <br> @return message - a message that indicates if the animal was added or not
     */
    public String addAnimal(String id, String name, String specie, boolean isSterilized, boolean isVaccinated) {
        String message = "";
        boolean added = false;
        Animal animal = new Animal(id, name, specie, isSterilized, isVaccinated);
        String existId = searchAnimalById(id);
        if (!existId.equals("")) {
            message = "El animal ya existe";
        } else {
            String existName = searchAnimalByName(name);
            if (!existName.equals("")) {
                message = "El animal con el nombre " + name + " ya existe";
            } else {
                for (int i = 0; i < animals.length && !added; i++) {
                    if (animals[i] == null) {
                        animals[i] = animal;
                        added = true;
                    }
                }
                if (added) {
                    message = "El animal fue agregado";
                } else {
                    message = "No se pudo agregar el animal, el refugio esta lleno";
                }
            }
        }

        return message;
    }

    /**
     * Name: getSpecieAmount
     * <br> Method used to get the amount of animals of a specie in the shelter
     * <br> 
     * <br> @param specie - the specie of the animal
     * <br> @return amount - the amount of animals of the specie
     */
    public String getSpecieAmount(String specie) {
        int amount = 0;
        String message = "";
        for (int i = 0; i < animals.length; i++) {
            if (animals[i] != null && animals[i].getSpecie().equalsIgnoreCase(specie)) {
                amount++;
            }
        }
        if (amount == 0) {
            message = "No hay animales de la especie " + specie;
        } else {
            message = "La cantidad de animales de la especie " + specie + " es: " + amount;
        }
        return message;
    }

    /**
     * Name: searchAnimalByName
     * <br> Method used to search an animal by its name in the shelter
     * <br> 
     * <br> @param name - the name of the animal
     * <br> @return animal - the animal found
     */
    public String searchAnimalByName(String name) {
        Animal animal = null;
        String message = "";
        for (int i = 0; i < animals.length && animal == null; i++) {
            if (animals[i] != null && animals[i].getName().equalsIgnoreCase(name)) {
                animal = animals[i];
            }
        }
        if (animal != null) {
            message = animal.toString();
        } else {
            message = "";
        }
        return message;
    }

    /**
     * Name: searchAnimalById
     * <br> Method used to search an animal by its id in the shelter
     * <br> 
     * <br> @param id - the identification of the animal
     * <br> @return animal - the animal found
     */
    public String searchAnimalById(String id) {
        Animal animal = null;
        String message = "";
        for (int i = 0; i < animals.length && animal == null; i++) {
            if (animals[i] != null && animals[i].getId().equalsIgnoreCase(id)) {
                animal = animals[i];
            }
        }
        if (animal != null) {
            message = animal.toString();
        } else {
            message = "";
        }
        return message;
    }

    /**
     * Name: searchAnimalsBySpecie
     * <br> Method used to search animals by their specie in the shelter
     * <br> 
     * <br> @param specie - the specie of the animal
     * <br> @return animals - the animals found
     */
    public String searchAnimalsBySpecie(String specie) {
        String message = "";
        for (int i = 0; i < animals.length; i++) {
            if (animals[i] != null && animals[i].getSpecie().equalsIgnoreCase(specie)) {
                message += animals[i].toString() + "\n";
            }
        }
        return message;
    }

    /**
     * Name: searchAnimalsBySterilization
     * <br> Method used to search animals by their sterilization in the shelter
     * <br> 
     * <br> @param isSterilized - if the animal is sterilized
     * <br> @return animals - the animals found
     */
    public String searchAnimalsBySterilization(boolean isSterilized) {
        String message = "";
        for (int i = 0; i < animals.length; i++) {
            if (animals[i] != null && animals[i].isSterilized() == isSterilized) {
                message += animals[i].toString() + "\n";
            }
        }
        return message;
    }

    /**
     * Name: searchAnimalsByVaccination
     * <br> Method used to search animals by their vaccination in the shelter
     * <br> 
     * <br> @param isVaccinated - if the animal is vaccinated
     * <br> @return animals - the animals found
     */
    public String searchAnimalsByVaccination(boolean isVaccinated) {
        String message = "";
        for (int i = 0; i < animals.length; i++) {
            if (animals[i] != null && animals[i].isVaccinated() == isVaccinated) {
                message += animals[i].toString() + "\n";
            }
        }
        return message;
    }
}
