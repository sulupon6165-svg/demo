package com.example.demo.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import java.time.LocalDate;
import jakarta.persistence.*;

@Entity
@Table(name = "personal_info")
public class PersonalInfo {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "名前を入力してください")
    private String name;

    @NotNull(message = "生年月日を入力してください")
    private LocalDate birthDate;

    @NotBlank(message = "マイナンバーを入力してください")
    @Pattern(regexp = "\\d{12}", message = "マイナンバーは12桁の数字です")
    private String myNumber;

    // getter / setter
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public LocalDate getBirthDate() { return birthDate; }
    public void setBirthDate(LocalDate birthDate) { this.birthDate = birthDate; }

    public String getMyNumber() { return myNumber; }
    public void setMyNumber(String myNumber) { this.myNumber = myNumber; }
}