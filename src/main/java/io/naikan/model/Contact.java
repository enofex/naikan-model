package io.naikan.model;

public record Contact(String name, String title, String email, String phone, String description,
                      Roles roles) {

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {

    private String name;
    private String title;
    private String email;
    private String phone;
    private String description;
    private Roles roles;

    private Builder() {
    }

    public Builder name(String name) {
      this.name = name;
      return this;
    }

    public Builder title(String title) {
      this.title = title;
      return this;
    }

    public Builder email(String email) {
      this.email = email;
      return this;
    }

    public Builder phone(String phone) {
      this.phone = phone;
      return this;
    }

    public Builder description(String description) {
      this.description = description;
      return this;
    }

    public Builder roles(Roles roles) {
      this.roles = roles;
      return this;
    }

    public Contact build() {
      return new Contact(this.name, this.title, this.email, this.phone, this.description,
          this.roles);
    }
  }
}
