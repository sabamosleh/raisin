package model;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResponseA {

    private String status;
    private String id;

    @Override
    public String toString() {
        return "{" +
                "status:'" + status + '\'' +
                ", id:'" + id + '\'' +
                '}';
    }
}
