/*
* @Author: aaronlai
* @Date:   2017-07-04 15:35:03
* @Last Modified by:   aaronlai
* @Last Modified time: 2017-07-04 15:36:12
*/

public interface DisjointSets {

    void connect(int p, int q);

    boolean isConnected(int p, int q);
}