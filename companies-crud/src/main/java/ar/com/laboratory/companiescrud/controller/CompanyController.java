package ar.com.laboratory.companiescrud.controller;

import ar.com.laboratory.companiescrud.models.dtos.CompanyDTO;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import java.rmi.NoSuchObjectException;
import java.util.List;

@Tag(name="Company controller", description = "This is a controller to manage companies", externalDocs = @ExternalDocumentation(description = "Find more info about Companies", url = "https://example.com/companies-crud/"))
public interface CompanyController {


    @Operation(summary = "Obtain detailed information about a specific company by name")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Company not found")
    })
    public ResponseEntity<CompanyDTO>get(@Parameter(description = "Company's identifier", example = "Facebook",required = true)String name) throws NoSuchObjectException;

    @Operation(summary = "Provide a list of all companies")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ok",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = CompanyDTO.class)))
            )
    })
    public ResponseEntity<List<CompanyDTO>> getAll() throws NoSuchObjectException;

    @Operation(summary = "Register a new company to make it available to manage")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Created"),
            @ApiResponse(responseCode = "400", description = "Bad Request")
    })
    public ResponseEntity<CompanyDTO> post(
            @RequestBody(description = "Company object that needs to be registered",
                         required = true,
                         content = @Content(
                         mediaType = "application/json",
                         schema = @Schema(implementation = CompanyDTO.class))) CompanyDTO company);


    @Operation(summary = "Replace whole company's information or create a new one if not found")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "201", description = "Created"),
            @ApiResponse(responseCode = "400", description = "Bad Request")
    })
    public ResponseEntity<CompanyDTO> put(@RequestBody(description = "Company object that needs to be registered",
            required = true,
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = CompanyDTO.class)))CompanyDTO company,
                                         @Parameter(description = "Company's identifier", example = "Facebook",required = true) String name) throws NoSuchObjectException;

    @Operation(summary = "Disable a specific company")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Company not found")
    })
    public ResponseEntity<?> delete(@Parameter(description = "Company's identifier", example = "Facebook",required = true)String name) throws NoSuchObjectException;
}
