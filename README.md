# 算法练习

之前学习算法也是断断续续的，没有系统的学习，在我看来，算法其实就是数据结构 + 数学推理，有的时候带着一些技巧，也就是模版，所以想要学习好算法，
要先了解必要的数据结构，最起码数组、链表、栈、队列、堆、树、图等数据结构先了解一下，很多的算法就是基于数据结构展开的，不同的数据结构在同一个
场景下，性能也可能是千差万别的，这次酒统一过一遍的，大学学的数据结构都有点遗忘了都。

## 数据结构

### 数组

数组是一种线性表数据结构，它用一组连续的内存空间，来存储一组具有相同类型的数据。数组的下标是从 0 开始的，所以数组的第一个元素的下标是
0，最后一个元素的下标是 n-1，n 表示数组的长度。

数组的优点是可以随机访问，根据下标随机访问的时间复杂度是 O(1)，但是数组的缺点也很明显，那就是插入和删除的时间复杂度是 O(n)
，因为数组是连续的内存空间，所以在插入和删除的时候，需要移动后面的元素，所以时间复杂度是 O(n)。

### 链表

链表是一种线性表数据结构，它用一组任意的内存空间，来存储一组具有相同类型的数据。链表的每个元素都是一个节点，节点分为两部分，一部分是存储数据的，另一部分是指向下一个节点的指针。

链表的优点是插入和删除的时间复杂度是 O(1)，因为链表的节点是任意的内存空间，所以在插入和删除的时候，只需要改变指针的指向就可以了，但是链表的缺点也很明显，那就是随机访问的时间复杂度是
O(n)，因为链表的节点是任意的内存空间，所以不能像数组一样，根据下标随机访问，只能从头节点开始遍历，直到找到对应的节点。

上面说的是单向链表，还有双链链表，双链表的每个节点都有两个指针，一个指向前一个节点，一个指向后一个节点。

循环链表是一种特殊的单链表，它的尾节点指向头节点，形成一个环。

双向循环链表是双向链表和循环链表的结合。

还有更多，当然，总体来说链表的特性是不发生改变的，也就是插入删除快，随机访问慢。

### 栈

栈是一种特殊的线性表数据结构，它只能在一端进行插入和删除操作，这一端称为栈顶，另一端称为栈底。栈的特点是先进后出(FILO)。

栈的应用场景有函数调用栈、表达式求值、括号匹配、浏览器前进后退等。

### 队列

队列是一种特殊的线性表数据结构，它只能在一端进行插入操作，另一端进行出对操作，插入端称为队头，出对端称为队尾。队列的特点是先进先出(
FIFO)。

队列的应用场景有消息队列、阻塞队列、并发队列等。

### 堆

堆是一种特殊的完全二叉树(除了最后一层，其他层的节点数都是满的，最后一层节点从左到右依次填满)
，它分为大顶堆和小顶堆，大顶堆的每个节点的值都大于等于其左右子节点的值，小顶堆的每个节点的值都小于等于其左右子节点的值。

PriorityQueue 是 Java 中的堆的实现。

堆的应用场景有优先级队列、Top K 问题、求中位数等。

> 使用对来实现求中位数的描述
> 使用两个堆来维护数据集合的左侧部分和右侧部分。左侧部分使用一个大根堆来维护，右侧部分使用一个小根堆来维护。假设现在已经有了一个大根堆
> leftMaxHeap 和一个小根堆 rightMinHeap，它们分别维护了数据集合的左侧部分和右侧部分。此时需要将一个新元素 num
> 加入到数据集合中，具体步骤如下：
> 1. 将 num 插入到 leftMaxHeap 中。
> 2. 如果 leftMaxHeap 的元素个数大于 rightMinHeap 的元素个数，将 leftMaxHeap 的堆顶元素弹出，并插入到 rightMinHeap 中。
> 3. 如果 rightMinHeap 的堆顶元素小于 leftMaxHeap 的堆顶元素，交换两个堆顶元素。
>
> 重复上述步骤，直到数据集合中的所有元素都被加入到堆中。这样，左侧部分的元素个数始终不小于右侧部分的元素个数，而且左侧部分的最大值不大于右侧部分的
最小值。当数据集合元素个数为偶数时，中位数为左侧部分的最大值和右侧部分的最小值的平均值；当数据集合元素个数为奇数时，中位数为左侧部分的最大值。

### 树

树是一种非线性表数据结构，它是由 n(n>=1) 个有限节点组成一个具有层次关系的集合。树的第一个节点称为根节点，除了根节点之外的其他节点都有且只有一个父节点，每个节点可以有多个子节点。

树的应用场景有文件系统、二叉搜索树、堆、图等。

#### 二叉树

二叉树是一种特殊的树，它的每个节点最多有两个子节点，分别称为左子节点和右子节点。

二叉树的应用场景有二叉搜索树、堆、表达式树等。

#### 二叉搜索树

二叉搜索树是一种特殊的二叉树，它的每个节点的值都大于其左子树的所有节点的值，小于其右子树的所有节点的值。

二叉搜索树的应用场景有快速查找、快速插入、快速删除等。