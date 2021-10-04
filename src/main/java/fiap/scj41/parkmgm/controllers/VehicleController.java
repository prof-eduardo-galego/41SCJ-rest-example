package fiap.scj41.parkmgm.controllers;

import fiap.scj41.parkmgm.exceptions.RecursoNaoEncontradoException;
import fiap.scj41.parkmgm.models.Vehicle;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

  private static final List<Vehicle> REPOSITORIO = new ArrayList<>();

  static {
    REPOSITORIO.add(new Vehicle(1, "Fusca"));
    REPOSITORIO.add(new Vehicle(2, "BMW"));
  }

  // [R]eatrive all
  @GetMapping(produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
  public List<Vehicle> listAll() {
    // Recupera a lista de veículos do Repositório
    return REPOSITORIO;
  }

  // [C]reate
  @PostMapping
  public ResponseEntity<Vehicle> create(@RequestBody Vehicle vehicle) {
    if (vehicle == null || vehicle.getId() == null) {
      return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
    }

    // Armazena o veículo dentro do Repositório
    REPOSITORIO.add(vehicle);
    return ResponseEntity
            .created(URI.create("/vehicle/" + vehicle.getId()))
            .body(vehicle);
  }

  // [R]eatrive one by id
  @GetMapping("/{id}")
  @Operation(summary = "Listar por ID", description = "Busca um veículo a partir de um identificador")
  public Vehicle findById(@PathVariable("id") @Parameter(description = "Identificador do veículo") Integer vehicleId) throws RecursoNaoEncontradoException {
    Vehicle found = REPOSITORIO.stream().filter(v -> v.getId().equals(vehicleId)).findFirst().orElse(null);
    if (found == null) {
      throw new RecursoNaoEncontradoException();
    }

    return found;
  }

  // [U]pdate

  // [D]elete


}
