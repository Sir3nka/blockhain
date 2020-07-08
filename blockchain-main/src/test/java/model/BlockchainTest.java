package model;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

@DisplayName("Blockchain test suite")
class BlockchainTest {
    private Blockchain blockchain;
    private final static String FILE_NAME = "Test_suite.ser";

    //fixme : does not clear serialized instances before each test
    @BeforeEach
    void getInstance() {
        Blockchain.setFILE_NAME(FILE_NAME);
        File serialized = new File(FILE_NAME);
        if (serialized.exists()) {
            serialized.delete();
        }
        blockchain = Blockchain.getInstance();
    }

    @Test
    @DisplayName("Adding same block")
    void twoSameBlocks() throws IOException {
        blockchain.addBlock(BlockBuilder.buildNext(null).build());
        blockchain.addBlock(BlockBuilder.buildNext(null).build());
        assert(blockchain.getBlockchain().size() == 1);
    }
}
