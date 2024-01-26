module seed.python {
    exports seed.python.core;

    opens seed.python.core to org.junit.platform.commons; // ugh...

    requires java.logging;
    requires org.junit.jupiter.api;
    requires org.graalvm.sdk;
}