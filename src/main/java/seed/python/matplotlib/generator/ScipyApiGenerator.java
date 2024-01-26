package seed.python.matplotlib.generator;

public class ScipyApiGenerator extends PythonApiGenerator {

    protected ScipyApiGenerator() {
        super("Scipy", "optimize");
    }

    @Override
    protected void defaultImports() {
        fromImports("scipy", "optimize");
    }

    public static void main(String[] args) {
        new ScipyApiGenerator().run();
    }

    @Override
    protected String documentationStyle() {
        return "numpydoc";
    }
}
