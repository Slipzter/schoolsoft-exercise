package api;

import util.NumberHandler;
import util.StringHandler;
import util.UserJsonHandler;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("methods")
public class MethodsAPI {

    private static final UserJsonHandler JSON_HANDLER = new UserJsonHandler();
    private static final StringHandler STRING_HANDLER = new StringHandler();
    private static final NumberHandler NUMBER_HANDLER = new NumberHandler();

    @GET
    @Path("users")
    public static Response users() {
        return Response.ok(
                JSON_HANDLER.getUsers()
        ).build();
    }

    @GET
    @Path("userswithreversednames")
    public static Response usersWithReversedNames() {
        return Response.ok(
                JSON_HANDLER.getUsersWithRevName()
        ).build();
    }

    @POST
    @Path("reversestring")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public static Response reverseString(@FormParam("string") String string) {
        return Response.ok(
                STRING_HANDLER.reverseString(string)
        ).build();
    }

    @POST
    @Path("ispalindrome")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public static Response isPalindrome(@FormParam("string") String string) {
        return Response.ok(
                STRING_HANDLER.isStringPalindrome(string)
        ).build();
    }

    @POST
    @Path("padnumberwithzeroes")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public static Response padNumberWithZeroes(@FormParam("number") int number) {
        return Response.ok(
                NUMBER_HANDLER.addZeros(number)
        ).build();
    }

    @POST
    @Path("findnthlargestnumber")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public static Response findNthLargestNumber(@FormParam("numbers") String string,
                                                @FormParam("nthlargestnumber") int nthLargestNumber) {
        return Response.ok(
                NUMBER_HANDLER.nthLargestNumber(STRING_HANDLER.stringToIntList(string), nthLargestNumber)
        ).build();
    }

}
