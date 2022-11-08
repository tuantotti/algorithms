package com.algorithm.trees.merkle;

public class MerkleNode {
    private String address;
    private String hash;
    private MerkleNode parent;
    private MerkleNode leftChild;
    private MerkleNode rightChild;

    public MerkleNode(String address, String hash) {
        this.address = address;
        this.hash = hash;
    }

    public MerkleNode(String address, String hash, MerkleNode leftChild, MerkleNode rightChild) {
        this.address = address;
        this.hash = hash;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public MerkleNode getParent() {
        return parent;
    }

    public void setParent(MerkleNode parent) {
        this.parent = parent;
    }

    public MerkleNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(MerkleNode leftChild) {
        this.leftChild = leftChild;
    }

    public MerkleNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(MerkleNode rightChild) {
        this.rightChild = rightChild;
    }
}
