package seed.python.matplotlib.generator;

public class MatplotlibApiGenerator2 extends PythonApiGenerator {

    protected MatplotlibApiGenerator2() {
        super("Matplotlib", "plt");
    }

    @Override
    protected void defaultImports() {
        fromImportsAs("matplotlib", "pyplot", "plt");
    }

    public static void main(String[] args) {
        new MatplotlibApiGenerator2().run();
    }

    @Override
    protected String documentationStyle() {
        return "numpydoc";
    }
}
