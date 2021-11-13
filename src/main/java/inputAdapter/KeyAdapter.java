package inputAdapter;

public interface KeyAdapter {

    static String convertKey(String[] inputs) {
        return  convertStrtoKey(inputs);
    }

    private static String convertStrtoKey(String[] inputs){
        return inputs[4];
    }
}
