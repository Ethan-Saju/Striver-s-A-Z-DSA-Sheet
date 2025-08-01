class KokoEatingBananas {
        public int minEatingSpeed(int[] piles, int h) {
        
        int maxBananas = 0;
        for(int pile : piles) maxBananas= Math.max(maxBananas,pile);

        int l = 1;
        int r = maxBananas;

        int res = maxBananas;

        while(l<=r){

            int k = l + (r-l) / 2;
           

            long t = 0;

            for(int pile : piles){

                t+=(pile/k);
                if (pile%k>0)
                    t+=1;

            }
           
            if (t>h)
                l = k + 1;
            else{
                res = k;
                r = k -1;
            }
        }

        return res;
    }
}
