public class ModNCounter extends Counter {
    int modulus;
    public ModNCounter (int modulus) {
        super();
        this.modulus = modulus;
    }

    public int value() {
        return super.value()%modulus;
    }

}