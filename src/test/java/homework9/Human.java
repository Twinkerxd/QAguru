package homework9;

public class Human {
    private String name;
    private Integer age;
    private Boolean isLearningAutomation;
    private Animals animals;
    private String[] hobbies;

    public String getName() {
        return name;
    }

    public Boolean getIsLearningAutomation() {
        return isLearningAutomation;
    }

    public Integer getAge() {
        return age;
    }

    public String[] getHobbies() {
        return hobbies;
    }

    public Animals getAnimals() {
        return animals;
    }

    public class Animals {
        private String name;
        private String type;
        private Integer age;
        private Boolean isLikesToEat;

        public String getName() {
            return name;
        }

        public String getType() {
            return type;
        }

        public Integer getAge() {
            return age;
        }

        public Boolean getIsLikesToEat() {
            return isLikesToEat;
        }
    }
}
