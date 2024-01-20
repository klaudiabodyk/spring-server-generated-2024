/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.52).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import io.swagger.model.Note;
import io.swagger.model.NoteInput;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.CookieValue;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2024-01-20T16:02:16.787911447Z[GMT]")
@Validated
public interface NotesApi {

    @Operation(summary = "Create a new note", description = "", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "201", description = "The created note", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Note.class))) })
    @RequestMapping(value = "/notes",
        produces = { "application/json" }, 
        consumes = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<Note> createNote(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody NoteInput body
);


    @Operation(summary = "Delete a note by ID", description = "", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "204", description = "Note deleted"),
        
        @ApiResponse(responseCode = "404", description = "Note not found") })
    @RequestMapping(value = "/notes/{noteId}",
        method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteNote(@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema()) @PathVariable("noteId") Integer noteId
);


    @Operation(summary = "Retrieve a specific note by ID", description = "", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "The requested note", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Note.class))),
        
        @ApiResponse(responseCode = "404", description = "Note not found") })
    @RequestMapping(value = "/notes/{noteId}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Note> getNote(@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema()) @PathVariable("noteId") Integer noteId
);


    @Operation(summary = "Retrieve a list of notes", description = "", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "A list of notes", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Note.class)))) })
    @RequestMapping(value = "/notes",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<Note>> listNotes();


    @Operation(summary = "Update an existing note", description = "", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "The updated note", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Note.class))),
        
        @ApiResponse(responseCode = "404", description = "Note not found") })
    @RequestMapping(value = "/notes/{noteId}",
        produces = { "application/json" }, 
        consumes = { "application/json" }, 
        method = RequestMethod.PATCH)
    ResponseEntity<Note> updateNote(@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema()) @PathVariable("noteId") Integer noteId
, @Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody NoteInput body
);

}
