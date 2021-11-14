package adapters;

public interface KeyAdapter {

    static String convertKey(String[] inputs) {
        return  convertStrToKey(inputs);
    }

    private static String convertStrToKey(String[] inputs){
        return inputs[4];
    }
}
