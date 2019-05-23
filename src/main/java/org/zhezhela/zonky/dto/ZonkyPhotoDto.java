package org.zhezhela.zonky.dto;

public class ZonkyPhotoDto {

    private String name;
    private String url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Zonky Photo{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
