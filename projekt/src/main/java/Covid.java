public class Covid {
    private String name;
    private int total_cases;
    private int active_cases;
    private int recovered;
    private int deaths;
    private int tested;

    public Covid(String name, int total_cases, int active_cases, int recovered, int deaths, int tested) {
        this.name = name;
        this.total_cases = total_cases;
        this.active_cases = active_cases;
        this.recovered = recovered;
        this.deaths = deaths;
        this.tested=tested;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotal_cases() {
        return total_cases;
    }

    public void setTotal_cases(int total_cases) {
        this.total_cases = total_cases;
    }

    public int getActive_cases() {
        return active_cases;
    }

    public void setActive_cases(int active_cases) {
        this.active_cases = active_cases;
    }

    public int getRecovered() {
        return recovered;
    }

    public void setRecovered(int recovered) {
        this.recovered = recovered;
    }

    public int getDeaths() {
        return deaths;
    }

    public int getTested() {
        return tested;
    }

    public void setTested(int tested) {
        this.tested = tested;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    @Override
    public String toString() {
        return "{" +
                "\"name\" : \"" + name + '\"' +
                ", \"total_cases\" : " + total_cases +
                ", \"active_cases\" : " + active_cases +
                ", \"recovered\" : " + recovered +
                ", \"deaths\" : " + deaths +
                ", \"tested\" : " + tested +
                '}';
    }
}
