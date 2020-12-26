import java.util.*;

// Name :
// Student ID :

@SuppressWarnings("unchecked")
class BST <T extends KeyValue> {
   class TreeNode <U extends KeyValue> {
      U data;   // storage for data : in HW 3, T will be Item
      TreeNode<U> leftChild;   // link to the left Child
      TreeNode<U> rightChild;   // link to the right Child

      TreeNode() {
         leftChild = rightChild = null;
      }
      TreeNode(U d) {
         // data is given
         data = d;
         // the leftChild and rightChild field are null
         leftChild = rightChild = null;
      }
   };

   TreeNode <T> root;
   BST() { 
      // BST constructor. 
      root = null;
   }

   void Show() {
      System.out.print( "PRE  Order : ");
      PreOrder(root);
      System.out.println("");
      System.out.print("IN   Order : ");
      InOrder(root);
      System.out.println("");
      System.out.print("POST Order : ");
      PostOrder(root);
      System.out.println("");
      System.out.print("Number of Nodes : ");
      System.out.println( Count(root));
      System.out.print("HEIGHT : ");
      System.out.println( Height(root));
      System.out.println("");
   }

   boolean  Insert(T item)  {
      // first search the key
       if (Get(item) != null) return false;  
      TreeNode<T> newNode = new TreeNode<T>(item);
      if(root == null) {
         root = newNode;
         return true;
      }
      
      TreeNode<T> ptr, parent;
      ptr = root; // 10 1
      while(true) {
         parent = ptr; // 10 1
         if(item.GetKey() < parent.data.GetKey()) {
            ptr = parent.leftChild;
            if(ptr == null) {
               parent.leftChild = newNode;
               return true;
               }
            }
         else {
            ptr = parent.rightChild;
            
            if(ptr == null) {
               parent.rightChild = newNode;
               return true;
            }
         }
      }
   }
         
   T Get(T item)  {
      // use the key field of item and find the node
      // do not use val field of item
      if(root == null) {
         return null;
      }
      
      TreeNode<T> ptr;
      ptr = root;
      
      while(ptr.data.GetKey() != item.GetKey()) {
         if(item.GetKey() < ptr.data.GetKey()) {
            ptr = ptr.leftChild;
         }
         else {
            ptr = ptr.rightChild;
         }
      if(ptr == null) {
         return null;
      }
      }
      return ptr.data;
   } 


   boolean Delete(T item)  {
      TreeNode<T> parent, ptr;
       ptr = root;
       parent = root;

       boolean isLeftChild = true;

      while(ptr.data.GetKey() != item.GetKey()) {
           parent = ptr; 
           if(item.GetKey() < ptr.data.GetKey()) {
               isLeftChild = true;             
               ptr = parent.leftChild;
           } else {
               isLeftChild = false;            
               ptr = parent.rightChild;
           }

           if(ptr == null) {
               return false;
           }
       }

       TreeNode<T> replacementNode;
       if(ptr.leftChild == null && ptr.rightChild == null) {
           if (ptr == root)
               root = null;
           else if (isLeftChild)
               parent.leftChild = null;
           else
               parent.rightChild = null;
       }
       else if(ptr.rightChild == null) {
           replacementNode = ptr.leftChild;

           if (ptr == root)
               root = replacementNode;
           else if (isLeftChild)
               parent.leftChild = replacementNode;
           else
               parent.rightChild = replacementNode;
       }
       else if (ptr.leftChild == null) {
           replacementNode = ptr.rightChild;
           if (ptr == root)
               root = replacementNode;
           else if (isLeftChild)
               parent.leftChild = replacementNode;
           else
               parent.rightChild = replacementNode;
       }
       else {
         TreeNode<T> rightSubTree = ptr.rightChild;

           replacementNode = findMaximum(ptr.leftChild); 
           Delete(replacementNode.data);
           TreeNode<T> leftSubTree = ptr.leftChild;
           
           if (ptr == root) {
               root = replacementNode;}
           else if (isLeftChild) {
               parent.leftChild = replacementNode;}
           else {
               parent.rightChild = replacementNode;}

           replacementNode.rightChild = rightSubTree;
           
           if (replacementNode == rightSubTree) {
               replacementNode.leftChild = null;
       }
           replacementNode.leftChild = leftSubTree;
       }
       return true;
   }

   
   BST<T>.TreeNode<T> findMaximum(TreeNode<T> t){
       if(t.rightChild != null){
         return findMaximum(t.rightChild);
       }
       return t;
     }


   
   void  PreOrder(TreeNode<T> t)  {
      if(t != null) {
          System.out.print("["+t.data.GetKey() + "(" + t.data.GetValue()+")"+"]");
          PreOrder(t.leftChild);
          PreOrder(t.rightChild);
        }

   }

   void  InOrder(TreeNode<T> t)  {
         if (t != null){
               InOrder(t.leftChild);   
              System.out.print("["+t.data.GetKey() + "(" + t.data.GetValue()+")"+"]");
               InOrder(t.rightChild);

            }
         }


   void  PostOrder(TreeNode<T> t)  {
         if (t != null){
               PostOrder(t.leftChild);   
               PostOrder(t.rightChild);
               System.out.print("["+t.data.GetKey() + "(" + t.data.GetValue()+")"+"]");
            }

         }
   
   
   int  Count(TreeNode<T> t)  {
      if(t == null) {
         return 0;
      }
      else {
         return 1 + Count(t.leftChild) + Count(t.rightChild);
      }
      }

   int  Height(TreeNode<T> t)  {
      if(t == null) return 0;
        else {
            return Math.max(Height(t.leftChild), Height(t.rightChild))+1;
        }
}
}
