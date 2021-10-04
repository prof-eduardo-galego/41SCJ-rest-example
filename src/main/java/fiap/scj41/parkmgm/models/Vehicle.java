package fiap.scj41.parkmgm.models;

import io.swagger.v3.oas.annotations.media.Schema;

public class Vehicle {

  @Schema(description = "Identificador do veículo", nullable = false, required = true)
  private Integer id;

  @Schema(description = "Modelo do veículo")
  private String model;

  public Vehicle() {
  }

  public Vehicle(Integer id, String model) {
    this.id = id;
    this.model = model;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }
}
