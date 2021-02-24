## Why Nested class ##

---

## Why call private method by public method ##

---

## Remove method ##

> When we remove a node, it is more suitable to regard the process as restruction of the tree than as deletion of single node

There exists four situations when removing a node:

- No such node: keep the tree unchanged, and return the former tree

- Node as a leaf: easy to handle

- Node with single child:![Single child](https://img-blog.csdnimg.cn/20201020210824347.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3poaXpoZW5nZ3Vhbg==,size_16,color_FFFFFF,t_70#pic_center)

    if the node is the left child of its parent, then change its parent's left child to its child.

- Node with two childs:![img](https://img-blog.csdnimg.cn/20201020211026630.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3poaXpoZW5nZ3Vhbg==,size_16,color_FFFFFF,t_70#pic_center)
    1. Find the succesor node, which is next node in the link after inorder traversal, or rather, the min value in its right child tree.
    2. Assign the value of succesor node to the node
    3. Remove succeor node. As the succesor node is the min value of the right child BST, there won't be left child node of it, so we can remove it easily.

---

