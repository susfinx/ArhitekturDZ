package DZ2.Builder;

public class Buter {
        private String bread;
        private String filling;
        private String sauce;

        public void setBread(String bread) {
            this.bread = bread;
        }

        public void setFilling(String filling) {
            this.filling = filling;
        }

        public void setSauce(String sauce) {
            this.sauce = sauce;
        }

        public void describe() {
            System.out.println("Buter with " + bread + " bread, " + filling + " filling, and " + sauce + " sauce.");
        }
    }

    // Абстрактный класс Builder
    abstract class ButerBuilder {
        protected Buter buter;

        public Buter getButer() {
            return buter;
        }

        public void createNewButer() {
            buter = new Buter();
        }

        public abstract void buildBread();
        public abstract void buildFilling();
        public abstract void buildSauce();
    }

    // Конкретный класс Builder - для строительства "Итальянского сэндвича"
    class ItalianButerBuilder extends ButerBuilder {
        public void buildBread() {
            buter.setBread("Italian bread");
        }

        public void buildFilling() {
            buter.setFilling("Salami, Ham, and Cheese");
        }

        public void buildSauce() {
            buter.setSauce("Mustard and Mayonnaise");
        }
    }

    class TurkishButerBuilder extends ButerBuilder {
        public void buildBread() {
            buter.setBread("Turkish bread");
        }

        public void buildFilling() {
            buter.setFilling("Lamb, Tomato, and Onion");
        }

        public void buildSauce() {
            buter.setSauce("Yogurt Sauce");
        }
    }

    class ButerMaker {
        private ButerBuilder builder;

        public void setBuilder(ButerBuilder builder) {
            this.builder = builder;
        }

        public Buter getSandwich() {
            return builder.getButer();
        }

        public void constructSandwich() {
            builder.createNewButer();
            builder.buildBread();
            builder.buildFilling();
            builder.buildSauce();
        }
    }

