package meal_plan_generator;

import java.util.*;

// Interface representing a meal plan
interface MealPlan {
    String getMealName();
    int getCalories();
}

// Specific meal plan types
class VegetarianMeal implements MealPlan {
    private String mealName;
    private int calories;

    public VegetarianMeal(String mealName, int calories) {
        this.mealName = mealName;
        this.calories = calories;
    }

    @Override
    public String getMealName() {
        return mealName;
    }

    @Override
    public int getCalories() {
        return calories;
    }

    @Override
    public String toString() {
        return "Vegetarian Meal: " + mealName + ", Calories: " + calories;
    }
}

class VeganMeal implements MealPlan {
    private String mealName;
    private int calories;

    public VeganMeal(String mealName, int calories) {
        this.mealName = mealName;
        this.calories = calories;
    }

    @Override
    public String getMealName() {
        return mealName;
    }

    @Override
    public int getCalories() {
        return calories;
    }

    @Override
    public String toString() {
        return "Vegan Meal: " + mealName + ", Calories: " + calories;
    }
}

class KetoMeal implements MealPlan {
    private String mealName;
    private int calories;

    public KetoMeal(String mealName, int calories) {
        this.mealName = mealName;
        this.calories = calories;
    }

    @Override
    public String getMealName() {
        return mealName;
    }

    @Override
    public int getCalories() {
        return calories;
    }

    @Override
    public String toString() {
        return "Keto Meal: " + mealName + ", Calories: " + calories;
    }
}

class HighProteinMeal implements MealPlan {
    private String mealName;
    private int calories;

    public HighProteinMeal(String mealName, int calories) {
        this.mealName = mealName;
        this.calories = calories;
    }

    @Override
    public String getMealName() {
        return mealName;
    }

    @Override
    public int getCalories() {
        return calories;
    }

    @Override
    public String toString() {
        return "High-Protein Meal: " + mealName + ", Calories: " + calories;
    }
}

// Generic Meal Plan class
class Meal<T extends MealPlan> {
    private List<T> mealList = new ArrayList<>();

    public void addMeal(T meal) {
        mealList.add(meal);
    }

    public void removeMeal(T meal) {
        mealList.remove(meal);
    }

    public List<T> getMeals() {
        return mealList;
    }

    // Wildcard method to display any type of meal
    public static void displayMeals(List<? extends MealPlan> meals) {
        for (MealPlan meal : meals) {
            System.out.println(meal);
        }
    }
}

// Main class to test the Personalized Meal Plan Generator
public class MealPlanGenerator {
    public static void main(String[] args) {
        Meal<VegetarianMeal> vegetarianMealPlan = new Meal<>();
        Meal<VeganMeal> veganMealPlan = new Meal<>();
        Meal<KetoMeal> ketoMealPlan = new Meal<>();
        Meal<HighProteinMeal> highProteinMealPlan = new Meal<>();

        // Adding meals
        vegetarianMealPlan.addMeal(new VegetarianMeal("Paneer Butter Masala", 500));
        vegetarianMealPlan.addMeal(new VegetarianMeal("Dal Tadka", 350));

        veganMealPlan.addMeal(new VeganMeal("Chickpea Salad", 400));
        veganMealPlan.addMeal(new VeganMeal("Tofu Stir Fry", 450));

        ketoMealPlan.addMeal(new KetoMeal("Grilled Chicken", 600));
        ketoMealPlan.addMeal(new KetoMeal("Avocado Egg Bowl", 550));

        highProteinMealPlan.addMeal(new HighProteinMeal("Protein Shake", 250));
        highProteinMealPlan.addMeal(new HighProteinMeal("Grilled Salmon", 700));

        // Displaying meals
        System.out.println("Vegetarian Meals:");
        Meal.displayMeals(vegetarianMealPlan.getMeals());

        System.out.println("\nVegan Meals:");
        Meal.displayMeals(veganMealPlan.getMeals());

        System.out.println("\nKeto Meals:");
        Meal.displayMeals(ketoMealPlan.getMeals());

        System.out.println("\nHigh-Protein Meals:");
        Meal.displayMeals(highProteinMealPlan.getMeals());
    }
}