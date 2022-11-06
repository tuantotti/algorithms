package com.algorithm.trees;

import java.util.Arrays;
import java.util.List;

import static com.algorithm.trees.Hashing.compute;

public class Main {

    public static void main(String[] args) {
        System.out.println("--------------------------------------------------------------");
        List<String> dataList = Arrays.asList("0", "1", "2", "3", "4", "5", "6");
        // setup in server
        MerkleTree merkleTree = new MerkleTree(dataList);

        // client request
        String address = "2";
        List<MerkleNodeDto> merklePath = merkleTree.getMerklePath(address);

        // client check
        String hash = compute(address);
        boolean check = verify(hash, merklePath);

        if (check) {
            System.out.println("The address " + address + " is valid");
        }
        System.out.println("--------------------------------------------------------------");
    }

    private static boolean verify(String hash, List<MerkleNodeDto> merklePath) {
        String parentHash = null;
        int size = merklePath.size();
        for (int i = 0; i < size - 1; i++) {
            MerkleNodeDto dto = merklePath.get(i);
            if (dto.getLeft()) {
                parentHash = compute(dto.getHash() + hash);
            } else {
                parentHash = compute(hash + dto.getHash());
            }

            hash = parentHash;
        }

        MerkleNodeDto root = merklePath.get(size - 1);
        return parentHash.equals(root.getHash());
    }
}
