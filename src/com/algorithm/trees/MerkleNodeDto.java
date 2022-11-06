package com.algorithm.trees;

public class MerkleNodeDto {
    private String address;
    private String hash;
    private Boolean isLeft;

    public MerkleNodeDto(String address, String hash, Boolean isLeft) {
        this.address = address;
        this.hash = hash;
        this.isLeft = isLeft;
    }

    public String getHash() {
        return hash;
    }

    public Boolean getLeft() {
        return isLeft;
    }

    public void setLeft(Boolean left) {
        isLeft = left;
    }
}
