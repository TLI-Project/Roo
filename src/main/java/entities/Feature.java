package entities;

/**
 * A feature that is added onto a car.
 * There is a builder for this
 */
public class Feature {
    private final String name;
    private final String description;

    /**
     * Construct a new feature.
     * @param name the features name.
     * @param description what the feature does.
     */
    public Feature(String name, String description) {
        this.name = name;
        this.description = description;
    }

    /**
     * @return the description of the feature.
     */
    public String getDescription(){
        return this.description;
    }

    /**
     * @return the name of the feature.
     */
    public String getName(){
        return this.name;
    }
}
