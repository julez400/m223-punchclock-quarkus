package ch.zli.m223.punchclock.controller;

import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import ch.zli.m223.punchclock.domain.Entry;
import ch.zli.m223.punchclock.service.EntryService;

@Path("/entries")
@Tag(name = "Entries", description = "Handling of entries")
public class EntryController {

    @Inject
    EntryService entryService;
    /**
     * Looks for all Entrys
     * @return a list with all Entrys
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "List all Entries", description = "")
    public List<Entry> list() {
        return entryService.findAll();
    }

    /**
     * Adds a new Entrey
     * @param entry gets the Entry wich it should create
     * @return the created Entry
     */
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Add a new Entry", description = "The newly created entry is returned. The id may not be passed.")
    public Entry add(Entry entry) {
       return entryService.createEntry(entry);
    }

    /**
     * Delets a Entry
     * @param id is the id of the Entry wich should be deleted
     */
    @DELETE
    @Operation(summary = "Remove a existing Entry", description = "Haha funny deleted")
    @Path("/{id}")
    public void remove(@PathParam("id") long id) {
        entryService.remove(id);
    }


    /**
     * Updates a Entry
     * @param entry is the new Entry wich schould replace the old one
     * @return the updated Entry
     */
    @PUT
    @Operation(summary = "Updates a existing Entry", description = "Haha new funny")
    public Entry update(Entry entry) {
        return entryService.update(entry);
    }
    

}
