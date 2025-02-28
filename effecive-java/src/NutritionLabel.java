// Item 2 - Builder
public class NutritionLabel {
    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrates;
    private String labelName;

    public static class Builder {
        // required
        private final int servingSize;
        private final int servings;
        // optional
        private int calories;
        private int fat;
        private int sodium;
        private int carbohydrates;

        public Builder(int servingSize, int servings){
            this.servingSize = servingSize;
            this.servings = servings;
        }

        public Builder calories(int val){
            this.calories = val;
            return this;
        }

        public Builder fat(int val){
            this.fat = val;
            return this;
        }

        public Builder sodium(int val){
            this.sodium = val;
            return this;
        }

        public Builder carbohydrates(int val){
            this.carbohydrates = carbohydrates;
            return this;
        }

        public NutritionLabel build(){
            return new NutritionLabel(this);
        }
    }

    private NutritionLabel(Builder builder){
        servingSize = builder.servingSize;
        servings = builder.servings;
        calories = builder.calories;
        fat = builder.fat;
        sodium = builder.sodium;
        carbohydrates = builder.carbohydrates;
    }

    public static void main(String[] args){
        NutritionLabel cocaCola = new Builder(240, 8)
                .calories(200).fat(10).carbohydrates(13).build();
        System.out.println(cocaCola.sodium);
        System.out.println(cocaCola.calories);
    }

}
