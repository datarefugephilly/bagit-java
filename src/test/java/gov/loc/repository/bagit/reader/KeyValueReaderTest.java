package gov.loc.repository.bagit.reader;

import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Assert;
import org.junit.Test;

import gov.loc.repository.bagit.exceptions.InvalidBagMetadataException;

public class KeyValueReaderTest extends Assert {

  @Test(expected=InvalidBagMetadataException.class)
  public void testReadInproperIndentedBagMetadataFileThrowsException() throws Exception{
    Path baginfo = Paths.get(getClass().getClassLoader().getResource("badBagMetadata/badIndent.txt").toURI());
    KeyValueReader.readKeyValuesFromFile(baginfo, ":", StandardCharsets.UTF_8);
  }
  
  @Test(expected=InvalidBagMetadataException.class)
  public void testReadInproperBagMetadataKeyValueSeparatorThrowsException() throws Exception{
    Path baginfo = Paths.get(getClass().getClassLoader().getResource("badBagMetadata/badKeyValueSeparator.txt").toURI());
    KeyValueReader.readKeyValuesFromFile(baginfo, ":", StandardCharsets.UTF_8);
  }
}
