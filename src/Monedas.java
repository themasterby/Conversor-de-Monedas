public record Monedas(String result,
                      String base_code,
                      Object conversion_rates,
                      String target_code,
                      double conversion_rate,
                      double conversion_result) {

    @Override
    public String toString() {
        return "";
    }
}


