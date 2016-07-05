enum PopulatingMode {
    ODD,
    EVEN;

    public PopulatingMode flip() {
        if (this == ODD) {
            return EVEN;
        } else {
            return ODD;
        }
    }
}
