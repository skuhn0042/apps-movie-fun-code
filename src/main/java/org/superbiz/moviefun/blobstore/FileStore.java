package org.superbiz.moviefun.blobstore;

import org.apache.tika.io.IOUtils;

import java.io.*;
import java.util.Optional;

public class FileStore implements BlobStore {

    @Override
    public void put(Blob blob) throws IOException {
        File file = new File(blob.name);

        file.delete();
        file.createNewFile();

        FileOutputStream outFile = new FileOutputStream(file);
        IOUtils.copy(blob.inputStream, outFile);
    }

    @Override
    public Optional<Blob> get(String name) throws IOException {
        File file = new File(name);
        FileInputStream inFile = new FileInputStream(file);
        Blob blob = new Blob(name, inFile, "");
        return Optional.of(blob);
    }

    @Override
    public void deleteAll() {

    }
}
