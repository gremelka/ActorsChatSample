package com.limprove.actorschatsample.domain.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Actor implements Serializable {
    @SerializedName("id")
    public int id;

    @SerializedName("createdBy")
    public int created;

    @SerializedName("text")
    public String speech;

    @SerializedName("tagList")
    public List<String> tags;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Actor actor = (Actor) o;
        return id == actor.id &&
                created == actor.created &&
                speech.equals(actor.speech) &&
                Objects.equals(tags, actor.tags);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, created, speech, tags);
    }
}
