import java.util.*;

public class Q355 {
    // design twitter

    HashMap<Integer, User> users;

    // sub classes to use
    private static int timeStamp = 0;

    private static class Twit{
        int twitID;
        int time;
        Twit next;

        private Twit(int id){
            this.twitID = id;
            this.time = timeStamp;
            timeStamp++;
            this.next = null;
        }
    }

    private static class User{
        int usrID;
        HashSet<Integer> following;
        Twit head;

        private User(int id){
            this.usrID = id;
            this.following = new HashSet<>();
            this.head = null;
            follow(id);
        }

        private void follow(int id){
            this.following.add(id);
        }

        private void unfollow(int id){
            if (this.following.contains(id)){
                this.following.remove(id);
            }
        }

        private void post(int twitId){
            Twit latest = new Twit(twitId);
            latest.next = head;
            head = latest;
        }
    }


    public Q355() {
        this.users = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        if (!users.containsKey(userId)){
            User newUser = new User(userId);
            users.put(userId, newUser);
        }
        users.get(userId).post(tweetId);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> ans = new ArrayList<>();

        if (!users.containsKey(userId)){
            return ans;
        }

        PriorityQueue<Twit> maxheap = new PriorityQueue<>((a,b)-> b.time - a.time);

        for (int followeeId : users.get(userId).following){
            if (users.get(followeeId).head != null){
                maxheap.add(users.get(followeeId).head);
            }
        }

        while (!maxheap.isEmpty() && ans.size() < 10){
            Twit latest = maxheap.poll();
            ans.add(latest.twitID);
            
            if (latest.next != null){
                maxheap.add(latest.next);
            }
        }

        return ans;
    }
    
    public void follow(int followerId, int followeeId) {
        if (!users.containsKey(followerId)){
            User follower = new User(followerId);
            users.put(followerId, follower);
        }
        if (!users.containsKey(followeeId)){
            User followee = new User(followeeId);
            users.put(followeeId, followee);
        }
        users.get(followerId).follow(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (users.containsKey(followerId)){
            users.get(followerId).unfollow(followeeId);
        }
    }
}
