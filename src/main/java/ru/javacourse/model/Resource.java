package ru.javacourse.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Arrays;

@Entity
@Table(name = "resource")
public class Resource
{
    @Id
    @Column(name = "resource_id")
    private Integer resourceId;

    @Column(name = "technology")
    private String technology;

    @Column(name = "tag")
    private String tag;

    @Column(name = "title")
    private String title;


    @Column(name = "description")
    private String description;

    @Column(name = "link")
    private String link;


    @Column(name = "file")
    private byte[] file;

    @Column(name = "resource_type")
    private String resourceType;

    @Column(name = "rating")
    private Integer rating;

    public Integer getResourceId()
    {
        return resourceId;
    }

    public void setResourceId(Integer resourceId)
    {
        this.resourceId = resourceId;
    }

    public String getTechnology()
    {
        return technology;
    }

    public void setTechnology(String technology)
    {
        this.technology = technology;
    }

    public String getTag()
    {
        return tag;
    }

    public void setTag(String tag)
    {
        this.tag = tag;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getLink()
    {
        return link;
    }

    public void setLink(String link)
    {
        this.link = link;
    }

    public byte[] getFile()
    {
        return file;
    }

    public void setFile(byte[] file)
    {
        this.file = file;
    }

    public String getResourceType()
    {
        return resourceType;
    }

    public void setResourceType(String resourceType)
    {
        this.resourceType = resourceType;
    }

    public Integer getRating()
    {
        return rating;
    }

    public void setRating(Integer rating)
    {
        this.rating = rating;
    }

    @Override
    public String toString()
    {
        return "Resource{" +
                "resourceId=" + resourceId +
                ", technology='" + technology + '\'' +
                ", tag='" + tag + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", link='" + link + '\'' +
                ", file=" + Arrays.toString(file) +
                ", resourceType='" + resourceType + '\'' +
                ", rating=" + rating +
                '}';
    }

}
