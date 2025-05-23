class Solution {
    public long minEnd(int n, int x) {
        long result = 0, bit;
        --n;

        int[] binaryX = new int[64];
        int[] binaryN = new int[64];

        long longX = x; 
        long longN = n; 

        // Step 2: Build binary representations of x and n-1
        for (int i = 0; i < 64; ++i) {
            bit = (longX >> i) & 1; // Extract i-th bit of x
            binaryX[i] = (int) bit;

            bit = (longN >> i) & 1; // Extract i-th bit of n-1
            binaryN[i] = (int) bit;
        }

        int posX = 0, posN = 0;

        // Step 3: Combine binary representation of x and n-1
        while (posX < 64) {
            // Traverse binaryX until we find a 0 bit
            while (binaryX[posX] != 0 && posX < 64) {
                ++posX;
            }
            // Copy bits from binaryN (n-1) into binaryX (x) starting from the first 0
            binaryX[posX] = binaryN[posN];
            ++posX;
            ++posN;
        }

        // Step 4: Rebuild the final result from the combined binary representation
        for (int i = 0; i < 64; ++i) {
            if (binaryX[i] == 1) {
                // convert binary bit to decimal value
                result += Math.pow(2, i);
            }
        }

        return result;
    }
}