package com.algorithm.trees;

import java.util.ArrayList;
import java.util.List;

import static com.algorithm.trees.Hashing.compute;

public class MerkleTree {
    private MerkleNode root;
    private List<MerkleNode> leaves;

    public MerkleTree(List<String> dataList) {
        leaves = new ArrayList<>();

        for (String data : dataList) {
            String hash = compute(data);
            MerkleNode leaf = new MerkleNode(data, hash);
            leaves.add(leaf);
        }
        root = buildMerkleTree(leaves);
    }

    private MerkleNode buildMerkleTree(List<MerkleNode> leaf) {
        int numLeaf = leaf.size();

        if (numLeaf == 1) return leaf.get(0);

        List<MerkleNode> parents = new ArrayList<>();
        int i = 0;
        while (i < numLeaf) {
            MerkleNode leftChild = leaf.get(i);
            MerkleNode rightChild = i + 1 < numLeaf ? leaf.get(i + 1) : leftChild;

            String hash = compute(leftChild.getHash() + rightChild.getHash());
            MerkleNode parent = new MerkleNode(leftChild.getAddress() + rightChild.getAddress(), hash, leftChild, rightChild);
            leftChild.setParent(parent);
            rightChild.setParent(parent);

            parents.add(parent);
            i += 2;

        }
        return buildMerkleTree(parents);
    }

    public List<MerkleNodeDto> getMerklePath(String address) {
        String hash = compute(address);

        for (MerkleNode leaf : leaves) {
            if (leaf.getHash().equals(hash)) {
                return generateMerklePath(leaf, new ArrayList<>());
            }
        }

        return null;
    }

    private List<MerkleNodeDto> generateMerklePath(MerkleNode node, List<MerkleNodeDto> path) {
        if (node.equals(root)) {
            MerkleNodeDto merkleNodeDto = new MerkleNodeDto(node.getAddress(), node.getHash(), null);
            path.add(merkleNodeDto);
            return path;
        }

        MerkleNode parent = node.getParent();
        boolean isLeft = parent.getLeftChild().equals(node);

        MerkleNodeDto merkleNodeDto;
        if (isLeft) {
            MerkleNode rightChild = parent.getRightChild();
            merkleNodeDto = new MerkleNodeDto(rightChild.getAddress(), rightChild.getHash(), false);
        } else {
            MerkleNode leftChild = parent.getLeftChild();
            merkleNodeDto = new MerkleNodeDto(leftChild.getAddress(), leftChild.getHash(), true);
        }
        path.add(merkleNodeDto);

        return generateMerklePath(node.getParent(), path);
    }
}
