import java.io.*;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class JsonIO {
    private String inputFile;
    private String outputFile;

    public JsonIO(String inputFile, String outputFile) {
        this.inputFile = inputFile;
        this.outputFile = outputFile;
    }

    public InputModel read() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        InputModel inputModel = mapper.readValue(new File(inputFile), InputModel.class);
        return inputModel;
    }

    public void write(OutputModel outputModel) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
        writer.writeValue(new File(outputFile), outputModel);
    }
}
