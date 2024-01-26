package seed.python.matplotlib.generator;

public class NumpyApiGenerator extends PythonApiGenerator {

    protected NumpyApiGenerator() {
        super("Numpy", "np");
    }

    @Override
    protected void defaultImports() {
        importsAs("numpy", "np");
    }

    public static void main(String[] args) {
        new NumpyApiGenerator().run();
    }

    @Override
    protected String documentationStyle() {
        return "numpydoc";
    }
}
