package lt.sventes.rest;

public class CountryRestResponse {
    private Long id;
    private String title;
    private String imageUrl;
    private String president;

    public CountryRestResponse() {
    }

    public CountryRestResponse(Long id, String title, String imageUrl, String president) {
        this.title = title;
        this.imageUrl = imageUrl;
        this.president = president;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getPresident() {
        return president;
    }

    public void setPresident(String president) {
        this.president = president;
    }
}
